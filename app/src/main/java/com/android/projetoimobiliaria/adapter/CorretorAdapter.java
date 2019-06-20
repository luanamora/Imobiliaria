package com.android.projetoimobiliaria.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.projetoimobiliaria.R;
import com.android.projetoimobiliaria.model.Corretor;

import java.util.List;

public class CorretorAdapter extends BaseAdapter {
    LayoutInflater myInflater;
    List<Corretor> corretorList;

    public CorretorAdapter(Context context, List<Corretor> corretorList) {
        this.corretorList = corretorList;
        myInflater = LayoutInflater.from(context); //Responsavel por inflar o layout
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Corretor corretor = corretorList.get(position);
        view = myInflater.inflate(R.layout.support_simple_spinner_dropdown_item, null);
        ((TextView) view.findViewById(R.id.etCodigo)).setText(String.valueOf(corretor.getCodigo()));
        ((TextView) view.findViewById(R.id.etNome)).setText(String.valueOf(corretor.getNome()));
        ((TextView) view.findViewById(R.id.etTelefone)).setText(String.valueOf(corretor.getTelefone()));
        ((TextView) view.findViewById(R.id.etCreci)).setText(String.valueOf(corretor.getCreci()));

        return view;
    }

}
