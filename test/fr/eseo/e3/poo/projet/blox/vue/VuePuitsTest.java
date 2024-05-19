package fr.eseo.e3.poo.projet.blox.vue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Dimension;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VuePuitsTest {

	//Test de constructeur de la vuePuits
	@Test
	public void testConstructeur() {
		Puits puits = new Puits();
		VuePuits vuePuits1 = new VuePuits(puits);
		VuePuits vuePuits2 = new VuePuits(puits, 100);

		assertEquals(vuePuits1.getTaille(), VuePuits.TAILLE_PAR_DEFAUT, ""); // Vérifie la taille par défaut
		assertEquals(100, vuePuits2.getTaille());
	}
	//Test de la taille conforme du puits lors de l'affichage
	@Test
	public void testTaillePreference() {
		Puits puits = new Puits();
		VuePuits vuePuits1 = new VuePuits(puits, 10);

		// Calcul de la taille préférée attendue
		int largeurAttendue = puits.getLargeur() * 10;
		int profondeurAttendue = puits.getProfondeur() * 10;

		// Vérification de la taille préférée
		assertEquals(new Dimension(largeurAttendue, profondeurAttendue), vuePuits1.getPreferredSize(),
				"La taille préférée devrait être correctement définie");
	}
	//Test du setter de puits 
	@Test
	public void testSetter() {
		Puits puits = new Puits();
		VuePuits vuePuits2 = new VuePuits(puits, 100);

		// Modification de la taille du VuePuits
		vuePuits2.setTaille(75);
		assertEquals(75, vuePuits2.getTaille(), "");
	}
	//Test d'un ajout d'un puits
	@Test
	public void testSetPuit() {
		Puits puits = new Puits();
		VuePuits vuePuits2 = new VuePuits(puits, 100);

		Puits nouveauPuits = new Puits(10,24);
		vuePuits2.setPuits(nouveauPuits);
		assertEquals(nouveauPuits, vuePuits2.getPuits(), "");
	}

}