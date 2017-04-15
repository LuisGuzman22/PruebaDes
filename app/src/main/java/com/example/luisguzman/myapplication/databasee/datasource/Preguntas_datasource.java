package com.example.luisguzman.myapplication.databasee.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.util.Log;

/**
 * Created by LuisGuzman on 14-04-17.
 */

public class Preguntas_datasource {
    Context context;
    private static final String TAG = Preguntas_datasource.class.getSimpleName();

    public Preguntas_datasource(Context context) {
        this.context = context;
    }


    public boolean cargarDatos(SQLiteDatabase db, String pregunta){
        try {
            ContentValues cv = new ContentValues();
            cv.put("pregunta", pregunta);
            long result = db.insertOrThrow("preguntas", null, cv);
            return (result >= 0);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Error al guardar; " + e.toString());
            return false;
        }
    }

    public Cursor obtenerPreguntas(SQLiteDatabase db){
        return db.rawQuery("SELECT * FROM preguntas", null);
    }

}
