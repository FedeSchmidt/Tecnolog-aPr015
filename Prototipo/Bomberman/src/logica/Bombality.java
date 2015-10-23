package logica;

import grafica.BombalityGrafico;
import grafica.BombermanGrafico;

/**
 * Clase Bombality
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
 * @version Octubre/2015
 */
public class Bombality extends PowerUp {

	//constructor
	/**
	 * Constructor de la clase. Recibe una celda de ubicaci�n.
	 * @param celda Celda donde se encuentra.
	 */
	public Bombality(Celda celda){
		super(celda, 35);
		graf=new BombalityGrafico(miCelda.getFila(),miCelda.getColumna());
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