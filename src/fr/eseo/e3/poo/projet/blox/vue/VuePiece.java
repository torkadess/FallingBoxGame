package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Rectangle;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePiece {
	public static final double MULTIPLIER_TEINTE = 0.5;
	private int taille;
	private final Piece piece; 
	
	public VuePiece(Piece piece, int taille) {
		this.piece = piece;
		this.setTaille(taille); 
		
	}
	
	public Color teinte(Color couleur) {
		int r = couleur.getRed();
		int g = couleur.getGreen();
		int b = couleur.getBlue();
		r = (int) (r + (255-r)*MULTIPLIER_TEINTE) ;
		b = (int) (b + (255-b)*MULTIPLIER_TEINTE); 
		g = (int) (g + (255-g)*MULTIPLIER_TEINTE); 
		return new Color(r,g,b);
	}

	
	public void afficherPiece(java.awt.Graphics2D g2D) {
		Element element; 
		for (int i=0; i < this.getPiece().getElements().size(); i++) {
			
			element = this.getPiece().getElements().get(i);
			if (element.getCoordonnees().getOrdonnee() > 0) {			
				if (i==0) {
					g2D.setColor(teinte(element.getCouleur().getCouleurPourAffichage()));
				}
				else {
					g2D.setColor(element.getCouleur().getCouleurPourAffichage());
				}
				g2D.fill3DRect(element.getCoordonnees().getAbscisse()*taille,element.getCoordonnees().getOrdonnee()*taille ,this.getTaille(),this.getTaille(),true);
				}
		}
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}
	public int getTaille() {
		return this.taille;
	}
	private Piece getPiece() {
		return this.piece;
	}
	
	

}
