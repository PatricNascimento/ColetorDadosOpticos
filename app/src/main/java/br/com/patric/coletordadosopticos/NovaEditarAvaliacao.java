package br.com.patric.coletordadosopticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NovaEditarAvaliacao extends AppCompatActivity {
    private EditText txtNomePaciente, txtCpfPaciente, txtNomeEmpresa, txtLongeOdEsferico,
            txtLongeOdCilindrico, txtLongeOdEixo, txtLongeOeEsferico, txtLongeOeCilindrico,
            txtLongeOeEixo, txtPertoOdEsferico, txtPertoOdCilindrico, txtPertoOdEixo,
            txtPertoOeEsferico, txtPertoOeCilindrico, txtPertoOeEixo;
    private Button btnSalvar;
    private Button btnCancelar;

    private FirebaseAuth auth;
    private DatabaseReference reference;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_editar_avaliacao);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference();

        txtNomePaciente = findViewById(R.id.txtNomePaciente);
        txtCpfPaciente = findViewById(R.id.txtCpfPaciente);
        txtNomeEmpresa = findViewById(R.id.txtNomeEmpresa);
        txtLongeOdEsferico = findViewById(R.id.txtLongeOdEsferico);
        txtLongeOdCilindrico = findViewById(R.id.txtLongeOdCilindrico);
        txtLongeOdEixo = findViewById(R.id.txtLongeOdEixo);
        txtLongeOeEsferico = findViewById(R.id.txtLongeOeEsferico);
        txtLongeOeCilindrico = findViewById(R.id.txtLongeOeCilindrico);
        txtLongeOeEixo = findViewById(R.id.txtLongeOeEixo);
        txtPertoOdEsferico = findViewById(R.id.txtPertoOdEsferico);
        txtPertoOdCilindrico = findViewById(R.id.txtPertoOdCilindrico);
        txtPertoOdEixo = findViewById(R.id.txtPertoOdEixo);
        txtPertoOeEsferico = findViewById(R.id.txtPertoOeEsferico);
        txtPertoOeCilindrico = findViewById(R.id.txtPertoOeCilindrico);
        txtPertoOeEixo = findViewById(R.id.txtPertoOeEixo);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        btnCancelar= findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListagemAvaliacoes.class);
                startActivity(intent);
            }
        });

    }
    public void salvar(){
        try {
            if (txtNomePaciente.getText().toString() == "" || txtNomeEmpresa.getText().toString() == "" || txtCpfPaciente.getText().toString() == ""
                    || txtPertoOdEsferico.getText().toString() == "" || txtPertoOdCilindrico.getText().toString() == ""
                    || txtPertoOdEixo.getText().toString() == "" || txtPertoOeEsferico.getText().toString() == "" || txtPertoOeCilindrico.getText().toString() == ""
                    || txtPertoOeEixo.getText().toString() == "" || txtLongeOdEsferico.getText().toString() == "" || txtLongeOdCilindrico.getText().toString() == ""
                    || txtLongeOdEixo.getText().toString() == "" || txtLongeOeEsferico.getText().toString() == "" || txtLongeOeCilindrico.getText().toString() == ""
                    || txtLongeOeEixo.getText().toString() == "") {
                Toast.makeText(this, "Você deve preencher todos os campos", Toast.LENGTH_LONG).show();
            }

            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setNomePacimente(txtNomePaciente.getText().toString());
            avaliacao.setNomeEmpresa(txtNomeEmpresa.getText().toString());
            avaliacao.setCpfPaciente(txtCpfPaciente.getText().toString());

            LeituraAvalicao leituraPerto = new LeituraAvalicao(Double.parseDouble(txtPertoOdEsferico.getText().toString()), Double.parseDouble(txtPertoOdCilindrico.getText().toString()),
                    Double.parseDouble(txtPertoOdEixo.getText().toString()), Double.parseDouble(txtPertoOeEsferico.getText().toString()), Double.parseDouble(txtPertoOeCilindrico.getText().toString()),
                    Double.parseDouble(txtPertoOeEixo.getText().toString()));

            LeituraAvalicao leituraLonge = new LeituraAvalicao(Double.parseDouble(txtLongeOdEsferico.getText().toString()), Double.parseDouble(txtLongeOdCilindrico.getText().toString()),
                    Double.parseDouble(txtLongeOdEixo.getText().toString()), Double.parseDouble(txtLongeOeEsferico.getText().toString()), Double.parseDouble(txtLongeOeCilindrico.getText().toString()),
                    Double.parseDouble(txtLongeOeEixo.getText().toString()));

            avaliacao.setLeituraPerto(leituraPerto);
            avaliacao.setLeituraLonge(leituraLonge);

            reference.child("avalicoes").push().setValue(avaliacao);
        }
        catch (Exception exception){
            Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}