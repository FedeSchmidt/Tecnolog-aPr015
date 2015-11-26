package logica;

import Threads.BombaThread;
import grafica.BombaGrafico;
/**
 * Clase Bomba
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class Bomba {

	//Atributos
	protected Celda miCelda;
	protected int alcance;
	protected BombaThread hiloBomba;
	protected boolean especial;

	//Atributos graficos
	protected BombaGrafico graf;

	//Constructor
	/**
	 * Constructor de la clase. Recibe una celda y un entero que indica el alcance de la explosión.
	 * @param celda CElda en la que se encuentro la bomba.
	 * @param alcance Entero que indica el alcance de la explosión de la bomba.
	 */
	public Bomba(Celda celda, int alcance){
		miCelda=celda;
		this.alcance=alcance;
		graf=new BombaGrafico(miCelda.getFila(), miCelda.getColumna());
		hiloBomba = new BombaThread(this,celda);
		especial = false;
		hiloBomba.start();
	}

	//Comandos y consultas
	/**
	 * Retorna el alcance de la explosión.
	 * @return Entero que indica el alcance de la explosión.
	 */
	public int getAlcance(){
		return alcance;
	}
	/**
	 * Desarrollo de la explosión de la bomba.
	 * @return Entero que indica el puntaje logrado con la explosión.
	 */
	public int explotar(){

		int f = miCelda.getFila();
		int c = miCelda.getColumna();

		int punt = miCelda.explotar();
		int suma=0;

		Celda aux;
		boolean b1 = true;boolean  b2 = true;boolean b3 = true; boolean b4 = true;

		for(int a = 1; a <= alcance; a++){

			aux = miCelda.getNivel().getCelda(f+a,c);
			if(aux!=null && b1) {
				suma=aux.explotar();
				if (suma>=0)
					punt+=suma;
				else
					b1= false;
			}

			aux = miCelda.getNivel().getCelda(f-a,c);
			if(aux!=null && b2){ 
				suma=aux.explotar();
				if (suma>=0)
					punt+=suma;
				else
					b2= false;
			}

			aux = miCelda.getNivel().getCelda(f,c+a);
			if(aux!=null && b3) {
				suma=aux.explotar();
				if (suma>=0)
					punt+=suma;
				else
					b3= false;
			}

			aux = miCelda.getNivel().getCelda(f,c-a);
			if(aux!=null && b4) {
				suma=aux.explotar();
				if (suma>=0)
					punt+=suma;
				else
					b4= false;
			}

		}
		return punt;
	}

	/**
	 * Retorna la entidad gráfica asociada a la bomba.
	 * @return BombaGráfico asociado a la bomba.
	 */
	public BombaGrafico getGrafico(){
		return graf;
	}

	/**
	 * Le indica a la bomba que fue creada de forma especial y no debe ser recargada una evz que explote
	 */
	public void serEspecial(){
		especial = true;
	}

	/**
	 * Retorna si la bomba es especial 
	 * @return verdadero si es especial, falso caso contrario.
	 */
	public boolean getEspecial(){
		return especial;
	}

}
