package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

/**
 * Clase PanelHeader
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
 * @version Noviembre/2015
 */
public class PanelHeader extends JPanel {		

	private static final long serialVersionUID = 1L;

	//Atributos
	private JLabel panel;

	/**
	 * Panel superior en la interfaz gr�fica
	 */
	public PanelHeader () {
		setLayout(new BorderLayout(0, 0));		
		panel = new JLabel();
		panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesPersonajes/PanelSuperior.png")));
		panel.setSize(998,115);
		this.add(panel);		
	}
}
