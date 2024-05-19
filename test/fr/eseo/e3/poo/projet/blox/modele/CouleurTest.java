package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.Test;

public class CouleurTest {

	// Test de l'enum couleur
	@Test
	public void testCouleurRouge() {
		assertEquals(Color.RED, Couleur.ROUGE.getCouleurPourAffichage());
		assertEquals(Color.ORANGE, Couleur.ORANGE.getCouleurPourAffichage());
		assertEquals(Color.BLUE, Couleur.BLEU.getCouleurPourAffichage());
		assertEquals(Color.GREEN, Couleur.VERT.getCouleurPourAffichage());
		assertEquals(Color.YELLOW, Couleur.JAUNE.getCouleurPourAffichage());
		assertEquals(Color.CYAN, Couleur.CYAN.getCouleurPourAffichage());
		assertEquals(Color.MAGENTA, Couleur.VIOLET.getCouleurPourAffichage());

	}

}
