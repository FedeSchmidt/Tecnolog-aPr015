package grafica;

import javax.swing.ImageIcon;

/**
 * Clase EstadoLibreGrafico
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
 * @version Noviembre/2015
 */
public class EstadoLibreGrafico extends EstadoGrafico{

	//Constructor
	/**
	 * Constructor de la clase.Recibe un par (x,y) que indica su posici�n.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 */
	public EstadoLibreGrafico(int x, int y) {
		super(x, y);
		this.imagen = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Estado-Libre.png"));
	}

}
