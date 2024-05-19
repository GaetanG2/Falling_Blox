package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class ElementTest {

	// Test des constructeurs avec Coordonnees
	@Test
	public void testconstructeur0() {
		Element elem = new Element(new Coordonnees(3, 4));

		assertEquals(new Coordonnees(3, 4), elem.getCoordonnees(), "Les coordonnees ne correspond pas");
		assertEquals(Couleur.ROUGE, elem.getCouleur(), "La couleur ne correspond pas");
	}

	// Test des constructeurs avec abscisse et ordonnee
	@Test
	public void testConstructeur1() {
		Element elem1 = new Element(8, 4);
		assertEquals(new Coordonnees(8, 4), elem1.getCoordonnees(), "Les coordonnees ne correspond pas");
		assertEquals(Couleur.ROUGE, elem1.getCouleur(), "La couleur ne correspond pas");
	}

	// Test des constructeurs avec Coordonnees et couleur
	@Test
	public void testConstructeur2() {
		Element elem2 = new Element(new Coordonnees(9, 4), Couleur.BLEU);
		assertEquals(new Coordonnees(9, 4), elem2.getCoordonnees(), "Les coordonnees ne correspond pas");
		assertEquals(Couleur.BLEU, elem2.getCouleur(), "La couleur ne correspond pas");
	}

	// Test des constructeurs avec abscisse, ordonnee et couleur
	@Test
	public void testConstructeur3() {
		Element elem3 = new Element(6, 5, Couleur.VERT);
		assertEquals(new Coordonnees(6, 5), elem3.getCoordonnees(), "Les coordonnees ne correspond pas");
		assertEquals(Couleur.VERT, elem3.getCouleur(), "La couleur ne correspond pas");
	}

	// Test des setters et getters
	@Test
	public void testSetters() {

		Element elem = new Element(new Coordonnees(3, 4));

		elem.setCoordonnees(new Coordonnees(2, 7));
		elem.setCouleur(Couleur.JAUNE);
		assertEquals(new Coordonnees(2, 7), elem.getCoordonnees(), "Les coordonnees ne correspond pas");
		assertEquals(Couleur.JAUNE, elem.getCouleur(), "La couleur ne correspond pas");
	}

	// Test de la methode equals
	@Test
	public void testEquals() {
		Coordonnees coord = new Coordonnees(3, 5);
		Element elem1 = new Element(coord, Couleur.ROUGE);
		Element elem2 = new Element(coord, Couleur.ROUGE);

		assertTrue(elem1.equals(elem2));

		assertTrue(elem1.equals(elem1));
		assertTrue(elem2.equals(elem2));

		assertFalse(elem1.equals(null));

		assertFalse(elem1.equals("3,5"));

		Element elem3 = new Element(new Coordonnees(3, 5), Couleur.BLEU);
		assertFalse(elem1.equals(elem3));

		Element elem4 = new Element(new Coordonnees(4, 5), Couleur.ROUGE);
		assertFalse(elem1.equals(elem4));

		assertFalse(elem1.equals(new Element(null, null)));
	}

	// Test de la methode toString
	@Test
	public void testToString() {
		Element elemT = new Element(new Coordonnees(2, 7), Couleur.JAUNE);
		assertEquals("(2, 7) - JAUNE", elemT.toString(), "La representation textuelle de la classe n'est pas correte");
	}

	// Test de la methode deplacerDe
	@Test
	public void testDeplacerDe() {
		Element elem = new Element(new Coordonnees(3, 4));

		elem.deplacerDe(5, 5);
		assertEquals(new Coordonnees(8, 9), elem.getCoordonnees());

	}

	// Test du hashCode
	@Test
	public void testHashCode() {
		Coordonnees coord = new Coordonnees(3, 5);
		Element elem1 = new Element(coord, Couleur.ROUGE);
		Element elem2 = new Element(coord, Couleur.ROUGE);

		assertEquals(elem1.hashCode(), elem2.hashCode());
	}

}
