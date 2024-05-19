package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;


//classe Element
public class Element {
	private Coordonnees coordonnees;
	private Couleur couleur;
	
	// Constructeur de la classe Element
	public Element(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
		this.couleur = Couleur.values()[0];
		}

	// Constructeur de la classe Element
	public Element(int abscisse  , int ordonnee) {
		this.coordonnees = new Coordonnees(abscisse,ordonnee);
		this.couleur = Couleur.values()[0];
	}

	// Constructeur de la classe Element
	public Element(Coordonnees coordonnees, Couleur couleur) {
		this.coordonnees = coordonnees;
        this.couleur = couleur;
	}
	
	// Constructeur de la classe Element
	public Element(int abscisse  , int ordonnee, Couleur couleur) {
		this.coordonnees = new Coordonnees(abscisse, ordonnee);
        this.couleur = couleur; 
	}

	// Méthode pour obtenir les coordonnees
	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	// Méthode pour définir les coordonnees de l'élement
	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	// Méthode pour obtenir la couleur de l'élement
	public Couleur getCouleur() {
		return couleur;
	}
	
	// Méthode pour définir la couleur de l'élement
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	
	// Représentation textuelle d'un element
	@Override
	public String toString() {
		return coordonnees + " - " + couleur ;
	}

	// Méthode pour le hachage 
	@Override
	public int hashCode() {
		return Objects.hash(coordonnees, couleur);
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
		Element other = (Element) obj;
		return Objects.equals(coordonnees, other.coordonnees) && couleur == other.couleur;
	}
	//Méthode pour éffectuer un déplacement de x position
	public void deplacerDe(int deltaX, int deltaY)  {
	    int nouvelleAbs = this.getCoordonnees().getAbscisse() + deltaX;
	    int nouvelleOrd = this.getCoordonnees().getOrdonnee() + deltaY;
	    this.setCoordonnees(new Coordonnees(nouvelleAbs, nouvelleOrd));
	}

}
