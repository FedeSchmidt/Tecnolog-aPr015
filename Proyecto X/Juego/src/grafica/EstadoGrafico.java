package grafica;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase EstadoGrafico
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
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
	 * Constructor de la clase, protegido. La clase es abstracta. Recibe un par (x,y) que indica su posici�n.
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
	 * Retorna la posici�n.
	 * @return la posici�n en el frame.
	 */
	public Point getPosicion(){
		return posicion;
	}

	/**
	 * Retorna el gr�fico asociado.
	 * @return atributo gr�fico de tipo JLabel.
	 */
	public JLabel getGrafico(){
		if(grafico == null){
			grafico = new JLabel(imagen);
			grafico.setBounds(posicion.x, posicion.y, ancho, alto);
		}
		return grafico;
	}

	/**
	 * Retorna el gr�fico de explosion asociado.
	 * @return atributo gr�fico de la explosion de tipo JLabel.
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
	 * @param i N�mero de explosi�n.
	 */
	public void cambiarExplosion(int i){
		graficoExplosion.setIcon(explosion[i]);
	}


}
