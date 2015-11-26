package grafica;

import javax.swing.ImageIcon;

/**
 * Clase AltairGrafico
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class AltairGrafico extends EntidadGrafica{

	//Constructor
	/**
	 * Constructor de clase. Recibe dos enteros indicando su posición y otro su velocidad.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 * @param v Entero indicando su velocidad.
	 */
	public AltairGrafico (int x, int y, int v){
		super (x, y, v);

		//imagenes
		imagenes[0] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Altair/arriba.png"));
		imagenes[1] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Altair/abajo.png"));
		imagenes[2] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Altair/derecha.png"));
		imagenes[3] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Altair/izquierda.png"));
		
		//movimiento
		movimiento[0] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Altair/arriba.gif"));
		movimiento[1] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Altair/abajo.gif"));
		movimiento[2] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Altair/izquierda.gif"));
		movimiento[3] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Altair/derecha.gif"));
	}



}
