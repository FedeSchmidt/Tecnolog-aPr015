package logica;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import Juego.Juego;
import Threads.EnemigoThread;
import Threads.TiempoThread;

/**
 * Clase Nivel.
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public class Nivel {

	//Atributos de clase
	protected int puntaje;
	protected int tiempo;
	protected int cantDestruibles;
	protected Bomberman miBomberman;
	protected Celda [][] grilla;
	protected final int ancho=31;
	protected final int alto=13;
	protected ArrayList<Enemigo> misEnemigos;
	protected Juego juego;


	//Constructor
	/**
	 * Constructor de la clase. Recibe una instancia de Juego.
	 * @param juego Instancia de Juego.
	 */
	public Nivel(Juego juego){
		this.juego = juego;

		puntaje=0;
		tiempo=0;
		
		//iniciar tiempo
		TiempoThread t = new TiempoThread(this,juego.getGui());

		//crear grilla
		grilla= new Celda [alto][ancho];

		//Creo grilla de celdas
		int cont=inicializarGrilla();
		cantDestruibles= ((alto*ancho)-cont)/2;

		//Creamos algunas paredes destruibles de ejemplo
		grilla[7][7].setEstado(new Destruible(grilla[7][7]));
		grilla[9][26].setEstado(new Destruible(grilla[9][26]));
		grilla[7][17].setEstado(new Destruible(grilla[7][17]));
		grilla[3][15].setEstado(new Destruible(grilla[3][15]));

		//Seteo bomberman en la celda (1,1)
		miBomberman= new Bomberman(this, grilla [1][1]);
		grilla[1][1].setBomberman(miBomberman);

		misEnemigos= new ArrayList<Enemigo>();


	}

	private int inicializarGrilla(){
		int cont=0;
		for(int i = 0; i < alto; i++){
			for(int j = 0; j < ancho; j++){
				Celda cel= new Celda (i,j, this, null, null);
				grilla[i][j] = cel;


				if (i==0 || i==alto-1 || j==0 || j==ancho-1){
					Estado estado= new Indestructible(cel);
					cel.setEstado(estado); 
					cont++;
				}
				else{
					if (i%2==0 && j%2==0){
						Estado estado= new Indestructible(cel);
						cel.setEstado(estado);
						cont++;
					}
					else{
						Estado estado= new Libre(cel);
						cel.setEstado(estado);
					}

				}

			}
		}
		return cont;
	}

	//Comandos y consultas

	/**
	 * Retorna el alto de la grilla del nivel.
	 * @return Entero que indica la altura de la grilla del nivel.
	 */
	public int getAlto(){
		return alto;
	}

	/**
	 * Retorna el ancho de la grilla del nivel.
	 * @return Enteor que indica el ancho de la grilla del nivel.
	 */
	public int getAncho(){
		return ancho;
	}

	/**
	 * Retorna el tiempo transcurrido desde el inicio del juego.
	 * @return Entero qeu indica el tiempo transcurrido.
	 */
	public int getTiempo(){
		return tiempo;
	}

	/**
	 * Retorna el puntaje acumulado.
	 * @return Entero que indica el puntaje acumulado.
	 */
	public int getPuntaje(){
		return puntaje;
	}

	/**
	 * Retorna el juego asociado al nivel.
	 * @return Juego asociado al nivel.
	 */
	public Juego getJuego(){
		return juego;
	}

	/**
	 * Retorna la cantidad de celdas que aun quedan por destruir.
	 * @return Entero que indica la cantidad de celdas que aun quedan por destruir.
	 */
	public int getCantDestruibles(){
		return cantDestruibles;
	}

	/**
	 * Retorna el Bomberman del juego.
	 * @return Bomberman del juego.
	 */
	public Bomberman getBomberman(){
		return miBomberman;
	}

	/**
	 * Retorna la lista de enemigos del juego.
	 * @return Lista de enemigos del juego.
	 */
	public ArrayList<Enemigo> getEnemigos(){
		return misEnemigos;
	}

	/**
	 * Setea un enemigo en la lista de enemigos.
	 * @param e Nuevo Enemigo en el nivel.
	 */
	public void setEnemigo(Enemigo e){
		misEnemigos.add(e);
	}

	/**
	 * Elimina un enemigo del nivel.
	 * @param e Enemigo que se elimina del nivel.
	 */
	public void eliminarEnemigo (Enemigo e){
		misEnemigos.remove(e);
	}

	/**
	 * Retorna celda según las coordenadas recibidas por parámetro.
	 * @param fila Entero indicando la fila.
	 * @param columna Entero indicando la columna
	 * @return Celda, segun las coordenadas recibidas por parámetro.
	 */
	public Celda getCelda(int fila, int columna){
		if (fila>=0 && fila<alto && columna>=0 && columna<ancho)
			return grilla[fila][columna];
		else
			return null;
	}

	/**
	 * Incrementa el tiempo transcurrido.
	 */
	public void incrementarTiempo(){
		tiempo++;
	}

	/**
	 * Incrementa el puntaje sumándole el entero pasado por parámetro.
	 * @param cant Entero que incrementa el puntaje.
	 */
	public void incrementarPuntaje(int cant){
		puntaje=puntaje+cant;
	}

	/**
	 * Disminuye la cantidad de celdas destruibles que quedan aún en el nivel.
	 */
	public void disminuirCantDestruibles(){
		cantDestruibles--;
		if (cantDestruibles==0)
			this.finalizarJuego();
	}

	/**
	 * Método que desarrolla la finalizacion del juego.
	 */
	public void finalizarJuego(){
		//finaliza hilo bomberman
		this.getBomberman().getGrafico().setIcon(new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/bomber_muerto.png")));
		this.getJuego().getGui().getBombermanThread().morir(); 		

		//finaliza hilos enemigos 
		for (EnemigoThread enemigo: this.getJuego().getEnemigoThreads()) 
			enemigo.morir();

	}

	/**
	 * Método que desarrolla la finalización del juego, en caso de victoria.
	 */
	public void ganarJuego(){

		System.out.println( "Ganaste el juego!!");
	}

}
