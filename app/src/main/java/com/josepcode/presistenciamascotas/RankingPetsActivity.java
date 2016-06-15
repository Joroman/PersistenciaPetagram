package com.josepcode.presistenciamascotas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.josepcode.presistenciamascotas.Adapter.RankingPetAdapter;
import com.josepcode.presistenciamascotas.basedatos.ConstructorPerros;
import com.josepcode.presistenciamascotas.pojo.MascotasRating;

import java.util.ArrayList;

public class RankingPetsActivity extends AppCompatActivity {
    private ConstructorPerros mConstructorPerros;
    private ArrayList<MascotasRating> mMascotasCincoArrayList;
    private RecyclerView mRVListaPets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_pets);



        //Primero cargamos la ToolBar
        Toolbar mMiActionBar=(Toolbar)findViewById(R.id.miActionBar_1);
        setSupportActionBar(mMiActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Cojemos el objeto RecycleView para pode trabajar con el a nivel de codigo java
        mRVListaPets= (RecyclerView) findViewById(R.id.rv_Contactos_1);
        //Creamos LinearLayout Manager
        LinearLayoutManager llm =new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRVListaPets.setLayoutManager(llm);

        mConstructorPerros = new ConstructorPerros(getApplicationContext());
        mMascotasCincoArrayList=mConstructorPerros.obtenerMascotasRating();
        inicializarAdapter();


    }

    public void inicializarAdapter(){
        //inicializamos el Adapter
        RankingPetAdapter petAdapter=new RankingPetAdapter(mMascotasCincoArrayList);
        mRVListaPets.setAdapter(petAdapter);
    }

}
