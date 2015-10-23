package grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase EstadoDestructibleGrafico
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public class EstadoDestructibleGrafico extends EstadoGrafico {

	//Constructor
	/**
	 * Constructor de la clase.Recibe un par (x,y) que indica su posición.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 */
	public EstadoDestructibleGrafico(int x, int y) {
		super(x, y);
		this.imagen = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Destructible.png"));
		//this.explosion = null;
	}

	public void explotar(){		
		//todavía no implementado.
	}

}
