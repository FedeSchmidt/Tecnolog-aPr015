package logica;

import Threads.ExplosionThread;
import grafica.EstadoLibreGrafico;

/**
 * Clase Libre
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class Libre extends Estado {

	//Constructor
	/**
	 * Constructor de la clase. Recibe la celda a la cual pertenece.
	 * @param celda Celda a la cual pertenece.
	 */
	public Libre (Celda celda){
		super (celda);
		graf=new EstadoLibreGrafico(celda.getFila(), celda.getColumna());
	}

	//comandos y consultas
	/**
	 * Método  para recibir al personaje Bomberman.
	 * @param bomber Personaje Bomberman controlado por el usuario.
	 * @param dir Entero que indica hacia donde se mueve el bomberman.
	 * @param anterior Celda de la que proviene el personaje.
	 */
	public void avanzar (Bomberman bomber, int dir, Celda anterior){	

		anterior.setBomberman(null);
		miCelda.setBomberman(bomber);
		bomber.setCelda(miCelda);
		bomber.getGrafico().mover(dir);	

		PowerUp power= miCelda.getPowerUp();
		if (power!=null){
			power.comportamiento(bomber);
		}	
		if (!miCelda.getEnemigos().isEmpty()){
			if (!bomber.getPoder()){
				bomber.morir();
			}
		}


	}

	/**
	 * Método  para recibir a los enemigos.
	 * @param e Enemigo que desea ubicarse en nueva celda.
	 * @param dir Entero que indica hacia donde se mueve el enemigo.
	 * @param anterior Celda de la que proviene el enemigo.
	 */
	public boolean avanzar (Enemigo e, int dir, Celda anterior){
		anterior.eliminarEnemigo(e);
		miCelda.setEnemigo(e);
		e.setCelda(miCelda);	
		e.getGrafico().mover(dir);	

		if (e.getCelda().getBomberman()!=null){
			if(!e.getCelda().getBomberman().getPoder()){
				e.getCelda().getBomberman().morir();
			}
		}
		return true;
	}

	/**
	 * Método  para cambiar el estado en la celda que lo abarca.
	 * @return Puntaje entero producto  de la destrucción.
	 */
	public int destruir(){
		ExplosionThread hilo = new ExplosionThread(this);
		hilo.start();
		return 0;
	}

}
