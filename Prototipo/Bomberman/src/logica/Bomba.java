package logica;

import grafica.BombaGrafico;
import grafica.EntidadGrafica;
/**
 * Clase Bomba
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
 * @version Octubre/2015
 */
public class Bomba {

	//Atributos
	protected Celda miCelda;
	protected int alcance;

	//Atributos graficos
	protected BombaGrafico graf;

	//Constructor
	/**
	 * Constructor de la clase. Recibe una celda y un entero que indica el alcance de la explosi�n.
	 * @param celda CElda en la que se encuentro la bomba.
	 * @param alcance Entero que indica el alcance de la explosi�n de la bomba.
	 */
	public Bomba(Celda celda, int alcance){
		miCelda=celda;
		this.alcance=alcance;
		graf=new BombaGrafico(miCelda.getFila(), miCelda.getColumna());
	}

	//Comandos y consultas
	/**
	 * Retorna el alcance de la explosi�n.
	 * @return Entero que indica el alcance de la explosi�n.
	 */
	public int getAlcance(){
		return alcance;
	}
	/**
	 * Desarrollo de la explosi�n de la bomba.
	 * @return Entero que indica el puntaje logrado con la explosi�n.
	 */
	public int explotar(){

		int f = miCelda.getFila();
		int c = miCelda.getColumna();

		int punt = miCelda.explotar();

		Celda aux;

		for(int a = 1; a < alcance; a++){

			aux = miCelda.getNivel().getCelda(f+a,c);
			if(aux!=null) 
				punt+=aux.explotar();

			aux = miCelda.getNivel().getCelda(f-a,c);
			if(aux!=null) 
				punt+=aux.explotar();

			aux = miCelda.getNivel().getCelda(f,c+a);
			if(aux!=null) 
				punt+=aux.explotar();

			aux = miCelda.getNivel().getCelda(f,c-a);
			if(aux!=null) 
				punt+=aux.explotar();

		}
		return punt;
	}

	/**
	 * Retorna la entidad gr�fica asociada a la bomba.
	 * @return BombaGr�fico asociado a la bomba.
	 */
	public BombaGrafico getGrafico(){
		return graf;
	}

}
