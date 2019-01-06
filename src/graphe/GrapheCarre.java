package graphe;

import java.awt.*;
import java.awt.image.BufferedImage;

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
			/*if(i < (g.vertices()-g.l))
				g.addEdge(new Edge(i, i+g.l));//*/
			if(i%g.l > 0)
				g.addEdge(new Edge(i, i-1));
			/*if(i%g.l < g.l-1)
				g.addEdge(new Edge(i, i+1));//*/
		}
	}

	public BufferedImage toImage(){
		int largeur, hauteur;
		largeur = l*55;
		hauteur = l*55;
		
		BufferedImage image = new BufferedImage(largeur, hauteur, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();
		g2d.setColor(Color.GRAY);
		g2d.fillRect(0, 0, largeur, hauteur);
		BasicStroke bs = new BasicStroke(2);
		g2d.setStroke(bs);

		// dessine les sommets
		for (int i = 0; i < V; i++) {
			g2d.setColor(Color.WHITE);
			g2d.fillRect(coordX[i]-15, coordY[i]-15,30,30);
			g2d.setColor(Color.BLACK);
			g2d.drawRect(coordX[i] - 15, coordY[i] - 15, 30, 30);
		}


		// dessine les arêtes
		for (Edge e: edges())
		{
			if(e.isUsed()){
				int i = e.getFrom();
				int j = e.getTo();

				//Rect blanc entre les deux
				g2d.setColor(Color.WHITE);
				int X, Y, H, L;
				if(coordX[j] < coordX[i]){
					g2d.setColor(Color.WHITE);
					X = coordX[j]-3;
					Y = coordY[j]-3;
					H = 6;
					L = 60;
					g2d.fillRect(X,Y,L,H);

					//ligne noire
					g2d.setColor(Color.BLACK);
					g2d.drawLine(coordX[i]-15,coordY[i]-4,coordX[j]+15,coordY[j]-4);
					g2d.drawLine(coordX[i]-15,coordY[i]+4,coordX[j]+15,coordY[j]+4);
				}
				if(coordY[j] < coordY[i]) {
					g2d.setColor(Color.WHITE);
					X = coordX[j] - 3;
					Y = coordY[j] - 3;
					H = 60;
					L = 6;
					g2d.fillRect(X, Y, L, H);

					//ligne noire
					g2d.setColor(Color.BLACK);
					g2d.drawLine(coordX[i]-4,coordY[i]-15,coordX[j]-4,coordY[j]+15);
					g2d.drawLine(coordX[i]+4,coordY[i]-15,coordX[j]+4,coordY[j]+15);
				}
			}//*/
		}

		g2d.setColor(Color.BLACK);
		// dessine les noms des sommets
		for (int i = 0; i < V; i++)
			g2d.drawString(Integer.toString(i), coordX[i]-10, coordY[i]);

		return image;
	}
}
