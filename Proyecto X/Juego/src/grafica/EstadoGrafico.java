package grafica;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase EstadoGrafico
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public abstract class EstadoGrafico {

	//Atributos
	protected JLabel grafico;
	protected JLabel graficoExplosion;
	protected Icon imagen;
	protected Icon[] explosion;
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
		explosion = new Icon[2];
		explosion[0] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/explosion.png"));
		explosion[1] = new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/explosion2.png"));
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
	 * Retorna el gráfico de explosion asociado.
	 * @return atributo gráfico de la explosion de tipo JLabel.
	 */
	public JLabel getExplotar(){
		if(graficoExplosion == null){
			graficoExplosion = new JLabel(explosion[0]);
			graficoExplosion.setBounds(posicion.x, posicion.y, ancho, alto);
		}
		return graficoExplosion;
	}

	/**
	 * Modifica la imagen de la explosion de ExplosionGrafico
	 * @param i Número de explosión.
	 */
	public void cambiarExplosion(int i){
		graficoExplosion.setIcon(explosion[i]);
	}


}
