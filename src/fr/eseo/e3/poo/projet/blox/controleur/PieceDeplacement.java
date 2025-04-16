package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacement implements MouseMotionListener, MouseListener, MouseWheelListener {
	private VuePuits vuePuits; 
	private Puits puits; 
	private Coordonnees coordsPrems;
	private int taillePuits;
 
	public PieceDeplacement(VuePuits vuePuits) {
		this.setVuePuits(vuePuits);
		this.setPuits(vuePuits.getPuits());
	}
  
	@Override
    public void mouseMoved(MouseEvent e) {
		taillePuits= vuePuits.getTaille();
        if(puits.getPieceActuelle()!=null) {
            Coordonnees coordsMouseNew = new Coordonnees(e.getX()/taillePuits, e.getY()/taillePuits);
            if (coordsPrems==null) {
                this.setCoordsPrems(coordsMouseNew);
            }
            if(coordsPrems.getAbscisse()!=coordsMouseNew.getAbscisse()) {
                try {
					puits.getPieceActuelle().deplacerDe(Integer.signum(coordsMouseNew.getAbscisse()-coordsPrems.getAbscisse()),0);
					this.vuePuits.repaint();
                } catch (BloxException e1) {
					System.out.println("La piece ne peut pas être deplacer"); 
				}
                
            }
            this.getCoordsPrems().setAbscisse(coordsMouseNew.getAbscisse());
        }
    }

	@Override
	public void mouseDragged( MouseEvent event) {
	 
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		taillePuits= vuePuits.getTaille();
		this.setCoordsPrems( new Coordonnees(e.getX()/taillePuits, e.getY()/taillePuits));
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {

	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (puits.getPieceActuelle()!= null) {
			if (e.getWheelRotation() > 0) {
				try {
					puits.getPieceActuelle().deplacerDe(0,1);
					this.vuePuits.repaint();
				} catch (BloxException e1) {
					
				}
				
	        }
		}
		
	}
	
	public void setVuePuits(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
	}

	public void setPuits(Puits puits) {
		this.puits = puits;
	}

	public Coordonnees getCoordsPrems() {
		return coordsPrems;
	}

	public void setCoordsPrems(Coordonnees coordsPrems) {
		this.coordsPrems = coordsPrems;
	}
	


	
	
	



	

	
	
	
}
