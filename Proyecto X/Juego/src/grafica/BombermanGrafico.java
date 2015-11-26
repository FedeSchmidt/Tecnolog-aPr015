package grafica;

import javax.swing.ImageIcon;

/**
 * Clase BombermanGrafico
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class BombermanGrafico extends EntidadGrafica{

	//Constructor
	/**
	 * Constructor de clase. Recibe dos enteros indicando su posición y otro su velocidad.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 * @param v Entero indicando su velocidad.
	 */
	public BombermanGrafico(int x, int y, int v) {
		super(x, y, v);

		imagenes[0] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Bomberman/BombermanArriba.png"));
		imagenes[1] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Bomberman/BombermanAbajo.gif"));
		imagenes[2] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Bomberman/BombermanIzquierda.gif"));
		imagenes[3] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Bomberman/BombermanDerecha.gif"));

		movimiento[0] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Bomberman/arriba.gif"));
		movimiento[1] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Bomberman/abajo.gif"));
		movimiento[2] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Bomberman/izquierda.gif"));
		movimiento[3] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Bomberman/derecha.gif"));

	}







}
