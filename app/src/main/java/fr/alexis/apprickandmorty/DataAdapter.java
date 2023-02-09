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

import java.text.DecimalFormat;

public class DataAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;

    private final TabPerso listPerso;

    public DataAdapter(Context context) {
        this.context = context;
        this.listPerso = TabPerso.getInstance();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.pattern, parent, false));

    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nom.setText(listPerso.getListPerso().get(1).getName());
        holder.genre.setText(listPerso.getListPerso().get(1).getStatus());
        holder.race.setText(listPerso.getListPerso().get(1).getSpecies());

    }

    @Override

    public int getItemCount() {
        return listPerso.getListPerso().size();
    }
}
