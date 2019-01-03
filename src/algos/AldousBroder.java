package algos;

import graphe.ArbreCouvrant;
import graphe.Edge;
import graphe.Graph;

import java.util.ArrayList;
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

    public int executerAlgo(){
        int size = 8;
        ArrayList<Edge> res = new ArrayList<>();
        ArrayList<Integer> pointAParcourir = new ArrayList<>();
        ArrayList<Integer> pointParcouru = new ArrayList<>();
        Random r = new Random();

        for(Edge e : g.edges()){
            if(pointAParcourir.get(e.getFrom()) == null){
                pointAParcourir.add(e.getFrom());
            }
            if(pointAParcourir.get(e.getTo()) == null){
               pointAParcourir.add(e.getTo());
                size++;
            }
        }

        int pointActuel = r.nextInt(4);
        pointAParcourir.remove(pointActuel);
        pointParcouru.add(pointActuel);

        while(pointAParcourir.size() > 0){

            boolean continuer = true;

            ArrayList<Edge> adj = g.adj(pointActuel);
            int i = r.nextInt(adj.size());

            while(continuer && adj.size() > 0){
                Edge e = adj.get(i);
                //si l'arete est utilisé ça ne fait rien
                if(e.isUsed())
                    continuer = false;
                //sinon on verifie si le point est à parcourir
                else{
                    if(pointAParcourir.contains(e.getTo())){
                        //si oui, ça ne fait pas de cycle donc ok
                        //on change de position et on recommence
                        pointParcouru.add(e.getTo());
                        pointAParcourir.remove(e.getTo());
                        pointActuel = e.getTo();
                        e.setUsed(true);
                        res.add(e);
                        continuer = false;
                    }
                    //sinon on la retire de la liste des adj et on teste une autre arete sans changer de position
                    adj.remove(e);
                  i = r.nextInt(adj.size());
                }

            }

        }






        for(int i = 0; i < size; i++){
            ArbreCouvrant a = arbreCouvrants.get(i);
            if(a.equals(res))
                return i+1;
        }
        return -1;
    }
}
