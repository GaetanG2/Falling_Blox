package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePiece {

	public static final double MULTIPLIER_TEINTE = 0.3;
	private final Piece piece;
	private final int taille;

	public VuePiece(Piece piece, int taille) {
		this.taille = taille;
		this.piece = piece;
	}
	//Methode pour définir la teinte pour les couleurs des elements de chaque piece
	public static Color teinte(Color couleur) {
		int r = couleur.getRed();
		int g = couleur.getGreen();
		int b = couleur.getBlue(); 
		int alpha = couleur.getAlpha();

		int newR = (int) (r + ((255 - r) * MULTIPLIER_TEINTE));
		int newG = (int) (g + ((255 - g) * MULTIPLIER_TEINTE));
		int newB = (int) (b + ((255 - b) * MULTIPLIER_TEINTE));

		if (r > 0 && r < newR) {
			r = newR;
		}
		if (g > 0 && g < newG) {
			g = newG;
		}
		if (b > 0 && b < newB) {
			b = newB;
		}

		return new Color(newR, newG, newB, alpha);
	}
	
	/*
	* ANTI-PLAGIAT: La méthode afficherPiece() finale m'a été explique par Mr Jonas(la logique de l'implémentation) 
	*/
	//Méthode pour afficher la piece avec fill3DRect
	public void afficherPiece(Graphics2D g2D) {
		Color couleurRef = piece.getElements()[0].getCouleur().getCouleurPourAffichage();

		int x, y;

		x = piece.getElements()[0].getCoordonnees().getAbscisse() * taille;
		y = piece.getElements()[0].getCoordonnees().getOrdonnee() * taille;
		g2D.setColor(teinte(couleurRef));
		g2D.fill3DRect(x, y, taille, taille, true);


		for (int i = 1; i < piece.getElements().length; i++) {
			x = piece.getElements()[i].getCoordonnees().getAbscisse() * taille;
			y = piece.getElements()[i].getCoordonnees().getOrdonnee() * taille;
			g2D.setColor(couleurRef);
			g2D.fill3DRect(x, y, taille, taille, true);

		}
 
	}

}
 