package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;

public class PuitsTest {

	// test du constructeur de Puits
	@Test
	public void testConstructeur() {
		Puits pies = new Puits();
		Puits piess = new Puits(15, 20);

		assertEquals(10, pies.getLargeur(), "Erreur pour le constructeur");
		assertEquals(15, pies.getProfondeur(), "Erreur pour le constructeur");

		assertEquals(15, piess.getLargeur(), "Erreur pour le constructeur");
		assertEquals(20, piess.getProfondeur(), "Erreur pour le constructeur");
	}

	// test du getter de la piece actuelle
	@Test
	public void testGetPieceActuelle() {
		Puits puits = new Puits();
		assertNull(puits.getPieceActuelle(), "Puit non nul");
	}

	// test de l'erreur d'une largeur non conforme
	@Test()
	public void testSetLargeur() {
		int largeur = 3; 
		int profondeur = 20;
		try {
			new Puits(largeur, profondeur);
			fail("Une IllegalArgumentException aurait dû être levée.");
		} catch (IllegalArgumentException e) {
		}
	}

	// test de l'erreur d'une profondeur non conforme
	@Test()
	public void testSetProf() {
		int largeur = 8; 
		int profondeur = 28;
		try {
			new Puits(largeur, profondeur);
			fail("Une IllegalArgumentException aurait dû être levée.");
		} catch (IllegalArgumentException e) {
		}
	}

	// test du getter de la piece suivante
	@Test
	public void testGetPieceSuivante() {
		Puits puits = new Puits();
		assertNull(puits.getPieceSuivante(), "Puit suivant non nul");
	}

	// test du setter de la piece suivante
	@Test
	public void testSetPieceSuivante() {
		Puits puits = new Puits();
		Coordonnees cordd = new Coordonnees(3, 5);
		Piece piece = new OTetromino(cordd, Couleur.BLEU);
		puits.setPieceSuivante(piece);
		assertEquals(piece, puits.getPieceSuivante(), "piece suivante non conforme");

		Coordonnees cordd1 = new Coordonnees(6, 5);
		Piece piece1 = new OTetromino(cordd1, Couleur.CYAN);
		puits.setPieceSuivante(piece1);
		assertEquals(piece1, puits.getPieceSuivante(), "piece suivante non conforme");
	}

	// test des methode toString avec parametre
	@Test
	public void testToStringAvecPieces() {
		Puits puits = new Puits();
		Coordonnees cord1 = new Coordonnees(5, 5);
		Piece pieceSuivante = new ITetromino(cord1, Couleur.BLEU);
		puits.setPieceSuivante(pieceSuivante);
		String attendu = "Puits : Dimension " + Puits.LARGEUR_PAR_DEFAUT + " x " + Puits.PROFONDEUR_PAR_DEFAUT + "\n";
		attendu += "Piece Actuelle : <aucune>\n";
		attendu += "Piece Suivante : " + pieceSuivante.toString();
		assertEquals(attendu, puits.toString(), "representation textuelle erroner");
	}

	// test des methode toString sans parametre
	@Test
	public void testToStringSansPieces() {
		Puits puits = new Puits();
		String attendu = "Puits : Dimension " + Puits.LARGEUR_PAR_DEFAUT + " x " + Puits.PROFONDEUR_PAR_DEFAUT + "\n";
		attendu += "Piece Actuelle : <aucune>\n";
		attendu += "Piece Suivante : <aucune>\n";
		assertEquals(attendu, puits.toString(), "representation textuelle erroner");
	}

	// Test de construction d'un puits avec des dimensions spécifiées
	@Test
	public void testPuitsConstruction() {
		Puits puits = new Puits(12, 17);
		assertNotNull(puits);
		assertEquals(12, puits.getLargeur());
		assertEquals(17, puits.getProfondeur());
	}

	// Test de création d'un puits avec un tas initialisé
	@Test
	public void testPuitsTasInitial() {
		Puits puits = new Puits(12, 17, 10, 3);
		assertNotNull(puits);
		assertNotNull(puits.getTas());
		assertEquals(10, puits.getTas().getElements().size());
	}
	
	/*
	* ANTI-PLAGIAT: La méthode testGererCollision() m'a ete generer pae l'ia chat gpt
	*/
	// Test de la gestion d'une collision
	@Test
	public void testGererCollision() {
		Puits puits = new Puits();
		Piece pieceActuelle = new OTetromino(new Coordonnees(3, 5), Couleur.BLEU);
		Piece pieceSuivante = new ITetromino(new Coordonnees(5, 5), Couleur.BLEU);
		puits.setPieceSuivante(pieceActuelle);
		puits.setPieceSuivante(pieceSuivante);
		int x, y;
		for (int i = 0; i < pieceActuelle.getElements().length; i++) {
			x = pieceActuelle.getElements()[i].getCoordonnees().getAbscisse();
			y = pieceActuelle.getElements()[i].getCoordonnees().getOrdonnee();
			assertTrue(puits.getTas().elementExists(x, y));
		}
		assertEquals(pieceSuivante, puits.getPieceActuelle());
	}

	// Test de la gravité
	@Test
	public void testGravite() {
		Puits puits = new Puits();
		Piece piece = new OTetromino(new Coordonnees(3, 5), Couleur.BLEU);
		puits.setPieceSuivante(piece);
		int yBefore = piece.getElements()[0].getCoordonnees().getOrdonnee();
		puits.gravite();
		int yAfter = piece.getElements()[0].getCoordonnees().getOrdonnee();
		assertEquals(yBefore - 1, yAfter);
	}

}
