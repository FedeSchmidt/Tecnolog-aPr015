package Threads;


import logica.*;

/**
 * Clase BombaThread
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
 * @version Noviembre/2015
 */
public class ExplosionThread extends Thread {

	//Atributos
	protected Estado estado;

	/**
	 * Constructor de la clase.
	 * @param estado Estado en que se produce la explosi�n.
	 */
	public ExplosionThread(Estado estado) {
		this.estado = estado;
	}

	/**
	 * Inicia el hilo.
	 */
	public void run() {
		try {
			//seteamos la imagen de explosion				
			estado.getCelda().getNivel().getJuego().getGui().addMapa(estado.getGrafico().getExplotar());
			for (int i = 0; i<2; i++){
				estado.getGrafico().cambiarExplosion(i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}