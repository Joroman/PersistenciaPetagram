package com.josepcode.presistenciamascotas.basedatos;

import android.content.ContentValues;
import android.content.Context;

import com.josepcode.presistenciamascotas.R;
import com.josepcode.presistenciamascotas.pojo.Mascota;
import com.josepcode.presistenciamascotas.pojo.MascotasRating;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by JR on 13/06/2016.
 */
public class ConstructorPerros {
    //el Interactor es una clase intermedia con la clase que directamente consulta la BD.
    //esta clase es la clase clave para poder swichear la base de datos tengo que definir aqui estandares.
    private Context mContext;
    private ArrayList<Mascota> mPerros;
    private static final int LIKE=1;


    public ConstructorPerros(Context context)
    {
        this.mContext = context;
    }

    //los datos siempre deben venir en una array list no importa la fuente de datos original.
    public ArrayList<Mascota> obtenerDatos()
    {
        //debemos aquí ejecutar nuestra conexión a base de datos
        BaseDatos db = new BaseDatos(mContext);
        if(db.obtenerTodosPerros().size()==0) {
            insertarSietePerros(db);
        }
        return db.obtenerTodosPerros();
    }

    public ArrayList<MascotasRating> obtenerMascotasRating(){
        ArrayList<Mascota> mascotas;
        BaseDatos db = new BaseDatos(mContext);
        db.borrarDatosTabla();
        mascotas=db.obtenerTodosPerros();
        insertarCincoMascotas(db,ordenarArralist(mascotas));
        return db.obtenerRatingMascotas() ;
    }

    public void insertarSietePerros(BaseDatos db){
        //formato de la fecha yyyy-MM-dd HH:mm"
        //La clase ContentValue trabaja con Clave Valor para almacenar información.
        ContentValues contentValues= new ContentValues();

        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.perro1);
        contentValues.put(ConstantesBD.TABLE_MACOTA_NOMBRE,"Miki");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES,3);
        contentValues.put(ConstantesBD.TABLE_MASCOTA_DATE_LIKE,"2016-01-12 16:00");
        db.insertarPerro(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.perro2);
        contentValues.put(ConstantesBD.TABLE_MACOTA_NOMBRE,"Jacko");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES,2);
        contentValues.put(ConstantesBD.TABLE_MASCOTA_DATE_LIKE,"2016-03-13 10:00");
        db.insertarPerro(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.perro3);
        contentValues.put(ConstantesBD.TABLE_MACOTA_NOMBRE,"Molly");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES,2);
        contentValues.put(ConstantesBD.TABLE_MASCOTA_DATE_LIKE,"2016-04-20 12:00");
        db.insertarPerro(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.perro4);
        contentValues.put(ConstantesBD.TABLE_MACOTA_NOMBRE,"Soti");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES,1);
        contentValues.put(ConstantesBD.TABLE_MASCOTA_DATE_LIKE,"2016-02-05 13:00");
        db.insertarPerro(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.perro5);
        contentValues.put(ConstantesBD.TABLE_MACOTA_NOMBRE,"Cachi");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES,1);
        contentValues.put(ConstantesBD.TABLE_MASCOTA_DATE_LIKE,"2016-05-01 11:00");
        db.insertarPerro(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.perro6);
        contentValues.put(ConstantesBD.TABLE_MACOTA_NOMBRE,"Estel");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES,2);
        contentValues.put(ConstantesBD.TABLE_MASCOTA_DATE_LIKE,"2015-11-14 20:00");
        db.insertarPerro(contentValues);

        contentValues= new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, R.drawable.perro7);
        contentValues.put(ConstantesBD.TABLE_MACOTA_NOMBRE,"Foc");
        contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES,2);
        contentValues.put(ConstantesBD.TABLE_MASCOTA_DATE_LIKE,"2015-12-17 17:00");
        db.insertarPerro(contentValues);
    }


 /*   public void darLikeContacto(Mascota mascota){
        BaseDatos db = new BaseDatos(mContext);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_ID, mascota.getId());
        contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES, mascota.getLikes());
        db.insertarPerro(contentValues);
    }
+/
   /* public int obtenerLikeContacto (Mascota perro){
        BaseDatos db = new BaseDatos(mContext);
        return db.obtenerLikeContacto(contacto);
    }*/

    public void insertarCincoMascotas(BaseDatos db,ArrayList<Mascota> mascotaArrayList){
        int cont = 5;
        ContentValues contentValues= new ContentValues();
        Mascota mascota;
        for(int i=0; i<cont;i++) {
            mascota=mascotaArrayList.get(i);
            contentValues.put(ConstantesBD.TABLE_MASCOTARATING_FOTO,mascota.getFotoPet());
            contentValues.put(ConstantesBD.TABLE_MASCOTARATING_NOMNRE,mascota.getNombre());
            contentValues.put(ConstantesBD.TABLE_MASCOTARATING_LIKES,mascota.getLikes());
            contentValues.put(ConstantesBD.TABLE_MASCOTARATING_FECHA,mascota.getFecha());
            db.insertarMascotaRating(contentValues);
        }
    }

    public ArrayList<Mascota> ordenarArralist(ArrayList<Mascota> mascotaArrayList){
        ArrayList<Mascota> mascotasDate = crearArralistDate(mascotaArrayList);

        Collections.sort(mascotasDate, new Comparator<Mascota>() {
            @Override
            public int compare(Mascota lhs, Mascota rhs) {
                return (rhs.getDate()).compareTo(lhs.getDate());
            }
        });

        return mascotasDate;
    }

    public ArrayList <Mascota> crearArralistDate(ArrayList<Mascota> arrayList){
        Mascota mascota;
        Date fecha;
        ArrayList<Mascota> mascotasDate=new ArrayList<Mascota>();

       for (int i =0; i<arrayList.size();i++){
            mascota = arrayList.get(i);
            fecha=passarStringDate(mascota);
            mascota.setDate(fecha);
            mascotasDate.add(mascota);
       }

        return mascotasDate;
    }
    public Date passarStringDate(Mascota mascota){
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String strFecha = mascota.getFecha();
        Date fecha = null;
        try {
            System.out.println(strFecha);
            fecha = formatoDelTexto.parse(strFecha);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return fecha;
    }

    public void actualizarFechaLikes(Mascota mascota){

        Calendar cal = new GregorianCalendar();
        Date date = cal.getTime();
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String fecha = fechaHora.format(date);

        BaseDatos db = new BaseDatos(mContext);
        ContentValues contentValues= new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTA_ID,mascota.getId());
        contentValues.put(ConstantesBD.TABLE_MASCOTA_FOTO, mascota.getFotoPet());
        contentValues.put(ConstantesBD.TABLE_MACOTA_NOMBRE,mascota.getNombre());
        contentValues.put(ConstantesBD.TABLE_MASCOTA_LIKES,mascota.getLikes()+1);
        contentValues.put(ConstantesBD.TABLE_MASCOTA_DATE_LIKE,fecha);
        System.out.println("NUEVA FECHA "+fecha);
        db.insertarNuevaFecha(contentValues,mascota.getId());
    }

}

