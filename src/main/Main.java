package main;

import algos.AldousBroder;
import algos.Kruskal;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import graphe.ArbreCouvrant;
import graphe.Display;
import graphe.Edge;
import graphe.Graph;
import sun.security.krb5.internal.crypto.Aes128;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]){
        int arbre1 =0;
        int arbre2 = 0;
        int arbre3 = 0;
        int arbre4 = 0;
        int arbre5 = 0;
        int arbre6 = 0;
        int arbre7 = 0;
        int arbre8 = 0;

        Graph g = new Graph(4);
        g = g.example();


        AldousBroder a = new AldousBroder(g);

       Display d = new Display();
        d.setImage(g.toImage());


            try{

                for (int i = 0; i < 1000000; i++) {
                    int res = a.executerAlgo();
                    switch (res) {
                        case 1:
                            arbre1++;
                            break;
                        case 2:
                            arbre2++;
                            break;
                        case 3:
                            arbre3++;
                            break;
                        case 4:
                            arbre4++;
                            break;
                        case 5:
                            arbre5++;
                            break;
                        case 6:
                            arbre6++;
                            break;
                        case 7:
                            arbre7++;
                            break;
                        case 8:
                            arbre8++;
                            break;
                        default:
                            System.out.println("error");
                    }

                }

                System.out.println("1 : " + arbre1 + "\n");
                System.out.println("2 : " + arbre2 + "\n");
                System.out.println("3 : " + arbre3 + "\n");
                System.out.println("4 : " + arbre4 + "\n");
                System.out.println("5 : " + arbre5 + "\n");
                System.out.println("6 : " + arbre6 + "\n");
                System.out.println("7 : " + arbre7 + "\n");
                System.out.println("8 : " + arbre8 + "\n");
            }
            catch(Exception e){
                e.printStackTrace();
            }
            }

        }


