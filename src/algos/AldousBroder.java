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

            //TODO tant que continue alors
            // si c'est marqué continue false
            // sinon
            //si sommet est dans à parcourir on met continue à false
            //On met le point dans parcouru
            //On marque l'arete
            //On change le point actuel
        }






        for(int i = 0; i < size; i++){
            ArbreCouvrant a = arbreCouvrants.get(i);
            if(a.equals(res))
                return i+1;
        }
        return -1;
    }
}
