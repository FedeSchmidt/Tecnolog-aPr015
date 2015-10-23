package logica;

import java.awt.event.KeyEvent;
import java.util.Random;

import grafica.AltairGrafico;

/**
 * Clase Altair
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public class Altair extends Enemigo{

	//Constructor
	/**
	 * Constructor de la clase. Recibe el nivel y la celda en la que se encuentra el enemigo.
	 * @param n Nivel al que pertenece el enemigo.
	 * @param c Celda en el que se encuentra el enemigo.
	 */
	public Altair(Nivel n, Celda c){

		super (n, c, 2, true, 20);
		graf= new AltairGrafico(miCelda.getFila(), miCelda.getColumna(), velocidad);
	}

	//comandos y consultas
	/**
	 * Método  que maneja el movimiento del enemigo.
	 */
	public void mover(){
		Random r = new Random();		
		int dir = r.nextInt(4);		
		int direccion = -1;
		switch (dir) {
		case 0 : //Arriba
			miCelda.avanzar(this,KeyEvent.VK_UP);
			break;
		case 1 : //Abajo
			miCelda.avanzar(this,KeyEvent.VK_DOWN);
			break;
		case 2 : //Izquierda
			miCelda.avanzar(this,KeyEvent.VK_LEFT);
			break;
		case 3 : //Derecha
			miCelda.avanzar(this,KeyEvent.VK_RIGHT);
			break;
		}

	}


}
