package main;

import algos.AldousBroder;
import algos.Kruskal;
import algos.Labyrinth;
import algos.Wilson;
import graphe.Display;
import graphe.Graph;
import graphe.GrapheCarre;

public class Main {

    public static void main(String args[]){

        Graph g = Graph.example();
		GrapheCarre gc = GrapheCarre.example();


        AldousBroder a = new AldousBroder(gc);
        Kruskal k = new Kruskal(gc);
		Wilson w = new Wilson(gc);
       	Display d = new Display();

       	w.doAlgo();
        d.setImage(gc.toImage());

        Labyrinth l = new Labyrinth(gc);

        double taille_kruskal = 0, taille_wilson = 0, taille_adb = 0;
        double cds_kruskal = 0, cds_wilson = 0, cds_adb = 0;

        double nb = 1000;
        for(int i = 0; i < nb; i++){
        	k.doAlgo();
        	l.identifier();
        	taille_kruskal+=(l.taille)/nb;
        	cds_kruskal+=(l.cul_de_sac)/nb;


        	w.doAlgo();
			l.identifier();
			taille_wilson+=(l.taille)/nb;
			cds_wilson+=(l.cul_de_sac)/nb;



        	a.doAlgo();
			l.identifier();
			taille_adb+=(l.taille)/nb;
			cds_adb+=(l.cul_de_sac)/nb;
		}

		System.out.println("En moyenne, Kruskal donne");
		System.out.println("Une taille moyenne du chemin entree/sortie de: "+taille_kruskal);
		System.out.println("Et un nombre moyen de cul de sac de: "+cds_kruskal);
		System.out.println();

		System.out.println("En moyenne, Wilson donne");
		System.out.println("Une taille moyenne du chemin entree/sortie de: "+taille_wilson);
		System.out.println("Et un nombre moyen de cul de sac de: "+cds_wilson);
		System.out.println();

		System.out.println("En moyenne, AldousBroder donne");
		System.out.println("Une taille moyenne du chemin entree/sortie de: "+taille_adb);
		System.out.println("Et un nombre moyen de cul de sac de: "+cds_adb);




		try{
			/*int arbres[] = new int[8];
			for (int i = 0; i < 1000000; i++) {
				int res = w.executerAlgo();
				if(res == -1)
					System.out.println("ERROR");
				else
					arbres[res-1]++;

			}//*/

			/*for(int i = 0; i < 8; i++) {
				int num = i+1;
				int ent = arbres[i]/10000;
				int dec = (int)(((arbres[i]/10000d) - ent)*10);
				System.out.println(num + " : " + ent + "," + dec + " %");
			}//*/
		}
		catch(Exception e){
			e.printStackTrace();
		}
    }

}


