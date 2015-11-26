package logica;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Clase Celda.
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class Celda {

	//Atributos
	public static final int LEFT = KeyEvent.VK_LEFT;
	public static final int RIGHT = KeyEvent.VK_RIGHT;
	public static final int UP = KeyEvent.VK_UP;
	public static final int DOWN = KeyEvent.VK_DOWN;
	protected int fila;
	protected int columna;
	protected Nivel miNivel;
	protected PowerUp miPU;
	protected Estado miEstado;
	protected Bomberman miBomberman;
	protected ArrayList<Enemigo> misEnemigos;


	//Constructor
	/**
	 * Constructor de la clase. Recibe dos enteros coordenada, un PowerUp, un Estado y el Nivel al que pertenece.
	 * @param fila Coordenada 1
	 * @param columna Coordenada 2
	 * @param nivel Nivel al que pertenece la celda.
	 * @param pu PowerUp que guarda la celda.
	 * @param estado Estado de la celda.
	 */
	public Celda (int fila, int columna, Nivel nivel, PowerUp pu, Estado estado){
		this.fila=fila;
		this.columna=columna;
		miNivel=nivel;
		miPU=pu;
		miEstado=estado;
		misEnemigos= new ArrayList<Enemigo>();
		miBomberman=null;

	}

	//Comandos y consultas
	/**
	 * Retorna la fila en la que se encuentra la celda.
	 * @return Entero que es la fila de la celda.
	 */
	public int getFila(){
		return fila;
	}

	/**
	 * Retorna la columna en la que se encuentra la celda.
	 * @return Entero que es la columna de la celda.
	 */
	public int getColumna(){
		return columna;
	}

	/**
	 * Retorna el powerUp que guarda la celda.
	 * @return PowerUP que guarda la celda.
	 */
	public PowerUp getPowerUp(){
		return miPU;
	}

	/**
	 * Retorna el Nivel en el que se encuentra la celda.
	 * @return Nivel en el que se encuentra la celda.
	 */
	public Nivel getNivel(){
		return miNivel;
	}

	/**
	 * Retorna el bomberman que tiene la celda. (si no lo tiene, retorna Null)
	 * @return Bomberman que guarda la celda.
	 */
	public Bomberman getBomberman(){
		return miBomberman;
	}

	/**
	 * Setea el Bomberman de la celda, con el pasado por parámetro.
	 * @param bomber Bomberman que ahora se encuentra en esta celda.
	 */
	public void setBomberman(Bomberman bomber){
		miBomberman=bomber;
	}

	/**
	 * Setea enemigo en esta celda.
	 * @param e Enemigo que ahora se encuetra en esta celda.
	 */
	public void setEnemigo(Enemigo e){
		misEnemigos.add(e);
	}

	/**
	 * Elimina enemigo que se encuentra en esta celda.
	 * @param e Enemigo que se quiere eliminar.
	 */
	public void eliminarEnemigo (Enemigo e){
		misEnemigos.remove(e);
	}

	/**
	 * Retorna la lista de enemigos que guarda la celda.
	 * @return Lista de enemigos que guarda la celda.
	 */
	public ArrayList<Enemigo> getEnemigos(){
		return misEnemigos;
	}

	/**
	 * Retorna el estado de la celda.
	 * @return Estado de la celda.
	 */
	public Estado getEstado(){
		return miEstado;
	}

	/**
	 * Setea el Estado de la celda.
	 * @param estado Estado de la celda actual.
	 */
	public void setEstado(Estado estado){
		miEstado=estado;
	}

	/**
	 * Setea el powerUp que guarda la celda con el pasado por parámetro.
	 * @param p Nuevo powerUP que guarda la celda.
	 */
	public void setPowerUp(PowerUp p){
		miPU=p;
	}

	/**
	 * Método que desarrolla la explosión de la celda.
	 * @return Entero que indica el puntaje que implica la explosión de la celda.
	 */
	public int explotar(){

		int cont=0;
		LinkedList<Enemigo> lista=new LinkedList<Enemigo>();
		if (miBomberman!=null && !miBomberman.getPoder()){

			return miBomberman.morir();
		}

		for (Enemigo e: misEnemigos){
			lista.add(e);
		}

		for(Enemigo e: lista){
			cont+= e.morir();
		}

		cont+= miEstado.destruir();

		return cont;
	}

	/**
	 * Método que desarrolla el avance de Bomberman hacia la siguiente celda.
	 * @param bomber Bomberman que hace su movimiento.
	 * @param dir Entero qeu indica la dirección del movimiento del Bomberman.
	 */
	public void avanzar (Bomberman bomber, int dir){
		Celda siguiente=null;

		siguiente=recuperarCelda(dir);
		if (siguiente!=null)
			siguiente.getEstado().avanzar(bomber, dir, this);

	}

	/**
	 * Método que desarrolla el avance de un enemigo hacia la sigueinte celda.
	 * @param e Enemigo que realiza el movimiento.
	 * @param dir Entero que indica la dirección en que se mueve el enemigo.
	 * @return boolean indicando si se avanza.
	 */
	public boolean avanzar (Enemigo e, int dir){		
		boolean res=false;
		Celda siguiente=null;

		siguiente=recuperarCelda(dir);
		if (siguiente!=null)
			res= siguiente.getEstado().avanzar(e, dir,this);
		return res;

	}

	private Celda recuperarCelda(int dir){
		Celda siguiente=null;
		switch (dir){
		case KeyEvent.VK_UP: //arriba
			siguiente=miNivel.getCelda(this.fila-1, this.columna);
			break;
		case KeyEvent.VK_DOWN: //abajo
			siguiente=miNivel.getCelda(this.fila+1, this.columna);
			break;
		case KeyEvent.VK_LEFT: //izquierda
			siguiente=miNivel.getCelda(this.fila, this.columna-1);
			break;
		case KeyEvent.VK_RIGHT: //derecha
			siguiente=miNivel.getCelda(this.fila, this.columna+1);
			break;
		}
		return siguiente;
	}

}
