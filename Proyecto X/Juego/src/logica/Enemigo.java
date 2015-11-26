package logica;

import Threads.EnemigoThread;

/**
 * Clase Enemigo
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
 * @version Noviembre/2015
 */
public abstract class Enemigo extends Personaje {

	//Atributos
	protected int valor;
	protected EnemigoThread hilo;

	//Constructor
	/**
	 * Constructor de la clase. Protegido, clase abstracto. Recibe un nivel, celda, velocidad del enemigo, boolean indicando si tiene poder y el valor del enemigo.
	 * @param n Nivel en el que se encuentra el enemigo.
	 * @param c Celda en la que se encuentra el enemigo.
	 * @param vel Velocidad del enemigo.
	 * @param p Boolean que indica si el enemigo tiene o no poder.
	 * @param valor Valor del enemigo.
	 */
	protected Enemigo (Nivel n, Celda c, int vel, boolean p, int valor){
		super (n, c, vel, p);
		this.valor=valor;
		hilo = new EnemigoThread(this);
	}

	//comandos y consultas
	/**
	 * Retorna el valor del enemigo.
	 * @return Entero que es el valor del enemigo.
	 */
	public int getValor(){
		return valor;
	}

	/**
	 * Desarrollo de la muerte del enemigo.
	 * @return Entero que es el valor del enemigo.
	 */
	public int morir(){
		miCelda.eliminarEnemigo(this);
		miCelda.getNivel().eliminarEnemigo(this);
		miCelda.getNivel().getJuego().getEnemigos().remove(this);		
		this.getNivel().getJuego().getGui().removeMapa(this.getGrafico().getGrafico());
		hilo.morir();
		return valor;
	}
	/**
	 * Hilo que maneja al Enemigo.
	 * @return Hilo que maneja el comportamiento del enemigo.
	 */
	public EnemigoThread getHilo(){
		return hilo;
	}

	/**
	 * M�todo abstracto que maneja el movimiento del enemigo.
	 */
	public abstract void mover();

}
