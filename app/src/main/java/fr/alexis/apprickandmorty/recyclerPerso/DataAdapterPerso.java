package fr.alexis.apprickandmorty.recyclerPerso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import fr.alexis.apprickandmorty.R;
import fr.alexis.apprickandmorty.TabPerso;

public class DataAdapterPerso extends RecyclerView.Adapter<MyViewHolderPerso> {

    Context context;

    private final TabPerso listPerso;

    public DataAdapterPerso(Context context, TabPerso listPerso) {
        this.context = context;
        this.listPerso = listPerso;
    }


    @NonNull
    @Override
    public MyViewHolderPerso onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolderPerso(LayoutInflater.from(context).inflate(R.layout.patternperso, parent, false));

    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPerso holder, int position) {
        Picasso.get().load(listPerso.getListPerso().get(position).getImage()).into(holder.image);
        holder.nom.setText(listPerso.getListPerso().get(position).getName());
        holder.genre.setText(listPerso.getListPerso().get(position).getStatus());
        holder.race.setText(listPerso.getListPerso().get(position).getSpecies());


    }

    @Override

    public int getItemCount() {
        return listPerso.getListPerso().size();
    }
}
