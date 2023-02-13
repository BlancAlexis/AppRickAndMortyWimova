package fr.alexis.apprickandmorty.recyclerEpisode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.alexis.apprickandmorty.Episode;
import fr.alexis.apprickandmorty.R;
import fr.alexis.apprickandmorty.TabEpi;
import fr.alexis.apprickandmorty.recyclerPerso.MyViewHolderPerso;

public class DataAdapterEpi extends RecyclerView.Adapter<MyViewHolderEpi> {

    Context context;

    private  ArrayList<Episode> listEpi;

    public DataAdapterEpi(Context context, ArrayList<Episode> epi) {
        this.context = context;
        this.listEpi = epi;
    }


    @NonNull
    @Override
    public MyViewHolderEpi onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolderEpi(LayoutInflater.from(context).inflate(R.layout.patternepi, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderEpi holder, int position) {
            holder.nomEpi.setText(listEpi.get(position).getNameEpi());
            holder.dateSortie.setText(listEpi.get(position).getAir_date());
            holder.numEpi.setText(listEpi.get(position).getEpisode());

        }


    @Override

    public int getItemCount() {
        return listEpi.size();
    }
}
