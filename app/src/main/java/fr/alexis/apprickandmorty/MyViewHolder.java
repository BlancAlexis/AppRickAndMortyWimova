package fr.alexis.apprickandmorty;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView nom,genre,race;
    ImageView image;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.photo);
        nom = itemView.findViewById(R.id.nom);
        genre = itemView.findViewById(R.id.genre);
        race = itemView.findViewById(R.id.race);
    }
}

