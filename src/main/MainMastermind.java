package main;

import mastermind.Mastermind;
import mastermind.Maths;

public class MainMastermind {

    public static void main(String[] args){
        Mastermind master = new Mastermind(4,6);
        System.out.println("resultat :" + master.getInTab(1,2));
        int resAttendu = Maths.combinaison(1,4)*Maths.combinaison(2,3)*Maths.arrangement(2,3)*Maths.arrangement(1,2);
        System.out.println("resultat attendu :" + resAttendu);


    }
}
