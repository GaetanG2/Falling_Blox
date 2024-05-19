package fr.eseo.e3.poo.projet.blox;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.controleur.Gravite;

public class FallingBloxVersion1 {

	private static void jeuTest(String[] args) {
		JFrame graphfenetre = new JFrame("Falling Blox");
		graphfenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		graphfenetre.setResizable(false);

		Puits puits;
		if (args.length == 1) {
			puits = new Puits();
		} else if (args.length == 2) {
			int nbElements = Integer.parseInt(args[0]);
			int nbLignes1 = (nbElements / Puits.LARGEUR_PAR_DEFAUT) + 1;
			puits = new Puits(Puits.LARGEUR_PAR_DEFAUT, Puits.PROFONDEUR_PAR_DEFAUT, nbElements, nbLignes1);
		} else if (args.length == 3) {
			int nbElements = Integer.parseInt(args[0]);
			int nbLignes = Integer.parseInt(args[2]);
			puits = new Puits(Puits.LARGEUR_PAR_DEFAUT, Puits.PROFONDEUR_PAR_DEFAUT, nbElements, nbLignes);
		} else {
			puits = new Puits();
		}
		puits.setPieceSuivante(UsineDePiece.genererTetromino());
		VuePuits vuePuits = new VuePuits(puits);
		graphfenetre.add(vuePuits, BorderLayout.CENTER);

		PanneauInformation panneauInformation = new PanneauInformation(puits);
		graphfenetre.add(panneauInformation, BorderLayout.EAST);

		graphfenetre.pack();
		graphfenetre.setLocationRelativeTo(null);
		graphfenetre.setVisible(true);
		new Gravite(vuePuits);
		puits.setPieceSuivante(UsineDePiece.genererTetromino());
		vuePuits.repaint();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				jeuTest(args);
			}
		});
	}
}
