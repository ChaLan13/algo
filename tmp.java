
//Kruskal

ArrayList<ArbreCouvrant> abres;
int size;

kruskal(Graph g){
	//...
	arbres = new ArrayList<>();

	ArrayList<Edge> abre = new ArrayList<>();
	arbre.add();
	//....
	arbres.add(new ArbreCouvrant(arbre));

	arbre = new ArrayList<>();
	arbre.add();
	//...
	arbres.add(new ArbreCouvrant(arbre));

	size = 8;
}


int executeralgo(){
	/*
	tout algo
	*/

	for(int i = 0; i < this.size; i++){
		ArbreCouvrant a = arbres.get(i);
		if(a.equals(res))
			return i;
	}
	return -1;
}
