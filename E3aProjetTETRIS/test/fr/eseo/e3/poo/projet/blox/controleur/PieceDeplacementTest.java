package fr.eseo.e3.poo.projet.blox.controleur;




import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacementTest {
    
    private PieceDeplacement pieceDeplacement;
    private VuePuits vuePuits;
    private Puits puits;
    private Piece piece;
    
    @BeforeEach
    public void setUp() {
    	Puits puits = new Puits(); 
    	this.puits = new Puits(); 
    	
		 this.vuePuits = new VuePuits(puits);
		 this.pieceDeplacement = new PieceDeplacement(this.vuePuits); 
    } 
    
    
    @Test
    public void testconstructeur() {
    	assertEquals("Erreur constructeur", this.puits, this.vuePuits.getPuits() ); 
    }
   
    
    
    
    
   
    
}
