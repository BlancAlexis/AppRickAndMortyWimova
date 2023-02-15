package fr.alexis.apprickandmorty;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class APIResponseChara {


    @SerializedName("results")
    private List<Characters> characters;
    @SerializedName("info")
    private Info info;

    public List<Characters> getCharacters() {
        return characters;
    }

    public Info getInfo() {return info;}

    public void setCharacters(List<Characters> characters) {
        this.characters = characters;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
