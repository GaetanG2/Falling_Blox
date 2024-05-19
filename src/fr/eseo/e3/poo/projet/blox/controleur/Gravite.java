package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class Gravite implements ActionListener {
	private final VuePuits vuePuits;
	private final Puits puits;
	private Timer timer;

	public Gravite(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
		this.timer = new Timer(5000, this);
		this.timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (this.puits != null) {
			this.puits.gravite();
			this.vuePuits.repaint();
		}
	}

	public int getPeriodicite() {
		return timer.getDelay();
	}

	public void setPeriodicite(int periodicite) {
		timer.setDelay(periodicite);
	}

	public VuePuits getVuePuits() {
		return vuePuits;
	}

	public Puits getPuits() {
		return puits;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
}