package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class PanneauInformation extends JPanel implements PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VuePiece vuePiece;
	private Puits puits;

	// Constructeur de la classe PanneauInformation.
	public PanneauInformation(Puits puits) {
		this.puits = puits;
		this.puits.addPropertyChangeListener(this);
		super.setPreferredSize(new Dimension(70, 70));
	} 

	//Méthode pour la modification d'une propriété du puits.
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(Puits.MODIFICATION_PIECE_SUIVANTE)) {
			this.vuePiece = new VuePiece((Piece) evt.getNewValue(), 10);
			this.repaint();
		}
	}
	//Methode pour afficher la piece suivante si elle est disponible 
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (this.vuePiece != null) {
			this.vuePiece.afficherPiece((Graphics2D) g);
		}
		
	} 
}
 