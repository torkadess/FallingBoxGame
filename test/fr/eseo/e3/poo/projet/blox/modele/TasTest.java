package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;

public class TasTest {

    private Tas tas;
    private Puits puits;
    
    @BeforeEach
    public void setUp() {
        puits = new Puits(10, 20);
        tas = new Tas(puits);
    }
    
    @Test
    public void testConstructeur() {
        Element[][] elements = tas.getElements();
        
        // Vérifier que la taille du tas correspond à la taille du puits
        assertEquals(puits.getProfondeur(), elements.length);
        assertEquals(puits.getLargeur(), elements[0].length);
        
        // Vérifier que tous les éléments du tas sont initialisés à null
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                assertNull(elements[i][j]);
            }
        }
        
        // Vérifier que le puits est correctement assigné
        assertEquals(puits, tas.getPuits());
    }
    
    @Test
    public void testConstruireTas() {
        int nbElements = 20;
        int nbLignes = 3;
        tas = new Tas(puits, nbElements, nbLignes); 
        
        Element[][] elements = tas.getElements();
        
        // Vérifier que le nombre d'éléments placés correspond à nbElements
        int nbElementsPlacer = 0;
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                if (elements[i][j] != null) {
                    nbElementsPlacer++;
                }
            }
        }
        assertEquals(nbElements, nbElementsPlacer);
        
        // Vérifier que le nombre de lignes utilisées est inférieur ou égal à nbLignes
        int nbLignesUtilisees = 0;
        for (int i = 0; i < elements.length; i++) {
            boolean ligneUtilisee = false;
            for (int j = 0; j < elements[i].length; j++) {
                if (elements[i][j] != null) {
                    ligneUtilisee = true;
                    break;
                }
            }
            if (ligneUtilisee) {
                nbLignesUtilisees++;
            }
        }
        assertTrue(nbLignesUtilisees == nbLignes);
    }
    
    @Test
    public void testConstruireTasInvalidArgument() {
        int nbElements = 100;
        int nbLignes = 10;
        
        assertThrows(IllegalArgumentException.class, () -> tas = new Tas(this.puits, nbElements, nbLignes));
    }
}
