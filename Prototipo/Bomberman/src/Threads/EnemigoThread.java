package Threads;

import gui.GUI;
import Juego.Juego;
import logica.*;

/**
 * Clase EnemigoThread
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public class EnemigoThread extends Thread {

	//Atributos
	private Enemigo enemigo;
	private volatile boolean detener;
	private volatile boolean matar;
	private Juego juego;

	//Constructor
	/**
	 * Constructor de la clase. Recibe una instancia de Juego y un Enemigo al cual correspondera este hilo.
	 * @param juego Instancia de la clase Juego
	 * @param e Enemigo al cual correspondera este hilo.
	 */
	public EnemigoThread(Juego juego, Enemigo e) {
		this.juego = juego;
		this.enemigo = e;
		this.detener = false;
		this.matar = true;
	}

	/**
	 * Inicia el hilo. Hace que el enemigo se mueva.
	 */
	public void run() {
		while(!detener){
			matar = false;
			try {
				Thread.sleep(1);
				enemigo.mover();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			matar = true;
		}
	}

	/**
	 * Detiene el hilo.
	 */
	public void detener(){
		detener = true;
		if(matar) 
			this.interrupt();
	}

	/**
	 * Detiene el hilo.
	 */
	public void morir(){
		detener();
	}
}