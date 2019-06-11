package com.android.projetoimobiliaria.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.projetoimobiliaria.ImovelActivity;
import com.android.projetoimobiliaria.R;
import com.android.projetoimobiliaria.model.Imovel;

public class ViewDialog {
    public void showDialog(final Activity activity, Imovel imovel){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //criar layout
        dialog.setContentView(R.layout.item_dialog);
        dialog.setCancelable(true);

        //Corretor
        ((TextView) dialog.findViewById(R.id.tvCorretorNome1)).setText((imovel.getCorretor().getNome()));
        ((TextView) dialog.findViewById(R.id.tvCorretorTelefone1)).setText((imovel.getCorretor().getTelefone()));
        ((TextView) dialog.findViewById(R.id.tvCorretorCreci1)).setText(String.valueOf(imovel.getCorretor().getCreci()));

        //Endereço
        ((TextView) dialog.findViewById(R.id.tvEnderecoCEP1)).setText((imovel.getEndereco().getCep()));
        ((TextView) dialog.findViewById(R.id.tvEnderecoEstado1)).setText((imovel.getEndereco().getEstado()));
        ((TextView) dialog.findViewById(R.id.tvEnderecoMunicipio1)).setText((imovel.getEndereco().getCidade()));
        ((TextView) dialog.findViewById(R.id.tvEnderecoRua1)).setText((imovel.getEndereco().getCidade()));
        ((TextView) dialog.findViewById(R.id.tvEnderecoNumero1)).setText(String.valueOf(imovel.getEndereco().getNumero()));

        //Locatario
        ((TextView) dialog.findViewById(R.id.tvLocatarioNome1)).setText((imovel.getLocatario().getNome()));
        ((TextView) dialog.findViewById(R.id.tvLocatarioTelefone1)).setText(String.valueOf(imovel.getLocatario().getTelefone()));

        //Imovel
        ((TextView) dialog.findViewById(R.id.tvImovelDesc1)).setText((imovel.getDescricao()));
        ((TextView) dialog.findViewById(R.id.tvImovelTam1)).setText((imovel.getTamanho() + "m²"));
        ((TextView) dialog.findViewById(R.id.tvImovelAluguel1)).setText(("R$" + imovel.getValorAluguel()));
        if(imovel.getAlugada() == 0){
            ((TextView) dialog.findViewById(R.id.tvImovelAlugada1)).setText(("DISPONIVEL"));
        }else {
            ((TextView) dialog.findViewById(R.id.tvImovelAlugada1)).setText(("ALUGADA"));
        }

        Button dialogButton = (Button) dialog.findViewById(R.id.btOk);
        Button dialogButtonEdit = (Button) dialog.findViewById(R.id.btEditar);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialogButtonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( activity, ImovelActivity.class);
                intent.putExtra("EDICAO", 1);
                activity.startActivity(intent);
                //startActivity(intent);
            }
        });
        dialog.show();
        Window window = dialog.getWindow();
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }
}