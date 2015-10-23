package logica;

import grafica.BombermanGrafico;
import grafica.RuguloGrafico;

import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Clase Rugulo
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
 * @version Octubre/2015
 */
public class Rugulo extends Enemigo{

	//Constructor
	/**
	 * Constructor de la clase. Recibe el nivel y la celda en la que se encuentra el enemigo.
	 * @param n Nivel al que pertenece el enemigo.
	 * @param c Celda en el que se encuentra el enemigo.
	 */
	public Rugulo(Nivel n, Celda c){		
		super (n, c, 2, false, 15);
		graf=new RuguloGrafico(miCelda.getFila(), miCelda.getColumna(),velocidad);
		//graf=new RuguloGrafico(miCelda.getColumna(), miCelda.getFila(),velocidad);
	}

	//comandos y consultas
	/**
	 * M�todo  que maneja el movimiento del enemigo.
	 */
	public void mover(){
		Random r = new Random();		
		int dir = r.nextInt(4);		
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
