package com.example.luisguzman.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.DrmInitData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.luisguzman.myapplication.databasee.SchemaHelper;
import com.example.luisguzman.myapplication.databasee.datasource.Preguntas_datasource;
import com.example.luisguzman.myapplication.databasee.datasource.Respuestas_datasource;
import com.example.luisguzman.myapplication.interfaces.Database;

public class MainActivity extends AppCompatActivity {

    SchemaHelper sh;
    SQLiteDatabase db;
    Preguntas_datasource s_preguntas;
    Respuestas_datasource s_respuestas;

    Button cargar;
    Button ver;
    Button nueva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sh = new SchemaHelper(MainActivity.this);
        db = sh.getWritableDatabase();
        s_preguntas = new Preguntas_datasource(MainActivity.this);
        s_respuestas = new Respuestas_datasource(MainActivity.this);

        cargar = (Button) findViewById(R.id.cargar);
        ver = (Button) findViewById(R.id.ver);
        nueva = (Button) findViewById(R.id.nueva);

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s_preguntas.cargarDatos(db, "Que le paso a lupita");
                s_preguntas.cargarDatos(db, "Como se llama");
                s_preguntas.cargarDatos(db, "Que hora es");
                s_preguntas.cargarDatos(db, "Cuantos años tienes");
                s_preguntas.cargarDatos(db, "asdasdas");

                s_respuestas.cargarDatos(db, 1, "No se");
                s_respuestas.cargarDatos(db, 1, "Si se");
                s_respuestas.cargarDatos(db, 2, "Luis");
                s_respuestas.cargarDatos(db, 2, "Francisco");
                s_respuestas.cargarDatos(db, 2, "Jaime");
                s_respuestas.cargarDatos(db, 2, "Esteban");
                s_respuestas.cargarDatos(db, 4, "20");
                s_respuestas.cargarDatos(db, 4, "21");
                s_respuestas.cargarDatos(db, 4, "22");


                db.close();

            }
        });

        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });

        nueva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(i);
            }
        });

    }
}
