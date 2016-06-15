package com.josepcode.presistenciamascotas.pojo;

/**
 * Created by JR on 14/06/2016.
 */
public class MascotasRating {

    private int mId;
    private int mFotoPet;
    private String mNombre;
    private int mLikes;
    private String fecha;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }



    public MascotasRating() {
    }

    public MascotasRating(int fotoPet, String nombre, int likes) {
        mFotoPet    = fotoPet;
        mNombre     = nombre;
        mLikes      = likes;

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

}
