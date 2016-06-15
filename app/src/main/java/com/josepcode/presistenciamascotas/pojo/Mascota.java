package com.josepcode.presistenciamascotas.pojo;

import java.util.Date;

/**
 * Created by JR on 30/05/2016.
 */
public class Mascota {
    private int mId;
    private int mFotoPet;
    private String mNombre;
    private int mLikes;
    private String mFecha;
    private Date mDate;



    public Mascota() {
    }

    public Mascota(int fotoPet, String nombre, int likes) {
        mFotoPet = fotoPet;
        mNombre = nombre;
        mLikes = likes;
    }

    public int getFotoPet() {
        return mFotoPet;
    }

    public void setFotoPet(int fotoPet) {
        mFotoPet = fotoPet;
    }

    public String getNombre() {
        return mNombre;
    }

    public void setNombre(String nombre) {
        mNombre = nombre;
    }

    public int getLikes() {
        return mLikes;
    }

    public void setLikes(int likes) {
        mLikes = likes;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getFecha() {
        return mFecha;
    }

    public void setFecha(String fecha) {
        mFecha = fecha;
    }
    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }



}
