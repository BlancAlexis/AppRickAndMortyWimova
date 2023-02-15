package fr.alexis.apprickandmorty;

import static okhttp3.internal.Internal.instance;

import java.util.ArrayList;
import java.util.List;

public class TabEpi {
    private static volatile TabEpi instanceTabEpi;

    public static TabEpi getInstance(){
        TabEpi result = instanceTabEpi;
        if (result!=null) {
            return result;
        }
        synchronized (TabEpi.class) {
            if (instanceTabEpi == null) {
                instanceTabEpi = new TabEpi();
            }
            return instanceTabEpi;
        }
    }

    private ArrayList<Episode> listEpi;

    public TabEpi() {
        this.listEpi = new ArrayList<Episode>();
    }

    public ArrayList<Episode> getListEpi() {
        return listEpi;
    }

    public void setListEpi(ArrayList<Episode> listEpi) {
        this.listEpi = listEpi;
    }

    public void addAll(List<Episode> epi){
        listEpi.addAll(epi);
    }
}
