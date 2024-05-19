package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Dimension;

import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.modele.Tas;

public class PanneauScore extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Constructeur de la classe PanneauScore.
	public PanneauScore(Tas tas) {
		super.setPreferredSize(new Dimension(40, 40));
	}

}
