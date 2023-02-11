package fr.alexis.apprickandmorty.recyclerEpisode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.alexis.apprickandmorty.R;
import fr.alexis.apprickandmorty.TabEpi;
import fr.alexis.apprickandmorty.recyclerPerso.MyViewHolderPerso;

public class DataAdapterEpi extends RecyclerView.Adapter<MyViewHolderEpi> {

    Context context;

    private final TabEpi listEpi;

    public DataAdapterEpi(Context context, TabEpi listEpi) {
        this.context = context;
        this.listEpi = listEpi;
    }


    @NonNull
    @Override
    public MyViewHolderEpi onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolderEpi(LayoutInflater.from(context).inflate(R.layout.patternepi, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderEpi holder, int position) {
            holder.nomEpi.setText(listEpi.getListEpi().get(position).getName());
            holder.dateSortie.setText(listEpi.getListEpi().get(position).getAir_date());
            holder.numEpi.setText(listEpi.getListEpi().get(position).getEpisode());

        }


    @Override

    public int getItemCount() {
        return listEpi.getListEpi().size();
    }
}
