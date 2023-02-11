package fr.alexis.apprickandmorty;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class pop_up extends Dialog {

    private final TextView titre;
    private final TextView age;
    private final TextView episode;
    private final ImageView pop_photo;
    private final Button yesButton;
    private final Button noButton;

    public pop_up(Activity activity) {
        super(activity, com.google.android.material.R.style.Theme_AppCompat_Dialog);
        setContentView(R.layout.popup);
        this.pop_photo = findViewById(R.id.pop_photo);
        this.titre = findViewById(R.id.pop_nom);
        this.age = findViewById(R.id.pop_age);
        this.episode = findViewById(R.id.pop_num_epi);
        this.yesButton = findViewById(R.id.yesButton);
        this.noButton = findViewById(R.id.noButton);


    }


    public void OnClick() {
        System.out.println("ef");
    }
    public Button getYesButton() {
        return yesButton;
    }

    public Button getNoButton() {
        return noButton;
    }

    public void build() {
        show();
    }

    public void build(int choix) {
        TabPerso listPerso = TabPerso.getInstance();
        Picasso.get().load(listPerso.getListPerso().get(0).getImage()).into(pop_photo);
        titre.setText(listPerso.getListPerso().get(0).getName());
        age.setText(listPerso.getListPerso().get(0).getStatus());
        //episode.setText(listPerso.getListPerso().get(position).getAllEpisode());
        show();
    }
}

