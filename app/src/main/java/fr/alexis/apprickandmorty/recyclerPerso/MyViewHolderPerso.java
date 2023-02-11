package fr.alexis.apprickandmorty.recyclerPerso;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.alexis.apprickandmorty.MainActivity;
import fr.alexis.apprickandmorty.R;
import fr.alexis.apprickandmorty.TabPerso;
import fr.alexis.apprickandmorty.ViewEpi;
import fr.alexis.apprickandmorty.pop_up;

public class MyViewHolderPerso extends RecyclerView.ViewHolder {


    MainActivity mainActivity=MainActivity.getInstance();
    TextView nom,genre,race;;
    ImageView image;

    TabPerso listData=TabPerso.getInstance();
    ImageButton more, delete;


/*    public void onDelete(){}

    public void onMore(){}*/
    public MyViewHolderPerso(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.photo);

        nom = itemView.findViewById(R.id.titreEpi);
        genre = itemView.findViewById(R.id.dateSortie);
        race = itemView.findViewById(R.id.numEpi);
        more = itemView.findViewById(R.id.more);
        delete = itemView.findViewById(R.id.delete);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("yorergat");
                pop_up customPopup=new pop_up(mainActivity.getActivity());
                customPopup.build(getAdapterPosition());
                customPopup.getYesButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customPopup.dismiss();
                    }
                });
                customPopup.getNoButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent passage;
                        passage=new Intent(mainActivity.getActivity(), ViewEpi.class);
                        passage.putExtra("position",getAdapterPosition());
                        mainActivity.startActivity(passage);
                    }
                });

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          //      pop_up customPopup=new pop_up(getAdapterPosition());
                System.out.println("yo"+getAdapterPosition());
                Toast.makeText(mainActivity.getBaseContext(),"Personnage "+listData.getListPerso().get(getAdapterPosition()).getName()+" supprimé", Toast.LENGTH_SHORT).show();
                listData.getListPerso().remove(getAdapterPosition());

mainActivity.getAdapter().notifyDataSetChanged();
               // Snackbar.make(mainActivity.getBaseContext(),"Personnage "+listData.getListPerso().get(getAdapterPosition()).getName()+" supprimé", Snackbar.LENGTH_SHORT).show();
               // mainActivity.ada
            //    v.getApplicationWindowToken()
//customPopup.build();
                System.out.println("yorergat");
            }
        });
    }
}

