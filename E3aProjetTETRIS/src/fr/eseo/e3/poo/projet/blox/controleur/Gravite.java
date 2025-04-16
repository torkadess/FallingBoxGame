package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.ActionEvent;

import javax.swing.Timer;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class Gravite {
	
	private Timer timer; 
	private VuePuits vuePuits; 
	private Puits puits; 
	
	public Gravite(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = this.vuePuits.getPuits(); 
		this.timer = new Timer(500, this::actionPerformed);
		this.timer.start();
	}
	 
	public int getPeriodicite() {
		return this.timer.getDelay();
	}
	
	
	public void setPeriodicite(int periodicite) {
		this.timer.setDelay(periodicite);
	}
	
	public void actionPerformed(ActionEvent event) {
		this.puits.gravite();
		this.vuePuits.repaint();
	}
	
	
}
