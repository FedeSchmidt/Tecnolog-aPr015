package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Juego.Juego;
import Threads.*;

/**
 * Clase GUI
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Octubre/2015
 */
public class GUI extends JFrame {

	//Atributos
	private JPanel contentPane;
	private Juego j;
	private BombermanThread hiloBomberman;
	private boolean lock = false;
	private int direction = -1;

	/**
	 * Inicia el programa.
	 */	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Crea la interfaz, definiendo sus elementos y caractéristicas.
	 */
	public GUI() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				mover(arg0);
			}
		});
		getContentPane().setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 444);		
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		j = new Juego(this);
		hiloBomberman = new BombermanThread(j, this);
		hiloBomberman.start();

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
	 * Retorna el hilo del personaje
	 * @return Hilo del personaje manejado por el usuario
	 */
	public BombermanThread getBombermanThread(){
		return hiloBomberman;
	}
}