package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class IPieceTest {
	private IPiece iPiece;
    private Coordonnees coordonnees;
    private Couleur couleur;
    
    @BeforeEach
    void setUp() throws Exception {
        coordonnees = new Coordonnees(0, 0);
        couleur = Couleur.ROUGE;
        iPiece = new IPiece(coordonnees, couleur);
    }

    @Test
    public void testSetElements() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        Couleur couleur = Couleur.VERT;
        Piece iPiece = new IPiece(coordonnees, couleur);
        Element element1 = new Element(new Coordonnees(0, 0), Couleur.ROUGE);
        Element element2 = new Element(new Coordonnees(1, 0), Couleur.ROUGE);
        Element element3 = new Element(new Coordonnees(0, 1), Couleur.ROUGE);
        Element element4 = new Element(new Coordonnees(1, 1), Couleur.ROUGE);

        assertTrue(iPiece.getElements().containsAll(
                Arrays.asList(element1, element2, element3, element4)));
    }
    

    @Test
    @DisplayName("Test getElements")
    void testGetElements() {
        assertEquals(4, iPiece.getElements().size());
        assertEquals(new Element(new Coordonnees(0, 0), couleur), iPiece.getElements().get(0));
        assertEquals(new Element(new Coordonnees(0, -1), couleur), iPiece.getElements().get(1));
        assertEquals(new Element(new Coordonnees(0, -2), couleur), iPiece.getElements().get(2));
        assertEquals(new Element(new Coordonnees(0, 1), couleur), iPiece.getElements().get(3));
    }
    
    @Test
    @DisplayName("Test setPosition")
    void testSetPosition() {
        iPiece.setPosition(2, 3);
        assertEquals(new Coordonnees(2, 3), iPiece.getElements().get(0).getCoordonnees());
    }
    
}
