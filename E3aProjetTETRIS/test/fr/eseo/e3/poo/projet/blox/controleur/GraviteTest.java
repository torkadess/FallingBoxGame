package fr.eseo.e3.poo.projet.blox.controleur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.Timer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

class GraviteTest {

    private Gravite gravite;
    private VuePuits vuePuits;
    private Puits puits;

    @BeforeEach
    void setUp() {
    	puits = new Puits(); 
    	vuePuits = new VuePuits(puits);
        gravite = new Gravite(vuePuits);
    }

    @Test
    void testGetPeriodicite() {
        int periodicite = gravite.getPeriodicite();
        assertEquals(500, periodicite);
    }

    @Test
    void testSetPeriodicite() {
        gravite.setPeriodicite(1000);
        assertEquals(gravite.getPeriodicite(), 1000); 
    }
    
    @Test
    void testconstructeur() {
    	assertTrue(this.puits !=null) ;
    	assertEquals(this.vuePuits.getPuits(),this.puits); 
    }
    
    @Test
    public void testActionPerformed() {
        ActionEvent eventMock = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "");

        gravite.actionPerformed(eventMock);

    }
    
    

}
