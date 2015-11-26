package Threads;


import gui.GUI;
import logica.*;

/**
 * Clase BombaThread
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class BombaThread extends Thread {

	//Atributos
	protected Bomba bomba;
	protected Celda celda;

	/**
	 * Constructor de la clase.
	 * @param bomba Bomba.
	 * @param celda Celda en la que se encuentra la bomba.
	 */
	public BombaThread(Bomba bomba, Celda celda) {
		this.bomba = bomba;
		this.celda = celda;
	}

	/**
	 * Inicia el hilo.
	 */
	public void run() {
		try {
			//agregamos la bomba a la GUI
			GUI gui = celda.getNivel().getJuego().getGui();
			gui.addMapa(bomba.getGrafico().getGrafico());

			//Esperamos 4 segundos para que explote, verificando que no haya terminado el juego
			Thread.sleep(4000);
			gui.removeMapa(bomba.getGrafico().getGrafico());
			if(!celda.getNivel().getJuego().getGui().getTermino()){ 
				int punt = bomba.explotar();

				//Recargarmos la bomba si ella no fue creada cuando el bomberman tenia poder
				if(!bomba.getEspecial())
					celda.getNivel().getBomberman().agregarBomba();

				//sumamos el putnaje al nivel
				celda.getNivel().incrementarPuntaje(punt);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}