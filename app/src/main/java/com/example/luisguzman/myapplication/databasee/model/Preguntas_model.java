package com.example.luisguzman.myapplication.databasee.model;

/**
 * Created by LuisGuzman on 14-04-17.
 */

public class Preguntas_model {
    private int mIdPregunta;
    private String mPregunta;

    public Preguntas_model(int mIdPregunta, String mPregunta) {
        this.mIdPregunta = mIdPregunta;
        this.mPregunta = mPregunta;
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
