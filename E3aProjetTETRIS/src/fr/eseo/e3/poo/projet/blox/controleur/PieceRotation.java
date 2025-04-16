package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotation extends MouseAdapter implements MouseListener {
	
	private VuePuits vuePuits; 
	private Puits puits; 
	
	public VuePuits getVuePuits() {
		return vuePuits;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(puits.getPieceActuelle()!=null) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				puits.getPieceActuelle().tourner(false);
				this.vuePuits.repaint();
			}
			if (SwingUtilities.isRightMouseButton(e)){
				puits.getPieceActuelle().tourner(true);
				this.vuePuits.repaint();
			}
		}

		
	}

	public void setVuePuits(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
	}

	public Puits getPuits() {
		return puits;
	}

	public void setPuits(Puits puits) {
		this.puits = puits;
	}

	public PieceRotation(VuePuits vuePuits) {
		this.setVuePuits(vuePuits);
		this.setPuits(vuePuits.getPuits());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	


}
