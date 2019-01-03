package graphe;

import java.util.ArrayList;

public class ArbreCouvrant {

    public ArrayList<Edge> aretes;

    public ArbreCouvrant(ArrayList<Edge> ar){
        this.aretes = ar;
    }

    public boolean equals(ArrayList<Edge> ar){
        int size = ar.size();
        for(int i=0; i < size; i++){
            Edge e = ar.get(i);
            if(!aretes.contains(e))
                return false;
        }
        return true;
    }

}
