package com.example.luisguzman.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.luisguzman.myapplication.R;
import com.example.luisguzman.myapplication.databasee.SchemaHelper;
import com.example.luisguzman.myapplication.databasee.datasource.Respuestas_datasource;
import com.example.luisguzman.myapplication.model.RespuestasModel;

import java.util.ArrayList;

/**
 * Created by LuisGuzman on 15-04-17.
 */


public class AdapterRespuestas extends RecyclerView.Adapter<AdapterRespuestas.RespuestasModel_ViewHolder> {
    private ArrayList<RespuestasModel> datos;
    private Context context;
    private Activity activity;

    SchemaHelper sh;
    SQLiteDatabase db;
    Respuestas_datasource s_respuesta;

    public static class RespuestasModel_ViewHolder extends RecyclerView.ViewHolder {

        public RadioButton RB_respuesta;
        public RadioGroup radiogroup;

        public RespuestasModel_ViewHolder(View itemView) {
            super(itemView);
            RB_respuesta = (RadioButton) itemView.findViewById(R.id.RB_respuesta);
            radiogroup= (RadioGroup) itemView.findViewById(R.id.radiogroup);

        }

    }

    public AdapterRespuestas(Context ctx, Activity act, ArrayList<RespuestasModel> datos) {
        this.context = ctx;
        this.datos = datos;
        this.activity = act;
    }

    @Override
    public RespuestasModel_ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_preguntas, viewGroup, false);
        final RespuestasModel_ViewHolder vh = new RespuestasModel_ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final RespuestasModel_ViewHolder viewHolder, final int pos) {
        RadioGroup.LayoutParams rprms;
        sh = new SchemaHelper(context);
        db = sh.getWritableDatabase();
        s_respuesta = new Respuestas_datasource(context);

        viewHolder.RB_respuesta.setText(datos.get(pos).getmRespuesta());
        //viewHolder.TV_Preguntas.setText(datos.get(pos).getmIdPregunta() + " - " + datos.get(pos).getmPregunta());





    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


}

