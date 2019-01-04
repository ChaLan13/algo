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

        while(size > 0){//Tant qu'on a pas visite tous les points du graphe

            boolean arreter = false;

            ArrayList<Edge> adj = g.adj(pointActuel);
            Collections.shuffle(adj);
            Edge e;
			int pointFutur = -1;


            for(int i=0; (i < adj.size()) && !arreter; i++){//Pour toutes les aretes adj OU quand on a trouve la bonne
                e = adj.get(i);

				if(e.getFrom() == pointActuel) //From->To
					pointFutur=e.getTo();
				else //To->From
					pointFutur=e.getFrom();



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
					if(!points_visites[pointFutur]){
						//Si le point est deja visite, Ne pas prendre car creation d'un cycle
						//mais la on sait qu'il n'est pas visite, donc on va le visiter

						arreter = true;//On arrete de chercher quelle arete a visiter
						points_visites[pointFutur] = true;//Comme on va visiter ce point, on le marque comme visite
						size--;//Il y aura donc un point en moins a visiter
						e.setUsed(true);//Comme on utilise l'arete, on la marque comme visitee
						res.add(e);//L'arbre couvrant aura donc cette arete
					}
                }
            }

            pointActuel = pointFutur;

            if(!arreter || pointActuel == -1) // Si on ne s'est pas arrete volontairement (donc pas trouve de chemin)
                //alors error
                throw new Exception("Graphe avec un point d'arite 0");

        }

        int sizeArbre = arbreCouvrants.size();

        for(int i = 0; i < sizeArbre; i++){
            ArbreCouvrant a = arbreCouvrants.get(i);
            if(a.equals(res))
                return i+1;
        }
        return -1;
    }
}
