package com.josepcode.presistenciamascotas.basedatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.josepcode.presistenciamascotas.pojo.Mascota;
import com.josepcode.presistenciamascotas.pojo.MascotasRating;

import java.util.ArrayList;

/**
 * Created by JR on 13/06/2016.
 */
public class BaseDatos extends SQLiteOpenHelper{

    Context mContext;

    public BaseDatos(Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //En el método onCreat creamos la estructura creamos las tablas toda la composición de las tablas tal y como estan
        //Creamos la query que nos va a generar la tabla con todos sus campo hemos definido para cada compo el tipo de campo que es.
        String queryCrearTablaMacotas   =  "CREATE TABLE "+ ConstantesBD.TABLE_MASCOTA +
                "("+
                ConstantesBD.TABLE_MASCOTA_ID           +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBD.TABLE_MASCOTA_FOTO         +" INTEGER, "+
                ConstantesBD.TABLE_MACOTA_NOMBRE        +" TEXt, "+
                ConstantesBD.TABLE_MASCOTA_LIKES        +" INTEGER, "+
                ConstantesBD.TABLE_MASCOTA_DATE_LIKE    +" TEXT"+
                ")";

        String queryCrearTablaMascotasRating    = "CREATE TABLE "+ ConstantesBD.TABLE_MASCOTARATING +
                "("+
                ConstantesBD.TABLE_MASCOTARATING_ID         +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBD.TABLE_MASCOTARATING_FOTO       +" INTEGER, "+
                ConstantesBD.TABLE_MASCOTARATING_NOMNRE     +" TEXT, "+
                ConstantesBD.TABLE_MASCOTARATING_LIKES      +" INTEGER, "+
                ConstantesBD.TABLE_MASCOTARATING_FECHA      +" TEXT"+
                ")";


        db.execSQL(queryCrearTablaMacotas);
        db.execSQL(queryCrearTablaMascotasRating);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE PERRO"+ConstantesBD.TABLE_MASCOTA);
    }

    //METODO QUE EJECUTA CONSULTA A BD Y EXTRA TODOS LOS PERROS
    public ArrayList<Mascota> obtenerTodosPerros(){

        ArrayList<Mascota> mascotas=new ArrayList<>();
        //Definición de la query
        String query= "SELECT * FROM "+ConstantesBD.TABLE_MASCOTA;
        //Abrir la base de datos y especificar como la queremos arbir en forma de solo escrituar de solo lectura.
        SQLiteDatabase db=this.getWritableDatabase();
        //ejecutamos la query con un drwa query porque queremos la colección de datos que consultor y nos devolvera un cursor.
        //utilizamos una instancia de la clase Cursor que nos ayudará a poder recorrer todos los registros a través de un bucle.
        //En el bucle vamos a llenar el objeto contacto.
        Cursor registro =db.rawQuery(query,null);

        while(registro.moveToNext())
        {
            Mascota mascota = new Mascota();
            mascota.setId         (registro.getInt(0));
            mascota.setFotoPet    (registro.getInt(1));
            mascota.setNombre     (registro.getString(2));
            mascota.setLikes      (registro.getInt(3));
            mascota.setFecha      (registro.getString(4));
            //almacenamos el arraylist
            mascotas.add(mascota);
        }



        //es importante después de realizar una conexión en este caso a base de datos apara poder ejecutar una query que despues cerremos
        //dicha conexión para que no traiga errores.
        db.close();

        return mascotas;

    }

    //METODO QUE EJECUTA CONSULTA A BD Y EXTRA TODOS LOS PERROS
    public ArrayList<MascotasRating> obtenerRatingMascotas(){

        ArrayList<MascotasRating> mascotasRatings=new ArrayList<>();
        String query= "SELECT * FROM "+ConstantesBD.TABLE_MASCOTARATING;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registro =db.rawQuery(query,null);

        while(registro.moveToNext())
        {
            MascotasRating masRating = new MascotasRating();
            masRating.setId             (registro.getInt(0));
            masRating.setFotoPet        (registro.getInt(1));
            masRating.setNombre         (registro.getString(2));
            masRating.setLikes          (registro.getInt(3));
            masRating.setFecha          (registro.getString(4));

            //almacenamos el arraylist
            mascotasRatings.add(masRating);
        }

        db.close();

        return mascotasRatings;
    }

    //metodo genérico
    public void insertarPerro(ContentValues contentValues){
        SQLiteDatabase db= this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_MASCOTA,null,contentValues);
        db.close();
    }

    public void insertarMascotaRating(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_MASCOTARATING,null,contentValues);
        db.close();
    }

    public void borrarDatosTabla(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("delete from "+ ConstantesBD.TABLE_MASCOTARATING);
    }

    public void insertarNuevaFecha(ContentValues contentValues, int id){
        SQLiteDatabase db= this.getWritableDatabase();
        db.update(ConstantesBD.TABLE_MASCOTA,contentValues,"id="+id,null);
        db.close();
    }

}
