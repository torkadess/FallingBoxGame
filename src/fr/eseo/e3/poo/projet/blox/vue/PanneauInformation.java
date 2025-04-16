package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.modele.Puits;



public class PanneauInformation extends JPanel implements PropertyChangeListener{
	
	
	public static final int TAILLE_PAR_DEFAUT = 70 ; 
	
	Dimension dimension; 
	VuePiece vuePiece; 
	private Puits puits; 
	
	public PanneauInformation(Puits puits) {
		this.puits = puits; 
		this.setDimension(new Dimension(TAILLE_PAR_DEFAUT, TAILLE_PAR_DEFAUT));
		setPreferredSize(this.getDimension()); 
		setSize(this.getDimension()); 
		this.puits.addPropertyChangeListener(this);
	}
	 public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 
		 Graphics2D g2D = (Graphics2D)g.create();
		 
		 if (this.getVuePiece()!= null) {
				this.getVuePiece().afficherPiece(g2D);
			}
		 g2D.dispose();
	 }
	




	public VuePiece getVuePiece() {
		return vuePiece;
	}
	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	
	
	public void propertyChange(java.beans.PropertyChangeEvent event) {
		
		if (event.getPropertyName().equals(Puits.MODIFICATION_PIECE_SUIVANTE)) {
			this.vuePiece = new VuePiece(this.puits.getPieceSuivante(), 13); 
			this.repaint();
		}
	}
	
	
	
}
