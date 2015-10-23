package logica;

import grafica.SpeedGrafico;

/**
 * Clase SpeedUp
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
 * @version Octubre/2015
 */
public class SpeedUp extends PowerUp {

	//constructor
	/**
	 * Constructor de la clase. Recibe una celda de ubicaci�n.
	 * @param celda Celda donde se encuentra.
	 */
	public SpeedUp(Celda celda){
		super(celda, 30);
		graf=new SpeedGrafico(miCelda.getFila(),miCelda.getColumna());
	}

	//comandos y consultas
	/**
	 * Desarrolla el comportamiento concreto sobre el personaje recibido por par�metro.
	 * @param bomber Bomberman al cual afectar� el PowerUp
	 */
	public void comportamiento(Bomberman bomber){		
		bomber.duplicarVelocidad();
		bomber.getNivel().incrementarPuntaje(valor);
		bomber.getNivel().getJuego().getGui().remove(graf.getGrafico());
		graf=null;		
		miCelda.setPowerUp(null);
	}

}
