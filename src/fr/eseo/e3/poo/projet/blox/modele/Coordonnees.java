package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

//classe Coordonnees
public class Coordonnees {
	// Variables d'instance
	private int abscisse;
	private int ordonnee;

	// Constructeur de la classe coordonnées
	public Coordonnees(int abscisse, int ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}
	
	// Méthode pour obtenir l'abscisse
	public int getAbscisse() {
		return this.abscisse;

	}
	
	// Méthode pour obtenir l'ordonnée
	public int getOrdonnee() {
		return this.ordonnee;

	}
	
	// Méthode pour définir l'abscisse
	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}

	// Méthode pour définir l'ordonnee
	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}
	
	// Représentation textuelle des coordonnées
	@Override
	public String toString() {
		return "(" + abscisse + ", " + ordonnee + ")";
	}
	
	// Méthode pour le hachage 
	@Override
	public int hashCode() {
		return Objects.hash(abscisse, ordonnee);
	}
	
	// Méthode pour comparer deux instances de coordonnees
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

}
