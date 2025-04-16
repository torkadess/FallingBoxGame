package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class PieceTest {

    private Piece piece;
    private Puits puits; 
    
    @BeforeEach
    public void setUp() {
        this.puits = new Puits(10, 20);
        piece = new IPiece(new Coordonnees(0, 0), Couleur.BLEU);
        piece.setPuits(puits);
    }
    @Test
    public void testSetPosition() {
        piece.setPosition(5, 7);
        assertEquals(new Coordonnees(5,7), piece.getElements().get(0).getCoordonnees());
        assertEquals(new Coordonnees(5,6), piece.getElements().get(1).getCoordonnees()); 
        assertEquals(new Coordonnees(5,5), piece.getElements().get(2).getCoordonnees());
        assertEquals(new Coordonnees(5,8), piece.getElements().get(3).getCoordonnees());    
    }
    
    @Test
    public void testSePuit() {
    	Puits puits2 = new Puits(12,15); 
    	this.piece.setPuits(puits2);
    	assertNotEquals(this.piece.getPuits(), puits); 
    	assertEquals(this.piece.getPuits(), puits2); 
    }
     
	
    
    @Test
    public void testDeplacerDe() throws BloxException {
        piece.setPosition(5, 7);
        piece.deplacerDe(1, 3);
    	assertEquals(new Coordonnees(6,10), piece.getElements().get(0).getCoordonnees());
        assertEquals(new Coordonnees(6,9), piece.getElements().get(1).getCoordonnees()); 
        assertEquals(new Coordonnees(6,8), piece.getElements().get(2).getCoordonnees());
        assertEquals(new Coordonnees(6,11), piece.getElements().get(3).getCoordonnees()); 
        
    }
    
    @Test
    public void testDeplacerDeInvalidArgument() {
        assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(0, -1));
        assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(2, 0));
        assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(-2, 0));
        assertThrows(IllegalArgumentException.class, () -> piece.deplacerDe(-2, -5));
    }
    
    @Test
    public void testDeplacerDe_ValidDeltaValues() throws BloxException {
        piece.getElements().get(0).setCoordonnees(new Coordonnees(0,this.puits.getProfondeur() - 1));
        int deltaX = 0;
        int deltaY = 1;
        assertThrows(fr.eseo.e3.poo.projet.blox.modele.BloxException.class,() -> piece.deplacerDe(deltaX, deltaY));
    }
    
    @Test
    public void testTourner() {
        piece.setPosition(5, 5);
        piece.tourner(true);
        assertEquals(new Coordonnees(5,5), piece.getElements().get(0).getCoordonnees());
        assertEquals(new Coordonnees(6,5), piece.getElements().get(1).getCoordonnees()); 
        assertEquals(new Coordonnees(7,5), piece.getElements().get(2).getCoordonnees());
        assertEquals(new Coordonnees(4,5), piece.getElements().get(3).getCoordonnees()); 
    }
    
    @Test
    public void testTournerBloxException() {
        Puits puits = new Puits(10, 15);
        piece.setPuits(puits);
        piece.setPosition(9, 14);
        assertEquals(new Coordonnees(9,14), piece.getElements().get(0).getCoordonnees());
        assertEquals(new Coordonnees(9,13), piece.getElements().get(1).getCoordonnees()); 
        assertEquals(new Coordonnees(9,12), piece.getElements().get(2).getCoordonnees());
        assertEquals(new Coordonnees(9,15), piece.getElements().get(3).getCoordonnees());
    }
    
    @Test
    public void testToString() {
        Piece piece = new IPiece(new Coordonnees(0,0), Couleur.BLEU); 
        String expected = "IPiece :\n" +
        	"	(0, 0) - BLEU\n" +
        	"	(0, -1) - BLEU\n" +
        	"	(0, -2) - BLEU\n" +
        	"	(0, 1) - BLEU\n";

        String actual = piece.toString();

        assertEquals(expected, actual);
    }
    

}
