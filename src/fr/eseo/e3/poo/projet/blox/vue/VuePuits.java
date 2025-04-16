package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.MouseMotionListener;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;

public class VuePuits extends JPanel implements PropertyChangeListener {
	public static final int TAILLE_PAR_DEFAUT = 15; 
	
	private Puits puits; 
	public Dimension dimension; 
	public int taille; 
	private VuePiece vuePiece;
	private VueTas vueTas; 
	private PieceDeplacement pieceDeplacement; 
	private PieceRotation pieceRotation; 
	
	public VuePuits(Puits puits) {
		this(puits,TAILLE_PAR_DEFAUT);
	}
	
	public VuePuits(Puits puits, int taille) {
		this.setPuits(puits);
		this.setTaille(taille);
		this.setDimension(new Dimension(taille*this.getPuits().getLargeur(), taille*this.getPuits().getProfondeur()));
		setPreferredSize(this.getDimension()); 
		setBackground(Color.WHITE); 
		this.pieceDeplacement = new PieceDeplacement(this);
		this.pieceRotation = new PieceRotation(this); 
		this.setVueTas(new VueTas(this));
		this.puits.addPropertyChangeListener(this);
		this.addMouseMotionListener(this.pieceDeplacement);
		this.addMouseWheelListener(this.pieceDeplacement); 
		this.addMouseListener(this.pieceDeplacement);
		this.addMouseListener(this.pieceRotation);
	}
	
	protected void paintComponent( Graphics g) {
		super.paintComponent(g);
		g.clearRect(0, 0, getWidth(), getHeight());
		
		Graphics2D g2D = (Graphics2D)g.create(); 
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i<puits.getLargeur(); i++) {
			g.drawLine(i*this.getTaille(), 0, i*this.getTaille(), this.getTaille()* puits.getProfondeur());
		}
		for (int i = 0; i<puits.getProfondeur(); i++) {
			g.drawLine(0, i*this.getTaille(), this.getTaille()* puits.getLargeur(), i*this.getTaille());
		}

		if (this.getVuePiece()!= null) {
			this.getVuePiece().afficherPiece(g2D);
		}
		if (this.getVueTas()!= null) {
			this.getVueTas().afficher(g2D);
		}
		

		g2D.dispose();
	}

	
	


	public VueTas getVueTas() {
		return vueTas;
	}

	public void setVueTas(VueTas vueTas) {
		this.vueTas = vueTas;
	}

	public Puits getPuits() {
		return this.puits;
	}
	public void setPuits(Puits puits) {
		this.puits = puits;
		this.setDimension(new Dimension(this.getTaille()*this.getPuits().getLargeur(), this.getTaille()*this.getPuits().getProfondeur()));
		setPreferredSize(this.getDimension()); 
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
		
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
		if (this.getPuits() != null) {
			this.setDimension(new Dimension(this.getTaille()*this.getPuits().getLargeur(), this.getTaille()*this.getPuits().getProfondeur()));
			setPreferredSize(this.getDimension()); 
		}
		
	}

	public VuePiece getVuePiece() {
		return vuePiece;
	}

	private void setVuePiece(VuePiece vuePiece) {
		this.vuePiece = vuePiece;
	}
	
	
	public void propertyChange(java.beans.PropertyChangeEvent event) {
		if (event.getPropertyName().equals(Puits.MODIFICATION_PIECE_ACTUELLE)) {
			setVuePiece(new VuePiece(this.getPuits().getPieceActuelle(), this.getTaille()));
		}
		if (event.getPropertyName().equals(Puits.MODIFICATION_TAS)) {
			this.repaint();
		}
	}
	
	
	
	
	
	
	
}
