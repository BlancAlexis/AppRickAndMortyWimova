package fr.alexis.apprickandmorty;

import java.util.ArrayList;
import java.util.List;

public class TabPerso {
    private List<Characters> listPerso;

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

public void affichage() {
    for (Characters characters : listPerso) {
        System.out.println(characters.getName());
    }
}
/*
public void getAllEpisode(TabPerso list){
    for (String ep: list.ge)
}*/
    public TabPerso(){
        listPerso =new ArrayList<Characters>();
    }
    public void addPerso(Characters chara){
        listPerso.add(chara);
    }

    public void remove(int position){
        listPerso.remove(position);
    }
    public List<Characters> getListPerso() {
        return listPerso;
    }
    public int getCounts() {
        return listPerso.size();
    }

 /*   public String getEpisode(){
    return listPerso.
    }
*/
    public void setListPerso(ArrayList<Characters> listPerso) {
        this.listPerso = listPerso;
    }
}
