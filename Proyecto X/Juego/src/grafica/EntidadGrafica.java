package grafica;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

import logica.Celda;

/**
 * Clase EntidadGrafica
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
 * @version Noviembre/2015
 */
public abstract class EntidadGrafica {

	//Atributos
	protected static final int mover = 1;
	protected JLabel grafico;
	protected Icon imagenes[];
	protected Icon movimiento[];
	protected final int ancho = 32;
	protected final int alto = 32;
	protected long velocidad;
	protected Point posicion;

	//Constructor
	/**
	 * Constructor de la clase, protegido, la clase es abstracta. Recibe un par (x,y) que es su posici�n, y un entero que indica la velocidad.
	 * @param y Coordenada 1
	 * @param x Coordenada 2
	 * @param vel Entero que indica la velocidad.
	 */
	protected EntidadGrafica(int y, int x, int vel) {
		posicion = new Point(x*ancho , y*alto);
		imagenes = new Icon[4];
		velocidad=(50-(vel*10));

		movimiento = new Icon[4];

	}

	/**
	 * Retorna la velocidad.
	 * @return entero que indica la velocidad.
	 */
	public float getVelocidad() {
		return velocidad;
	}

	/**
	 * Retorna la posici�n.
	 * @return la posici�n en el frame.
	 */
	public Point getPosicion() {
		return posicion;
	}

	/**
	 * Setea la velocidad seg�n la dada por par�metro.
	 * @param velocidad Nueva velocidad.
	 */
	public void setVelocidad(int velocidad){
		this.velocidad/=2;	
	}

	/**
	 * Cambia el gr�fico segun el movimiento realizado.
	 */
	protected void cambiarIcono(int dir){
		int direccion = -1;

		switch (dir){
		case Celda.UP : 
			direccion = 0;
			break;
		case Celda.DOWN : 
			direccion = 1;
			break;
		case Celda.LEFT : 
			direccion = 2;
			break;
		case Celda.RIGHT : 
			direccion = 3;
			break;
		}


		grafico.setIcon(imagenes[direccion]);
	}

	/**
	 * Realiza el movimiento del personaje seg�n la direcci�n que indica el usuario.
	 * @param dir Entero que indica la direccion en que se movi� el personaje.
	 */
	public void mover(int dir){
		if(grafico != null){	
			cambiarMovimiento(dir);	
			try {
				switch (dir){
				case Celda.UP : // Arriba
					for(int i = 0; i < alto; i +=mover){
						grafico.setBounds(posicion.x, posicion.y -=mover, ancho, alto);
						Thread.sleep(velocidad);
					}
					grafico.setIcon(imagenes[0]);
					break;
				case Celda.DOWN : // Abajo
					for(int i = 0; i < alto; i +=mover){
						grafico.setBounds(posicion.x, posicion.y +=mover, ancho, alto);
						Thread.sleep(velocidad);
					}
					grafico.setIcon(imagenes[1]);
					break;
				case Celda.LEFT : // izquierda
					for(int i = 0; i < ancho; i +=mover){
						grafico.setBounds(posicion.x -=mover, posicion.y, ancho, alto);
						Thread.sleep(velocidad);
					}
					grafico.setIcon(imagenes[2]);
					break;
				case Celda.RIGHT : // Derecha
					for(int i = 0; i < ancho; i += mover){
						grafico.setBounds(posicion.x +=mover, posicion.y, ancho, alto);
						Thread.sleep(velocidad);
					}
					grafico.setIcon(imagenes[3]);
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	protected void cambiarMovimiento(int d){
		int direccion = -1;
		switch (d){
		case Celda.UP : 
			direccion = 0;
			break;
		case Celda.DOWN : 
			direccion = 1;
			break;
		case Celda.LEFT : 
			direccion = 2;
			break;
		case Celda.RIGHT : 
			direccion = 3;
			break;
		}		
		grafico.setIcon(movimiento[direccion]);
	}

	/**
	 * Retorna el gr�fico asociado.
	 * @return atributo gr�fico de tipo JLabel.
	 */
	public JLabel getGrafico(){
		if(grafico == null){
			grafico = new JLabel(imagenes[1]);
			grafico.setBounds(posicion.x, posicion.y, ancho, alto);
		}

		return grafico;
	}

	/**
	 * Setea gr�fico segun el par�metro.
	 * @param graf JLabel para setear el gr�fico.
	 */
	public void setGrafico(JLabel graf){
		grafico = graf;
	}

	/**
	 * Setea la imagen de gr�fico segun el par�metro.
	 * @param imagen Icon para setear en gr�fico.
	 */
	public void setIcon(Icon imagen){
		grafico.setIcon(imagen);
	}



}
