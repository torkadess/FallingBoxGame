package fr.eseo.e3.poo.projet.blox.modele;

public class BloxException extends Exception {
	public static final  int BLOX_COLLISION = 1; 
	public static final int BLOX_SORTIE_PUITS = 2; 
	
	public static int type; 
	
	public BloxException(String message, int type) {
		super(message); 
		System.out.println("DEPLACER DE  : " + message); 
		this.type = type; 

		
	}
	
	public int getType() {
		return this.type; 
	}
	
}
