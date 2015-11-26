package logica;

import grafica.FatalityGrafico;

/**
 * Clase Fatality
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class Fatality extends PowerUp {

	//constructor
	/**
	 * Constructor de la clase. Recibe una celda de ubicación.
	 * @param celda Celda donde se encuentra.
	 */
	public Fatality(Celda celda){
		super(celda, 35);
		graf=new FatalityGrafico(miCelda.getFila(),miCelda.getColumna());
	}

	//comandos y consultas
	/**
	 * Desarrolla el comportamiento concreto sobre el personaje recibido por parámetro.
	 * @param bomber Bomberman al cual afectará el PowerUp
	 */
	public void comportamiento(Bomberman bomber){
		bomber.duplicarAlcance();
		bomber.getNivel().incrementarPuntaje(valor);
		bomber.getNivel().getJuego().getGui().removeMapa(graf.getGrafico());
		bomber.getNivel().getJuego().getGui().getPanelEstadisiticas().disminuirFatality();
		miCelda.setPowerUp(null);		
	}

}
