package mastermind;

public class Maths {


    public static int factorielle(int n){
        int fact = 1;
        for(int i =1; i <=n; i++)
            fact = fact* i;
        return fact;
    }

    public static int arrangement(int n, int k){
        return (factorielle(k)/factorielle(k-n));
    }

    public static int combinaison(int n, int k){
        return(factorielle(k)/(factorielle(k-n)*factorielle(n)));
    }


}
