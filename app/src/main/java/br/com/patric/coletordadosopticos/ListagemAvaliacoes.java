package br.com.patric.coletordadosopticos;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;


public class ListagemAvaliacoes extends AppCompatActivity {

    private Button btnNovaAvaliacao;
    private Button btnSair;

    private FirebaseAuth auth;
    private DatabaseReference reference;
    private FirebaseDatabase firebaseDatabase;

    private ListView lvAvaliacoes;
    private List<Avaliacao> ListaDeAvaliacoes;
    private ArrayAdapter adapter;

    private ChildEventListener childEventListener;
    private Query query;

    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_avaliacoes);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference();

        lvAvaliacoes = findViewById(R.id.lvAvaliacao);

        ListaDeAvaliacoes = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListaDeAvaliacoes);
        lvAvaliacoes.setAdapter(adapter);

        btnNovaAvaliacao = findViewById(R.id.btnNovaAvaliacao);
        btnNovaAvaliacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NovaEditarAvaliacao.class);
                startActivity(intent);
            }
        });

        btnSair = findViewById(R.id.btnSair);
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });

        lvAvaliacoes = findViewById(R.id.lvAvaliacao);
        ListaDeAvaliacoes = new ArrayList<>();
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, ListaDeAvaliacoes);
        lvAvaliacoes.setAdapter(adapter);

        lvAvaliacoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent( ListagemAvaliacoes.this, NovaEditarAvaliacao.class);
                intent.putExtra("acao", "editar");
                Avaliacao prodSelecionado = ListaDeAvaliacoes.get(position);
                intent.putExtra("idAvaliacao", prodSelecionado.getId());
                intent.putExtra("nome", prodSelecionado.getNomePacimente());
                intent.putExtra("empresa", prodSelecionado.getNomeEmpresa());
                startActivity( intent );
            }
        });

        lvAvaliacoes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {

                excluir( position );

                return true;
            }
        });

        auth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if( auth.getCurrentUser() == null){
                    finish();
                }
            }
        };
        auth.addAuthStateListener( authStateListener );

    }

    @Override
    protected void onStart() {
        super.onStart();

        ListaDeAvaliacoes.clear();

        firebaseDatabase = FirebaseDatabase.getInstance();

        reference = firebaseDatabase.getReference();

        query = reference.child("avalicoes"); //*

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                try {
                    Avaliacao avaliacao = new Avaliacao();
                    avaliacao.setId(snapshot.getKey());
                    avaliacao.setNomePacimente(snapshot.child("nomePacimente").getValue(String.class));
                    avaliacao.setNomeEmpresa(snapshot.child("nomeEmpresa").getValue(String.class));

                    ListaDeAvaliacoes.add(avaliacao);

                    adapter.notifyDataSetChanged();

                } catch (Exception e) {

                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                for (Avaliacao avaliacao : ListaDeAvaliacoes) {

                    avaliacao.setNomePacimente(snapshot.child("nomePacimente").getValue(String.class));
                    avaliacao.setNomeEmpresa(snapshot.child("nomeEmpresa").getValue(String.class));

                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                for (Avaliacao p: ListaDeAvaliacoes){
                    if (p.getId().equals( snapshot.getKey() )){
                        ListaDeAvaliacoes.remove( p );
                        adapter.notifyDataSetChanged();
                    }
                }

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        };
        query.addChildEventListener(childEventListener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        query.removeEventListener(childEventListener);
    }

    private void excluir(int posicao) {
        Avaliacao prodSelecionado = ListaDeAvaliacoes.get(posicao);
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Excluir");
        alerta.setIcon(android.R.drawable.ic_delete);
        alerta.setMessage("Confirma a exclusão do " + prodSelecionado.getNomePacimente() + "?");

        alerta.setNeutralButton("Cancelar", null);
        alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                reference.child("avalicoes").child(prodSelecionado.getId()).removeValue();
            }
        });
        alerta.show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        carregarListaAvaliacao();
    }

    private void carregarListaAvaliacao() {

        if (ListaDeAvaliacoes.size() == 0) {
            Avaliacao fake = new Avaliacao("Lista Vazia", "", "", "");
            ListaDeAvaliacoes.add(fake);
            lvAvaliacoes.setEnabled(false);
        } else {
            lvAvaliacoes.setEnabled(true);
        }
    }

}