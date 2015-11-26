package Threads;

import logica.*;
import gui.*;

/**
 * Clase TiempoThread
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class TiempoThread extends Thread {

	//Atributos
	private Nivel n;
	private GUI gui;
	boolean seguir;

	/**
	 * Constructor de la clase. Recibe un nivel y una gui.
	 * @param n Nivel a modificar tiempo.
	 * @param gui interfaz gráfica.
	 */
	public TiempoThread(Nivel n, GUI gui) {
		this.n = n;
		this.gui = gui;
		seguir = true;
	}

	/**
	 * Inicia el hilo. Hace que el tiempo se actualice.
	 */
	public void run() {
		while(seguir){
			try {
				for(int i = 0; i<1000; i++){
					Thread.sleep(1);
					gui.getPanelEstadisiticas().aumentarTiempo(n.getTiempo());					
				}
				n.incrementarTiempo();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Detiene el hilo
	 */
	public void detener(){
		seguir = false;
	}
}
