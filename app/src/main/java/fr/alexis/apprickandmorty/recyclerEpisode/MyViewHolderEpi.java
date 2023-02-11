package fr.alexis.apprickandmorty.recyclerEpisode;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.alexis.apprickandmorty.R;

public class MyViewHolderEpi extends RecyclerView.ViewHolder {


    TextView nomEpi, dateSortie, numEpi;



/*    public void onDelete(){}

    public void onMore(){}*/
    public MyViewHolderEpi(@NonNull View itemView) {
        super(itemView);
        nomEpi = itemView.findViewById(R.id.titreEpi);
        dateSortie = itemView.findViewById(R.id.dateSortie);
        numEpi = itemView.findViewById(R.id.numEpi);
    }
}

