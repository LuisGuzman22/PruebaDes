package com.example.luisguzman.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luisguzman.myapplication.databasee.SchemaHelper;
import com.example.luisguzman.myapplication.databasee.datasource.Preguntas_datasource;

public class Main3Activity extends AppCompatActivity {

    SchemaHelper sh;
    SQLiteDatabase db;

    Preguntas_datasource s_pregunta;

    Button guardar;
    EditText pregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        sh = new SchemaHelper(Main3Activity.this);

        s_pregunta = new Preguntas_datasource(Main3Activity.this);

        guardar = (Button) findViewById(R.id.guardar);
        pregunta = (EditText) findViewById(R.id.pregunta);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = sh.getWritableDatabase();
                /*if (s_pregunta.cargarDatos(db, pregunta.getText().toString().trim())){
                    Toast.makeText(Main3Activity.this, "Pregunta almacenada", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Main3Activity.this, "Pregunta no almacenada", Toast.LENGTH_SHORT).show();
                }*/
            }
        });

    }
}
