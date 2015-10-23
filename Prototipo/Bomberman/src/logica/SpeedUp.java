package logica;

import grafica.SpeedGrafico;

/**
 * Clase SpeedUp
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public class SpeedUp extends PowerUp {

	//constructor
	/**
	 * Constructor de la clase. Recibe una celda de ubicación.
	 * @param celda Celda donde se encuentra.
	 */
	public SpeedUp(Celda celda){
		super(celda, 30);
		graf=new SpeedGrafico(miCelda.getFila(),miCelda.getColumna());
	}

	//comandos y consultas
	/**
	 * Desarrolla el comportamiento concreto sobre el personaje recibido por parámetro.
	 * @param bomber Bomberman al cual afectará el PowerUp
	 */
	public void comportamiento(Bomberman bomber){		
		bomber.duplicarVelocidad();
		bomber.getNivel().incrementarPuntaje(valor);
		bomber.getNivel().getJuego().getGui().remove(graf.getGrafico());
		graf=null;		
		miCelda.setPowerUp(null);
	}

}
