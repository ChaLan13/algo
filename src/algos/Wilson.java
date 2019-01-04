package algos;

import graphe.Edge;
import graphe.Graph;

import java.util.ArrayList;
import java.util.Random;

public class Wilson extends algo{

	public Wilson(Graph graph){
		super(graph);
	}

	private boolean[] points_visites;
	private int size;
	private Random r;
	private int point_actuel;
	private ArrayList<Edge> _res;
	private ArrayList<Edge> _cheminRetour;

	public ArrayList<Edge> doAlgo() {
		size = g.vertices();
		r = new Random();
		_res = new ArrayList<>();
		points_visites = new boolean[size];


		point_actuel = r.nextInt(size);
		points_visites[point_actuel] = true;

		while(size > 0){
			point_actuel = genNewUncoveredPoint();

			cheminRetour();
			enleverBoucle();
			ajouterChemin();
		}

		return _res;
	}

	private int genNewUncoveredPoint(){
		int res = r.nextInt(size);
		for(int i = 0; i <= res; i++){
			if(!points_visites[i])
				res++;
		}
		return res;
	}

	private void cheminRetour(){
		int point = point_actuel;
		int futur_point;
		_cheminRetour = new ArrayList<>();
		ArrayList<Edge> adj;
		Edge e;

		while(!points_visites[point]){
			adj = g.adj(point);
			e = adj.get(r.nextInt(adj.size()));

			if(e.getFrom() == point) // From -> To
				futur_point = e.getTo();
			else					 // To -> From
				futur_point = e.getFrom();

			_cheminRetour.add(e);
			point = futur_point;
		}
	}

	private void enleverBoucle(){
		int[] pointsParcouru = new int[points_visites.length];

		for(int i=0; i < pointsParcouru.length; i++)
			pointsParcouru[i] = -1;

		int point = point_actuel;
		pointsParcouru[point] = 0;

		for(int i = 0; i < _cheminRetour.size(); i++){
			Edge e = _cheminRetour.get(i);

			if(e.getFrom() == point) point = e.getTo();
			else point = e.getFrom();

			if(pointsParcouru[point] > -1){
				int first = pointsParcouru[point];
				int j;
				for(j = first; j < i; j++)
					_cheminRetour.remove(first+1);

				i-= j;
			}
			else {
				pointsParcouru[point] = i;
			}
		}
	}

	private void ajouterChemin(){
		_res.addAll(_cheminRetour);
		for(Edge e : _cheminRetour) {
			points_visites[e.getFrom()] = true;
			points_visites[e.getTo()] = true;
		}
		size-=_cheminRetour.size();
	}
}
