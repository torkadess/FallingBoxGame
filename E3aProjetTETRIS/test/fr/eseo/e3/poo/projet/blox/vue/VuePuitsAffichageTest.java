package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;

public class VuePuitsAffichageTest  {
	
	
	private void testConstructeurPuits() { 
		 Puits puits = new Puits(15,25); 
		 /*** Creation des JPanel  ***/
		 JFrame frame = new JFrame("Puits"); 
		 VuePuits vuePuits = new VuePuits(puits);
		 
		 PanneauInformation panneau = new PanneauInformation(puits);
		 JPanel pannelEst = new JPanel(); 
		 
		 Gravite gravite = new Gravite(vuePuits); 
		 
		 UsineDePiece.setMode(0);
		 puits.setPieceSuivante(UsineDePiece.genererPiece());
		 puits.setPieceSuivante(UsineDePiece.genererPiece());
		 
		 

		 pannelEst.add(panneau, BorderLayout.NORTH); 
		 frame.add(vuePuits, BorderLayout.WEST);
		 frame.add(pannelEst, BorderLayout.EAST);
		 frame.setSize((int ) vuePuits.getDimension().getWidth() + 100, (int) vuePuits.getDimension().getHeight() + 170);
		 frame.setVisible(true); 
		 
	 }
	
	private void testConstructeurPuitsTaille() {
		
		 Puits puits = new Puits(15,25); 
		 /*** Creation des JPanel  ***/
		 JFrame jFrame = new JFrame("Puits et taille"); 
		 VuePuits vuePuits = new VuePuits(puits,10);
		 PanneauInformation panneau = new PanneauInformation(puits);
		 JPanel pannelEst = new JPanel(); 
		 
		 Gravite gravite = new Gravite(vuePuits); 
		 
		 puits.addPropertyChangeListener(vuePuits);
		 UsineDePiece.setMode(0);
		 puits.setPieceSuivante(UsineDePiece.genererPiece());
		 puits.setPieceSuivante(UsineDePiece.genererPiece());
		 
		 

		 pannelEst.add(panneau, BorderLayout.NORTH); 
		 jFrame.add(vuePuits, BorderLayout.WEST);
		 jFrame.add(pannelEst, BorderLayout.EAST);
		 jFrame.setSize((int ) vuePuits.getDimension().getWidth() + 100, (int) vuePuits.getDimension().getHeight() + 170);
		 jFrame.setVisible(true);  
		 
	 }
	 
	 public static void main(String args[]) {
		 VuePuitsAffichageTest test = new VuePuitsAffichageTest(); 
		 test.testConstructeurPuits(); 
		 test.testConstructeurPuitsTaille();
	 }
}
