package algos;

import graphe.ArbreCouvrant;
import graphe.Edge;
import graphe.Graph;

import java.util.ArrayList;

public abstract class algo {

	Graph g;
	ArrayList<ArbreCouvrant> arbreCouvrants = new ArrayList<ArbreCouvrant>();

	public algo(Graph graph){
		g = graph;
		initArbresCouvrants();
	}

	public void initArbresCouvrants(){
		arbreCouvrants = ArbreCouvrant.arbreCouvrants;
	}

	public int executerAlgo(){
		ArrayList<Edge> res = doAlgo();

		//Cette partie permet de reconnaitre quel est l'arbre couvrant.
		int size = res.size();
		for(int i = 0; i < size; i++){
			ArbreCouvrant a = arbreCouvrants.get(i);
			if(a.equals(res))
				return i+1;
		}
		return -1;
	}

	public abstract ArrayList<Edge> doAlgo();
}
