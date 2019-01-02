package algos;

import graphe.Edge;
import graphe.Graph;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {

    private Graph g;

    public Kruskal(Graph graph){
        g = graph;
    }

    public ArrayList<Edge> executerAlgo() {
        ArrayList<Edge> aretes = g.edges();
        ArrayList<Edge> res = new ArrayList<Edge>();

        Collections.shuffle(aretes);

        do {
            res.add(aretes.get(0));
            aretes.remove(0);

        } while (!estCyclique(res));
        return res;
    }


    public boolean estCyclique(ArrayList<Edge> list){
        Edge areteATester = list.get(list.size()-1);
        for(int i = 0; i < list.size()-1; i++){
            if(areteATester.getTo() == list.get(i).getFrom())
                return true;

        }
        return false;
    }


}
