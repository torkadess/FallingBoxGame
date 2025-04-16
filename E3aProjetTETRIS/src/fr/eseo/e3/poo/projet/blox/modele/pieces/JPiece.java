package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class JPiece extends Piece {
	public JPiece(Coordonnees coordonnees, Couleur couleur) {
		super(coordonnees, couleur);
		// TODO Auto-generated constructor stub
	} 
	
	

	protected void setElements(Coordonnees coordonnees, Couleur couleur) {
		int ordonnee = coordonnees.getOrdonnee();
		int abscisse = coordonnees.getAbscisse(); 
		if (this.getElements().size() == 0 ) {
			this.getElements().add(new Element(coordonnees, couleur)); 
			this.getElements().add(new Element(new Coordonnees(abscisse,ordonnee-1),   couleur));
			this.getElements().add(new Element(new Coordonnees(abscisse,ordonnee-2),   couleur));
			this.getElements().add(new Element(new Coordonnees(abscisse-1,ordonnee),   couleur));
		}
		else {
			this.getElements().set(0,new Element(coordonnees, couleur)); 
			this.getElements().set(1,new Element(new Coordonnees(abscisse,ordonnee-1),   couleur));
			this.getElements().set(2,new Element(new Coordonnees(abscisse,ordonnee-2),   couleur));
			this.getElements().set(3,new Element(new Coordonnees(abscisse-1,ordonnee),   couleur));
		}
		
	}
}
