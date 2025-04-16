package fr.eseo.e3.poo.projet.blox.modele;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PuitsTest {
	@Test
	void testConstructeurParDefaut() {
		Puits puits = new Puits();
		assertEquals(Puits.LARGEUR_PAR_DEFAUT, puits.getLargeur());
		assertEquals(Puits.PROFONDEUR_PAR_DEFAUT, puits.getProfondeur());
		assertNull(puits.getPieceActuelle());
		assertNull(puits.getPieceSuivante());
	} 
	
	
	@Test
	void testConstructeurAvecParametresValides() {
		int largeur = 8;
		int profondeur = 20;
		Puits puits = new Puits(largeur, profondeur);
		assertEquals(largeur, puits.getLargeur());
		assertEquals(profondeur, puits.getProfondeur());
		assertNull(puits.getPieceActuelle());
		assertNull(puits.getPieceSuivante());
	}
	
	@Test
	void testConstructeurAvecParametresInvalides() {
		assertThrows(IllegalArgumentException.class, () -> new Puits(4, 25));
		assertThrows(IllegalArgumentException.class, () -> new Puits(15, 26));
		assertThrows(IllegalArgumentException.class, () -> new Puits(15, 14));
		assertThrows(IllegalArgumentException.class, () -> new Puits(16,26 ));
		assertThrows(IllegalArgumentException.class, () -> new Puits(16,14 ));
		assertThrows(IllegalArgumentException.class, () -> new Puits( 4,14 ));
		assertThrows(IllegalArgumentException.class, () -> new Puits( 4,26 ));
	}
	
	@Test
	void testSetPieceSuivante() {
		Puits puits = new Puits();
		Piece piece = new OPiece(new Coordonnees(0,0), Couleur.BLEU);
		Piece piece2 = new OPiece(new Coordonnees(1,1), Couleur.ROUGE);
		Piece pieceCur = new OPiece(new Coordonnees(2,2), Couleur.ORANGE);
		puits.setPieceSuivante(piece);
		assertNull(puits.getPieceActuelle());
		assertEquals(piece, puits.getPieceSuivante());
		puits.setPieceActuelle(pieceCur);
		puits.setPieceSuivante(piece2);
		assertEquals(piece, puits.getPieceActuelle());
		assertEquals(piece2, puits.getPieceSuivante());	
	}
	
	@Test
	void testGetPiecesuivante() {
		Puits puits = new Puits();
		Piece piece = new OPiece(new Coordonnees(0,0), Couleur.BLEU);
		puits.setPieceSuivante(piece);
		assertEquals(piece, puits.getPieceSuivante());	
	}
	
	
	@Test
    public void testSetProfondeurValeurIncorrecte() {
		Puits puits = new Puits();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            puits.setProfondeur(14);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            
			puits.setProfondeur(26);
        });
    }
	
	@Test
    public void testSetLargeurValeurIncorrecte() {
		Puits puits = new Puits(); 
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            puits.setLargeur(4);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            puits.setLargeur(16);
        });
    }
	

	@Test
	void testSetPieceActuelle() {
		Puits puits = new Puits(); 
		Piece piece = new IPiece(new Coordonnees(0,0), Couleur.ROUGE) ; 
		puits.setPieceActuelle(piece);
		assertEquals(puits.getPieceActuelle(), piece);
	}
	
	

	@Test
    public void testToStringPuitsVide() {
		Puits puits = new Puits();
        String expectedString = "Puits : Dimension 10 x 20\n" + 
                                "Piece Actuelle : <aucune>\n" +
                                "Piece Suivante : <aucune>\n";
        String actualString = puits.toString();
        assertEquals(expectedString, actualString);
    }
	
	
	@Test
    public void testToStringAvecPieces() {
		Puits puits = new Puits(); 
        Piece pieceActuelle = new IPiece(new Coordonnees(1, 1), Couleur.BLEU);
        Piece pieceSuivante = new OPiece(new Coordonnees(0, 0), Couleur.ROUGE);
        puits.setPieceSuivante(pieceActuelle);
        puits.setPieceSuivante(pieceSuivante);
        String expectedString = "Puits : Dimension 10 x 20\n" + 
                                "Piece Actuelle : " + pieceActuelle.toString() +
                                "Piece Suivante : " + pieceSuivante.toString();
        String actualString = puits.toString();
        assertEquals(expectedString, actualString);
    }
	

	
	
	
	
	
}