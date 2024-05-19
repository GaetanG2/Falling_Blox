package fr.eseo.e3.poo.projet.blox.modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;

public class Puits {

	public static final int LARGEUR_PAR_DEFAUT = 10;
	public static final int PROFONDEUR_PAR_DEFAUT = 15;
	public static final String MODIFICATION_PIECE_ACTUELLE = "Actuelle";
	public static final String MODIFICATION_PIECE_SUIVANTE = "Suivante";
	public int largeur;
	public int profondeur;
	private Piece pieceActuelle;
	private Piece pieceSuivante;
	private PropertyChangeSupport pcs;
	private Tas tas;

	// Constructeur de la classe Puits
	public Puits() {
		this.largeur = LARGEUR_PAR_DEFAUT;
		this.profondeur = PROFONDEUR_PAR_DEFAUT;
		this.pcs = new PropertyChangeSupport(this);
		this.tas = new Tas(this);
	}

	// Constructeur de la classe Puits
	public Puits(int largeur, int profondeur) {
		if (largeur < 5 || largeur > 15 || profondeur < 15 || profondeur > 25) {
			throw new IllegalArgumentException("Argument non conformes");
		} else {
			this.largeur = largeur;
			this.profondeur = profondeur;
			this.pcs = new PropertyChangeSupport(this);
			this.tas = new Tas(this);
		}

	}

	// Constructeur de la classe Puits
	public Puits(int largeur, int profondeur, int nbElements, int nbLignes) {
		this.largeur = largeur;
		this.profondeur = profondeur;
		this.pcs = new PropertyChangeSupport(this);
		this.tas = new Tas(this, nbElements, nbLignes);
	}

	// Methode de récuperation de la piece actuelle
	public Piece getPieceActuelle() {
		return pieceActuelle;
	}

	// Methode de récuperation de la piece suivante
	public Piece getPieceSuivante() {

		return pieceSuivante;
	}

	// Methode de récuperation de la profondeur du puits
	public int getProfondeur() {
		return this.profondeur;
	}

	// Methode de récuperation de la largeur du puits
	public int getLargeur() {
		return this.largeur;
	}

	// Methode de récuperation du tas lié au puits
	public Tas getTas() {
		return tas;
	}

	// Methode d'ajout d'un tas
	public void setTas(Tas tas) {
		this.tas = tas;
	}

	// Methode pour mettre à jour la piece suivante
	public void setPieceSuivante(Piece piece) {
		Piece actPiece = this.pieceSuivante;
		Piece actPieceanc = this.pieceActuelle;

		if (getPieceSuivante() != null) {
			this.pieceActuelle = this.pieceSuivante;
			this.pieceActuelle.setPosition(getLargeur() / 2, -4);
			pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, actPieceanc, this.pieceActuelle);
			this.pieceSuivante = piece;
		} else {
			this.pieceSuivante = piece;
		}
		this.pieceSuivante.setPuits(this);
		pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, actPiece, piece); 

	}

	// Methode pour mettre à jour la profondeur du puits
	public void setProfondeur(int profondeur) {
		if (profondeur < 15 || profondeur > 25) {
			throw new IllegalArgumentException("Argument non conformes");
		} else {
			this.profondeur = profondeur;
		}
	}

	// Methode pour mettre à jour la largeur du puits
	public void setLargeur(int largeur) {
		if (largeur < 5 || largeur > 15) {
			throw new IllegalArgumentException("Argument non conformes");
		} else {
			this.largeur = largeur;
		}
	}

	// Methode pour la representation textuelle du puits avec renvoi de sa largeur
	// et sa profondeur
	public String toString() {
		String pui = "Piece Actuelle : ";
		String puis = "Piece Suivante : ";
		if (this.pieceActuelle != null) {
			pui = pui + this.pieceActuelle.toString();
		} else {
			pui = pui + "<aucune>" + "\n";
		}

		if (this.pieceSuivante != null) {
			puis = puis + this.pieceSuivante.toString();
		} else {
			puis = puis + "<aucune>" + "\n";
		}
		return "Puits : Dimension " + this.largeur + " x " + this.profondeur + "\n" + pui + puis;

	}

	// Méthode pour ajouter un écouteur de changement de propriété
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	// Méthode pour retirer un écouteur de changement de propriété
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

	// Méthode pour gérer les collisions
	private void gererCollision() {
		this.tas.ajouterElements(pieceActuelle);
		this.setPieceSuivante(UsineDePiece.genererTetromino());

	}

	// Méthode pour appliquer la gravité au jeu
	public void gravite() {
		try {
			if (this.pieceActuelle != null) {
				pieceActuelle.deplacerDe(0, 1);
			}
		} catch (BloxException e) {
			gererCollision();
		}
	}

}
