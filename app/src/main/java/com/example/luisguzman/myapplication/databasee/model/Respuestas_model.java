package com.example.luisguzman.myapplication.databasee.model;

/**
 * Created by LuisGuzman on 15-04-17.
 */

public class Respuestas_model {
    private int mIdRespuesta;
    private int mIdPregunta;
    private String mRespuesta;

    public Respuestas_model(int IdRespuesta, int IdPregunta, String Respuesta) {
        this.mIdRespuesta = IdRespuesta;
        this.mIdPregunta = IdPregunta;
        this.mRespuesta = Respuesta;
    }

    public int getmIdRespuesta() {
        return mIdRespuesta;
    }

    public void setmIdRespuesta(int mIdRespuesta) {
        this.mIdRespuesta = mIdRespuesta;
    }

    public int getmIdPregunta() {
        return mIdPregunta;
    }

    public void setmIdPregunta(int mIdPregunta) {
        this.mIdPregunta = mIdPregunta;
    }

    public String getmRespuesta() {
        return mRespuesta;
    }

    public void setmRespuesta(String mRespuesta) {
        this.mRespuesta = mRespuesta;
    }
}
