package grafica;

import javax.swing.ImageIcon;

/**
 * Clase SiriusGrafico
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
 * @version Noviembre/2015
 */
public class SiriusGrafico extends EntidadGrafica{

	//Constructor
	/**
	 * Constructor de clase. Recibe dos enteros indicando su posici�n y otro su velocidad.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 * @param v Entero indicando su velocidad.
	 */
	public SiriusGrafico (int x, int y, int v){
		super (x, y, v);

		//imagenes
		imagenes[0] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Sirius/arriba.png"));
		imagenes[1] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Sirius/abajo.png"));
		imagenes[3] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Sirius/derecha.png"));
		imagenes[2] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Sirius/izquierda.png"));

		//movimiento
		movimiento[0] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Sirius/arriba.gif"));
		movimiento[1] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Sirius/abajo.gif"));
		movimiento[3] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Sirius/derecha.gif"));
		movimiento[2] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/Sirius/izquierda.gif"));


	}

}