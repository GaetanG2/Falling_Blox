package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotation extends MouseAdapter {

	private VuePuits vuePuits;
	private Puits puits;

	public PieceRotation(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
	}
	//Méthode invoquée lors du clic(droit ou gauche) de la souris pour faire tourner la piece.
	@Override
	public void mouseClicked(MouseEvent event) {
		if (SwingUtilities.isRightMouseButton(event)) {
			if (vuePuits.getPuits().getPieceActuelle() != null) {
				try {
					puits.getPieceActuelle().tourner(true);
				} catch (BloxException e) {
				}
				this.vuePuits.repaint();
			}
		} else if (SwingUtilities.isLeftMouseButton(event)) {
			if (vuePuits.getPuits().getPieceActuelle() != null) {
				try {
					puits.getPieceActuelle().tourner(false);
				} catch (BloxException e) {
				}
				this.vuePuits.repaint();
			}
		}
	}

	public Puits getPuits() {
		return puits;
	}

	public void setPuits(Puits puits) {
		this.puits = puits;
	}
}
