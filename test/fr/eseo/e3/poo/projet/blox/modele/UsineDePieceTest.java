package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class UsineDePieceTest {
	@Test
	void testMode() {
		UsineDePiece.setMode(2);
		assertEquals(UsineDePiece.getMode(), UsineDePiece.ALEATOIRE_COMPLET ); 
		UsineDePiece.setMode(1);
		assertEquals(UsineDePiece.getMode(), UsineDePiece.ALEATOIRE_PIECE);
		UsineDePiece.setMode(0);
		assertEquals(UsineDePiece.getMode(), UsineDePiece.CYCLIC);
		
	} 
	 
	@Test
	void testModeFailed() {
		UsineDePiece.setMode(0);
		UsineDePiece.setMode(5);
		assertEquals(UsineDePiece.getMode(), 0); 
	}
	
	@Test
	void testGenererPieceALEATOIRECOMPLET() {
		UsineDePiece.setMode(2);
		Piece piece = UsineDePiece.genererPiece(); 
		assertEquals(piece.getElements().get(0).getCoordonnees(), new Coordonnees(2,3));
		int oPiece = 0, iPiece = 0,jPiece = 0,lPiece = 0, tPiece = 0, sPiece = 0, zPiece = 0;
		for (int i=0; i <10000; i++) { // on réalise 1000 essais pour contrer le aléatoire 
			piece = UsineDePiece.genererPiece(); 
			assertEquals(piece.getElements().get(0).getCoordonnees(), new Coordonnees(2,3));
			String className = piece.getClass().getSimpleName(); 
			
			switch (className) {
				case "IPiece" :	
					iPiece = 1 ;
					break;
				case "OPiece" :	
					oPiece = 1 ; 
					break;
				case "JPiece" :	
					jPiece = 1 ; 
					break;
				case "LPiece" :	
					lPiece = 1 ; 
					break;
				case "SPiece" :	
					sPiece = 1 ; 
					break;
				case "ZPiece" :	
					zPiece = 1 ; 
					break;
				case "TPiece" :	
					tPiece = 1 ; 
					break;
				
			}
		}
		assertEquals("IPIECE", 1, iPiece); 
		assertEquals("OPIECE", 1,oPiece);
		assertEquals("JPIECE", 1,jPiece);
		assertEquals("LPIECE", 1,lPiece);
		assertEquals("TPIECE", 1,tPiece);
		assertEquals("SPIECE", 1,sPiece);
		assertEquals("ZPIECE", 1,zPiece);
	}
	
	@Test
	void testGenererPieceALEATOIREPIECE() {
		UsineDePiece.setMode(1);
		Piece  piece; 
		int oPiece = 0, iPiece = 0,jPiece = 0,lPiece = 0, tPiece = 0, sPiece = 0, zPiece = 0;
		for (int i=0; i <10000; i++) { // on réalise 1000 essais pour contrer le aléatoire 
			piece = UsineDePiece.genererPiece(); 
			assertEquals(piece.getElements().get(0).getCoordonnees(), new Coordonnees(2,3));
			String className = piece.getClass().getSimpleName(); 
			
			switch (className) {
				case "IPiece" :	
					assertEquals(piece.getElements().get(0).getCouleur(), Couleur.ORANGE);
					iPiece = 1 ;
					break;
				case "OPiece" :	
					assertEquals(piece.getElements().get(0).getCouleur(), Couleur.ROUGE);
					oPiece = 1 ; 
					break;
				case "JPiece" :	
					assertEquals(piece.getElements().get(0).getCouleur(), Couleur.JAUNE);
					jPiece = 1 ; 
					break;
				case "LPiece" :	
					assertEquals(piece.getElements().get(0).getCouleur(), Couleur.VERT);
					lPiece = 1 ; 
					break;
				case "SPiece" :	
					assertEquals(piece.getElements().get(0).getCouleur(), Couleur.VIOLET);
					sPiece = 1 ; 
					break;
				case "ZPiece" :	
					assertEquals(piece.getElements().get(0).getCouleur(), Couleur.CYAN);
					zPiece = 1 ; 
					break;
				case "TPiece" :	
					assertEquals(piece.getElements().get(0).getCouleur(), Couleur.BLEU);
					tPiece = 1 ; 
					break;
				
			}
		}
		assertEquals("IPIECE", 1, iPiece); 
		assertEquals("OPIECE", 1,oPiece);
		assertEquals("JPIECE", 1,jPiece);
		assertEquals("LPIECE", 1,lPiece);
		assertEquals("TPIECE", 1,tPiece);
		assertEquals("SPIECE", 1,sPiece);
		assertEquals("ZPIECE", 1,zPiece);
	}
	
	@Test
	void testGenererPieceCYCLIC() {
		UsineDePiece.setMode(0);
		Piece piece; 
		for(int i=0; i<100; i++) {
			piece = UsineDePiece.genererPiece();
			assertEquals(piece.getClass().getSimpleName(), "OPiece"); 
			assertEquals(piece.getElements().get(0).getCouleur(), Couleur.ROUGE);
			assertEquals(piece.getElements().get(0).getCoordonnees(), new Coordonnees(2,3));
			piece = UsineDePiece.genererPiece();
			assertEquals(piece.getClass().getSimpleName(), "IPiece");
			assertEquals(piece.getElements().get(0).getCouleur(), Couleur.ORANGE);
			assertEquals(piece.getElements().get(0).getCoordonnees(), new Coordonnees(2,3));
			piece = UsineDePiece.genererPiece();
			assertEquals(piece.getClass().getSimpleName(), "TPiece");
			assertEquals(piece.getElements().get(0).getCouleur(), Couleur.BLEU);
			assertEquals(piece.getElements().get(0).getCoordonnees(), new Coordonnees(2,3));
			piece = UsineDePiece.genererPiece();
			assertEquals(piece.getClass().getSimpleName(), "LPiece");
			assertEquals(piece.getElements().get(0).getCouleur(), Couleur.VERT);
			assertEquals(piece.getElements().get(0).getCoordonnees(), new Coordonnees(2,3));
			piece = UsineDePiece.genererPiece();
			assertEquals(piece.getClass().getSimpleName(), "JPiece");
			assertEquals(piece.getElements().get(0).getCouleur(), Couleur.JAUNE);
			assertEquals(piece.getElements().get(0).getCoordonnees(), new Coordonnees(2,3));
			piece = UsineDePiece.genererPiece();
			assertEquals(piece.getClass().getSimpleName(), "ZPiece");
			assertEquals(piece.getElements().get(0).getCouleur(), Couleur.CYAN);
			assertEquals(piece.getElements().get(0).getCoordonnees(), new Coordonnees(2,3));
			piece = UsineDePiece.genererPiece();
			assertEquals(piece.getClass().getSimpleName(), "SPiece");
			assertEquals(piece.getElements().get(0).getCouleur(), Couleur.VIOLET);
			assertEquals(piece.getElements().get(0).getCoordonnees(), new Coordonnees(2,3));
			
			
		}
	}
}
