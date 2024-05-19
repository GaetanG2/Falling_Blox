package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;

public class UsineDePieceTest {

	// test du setter
	@Test
	public void testSetMode() {
		UsineDePiece.setMode(UsineDePiece.CYCLIC);
		assertEquals(UsineDePiece.CYCLIC, UsineDePiece.mod);
	}

	// test du cas CYCLIC
	@Test
	public void testGenererTetrominoModeCyclique() {
		UsineDePiece.setMode(UsineDePiece.CYCLIC);

		Tetromino piece1 = UsineDePiece.genererTetromino();
		assertTrue(piece1 instanceof OTetromino);
		Tetromino piece2 = UsineDePiece.genererTetromino();
		assertTrue(piece2 instanceof ITetromino);
		Tetromino piece3 = UsineDePiece.genererTetromino();
		assertTrue(piece3 instanceof OTetromino);
		Tetromino piece4 = UsineDePiece.genererTetromino();
		assertTrue(piece4 instanceof ITetromino);
	}

	// test du cas ALEATOIRE_PIECE
	@Test
	public void testGenererTetrominoModeAleatoirePiece() {
		UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
		Tetromino piece1 = UsineDePiece.genererTetromino();
		assertNotNull(piece1);

		Tetromino piece2 = UsineDePiece.genererTetromino();
		assertNotNull(piece2);

		Tetromino piece3 = UsineDePiece.genererTetromino();
		assertNotNull(piece3);

		Tetromino piece4 = UsineDePiece.genererTetromino();
		assertNotNull(piece4);
	}

	// test du cas ALEATOIRE_COMPLET
	@Test
	public void testGenererTetrominoModeAleatoireComplet() {
		UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
		Tetromino piece1 = UsineDePiece.genererTetromino();
		assertNotNull(piece1);
		Tetromino piece2 = UsineDePiece.genererTetromino();
		assertNotNull(piece2);
		assertNotEquals(piece1.getClass(), piece2.getClass());
	}

	// Test de génération aléatoire - Vérification de la diversité des pièces
	@Test
	public void testDiversitePiecesGeneres() {
		UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
		Tetromino previousPiece = null;
		boolean foundDifferentType = false;

		for (int i = 0; i < 10; i++) {
			Tetromino piece = UsineDePiece.genererTetromino();
			assertNotNull(piece);

			if (previousPiece != null && !piece.getClass().equals(previousPiece.getClass())) {
				foundDifferentType = true;
				break;
			}

			previousPiece = piece;
		}

		assertTrue(foundDifferentType);

	}

}
