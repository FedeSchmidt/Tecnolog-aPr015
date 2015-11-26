package logica;

import grafica.PowerUpGrafico;

/**
 * Clase PowerUp
 * @author G�mez Germ�n, Schmidt Federico. Comisi�n n� 7. Tecnolog�a de Programaci�n 2015.
 * @version Noviembre/2015
 */
public abstract  class PowerUp {

	//Atributos
	protected int valor;
	protected Celda miCelda;

	//Atributo grafico
	protected PowerUpGrafico graf;

	//constructor
	/**
	 * Constructor de la clase, protegido, la clase es abstracta. Recibe una celda y un valor entero.
	 * @param celda Celda donde se encuentra.
	 * @param valor Entero que indica el puntaje que suma al agarrarlo.
	 */
	protected PowerUp (Celda celda, int valor){
		miCelda=celda;
		this.valor=valor;
		graf=null;
	}

	//comandos y consultas
	/**
	 * Retorna el valor de PowerUp
	 * @return Entero que indica su valor.
	 */
	public int getValor(){
		return valor;
	}

	/**
	 * Retorna la celda en donde se encuentra
	 * @return Celda donde se encuentra.
	 */
	public Celda getCelda(){
		return miCelda;
	}

	/**
	 * Retorna  la estructura gr�fica.
	 * @return PowerUpGrafico, que es la estructura gr�fica.
	 */
	public PowerUpGrafico getGrafico(){
		return graf;
	}

	/**
	 * Setea el grafico en nulo.
	 */
	public void setGrafico(){
		graf = null;
	}

	/**
	 * Operaci�n abstracta, debe ser definida en las clases herederas.
	 * @param bomber Bomberman, personaje principal al cual afectar� el powerUp-
	 */
	public abstract void comportamiento(Bomberman bomber);

}
