package algos;

import graphe.ArbreCouvrant;
import graphe.Edge;
import graphe.Graph;

import java.util.ArrayList;
import java.util.Collections;

import static algos.UnionFind.makeSet;
import static algos.UnionFind.union;

public class Kruskal {

    private Graph g;
    public ArrayList<ArbreCouvrant> arbreCouvrants = new ArrayList<ArbreCouvrant>();

    public Kruskal(Graph graph){
        g = graph;
        initArbresCouvrants();
    }

    public int executerAlgo() {
        int size = 8;
        ArrayList<Edge> aretes = g.edges();
        ArrayList<Edge> res = new ArrayList<Edge>();

        Collections.shuffle(aretes);

        makeSet(aretes);
        for(int i = 0; i < aretes.size(); i++){
            if(union(aretes.get(i)))
                res.add(new Edge(aretes.get(i).getFrom(), aretes.get(i).getTo()));
        }

        for(int i = 0; i < size; i++){
            ArbreCouvrant a = arbreCouvrants.get(i);
            if(a.equals(res))
                return i+1;
        }
        return -1;
    }


    public void initArbresCouvrants(){
        arbreCouvrants = ArbreCouvrant.arbreCouvrants;
    }


}
