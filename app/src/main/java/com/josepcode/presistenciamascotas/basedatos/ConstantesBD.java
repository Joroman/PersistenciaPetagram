package com.josepcode.presistenciamascotas.basedatos;

/**
 * Created by JR on 13/06/2016.
 */
public class ConstantesBD {
    //pones la clase como constatne/final para que nadie pueda alterar dichos datos
    //Esta clase la utilizamos para declarar constantes.
    public static final String  DATABASE_NAME="perros";
    public static final int     DATABASE_VERSION=1;

    // de esta forma mis campos de la tabla permanecen constantes y Si este archivo cambio la estructura de la variablers
    //son varibles super globales ya que son staticas.
    //TABLA: MASCOTA
    //CAMPOS: ID, FOTO, NOMBRE, LIKES, DATE_LIKES;


    public static final String TABLE_MASCOTA            =   "mascota";
    public static final String TABLE_MASCOTA_ID         =   "id";
    public static final String TABLE_MASCOTA_FOTO       =   "foto";
    public static final String TABLE_MACOTA_NOMBRE      =   "nombre";
    public static final String TABLE_MASCOTA_LIKES      =   "likes";
    public static final String TABLE_MASCOTA_DATE_LIKE  =   "date_likes";

    //TABLA: MASCOTARATING
    //CAMPOS: ID , ID_MASCOTA, FOT, NOMEBRE, LIKES.

    public static  final String TABLE_MASCOTARATING             =   "mascotarating";
    public static  final String TABLE_MASCOTARATING_ID          =   "id";
    public static  final String TABLE_MASCOTARATING_FOTO        =   "foto";
    public static  final String TABLE_MASCOTARATING_NOMNRE      =   "nombre";
    public static  final String TABLE_MASCOTARATING_LIKES       =   "likes";
    public static  final String TABLE_MASCOTARATING_FECHA       =   "fecha";
}

