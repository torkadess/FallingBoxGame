package fr.eseo.e3.poo.projet.blox.modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Puits {
	public static final int LARGEUR_PAR_DEFAUT = 10;
	public static final int PROFONDEUR_PAR_DEFAUT = 20;
	public static final String MODIFICATION_PIECE_ACTUELLE = "PieceActuelle";
	public static final String MODIFICATION_PIECE_SUIVANTE = "PieceSuivante";
	public static final String MODIFICATION_TAS = "Tas";
	
	private int profondeur;
	private int largeur; 
	private Piece pieceActuelle; 
	private Piece pieceSuivante; 
	private Tas tas; 
	

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this); 
	
	
	
	public Puits() {
		this(LARGEUR_PAR_DEFAUT ,PROFONDEUR_PAR_DEFAUT ); 
		
	}
	
	public Puits(int largeur, int profondeur) {
		this.setLargeur(largeur);
		this.setProfondeur(profondeur);
		this.tas = new Tas(this);
	}
	
	public Puits (int largeur, int profondeur, int nbElements, int nbLignes) {
		this.setLargeur(largeur);
		this.setProfondeur(profondeur);
		this.tas = new Tas(this, nbElements, nbLignes); 
	}
	

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	
	
	
	
	public void setPieceSuivante (Piece piece) {
		if (this.pieceSuivante != null ) {
			Piece oldPieceActuelle = this.getPieceActuelle();
			this.pieceActuelle = this.pieceSuivante; 
			this.pieceActuelle.setPuits(this);
			this.pieceActuelle.setPosition( this.getLargeur() / 2 ,-4 );
			pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE,oldPieceActuelle, this.getPieceActuelle());
		}
		Piece old2 = this.pieceSuivante;
		this.pieceSuivante = piece ; 
		pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE,old2,this.getPieceSuivante());
	}
	
	
	private void gererCollision() {
		this.getTas().ajouterElements(pieceActuelle);
		this.setPieceSuivante(UsineDePiece.genererPiece());
		this.tas.ligneComplete();
		pcs.firePropertyChange(MODIFICATION_TAS,1, this.tas);
	}
	
	public void gravite() {
		try {
		    this.pieceActuelle.deplacerDe(0, 1);
		} catch (BloxException e) {
		    if (e.getType() == BloxException.BLOX_COLLISION) {
		        this.gererCollision();
		    } else {
		        System.out.println(e.getMessage());
		    }
		}
		
	}

	
	public void setPieceActuelle(Piece pieceActuelle) {
		this.pieceActuelle = pieceActuelle;
	}

	public void setProfondeur(int profondeur) {
		if (profondeur < 15 || profondeur > 25) {
	         throw new IllegalArgumentException("Valeur de profondeur incorect ");
		}
		this.profondeur = profondeur;
	}

	public void setLargeur(int largeur) {
		// Test si la largeur et longueur respect bien les valeurs acceptés 
		if( largeur < 5 || largeur > 15 ) {
	         throw new IllegalArgumentException("Valeur de largeur incorect");
	    }
		this.largeur = largeur;
	}

	public Piece getPieceActuelle() {
		return pieceActuelle;
	}

	public Piece getPieceSuivante() {
		return pieceSuivante;
	}

	public int getProfondeur() {
		return profondeur;
	}

	public int getLargeur() {
		return largeur;
	}
	

	public Tas getTas() {
		return tas;
	}
	
	public void setTas(Tas tas) {
		this.tas = tas;
	}
	

	@Override
	public String toString() {
		String retour = "Puits : Dimension " + this.getLargeur() + " x " +this.getProfondeur() + "\n";
		retour += "Piece Actuelle : "; 
		if (this.getPieceActuelle() != null ) {
			retour += this.getPieceActuelle().toString();
		}
		else {
			retour += "<aucune>\n";
		}
		retour += "Piece Suivante : "; 
		if (this.getPieceSuivante() != null ) {
			retour += this.getPieceSuivante().toString();
		}
		else {
			retour += "<aucune>\n";
		}
		return retour; 
	}	
}
