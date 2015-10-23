package logica;

import grafica.FatalityGrafico;

/**
 * Clase Fatality
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
 * @version Octubre/2015
 */
public class Fatality extends PowerUp {

	//constructor
	/**
	 * Constructor de la clase. Recibe una celda de ubicaci�n.
	 * @param celda Celda donde se encuentra.
	 */
	public Fatality(Celda celda){
		super(celda, 35);
		graf=new FatalityGrafico(miCelda.getFila(),miCelda.getColumna());
	}

	//comandos y consultas
	/**
	 * Desarrolla el comportamiento concreto sobre el personaje recibido por par�metro.
	 * @param bomber Bomberman al cual afectar� el PowerUp
	 */
	public void comportamiento(Bomberman bomber){

		//todavia no implementado.
	}

}
