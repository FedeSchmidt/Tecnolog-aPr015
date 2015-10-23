package grafica;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * Clase EstadoGrafico
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public abstract class EstadoGrafico {

	//Atributos
	protected JLabel grafico;
	protected Icon imagen;
	//protected Icon explosion;
	protected Point posicion;
	protected final int ancho = 32;
	protected final int alto = 32;	

	//constructor
	/**
	 * Constructor de la clase, protegido. La clase es abstracta. Recibe un par (x,y) que indica su posición.
	 * @param x Coordenada 1
	 * @param y Coordenada 2
	 */
	protected  EstadoGrafico(int x, int y){
		posicion = new Point(y * ancho, x * alto);
	}

	//comandos  y consultas.
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

	/**
	 * Operación abstracta, debe definirse en clases herederas.
	 */
	public abstract void explotar();


}
