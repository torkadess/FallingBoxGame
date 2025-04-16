package fr.eseo.e3.poo.projet.blox.modele.pieces;


import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;


public class OPieceTest {
	

    @Test
    public void testGetElements() {
    	Coordonnees coordonnees = new Coordonnees(0, 0);
        Couleur couleur = Couleur.ROUGE;
        Piece oPiece = new OPiece(coordonnees, couleur);
        assertEquals(4, oPiece.getElements().size());
    }
    
    
    
    public void testSetElements() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        Couleur couleur = Couleur.VERT;
        OPiece oPiece = new OPiece(coordonnees, couleur);
        Element element1 = new Element(new Coordonnees(0, 0), Couleur.ROUGE);
        Element element2 = new Element(new Coordonnees(1, 0), Couleur.ROUGE);
        Element element3 = new Element(new Coordonnees(0, 1), Couleur.ROUGE);
        Element element4 = new Element(new Coordonnees(1, 1), Couleur.ROUGE);

        assertTrue(oPiece.getElements().containsAll(
                Arrays.asList(element1, element2, element3, element4)));
    }
}
