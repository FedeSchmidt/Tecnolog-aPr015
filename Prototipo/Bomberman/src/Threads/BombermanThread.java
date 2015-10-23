package Threads;

import gui.GUI;
import Juego.Juego;

/**
 * Clase BombermanThread
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public class BombermanThread extends Thread {

	//Atributos
	private volatile boolean detener;
	private volatile boolean matar;
	private Juego juego;
	private GUI gui;

	//Constructor
	/**
	 * Constructor de la clase. Recibe una instancia de Juego y la GUI del programa.
	 * @param juego Instancia de la clase Juego
	 * @param gui Interfaz gráfica.
	 */
	public BombermanThread(Juego juego, GUI gui) {
		this.juego = juego;
		this.gui = gui;
		detener = false;
		this.matar = true;
	}

	/**
	 * Inicia el hilo. Hace que el bomberman se mueva.
	 */
	public void run() {
		while(!detener){
			matar = false;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			if(gui.getLock() && !detener){				
				juego.mover(gui.getDirection());
				gui.toggleLock();				
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