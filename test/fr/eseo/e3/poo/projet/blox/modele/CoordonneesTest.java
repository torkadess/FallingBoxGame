package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;



public class CoordonneesTest {


	@Test
    public void testConstructeur() {
        Coordonnees coordonnees = new Coordonnees(10, 5);
        assertEquals(10, coordonnees.getAbscisse());
        assertEquals(5, coordonnees.getOrdonnee());

    }
    
    @Test
    public void testEquals() {
    	{
            Coordonnees c1 = new Coordonnees(0, 0);
            Coordonnees c2 = new Coordonnees(0, 0);
            Coordonnees c3 = new Coordonnees(1, 0);
            Coordonnees c4 = new Coordonnees(0, 1);

            Assertions.assertEquals(c1, c2); // c1 et c2 ont les mêmes coordonnées
            Assertions.assertEquals(c2, c1); // c2 et c1 ont les mêmes coordonnées (test de symétrie)
            Assertions.assertNotEquals(c1, c3); // c1 et c3 ont des coordonnées différentes
            Assertions.assertNotEquals(c1, c4); // c1 et c4 ont des coordonnées différentes
            Assertions.assertNotEquals(c3, c4); // c3 et c4 ont des coordonnées différentes
            Assertions.assertNotEquals(c4, c3); // c4 et c3 ont des coordonnées différentes (test de symétrie)
            Assertions.assertNotEquals(c1, null); // c1 n'est pas égal à null
            Assertions.assertNotEquals(c1, "Test"); // c1 n'est pas égal à une chaîne de caractères
        }
    }
    
    @Test
    public void testToString() 
    {
        Coordonnees coordonnees = new Coordonnees(10, 5);
        boolean result = coordonnees.toString().equals("Coordonnees [abscisse=10, ordonnee=5]"); 
        assertTrue(result); 
    }
    
    @Test
	public void testToStringNegatives() {
		Coordonnees coordonneesNegatives = new Coordonnees(-1, -2);
		assertEquals("(-1, -2)", coordonneesNegatives.toString());
	}
    
	@Test
	public void testGetAbscisse() {
		Coordonnees coordonnees = new Coordonnees(1, 2);
		assertEquals(1, coordonnees.getAbscisse());
	}
	
	public void testGetOrdonnee() {
		Coordonnees coordonnees = new Coordonnees(1, 2);
		assertEquals(2, coordonnees.getOrdonnee());
	}
	
	@Test
	public void testSetAbscisse() {
		Coordonnees coordonnees = new Coordonnees(1, 2);
		coordonnees.setAbscisse(3);
		assertEquals(3, coordonnees.getAbscisse());
	}
	
	@Test
	public void testSetOrdonnee() {
		Coordonnees coordonnees = new Coordonnees(1, 2);
		coordonnees.setOrdonnee(4);
		assertEquals(4, coordonnees.getOrdonnee());
	}
	
	@Test
	public void testHashCode() {
		Coordonnees coordonnees = new Coordonnees(1, 2);
		Coordonnees autreCoordonnees = new Coordonnees(1, 2);
		assertEquals(coordonnees.hashCode(), autreCoordonnees.hashCode());
	}
    
    
    
    
}