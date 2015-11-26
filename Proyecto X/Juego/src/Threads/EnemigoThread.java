package Threads;

import logica.*;

/**
 * Clase EnemigoThread
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class EnemigoThread extends Thread {

	//Atributos
	private Enemigo enemigo;
	private volatile boolean detener;
	private volatile boolean matar;

	//Constructor
	/**
	 * Constructor de la clase. Recibe una instancia de Juego y un Enemigo al cual correspondera este hilo.
	 * @param e Enemigo al cual correspondera este hilo.
	 */
	public EnemigoThread(Enemigo e) {	
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