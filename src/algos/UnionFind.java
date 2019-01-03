package algos;

import graphe.Edge;
import java.util.HashMap;
import java.util.List;

public class UnionFind {
	private static class classe{
		int point;
		classe parent = null;

		classe(int n){
			this.point = n;
		}

		classe find(){
			if(parent == null)
				return this;
			return parent.find();
		}
	}

	private static HashMap<Integer, classe> all_in_partition;
	public static int size;

	public static void makeSet(List<Edge> edges){
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

		p1.parent = p2;

		return true;
	}
}
