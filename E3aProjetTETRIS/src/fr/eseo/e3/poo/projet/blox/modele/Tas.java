package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Random;

import javax.lang.model.util.Elements;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Tas {
	private Element[][] elements; 
	private Puits puits; 
	
	public Tas(Puits puits) {
		this.puits = puits; 
		this.elements = new Element[this.getPuits().getProfondeur()][this.getPuits().getLargeur()]; 
//		construireTas(20, 20/this.getPuits().getLargeur() + 1, new Random()); //construction d'un nouveau tas

	}
	
	public Tas(Puits puits, int nbElements) {
		this.puits = puits; 
		this.elements = new Element[this.getPuits().getProfondeur()][this.getPuits().getLargeur()]; 
		construireTas(nbElements, nbElements/this.getPuits().getLargeur() + 1, new Random()); //construction d'un nouveau tas

		
	}
	
	public Tas(Puits puits, int nbElements , int nbLignes) {
		this.puits = puits; 
		this.elements = new Element[this.getPuits().getProfondeur()][this.getPuits().getLargeur()]; 
		construireTas(nbElements, nbLignes, new Random()); //construction d'un nouveau tas
	}
	
	private void construireTas(int nbElements, int nbLignes, Random rand) {
		if (nbElements !=0 && nbElements>= this.puits.getLargeur() * nbLignes) {
			throw new IllegalArgumentException("Nombre d'element mauvais");
		}
		int nbElementsPlacer = 0; 
		int ordonnee, abscisse; 
		while (nbElementsPlacer < nbElements) {
			ordonnee = this.getPuits().getProfondeur() -  (rand.nextInt(nbLignes) + 1); ;  
			abscisse = rand.nextInt(this.getPuits().getLargeur());
		
			if (this.elements[ordonnee][abscisse] == null) {
				this.elements[ordonnee][abscisse] = new Element(new Coordonnees(abscisse, ordonnee), Couleur.values()[rand.nextInt(Couleur.values().length)]); 
				nbElementsPlacer = nbElementsPlacer + 1; 
			}
			
		}
		
	}
	
	
	public void ajouterElements(Piece piece)  {
		for (int i=0; i<piece.getElements().size(); i++) {
			int largeur = piece.getElements().get(i).getCoordonnees().getAbscisse();
			int profondeur = piece.getElements().get(i).getCoordonnees().getOrdonnee(); 
			this.elements[profondeur][largeur] = piece.getElements().get(i); 
		}
	}
	
	public void ligneComplete() {
	    int hauteur = this.elements.length;
	    int largeur = this.elements[0].length;
	    int ligneASupprimer = -1;

	    // Vérifier chaque ligne du tableau
	    for (int i = 0; i < hauteur; i++) {
	        boolean ligneComplete = true;

	        // Vérifier si la ligne contient uniquement des éléments non nuls
	        for (int j = 0; j < largeur; j++) {
	            if (this.elements[i][j] == null) {
	                ligneComplete = false;
	                break;
	            }
	        }

	        // Si la ligne est complète, marquer l'indice de la ligne à supprimer
	        if (ligneComplete) {
	            ligneASupprimer = i;
	            break;
	        }
	    }

	    // Supprimer la ligne et décaler les lignes du dessus
	    if (ligneASupprimer != -1) {
	        for (int i = ligneASupprimer; i > 0; i--) {
	        	this.elements[i] = this.elements[i - 1];
	        	for(int j = 0; j < this.elements[i].length ; j++) {
	        		if (this.elements[i][j]!=null)
	        			this.elements[i][j].deplacerDe(0, 1);
	        	}
	        }

	        // Remplir la première ligne avec des éléments nuls
	        for (int j = 0; j < largeur; j++) {
	        	this.elements[0][j] = null;
	        }
	    }
	}


	public Element[][] getElements() {
		return elements;
	}

	public Puits getPuits() {
		return puits;
	}


	
	
	
	
	
	
	
	
	
	
}
