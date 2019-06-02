package com.android.projetoimobiliaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.projetoimobiliaria.model.Corretor;
import com.android.projetoimobiliaria.model.Endereco;
import com.android.projetoimobiliaria.model.Imovel;
import com.android.projetoimobiliaria.model.Locatario;
import com.android.projetoimobiliaria.util.Mensagem;
import com.android.projetoimobiliaria.util.TipoMensagem;

import java.util.List;

public class ImovelActivity extends AppCompatActivity {

    public static TextView tvEndereco;
    private EditText etCodigo, etDescricao, etTamanho, etVAluguel;
    private Spinner spCorretor, spLocatario;
    private Button btEndereco, btSalvar, btCancelar;
    private ArrayAdapter<Imovel> imovelAdapter;
    private ArrayAdapter<Corretor> corretorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imovel);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loadComponents();
        loadSpinnerCorretor();
        loadSpinnerLocatario();
        loadEvents();
        limpaCampos();

    }

    private void loadComponents() {
        etCodigo = findViewById(R.id.etCodigo);
        etDescricao = findViewById(R.id.etDescricao);
        etTamanho = findViewById(R.id.etTamanho);
        spCorretor = findViewById(R.id.spCorretor);
        spLocatario = findViewById(R.id.spLocatario);
        btEndereco = findViewById(R.id.btEndereco);
        btSalvar = findViewById(R.id.btSalvar);
        btCancelar = findViewById(R.id.btCancelar);
        etVAluguel = findViewById(R.id.etVAluguel);
        tvEndereco = findViewById(R.id.tvEndereco);
    }

    private void loadSpinnerCorretor() {
        List<Corretor> corretorList = Corretor.listAll(Corretor.class, "codigo desc");
        corretorAdapter = new ArrayAdapter<>(ImovelActivity.this, R.layout.support_simple_spinner_dropdown_item,
                corretorList);
        spCorretor.setAdapter(corretorAdapter);

    }

    private void loadSpinnerLocatario() {
        List<Locatario> locatarioList = Locatario.listAll(Locatario.class, "codigo desc");
        ArrayAdapter locatarioAdapter = new ArrayAdapter<>(ImovelActivity.this, R.layout.support_simple_spinner_dropdown_item,
                locatarioList);
        spLocatario.setAdapter(locatarioAdapter);

    }

    private void loadEvents() {
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etDescricao.getText().length() > 0 && etTamanho.getText().toString().length() > 0 && etVAluguel.getText().toString().length() > 0) {
                    Imovel imovel = new Imovel();
                    imovel.setCodigo(Integer.parseInt(etCodigo.getText().toString()));
                    imovel.setDescricao(etDescricao.getText().toString());
                    imovel.setTamanho(Double.parseDouble(etTamanho.getText().toString()));
                    imovel.setCorretor((Corretor) spCorretor.getSelectedItem());  //Provavel que essa linhda não funcionará, revisar mais tarde
                    imovel.setLocatario((Locatario) spLocatario.getSelectedItem()); //Provavel que essa linhda não funcionará, revisar mais tarde
                    imovel.setValorAluguel(Double.parseDouble(etVAluguel.getText().toString()));
                    imovel.setAlugada(0);
                    imovel.setEndereco(Endereco.last(Endereco.class));
                    imovel.save();
                    Mensagem.ExibirMensagem(ImovelActivity.this, "Imovel salvo com Sucesso!", TipoMensagem.SUCESSO);
                    limpaCampos();
                } else {
                    Mensagem.ExibirMensagem(ImovelActivity.this, "Preencha todos os campos!", TipoMensagem.ERRO);
                }
                limpaCampos();
            }
        });

        btEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImovelActivity.this, EnderecoActivity.class);
                startActivity(intent);
            }
        });

        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void loadList() {
        List<Imovel> imovelList = Imovel.listAll(Imovel.class, "codigo desc");
        imovelAdapter = new ArrayAdapter<>(ImovelActivity.this, R.layout.support_simple_spinner_dropdown_item, imovelList);

    }


    private void limpaCampos() {
        Imovel last = Imovel.last(Imovel.class);
        if (last != null) {
            etCodigo.setText(String.valueOf(last.getCodigo() + 1));
        } else {
            etCodigo.setText("1");
        }
        etVAluguel.setText("");
        etTamanho.setText("");
        etDescricao.setText("");
        tvEndereco.setText("Selecione o Endereço");
    }

}
