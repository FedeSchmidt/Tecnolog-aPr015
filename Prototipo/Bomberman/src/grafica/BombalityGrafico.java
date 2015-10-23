package grafica;

import javax.swing.ImageIcon;

/**
 * Clase BombalityGrafico
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public class BombalityGrafico extends PowerUpGrafico {

	//Constructor
	/**
	 * Constructor de la clase. Recibe par (x,y) que indica su posición.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 */
	public BombalityGrafico (int x, int y){
		super(x,y);
		imagen = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Bombality.png"));

	}

}
