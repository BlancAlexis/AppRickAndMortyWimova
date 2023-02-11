package fr.alexis.apprickandmorty;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class MyViewHolder extends RecyclerView.ViewHolder {


   // MainActivity mainActivity=MainActivity.getInstance();
    TextView nom,genre,race;;
    ImageView image;

    TabPerso listData=TabPerso.getInstance();
    ImageButton more, delete;


/*    public void onDelete(){}

    public void onMore(){}*/
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.photo);

        nom = itemView.findViewById(R.id.nom);
        genre = itemView.findViewById(R.id.genre);
        race = itemView.findViewById(R.id.race);
        more = itemView.findViewById(R.id.more);
        delete = itemView.findViewById(R.id.delete);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("yorergat");
                pop_up customPopup=new pop_up(getAdapterPosition());
                customPopup.getYesButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customPopup.dismiss();
                    }
                });
                customPopup.getNoButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent passage=new Intent(MyViewHolder.class,MainActivity.this);

                    }
                });

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          //      pop_up customPopup=new pop_up(getAdapterPosition());
                System.out.println(getAdapterPosition());
                listData.getListPerso().remove(getAdapterPosition());
                Snackbar.make(delete.getContext(),"Personnage "+listData.getListPerso().get(getAdapterPosition()).getName()+" supprimé", Snackbar.LENGTH_SHORT).show();
               // mainActivity.ada
            //    v.getApplicationWindowToken()
//customPopup.build();
                System.out.println("yorergat");
            }
        });
    }
}

