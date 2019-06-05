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
    public void showDialog(Activity activity, Imovel imovel){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //criar layout
        dialog.setContentView(R.layout.item_dialog);
        dialog.setCancelable(true);

        ((TextView) dialog.findViewById(R.id.tvCo)).setText((imovel.getCorretor().getNome()));
        ((TextView) dialog.findViewById(R.id.tvTe)).setText((imovel.getCorretor().getTelefone()));

        //Button dialogButton = (Button) dialog.findViewById(R.id.btCancelar);
       /* dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
*/
        dialog.show();
        Window window = dialog.getWindow();
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }
}
