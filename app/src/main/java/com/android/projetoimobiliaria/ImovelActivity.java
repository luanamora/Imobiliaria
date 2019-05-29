package com.android.projetoimobiliaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.projetoimobiliaria.adapter.ImovelAdapter;
import com.android.projetoimobiliaria.model.Corretor;
import com.android.projetoimobiliaria.model.Imovel;
import com.android.projetoimobiliaria.model.Locatario;

import java.util.ArrayList;
import java.util.List;

public class ImovelActivity extends AppCompatActivity {

    private TextView tvLabelImovel;
    private EditText etCodigo, etDescricao, etTamanho, etVAluguel;
    private Spinner spCorretor, spLocatario;
    private Button btEndereco, btSalvar, btCancelar;
    private ArrayAdapter<Imovel> imovelAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imovel);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loadComponents();
        loadEvents();
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
    }

    private void loadEvents() {
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                save();

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

    private void save() {
        Imovel imovel = new Imovel();
        imovel.setCodigo(Integer.parseInt(etCodigo.getText().toString()));
        imovel.setDescricao(etDescricao.getText().toString());
        imovel.setTamanho(Double.parseDouble(etTamanho.getText().toString()));
        imovel.setCorretor((Corretor) spCorretor.getSelectedItem());  //Provavel que essa linhda não funcionará, revisar mais tarde
        imovel.setLocatario((Locatario) spLocatario.getSelectedItem()); //Provavel que essa linhda não funcionará, revisar mais tarde
        imovel.setValorAluguel(Double.parseDouble(etVAluguel.getText().toString()));
        imovel.save();
        System.out.println(Imovel.class);
    }

    private void loadList(){
        List<Imovel> imovelList = Imovel.listAll(Imovel.class, "codigo desc");
        imovelAdapter = new ArrayAdapter<>(ImovelActivity.this, R.layout.support_simple_spinner_dropdown_item, imovelList);

    }


}
