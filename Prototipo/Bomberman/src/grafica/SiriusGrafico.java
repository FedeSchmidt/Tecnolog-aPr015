package grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase SiriusGrafico
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public class SiriusGrafico extends EntidadGrafica{

	//Constructor
	/**
	 * Constructor de clase. Recibe dos enteros indicando su posición y otro su velocidad.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 * @param v Entero indicando su velocidad.
	 */
	public SiriusGrafico (int x, int y, int v){
		super (x, y, v);

		//imagenes
		imagenes[0] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/siruis.png"));
		imagenes[1] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/siruis.png"));
		imagenes[2] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/siruis.png"));
		imagenes[3] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/siruis.png"));
	}



}