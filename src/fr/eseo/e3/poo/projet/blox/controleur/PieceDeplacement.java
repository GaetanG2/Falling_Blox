package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacement extends MouseAdapter {
	private VuePuits vuePuits;
	private Puits puits;

	private int derniereColon = -1;

	public PieceDeplacement(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
	}
	//Méthode invoquée lorsque la souris est déplacée au-dessus de la zone de jeu.
	@Override
	public void mouseMoved(MouseEvent event) {
		if (puits != null && vuePuits.getPuits().getPieceActuelle() != null) {
			int mouseX = event.getX();
			int mouseY = event.getY();

			if (mouseX >= 0 && mouseX < vuePuits.getWidth() && mouseY >= 0 && mouseY < vuePuits.getHeight()) {

				int column = getColumnUnderMouse(event.getX(), event.getY());

				if (derniereColon == -1) {
					derniereColon = column;
				} else {
					if (column != derniereColon) {

						try {
							int delta = column - derniereColon;
							if (delta < -1) {
								delta = -1;
							} else if (delta > 1) {
								delta = 1;
							}
							puits.getPieceActuelle().deplacerDe(delta, 0);
							derniereColon = column;
						} catch (IllegalArgumentException e) {
							System.out.println("Impossible de déplacer la pièce : " + e.getMessage());
						} catch (BloxException e) {
							System.out.println("Impossible de déplacer la pièce" + e.getMessage());
						}
					}
				}
			}
		}
		this.vuePuits.repaint();
	}

	private int getColumnUnderMouse(int x, int y) {
		int columnWidth = vuePuits.getTaille();
		return x / columnWidth;
	}

	public Puits getPuits() {
		return puits;
	}

	public void setPuits(Puits puits) {
		this.puits = puits;
	}

	public void mouseEntered(java.awt.event.MouseEvent event) {
		derniereColon = -1;
	}
	//Méthode invoquée lors du défilement de la molette de la souris pour faire déplacer la piece veticalement.
	public void mouseWheelMoved(java.awt.event.MouseWheelEvent event) {
		if (puits != null && vuePuits.getPuits().getPieceActuelle() != null) {
			int wheelRotation = event.getWheelRotation();

			if (wheelRotation > 0) {
				try {
					puits.getPieceActuelle().deplacerDe(0, 1);
				} catch (IllegalArgumentException e) {
					System.out.println("Impossible de déplacer la pièce : " + e.getMessage());
				} catch (BloxException e) {
					System.out.println("Impossible de déplacer la pièce" + e.getMessage());
				}
			}
		}
		vuePuits.repaint();
	}

}
