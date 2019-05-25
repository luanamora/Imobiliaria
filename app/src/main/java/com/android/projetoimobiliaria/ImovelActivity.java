package com.android.projetoimobiliaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ImovelActivity extends AppCompatActivity {

    private TextView tvLabelImovel;
    private EditText etCodigo, etDescricao, etTamanho;
    private Spinner spCorretor, spLocatario;
    private Button btEndereco, btSalvar, btCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imovel);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loadComponents();
        loadEvents();
    }

    private void loadComponents(){
        etCodigo = findViewById(R.id.etCodigo);
        etDescricao = findViewById(R.id.etDescricao);
        etTamanho = findViewById(R.id.etTamanho);
        spCorretor = findViewById(R.id.spCorretor);
        spLocatario = findViewById(R.id.spLocatario);
        btEndereco = findViewById(R.id.btEndereco);
        btSalvar = findViewById(R.id.btSalvar);
        btCancelar = findViewById(R.id.btCancelar);
    }

    private void loadEvents(){
        btEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImovelActivity.this, EnderecoActivity.class);
                startActivity(intent);
            }
        });
    }

}
