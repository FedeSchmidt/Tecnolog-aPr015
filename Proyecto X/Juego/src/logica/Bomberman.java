package logica;

import java.awt.event.KeyEvent;

import Threads.BombermanThread;
import grafica.*;

/**
 * Clase Bomberman.
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class Bomberman extends Personaje{

	//Atributos
	protected int cantBombas;
	protected int alcanceBomba;
	protected BombermanThread hilo;


	//Constructor
	/**
	 * Constructor de la clase. Recibe el nivel y la Celda en que se encuentra el Bomberman.
	 * @param n Nivel en que se encuentra el bomberman.
	 * @param c Celda en la cual se encuentra el bomberman.
	 */
	public Bomberman (Nivel n, Celda c){
		super (n, c, 3, false);
		cantBombas=1;
		alcanceBomba=1;
		graf=new BombermanGrafico(miCelda.getFila(),miCelda.getColumna(), velocidad);
		hilo = new BombermanThread(n.getJuego(),n.getJuego().getGui());
	}

	//Comandos y consultas
	/**
	 * Retorna la cantidad de bombas.
	 * @return Entero que indica la cantidad de bombas.
	 */
	public int getCantBombas(){
		return cantBombas;
	}

	/**
	 * Retorna el hilo del bomberman.
	 * @return Hilo que controla em bomberman.
	 */
	public BombermanThread getHilo(){
		return hilo;
	}

	/**
	 * Retorna el alcance de la explosión de una bomba puesta por bomberman.
	 * @return Entero que indica el alcance de la explosión de una bomba puesta por bomberman.
	 */
	public int getAlcanceBomba(){
		return alcanceBomba;
	}

	/**
	 * Duplica el alcance de las explosiones de la bomba.
	 */
	public void duplicarAlcance(){
		alcanceBomba*=2;
	}

	/**
	 * Aumenta la cantidad de bombas disponibles para el Bomberman.
	 */
	public void agregarBomba(){
		cantBombas++;
	}

	/**
	 * Setea la cantidad de bombas segun el entero pasado por parámetro.
	 * @param cant Entero que indica la nueva cantidad de bombas disponibles.
	 */
	public void setCantidadBombas(int cant){
		cantBombas = cant;
	}

	/**
	 * Método que posibilita al personaje poner una bomba.
	 */
	public void ponerBomba(){
		if(this.getPoder()){
			Bomba bomba= new Bomba(miCelda, alcanceBomba);
			bomba.serEspecial();
		}else{
			if(this.getCantBombas()>0){
				@SuppressWarnings("unused")
				Bomba bomba = new Bomba(miCelda, alcanceBomba);
				cantBombas--;
			}
		}
	}

	/**
	 * Método que desarrolla la muerte del personaje.
	 */
	public int morir(){
		miNivel.finalizarJuego();
		miCelda.setBomberman(null);
		this.setCelda(null);
		hilo.morir();
		return 0;
	}

	/**
	 * Setea el poder del bomberman.
	 * @param poder Boolean que indica si el personaje tiene ahora poder o no.
	 */
	public void setPoder(boolean poder){
		this.poder=poder;
	}

	/**
	 * Duplica la velocidad del Bomberman.
	 */
	public void duplicarVelocidad(){
		velocidad*=2;
		this.getGrafico().setVelocidad(velocidad);

	}

	/**
	 * Método que desarrolla el movimiento del Bomberman.
	 * @param dir Entero que indica la dirección en la cual se moverá, de ser posible, el personaje.
	 */
	public void mover(int dir){

		switch (dir){
		case KeyEvent.VK_UP : //Arriba
			miCelda.avanzar(this,KeyEvent.VK_UP);
			//System.out.println ("up bomber");
			break;
		case KeyEvent.VK_DOWN : //Abajo
			miCelda.avanzar(this,KeyEvent.VK_DOWN);
			break;
		case KeyEvent.VK_LEFT : //Izquierda
			miCelda.avanzar(this,KeyEvent.VK_LEFT);
			//System.out.println ("izqu bomber");
			break;
		case KeyEvent.VK_RIGHT : //Derecha
			miCelda.avanzar(this,KeyEvent.VK_RIGHT);
			break;
		}

	}

}
