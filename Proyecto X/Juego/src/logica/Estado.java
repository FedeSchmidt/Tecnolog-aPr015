package logica;

import grafica.EstadoGrafico;

/**
 * Clase Estado
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
 * @version Noviembre/2015
 */
public abstract class Estado {

	//Atributos
	protected Celda miCelda;

	//Atributo grafico
	protected EstadoGrafico graf;

	//Constructor
	/**
	 * Constructor de la clase. Recibe la celda a la cual pertenece.
	 * @param celda Celda a la cual pertenece.
	 */
	protected Estado (Celda celda){
		miCelda=celda;
	}

	//comandos y consultas
	/**
	 * Retorna la celda en la que se encuentra.
	 * @return La celda a la cual pertenece.
	 */
	public Celda getCelda(){
		return miCelda;
	}

	/**
	 * Retorna el estado gr�fico asociado.
	 * @return EstadoGrafico asociado.
	 */
	public EstadoGrafico getGrafico(){
		return graf;
	}

	/**
	 * M�todo abstracto para recibir al personaje Bomberman.Debe definirse en las clases herederas.
	 * @param bomber Personaje Bomberman controlado por el usuario.
	 * @param dir Entero que indica hacia donde se mueve el bomberman.
	 * @param anterior Celda de la que proviene el personaje.
	 */
	public abstract void avanzar (Bomberman bomber, int dir, Celda anterior);

	/**
	 * M�todo abstracto para recibir a los enemigos.Debe definirse en las clases herederas.
	 * @param e Enemigo que desea ubicarse en nueva celda.
	 * @param dir Entero que indica hacia donde se mueve el enemigo.
	 * @param anterior Celda de la que proviene el enemigo.
	 * @return boolean indicando si se avanza.
	 */
	public abstract boolean avanzar (Enemigo e, int dir, Celda anterior);

	/**
	 * M�todo abstracto para cambiar el estado en la celda que lo abarca. Abstracto. Debe definirse en las clase herederas.
	 * @return Puntaje entero producto  de la destrucci�n.
	 */
	public abstract int destruir();

}
