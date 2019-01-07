package algos;

import graphe.Edge;
import graphe.GrapheCarre;

import java.util.List;

public class Labyrinth {
	GrapheCarre g;
	boolean[] points_visites;
	int entree, sortie;
	public int cul_de_sac;
	public int taille;

	public Labyrinth(GrapheCarre g){
		this.g = g;
		entree = g.vertices()-g.l;
		sortie = g.l - 1;
	}

	public void identifier(){
		points_visites = new boolean[g.vertices()];
		cul_de_sac = 0;
		taille = chercherAutour(entree)+1;
	}

	private int chercherAutour(int pointActuel){
		points_visites[pointActuel] = true;
		List<Edge> adj = g.adj(pointActuel);
		int chemin = -1;
		boolean cds = true;

		for(Edge e : adj){
			if(e.isUsed()){//Fait partis du labyrinth
				int pointFutur;
				if(e.getFrom() == pointActuel) pointFutur = e.getTo();
				else pointFutur = e.getFrom();

				if(!points_visites[pointFutur]){//Pas de retour en arriere
					cds = false;//Il reste du chemin donc pas de Cul De Sac
					int res = chercherAutour(pointFutur);//Recursion sur ce point.
					//Pas de cycle donc pas d'autres verifications a faire
					if(res != -1) {
						chemin = res + 1;
					}
				}

			}
		}

		if(cds) cul_de_sac++;

		if(pointActuel == sortie)
			return 0;

		return chemin;
	}
}
