package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Coordonnees {
    private int abscisse,ordonnee; 

    public Coordonnees( int abscisse, int ordonnee) 
    {
        this.setAbscisse(abscisse);
        this.setOrdonnee(ordonnee);
    }
    
    @Override
	public String toString() {
		return "(" + abscisse + ", " + ordonnee + ")";
	}
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordonnees other = (Coordonnees) obj;
		return abscisse == other.abscisse && ordonnee == other.ordonnee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(abscisse, ordonnee);
	}

	public int getAbscisse() {
        return abscisse;
    }
    public int getOrdonnee() {
        return ordonnee;
    }
    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    



}
