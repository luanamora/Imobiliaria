package com.android.projetoimobiliaria.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
