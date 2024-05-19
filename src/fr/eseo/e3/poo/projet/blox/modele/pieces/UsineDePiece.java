package fr.eseo.e3.poo.projet.blox.modele.pieces;

import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.JTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.LTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.STetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.TTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ZTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;

public class UsineDePiece {

	public static final int ALEATOIRE_COMPLET = 3;
	public static final int ALEATOIRE_PIECE = 2;
	public static final int CYCLIC = 1;

	public static int mod = ALEATOIRE_PIECE;
	private static Random rand = new Random();
	public static int typee = 0;

	// Constructeur de la methode usineDePiece
	private UsineDePiece() {

	}

	// Maj d'un mode pour la generation d'un tetromino
	public static void setMode(int mode) {
		if (mode == 1) {
			mod = CYCLIC;
		} else if (mode == 2) {
			mod = ALEATOIRE_PIECE;
		} else if (mode == 3) {
			mod = ALEATOIRE_COMPLET;
		}
	}


	public static Tetromino genererTetromino() {
        Tetromino piece = null;
        switch (mod) {
            case CYCLIC:
                piece = genererTetrominoCyclic();
                break;
            case ALEATOIRE_PIECE:
                piece = genererTetrominoAleatoirePiece();
                break;
            case ALEATOIRE_COMPLET:
                piece = genererTetrominoAleatoireComplet();
                break;
		default:
			break;
        }
        return piece;
    }

	private static Tetromino genererTetrominoCyclic() {
		Tetromino piece = null;
		
		if (typee == 0) {
			piece = new OTetromino(new Coordonnees(2, 3), Couleur.ROUGE);
			UsineDePiece.typee += 1;
		} else if (typee == 1) {
			piece = new ITetromino(new Coordonnees(2, 3), Couleur.ORANGE);
			UsineDePiece.typee += 1;
		} else if (typee == 2) {
			piece = new TTetromino(new Coordonnees(2, 3), Couleur.BLEU);
			UsineDePiece.typee += 1;
		} else if (typee == 3) {
			piece = new LTetromino(new Coordonnees(2, 3), Couleur.VERT);
			UsineDePiece.typee += 1;
		} else if (typee == 4) {
			piece = new JTetromino(new Coordonnees(2, 3), Couleur.JAUNE);
			UsineDePiece.typee += 1;
		} else if (typee == 5) {
			piece = new ZTetromino(new Coordonnees(2, 3), Couleur.CYAN);
			UsineDePiece.typee += 1;
		} else if (typee == 6) {
			piece = new STetromino(new Coordonnees(2, 3), Couleur.VIOLET);
			UsineDePiece.typee = 0;
		}
		return piece;

	}

	private static Tetromino genererTetrominoAleatoirePiece() {
		Tetromino piece = null;
		String[] types = { "O", "I", "T", "L", "J", "Z", "S" };
		int type = rand.nextInt(7);

		if (types[type].equals("O")) {
			piece = new OTetromino(new Coordonnees(2, 3), Couleur.ROUGE);
		} else if (types[type].equals("I")) {
			piece = new ITetromino(new Coordonnees(2, 3), Couleur.ORANGE);
		} else if (types[type].equals("T")) {
			piece = new TTetromino(new Coordonnees(2, 3), Couleur.BLEU);
		} else if (types[type].equals("L")) {
			piece = new LTetromino(new Coordonnees(2, 3), Couleur.VERT);
		} else if (types[type].equals("J")) {
			piece = new JTetromino(new Coordonnees(2, 3), Couleur.JAUNE);
		} else if (types[type].equals("Z")) {
			piece = new ZTetromino(new Coordonnees(2, 3), Couleur.CYAN);
		} else if (types[type].equals("S")) {
			piece = new STetromino(new Coordonnees(2, 3), Couleur.VIOLET);
		}
		return piece;

	}

	private static Tetromino genererTetrominoAleatoireComplet() {

		Tetromino piece = null;

		String[] types = { "O", "I", "T", "L", "J", "Z", "S" };
		int type = rand.nextInt(7);
		Couleur[] couleur = Couleur.values();
		int coul = rand.nextInt(7);
		if (types[type].equals("O")) {
			piece = new OTetromino(new Coordonnees(2, 3), couleur[coul]);
		} else if (types[type].equals("I")) {
			piece = new ITetromino(new Coordonnees(2, 3), couleur[coul]);
		} else if (types[type].equals("T")) {
			piece = new TTetromino(new Coordonnees(2, 3), couleur[coul]);
		} else if (types[type].equals("L")) {
			piece = new LTetromino(new Coordonnees(2, 3), couleur[coul]);
		} else if (types[type].equals("J")) {
			piece = new JTetromino(new Coordonnees(2, 3), couleur[coul]);
		} else if (types[type].equals("Z")) {
			piece = new ZTetromino(new Coordonnees(2, 3), couleur[coul]);
		} else if (types[type].equals("S")) {
			piece = new STetromino(new Coordonnees(2, 3), couleur[coul]);
		}
		return piece;

	}

}
