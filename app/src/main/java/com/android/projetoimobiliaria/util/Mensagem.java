package com.android.projetoimobiliaria.util;

import android.app.AlertDialog;
import android.content.Context;

import com.android.projetoimobiliaria.R;

public class Mensagem {
    public static void ExibirMensagem(Context context, String msg, TipoMensagem tipo){
        AlertDialog.Builder alert = new AlertDialog.Builder(context);

        if (tipo == TipoMensagem.ALERTA) {
            alert.setTitle("Atenção!");
            alert.setIcon(R.drawable.ic_alert);
        } else if (tipo == TipoMensagem.ERRO) {
            alert.setTitle("ERRO!");
            alert.setIcon(R.drawable.ic_error);
        } else if (tipo == TipoMensagem.SUCESSO) {
            alert.setTitle("Sucesso!");
            alert.setIcon(R.drawable.ic_check);
        }
        alert.setMessage(msg);
        alert.setNeutralButton("Ok", null);
        alert.show();
    }
}
