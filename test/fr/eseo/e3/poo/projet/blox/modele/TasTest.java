package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;


import org.junit.jupiter.api.Test;

public class TasTest {

	// test du constructeur de tas
	@Test
	public void testTasConstruction() {
		Tas tas = new Tas(new Puits(), 10, 3);
		assertNotNull(tas);
		assertEquals(10, tas.getElements().size());
	}
	
	//test de la methode ElementsExists de tas
	@Test
	public void testTasElementExists() {
		Tas tas = new Tas(new Puits(), 10, 3);
		assertFalse(tas.elementExists(2, 1));
		assertFalse(tas.elementExists(5, 5));
	}
	
	//Test d'un ajout d'element au tas
	@Test
	public void testAjouterElements() {
	    Tas tas = new Tas(new Puits());
	    Piece piece = new OTetromino(new Coordonnees(3, 5), Couleur.BLEU);
	    tas.ajouterElements(piece);
	    for (Element element : piece.getElements()) {
	        assertTrue(tas.elementExists(element.getCoordonnees().getAbscisse(), element.getCoordonnees().getOrdonnee()));
	    } 
	}


}
