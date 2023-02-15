package fr.alexis.apprickandmorty;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class APIResponseEpi {
        @SerializedName("results")
        private List<Episode> episodes;
        @SerializedName("info")
        private Info info;

        public List<Episode> getEpisodes() {
            return episodes;
        }

        public Info getInfo() {return info;}

        public void setEpisodes(List<Episode> episode) {
            this.episodes = episode;
        }

        public void setInfo(Info info) {
            this.info = info;
        }
    }

