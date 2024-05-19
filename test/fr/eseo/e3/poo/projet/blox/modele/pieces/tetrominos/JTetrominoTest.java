package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

class JTetrominoTest {

	// test du constructeur de Jtetromino
		@Test
		public void testConstructeur() {
			Coordonnees cordonnees = new Coordonnees(3, 5);
			JTetromino tetromino = new JTetromino(cordonnees, Couleur.BLEU);

			Element[] elemt = tetromino.getElements();
			assertEquals(new Element(new Coordonnees(3, 5), Couleur.BLEU), elemt[0]);
			assertEquals(new Element(cordonnees.getAbscisse() - 1, cordonnees.getOrdonnee(), Couleur.BLEU), elemt[1]);
			assertEquals(new Element(cordonnees.getAbscisse(), cordonnees.getOrdonnee() - 1, Couleur.BLEU), elemt[2]);
			assertEquals(new Element(cordonnees.getAbscisse() , cordonnees.getOrdonnee() -2, Couleur.BLEU), elemt[3]);

		}

		// test des setters et des getters 
		@Test
		public void testSetter() {
			Coordonnees cordonnees = new Coordonnees(3, 5);
			JTetromino tetromino = new JTetromino(new Coordonnees(0, 0), Couleur.BLEU);

			tetromino.setElements(cordonnees, Couleur.CYAN);
			Element[] elemt = tetromino.getElements();
			assertEquals(new Element(new Coordonnees(3, 5), Couleur.CYAN), elemt[0]);
			assertEquals(new Element(cordonnees.getAbscisse() -1, cordonnees.getOrdonnee(), Couleur.CYAN), elemt[1]);
			assertEquals(new Element(cordonnees.getAbscisse(), cordonnees.getOrdonnee() - 1, Couleur.CYAN), elemt[2]);
			assertEquals(new Element(cordonnees.getAbscisse() , cordonnees.getOrdonnee() - 2, Couleur.CYAN), elemt[3]);

		}

		// test de setPosition
		@Test
		public void testSetPos() {
			JTetromino tetromino1 = new JTetromino(new Coordonnees(0, 0), Couleur.BLEU);

			tetromino1.setPosition(6, 6);
			Element[] elemt = tetromino1.getElements();
			assertEquals(new Element(new Coordonnees(6, 6), Couleur.BLEU), elemt[0]);
			assertEquals(new Element(5, 6, Couleur.BLEU), elemt[1]);
			assertEquals(new Element(6, 5, Couleur.BLEU), elemt[2]);
			assertEquals(new Element(6, 4, Couleur.BLEU), elemt[3]);

		}

		@Test
		// test de la representation textuelle
		public void testToString() {
			JTetromino tetromino = new JTetromino(new Coordonnees(3, 5), Couleur.BLEU);

			// assertEquals(null,tetro.getElements());
			assertEquals("JTetromino :\n" + "	" + "(3, 5) - BLEU" + "\n" + "	" + "(2, 5) - BLEU" + "\n" + "	"
					+ "(3, 4) - BLEU" + "\n" + "	" + "(3, 3) - BLEU" + "\n", tetromino.toString());
		}

		// Test methode tourner
		@Test
		public void testTourner() throws BloxException {
			JTetromino tetromino = new JTetromino(new Coordonnees(3, 5), Couleur.ROUGE);

			tetromino.tourner(true); 
			Element[] elemt = tetromino.getElements();
			assertEquals(new Element(new Coordonnees(3, 5), Couleur.ROUGE), elemt[0]);
			assertEquals(new Element(new Coordonnees(3, 4), Couleur.ROUGE), elemt[1]);
			assertEquals(new Element(new Coordonnees(4, 5), Couleur.ROUGE), elemt[2]);
			assertEquals(new Element(new Coordonnees(5, 5), Couleur.ROUGE), elemt[3]);
		}

		// Test d'un deplacement vers la droite
		@Test
		public void deplacerDeHori() throws BloxException {
			JTetromino tetromino = new JTetromino(new Coordonnees(5, 5), Couleur.ROUGE);
			tetromino.deplacerDe(1, 0);
			assertEquals(6, tetromino.getElements()[0].getCoordonnees().getAbscisse());
			assertEquals(5, tetromino.getElements()[0].getCoordonnees().getOrdonnee());
			tetromino.deplacerDe(-1, 0);
			tetromino.deplacerDe(0, 1);
			tetromino.deplacerDe(-1, 1);
			tetromino.deplacerDe(1, 1);
		}

		// Test d'un deplacement impossible
		@Test
		public void deplacerDeNonVertical() {
			JTetromino tetromino = new JTetromino(new Coordonnees(5, 5), Couleur.ROUGE);
			IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,() -> tetromino.deplacerDe(0, -6));
			assertEquals("Le déplacement est invalide.", exception.getMessage());
		}
		
		// Test d'un deplacement avec erreur
		@Test
		public void deplacerErreurPuits() throws BloxException {
			JTetromino tetromino = new JTetromino(new Coordonnees(5, 5), Couleur.ROUGE);
			tetromino.deplacerDe(0, 1);
			
		}
}
