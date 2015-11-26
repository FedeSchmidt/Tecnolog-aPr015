package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Juego.Juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.BoxLayout;



/**
 * Clase GUI
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre /2015
 */

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int BOMBA = KeyEvent.VK_SPACE;
	private static final int silenciar = KeyEvent.VK_S;
	private boolean pantallaInicio = true;
	private boolean pantallaInstrucciones = false;
	private boolean termino = false;
	protected boolean lock = false;
	protected boolean sonidoActivo = true;
	protected int direction = -1;

	protected Juego j;
	protected JPanel pH;
	protected PanelEstadisticas pE;
	protected JPanel mapa;
	protected JLabel inicio;
	protected Clip sonido;

	/**
	 * Crea la interfaz, definiendo sus elementos y caractéristicas.
	 */
	public GUI() {		
		super ("Proyecto X");
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(!termino){
					if(pantallaInicio){
						mostrarInstrucciones();
						pantallaInicio = false;
						pantallaInstrucciones = true;
					}else{
						if(pantallaInstrucciones){
							iniciarJuego();
							pantallaInstrucciones = false;
						}else{
							switch (arg0.getKeyCode()){
							case BOMBA: //con espacio pone una bomba el bomberman
								j.ponerBomba();
								break;
							case silenciar: //izquierda
								silenciarJuego(!sonidoActivo);
								break;
							default : //derecha
								mover(arg0);
								break;
							}							
						}
					}
				}
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 998, 599);		
		setResizable(false);
		pE = new PanelEstadisticas();
		pH = new PanelHeader();
		mapa = new JPanel();
		mapa.setBackground(Color.getHSBColor(0f, 500f, 1000f));

		//Panel de inicio antes de empezar a jugar
		inicio = new JLabel();
		inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesPersonajes/fondo-inicio.gif")));
		inicio.setSize(998,115);
		getContentPane().add(inicio);

		//iniciarJuego();

		j = new Juego(this);
	}

	/**
	 * Muestra instrucciones del juego
	 */
	public void mostrarInstrucciones(){		
		inicio.setIcon(null);
		inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesPersonajes/ins.jpg")));
	}

	/**
	 * Silencia el Juego
	 * @param s Boolean que indica si reproducir o no el sonido.
	 */
	public void silenciarJuego(boolean s){
		sonidoActivo = s;
		if(sonidoActivo)
			sonido.start();
		else
			sonido.stop();

	}

	/**
	 * Da inicio al juego
	 */
	public void iniciarJuego(){
		//Agreamos los paneles al juego
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(mapa, BorderLayout.CENTER);
		getContentPane().add(pH, BorderLayout.NORTH);
		getContentPane().add(pE, BorderLayout.SOUTH);
		pE.setLayout(new BoxLayout(pE, BoxLayout.X_AXIS));
		mapa.setLayout(null);	

		//Sacamos pantalla de inicio
		inicio.setIcon(null);

		//Audio
		try{
			BufferedInputStream bis= new BufferedInputStream(getClass().getResourceAsStream("/Musica/musica.wav"));
			AudioInputStream ais= AudioSystem.getAudioInputStream(bis);
			sonido= AudioSystem.getClip();
			sonido.open(ais);
			sonido.start();
			sonido.loop(100);
		}
		catch (LineUnavailableException | IOException | UnsupportedAudioFileException e){
			e.printStackTrace();
		}

		//Iniciamos los hilos de los personajes
		j.getNivel().iniciarHilos();

	}


	/**
	 * Recupera el movimiento,  realizado por teclado, del personaje.
	 * @param key indicará el movimiento realizado por teclado.
	 */
	public  void mover(KeyEvent key){
		if(!lock){
			direction = key.getKeyCode();
			lock = true;
		}
	}

	/**
	 * Devuelve verdadero si hay bloqueo, falso en caso contrario.
	 * @return boolean que indica si hay bloqueo.
	 */
	public boolean getLock(){
		return lock;
	}

	/**
	 * Cambia el valor del bloqueo.
	 */
	public void toggleLock(){
		this.lock = !this.lock;
	}

	/**
	 * Retorna la dirección.
	 * @return entero que representa la dirección.
	 */
	public int getDirection(){
		return direction;
	}


	/**
	 * Retorna el Panel del mapa del juego
	 * @return Mapa del juego
	 */
	public JPanel getMapa(){
		return mapa;
	}

	/**
	 * Retorna el Panel de estadisticas
	 * @return Panel de estadisticias
	 */
	public PanelEstadisticas getPanelEstadisiticas(){
		return pE;
	}

	/**
	 * Agrega un Component al Mapa de la gui
	 * @param c Componente que se agrega al mapa.
	 */
	public void addMapa(Component c){
		mapa.add(c);
		mapa.repaint();
	}

	/**
	 * Elimina un Component al Mapa de la gui
	 * @param c Componente que se elimina del mapa.
	 */
	public void removeMapa(Component c){
		mapa.remove(c);
		mapa.repaint();
	}

	/**
	 * Termina el juego
	 */
	public void finalizarJuego(){
		termino = true; 
		JLabel fin = new JLabel();
		fin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesPersonajes/perdiste.jpg")));
		fin.setSize(998,416);
		addMapa(fin);
		getContentPane().add(mapa, BorderLayout.CENTER);		
	}

	/**
	 * Gano el juego
	 */
	public void ganarJuego(){
		termino = true;
		JLabel fin = new JLabel();
		fin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesPersonajes/ganaste.jpg")));
		fin.setSize(998,416);
		addMapa(fin);
		getContentPane().add(mapa, BorderLayout.CENTER);
	}

	/**
	 * Devuelve true si termino el juego, false caso contrario.
	 * @return True si el juego termino, false caso contrario
	 */

	public boolean getTermino(){
		return termino;
	}


}
