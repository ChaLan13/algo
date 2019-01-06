package graphe;

public class GrapheCarre extends Graph {
	public int l;


	public GrapheCarre(int N) {
		super(N*N);
		l = N;

		doCoo(this);
		doEdges(this);
	}



	public static GrapheCarre example(){
		GrapheCarre g = new GrapheCarre(20);
		return g;
	}

	private static void doCoo(GrapheCarre g){
		int k = 0;
		for(int i = 0; i < g.l; i++){
			for(int j = 0; j < g.l; j++){
				g.setCoordinate(k++, (j+1)*50, (i+1)*50);
			}
		}
	}

	private static void doEdges(GrapheCarre g){
		for(int i = 0; i < g.vertices(); i++){
			if(i >= g.l)
				g.addEdge(new Edge(i, i-g.l));
			if(i < (g.vertices()-g.l))
				g.addEdge(new Edge(i, i+g.l));
			if(i%g.l > 0)
				g.addEdge(new Edge(i, i-1));
			if(i%g.l < g.l-1)
				g.addEdge(new Edge(i, i+1));
		}
	}
}
