package com.videoteca.androidtv.utils;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.videoteca.androidtv.R;
import com.videoteca.androidtv.interfaces.DialogCallback;

public class Dialogs {

    private static Activity act;

    public Dialogs(Activity _act){
        act = _act;
    }

    public static AlertDialog setDialogInfo(int title, int message, DialogCallback callback){

        AlertDialog.Builder builder = new AlertDialog.Builder(act);

        LayoutInflater inflater = act.getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_standard, null);

        TextView btnNeutral = view.findViewById(R.id.btnNeutral);
        TextView txtTitle   = view.findViewById(R.id.txtTitle);
        TextView txtMessage = view.findViewById(R.id.txtMessage);

        txtTitle.setText(title);
        txtMessage.setText(message);

        btnNeutral.setOnClickListener(view1 -> {
            callback.onClick();
        });

        builder.setView(view);
        return builder.create();
    }

    public static AlertDialog loading(){

        AlertDialog.Builder builder = new AlertDialog.Builder(act);

        LayoutInflater inflater = act.getLayoutInflater();

        View view = inflater.inflate(R.layout.node_loading, null);

        TextView txtTitle = view.findViewById(R.id.txtTitle);

        txtTitle.setText(R.string.txt_loading);

        builder.setView(view);
        return builder.create();
    }

    public static void show(AlertDialog dialog){
        dialog.show();
        setTransparence(dialog);
    }

    public static void hide(AlertDialog dialog){
        dialog.dismiss();
    }

    public static void setTransparence(AlertDialog dialog){
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }


}
