package graphe;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ArbreCouvrant {

    static public ArrayList<ArbreCouvrant> arbreCouvrants = new ArrayList<>();
    static {
        ArrayList<Edge> ar1 = new ArrayList<Edge>();
        ar1.add(new Edge(0,2));
        ar1.add(new Edge(0,3));
        ar1.add(new Edge(1,3));

        arbreCouvrants.add(new ArbreCouvrant(ar1));

        ArrayList<Edge> ar2 = new ArrayList<Edge>();
        ar2.add(new Edge(0,2));
        ar2.add(new Edge(1,2));
        ar2.add(new Edge(1,3));

        arbreCouvrants.add(new ArbreCouvrant(ar2));

        ArrayList<Edge> ar3 = new ArrayList<Edge>();
        ar3.add(new Edge(0,3));
        ar3.add(new Edge(1,3));
        ar3.add(new Edge(1,2));

        arbreCouvrants.add(new ArbreCouvrant(ar3));

        ArrayList<Edge> ar4 = new ArrayList<Edge>();
        ar4.add(new Edge(0,2));
        ar4.add(new Edge(0,3));
        ar4.add(new Edge(1,2));

        arbreCouvrants.add(new ArbreCouvrant(ar4));

        ArrayList<Edge> ar5 = new ArrayList<Edge>();
        ar5.add(new Edge(0,2));
        ar5.add(new Edge(0,1));
        ar5.add(new Edge(0,3));

        arbreCouvrants.add(new ArbreCouvrant(ar5));

        ArrayList<Edge> ar6 = new ArrayList<Edge>();
        ar6.add(new Edge(0,1));
        ar6.add(new Edge(1,2));
        ar6.add(new Edge(1,3));

        arbreCouvrants.add(new ArbreCouvrant(ar6));

        ArrayList<Edge> ar7 = new ArrayList<Edge>();
        ar7.add(new Edge(0,2));
        ar7.add(new Edge(0,1));
        ar7.add(new Edge(1,3));

        arbreCouvrants.add(new ArbreCouvrant(ar7));

        ArrayList<Edge> ar8 = new ArrayList<Edge>();
        ar8.add(new Edge(0,3));
        ar8.add(new Edge(0,1));
        ar8.add(new Edge(1,2));

        arbreCouvrants.add(new ArbreCouvrant(ar8));
    }

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
