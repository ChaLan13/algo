public int executerAlgo(){
	int size = g.vertices();
	boolean[] points_visites = new boolean[size]();
	ArrayList<Edge> res = new ArrayList<>();
	Random r = new Random();

	int pointActuel = r.nextInt(size);
	points_visites[pointActuel] = true;
	size--;

	while(size > 0){

		boolean arreter = false;

		ArrayList<Edge> adj = g.adj(pointActuel);
		adj.shuffle();
Â		Edge e;
		for(int i=0; (i < adj.size()) && !arreter; i++){
			e = adj.get(i);

			if(e.isUsed()){//On peut retourner en arriere
				//car l arete est deja visitee
				//mais on n ajoute rien aux points visites
				arreter = true;
			}
			else{
				/*Comme le graphe n'est pas considere comme oriente,
				* Il faut donc essayer dans le sens from -> to
				* et dans le sens to -> from
				*/
				e.setUsed(true);
				res.add(e);

				//from -> to
				if(e.getFrom() == pointActuel){
					if(!points_visites[e.getTo()]){
						//Si le point est deja visite, Ne pas prendre car creation d'un cycle
						//mais la on sait qu'il n'est pas visite, donc on va le visiter
						points_visites[e.getTo()] = true;
						size--;
						arreter = true;
					}
				}
				else{//To -> From
					if(!points_visites[e.getFrom()]){
						arreter = true;
						points_visites[e.getFrom()] = true;
						size--;
					}
				}
			}
		}

		if(!arreter) // Si on ne s'est pas arrete volontairement (donc pas trouve de chemin)
			//alors error
			throw new Exception("Graphe avec un point d'arite 0");

		//Visiter l'arrete
		if(e.getFrom() == pointActuel) //sens From -> To
			pointActuel = e.getTo();
		else// To -> From
			pointActuel = e.getFrom();

	}

	//verif avec abrecouvrant;
}
