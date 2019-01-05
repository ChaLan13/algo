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
	private int _size;
	private Random r;
	private int point_actuel;
	private ArrayList<Edge> _res;
	private ArrayList<Edge> _cheminRetour;

	public ArrayList<Edge> doAlgo() {
		_size = g.vertices();
		r = new Random();
		_res = new ArrayList<>();
		points_visites = new boolean[_size];


		point_actuel = r.nextInt(_size);
		points_visites[point_actuel] = true;
		_size--;


		while(_size > 0){
			point_actuel = genNewUncoveredPoint();

			cheminRetour();
			enleverBoucle();
			ajouterChemin();
		}

		return _res;
	}

	private int genNewUncoveredPoint(){
		ArrayList<Integer> list = new ArrayList<>();

		for(int i = 0; i<points_visites.length; i++){
			if(!points_visites[i])
				list.add(i);
		}

		int res = r.nextInt(list.size());

		return list.get(res);
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
		int point = point_actuel;
		int size = _cheminRetour.size();
		int[] indice_du_premier_depart = new int[g.vertices()];
		for(int i = 0; i < g.vertices(); i++) indice_du_premier_depart[i] = -1;

		for(int i = 0; i < size; i++){
			Edge e = _cheminRetour.get(i);

			if(indice_du_premier_depart[point] != -1){

				int first = indice_du_premier_depart[point];
				indice_du_premier_depart[point] = -1;

				for(int j = first; j < i; j++){
					_cheminRetour.remove(first);
					size--;
				}
				i = first;
			}

			else {
				indice_du_premier_depart[point] = i;
				
				if(e.getFrom() == point) point = e.getTo();
				else point = e.getFrom();
			}
		}

	}

	private void ajouterChemin(){
		_res.addAll(_cheminRetour);
		for(Edge e : _cheminRetour) {
			points_visites[e.getFrom()] = true;
			points_visites[e.getTo()] = true;
		}
		_size -=_cheminRetour.size();
	}
}
