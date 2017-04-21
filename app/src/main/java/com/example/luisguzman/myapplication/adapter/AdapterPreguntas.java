package com.example.luisguzman.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.IdRes;
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
import android.widget.Toast;

import com.example.luisguzman.myapplication.Main2Activity;
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
    private ArrayList<RespuestasModel> respuestas = new ArrayList<RespuestasModel>();
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

        viewHolder.TV_Preguntas.setText(datos.get(pos).getmIdPregunta() + " - " + datos.get(pos).getmPregunta());
/*
        RadioButton radioButton = new RadioButton(context);
        radioButton.setText(datos.get(pos).getmRespuesta());
        rprms= new RadioGroup.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        viewHolder.rgp.addView(radioButton, rprms);*/

        Cursor c = s_respuesta.obtenerRespuestas(db, datos.get(pos).getmIdPregunta());
        rprms = new RadioGroup.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        CheckBox checkBox = new CheckBox(context);
        if (c.moveToFirst()) {
            do {

                if (datos.get(pos).getmTipoPregunta() == 1) {
                    viewHolder.radioButton = new RadioButton(context);
                    viewHolder.radioButton.setText(c.getString(c.getColumnIndex("respuesta")));
                    viewHolder.radioButton.setId(c.getInt(c.getColumnIndex("id_respuesta")));
                    viewHolder.rgp.addView(viewHolder.radioButton, rprms);
                } else if (datos.get(pos).getmTipoPregunta() == 2) {
                    checkBox.setText(c.getString(c.getColumnIndex("respuesta")));
                    checkBox.setId(c.getInt(c.getColumnIndex("id_respuesta")));
                   // viewHolder.rgp.addView(checkBox, rprms);

                }

                /*if (checkBox.isChecked()){
                    respuestas.add(new RespuestasModel(datos.get(pos).getmIdRespuesta(), datos.get(pos).getmIdPregunta()));
                } else if (!checkBox.isChecked()){
                    respuestas.remove(new RespuestasModel(datos.get(pos).getmIdRespuesta(), datos.get(pos).getmIdPregunta()));
                }*/

            } while (c.moveToNext());
        }


        viewHolder.rgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                //Toast.makeText(context, "" + pregunta + " - " + respuesta, Toast.LENGTH_SHORT).show();
                ((Main2Activity) context).guardarRespuestas(datos.get(pos).getmIdPregunta(), viewHolder.rgp.getCheckedRadioButtonId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


}
