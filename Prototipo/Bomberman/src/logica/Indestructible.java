package logica;

import grafica.EstadoIndestructibleGrafico;
import grafica.EstadoLibreGrafico;

/**
 * Clase Indestructible.
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public class Indestructible extends Estado {


	//Constructor
	/**
	 * Constructor de la clase. Recibe la celda a la cual pertenece.
	 * @param celda Celda a la cual pertenece.
	 */
	public Indestructible(Celda celda){
		super (celda);
		graf=new EstadoIndestructibleGrafico(celda.getFila(), celda.getColumna());
	}


	//comandos y consultas
	/**
	 * Método para recibir al personaje Bomberman.
	 * @param bomber Personaje Bomberman controlado por el usuario.
	 * @param dir Entero que indica hacia donde se mueve el bomberman.
	 * @param anterior Celda de la que proviene el personaje.
	 */
	public void avanzar (Bomberman bomber, int dir, Celda anterior){
		//No hace modificaciones.
	}

	/**
	 * Método  para recibir a los enemigos.
	 * @param e Enemigo que desea ubicarse en nueva celda.
	 * @param dir Entero que indica hacia donde se mueve el enemigo.
	 * @param anterior Celda de la que proviene el enemigo.
	 */
	public void avanzar (Enemigo e, int dir, Celda anterior){
		//No hace modificaciones.
	}

	/**
	 * Método  para cambiar el estado en la celda que lo abarca.
	 * @return Puntaje entero producto  de la destrucción.
	 */
	public int destruir(){
		//No hace modificaciones.
		return 0;
	}
}

