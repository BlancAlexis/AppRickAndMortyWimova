package fr.alexis.apprickandmorty;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class DataAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;

    private final TabPerso listPerso;

    public DataAdapter(Context context, TabPerso listPerso) {
        this.context = context;
        this.listPerso = listPerso;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.pattern, parent, false));

    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
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
