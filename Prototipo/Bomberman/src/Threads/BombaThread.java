package Threads;


import gui.GUI;
import Juego.Juego;
import logica.*;

/**
 * Clase BombaThread
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public class BombaThread extends Thread {
	/*private Enemigo enemigo;
	private volatile boolean detener;
	private Juego juego;

	public BombaThread(Juego juego, Enemigo e) {
		this.juego = juego;
		this.enemigo = e;
		this.detener = false;
	}

	public void run() {
		while(!detener){
			try {
				Thread.sleep(1);
				enemigo.mover();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void detener(){
		this.interrupt();
		detener = true;
	}

	public void morir(){
		detener();
	}*/
}