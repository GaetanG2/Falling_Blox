package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;


import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class LTetromino extends Tetromino{
	public LTetromino(Coordonnees coordonnees, Couleur couleur) {
		super(coordonnees, couleur);
		this.setElements(coordonnees, couleur);

	}

	// Methode pour ajouter les element au tableau
	protected void setElements(Coordonnees coordonnees, Couleur couleur) {
		this.getElements()[0] = new Element(coordonnees, couleur);
		this.getElements()[1] = new Element(coordonnees.getAbscisse()+1, coordonnees.getOrdonnee(), couleur);
		this.getElements()[2] = new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1, couleur);
		this.getElements()[3] = new Element(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 2, couleur);
	}

	// Representation textuelle d'un Otetromino
	public String toString() {
		return "LTetromino :\n" + "	" + getElements()[0] + "\n" + "	" + getElements()[1] + "\n" + "	" + getElements()[2]
				+ "\n" + "	" + getElements()[3] + "\n";
	}
}
