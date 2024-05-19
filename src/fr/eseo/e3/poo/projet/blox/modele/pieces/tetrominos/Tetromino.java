package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public abstract class Tetromino implements Piece {

	private Element[] elements;
	private Puits puits;

	// constructeur de la classe tetromino
	public Tetromino(Coordonnees coordonnees, Couleur couleur) {
		this.elements = new Element[4];
		this.setElements(coordonnees, couleur);

	}

	// Methode abstraite setElements a definir dans les sous-classes
	protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

	// Methode pour recuperer les elements
	public Element[] getElements() {
		return this.elements;
	}

	// Methode pour mettre a jour la position
	public void setPosition(int abscisse, int ordonnee) {
		this.setElements(new Coordonnees(abscisse, ordonnee), this.getElements()[0].getCouleur());
	}

	// representation textuelle d'un tetromino
	public String toString() {
		return "Tetromino :\n" + "	" + getElements()[0] + "\n" + "	" + getElements()[1] + "\n" + "	" + getElements()[2]
				+ "\n" + "	" + getElements()[3] + "\n";
	}
	//recuperation(getter) de puits
	public Puits getPuits() {
		return puits;
	}
	//ajout(setter) de puits
	public void setPuits(Puits puits) {
		this.puits = puits;
	}
	//Methode pour éffectuer un déplacement
	public void deplacerDe(int deltaX, int deltaY) throws BloxException {
		if (deltaY < 0 || deltaY > 1 || deltaX < -1 || deltaX > 1) {
			throw new IllegalArgumentException("Le déplacement est invalide.");
		} else {
			int erreur = 0;

			if (this.puits != null) {

				Tas tas = getPuits().getTas();
				for (int i = 0; i < getElements().length; i++) {

					int nouvelleAbs = getElements()[i].getCoordonnees().getAbscisse() + deltaX;
					int nouvelleOrd = getElements()[i].getCoordonnees().getOrdonnee() + deltaY;

					if (nouvelleAbs < 0 || nouvelleAbs >= this.puits.getLargeur()) {
						erreur += 2;
					} else if (nouvelleOrd >= this.puits.getProfondeur()
							|| tas.elementExists(nouvelleAbs, nouvelleOrd)) {
						erreur += 1;
					} else if (nouvelleOrd < 0) {
						erreur += 0;
					}

					if (erreur != 0) {
						throw new BloxException("Collision détectée", erreur);
					}
				}
			}
			for (int i = 0; i < getElements().length; i++) {
				int nouvelleAbs = getElements()[i].getCoordonnees().getAbscisse() + deltaX;
				int nouvelleOrd = getElements()[i].getCoordonnees().getOrdonnee() + deltaY;
				getElements()[i].setCoordonnees(new Coordonnees(nouvelleAbs, nouvelleOrd));

			}
		}

	}
	
	/*
	* ANTI-PLAGIAT: La méthode tourner() finale : par rapport a la gestion des collision m'a été expliqué par Yoan 
	* mais j'ai réalisé l'implémentation moi-meme
	*/
	//Methode pour éffectuer des rotation horaire et anti-horaire
	public void tourner(boolean sensHoraire) throws BloxException {
		Element ref = elements[0];
		int referenX = ref.getCoordonnees().getAbscisse();
		int referenY = ref.getCoordonnees().getOrdonnee();
		boolean canRotat = true;
		int erreur = 0;

		for (int i = 0; i < getElements().length; i++) {

			if (getElements()[i] != ref) {
				int relX = getElements()[i].getCoordonnees().getAbscisse() - referenX;
				int relY = getElements()[i].getCoordonnees().getOrdonnee() - referenY;
				int nouveauX, nouveauY;

				if (sensHoraire) {
					// Rotation 90°
					nouveauX = referenX - relY;
					nouveauY = referenY + relX;

				} else {
					// Rotation -90°
					nouveauX = referenX + relY;
					nouveauY = referenY - relX;
				}

				if (this.puits != null) {
					Tas tas = getPuits().getTas();
					if (nouveauX < 0 || nouveauX >= this.puits.getLargeur()) {
						canRotat = false;
						erreur += 2;
					} else if (nouveauY >= this.puits.getProfondeur() || tas.elementExists(nouveauX, nouveauY)) {
						canRotat = false;
						erreur += 1;
					} else if (nouveauY < 0) {
						canRotat = false;
						erreur += 0;
					}
					if (erreur != 0) {
						throw new BloxException("Collision détectée", erreur);
					}
					if (nouveauX < 0 || nouveauX >= puits.getLargeur() || nouveauY >= puits.getProfondeur()) {
						canRotat = false;
						break;
					}
				}

			}
		}

		if (canRotat) {
			for (int i = 0; i < getElements().length; i++) {
				if (getElements()[i] != ref) {
					int relX = getElements()[i].getCoordonnees().getAbscisse() - referenX;
					int relY = getElements()[i].getCoordonnees().getOrdonnee() - referenY;

					int nouveauX, nouveauY;
					if (sensHoraire) {
						nouveauX = referenX - relY;
						nouveauY = referenY + relX;
						getElements()[i].setCoordonnees(new Coordonnees(nouveauX, nouveauY));

					} else {
						nouveauX = referenX + relY;
						nouveauY = referenY - relX;
						getElements()[i].setCoordonnees(new Coordonnees(nouveauX, nouveauY));

					}
				}
			}
		}
	}
}
