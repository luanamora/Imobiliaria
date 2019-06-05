package com.android.projetoimobiliaria.util;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.projetoimobiliaria.R;
import com.android.projetoimobiliaria.model.Imovel;

public class ViewDialog {
    public void showDialod(Activity activity, Imovel imovel){
        final Dialog dialog = new Dialog(activity);
        //dialog.requestWindowFeature(R.layout.itemdialog); //criar layout
        dialog.setCancelable(true);

        ((TextView) dialog.findViewById(R.id.tvCorretor)).setText(String.valueOf(imovel.getCorretor().getNome()));
        ((TextView) dialog.findViewById(R.id.tvTelefone)).setText(String.valueOf(imovel.getCorretor().getTelefone()));

        Button dialogButton = (Button) dialog.findViewById(R.id.btCancelar);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
        Window window = dialog.getWindow();
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }
}
