package main;

import algos.AldousBroder;
import graphe.Display;
import graphe.Graph;

public class Main {

    public static void main(String args[]){
        int arbres[] = new int[8];

        Graph g = Graph.example();


        AldousBroder a = new AldousBroder(g);

       	//Display d = new Display();
        //d.setImage(g.toImage());


		try{
			for (int i = 0; i < 1000000; i++) {
				int res = a.executerAlgo();
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


