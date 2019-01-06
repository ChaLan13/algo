package mastermind;

public class Mastermind {

    private int n;
    private int k;

    private int[][] tab;

    public Mastermind(int nb, int dispo){
        n=nb;
        k=dispo;
        initTableau();

    }

    public void initTableau() {
        tab = new int[n+1][n+1];
        for(int b = 0; b<=n; b++){
            for(int m = 0; m<=n-b; m++){
                if(b==0)
                    tab[b][m] = Maths.combinaison(m,n)*Maths.arrangement(m,n)*Maths.arrangement(n-m,k-n);
                else if(m==0)
                    tab[b][m] = Maths.combinaison(b,n)*Maths.arrangement(n-b,k-n);
                else {
                	int diff = tab[b-1][m-1] - tab[b-1][m];
					tab[b][m] = tab[b][m - 1] - diff - Maths.arrangement(n - b, k - n-b);
					//tab[b][m] = (tab[b - 1][m] + tab[b][m - 1]) * Maths.arrangement(n - b - m, k - n);
				}

                System.out.println("tab "+b+m+ " : " + tab[b][m]);
            }
        }
    }

    public int getInTab(int b, int m){
        return tab[b][m];
    }
}
