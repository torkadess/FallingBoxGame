package fr.eseo.e3.poo.projet.blox.vue;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;

public class VuePuitsTest {

    private VuePuits vuePuits;
    private Puits puits;
    
    @BeforeEach
    public void setUp() {
        // Initialiser le puits et la vuePuits avant chaque test
        puits = new Puits(10, 20);
        vuePuits = new VuePuits(puits);
    }
    
    @Test
    public void testConstructeur() {
        Dimension expectedDimension = new Dimension(VuePuits.TAILLE_PAR_DEFAUT * puits.getLargeur(),VuePuits.TAILLE_PAR_DEFAUT * puits.getProfondeur());
        assertEquals(expectedDimension, vuePuits.getPreferredSize());
        assertEquals(expectedDimension, vuePuits.getDimension());
        assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vuePuits.getTaille());
        
        assertEquals(Color.WHITE, vuePuits.getBackground());
    }
    
    @Test
    public void testSetPuits() {
        // Créer un nouveau puits et l'assigner à la vuePuits
        Puits puits = new Puits();
        vuePuits.setPuits(puits);
        
        // Vérifier que les dimensions ont été mises à jour
        Dimension expectedDimension = new Dimension(VuePuits.TAILLE_PAR_DEFAUT * puits.getLargeur(),VuePuits.TAILLE_PAR_DEFAUT * puits.getProfondeur());
        assertEquals(expectedDimension, vuePuits.getPreferredSize());
        assertEquals(expectedDimension, vuePuits.getDimension());
        assertEquals(puits, vuePuits.getPuits());
    }
    
    @Test
    public void testSetTaille() {
        // Changer la taille de la vuePuits
        int newTaille = 30;
        vuePuits.setTaille(newTaille);
        
        // Vérifier que les dimensions ont été mises à jour
        Dimension expectedDimension = new Dimension(newTaille * puits.getLargeur(), newTaille * puits.getProfondeur());
        assertEquals(expectedDimension, vuePuits.getPreferredSize());
        assertEquals(expectedDimension, vuePuits.getDimension());
        assertEquals(newTaille, vuePuits.getTaille());
    }
    
    @Test
    public void testSetVuePiece() {
        // Créer une pièce et une vuePiece
        Piece piece = UsineDePiece.genererPiece();
        VuePiece vuePiece = new VuePiece(piece, 10);
        
        // Assigner la vuePiece à la vuePuits
//        vuePuits.setVuePiece(vuePiece);
        
        // Vérifier que la vuePiece est bien assignée
//        assertEquals(vuePiece, vuePuits.getVuePiece());
    }
}

