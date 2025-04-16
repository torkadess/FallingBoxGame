package fr.eseo.e3.poo.projet.blox.modele.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public abstract class Piece {
	
	private List<Element> elements; 
	private Puits puits; 
	
	
	public Piece(Coordonnees coordonnees, Couleur couleur) {
		elements = new ArrayList<Element>();
		this.setElements(coordonnees, couleur);
		
	}
	
	protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

	public List<Element> getElements() {
		return elements;
	} 
	
	public void setPosition(int abscisse, int ordonnee) {
		this.setElements(new Coordonnees(abscisse, ordonnee), this.getElements().get(0).getCouleur());
	}
	
	public void deplacerDe(int deltaX, int deltaY) throws BloxException {
		if (deltaX > 1 || deltaX <-1 ) {
			throw new IllegalArgumentException("DeltaX mauvais");
		}
		if (deltaY<0 ) {
			throw new IllegalArgumentException("DeltaY mauvais");
		}
		String deplacement;
		deplacement = "valide"; 
		int abscisse, ordonnee; 
		
		if (this != null) {
			// boucle qui test si une pièce peut être deplacerDe
			for (int i=0; i<this.elements.size(); i++) {
				abscisse = elements.get(i).getCoordonnees().getAbscisse() + deltaX;
				ordonnee = elements.get(i).getCoordonnees().getOrdonnee() + deltaY;
//				si un element atteint le fond du puits
				if (this.puits != null && ordonnee >= this.getPuits().getProfondeur()) {
					deplacement = "collision";
				}	   
//				Si un élément sort du puits
				else if (this.puits != null && (abscisse < 0 || abscisse >= this.getPuits().getLargeur())) {
					deplacement = "sortie";
	            }
// 			    si un élément rentre en collision avec un autre element
				else if (this.puits != null && this.getPuits().getPieceActuelle().getElements().get(i).getCoordonnees().getOrdonnee()>=0 ) {
					if (this.getPuits().getTas().getElements()[ordonnee][abscisse] != null) {
						deplacement = "collision";
			        }
				}
			
			} 
			if (deplacement.equals("valide")) {
				for (int i=0; i<this.elements.size(); i++) {
					this.elements.get(i).deplacerDe(deltaX, deltaY);	
				} 
			}else {
				if (deplacement.equals("collision")) {
					throw new BloxException("Collision d'un element", BloxException.BLOX_COLLISION);

				}
				else {
					throw new BloxException("Un element sort du puits", BloxException.BLOX_SORTIE_PUITS);

				}
			}
			 
		}
	} 
		
		
	
	
	public  void tourner(boolean sensHoraire) {
		// sauvegarde des coo initiales
		List<Coordonnees> coordonneesInitiales = new ArrayList<>();
		for (Element element : this.getElements()) {
	        coordonneesInitiales.add(new Coordonnees(element.getCoordonnees().getAbscisse(), element.getCoordonnees().getOrdonnee()));
	    }
		
	    Coordonnees coo = this.getElements().get(0).getCoordonnees();
	    for (int i = 1; i < this.getElements().size(); i++) {
	        Element element = this.getElements().get(i);
	        element.deplacerDe(-coo.getAbscisse(), -coo.getOrdonnee());
	    }
		try {
		    int x, y;
		    for (int i = 1; i < this.getElements().size(); i++) {
		        Element element = this.getElements().get(i);

		        if (sensHoraire) {
		            x = -element.getCoordonnees().getOrdonnee();
		            y = element.getCoordonnees().getAbscisse();
		        } else {
		            y = -element.getCoordonnees().getAbscisse();
		            x = element.getCoordonnees().getOrdonnee();
		        }

		        Coordonnees nouvelleCoordonnees = new Coordonnees(x, y);
		        int abscisse = nouvelleCoordonnees.getAbscisse() + coo.getAbscisse() ;
				int ordonnee = nouvelleCoordonnees.getOrdonnee() + coo.getOrdonnee();
//				si un element atteint le fond du puits
				if (this.puits != null && ordonnee >= this.getPuits().getProfondeur()) {
					throw new BloxException("un des Element est trop profond", BloxException.BLOX_COLLISION);
				}	   
//				 Si un élément sort du puits
				if (this.puits != null && (abscisse < 0 || abscisse >= this.getPuits().getLargeur())) {
					throw new BloxException("Un element sort du puits", BloxException.BLOX_SORTIE_PUITS);
	            }
//				 si un élément rentre en collision avec un autre element
				if (ordonnee>= 0 ) {
					if (this.puits != null && this.getPuits().getTas().getElements()[ordonnee][abscisse] != null) {
						throw new BloxException("Collision d'un element", BloxException.BLOX_COLLISION);
			        }
					
				}
				

		        element.setCoordonnees(nouvelleCoordonnees);
		    }

		    for (int i = 1; i < this.getElements().size(); i++) {
		        Element element = this.getElements().get(i);
		        element.deplacerDe(coo.getAbscisse(), coo.getOrdonnee());
		    }
		} catch (Exception e) {
			// Réinitialiser les coordonnées de tous les éléments à leurs positions initiales
            for (int j = 1; j < this.getElements().size(); j++) {
                Element elem = this.getElements().get(j);
                Coordonnees initCoordonnees = coordonneesInitiales.get(j);
                elem.setCoordonnees(new Coordonnees(initCoordonnees.getAbscisse(), initCoordonnees.getOrdonnee()));
            }
		    // Gérer l'exception BloxException ici
		    System.out.println("TOURNER  : " + e.getMessage());
		}
	}
	
	@Override
	public String toString() {
		String retour = getClass().getSimpleName() + " :"; 
		Element element;
		for(int i = 0 ; i < elements.size(); i++) {
			element = elements.get(i); 
			retour += "\n" + "	" + element.toString();
		}
		retour += "\n";
		return retour; 
	}

	public Puits getPuits() {
		return puits;
	}

	public void setPuits(Puits puits) {
		this.puits = puits;
	}
	
	
	
}
