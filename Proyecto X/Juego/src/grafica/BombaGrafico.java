package grafica;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase BombaGrafico
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class BombaGrafico {

	//Atributos
	protected JLabel grafico;
	protected Icon imagen;
	protected final int ancho = 32;
	protected final int alto = 32;
	protected Point posicion;

	//Constructor
	/**
	 * Constructor de la clase. Recibe un par de enteros que indican la posición.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 */
	public BombaGrafico(int y, int x){

		posicion=new Point (x* ancho, y*alto);
		imagen = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/bomb_32.png"));

	}

	//Comandos y consultas.
	/**
	 * Retorna la posición.
	 * @return la posición en el frame.
	 */
	public Point getPosicion(){
		return posicion;
	}

	/**
	 * Retorna el gráfico asociado.
	 * @return atributo gráfico de tipo JLabel.
	 */
	public JLabel getGrafico(){
		if(grafico == null){
			grafico = new JLabel(imagen);
			grafico.setBounds(posicion.x, posicion.y, ancho, alto);
		}

		return grafico;
	}

}
