package grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase BombermanGrafico
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
 * @version Octubre/2015
 */
public class BombermanGrafico extends EntidadGrafica{

	//Constructor
	/**
	 * Constructor de clase. Recibe dos enteros indicando su posici�n y otro su velocidad.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 * @param v Entero indicando su velocidad.
	 */
	public BombermanGrafico(int x, int y, int v) {
		super(x, y, v);

		imagenes[0] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/BombermanArriba.png"));
		imagenes[1] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/BombermanAbajo.png"));
		imagenes[2] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/BombermanIzquierda.png"));
		imagenes[3] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/BombermanDerecha.png"));

	}


}
