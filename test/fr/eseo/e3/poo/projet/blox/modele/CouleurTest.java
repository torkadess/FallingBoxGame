package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import java.awt.Color;

public class CouleurTest {

    @Test
    public void testCouleurPourAffichage() {
        assertEquals(Color.RED, Couleur.ROUGE.getCouleurPourAffichage());
        assertEquals(Color.ORANGE, Couleur.ORANGE.getCouleurPourAffichage());
        assertEquals(Color.BLUE, Couleur.BLEU.getCouleurPourAffichage());
        assertEquals(Color.GREEN, Couleur.VERT.getCouleurPourAffichage());
        assertEquals(Color.YELLOW, Couleur.JAUNE.getCouleurPourAffichage());
        assertEquals(Color.CYAN, Couleur.CYAN.getCouleurPourAffichage());
        assertEquals(Color.MAGENTA, Couleur.VIOLET.getCouleurPourAffichage());
    }
    
    @Test
    public void testCouleurEnum() {
        assertEquals(Couleur.ROUGE, Couleur.valueOf("ROUGE"));
        assertEquals(Couleur.ORANGE, Couleur.valueOf("ORANGE"));
        assertEquals(Couleur.BLEU, Couleur.valueOf("BLEU"));
        assertEquals(Couleur.VERT, Couleur.valueOf("VERT"));
        assertEquals(Couleur.JAUNE, Couleur.valueOf("JAUNE"));
        assertEquals(Couleur.CYAN, Couleur.valueOf("CYAN"));
        assertEquals(Couleur.VIOLET, Couleur.valueOf("VIOLET"));
    }
    
}

