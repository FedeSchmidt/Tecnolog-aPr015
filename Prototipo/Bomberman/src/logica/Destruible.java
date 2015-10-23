package logica;

import grafica.EstadoDestructibleGrafico;
import grafica.EstadoLibreGrafico;

/**
 * Clase Destructible
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public class Destruible extends Estado {


	//Constructor
	/**
	 * Constructor de la clase. Recibe la celda a la cual pertenece.
	 * @param celda Celda a la cual pertenece.
	 */
	public Destruible(Celda celda){
		super (celda);
		graf=new EstadoDestructibleGrafico(celda.getFila(), celda.getColumna());
	}


	//comandos y consultas

	/**
	 * Método para recibir al personaje Bomberman.
	 * @param bomber Personaje Bomberman controlado por el usuario.
	 * @param dir Entero que indica hacia donde se mueve el bomberman.
	 * @param anterior Celda de la que proviene el personaje.
	 */
	public void avanzar (Bomberman bomber, int dir, Celda anterior){		
		if (bomber.getPoder()){
			anterior.setBomberman(null);
			miCelda.setBomberman(bomber);
			bomber.setCelda(miCelda);
			bomber.getGrafico().mover(dir);
		}
	}

	/**
	 * Método  para recibir a los enemigos.
	 * @param e Enemigo que desea ubicarse en nueva celda.
	 * @param dir Entero que indica hacia donde se mueve el enemigo.
	 * @param anterior Celda de la que proviene el enemigo.
	 */
	public void avanzar (Enemigo e, int dir, Celda anterior){
		if (e.getPoder()){
			anterior.setBomberman(null);
			miCelda.setEnemigo(e);
			e.setCelda(miCelda);
			e.getGrafico().mover(dir);
		}		
	}

	/**
	 * Método  para cambiar el estado en la celda que lo abarca.
	 * @return Puntaje entero producto  de la destrucción.
	 */
	public int destruir(){
		//Cambia el estado de la celda por uno libre
		miCelda.setEstado(new Libre(miCelda));
		miCelda.getNivel().disminuirCantDestruibles();
		return 10;
	}
}
