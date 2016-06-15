package com.josepcode.presistenciamascotas.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.josepcode.presistenciamascotas.R;
import com.josepcode.presistenciamascotas.pojo.MascotasRating;

import java.util.ArrayList;

/**
 * Created by JR on 30/05/2016.
 */
public class RankingPetAdapter extends RecyclerView.Adapter <RankingPetAdapter.RankingPetViewHolder> {

    ArrayList<MascotasRating> mMascotaArrayList;

    public RankingPetAdapter(ArrayList<MascotasRating> mascotaArrayList) {
        this.mMascotaArrayList = mascotaArrayList;
    }

    @Override
    public RankingPetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_pet_cardview,parent,false);
        return new RankingPetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RankingPetViewHolder petViewHolder, int position) {
        final MascotasRating mascota = mMascotaArrayList.get(position);

        petViewHolder.mPetFoto  .setImageResource(mascota.getFotoPet());
        petViewHolder.mPetName  .setText(mascota.getNombre());
        petViewHolder.mPetLikes .setText(String.valueOf(mascota.getLikes()));
        petViewHolder.mIBBone   .setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(),"Diste Like a: " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMascotaArrayList.size();
    }

    public static class RankingPetViewHolder extends RecyclerView.ViewHolder{
        private ImageView mPetFoto;
        private TextView mPetName;
        private TextView mPetLikes;
        private ImageButton mIBBone;

        public RankingPetViewHolder(View itemView) {
            super(itemView);

            mPetFoto    =(ImageView)    itemView.findViewById(R.id.iv_foto_pet);
            mPetName    =(TextView)     itemView.findViewById(R.id.tv_pet_name);
            mPetLikes   =(TextView)     itemView.findViewById(R.id.tv_like);
            mIBBone     =(ImageButton)  itemView.findViewById(R.id.ib_bone);
        }
    }
}
