package grafica;

import javax.swing.ImageIcon;

/**
 * Clase FatalityGrafico
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
 * @version Octubre/2015
 */
public class FatalityGrafico extends PowerUpGrafico {

	//Constructor
	/**
	 * Constructor de la clase. Recibe par (x,y) que indica su posici�n.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 */
	public FatalityGrafico (int x, int y){
		super(x,y);
		imagen = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/fatality.png"));

	}

}
