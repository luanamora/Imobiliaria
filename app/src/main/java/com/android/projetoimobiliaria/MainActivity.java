package com.android.projetoimobiliaria;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.projetoimobiliaria.adapter.ImovelAdapter;
import com.android.projetoimobiliaria.model.Corretor;
import com.android.projetoimobiliaria.model.Endereco;
import com.android.projetoimobiliaria.model.Imovel;
import com.android.projetoimobiliaria.model.Locatario;
import com.android.projetoimobiliaria.util.Mensagem;
import com.android.projetoimobiliaria.util.TipoMensagem;
import com.orm.SugarContext;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImovelAdapter imovelAdapter;
    private ListView lvImovel;
    private Button btAtualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        SugarContext.init(this);
        loadComponents();
        loadList();


    }

    private void loadComponents(){
        lvImovel = findViewById(R.id.lvImovel);
        btAtualizar = findViewById(R.id.btAtualizar);

        List<Locatario> l = Locatario.listAll(Locatario.class);
        if(l.size() == 0){
            Locatario locatario = new Locatario(1,"Ninguém",0);
            locatario.save();
        }



        btAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadList();
                Mensagem.ExibirMensagem(MainActivity.this,"Lista Atualizada!",TipoMensagem.SUCESSO);
            }
        });
    }

    private void loadList(){
        List<Imovel> imovels = Imovel.listAll(Imovel.class, "codigo desc");
        imovelAdapter = new ImovelAdapter(MainActivity.this, imovels);
        lvImovel.setAdapter(imovelAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_imovel) {
            Intent intent = new Intent(MainActivity.this, ImovelActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_corretor) {
            Intent intent = new Intent(MainActivity.this, CorretorActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_locatario) {
            Intent intent = new Intent(MainActivity.this, LocatarioActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_tools) {
            Intent intent = new Intent(MainActivity.this, EnderecoActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_remove) {
            final AlertDialog.Builder alertConfirmacao = new AlertDialog.Builder(MainActivity.this);
            alertConfirmacao.setTitle("Confirmação de Exclusão");
            alertConfirmacao.setMessage("Deseja realmente excluir TODOS os registros do SUGARSQL?");
            alertConfirmacao.setIcon(R.drawable.ic_alert);
            alertConfirmacao.setNeutralButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    List<Corretor> corretorList = Corretor.listAll(Corretor.class);
                    List<Endereco> enderecoList = Endereco.listAll(Endereco.class);
                    List<Imovel> imovelList = Imovel.listAll(Imovel.class);
                    List<Locatario> locatarioList = Locatario.listAll(Locatario.class);

                    corretorList.removeAll(corretorList);
                    enderecoList.removeAll(enderecoList);
                    imovelList.removeAll(imovelList);
                    locatarioList.removeAll(locatarioList);
                    Mensagem.ExibirMensagem(MainActivity.this, "Banco de dados limpo com sucesso!", TipoMensagem.SUCESSO);
                }
            });
            alertConfirmacao.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertConfirmacao.show();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
