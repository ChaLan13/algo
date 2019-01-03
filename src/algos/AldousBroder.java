package algos;

import graphe.ArbreCouvrant;
import graphe.Edge;
import graphe.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AldousBroder {

    private Graph g;
    public ArrayList<ArbreCouvrant> arbreCouvrants = new ArrayList<ArbreCouvrant>();

    public AldousBroder(Graph graph){
        g = graph;
        initArbresCouvrants();
    }

    public void initArbresCouvrants(){
        arbreCouvrants = ArbreCouvrant.arbreCouvrants;
    }

    public int executerAlgo() throws Exception{
        int size = g.vertices();
        boolean[] points_visites = new boolean[size];
        ArrayList<Edge> res = new ArrayList<>();
        Random r = new Random();

        for (Edge e : g.edges()){
            e.setUsed(false);
        }

        int pointActuel = r.nextInt(size);
        points_visites[pointActuel] = true;
        size--;

        while(size > 0){

            boolean arreter = false;

            ArrayList<Edge> adj = g.adj(pointActuel);
            Collections.shuffle(adj);
            Edge e;


            for(int i=0; (i < adj.size()) && !arreter; i++){
                e = adj.get(i);

                if(e.isUsed()){//On peut retourner en arriere
                    //car l arete est deja visitee
                    //mais on n ajoute rien aux points visites
                    arreter = true;
                }
                else{
                    /*Comme le graphe n'est pas considere comme oriente,
                     * Il faut donc essayer dans le sens from -> to
                     * et dans le sens to -> from
                     */


                    //from -> to
                    if(e.getFrom() == pointActuel){
                        if(!points_visites[e.getTo()]){
                            //Si le point est deja visite, Ne pas prendre car creation d'un cycle
                            //mais la on sait qu'il n'est pas visite, donc on va le visiter
                            points_visites[e.getTo()] = true;
                            size--;
                            e.setUsed(true);
                            res.add(e);
                            arreter = true;
                        }
                    }
                    else{//To -> From
                        if(!points_visites[e.getFrom()]){
                            arreter = true;
                            points_visites[e.getFrom()] = true;
                            size--;
                            e.setUsed(true);
                            res.add(e);

                        }
                    }
                }

                //Visiter l'arrete
                if(e.getFrom() == pointActuel) //sens From -> To
                    pointActuel = e.getTo();
                else// To -> From
                    pointActuel = e.getFrom();

            }

            if(!arreter) // Si on ne s'est pas arrete volontairement (donc pas trouve de chemin)
                //alors error
                throw new Exception("Graphe avec un point d'arite 0");

        }



        int sizeArbre = 8;

        for(int i = 0; i < sizeArbre; i++){
            ArbreCouvrant a = arbreCouvrants.get(i);
            if(a.equals(res))
                return i+1;
        }
        return -1;
    }
}
