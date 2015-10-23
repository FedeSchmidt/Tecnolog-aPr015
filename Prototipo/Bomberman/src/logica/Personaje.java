package logica;

import javax.swing.JLabel;

import grafica.EntidadGrafica;

/**
 * Clase Personaje
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public abstract class Personaje {

	//Atributos
	protected int velocidad;
	protected boolean poder;
	protected Nivel miNivel;
	protected Celda miCelda;

	//Atributos graficos
	protected EntidadGrafica graf;

	//Constructor
	/**
	 * Constructor de la clase. Recibe el Nivel del juego, la Celda en la cual está el personaje, la velocidad del mismo y si tiene poder o no.
	 * Constructor Protegido. Clase abstracta.
	 * @param n Nivel del juego.
	 * @param c Celda en la que se crea el personaje.
	 * @param vel Velocidad del personaje.
	 * @param p Boolean que indica si el personaje tiene poder o no.
	 */
	protected Personaje( Nivel n, Celda c, int vel, boolean p){
		miNivel=n;
		miCelda=c;
		velocidad=vel;
		poder=p;

		graf=null;
	}

	//Comandos y consultas
	/**
	 * Retorna la velocidad del personaje.
	 * @return Entero que indica la velocidad del personaje.
	 */
	public int getVelocidad(){
		return velocidad;
	}

	/**
	 * Retorna si el personaje tiene poder o no.
	 * @return Boolean que indica si el personaje tiene poder o no.
	 */
	public boolean getPoder(){
		return poder;
	}

	/**
	 * Retorna la celda en la que se encuentra el personaje.
	 * @return Celda en la que se encuentra el personaje.
	 */
	public Celda getCelda(){
		return miCelda;
	}

	/**
	 * Retorna Nivel donde se encuentra el personaje.
	 * @return Nivel donde se encuentra el personaje.
	 */
	public Nivel getNivel(){
		return miNivel;
	}

	/**
	 * Setea la celda actual del personaje con la pasado por parámetro.
	 * @param c Nueva celda actual del personaje.
	 */
	public void setCelda(Celda c){
		miCelda=c;
	}

	/**
	 * Retorna la entidad gráfica asociada al personaje.
	 * @return Entidad gráfica asociada al personaje.
	 */
	public EntidadGrafica getGrafico(){
		return graf;
	}

	/**
	 * Método abstracto que maneja la muerte del personaje. Debe definirse en las clases herederas.
	 * @return Entero. Valor de cada personaje.
	 */
	public abstract int  morir();

}
