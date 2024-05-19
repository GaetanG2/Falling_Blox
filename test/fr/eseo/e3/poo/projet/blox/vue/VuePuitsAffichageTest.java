package fr.eseo.e3.poo.projet.blox.vue;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;

public class VuePuitsAffichageTest {

	public VuePuitsAffichageTest() {
		testConstructeurPuits();
		testConstructeurPuitsTaille();

	}
	//Methode pour affiche le puits avec un ou des pieces 
	private void testConstructeurPuits() {
		Puits puits = new Puits();
		VuePuits vuePuits = new VuePuits(puits);
		
		puits.setPieceSuivante(UsineDePiece.genererTetromino());

		JFrame fenetre = new JFrame("Puits");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fenetre.add(vuePuits);
		fenetre.pack();
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
        puits.setPieceSuivante(UsineDePiece.genererTetromino());
        vuePuits.repaint();
 

	}
	//Methode pour affiche le puits avec une taille défini 
	private void testConstructeurPuitsTaille() {
		Puits puits = new Puits();
		VuePuits vuePuits = new VuePuits(puits, 20);

		puits.setPieceSuivante(UsineDePiece.genererTetromino());

		JFrame fenetre1 = new JFrame("Puits et taille");
		fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fenetre1.add(vuePuits);
		fenetre1.pack();
		fenetre1.setLocationRelativeTo(null);
		fenetre1.setVisible(true);
		puits.setPieceSuivante(UsineDePiece.genererTetromino());
        vuePuits.repaint();

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VuePuitsAffichageTest();
			}
		});
	}
}