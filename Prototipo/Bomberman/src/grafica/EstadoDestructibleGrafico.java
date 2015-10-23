package grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase EstadoDestructibleGrafico
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
 * @version Octubre/2015
 */
public class EstadoDestructibleGrafico extends EstadoGrafico {

	//Constructor
	/**
	 * Constructor de la clase.Recibe un par (x,y) que indica su posici�n.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 */
	public EstadoDestructibleGrafico(int x, int y) {
		super(x, y);
		this.imagen = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Destructible.png"));
		//this.explosion = null;
	}

	public void explotar(){		
		//todav�a no implementado.
	}

}
