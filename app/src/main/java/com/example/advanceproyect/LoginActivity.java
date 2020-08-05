package com.example.advanceproyect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
private EditText etEmail,etClave;
private TextView tvCartel;
private Button btLogin;
private LoguinViewModel lvm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniciarVista();
        lvm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoguinViewModel.class);
        lvm.getCartel().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvCartel.setText(s);
            }
        });
    }
    public void iniciarVista(){
        etEmail=findViewById(R.id.etEmailLogin);
        etClave=findViewById(R.id.etClaveLogin);
        tvCartel=findViewById(R.id.tvcartelLogin);
        etEmail.setText("");
        etClave.setText("");
        btLogin=findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvCartel.setText("");
                validar(v);
            }
        });
    }
    public void validar(View view){
        String mail=etEmail.getText().toString();
        String clave=etClave.getText().toString();
        lvm.validardatos(mail, clave);
    }
}
