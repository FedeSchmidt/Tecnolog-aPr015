package logica;

import java.awt.event.KeyEvent;
import java.util.PriorityQueue;
import grafica.SiriusGrafico;
import estructuras.*;

/**
 * Clase Sirius
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class Sirius extends Enemigo {
	//atributos
	protected Celda anterior;

	//Constructor
	/**
	 * Constructor de la clase. Recibe el nivel y la celda en la que se encuentra el enemigo.
	 * @param n Nivel al que pertenece el enemigo.
	 * @param c Celda en el que se encuentra el enemigo.
	 */
	public Sirius(Nivel n, Celda c){
		super (n, c, 3, false, 50);
		anterior = c;
		graf = new SiriusGrafico(miCelda.getFila(), miCelda.getColumna(), velocidad);
	}

	//comandos y consultas
	/**
	 * Método  que maneja el movimiento del enemigo. 
	 */
	public void mover(){

		int dir=-1;

		PriorityQueue<Integer> cola=new PriorityQueue<Integer>();
		Diccionario<Integer, Celda> mapeo= new Diccionario<Integer, Celda>();

		Bomberman bomber=this.getCelda().getNivel().getBomberman();
		Celda objetivo= bomber.getCelda();

		int fila=miCelda.getFila();
		int columna=miCelda.getColumna();

		Celda celdaArriba= miNivel.getCelda(fila-1, columna);
		Celda celdaAbajo= miNivel.getCelda(fila+1, columna);
		Celda celdaIzquierda= miNivel.getCelda(fila, columna-1);
		Celda celdaDerecha= miNivel.getCelda(fila, columna+1);

		int distanciaArriba=distancia(objetivo, celdaArriba);
		int distanciaAbajo= distancia(objetivo, celdaAbajo);
		int distanciaIzquierda= distancia(objetivo, celdaIzquierda);
		int distanciaDerecha= distancia(objetivo, celdaDerecha);

		if (celdaArriba==anterior){
			distanciaArriba=100;
		}
		else{
			if (celdaAbajo==anterior){
				distanciaAbajo=100;
			}
			else{
				if(celdaIzquierda==anterior){
					distanciaIzquierda=100;
				}
				else{
					distanciaDerecha=100;
				}
			}
		}

		//Ordeno las celdas segun las distancias a la celda objetivo. (la celda anterior está en la última posicion)
		cola.add(distanciaArriba);
		cola.add(distanciaAbajo);
		cola.add(distanciaIzquierda);
		cola.add(distanciaDerecha);

		//mapeo distanica con celda
		mapeo.insert(distanciaArriba, celdaArriba);
		mapeo.insert(distanciaAbajo, celdaAbajo);
		mapeo.insert(distanciaIzquierda, celdaIzquierda);
		mapeo.insert(distanciaDerecha, celdaDerecha);

		boolean listo=false;
		anterior = miCelda;
		while (!listo && !cola.isEmpty()){

			int menor= cola.poll();
			Par<Integer, Celda> entrada=mapeo.find(menor);
			mapeo.remove(entrada);
			//Celda obj=mapeo.remove(entrada).getValue();
			Celda obj= entrada.getValue();

			if (obj==celdaArriba)
				dir=0;
			else{
				if(obj==celdaAbajo)
					dir=1;
				else{
					if (obj==celdaIzquierda)
						dir=2;
					else
						dir=3;
				}
			}

			listo= realizarMovimiento(dir);

		}


	}

	private int distancia (Celda a, Celda b){

		return  Math.abs(a.getColumna()- b.getColumna())+ Math.abs(a.getFila() - b.getFila()) ;
	}

	private boolean  realizarMovimiento (int dir){

		boolean salida=true;
		switch (dir) {
		case 0 : //Arriba
			salida= miCelda.avanzar(this,KeyEvent.VK_UP);
			break;
		case 1 : //Abajo
			salida= miCelda.avanzar(this,KeyEvent.VK_DOWN);
			break;
		case 2 : //Izquierda
			salida= miCelda.avanzar(this,KeyEvent.VK_LEFT);
			break;
		case 3 : //Derecha
			salida=miCelda.avanzar(this,KeyEvent.VK_RIGHT);
			break;

		}
		return salida;
	}


}
