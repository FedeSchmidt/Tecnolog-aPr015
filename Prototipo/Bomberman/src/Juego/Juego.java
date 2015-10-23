package Juego;

import java.util.ArrayList;
import java.util.Random;

import logica.*;
import gui.*;
import Threads.*;

/**
 * Clase Juego
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public class Juego {

	//Atributosde clase
	private static final int cantRugulos = 3;
	private static final int cantAltair = 2;
	private static final int cantSirius = 1;

	//Atributos	
	private Bomberman jugador;	
	private ArrayList<Enemigo> enemigos;
	private ArrayList<EnemigoThread> hiloEnemigo;
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

		nivel = new Nivel(this);

		jugador = nivel.getBomberman();

		gui.add(jugador.getGrafico().getGrafico());
		enemigos= new ArrayList<Enemigo>();
		hiloEnemigo = new ArrayList<EnemigoThread>();

		//Crear enemigos
		crearEnemigos();

		//empezar hilos de enemigos
		for(int i = 0; i<enemigos.size(); i++){
			hiloEnemigo.get(i).start();
		}

		//crear PowerUp
		crearPowerUps();	

		//grafica celdas.
		for (int i=0;i<nivel.getAlto();i++){
			for(int j=0;j<nivel.getAncho(); j++){
				gui.add(nivel.getCelda(i,j).getEstado().getGrafico().getGrafico());
			}
		}	


	}

	private void crearPowerUps(){
		//crear 4 Speed Up
		PowerUp pu= new SpeedUp(nivel.getCelda(1, 7));
		nivel.getCelda(1, 7).setPowerUp(pu);
		gui.add(pu.getGrafico().getGrafico());	
		pu= new SpeedUp(nivel.getCelda(1, 3));
		nivel.getCelda(1, 3).setPowerUp(pu);
		gui.add(pu.getGrafico().getGrafico());	
		pu= new SpeedUp(nivel.getCelda(1, 11));
		nivel.getCelda(1, 11).setPowerUp(pu);
		gui.add(pu.getGrafico().getGrafico());	
		pu= new SpeedUp(nivel.getCelda(1, 15));
		nivel.getCelda(1, 15).setPowerUp(pu);
		gui.add(pu.getGrafico().getGrafico());	
		//Crear Masacrallity
		pu= new Masacrality(nivel.getCelda(3, 7));
		nivel.getCelda(3, 7).setPowerUp(pu);
		gui.add(pu.getGrafico().getGrafico());


	}

	private void crearEnemigos(){

		Enemigo e;
		Celda c;

		for(int i = 0; i < cantRugulos; i++){
			int[] pos = generarPosicion(nivel.getAlto(),nivel.getAncho());
			int x = pos[0];
			int y = pos[1];
			c = nivel.getCelda(x,	y);		
			e = new Rugulo(nivel, c);			
			enemigos.add(e);			
			c.setEnemigo(e);			
			gui.add(e.getGrafico().getGrafico());
			hiloEnemigo.add(new EnemigoThread(this, e));
		}

		//crear Altairs
		for(int i = 0; i < cantAltair; i++){
			int [] pos = generarPosicion(nivel.getAlto(),nivel.getAncho());
			int x = pos[0];
			int y = pos[1];
			c = nivel.getCelda(x,	y);		
			e = new Altair(nivel, c);			
			enemigos.add(e);			
			c.setEnemigo(e);			
			gui.add(e.getGrafico().getGrafico());
			hiloEnemigo.add(new EnemigoThread(this, e));
		}

		//crear Sirius
		for(int i = 0; i < cantSirius; i++){
			c = nivel.getCelda(nivel.getAlto()-2, nivel.getAncho()-2);		
			e = new Sirius(nivel, c);			
			enemigos.add(e);			
			c.setEnemigo(e);			
			gui.add(e.getGrafico().getGrafico());
			hiloEnemigo.add(new EnemigoThread(this, e));
		}
	}

	private  int[] generarPosicion(int maxAlto, int maxAncho){
		int [] pos = new int[2];
		Random r = new Random();
		int alto = r.nextInt(maxAlto);
		int ancho = r.nextInt(maxAncho);
		boolean seguir = true;
		while(seguir){
			if(alto<3  || alto==maxAlto-1){ // esta en un lugar indestructible del borde indestrcutible
				alto = r.nextInt(maxAlto);
			}else{
				if(ancho<5 || ancho==maxAncho-1){ // esta en un lugar del borde indestructible
					ancho = r.nextInt(maxAncho);
				}else{
					if(alto%2==0 && ancho%2==0){ // esta en un lugar indestructible
						ancho = r.nextInt(maxAncho);						
					}else{
						seguir=false;
						pos[0] = alto;
						pos[1] = ancho;
					}					
				}
			}
		}	

		return pos;
	}
	
	//Comandos y consultas
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
	 * Retorna la lista de hilos correspondientes a los enemigos.
	 * @return Lista de hilos correspondientes a los enemigos.
	 */
	public ArrayList<EnemigoThread> getEnemigoThreads(){
		return hiloEnemigo;
	}

}