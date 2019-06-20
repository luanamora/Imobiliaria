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
import com.android.projetoimobiliaria.model.Imovel;
import com.android.projetoimobiliaria.util.Mensagem;
import com.android.projetoimobiliaria.util.TipoMensagem;

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
        loadEvents();

    }

    private void loadEvents() {
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etCidade.getText().length() > 0 && etEstado.getText().toString().length() > 0 && etRua.getText().toString().length() > 0 && etNumero.getText().toString().length() > 0 && etCEP.getText().toString().length() > 0) {
                    Endereco endereco = new Endereco();
                    Endereco last = Endereco.last(Endereco.class);
                    if (last == null) {
                        endereco.setCodigo(1);
                    } else {
                        endereco.setCodigo(last.getCodigo() + 1);
                    }
                    endereco.setCep(etCEP.getText().toString());
                    endereco.setCidade(etCidade.getText().toString());
                    endereco.setEstado(etEstado.getText().toString());
                    endereco.setRua(etRua.getText().toString());
                    endereco.setNumero(Integer.parseInt(etNumero.getText().toString()));
                    endereco.save();
                    Mensagem.ExibirMensagem(EnderecoActivity.this, "Endereço salvo com Sucesso!", TipoMensagem.SUCESSO);
                    limpaCampos();

                    last = Endereco.last(Endereco.class);
                    if (last == null) {
                        ImovelActivity.tvEndereco.setText("Não existem locais cadastrados");
                    } else {
                        ImovelActivity.tvEndereco.setText(last.toStringAdapter());
                    }
                    finish();
                } else {
                    Mensagem.ExibirMensagem(EnderecoActivity.this, "Preencha todos os campos!", TipoMensagem.ERRO);
                }
            }
        });
    }

    private void limpaCampos() {
        etCidade.setText("");
        etEstado.setText("");
        etRua.setText("");
        etCEP.setText("");
        etNumero.setText("");
    }

    private void loadComponents() {
        etCidade = findViewById(R.id.etCidade);
        etEstado = findViewById(R.id.etEstado);
        etRua = findViewById(R.id.etRua);
        etNumero = findViewById(R.id.etNumero);
        etCEP = findViewById(R.id.etCEP);
        btSalvar = findViewById(R.id.btSalvar);
        btCancelar = findViewById(R.id.btCancelar);
    }

}
