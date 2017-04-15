package com.example.luisguzman.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.luisguzman.myapplication.adapter.AdapterPreguntas;
import com.example.luisguzman.myapplication.adapter.AdapterRespuestas;
import com.example.luisguzman.myapplication.databasee.SchemaHelper;
import com.example.luisguzman.myapplication.databasee.datasource.Preguntas_datasource;
import com.example.luisguzman.myapplication.databasee.datasource.Respuestas_datasource;
import com.example.luisguzman.myapplication.model.PreguntasModel;
import com.example.luisguzman.myapplication.model.RespuestasModel;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    SchemaHelper sh;
    SQLiteDatabase db;
    Preguntas_datasource s_preguntas;
    Respuestas_datasource s_respuestas;

    RecyclerView RV_Preguntas;
    private ArrayList<PreguntasModel> datosPreguntas;
    private ArrayList<RespuestasModel> datosRespuestas;
    private AdapterPreguntas mAdapterPreguntas;
    private AdapterRespuestas mAdapterRespuestas;


    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sh = new SchemaHelper(Main2Activity.this);

        guardar = (Button) findViewById(R.id.guardar);

        datosPreguntas = new ArrayList<PreguntasModel>();
        datosRespuestas = new ArrayList<RespuestasModel>();

        RV_Preguntas = (RecyclerView) findViewById(R.id.RV_Preguntas);

        RV_Preguntas.setHasFixedSize(true);
        mAdapterPreguntas = new AdapterPreguntas(Main2Activity.this, Main2Activity.this, datosPreguntas);
        mAdapterRespuestas = new AdapterRespuestas(Main2Activity.this, Main2Activity.this, datosRespuestas);
        RV_Preguntas.setAdapter(mAdapterPreguntas);
        RV_Preguntas.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        RV_Preguntas.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));



        cargarPreguntas();

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = 0;
                RespuestasModel m_respuestas = new RespuestasModel();
                Log.d("Actividad", String.valueOf(m_respuestas.getCount()));
                while (m_respuestas.getCount() > x ){

                    String pregunta = String.valueOf(datosRespuestas.get(x).getmIdPregunta());
                    String respuesta = String.valueOf(datosRespuestas.get(x).getmIdRespuesta());
                    System.out.println(pregunta + " " + respuesta);
                    ++x;
                }

            }
        });
    }

    public void cargarPreguntas(){
        db = sh.getWritableDatabase();
        s_preguntas = new Preguntas_datasource(Main2Activity.this);
        Cursor c = s_preguntas.obtenerPreguntas(db);
        if (c.moveToFirst()) {
            do {
                int idPregunta = c.getInt(c.getColumnIndex("id_pregunta"));
                String pregunta = c.getString(c.getColumnIndex("pregunta"));
                int tipo_pregunta = c.getInt(c.getColumnIndex("tipo_pregunta"));
                datosPreguntas.add(new PreguntasModel(idPregunta, pregunta, tipo_pregunta));
            } while (c.moveToNext());
        }
        c.close();
        mAdapterPreguntas.notifyDataSetChanged();
        db.close();
    }







}
