package algos;

import graphe.Edge;
import graphe.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UnionFind {
	private static class classe{
		public int point;
		public classe parent = null;
		public int rang = 0;

		public classe(int n){
			this.point = n;
		}

		public classe find(){
			if(parent == null)
				return this;
			return parent.find();
		}
	}

	private static HashMap<Integer, classe> all_in_partition;
	public static int size;

	public static void MakeSet(List<Edge> edges){
		all_in_partition = new HashMap<>();
		size = 0;

		classe c;
		for(Edge e : edges){
			if(all_in_partition.get(e.getFrom()) == null){
				c = new classe(e.getFrom());
				all_in_partition.put(c.point, c);
				size++;
			}
			if(all_in_partition.get(e.getTo()) == null){
				c = new classe(e.getTo());
				all_in_partition.put(c.point, c);
				size++;
			}
		}
	}

	public static int find(int x){
		return all_in_partition.get(x).find().point;
	}

	public static boolean union(Edge e){
		return union(e.getFrom(), e.getTo());
	}
	public static boolean union(int x, int y) {
		classe p1 = all_in_partition.get(x).find();
		classe p2 = all_in_partition.get(y).find();

		if(p1.point == p2.point)
			return false;

		size--;

		if(p1.rang < p2.rang){
			p1.parent = p2;
		}
		else{
			p2.parent = p1;
			if(p1.rang == p2.rang) p1.rang++;
		}
		return true;
	}
}
