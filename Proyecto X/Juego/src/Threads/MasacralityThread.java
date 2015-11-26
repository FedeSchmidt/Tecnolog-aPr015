package Threads;

import logica.*;
/**
 * Clase MasacralityThread
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
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
	 * Inicia el hilo. 
	 */
	public void run() {
		int bombasOriginal = bomberman.getCantBombas();
		bomberman.setPoder(true);
		bomberman.getNivel().getJuego().getGui().getPanelEstadisiticas().aumentarMasacrality();
		bomberman.getNivel().getJuego().getGui().getPanelEstadisiticas().modificarCantBombas(100);
		try {
			for(int tiempo = 0; tiempo<5000; tiempo+=1000){
				Thread.sleep(1000);
				bomberman.getNivel().getJuego().getGui().getPanelEstadisiticas().disminuirMasacrality();				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bomberman.setPoder(false);
		bomberman.getNivel().getJuego().getGui().getPanelEstadisiticas().modificarCantBombas(bombasOriginal);
	}
}
