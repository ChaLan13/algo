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
                return i;
        }
        return -1;
    }


    public void initArbresCouvrants(){
        ArrayList<Edge> ar1 = new ArrayList<Edge>();
        ar1.add(new Edge(0,2));
        ar1.add(new Edge(0,3));
        ar1.add(new Edge(1,3));

        arbreCouvrants.add(new ArbreCouvrant(ar1));

        ArrayList<Edge> ar2 = new ArrayList<Edge>();
        ar1.add(new Edge(0,2));
        ar1.add(new Edge(1,2));
        ar1.add(new Edge(1,3));

        arbreCouvrants.add(new ArbreCouvrant(ar2));

        ArrayList<Edge> ar3 = new ArrayList<Edge>();
        ar1.add(new Edge(0,3));
        ar1.add(new Edge(1,3));
        ar1.add(new Edge(1,2));

        arbreCouvrants.add(new ArbreCouvrant(ar3));

        ArrayList<Edge> ar4 = new ArrayList<Edge>();
        ar1.add(new Edge(0,2));
        ar1.add(new Edge(0,3));
        ar1.add(new Edge(1,2));

        arbreCouvrants.add(new ArbreCouvrant(ar4));

        ArrayList<Edge> ar5 = new ArrayList<Edge>();
        ar1.add(new Edge(0,2));
        ar1.add(new Edge(0,1));
        ar1.add(new Edge(0,3));

        arbreCouvrants.add(new ArbreCouvrant(ar5));

        ArrayList<Edge> ar6 = new ArrayList<Edge>();
        ar1.add(new Edge(0,1));
        ar1.add(new Edge(1,2));
        ar1.add(new Edge(1,3));

        arbreCouvrants.add(new ArbreCouvrant(ar6));

        ArrayList<Edge> ar7 = new ArrayList<Edge>();
        ar1.add(new Edge(0,2));
        ar1.add(new Edge(0,1));
        ar1.add(new Edge(1,3));

        arbreCouvrants.add(new ArbreCouvrant(ar7));

        ArrayList<Edge> ar8 = new ArrayList<Edge>();
        ar1.add(new Edge(0,3));
        ar1.add(new Edge(0,1));
        ar1.add(new Edge(1,2));

        arbreCouvrants.add(new ArbreCouvrant(ar8));

    }

    /*public boolean estCyclique(ArrayList<Edge> list){
        Edge areteATester = list.get(list.size()-1);
        for(int i = 0; i < list.size()-1; i++){
            if(areteATester.getTo() == list.get(i).getFrom())
                return true;

        }
        return false;
    }
    */

}
