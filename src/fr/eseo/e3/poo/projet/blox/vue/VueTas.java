package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Tas;

public class VueTas {
	public static final double MULTIPLIER_NUANCE = 0.4;
	private final VuePuits vuePuits;
	private final Tas tas;

	public VueTas(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.tas = vuePuits.getPuits().getTas();
	}

	// Test pour redefinir une nouvelles teinte de la piece
	public static Color nuance(Color couleur) {
		int r = couleur.getRed();
		int g = couleur.getGreen();
		int b = couleur.getBlue();
		int alpha = couleur.getAlpha();

		int red = (int) (r * (1 - MULTIPLIER_NUANCE));
		int green = (int) (g * (1 - MULTIPLIER_NUANCE));
		int blue = (int) (b * (1 - MULTIPLIER_NUANCE));

		return new Color(red, green, blue, alpha);
	}

	public VuePuits getVuePuits() {
		return vuePuits;
	}

	/*
	 * ANTI-PLAGIAT: La méthode afficherPiece() finale m'a été explique par Mr Jonas
	 */
	// Test de l'affichage du tas dans le puits
	public void afficher(Graphics2D g2d) {
		if (tas != null && tas.getElements().size() > 0) {
			int x, y;
			int width = this.vuePuits.getTaille();

			for (int i = 0; i < tas.getElements().size(); i++) {
				Color couleurRef = (tas.getElements().get(i)).getCouleur().getCouleurPourAffichage();
				Color couleur = nuance(couleurRef);
				g2d.setColor(couleur);
				x = (tas.getElements().get(i)).getCoordonnees().getAbscisse() * width;
				y = (tas.getElements().get(i)).getCoordonnees().getOrdonnee() * width;
				g2d.setColor(couleur);

				g2d.fill3DRect(x, y, width, width, true);
			}
			this.tas.suppLigneComplet();
		}

	}

}
