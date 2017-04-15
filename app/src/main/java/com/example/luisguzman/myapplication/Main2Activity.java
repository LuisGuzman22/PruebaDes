package com.example.luisguzman.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.luisguzman.myapplication.adapter.AdapterPreguntas;
import com.example.luisguzman.myapplication.databasee.SchemaHelper;
import com.example.luisguzman.myapplication.databasee.datasource.Preguntas_datasource;
import com.example.luisguzman.myapplication.model.PreguntasModel;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    SchemaHelper sh;
    SQLiteDatabase db;
    Preguntas_datasource s_preguntas;

    RecyclerView RV_Preguntas;
    // VARIABLES ADAPTER EMBALAJE
    private ArrayList<PreguntasModel> datosPreguntas;
    private AdapterPreguntas mAdapterPreguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sh = new SchemaHelper(Main2Activity.this);

        datosPreguntas = new ArrayList<PreguntasModel>();
        RV_Preguntas = (RecyclerView) findViewById(R.id.RV_Preguntas);

        RV_Preguntas.setHasFixedSize(true);
        mAdapterPreguntas = new AdapterPreguntas(Main2Activity.this, Main2Activity.this, datosPreguntas);
        RV_Preguntas.setAdapter(mAdapterPreguntas);
        RV_Preguntas.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        RV_Preguntas.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));



        cargarPreguntas();
    }

    public void cargarPreguntas(){
        db = sh.getWritableDatabase();
        s_preguntas = new Preguntas_datasource(Main2Activity.this);
        Cursor c = s_preguntas.obtenerPreguntas(db);
        if (c.moveToFirst()) {
            do {
                int idPregunta = c.getInt(c.getColumnIndex("id_pregunta"));
                String pregunta = c.getString(c.getColumnIndex("pregunta"));
                Log.d("ASD", pregunta);
                datosPreguntas.add(new PreguntasModel(idPregunta, pregunta));
            } while (c.moveToNext());
        }
        c.close();
        mAdapterPreguntas.notifyDataSetChanged();
    }

}
