package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VuePuits extends JPanel implements PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int TAILLE_PAR_DEFAUT = 15;
	private Puits puits;
	private int taille;
	private VuePiece vuePiece;
	private PieceDeplacement pieceDeplacement;
	private PieceRotation pieceRotation;
	private final VueTas vueTas;

	// Constructeur de VuePuits
	public VuePuits(Puits puits) {
		this.puits = puits;
		this.taille = TAILLE_PAR_DEFAUT;
		this.setBackground(Color.WHITE);
		super.setPreferredSize(
				new Dimension(puits.getLargeur() * TAILLE_PAR_DEFAUT, puits.getProfondeur() * TAILLE_PAR_DEFAUT));

		this.pieceDeplacement = new PieceDeplacement(this);

		this.addMouseListener(this.pieceDeplacement);
		if (pieceRotation == null) {
			pieceRotation = new PieceRotation(this);
			this.addMouseListener(pieceRotation);
		}
		this.addMouseMotionListener(this.pieceDeplacement);
		this.addMouseWheelListener(this.pieceDeplacement);

		this.pieceDeplacement.setPuits(this.puits);
		this.puits.addPropertyChangeListener(this);
		this.vueTas = new VueTas(this);
		vuePiece = null;
		repaint();
	}

	// Constructeur de VuePuits
	public VuePuits(Puits puits, int taille) {
		this.puits = puits;
		this.taille = taille;
		this.setBackground(Color.WHITE);
		super.setPreferredSize(new Dimension(puits.getLargeur() * taille, puits.getProfondeur() * taille));

		this.pieceDeplacement = new PieceDeplacement(this);

		this.addMouseListener(this.pieceDeplacement);

		if (pieceRotation == null) {
			pieceRotation = new PieceRotation(this);
			this.addMouseListener(pieceRotation);
		}
		this.addMouseMotionListener(this.pieceDeplacement);
		this.addMouseWheelListener(this.pieceDeplacement);

		this.pieceDeplacement.setPuits(this.puits);
		this.puits.addPropertyChangeListener(this);
		this.vueTas = new VueTas(this);
		vuePiece = null;
		repaint();

	}

	public Puits getPuits() {
		return puits;
	}

	public int getTaille() {
		return taille;
	}

	// Methode pour mettre à jour et les proprietés et ajouter le puits
	public void setPuits(Puits puits) {
		if (this.puits != null && this.puits != puits) {
			this.puits.removePropertyChangeListener(this);
			this.removeMouseMotionListener(this.pieceDeplacement);
			this.removeMouseWheelListener(this.pieceDeplacement);

			if (this.pieceRotation != null) {
				this.pieceRotation.setPuits(puits);
			}
		}
		this.puits = puits;
		super.setPreferredSize(new Dimension(puits.getLargeur() * taille, puits.getProfondeur() * taille));
		this.pieceDeplacement.setPuits(this.puits);
		this.addMouseMotionListener(this.pieceDeplacement);
		this.addMouseWheelListener(this.pieceDeplacement);
		this.puits.addPropertyChangeListener(this);

		repaint();
	}

	// Methode pour ajouter la taille du puits
	public void setTaille(int taille) {
		this.taille = taille;
		setPreferredSize(new Dimension(puits.getLargeur() * taille, puits.getProfondeur() * taille));
		repaint();
	}

	// Methode pour récuperer la vueTas
	public VueTas getVueTas() {
		return vueTas;
	}

	// Methode pour afficher la grille de notre puits, les pieces et le tas
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		/* appel vers super pour remplir le fond du JPanel */
		/*
		 * Le paramètre g est copie en utilisant la méthode copie() puis converti en
		 * instance de Graphics2D grâce à un transtypage (cast) explicite.
		 */
		Graphics2D g2D = (Graphics2D) g.create();
		/* Nous utiliserons l'instance de Graphics2D */
		/* Puis nous liberons la memoire */
		g2D.setColor(Color.LIGHT_GRAY);
		// Lignes verticales

		for (int i = 0; i < getWidth(); i += this.taille) {
			g2D.drawLine(i, 0, i, getHeight());
		}
		// Lignes horizontales
		for (int j = 0; j < getHeight(); j += this.taille) {
			g2D.drawLine(0, j, getWidth(), j);
		}

		if (vuePiece != null) {
			vuePiece.afficherPiece(g2D);
		}
		if (this.vueTas != null) {
			vueTas.afficher(g2D);
		
		}
		g2D.dispose();
	}

	public VuePiece getVuePiece() {
		return vuePiece;
	}

	// Méthode pour ajouter une vuePiece
	private void setVuePiece(VuePiece vuePiece) {
		this.vuePiece = vuePiece;
		repaint();
	}

	// Méthode pour un changement de propriété du puits , en particulier la pièce
	// actuelle.
	// et la mise à jour de la vue de la pièce
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getPropertyName().equals(Puits.MODIFICATION_PIECE_ACTUELLE)) {
			setVuePiece(new VuePiece(puits.getPieceActuelle(), this.taille));
		}
	}

}
