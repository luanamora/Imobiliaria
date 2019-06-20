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

import com.android.projetoimobiliaria.model.Locatario;
import com.android.projetoimobiliaria.util.Mensagem;
import com.android.projetoimobiliaria.util.TipoMensagem;

public class LocatarioActivity extends AppCompatActivity {

    private EditText etCodigo, etNome, etTelefone;
    private Button btSalvar, btCancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locatario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadComponents();
        loadEvents();
        limpaCampos();
    }

    private void loadComponents() {
        etCodigo = findViewById(R.id.etCodigo);
        etNome = findViewById(R.id.etNome);
        etTelefone = findViewById(R.id.etTelefone);
        btSalvar = findViewById(R.id.btSalvar);
        btCancelar = findViewById(R.id.btCancelar);
    }

    private void loadEvents() {
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etNome.getText().length() > 0 && etTelefone.getText().toString().length() > 0 && etNome.getText().toString().length() > 0) {
                    Locatario locatario = new Locatario();
                    locatario.setCodigo(Integer.parseInt(etCodigo.getText().toString()));
                    locatario.setNome(etNome.getText().toString());
                    locatario.setTelefone(Integer.parseInt(etTelefone.getText().toString()));
                    locatario.save();
                    Mensagem.ExibirMensagem(LocatarioActivity.this, "Locatario salvo com Sucesso!", TipoMensagem.SUCESSO);
                    limpaCampos();
                } else {
                    Mensagem.ExibirMensagem(LocatarioActivity.this, "Preencha todos os campos!", TipoMensagem.ERRO);
                }
            }
        });
    }

    private void limpaCampos() {
        Locatario last = Locatario.last(Locatario.class);
        if (last == null) {
            etCodigo.setText("1");
        } else {
            etCodigo.setText(String.valueOf(last.getCodigo() + 1));
        }
        etNome.setText("");
        etTelefone.setText("");
    }

}


