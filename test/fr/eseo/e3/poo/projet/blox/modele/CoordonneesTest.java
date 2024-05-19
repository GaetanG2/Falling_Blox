package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.Assert.assertTrue;
//Importation des assertions de JUnit pour les tests
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

//Importation de l'annotation @Test de JUnit
import org.junit.jupiter.api.Test;

public class CoordonneesTest {

	// Test de la méthode getAbscisse
	@Test
	public void testGetAbscisse() {
		Coordonnees cord = new Coordonnees(3, 4);
		assertEquals(3, cord.getAbscisse(), "L'abscisse ne correspond pas");
	}

	// Test de la méthode getOrdonnee
	@Test
	public void testGetOrdonnee() {
		Coordonnees cord = new Coordonnees(3, 4);
		assertEquals(4, cord.getOrdonnee(), "L'ordonnee ne correspond pas");
	}

	// Test de la méthode setAbscisse
	@Test
	public void testSetAbscisse() {
		Coordonnees cord = new Coordonnees(3, 4);
		cord.setAbscisse(9);
		assertEquals(9, cord.getAbscisse(), "L'abscisse n'a pas été correctement modifiée");
	}

	// Test de la méthode setOrdonnee
	@Test
	public void testSetOrdonnee() {
		Coordonnees cord = new Coordonnees(3, 4);
		cord.setOrdonnee(5);
		assertEquals(5, cord.getOrdonnee(), "L'ordonnee n'a pas été correctement modifiée");
	}

	// Test de la méthode toString
	@Test
	public void testToString() {
		Coordonnees cord = new Coordonnees(3, 4);
		assertEquals("(3, 4)", cord.toString(), "La représentation textuelle de la classe n'est pas correcte");
	}

	// Test de la méthode equals
	@Test
	public void testEquals() {
		Coordonnees coord1 = new Coordonnees(3, 5);
		Coordonnees coord2 = new Coordonnees(3, 5);

		assertTrue(coord1.equals(coord2));

		assertTrue(coord1.equals(coord1));
		assertTrue(coord2.equals(coord2));

		assertFalse(coord1.equals(null));

		assertFalse(coord1.equals("3,5"));

		Coordonnees coord3 = new Coordonnees(3, 6);
		assertFalse(coord1.equals(coord3));

		Coordonnees coord4 = new Coordonnees(4, 5);
		assertFalse(coord1.equals(coord4));
	}

	// Test du hashcode
	@Test
	public void testHashCode() {
		Coordonnees coord1 = new Coordonnees(3, 5);
		Coordonnees coord2 = new Coordonnees(3, 5);

		// Vérification que les hashCodes sont identiques
		assertEquals(coord1.hashCode(), coord2.hashCode());
	}

}
