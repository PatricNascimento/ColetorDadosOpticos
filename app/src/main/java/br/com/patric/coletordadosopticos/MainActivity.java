package br.com.patric.coletordadosopticos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser usuario;

    private EditText etEmail, etSenha;
    private Button btnEntrar, btnCadastro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.txtEmail);
        etSenha = findViewById(R.id.txtSenha);
        btnCadastro = findViewById(R.id.btnCadastro);
        btnEntrar = findViewById(R.id.btnAcessar);

        auth = FirebaseAuth.getInstance();

        authStateListener = new FirebaseAuth.AuthStateListener()
        {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth)
            {
                usuario = auth.getCurrentUser();
                if( usuario != null)
                {
                    Intent intent = new Intent(getApplicationContext(), ListagemAvaliacoes.class);
                    startActivity(intent);
                }
            }
        };

        auth.addAuthStateListener( authStateListener );
        btnCadastro.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });
        btnEntrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                entrar();
            }
        });
    }

    private void cadastrar()
    {
        String email = etEmail.getText().toString();
        String senha = etSenha.getText().toString();

        if (email.isEmpty() || senha.isEmpty())
        {
            Toast.makeText(this,"Todos os campos são obrigatórios", Toast.LENGTH_LONG).show();
            return;
        }

        auth.createUserWithEmailAndPassword( email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(!task.isSuccessful())
                {
                    task.getException().toString();
                    Toast.makeText(MainActivity.this, "Erro ao criar o user!", Toast.LENGTH_LONG).show();
                    return;
                }
                usuario = auth.getCurrentUser();
            }
        });
    }
    private void entrar()
    {
        String email = etEmail.getText().toString();
        String senha = etSenha.getText().toString();

        if (email.isEmpty() || senha.isEmpty())
        {
            Toast.makeText(this,"Todos os campos são obrigatórios", Toast.LENGTH_LONG).show();
            return;
        }

        auth.signInWithEmailAndPassword( email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(!task.isSuccessful())
                {
                    task.getException().toString();
                    Toast.makeText(MainActivity.this, "Erro de usuário ou senha!", Toast.LENGTH_LONG).show();

                }
                usuario = auth.getCurrentUser();
            }
        });
    }
}