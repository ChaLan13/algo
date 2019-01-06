package algos;

import graphe.Edge;
import graphe.Graph;

import java.util.ArrayList;
import java.util.Collections;

import static algos.UnionFind.makeSet;
import static algos.UnionFind.union;

public class Kruskal extends algo{

    public Kruskal(Graph graph){
        super(graph);
    }

    public ArrayList<Edge> doAlgo() {
        ArrayList<Edge> aretes = g.edges();
        ArrayList<Edge> res = new ArrayList<Edge>();

        Collections.shuffle(aretes);
        for(Edge e : aretes)
        	e.setUsed(false);

        makeSet(aretes);
        for(int i = 0; i < aretes.size(); i++){
            if(union(aretes.get(i))) {
				res.add(aretes.get(i));
				aretes.get(i).setUsed(true);
			}
        }

        return res;
    }
}
