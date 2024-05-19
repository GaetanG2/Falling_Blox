package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

class ZTetrominoTest {

	// test du constructeur de Ztetromino
		@Test
		public void testConstructeur() {
			Coordonnees cord = new Coordonnees(4, 5);
			ZTetromino tetro = new ZTetromino(cord, Couleur.BLEU);

			Element[] elemt = tetro.getElements();
			assertEquals(new Element(new Coordonnees(4, 5), Couleur.BLEU), elemt[0]);
			assertEquals(new Element(cord.getAbscisse() -1, cord.getOrdonnee()-1 , Couleur.BLEU), elemt[1]);
			assertEquals(new Element(cord.getAbscisse(), cord.getOrdonnee()-1 , Couleur.BLEU), elemt[2]);
			assertEquals(new Element(cord.getAbscisse()+1 , cord.getOrdonnee(), Couleur.BLEU), elemt[3]);

		}

		// test des setters et des getters
		@Test
		public void testSetter() {
			Coordonnees cord = new Coordonnees(3, 5);
			ZTetromino tetro = new ZTetromino(new Coordonnees(0, 0), Couleur.BLEU);

			tetro.setElements(cord, Couleur.CYAN);
			Element[] elemt = tetro.getElements();
			assertEquals(new Element(new Coordonnees(3, 5), Couleur.CYAN), elemt[0]);
			assertEquals(new Element(cord.getAbscisse() -1, cord.getOrdonnee()-1 , Couleur.CYAN), elemt[1]);
			assertEquals(new Element(cord.getAbscisse(), cord.getOrdonnee()-1 , Couleur.CYAN), elemt[2]);
			assertEquals(new Element(cord.getAbscisse() +1, cord.getOrdonnee(), Couleur.CYAN), elemt[3]);

		}

		// test de setPosition
		@Test
		public void testSetPosi() {
			ZTetromino tetro = new ZTetromino(new Coordonnees(0, 0), Couleur.BLEU);

			tetro.setPosition(6, 6);
			Element[] elemt = tetro.getElements();
			assertEquals(new Element(new Coordonnees(6, 6), Couleur.BLEU), elemt[0]);
			assertEquals(new Element(5, 5, Couleur.BLEU), elemt[1]);
			assertEquals(new Element(6, 5, Couleur.BLEU), elemt[2]);
			assertEquals(new Element(7, 6, Couleur.BLEU), elemt[3]);

		}

		// Test methode tourner
		@Test
		public void testTourner() throws BloxException {
			ZTetromino tetro = new ZTetromino(new Coordonnees(3, 3), Couleur.ROUGE);
			ZTetromino tetro1 = new ZTetromino(new Coordonnees(3, 3), Couleur.BLEU);

			tetro.tourner(true);
			Element[] elemt = tetro.getElements();
			assertEquals(new Element(new Coordonnees(3, 3), Couleur.ROUGE), elemt[0]);
			assertEquals(new Element(new Coordonnees(4, 2), Couleur.ROUGE), elemt[1]);
			assertEquals(new Element(new Coordonnees(4, 3), Couleur.ROUGE), elemt[2]);
			assertEquals(new Element(new Coordonnees(3, 4), Couleur.ROUGE), elemt[3]);

			tetro1.tourner(false);
			Element[] elemt1 = tetro1.getElements();
			assertEquals(new Element(new Coordonnees(3, 3), Couleur.BLEU), elemt1[0]);
			assertEquals(new Element(new Coordonnees(2, 4), Couleur.BLEU), elemt1[1]);
			assertEquals(new Element(new Coordonnees(2, 3), Couleur.BLEU), elemt1[2]);
			assertEquals(new Element(new Coordonnees(3, 2), Couleur.BLEU), elemt1[3]);
		}

		@Test
		// test de la representation textuelle
		public void testToString() {
			ZTetromino tetro = new ZTetromino(new Coordonnees(3, 5), Couleur.BLEU);

			// assertEquals(null,tetro.getElements());
			assertEquals("ZTetromino :\n" + "	" + "(3, 5) - BLEU" + "\n" + "	" + "(2, 4) - BLEU" + "\n" + "	"
					+ "(3, 4) - BLEU" + "\n" + "	" + "(4, 5) - BLEU" + "\n", tetro.toString());
		}

		// Test d'un deplacement vers la droite
		@Test
		public void deplacerDeHori() throws BloxException {
			ZTetromino tetro = new ZTetromino(new Coordonnees(5, 5), Couleur.ROUGE);
			tetro.deplacerDe(1, 0);
			assertEquals(6, tetro.getElements()[0].getCoordonnees().getAbscisse());
			assertEquals(5, tetro.getElements()[0].getCoordonnees().getOrdonnee());
		}

		// Test d'un deplacement impossible
		@Test
		public void deplacerDeNonVertical() {
			ZTetromino tetro = new ZTetromino(new Coordonnees(5, 5), Couleur.ROUGE);
			IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
					() -> tetro.deplacerDe(0, -6));
			assertEquals("Le déplacement est invalide.", exception.getMessage());
		}

}
