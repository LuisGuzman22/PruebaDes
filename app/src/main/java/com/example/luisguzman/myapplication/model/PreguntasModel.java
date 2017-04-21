package com.example.luisguzman.myapplication.model;

import java.util.ArrayList;

/**
 * Created by LuisGuzman on 14-04-17.
 */

public class PreguntasModel {
    private int mIdPregunta;
    private String mPregunta;
    private int mTipoPregunta;
    private RespuestasModel mDatos;


    private int mIdRespuesta;
    private String mRespuesta;

    public PreguntasModel(int IdPregunta, String Pregunta, int TipoPregunta) {
        this.mIdPregunta = IdPregunta;
        this.mPregunta = Pregunta;
        this.mTipoPregunta = TipoPregunta;
    }

    public PreguntasModel(int IdPregunta, String Pregunta, int TipoPregunta, RespuestasModel Datos) {
        this.mIdPregunta = IdPregunta;
        this.mPregunta = Pregunta;
        this.mTipoPregunta = TipoPregunta;
        this.mDatos = Datos;
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

    public int getmIdRespuesta() {
        return mIdRespuesta;
    }

    public void setmIdRespuesta(int mIdRespuesta) {
        this.mIdRespuesta = mIdRespuesta;
    }

    public String getmRespuesta() {
        return mRespuesta;
    }

    public void setmRespuesta(String mRespuesta) {
        this.mRespuesta = mRespuesta;
    }

    public int getmTipoPregunta() {
        return mTipoPregunta;
    }

    public void setmTipoPregunta(int mTipoPregunta) {
        this.mTipoPregunta = mTipoPregunta;
    }

    public RespuestasModel getmDatos() {
        return mDatos;
    }

    public void setmDatos(RespuestasModel mDatos) {
        this.mDatos = mDatos;
    }
}
