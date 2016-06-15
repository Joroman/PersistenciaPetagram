package com.josepcode.presistenciamascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.josepcode.presistenciamascotas.Adapter.PetAdapter;
import com.josepcode.presistenciamascotas.basedatos.ConstructorPerros;
import com.josepcode.presistenciamascotas.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRVListaPets;
    private ImageButton mIBEstrella;
    private ConstructorPerros mConstructorPerros;
    private ArrayList<Mascota> mMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Primero cargamos la ToolBar
        Toolbar mMiActionBar=(Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(mMiActionBar);

        //Cojemos el objeto RecycleView para pode trabajar con el a nivel de codigo java
        mRVListaPets=(RecyclerView)findViewById(R.id.rv_Perros);
        //Creamos LinearLayout Manager
        LinearLayoutManager llm =new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRVListaPets.setLayoutManager(llm);



        mConstructorPerros = new ConstructorPerros(getApplicationContext());
        mMascotas=mConstructorPerros.obtenerDatos();
        inicializarAdapter(mMascotas);




        //ImageButton
        mIBEstrella=(ImageButton)findViewById(R.id.ib_estrella);
        mIBEstrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RankingPetsActivity.class);
                startActivity(intent);
            }
        });


    }



    public void inicializarAdapter(ArrayList<Mascota> arrayListPerros){
        //inicializamos el Adapter
        PetAdapter petAdapter=new PetAdapter(arrayListPerros);
        mRVListaPets.setAdapter(petAdapter);
    }

}
