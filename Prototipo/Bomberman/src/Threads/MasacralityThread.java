package Threads;

import logica.*;
/**
 * Clase MasacralityThread
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public class MasacralityThread extends Thread{

	//Atributos
	private Bomberman bomberman;

	//Constructor
	/**
	 * Constructor de la clase. Recibe una instancia del personaje Bomberman.
	 * @param bomberman Instancia del personaje Bomberman.
	 */
	public MasacralityThread(Bomberman bomberman) {
		this.bomberman = bomberman;
	}


	/**
	 * Inicia el hilo. Hace que el enemigo se mueva.
	 */
	public void run() {
		int bombasOriginal = bomberman.getCantBombas();
		bomberman.setPoder(true);
		bomberman.setCantidadBombas(100);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Termino poder Masacrality");
		bomberman.setPoder(false);
		bomberman.setCantidadBombas(bombasOriginal);
		this.interrupt();
	}
}
