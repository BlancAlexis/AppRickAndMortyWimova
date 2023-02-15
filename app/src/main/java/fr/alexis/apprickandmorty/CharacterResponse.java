package fr.alexis.apprickandmorty;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import fr.alexis.apprickandmorty.Characters;

public class CharacterResponse {


    @SerializedName("results")
    private List<Characters> characters;


    public List<Characters> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Characters> characters) {
        this.characters = characters;
    }
}
