package com.example.luisguzman.myapplication.databasee.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by LuisGuzman on 15-04-17.
 */

public class Respuestas_datasource {
    Context context;
    private static final String TAG = Respuestas_datasource.class.getSimpleName();

    public Respuestas_datasource(Context context) {
        this.context = context;
    }


    public boolean cargarDatos(SQLiteDatabase db, int pregunta, String respuesta){
        try {
            ContentValues cv = new ContentValues();
            cv.put("id_pregunta", pregunta);
            cv.put("respuesta", respuesta);
            long result = db.insertOrThrow("respuestas", null, cv);
            return (result >= 0);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Error al guardar; " + e.toString());
            return false;
        }
    }

    public Cursor obtenerRespuestas(SQLiteDatabase db, int pregunta){
        return db.rawQuery("SELECT * FROM respuestas WHERE id_pregunta = " + pregunta, null);
    }
}
