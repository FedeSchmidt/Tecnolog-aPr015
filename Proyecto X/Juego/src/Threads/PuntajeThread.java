package Threads;

import logica.*;
import gui.*;

/**
 * Clase PuntajeThread
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class PuntajeThread extends Thread {

	//Atributos
	private Nivel n;
	private GUI gui;
	private boolean seguir;

	/**
	 * Constructor de la clase. Recibe un nivel y una gui.
	 * @param n Nivel a modificar tiempo.
	 * @param gui interfaz gráfica.
	 */
	public PuntajeThread(Nivel n, GUI gui) {
		this.n = n;
		this.gui = gui;
		seguir = true;
	}

	/**
	 * Inicia el hilo. Hace que el puntaje se actualice.
	 */
	public void run() {
		while(seguir){
			try {
				//esperamos apra ver si hay cambios en el puntaje
				Thread.sleep(100);

				//Si el Bomberman no tiene poder actualizamos la cantidad de bombas 
				if(!n.getBomberman().getPoder())
					gui.getPanelEstadisiticas().modificarCantBombas(n.getBomberman().getCantBombas());

				//actualizar puntaje
				gui.getPanelEstadisiticas().aumentarPuntaje(n.getPuntaje());

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
