package com.android.projetoimobiliaria.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.projetoimobiliaria.R;
import com.android.projetoimobiliaria.model.Imovel;

import java.util.List;

public class ImovelAdapter extends BaseAdapter {
    LayoutInflater myInflater;
    List<Imovel> imovelList;

    public ImovelAdapter(Context context, List<Imovel> imovelList) {
        this.imovelList = imovelList;
        myInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imovelList.size();
    }

    @Override
    public Object getItem(int position) {
        return imovelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Imovel imovel = imovelList.get(position); //Recupero o Imovel da posição passada
        view = myInflater.inflate(R.layout.item_imovel, null);//Seto o layout escolhido na View

        view.findViewById(R.id.ivHouse);//Adiciono a Imagem
        ((TextView) view.findViewById(R.id.tvValor)).setText(String.valueOf(imovel.getValorAluguel()));

        if (imovel.isAlugada()) { //Verifico se está ou não alugada para definir o texto
            ((TextView) view.findViewById(R.id.tvStatus)).setText("Alugada");
        } else {
            ((TextView) view.findViewById(R.id.tvStatus)).setText("Disponivel");
        }
        if (imovel.getEndereco() != null) {
            ((TextView) view.findViewById(R.id.tvEndereco)).setText(String.valueOf(imovel.getEndereco().toStringAdapter()));
        }

        if (imovel.getCorretor() != null) {
            ((TextView) view.findViewById(R.id.tvCorretor)).setText(String.valueOf(imovel.getCorretor().getNome()));
            ((TextView) view.findViewById(R.id.tvTelefone)).setText(String.valueOf(imovel.getCorretor().getTelefone()));
        }
        return view;
    }
}
