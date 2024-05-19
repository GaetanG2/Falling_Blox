package fr.eseo.e3.poo.projet.blox.controleur;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotationTest {
	public PieceRotationTest() {
		testTourne();
		
	}

	// Test de VuePuits pour verifier la méthode tourner d'une piece
	public void testTourne() {
		Puits puits = new Puits(10, 20); 
        VuePuits vuePuits = new VuePuits(puits,20);


		puits.setPieceSuivante(UsineDePiece.genererTetromino());
	
		JFrame fenetre = new JFrame("PieceDeplacement Test");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fenetre.add(vuePuits);
        fenetre.pack();  
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        puits.setPieceSuivante(UsineDePiece.genererTetromino());
        vuePuits.repaint();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PieceRotationTest();
			}
		});
	}

}
