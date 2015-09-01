package Programa;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Interfaz extends JFrame {

	//atributos

	private Container contenedor;
	private JPanel panelImagen, panelBoton, panelTexto;
	private JButton botonImagen,botonLimpiar;
	private JLabel etiqueta1,etiquetaImagen;

	//constructor
	/**
	 * Constructor de la clase Interfaz, recibe un String que será el título de la ventana.
	 * Crea la interfaz, definiendo sus elementos y caractéristicas.
	 * @param titulo String que será el título de la ventana.
	 */
	public Interfaz(String titulo){
		super(titulo);

		contenedor=getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450, 350);
		contenedor.setLayout(new BorderLayout());


		//creo paneles
		crearPaneles();

		//creo botones y los relaciono con sus oyentes
		crearBoton();

		//inserto botones en panel correspondiente
		panelBoton.add(botonImagen);
		panelBoton.add(botonLimpiar);

		//creo etiquetas e inserto en los paneles correspondientes
		etiqueta1=new JLabel("");
		etiquetaImagen=new JLabel();
		etiquetaImagen.setIcon(new ImageIcon(this.getClass().getResource("/Programa/homer.gif")));

		panelImagen.add(etiquetaImagen);
		panelTexto.add(etiqueta1);

		//agrego paneles al contenedor
		contenedor.add(panelImagen, BorderLayout.NORTH);
		contenedor.add(panelBoton);	
		contenedor.add(panelTexto, BorderLayout.SOUTH);	
	}
	private void crearPaneles(){
		panelImagen= new JPanel();
		panelImagen.setLayout (new FlowLayout());		

		panelBoton= new JPanel();
		panelBoton.setLayout (new FlowLayout());

		panelTexto= new JPanel();
		panelTexto.setLayout (new FlowLayout());

	}

	private void crearBoton(){

		OyenteBoton ob=new OyenteBoton();
		botonImagen= new JButton ("¡¡¡Los Simpson!!!");
		botonImagen.addActionListener(ob);

		OyenteLimpiar ol=new OyenteLimpiar();
		botonLimpiar=new JButton ("Borrar");
		botonLimpiar.addActionListener(ol);
		botonLimpiar.setEnabled(false);
	}

	private class OyenteBoton implements ActionListener{
		public void actionPerformed (ActionEvent event){

			etiqueta1.setText("¡¡Vas a morir Moe!!... Wiiiiii");
			botonLimpiar.setEnabled(true);
			botonImagen.setEnabled(false);

		}
	}
	private class OyenteLimpiar implements ActionListener{
		public void actionPerformed (ActionEvent event){

			etiqueta1.setText("");
			botonLimpiar.setEnabled(false);
			botonImagen.setEnabled(true);
		}
	}

}
