package com.example.luisguzman.myapplication.model;

/**
 * Created by LuisGuzman on 14-04-17.
 */

public class PreguntasModel {
    private int mIdPregunta;
    private String mPregunta;

    public PreguntasModel(int IdPregunta, String Pregunta) {
        this.mIdPregunta = IdPregunta;
        this.mPregunta = Pregunta;
    }

    public int getmIdPregunta() {
        return mIdPregunta;
    }

    public void setmIdPregunta(int mIdPregunta) {
        this.mIdPregunta = mIdPregunta;
    }

    public String getmPregunta() {
        return mPregunta;
    }

    public void setmPregunta(String mPregunta) {
        this.mPregunta = mPregunta;
    }
}
