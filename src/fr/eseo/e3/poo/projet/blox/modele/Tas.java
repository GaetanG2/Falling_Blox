package fr.eseo.e3.poo.projet.blox.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Tas {
	private Puits puits;
	private List<Element> elements;

	public Tas(Puits puits) {
		this.puits = puits;
		this.elements = new ArrayList<Element>();
	}

	public Tas(Puits puits, int nbElements) {
		this(puits);
		construireTas(nbElements, (nbElements / puits.getLargeur()) + 1, new Random());
	}

	public Tas(Puits puits, int nbElements, int nbLignes) {
		this(puits);
		construireTas(nbElements, nbLignes, new Random());
	}

	public Tas(Puits puits, int nbElements, int nbLignes, Random rand) {
		this(puits);
		construireTas(nbElements, nbLignes, rand);
	}

	// Méthode pour construire le tas avec un nombre spécifié d'éléments
	private void construireTas(int nbElements, int nbLignes, Random rand) {
		if (nbElements > puits.getLargeur() * nbLignes) {
			throw new IllegalArgumentException("Nombre d'éléments ou nombre de lignes trop grands pour le puits.");
		}

		int nombreElementsPlacesPuits = 0;
		while (nombreElementsPlacesPuits < nbElements) {
			int ordon = puits.getProfondeur() - rand.nextInt(nbLignes) - 1;
			int abscd = rand.nextInt(puits.getLargeur());

			if (!elementExists(abscd, ordon)) {
				int indiceDeCouleur = rand.nextInt(Couleur.values().length);
				Element element = new Element(abscd, ordon, Couleur.values()[indiceDeCouleur]);
				elements.add(element);
				nombreElementsPlacesPuits++;
			}
		}
	}

	public Puits getPuits() {
		return this.puits;
	}

	public List<Element> getElements() {
		return elements;
	}

	// Methode pour vérifier si un element existe a une position donner dans le tas
	// donc si elle existe dans le tas
	public boolean elementExists(int x, int y) {
		boolean verif = true;
		for (Element element : elements) {
			if (element.getCoordonnees().getAbscisse() == x && element.getCoordonnees().getOrdonnee() == y) {
				return true;
			}
		}
		verif = false;
		return verif;
	}
	//Methode pour ajouter une piece a la liste des elements du tas 
	public void ajouterElements(Piece piece) {
		for (int i = 0; i < piece.getElements().length; i++) {
			int x = piece.getElements()[i].getCoordonnees().getAbscisse();
			int y = piece.getElements()[i].getCoordonnees().getOrdonnee();
			if (!elementExists(x, y))
				this.getElements().add(piece.getElements()[i]);
		}
	}
	//Methode pour supprimer une ligne dans le puits lorsqu'elle est complète 
	public void suppLigneComplet() {
	    int largeurPuits = puits.getLargeur();
	    int profondeurPuits = puits.getProfondeur();

	    for (int y = 0; y < profondeurPuits; y++) {
	        int blocsDsLigne = 0;
	        for (int i = 0; i < this.getElements().size(); i++) {
	            if (this.getElements().get(i).getCoordonnees().getOrdonnee() == y) {
	            	blocsDsLigne++;
	            }
	        }
	        if (blocsDsLigne == largeurPuits) { 
	            final int ligneASupprimer = y;
	            elements.removeIf(element -> element.getCoordonnees().getOrdonnee() == ligneASupprimer); 
	            for (int i = 0; i < this.getElements().size(); i++) {
	                if (this.getElements().get(i).getCoordonnees().getOrdonnee() < ligneASupprimer) {
	                    this.getElements().get(i).getCoordonnees().setOrdonnee(this.getElements().get(i).getCoordonnees().getOrdonnee() + 1);
	                }
	            }
	        }
	    }
	}

	


}