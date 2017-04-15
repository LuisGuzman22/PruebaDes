package com.example.luisguzman.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.luisguzman.myapplication.R;
import com.example.luisguzman.myapplication.databasee.SchemaHelper;
import com.example.luisguzman.myapplication.databasee.datasource.Respuestas_datasource;
import com.example.luisguzman.myapplication.model.PreguntasModel;
import com.example.luisguzman.myapplication.model.RespuestasModel;

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
        public RadioButton radioButton;

        public PreguntasModel_ViewHolder(View itemView) {
            super(itemView);
            rgp= (RadioGroup) itemView.findViewById(R.id.radiogroup);
            radioButton = new RadioButton(itemView.getContext());


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
        RespuestasModel m_respuestas;

        viewHolder.TV_Preguntas.setText(datos.get(pos).getmIdPregunta() + " - " + datos.get(pos).getmPregunta());
/*
        RadioButton radioButton = new RadioButton(context);
        radioButton.setText(datos.get(pos).getmRespuesta());
        rprms= new RadioGroup.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        viewHolder.rgp.addView(radioButton, rprms);*/

        Cursor c = s_respuesta.obtenerRespuestas(db, datos.get(pos).getmIdPregunta());
        rprms = new RadioGroup.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);

        if (c.moveToFirst()){
            do {

                if (datos.get(pos).getmTipoPregunta() == 1) {
                    viewHolder.radioButton = new RadioButton(context);
                    viewHolder.radioButton.setText(c.getString(c.getColumnIndex("respuesta")));
                    viewHolder.radioButton.setId(c.getInt(c.getColumnIndex("id_respuesta")));

                    viewHolder.rgp.addView(viewHolder.radioButton, rprms);
                } else if (datos.get(pos).getmTipoPregunta() == 2){
                    CheckBox checkBox = new CheckBox(context);
                    checkBox.setText(c.getString(c.getColumnIndex("respuesta")));
                    checkBox.setId(c.getInt(c.getColumnIndex("id_respuesta")));
                    viewHolder.rgp.addView(checkBox, rprms);

                }


            } while (c.moveToNext());
        }


        if (viewHolder.radioButton.isChecked()){
            Log.d("ADAPTADOR", "TRue" + datos.get(pos).getmIdPregunta());
            m_respuestas = new RespuestasModel(c.getInt(c.getColumnIndex("id_respuesta")), datos.get(pos).getmIdPregunta());
        } else {
            Log.d("ADAPTADOR", "false" + datos.get(pos).getmIdPregunta());
        }


    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


}
