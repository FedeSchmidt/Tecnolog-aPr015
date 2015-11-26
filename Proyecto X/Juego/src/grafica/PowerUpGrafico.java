package grafica;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * Clase PowerUpGrafico
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class PowerUpGrafico {

	//Atributos
	protected JLabel grafico;
	protected Icon imagen;
	protected final int ancho = 32;
	protected final int alto = 32;
	protected Point posicion;

	//Constructor
	/**
	 *  Constructor de la clase. Recibe un par (x,y) que es su posición.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 */
	public PowerUpGrafico(int x, int y){

		posicion=new Point (x* ancho, y*alto);

	}

	//comandos y consultas.
	/**
	 * Retorna la posición.
	 * @return la posición en el frame.
	 */
	public Point getPosicion(){
		return posicion;
	}

	/**
	 * Setea gráfico segun el parámetro.
	 * @param label Icon para setear el gráfico.
	 */
	public void setGrafico(Icon label){
		imagen=label;
		grafico = new JLabel(imagen);
	}

	/**
	 * Retorna el gráfico asociado.
	 * @return atributo gráfico de tipo JLabel.
	 */
	public JLabel getGrafico(){
		if(grafico == null){
			grafico = new JLabel(imagen);
			grafico.setBounds(posicion.y, posicion.x, ancho, alto);
		}

		return grafico;
	}

}
