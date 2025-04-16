package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.JPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.LPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.SPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.TPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.ZPiece;

public class UsineDePiece {
	public static final int ALEATOIRE_COMPLET = 2; 
	public static final int ALEATOIRE_PIECE = 1; 
	public static final int CYCLIC = 0;
	
	public static int modePartie = 0; 
	static int choixPiece = 0 ;
	
	private UsineDePiece() {
		
	}
	
	public static Piece genererPiece() {
		Piece piece = null;  
		switch (modePartie) {
			case ALEATOIRE_COMPLET : 
				piece = genererPieceAleatoireComplet(piece); 
				break;
			case ALEATOIRE_PIECE : 
				piece = genererPieceAleatoirePiece(piece); 
				break;
			case CYCLIC : 
				piece = genererPieceCyclic(piece); 				
				break;
		}
		return piece;  
	}
	
	private static Piece genererPieceCyclic(Piece piece) {
		switch (choixPiece) {
		case 0 :
			piece = new OPiece (new Coordonnees(2,3), Couleur.ROUGE); 
			choixPiece +=1; 
			break; 
		case 1 : 
			piece = new IPiece (new Coordonnees(2,3), Couleur.ORANGE); 
			choixPiece+=1; 
			break; 
		case 2 : 
			piece = new TPiece (new Coordonnees(2,3), Couleur.BLEU); 
			choixPiece+=1; 
			break; 
		case 3 : 
			piece = new LPiece (new Coordonnees(2,3), Couleur.VERT); 
			choixPiece+=1; 
			break; 
		case 4 : 
			piece = new JPiece (new Coordonnees(2,3), Couleur.JAUNE); 
			choixPiece+=1; 
			break; 
		case 5 : 
			piece = new ZPiece (new Coordonnees(2,3), Couleur.CYAN); 
			choixPiece+=1; 
			break;
		case 6 : 
			piece = new SPiece (new Coordonnees(2,3), Couleur.VIOLET);
			choixPiece = 0; 
			break;
		} 
		return piece; 
	}
	private static Piece genererPieceAleatoireComplet(Piece piece) {
		Couleur couleurAleatoire = couleurAleatoire(); 
		choixPiece = new Random().nextInt(7);
		switch (choixPiece) {
			case 0 :
				piece = new OPiece (new Coordonnees(2,3), couleurAleatoire); 
				break; 
			case 1 : 
				piece = new IPiece (new Coordonnees(2,3), couleurAleatoire); 
				break;
			case 2 : 
				piece = new TPiece (new Coordonnees(2,3), couleurAleatoire); 
				break;
			case 3 : 
				piece = new LPiece (new Coordonnees(2,3), couleurAleatoire); 
				break; 
			case 4 : 
				piece = new JPiece (new Coordonnees(2,3), couleurAleatoire); 
				break; 
			case 5 : 
				piece = new ZPiece (new Coordonnees(2,3), couleurAleatoire); 

				break; 
			case 6 : 
				piece = new SPiece (new Coordonnees(2,3), couleurAleatoire); 
				break; 


				
		}
		return piece; 
	}
	
	private static Piece genererPieceAleatoirePiece(Piece piece) {
		choixPiece = new Random().nextInt(7);
		switch (choixPiece) {
			case 0 :
				piece = new OPiece (new Coordonnees(2,3), Couleur.ROUGE); 
				break; 
			case 1 : 
				piece = new IPiece (new Coordonnees(2,3), Couleur.ORANGE); 
				break; 
			case 2 : 
				piece = new TPiece (new Coordonnees(2,3), Couleur.BLEU); 
				break;
			case 3 : 
				piece = new LPiece (new Coordonnees(2,3), Couleur.VERT); 
				break; 
			case 4 : 
				piece = new JPiece (new Coordonnees(2,3), Couleur.JAUNE); 
				break;
			case 5 : 
				piece = new ZPiece (new Coordonnees(2,3), Couleur.CYAN); 
				break;
			case 6 : 
				piece = new SPiece (new Coordonnees(2,3), Couleur.VIOLET); 
				break; 

		}
		return piece; 
	}

	public static Couleur couleurAleatoire() {
	    return Couleur.values()[new Random().nextInt(Couleur.values().length)];
	}
	
	public static void setMode (int mode) {
		switch (mode) {
		case ALEATOIRE_COMPLET : 
			modePartie = ALEATOIRE_COMPLET ;
			break; 
		case ALEATOIRE_PIECE : 
			modePartie = ALEATOIRE_PIECE ;
			break; 
		case CYCLIC : 
			modePartie = CYCLIC; 
			choixPiece = 0; 
			break; 
		}
	}
	public static int getMode() {
		return modePartie;
	}

	
}
