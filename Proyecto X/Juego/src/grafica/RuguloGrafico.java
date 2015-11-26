package grafica;

import javax.swing.ImageIcon;

/**
 * Clase RuguloGrafico
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class RuguloGrafico extends EntidadGrafica{

	//Constructor
	/**
	 * Constructor de clase. Recibe dos enteros indicando su posición y otro su velocidad.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 * @param v Entero indicando su velocidad.
	 */
	public RuguloGrafico (int x, int y, int v){
		super (x, y, v);

		//imagenes
		imagenes[0] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Rugulo/arriba.png"));
		imagenes[1] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Rugulo/abajo.png"));
		imagenes[2] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Rugulo/derecha.png"));
		imagenes[3] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Rugulo/izquierda.png"));
		//movimiento
		movimiento[0] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Rugulo/arriba.png"));
		movimiento[1] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Rugulo/abajo.png"));
		movimiento[3] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Rugulo/derecha.png"));
		movimiento[2] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Rugulo/izquierda.png"));
	}


}