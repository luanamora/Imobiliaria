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

import com.android.projetoimobiliaria.model.Corretor;
import com.android.projetoimobiliaria.model.Endereco;
import com.android.projetoimobiliaria.util.Mensagem;
import com.android.projetoimobiliaria.util.TipoMensagem;

import java.util.List;

public class CorretorActivity extends AppCompatActivity {

    private EditText etCodigo, etNome, etTelefone, etCreci;
    private Button btSalvar, btCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corretor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadComponents();
        limpaCampos();
        loadEvents();


    }

    private void loadEvents() {

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etCodigo.getText().length() > 0 && etNome.getText().toString().length() > 0 && etTelefone.getText().toString().length() > 0 && etCreci.getText().toString().length() > 0) {
                    Corretor corretor = new Corretor();
                    corretor.setCodigo(Integer.parseInt(etCodigo.getText().toString()));
                    corretor.setNome(etNome.getText().toString());
                    corretor.setTelefone(etTelefone.getText().toString());
                    corretor.setCreci(Integer.parseInt(etCreci.getText().toString()));
                    corretor.save();
                    Mensagem.ExibirMensagem(CorretorActivity.this, "Corretor salvo com Sucesso!", TipoMensagem.SUCESSO);
                    limpaCampos();
                } else {
                    Mensagem.ExibirMensagem(CorretorActivity.this, "Preencha todos os campos!", TipoMensagem.ERRO);
                }
            }
        });

        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    private void loadComponents() {
        etCodigo = findViewById(R.id.etCodigo);
        etNome = findViewById(R.id.etNome);
        etTelefone = findViewById(R.id.etTelefone);
        etCreci = findViewById(R.id.etCreci);
        btSalvar = findViewById(R.id.btSalvar);
        btCancelar = findViewById(R.id.btCancelar);
    }


    private void limpaCampos() {
        Corretor last = Corretor.last(Corretor.class);
        if (last == null) {
            etCodigo.setText("1");
        } else {
            etCodigo.setText(String.valueOf(last.getCodigo() + 1));
        }
        etNome.setText("");
        etTelefone.setText("");
        etCreci.setText("");
    }


}
