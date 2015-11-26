package logica;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import Juego.Juego;
import Threads.PuntajeThread;
import Threads.TiempoThread;

/**
 * Clase Nivel.
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class Nivel {
	//atributos de clase
	protected static final int cantRugulos = 3;
	protected static final int cantAltair = 2;
	protected static final int cantSirius = 1;
	protected static final int cantSpeedUp = 4;
	protected static final int cantBombality = 3;
	protected static final int cantFatality = 3;
	protected static final int cantMasacrality = 1;
	protected static final int ancho = 31;
	protected static final int alto = 13;
	protected int cantDestruibles = 80;

	//Atributos de clase
	protected int puntaje;
	protected int tiempo;
	protected Bomberman miBomberman;
	protected Celda [][] grilla;
	protected ArrayList<Enemigo> misEnemigos;
	protected Juego juego;
	protected TiempoThread tiempoHilo;
	protected PuntajeThread puntajeHilo;


	//Constructor
	/**
	 * Constructor de la clase. Recibe una instancia de Juego.
	 * @param juego Instancia de Juego.
	 */
	public Nivel(Juego juego){
		puntaje = 0;
		tiempo = 0;
		this.juego = juego;
		misEnemigos = new ArrayList<Enemigo>();

		//Crear Grilla y celdas sin estados
		grilla = new Celda[alto][ancho];
		crearGrilla();

		//crear PowerUp
		crearPowerUp();

		//Crear Enemigos
		crearEnemigos();

		//Crear Estados Indestruibles
		crearIndestruibles();

		//crear Esatdos Libres
		crearLibres();

		//crear Estado Destruibles
		cantDestruibles = crearDestruibles();

		//crear Bomberman
		miBomberman = new Bomberman(this,grilla[1][1]);
		grilla[1][1].setBomberman(miBomberman);
		getJuego().getGui().addMapa(miBomberman.getGrafico().getGrafico());

		//cargar Graficos a la gui
		generarGraficos();

		//creamos hilos del tiempo y el puntaje
		tiempoHilo = new TiempoThread(this,juego.getGui());
		puntajeHilo = new PuntajeThread(this,juego.getGui());
	}


	//metodos auxilaires
	/**
	 * Inicia los hilos del programa.
	 */
	public void iniciarHilos(){
		//inicia hilos de los enemigos
		for(Enemigo e: misEnemigos)
			e.getHilo().start();
		//inicia el hilo del bomberman
		miBomberman.getHilo().start();

		//inicia el tiempo y a controlar putnaje
		tiempoHilo.start();
		puntajeHilo.start();
	}

	/**
	 * Genera los gráficos.
	 */
	public void generarGraficos(){
		for(int i = 0; i<alto; i++){
			for(int j = 0; j<ancho; j++){
				Celda c = grilla[i][j];				
				if(!c.getEnemigos().isEmpty())
					for(Enemigo e: c.getEnemigos())
						getJuego().getGui().addMapa(e.getGrafico().getGrafico());							
			}
		}
		for(int i = 0; i<alto; i++){
			for(int j = 0; j<ancho; j++){
				Celda c = grilla[i][j];	
				getJuego().getGui().addMapa(c.getEstado().getGrafico().getGrafico());
				if(c.getPowerUp()!=null)
					getJuego().getGui().addMapa(c.getPowerUp().getGrafico().getGrafico());

			}
		}
	}

	protected int crearDestruibles(){
		int cont = 0;
		Random r = new Random();
		for(int j = 1; j<ancho-1; j++){
			for(int i = 1; i<alto-1; i++){
				int azar = r.nextInt(3);
				Celda c = grilla[i][j];
				if (!(i%2==0 && j%2==0)){
					if(!((i==1 && j==1) || (i==1 && j==2) || (i==2 && j==1))){
						if(c.getPowerUp()!=null){
							c.setEstado(new Destruible(c));
							cont++;
						}else{
							if(azar==0){
								if(cont<cantDestruibles){
									if(c.getEnemigos().isEmpty()){
										c.setEstado(new Destruible(c));
										cont++;										
									}
								}
							}
						}
					}
				}
			}
		}
		return cont;
	}


	protected void crearLibres(){
		for(int i = 0; i<alto; i++){
			for(int j = 0; j<ancho; j++){
				if(grilla[i][j].getEstado()==null){
					grilla[i][j].setEstado(new Libre(grilla[i][j]));
				}
			}
		}
	}

	protected void crearIndestruibles(){
		for(int i = 0; i<alto; i++){
			for(int j = 0; j<ancho; j++){
				if ((i==0 || i==alto-1 || j==0 || j==ancho-1) || (i%2==0 && j%2==0)){
					grilla[i][j].setEstado(new Indestructible(grilla[i][j])); 
				}
			}
		}
	}

	protected void crearEnemigos(){
		for(int i = 0; i< cantRugulos; i++){
			int [] pos = generarPosicion(alto, ancho);
			Celda c = grilla[pos[0]][pos[1]];
			if(c.getPowerUp()!=null)
				i--;
			else{
				Enemigo e = new Rugulo(this,c);
				c.setEnemigo(e);
				misEnemigos.add(e);
			}
		}
		for(int i = 0; i< cantAltair; i++){
			int [] pos = generarPosicion(alto, ancho);
			Celda c = grilla[pos[0]][pos[1]];
			if(c.getPowerUp()!=null)
				i--;
			else{
				Enemigo e = new Altair(this,c);
				c.setEnemigo(e);
				misEnemigos.add(e);
			}
		}
		for(int i = 0; i< cantSirius; i++){
			Celda c = grilla[alto-2][ancho-2];
			Enemigo e = new Sirius(this,c);
			c.setEnemigo(e);
			misEnemigos.add(e);
		}
	}


	protected void crearPowerUp(){
		for(int i = 0; i< cantSpeedUp; i++){
			int [] pos = generarPosicion(alto, ancho);
			Celda c = grilla[pos[0]][pos[1]];
			if(c.getPowerUp()!=null)
				i--;
			else{
				PowerUp pu = new SpeedUp(c);
				c.setPowerUp(pu);
			}
		}
		for(int i = 0; i< cantBombality; i++){
			int [] pos = generarPosicion(alto, ancho);
			Celda c = grilla[pos[0]][pos[1]];
			if(c.getPowerUp()!=null)
				i--;
			else{
				PowerUp pu = new Bombality(c);
				c.setPowerUp(pu);
			}
		}
		for(int i = 0; i< cantFatality; i++){
			int [] pos = generarPosicion(alto, ancho);
			Celda c = grilla[pos[0]][pos[1]];
			if(c.getPowerUp()!=null)
				i--;
			else{
				PowerUp pu = new Fatality(c);
				c.setPowerUp(pu);
			}
		}
		for(int i = 0; i< cantMasacrality; i++){
			int [] pos = generarPosicion(alto, ancho);
			Celda c = grilla[pos[0]][pos[1]];
			if(c.getPowerUp()!=null)
				i--;
			else{
				PowerUp pu = new Masacrality(c);
				c.setPowerUp(pu);
			}
		}
	}

	protected void crearGrilla(){
		for(int i = 0; i<alto; i++){
			for(int j = 0; j<ancho;j++){
				grilla[i][j] = new Celda(i,j,this,null,null);
			}
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
			this.ganarJuego();
	}

	/**
	 * Método que desarrolla la finalizacion del juego.
	 */
	public void finalizarJuego(){	

		//setea una imagen de muerte al bomberman
		this.getBomberman().getGrafico().setIcon(new ImageIcon(this.getClass().getResource("/ImagenesPersonajes/bomber_muerto.png")));

		//Detener hilo bomberman
		miBomberman.getHilo().morir();			

		limpiarJuego();

		//le solicita a la gui mstrar mensaje de perdedor
		this.getJuego().getGui().finalizarJuego();
	}

	/**
	 * Método que desarrolla la finalización del juego, en caso de victoria.
	 */
	public void ganarJuego(){
		limpiarJuego();

		//mensaje ganador
		this.getJuego().getGui().ganarJuego();
	}

	protected void limpiarJuego(){
		//finalizar hilos de putnaje y tiempo
		tiempoHilo.detener();
		puntajeHilo.detener();		

		//sacar a los enemigos del mapa
		ArrayList<Enemigo> lista = new ArrayList<Enemigo>();
		for(Enemigo e: misEnemigos){
			lista.add(e);
		}		
		for(Enemigo e: lista){
			e.morir();
		}	

		//remover graficos
		juego.getGui().getMapa().removeAll();
		juego.getGui().getMapa().repaint();
		juego.getGui().silenciarJuego(false);
		juego.getGui().remove(juego.getGui().getMapa());
		juego.getGui().repaint();
	}

	/**
	 * Inserta una Celda en la posicion i,j
	 * @param i coordenada 1.
	 * @param j coordenada 2.
	 * @param e Estado de la celda.
	 */
	public void setCelda(int i, int j, Estado e){
		grilla[i][j] = new Celda(j, j, this, null, e);
	}

}
