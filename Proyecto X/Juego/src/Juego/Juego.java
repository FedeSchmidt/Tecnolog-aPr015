package Juego;

import java.util.ArrayList;

import logica.*;
import gui.*;

/**
 * Clase Juego
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class Juego {

	//Atributos	
	private Bomberman jugador;	
	private ArrayList<Enemigo> enemigos;
	private Nivel nivel;
	private GUI gui;

	//Constructor
	/**
	 * Constructor de la clase. Recibe la GUI por parámetro.
	 * Crea el nivel y setea la gráfica de la GUI pasada por parámetro.
	 * @param gui Interfaz gráfica.
	 */
	public Juego(GUI gui){
		this.gui = gui;	
		this.nivel = new Nivel(this);
		this.enemigos = new ArrayList<Enemigo>();
		for(Enemigo e: nivel.getEnemigos())
			enemigos.add(e);
		jugador = nivel.getBomberman();

	}


	//Comandos y consultas	
	/**
	 * Inicia los hilos de los enemigos
	 */
	public void iniciarHilos(){
		//inicia hilos de los enemigos
		for(Enemigo e: enemigos)
			e.getHilo().start();
		//inicia el hilo del bomberman
		jugador.getHilo().start();
	}

	/**
	 * Recupera la lista de enemigos
	 * @return Lista de enemigos.
	 */
	public ArrayList<Enemigo> getEnemigos(){
		return enemigos;
	}

	/**
	 * Operación que indica a los enemigos que realicen movimientos.
	 */
	public void mover(){
		for(int i = 0; i < enemigos.size(); i++){
			enemigos.get(i).mover();
		}
	}

	/**
	 * Operación que indica al personaje controlado por el usuario que realice movimiento, segun una dirección.
	 * @param dir Entero que indica la direccion en que debe moverse el personaje según lo indicado por el usuario.
	 */
	public void mover(int dir){
		jugador.mover(dir);
	}

	/**
	 * Retorna la GUI
	 * @return Interfaz Gráfica.
	 */
	public GUI getGui(){
		return gui;
	}

	/**
	 * Retorna el Nivel
	 * @return Nivel del juego.
	 */
	public Nivel getNivel(){
		return nivel;
	}
	/**
	 * Le inidica al bomberman que debe poner una bomba
	 */
	public void ponerBomba(){
		nivel.getBomberman().ponerBomba();
	}

}