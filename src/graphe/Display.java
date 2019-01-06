package graphe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Display extends JFrame {
	class MyWindowListener implements WindowListener {

		public void windowClosing(WindowEvent arg0) {
			System.exit(0);
		}

		public void windowOpened(WindowEvent arg0) {}
		public void windowClosed(WindowEvent arg0) {}
		public void windowIconified(WindowEvent arg0) {}
		public void windowDeiconified(WindowEvent arg0) {}
		public void windowActivated(WindowEvent arg0) {}
		public void windowDeactivated(WindowEvent arg0) {}

	}
    private JLabel jlabel ;
    boolean visible;
    public  Display() {
        super("Image");       // Titre de la fenêtre
        setPreferredSize(new Dimension(1820, 980));  // largeur, hauteur

        jlabel = new JLabel();
	visible = false;
        this.add(jlabel, BorderLayout.CENTER);
        this.pack();
        this.addWindowListener(new MyWindowListener());
    }

    public void setImage(Image blop) {
        if (!visible)
	    {
		visible = true;
		this.setVisible(true);
	    }
	
	jlabel.setIcon(new ImageIcon(blop));
	    
    }

    /** La fenêtre n'est plus visible
     *
     */
    public void close() {
        this.dispose();
    }

} 
