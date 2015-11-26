package logica;

import grafica.BombalityGrafico;

/**
 * Clase Bombality
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class Bombality extends PowerUp {

	//constructor
	/**
	 * Constructor de la clase. Recibe una celda de ubicación.
	 * @param celda Celda donde se encuentra.
	 */
	public Bombality(Celda celda){
		super(celda, 35);
		graf=new BombalityGrafico(miCelda.getFila(),miCelda.getColumna());
	}

	//comandos y consultas
	/**
	 * Desarrolla el comportamiento concreto sobre el personaje recibido por parámetro.
	 * @param bomber Bomberman al cual afectará el PowerUp
	 */
	public void comportamiento(Bomberman bomber){	
		bomber.agregarBomba();
		bomber.getNivel().incrementarPuntaje(valor);
		bomber.getNivel().getJuego().getGui().removeMapa(graf.getGrafico());
		bomber.getNivel().getJuego().getGui().getPanelEstadisiticas().disminuirBombality();
		miCelda.setPowerUp(null);
	}

}