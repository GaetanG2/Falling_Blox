package fr.eseo.e3.poo.projet.blox.controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.event.ActionEvent;

import javax.swing.Timer;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class GraviteTest {
	
	//Test des fonctionnalité de la méthode gravité
	/*
	 * ANTI-PLAGIAT: La méthode testGravite() m'a éte auto génerer par l'IA chat GPT
	 */

    @Test
    public void testGravite() {
        VuePuits vuePuits = new VuePuits(new Puits());
        Gravite gravite = new Gravite(vuePuits);

        Timer timer = gravite.getTimer();
        assertNotNull(timer, "Le timer ne devrait pas être null");

        assertEquals(1000, timer.getDelay(), "La périodicité du timer devrait être de 1000 ms");

        int yAvant = vuePuits.getPuits().getPieceSuivante().getElements()[0].getCoordonnees().getOrdonnee();
        gravite.actionPerformed(new ActionEvent(gravite, ActionEvent.ACTION_PERFORMED, null));
        int yApres = vuePuits.getPuits().getPieceSuivante().getElements()[0].getCoordonnees().getOrdonnee();
        assertEquals(yAvant + 1, yApres, "La pièce devrait avoir descendu d'une case");
    }
}
