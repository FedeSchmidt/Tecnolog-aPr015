package Threads;

import logica.*;
import gui.*;

/**
 * Clase TiempoThread
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public class TiempoThread extends Thread {
	//atributos
	private Nivel n;
	private GUI gui;
	/**
	 * Constructor de la clase. Recibe un nivel y una gui.
	 * @param n Nivel a modificar tiempo.
	 * @param gui interfaz gráfica.
	 */
	public TiempoThread(Nivel n, GUI gui) {
		this.n = n;
		this.gui = gui;
	}
	
	/**
	 * Inicia el hilo. Hace que el tiemp ose actualice.
	 */
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			n.incrementarTiempo();
		}
	}
}
