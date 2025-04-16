package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;

public class VueTas {
	private VuePuits vuePuits; 
	private Tas tas;
	public static final double MULTIPLIER_NUANCE = 0.7; 
	
	
	public VueTas(VuePuits vuePuits) {
		this.vuePuits = vuePuits; 
		this.tas = this.getVuePuits().getPuits().getTas();
	}
	
	public Color nuance(Color couleur) {
		int r = couleur.getRed();
		int g = couleur.getGreen();
		int b = couleur.getBlue();
		r = (int) (r*(1-MULTIPLIER_NUANCE)) ;
		b = (int) (b*(1-MULTIPLIER_NUANCE)) ;
		g = (int) (g*(1-MULTIPLIER_NUANCE)) ;
		return new Color(r,g,b);
	}
	
	public void afficher(Graphics2D g2D) {

		Element element; 
		int taille = this.getVuePuits().getTaille(); 
		for(int i = 0; i<this.tas.getElements().length; i++) {
			for(int j = 0; j<tas.getElements()[i].length; j ++) {
				if (tas.getElements()[i][j] != null) {
//					System.out.print("X"); 
					element = tas.getElements()[i][j]; 
					g2D.setColor(nuance(element.getCouleur().getCouleurPourAffichage()));
					g2D.fill3DRect(element.getCoordonnees().getAbscisse()*taille,element.getCoordonnees().getOrdonnee()*taille ,taille,taille,true);
				}
//				else { System.out.print("."); } 
				
			}
//			System.out.println(""); 
		}
//		System.out.println(""); 
	}
	
	
	public VuePuits getVuePuits() {
		return this.vuePuits; 
	}
	
}
