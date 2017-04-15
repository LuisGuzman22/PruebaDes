package com.example.luisguzman.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.luisguzman.myapplication.R;
import com.example.luisguzman.myapplication.databasee.SchemaHelper;
import com.example.luisguzman.myapplication.databasee.datasource.Respuestas_datasource;
import com.example.luisguzman.myapplication.model.PreguntasModel;

import java.util.ArrayList;

/**
 * Created by LuisGuzman on 14-04-17.
 */

public class AdapterPreguntas extends RecyclerView.Adapter<AdapterPreguntas.PreguntasModel_ViewHolder> {
    private ArrayList<PreguntasModel> datos;
    private Context context;
    private Activity activity;

    SchemaHelper sh;
    SQLiteDatabase db;
    Respuestas_datasource s_respuesta;

    public static class PreguntasModel_ViewHolder extends RecyclerView.ViewHolder {

        public TextView TV_Preguntas;
        public RadioGroup rgp;

        public PreguntasModel_ViewHolder(View itemView) {
            super(itemView);
            rgp= (RadioGroup) itemView.findViewById(R.id.radiogroup);


            TV_Preguntas = (TextView) itemView.findViewById(R.id.TV_Preguntas);
        }

    }

    public AdapterPreguntas(Context ctx, Activity act, ArrayList<PreguntasModel> datos) {
        this.context = ctx;
        this.datos = datos;
        this.activity = act;
    }

    @Override
    public PreguntasModel_ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_preguntas, viewGroup, false);
        final PreguntasModel_ViewHolder vh = new PreguntasModel_ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final PreguntasModel_ViewHolder viewHolder, final int pos) {
        RadioGroup.LayoutParams rprms;
        sh = new SchemaHelper(context);
        db = sh.getWritableDatabase();
        s_respuesta = new Respuestas_datasource(context);


        viewHolder.TV_Preguntas.setText(datos.get(pos).getmIdPregunta() + " - " + datos.get(pos).getmPregunta());

        Cursor c = s_respuesta.obtenerRespuestas(db, datos.get(pos).getmIdPregunta());
        if (c.moveToFirst()){
            do {
                RadioButton radioButton = new RadioButton(context);
                radioButton.setText(c.getString(c.getColumnIndex("respuesta")));
                rprms= new RadioGroup.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
                viewHolder.rgp.addView(radioButton, rprms);

            } while (c.moveToNext());
        }



    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


}
