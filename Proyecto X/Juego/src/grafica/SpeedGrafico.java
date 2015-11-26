package grafica;

import javax.swing.ImageIcon;

/**
 * Clase SpeedGrafico
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class SpeedGrafico extends PowerUpGrafico {

	//Constructor
	/**
	 * Constructor de la clase. Recibe par (x,y) que indica su posición.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 */
	public SpeedGrafico (int x, int y){
		super(x,y);
		imagen = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/SpeedUp.png"));

	}

}
