package com.example.luisguzman.myapplication.model;

/**
 * Created by LuisGuzman on 15-04-17.
 */

public class RespuestasModel {
    private int mIdRespuesta;
    private int mIdPregunta;
    private String mRespuesta;
    private int count;

    public RespuestasModel() {
    }

    public RespuestasModel(int mIdRespuesta, int mIdPregunta) {
        ++count;
        this.mIdRespuesta = mIdRespuesta;
        this.mIdPregunta = mIdPregunta;
    }

    public RespuestasModel(int mIdRespuesta, int mIdPregunta, String mRespuesta) {
        this.mIdRespuesta = mIdRespuesta;
        this.mIdPregunta = mIdPregunta;
        this.mRespuesta = mRespuesta;
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



    public int getCount(){
        return count;
    }
}
