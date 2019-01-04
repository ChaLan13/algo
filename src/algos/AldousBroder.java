package algos;

import graphe.ArbreCouvrant;
import graphe.Edge;
import graphe.Graph;

import java.util.ArrayList;
import java.util.Random;

public class AldousBroder extends algo{


    public AldousBroder(Graph graph){
        super(graph);
    }

    public void initArbresCouvrants(){
        arbreCouvrants = ArbreCouvrant.arbreCouvrants;
    }

    public ArrayList<Edge> doAlgo(){
        int size = g.vertices();
        boolean[] points_visites = new boolean[size];
        ArrayList<Edge> res = new ArrayList<>();
        Random r = new Random();

        int pointActuel = r.nextInt(size);
        points_visites[pointActuel] = true;
        size--;

        ArrayList<Edge> edges = g.edges();
        for(Edge e : edges)
        	e.setUsed(false);

        while(size > 0){//Tant qu'on a pas visite tous les points du graphe

            ArrayList<Edge> adj = g.adj(pointActuel);
            Edge e = adj.get(r.nextInt(adj.size()));


            int pointFutur;
			if(e.getFrom() == pointActuel) 	//From->To
				pointFutur=e.getTo();
			else 							//To->From
				pointFutur=e.getFrom();


			if(!points_visites[pointFutur]){
				points_visites[pointFutur] = true;//On le marque comme visite
				size--;//Il y aura donc un point en moins a visiter
				if(!e.isUsed())
					res.add(e);//L'arbre couvrant aura donc cette arete
				e.setUsed(true);
			}

            pointActuel = pointFutur;
        }

		return res;
    }
}
