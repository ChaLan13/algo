package main;

import algos.Kruskal;
import graphe.Display;
import graphe.Edge;
import graphe.Graph;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]){
        Graph g = new Graph(4);
        g = g.example();

        /*Display d = new Display();
        d.setImage(g.toImage());*/

        Kruskal k = new Kruskal(g);
        ArrayList<Edge> res = k.executerAlgo();

        System.out.println(res.toString());
    }
}
