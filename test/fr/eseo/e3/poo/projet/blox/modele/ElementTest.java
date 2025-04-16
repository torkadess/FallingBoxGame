package fr.eseo.e3.poo.projet.blox.modele;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ElementTest {
	
	
	
	@Test
	public void testConstructeur1() 
	{
		Element element = new Element(new Coordonnees(1,0)); 
		assertEquals(1,element.getCoordonnees().getAbscisse());
		assertEquals(Couleur.ROUGE, element.getCouleur()); 
	}
	
	@Test
	public void testConstructeur2() 
	{
		Element element = new Element(1,2); 
		assertEquals(1,element.getCoordonnees().getAbscisse());
		assertEquals(Couleur.ROUGE, element.getCouleur()); 
	}
	
	@Test
	public void testConstructeur3() 
	{
		Element element = new Element(new Coordonnees(1,0), Couleur.ORANGE); 
		assertEquals(1,element.getCoordonnees().getAbscisse());
		assertEquals(Couleur.ORANGE, element.getCouleur()); 
	}
	
	@Test
	public void testConstructeur4() 
	{
		Element element = new Element(10,1, Couleur.ROUGE); 
		assertEquals(10,element.getCoordonnees().getAbscisse());
		assertEquals(1,element.getCoordonnees().getOrdonnee());
		assertEquals(Couleur.ROUGE, element.getCouleur()); 
	}
	
	@Test
    void testEquals() {
        Element e1 = new Element(new Coordonnees(1, 2), Couleur.ROUGE);
        Element e2 = new Element(new Coordonnees(1, 2), Couleur.ROUGE);
        Element e3 = new Element(new Coordonnees(1, 3), Couleur.ROUGE);
        Element e4 = new Element(new Coordonnees(1, 2), Couleur.VERT);
        
        assertTrue(e1.equals(e1)); // reflexive
        assertFalse(e1.equals(null)); // null check
        assertFalse(e1.equals(new Object())); // type check
        assertTrue(e1.equals(e2)); // equals
        assertFalse(e1.equals(e3)); // different coordonnees
        assertFalse(e1.equals(e4)); // different couleur
    }
	
	@Test
    void testHashCode() {
        Element e1 = new Element(new Coordonnees(1, 2), Couleur.ROUGE);
        Element e2 = new Element(new Coordonnees(1, 2), Couleur.ROUGE);
        Element e3 = new Element(new Coordonnees(2, 2), Couleur.ROUGE);
        assertEquals(e1.hashCode(), e2.hashCode()); 
        assertNotEquals(e1.hashCode(), e3.hashCode());
	}
	
	@Test
	void testtoString() {
		Element e1 = new Element(new Coordonnees(1, 2), Couleur.ROUGE);
		String toStringe1 = "(1, 2) - ROUGE";
		assertEquals(toStringe1, e1.toString());
	}
	
	
	@Test
	void testGetCoordonnees() {
		
	}
	
	@Test
	void testDeplacerDe() {
		Element element = new Element(new Coordonnees(10,10)) ; 
		element.deplacerDe(5, 0);
		Coordonnees coo = new Coordonnees(15,10); 
		assertEquals(coo, element.getCoordonnees());
	}
	
	
	
}
