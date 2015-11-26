package grafica;

import javax.swing.ImageIcon;

/**
 * Clase MasacralityGrafico
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class MasacralityGrafico extends PowerUpGrafico {

	//Constructor
	/**
	 * Constructor de la clase. Recibe par (x,y) que indica su posición.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 */
	public MasacralityGrafico (int x, int y){
		super(x,y);
		imagen = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Masacrallity.png"));

	}

}
