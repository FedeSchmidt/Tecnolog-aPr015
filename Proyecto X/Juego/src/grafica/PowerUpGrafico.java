package grafica;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * Clase PowerUpGrafico
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
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
	 *  Constructor de la clase. Recibe un par (x,y) que es su posici�n.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 */
	public PowerUpGrafico(int x, int y){

		posicion=new Point (x* ancho, y*alto);

	}

	//comandos y consultas.
	/**
	 * Retorna la posici�n.
	 * @return la posici�n en el frame.
	 */
	public Point getPosicion(){
		return posicion;
	}

	/**
	 * Setea gr�fico segun el par�metro.
	 * @param label Icon para setear el gr�fico.
	 */
	public void setGrafico(Icon label){
		imagen=label;
		grafico = new JLabel(imagen);
	}

	/**
	 * Retorna el gr�fico asociado.
	 * @return atributo gr�fico de tipo JLabel.
	 */
	public JLabel getGrafico(){
		if(grafico == null){
			grafico = new JLabel(imagen);
			grafico.setBounds(posicion.y, posicion.x, ancho, alto);
		}

		return grafico;
	}

}
