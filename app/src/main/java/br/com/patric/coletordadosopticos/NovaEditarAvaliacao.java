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

    private String acao;
    private Avaliacao avaliacao;


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
        acao = getIntent().getStringExtra("acao");
        if( acao.equals("editar")){
            carregarAvaliacao();
        }

    }
    private void carregarAvaliacao(){

        String idAvaliacao = getIntent().getStringExtra("id");

        avaliacao = new Avaliacao();
        avaliacao.setId(idAvaliacao);
        avaliacao.setNomePaciente(getIntent().getStringExtra("nomePaciente"));
        avaliacao.setNomeEmpresa(getIntent().getStringExtra("nomeEmpresa"));
        avaliacao.setCpfPaciente(getIntent().getStringExtra("cpfPaciente"));

        avaliacao.setLeituraPertoOdCilindrico(getIntent().getDoubleExtra("leituraPertoOdCilindrico",0.0));
        avaliacao.setLeituraPertoOdEsferico(getIntent().getDoubleExtra("leituraPertoOdEsferico", 0.0));
        avaliacao.setLeituraPertoOdEixo(getIntent().getDoubleExtra("leituraPertoOdEixo", 0.0));
        avaliacao.setLeituraPertoOeCilindrico(getIntent().getDoubleExtra("leituraPertoOeCilindrico", 0.0));
        avaliacao.setLeituraPertoOeEsferico(getIntent().getDoubleExtra("leituraPertoOeEsferico", 0.0));
        avaliacao.setLeituraPertoOeEixo(getIntent().getDoubleExtra("leituraPertoOeEixo", 0.0));

        avaliacao.setLeituraLongeOdEsferico(getIntent().getDoubleExtra("leituraLongeOdEsferico", 0.0));
        avaliacao.setLeituraLongeOdCilindrico(getIntent().getDoubleExtra("leituraLongeOdCilindrico", 0.0));
        avaliacao.setLeituraLongeOdEixo(getIntent().getDoubleExtra("leituraLongeOdEixo", 0.0));
        avaliacao.setLeituraLongeOeEsferico(getIntent().getDoubleExtra("leituraLongeOeEsferico", 0.0));
        avaliacao.setLeituraLongeOeCilindrico(getIntent().getDoubleExtra("leituraLongeOeCilindrico", 0.0));
        avaliacao.setLeituraLongeOeEixo(getIntent().getDoubleExtra("leituraLongeOeEixo", 0.0));



        txtNomePaciente.setText(avaliacao.getNomePaciente());
        txtNomeEmpresa.setText(avaliacao.getNomeEmpresa());
        txtCpfPaciente.setText(avaliacao.getCpfPaciente());
        try{
        txtPertoOdEsferico.setText(avaliacao.getLeituraPertoOdEsferico().toString());
        txtPertoOdCilindrico.setText(avaliacao.getLeituraPertoOdCilindrico().toString());
        txtPertoOdEixo.setText(avaliacao.getLeituraPertoOdEixo().toString());
        txtPertoOeEsferico.setText(avaliacao.getLeituraPertoOeEsferico().toString());
        txtPertoOeCilindrico.setText(avaliacao.getLeituraPertoOeCilindrico().toString());
        txtPertoOeEixo.setText(avaliacao.getLeituraPertoOeEixo().toString());

        txtLongeOdEsferico.setText(avaliacao.getLeituraLongeOdEsferico().toString());
        txtLongeOdCilindrico.setText(avaliacao.getLeituraLongeOdCilindrico().toString());
        txtLongeOdEixo.setText(avaliacao.getLeituraLongeOdEixo().toString());
        txtLongeOeEsferico.setText(avaliacao.getLeituraLongeOeEsferico().toString());
        txtLongeOeCilindrico.setText(avaliacao.getLeituraLongeOeCilindrico().toString());
        txtLongeOeEixo.setText(avaliacao.getLeituraLongeOeEixo().toString());
        }catch (Exception exception){
            Toast.makeText(this, exception.getStackTrace().toString(), Toast.LENGTH_LONG).show();
        }

    }

    public void salvar(){
        String nome = txtNomePaciente.getText().toString();
        String empresa = txtNomeEmpresa.getText().toString();
        String cpf = txtCpfPaciente.getText().toString();

        Double pertoOdEsferico = (Double.parseDouble(txtPertoOdEsferico.getText().toString()));
        Double pertoOdCilindrico = (Double.parseDouble(txtPertoOdCilindrico.getText().toString()));
        Double pertoOdEixo = (Double.parseDouble(txtPertoOdEixo.getText().toString()));
        Double pertoOeEsferico = (Double.parseDouble(txtPertoOeEsferico.getText().toString()));
        Double pertoOeCilindrico = (Double.parseDouble(txtPertoOeCilindrico.getText().toString()));
        Double pertoOeEixo = (Double.parseDouble(txtPertoOeEixo.getText().toString()));

        Double longeOdEsferico = (Double.parseDouble(txtLongeOdEsferico.getText().toString()));
        Double longeOdCilindrico = (Double.parseDouble(txtLongeOdCilindrico.getText().toString()));
        Double longeOdEixo = (Double.parseDouble(txtLongeOdEixo.getText().toString()));
        Double longeOeEsferico = (Double.parseDouble(txtLongeOeEsferico.getText().toString()));
        Double longeOeCilindrico = (Double.parseDouble(txtLongeOeCilindrico.getText().toString()));
        Double longeOeEixo = (Double.parseDouble(txtLongeOeEixo.getText().toString()));

        try {
            if (txtNomePaciente.getText().toString() == "" || txtNomeEmpresa.getText().toString() == "" || txtCpfPaciente.getText().toString() == ""
                    || txtPertoOdEsferico.getText().toString() == "" || txtPertoOdCilindrico.getText().toString() == ""
                    || txtPertoOdEixo.getText().toString() == "" || txtPertoOeEsferico.getText().toString() == "" || txtPertoOeCilindrico.getText().toString() == ""
                    || txtPertoOeEixo.getText().toString() == "" || txtLongeOdEsferico.getText().toString() == "" || txtLongeOdCilindrico.getText().toString() == ""
                    || txtLongeOdEixo.getText().toString() == "" || txtLongeOeEsferico.getText().toString() == "" || txtLongeOeCilindrico.getText().toString() == ""
                    || txtLongeOeEixo.getText().toString() == "") {
                Toast.makeText(this, "Você deve preencher todos os campos", Toast.LENGTH_LONG).show();
            }
            else{
                if (acao.equals("inserir")){
                    avaliacao = new Avaliacao();
                }
                avaliacao.setNomePaciente(nome);
                avaliacao.setNomeEmpresa(empresa);
                avaliacao.setCpfPaciente(cpf);

                avaliacao.setLeituraLongeOeEixo(longeOeEixo);
                avaliacao.setLeituraLongeOeCilindrico(longeOeCilindrico);
                avaliacao.setLeituraLongeOeEsferico(longeOeEsferico);
                avaliacao.setLeituraLongeOdEixo(longeOdEixo);
                avaliacao.setLeituraLongeOdCilindrico(longeOdCilindrico);
                avaliacao.setLeituraLongeOdEsferico(longeOdEsferico);

                avaliacao.setLeituraPertoOeEsferico(pertoOeEsferico);
                avaliacao.setLeituraPertoOeEixo(pertoOeEixo);
                avaliacao.setLeituraPertoOeCilindrico(pertoOeCilindrico);
                avaliacao.setLeituraPertoOdEsferico(pertoOdEsferico);
                avaliacao.setLeituraPertoOdEixo(pertoOdEixo);
                avaliacao.setLeituraPertoOdCilindrico(pertoOdCilindrico);

                if (acao.equals("inserir")){
                    reference.child("avalicoes").push().setValue(avaliacao);
                }
                else{

                    String idAvaliacao = avaliacao.getId();
                    avaliacao.setId( null );


                    reference.child("produtos").child( idAvaliacao ).setValue( avaliacao );

                    finish();
                }

            }

            /*Avaliacao avaliacao = new Avaliacao();
            avaliacao.setNomePaciente(txtNomePaciente.getText().toString());
            avaliacao.setNomeEmpresa(txtNomeEmpresa.getText().toString());
            avaliacao.setCpfPaciente(txtCpfPaciente.getText().toString());

            avaliacao.setLeituraPertoOdCilindrico(Double.parseDouble(txtPertoOdCilindrico.getText().toString()));
            avaliacao.setLeituraPertoOdEixo(Double.parseDouble(txtPertoOdEixo.getText().toString()));
            avaliacao.setLeituraPertoOdEsferico(Double.parseDouble(txtPertoOdEsferico.getText().toString()));
            avaliacao.setLeituraPertoOeCilindrico(Double.parseDouble(txtPertoOeCilindrico.getText().toString()));
            avaliacao.setLeituraPertoOeEixo(Double.parseDouble(txtPertoOeEixo.getText().toString()));
            avaliacao.setLeituraPertoOeEsferico(Double.parseDouble(txtPertoOeEsferico.getText().toString()));

            avaliacao.setLeituraLongeOdCilindrico(Double.parseDouble(txtLongeOdCilindrico.getText().toString()));
            avaliacao.setLeituraLongeOdEixo(Double.parseDouble(txtLongeOdEixo.getText().toString()));
            avaliacao.setLeituraLongeOdEsferico(Double.parseDouble(txtLongeOdEsferico.getText().toString()));
            avaliacao.setLeituraLongeOeCilindrico(Double.parseDouble(txtLongeOeCilindrico.getText().toString()));
            avaliacao.setLeituraLongeOeEixo(Double.parseDouble(txtLongeOeEixo.getText().toString()));
            avaliacao.setLeituraLongeOeEsferico(Double.parseDouble(txtLongeOeEsferico.getText().toString()));


            reference.child("avalicoes").push().setValue(avaliacao);*/
        }
        catch (Exception exception){
            Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}