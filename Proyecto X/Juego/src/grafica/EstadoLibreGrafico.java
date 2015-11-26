package grafica;

import javax.swing.ImageIcon;

/**
 * Clase EstadoLibreGrafico
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class EstadoLibreGrafico extends EstadoGrafico{

	//Constructor
	/**
	 * Constructor de la clase.Recibe un par (x,y) que indica su posición.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 */
	public EstadoLibreGrafico(int x, int y) {
		super(x, y);
		this.imagen = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Estado-Libre.png"));
	}

}
