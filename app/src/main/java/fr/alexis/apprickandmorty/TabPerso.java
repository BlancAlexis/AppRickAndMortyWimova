package fr.alexis.apprickandmorty;

import java.util.ArrayList;

public class TabPerso {
    private ArrayList<Characters> listPerso;

    private static volatile TabPerso instance;

public static TabPerso getInstance(){
    TabPerso result = instance;
        if (result!=null) {
        return result;
    }
    synchronized (TabPerso.class) {
        if (instance == null) {
            instance = new TabPerso();
        }
        return instance;
    }
}

    public TabPerso(){
        listPerso =new ArrayList<Characters>();
    }
    public void addPerso(Characters chara){
        listPerso.add(chara);
    }
    public ArrayList<Characters> getListPerso() {
        return listPerso;
    }
    public int getCounts() {
        return listPerso.size();
    }

    public void setListPerso(ArrayList<Characters> listPerso) {
        this.listPerso = listPerso;
    }
}
