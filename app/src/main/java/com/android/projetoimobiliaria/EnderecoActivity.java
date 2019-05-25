package com.android.projetoimobiliaria;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnderecoActivity extends AppCompatActivity {

    private EditText etCidade, etEstado, etRua, etNumero, etCEP;
    private Button btSalvar, btCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadComponents();

    }

    private void loadComponents(){
        etCidade = findViewById(R.id.etCidade);
        etEstado = findViewById(R.id.etEstado);
        etRua = findViewById(R.id.etRua);
        etNumero = findViewById(R.id.etNumero);
        etCEP = findViewById(R.id.etCEP);
    }

}
