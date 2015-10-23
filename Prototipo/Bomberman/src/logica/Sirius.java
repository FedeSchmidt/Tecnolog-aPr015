package logica;

import java.awt.event.KeyEvent;
import java.util.Random;

import grafica.SiriusGrafico;

/**
 * Clase Sirius
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public class Sirius extends Enemigo {

	//Constructor
	/**
	 * Constructor de la clase. Recibe el nivel y la celda en la que se encuentra el enemigo.
	 * @param n Nivel al que pertenece el enemigo.
	 * @param c Celda en el que se encuentra el enemigo.
	 */
	public Sirius(Nivel n, Celda c){

		super (n, c, 3, false, 50);
		graf= new SiriusGrafico(miCelda.getFila(), miCelda.getColumna(), velocidad);
	}

	//comandos y consultas
	/**
	 * Método  que maneja el movimiento del enemigo. Parcialmente implementado.
	 */
	public void mover(){
		int dir=-1;
		Bomberman bomber=this.getCelda().getNivel().getBomberman();
		Celda objetivo= bomber.getCelda();
		int xObjetivo= objetivo.getFila();
		int yObjetivo= objetivo.getColumna();

		int diferenciaX = this.getCelda().getFila() - xObjetivo;
		int diferenciaY= this.getCelda().getColumna() - yObjetivo;

		if (diferenciaX > diferenciaY){
			if (xObjetivo < this.getCelda().getFila())
				dir=0;
			else{
				if (xObjetivo > this.getCelda().getFila())
					dir=1;
			}
		}
		else{
			if (yObjetivo < this.getCelda().getColumna())
				dir=2;
			else{
				if (yObjetivo > this.getCelda().getColumna())
					dir=3;
			}	
		}
		if (dir==-1){
			Random r= new Random();
			dir=r.nextInt(4);
		}

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
