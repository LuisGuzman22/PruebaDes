package com.example.luisguzman.myapplication.databasee;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.luisguzman.myapplication.interfaces.Database;

import static com.example.luisguzman.myapplication.interfaces.Database.DATABASE_NAME;
import static com.example.luisguzman.myapplication.interfaces.Database.DATABASE_VERSION;

/**
 * Created by LuisGuzman on 14-04-17.
 */

public class SchemaHelper extends SQLiteOpenHelper implements Database {

    private static final String TAG = SchemaHelper.class.getSimpleName();
    private Context mContext;

    public SchemaHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE preguntas(" +
                    " id_pregunta INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " pregunta VARCHAR(500));");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            db.execSQL("CREATE TABLE respuestas(" +
                    " id_respuesta INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " id_pregunta INTEGER, " +
                    " respuesta VARCHAR(500));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
