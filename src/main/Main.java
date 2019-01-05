package main;

import algos.AldousBroder;
import algos.Kruskal;
import algos.Wilson;
import graphe.Display;
import graphe.Graph;

public class Main {

    public static void main(String args[]){
        int arbres[] = new int[8];

        Graph g = Graph.example();


        AldousBroder a = new AldousBroder(g);
        Kruskal k = new Kruskal(g);
		Wilson w = new Wilson(g);
       	//Display d = new Display();
        //d.setImage(g.toImage());


		try{
			for (int i = 0; i < 1000000; i++) {
				System.out.println("Execution");
				int res = w.executerAlgo();
				System.out.println(i + " : " + res);
				if(res == -1)
					System.out.println("ERROR");
				else
					arbres[res-1]++;

			}

			for(int i = 0; i < 8; i++) {
				int num = i+1;
				int ent = arbres[i]/10000;
				int dec = (int)(((arbres[i]/10000d) - ent)*10);
				System.out.println(num + " : " + ent + "," + dec + " %");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
    }

}


