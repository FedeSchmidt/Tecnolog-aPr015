package gui;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Clase PanelEstadisticas
 * @author Gómez Germán, Schmidt Federico. Comisión nº 7. Tecnología de Programación 2015.
 * @version Noviembre/2015
 */
public class PanelEstadisticas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon imagen;
	private JLabel speedUp,cantSU;
	private int totalSpeedUp;
	private JLabel fatality,cantFa;
	private int totalFatality;
	private JLabel bombality,cantBom;
	private int totalBombality;
	private JLabel masacrality,cantMa;
	private int totalMasacrality;
	private JLabel puntaje,cantPunt1,cantPunt2,cantPunt3,cantPunt4;
	private JLabel tiempo, tiempo1, tiempo2, tiempo3, tiempo4, tiempo5, tiempo6, puntos2a, puntos2b;
	private JLabel bomba, cantBombas;

	/**
	 * Lleva la cuenta de todas las estadisticas que apareceran en el panel de juego
	 */
	public PanelEstadisticas () {
		//this.setSize(100,908);
		this.setVisible(true);
		imagen = new ImageIcon(getClass().getResource("/ImagenesPersonajes/fondoNegro.png"));


		speedUp = new JLabel();
		speedUp.setBorder(new EmptyBorder(0, 10, 0, 0));
		this.speedUp.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/SpeedUp.png")));
		this.add(speedUp);
		totalSpeedUp=4;
		cantSU= new JLabel();
		cantSU.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+totalSpeedUp+".png")));
		this.add(cantSU);

		fatality = new JLabel();
		fatality.setBorder(new EmptyBorder(0, 10, 0, 0));
		this.fatality.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/fatality.png")));
		this.add(fatality);
		totalFatality=3;
		cantFa= new JLabel();
		cantFa.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+totalFatality+".png")));
		this.add(cantFa);

		bombality = new JLabel();
		bombality.setBorder(new EmptyBorder(0, 10, 0, 0));
		this.bombality.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/Bombality.png")));
		this.add(bombality);
		totalBombality=3;
		cantBom= new JLabel();
		cantBom.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+totalBombality+".png")));
		this.add(cantBom);

		masacrality = new JLabel();
		masacrality.setBorder(new EmptyBorder(0, 10, 0, 0));
		this.masacrality.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/Masacrallity.png")));
		this.add(masacrality);
		totalMasacrality=1;
		cantMa= new JLabel();
		cantMa.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+totalMasacrality+".png")));
		this.add(cantMa);

		bomba = new JLabel();
		bomba.setBorder(new EmptyBorder(0, 10, 0, 0));
		this.bomba.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/bomb_32.png")));
		this.add(bomba);
		cantBombas= new JLabel();
		cantBombas.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/1.png")));
		this.add(cantBombas);

		puntaje= new JLabel();
		puntaje.setBorder(new EmptyBorder(0, 10, 0, 0));
		this.puntaje.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/Puntos.png")));
		this.add(puntaje);
		cantPunt1= new JLabel();
		cantPunt1.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/0.png")));
		this.add(cantPunt1);
		cantPunt2= new JLabel();
		cantPunt2.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/0.png")));
		this.add(cantPunt2);
		cantPunt3= new JLabel();
		cantPunt3.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/0.png")));
		this.add(cantPunt3);
		cantPunt4= new JLabel();
		cantPunt4.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/0.png")));
		this.add(cantPunt4);

		tiempo= new JLabel();
		tiempo.setBorder(new EmptyBorder(0, 10, 0, 0));
		this.tiempo.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/tiempo.png")));
		this.add(tiempo);
		tiempo1= new JLabel();
		tiempo1.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/0.png")));
		this.add(tiempo1);
		tiempo2= new JLabel();
		tiempo2.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/0.png")));
		this.add(tiempo2);
		puntos2a= new JLabel();
		puntos2a.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/dosPuntos.png")));
		this.add(puntos2a);
		tiempo3= new JLabel();
		tiempo3.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/0.png")));
		this.add(tiempo3);
		tiempo4= new JLabel();
		tiempo4.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/0.png")));
		this.add(tiempo4);
		puntos2b= new JLabel();
		puntos2b.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/dosPuntos.png")));
		this.add(puntos2b);
		tiempo5= new JLabel();
		tiempo5.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/0.png")));
		this.add(tiempo5);
		tiempo6= new JLabel();
		tiempo6.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/0.png")));
		this.add(tiempo6);
	}

	/**
	 * Disminuye un speedUp.
	 */
	public void disminuirSpeedUp() {
		totalSpeedUp--;
		cantSU.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+totalSpeedUp+".png")));
		if(totalSpeedUp==0)
			speedUp.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/SpeedUpGris.png")));  
	}

	/**
	 * Disminuye una fatality.
	 */
	public void disminuirFatality() {
		totalFatality--;
		cantFa.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+totalFatality+".png")));
		if( totalFatality==0)
			fatality.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/FatalityGris.png")));  	
	}

	/**
	 * Disminuye una bombality.
	 */
	public void disminuirBombality() {
		totalBombality--;
		cantBom.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+totalBombality+".png")));
		if(totalBombality==0)
			bombality.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/BombalityGris.png")));  	
	}

	/**
	 * Disminuye una masacrality.
	 */
	public void disminuirMasacrality() {
		totalMasacrality--;
		cantMa.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+totalMasacrality+".png")));
		if(totalMasacrality==0)
			masacrality.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/MasacrallityGris.png")));  			  
	}

	/**
	 * Aumenta Masacrality.
	 */
	public void aumentarMasacrality(){
		totalMasacrality = 5;
	}

	/**
	 * Aumenta puntaje según el parámetro.
	 * @param punt cantidad de puntos que se suman.
	 */
	public void aumentarPuntaje(int punt) {
		cantPunt4.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+punt%10+".png"))); 
		punt/=10;
		cantPunt3.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+punt%10+".png"))); 
		punt/=10;
		cantPunt2.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+punt%10+".png")));
		punt/=10; 
		cantPunt1.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+punt%10+".png")));
		punt/=10;		  
	}

	/**
	 * Se aumenta tiempo según el parámetro.
	 * @param tiempo cantidad de tiempo que se aumenta.
	 */
	public void aumentarTiempo(int tiempo){
		int seg,hor,min;
		hor = tiempo/3600;  
		min = (tiempo-(3600*hor))/60;  
		seg = tiempo-((hor*3600)+(min*60));
		tiempo6.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+seg%10+".png")));
		tiempo5.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+seg/10+".png"))); 
		tiempo4.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+min%10+".png")));
		tiempo3.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+min/10+".png"))); 
		tiempo2.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+hor%10+".png")));
		tiempo1.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+hor/10+".png"))); 
	}

	/**
	 * 
	 */
	public void paint(Graphics g) {
		if (imagen != null) {
			g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(),  this); 
			setOpaque(false);
		} else {
			setOpaque(true);
		} 
		super.paint(g);
	}

	/**
	 * Modifica la cantidad de bombas.
	 * @param n cantidad de bombas.
	 */
	public void modificarCantBombas(int n){
		if(n>=10)
			cantBombas.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/inf.png")));
		else{
			cantBombas.setIcon(new ImageIcon(getClass().getResource("/ImagenesPersonajes/"+n+".png")));
		}
	}
}

