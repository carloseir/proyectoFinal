package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

/**
 * @author Sergio Flores, Alejandro Solorzano, Carlos Ibarra
 * @version 1.0.0
 * 
 */

public class VistaPersona extends JFrame{
	
	//Labels en panelder
	public JLabel labelEstado;
	public JLabel labelSexo;
	public JLabel labelClasificacion;
	
	//Paneles con imagen de fondo
	public Fondo panelizq; //Panel izquierdo y derecho, divide en dos el Frame
	public JPanel panelder;
	public Fondo panelGrafica; //Para la grafica dentro del panel derecho
	
	//ComboBox e Items
	private String[] E = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Coahuila de Zaragoza", "Colima", "Chiapas", "Chihuahua", "CDMX", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "México", "Michoacán de Ocampo", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz de Ignancio de la Llave", "Yucatán", "Zacatecas", "Estados Unidos Mexicanos"};
	public JComboBox estados;
	
	//Grupos de RadioButton
	public ButtonGroup sexo, enfermedades;
	public JRadioButton hombre, mujer;//sexo
	public JRadioButton EPOC, ASMA, HIP, OBESIDAD, EDAD;//enfermedades
	
	//Diseño
	private Color colorFondo = new Color(255, 255, 255); //Color blanco
	private Font fuenteRadios = new Font("Serif", Font.PLAIN, 20); //Texto plano
	private Font fuenteLabels = new Font("Serif", Font.BOLD, 20); //Negrita
	
	//CONSTRUCTOR
	public VistaPersona () {
		
		super ("Registro de casos de COVID-19 en México a Noviembre de 2020"); //Titulo de Ventana
		setSize (1350, 700);
		setLayout (new GridLayout (1, 2)); //Divide el Frame principal en dos paneles, izquierda y derecha
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setResizable (true);
		
		//Imagen de ícono
		try {
			setIconImage (new ImageIcon(getClass().getResource("virus.jpg")).getImage());
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontraron archivos de imagenes.", "Covid 2020",JOptionPane.INFORMATION_MESSAGE);
			System.exit(1);
		}

		/* ****** PANEL IZQUIERDO ******* */	
		
		//ComboBox
		estados = new JComboBox (E);
		estados.setBounds(20, 20, 300, 50);
		estados.setSelectedIndex (0); //Aguascalientes será el estado predeterminado seleccionado
		
		//Primer conjunto de RadioButtons
		hombre = new JRadioButton ("Hombre");
		hombre.setBounds(20, 120, 100, 30);
		hombre.setBackground(colorFondo);
		hombre.setFont(fuenteRadios);
		mujer = new JRadioButton ("Mujer");
		mujer.setBounds(20, 170, 80, 30);
		mujer.setBackground(colorFondo);
		mujer.setFont(fuenteRadios);
		sexo = new ButtonGroup();
		sexo.add(hombre);
		sexo.add(mujer);
		
		//Segundo conjunto de RadioButtons
		EPOC = new JRadioButton ("EPOC");
		EPOC.setBounds(20, 300, 100, 30);
		EPOC.setBackground(colorFondo);
		EPOC.setFont(fuenteRadios);
		ASMA = new JRadioButton ("Asma");
		ASMA.setBounds(180, 300, 100, 30);
		ASMA.setBackground(colorFondo);
		ASMA.setFont(fuenteRadios);
		HIP = new JRadioButton ("Hipertensión");
		HIP.setBounds(20, 350, 150, 30);
		HIP.setBackground(colorFondo);
		HIP.setFont(fuenteRadios);
		OBESIDAD = new JRadioButton ("Obesidad");
		OBESIDAD.setBounds(180, 350, 120, 30);
		OBESIDAD.setBackground(colorFondo);
		OBESIDAD.setFont(fuenteRadios);
		EDAD = new JRadioButton ("Edad (Casos totales)");
		EDAD.setBounds(20, 400, 200, 30);
		EDAD.setBackground(colorFondo);
		EDAD.setFont(fuenteRadios);
		//Se agregan a su ButtonGroup
		enfermedades = new ButtonGroup ();
		enfermedades.add(EPOC);
		enfermedades.add(ASMA);
		enfermedades.add(HIP);
		enfermedades.add(OBESIDAD);
		enfermedades.add(EDAD);
		
		//Creación del panel
		panelizq = new Fondo ();
		panelizq.setLayout (null);
		panelizq.setBackground(colorFondo);
		 //Adición de elementos al panel
		panelizq.add (estados);
		panelizq.add (hombre);
		panelizq.add (mujer);
		panelizq.add (EPOC);
		panelizq.add (ASMA);
		panelizq.add (HIP);
		panelizq.add (OBESIDAD);
		panelizq.add (EDAD);
		
		this.add (panelizq);//Al frame
		
		/* ****** PANEL DERECHO ******* */
		
		//Labels		
		labelEstado = new JLabel ("Estado");
		labelEstado.setBounds (0, 0, 500, 100);
		labelEstado.setFont (fuenteLabels);
		labelSexo = new JLabel ("Sexo");
		labelSexo.setBounds (0, 50, 500, 100);
		labelSexo.setFont (fuenteLabels);
		labelClasificacion = new JLabel ("Especificaciones");
		labelClasificacion.setBounds (0, 100, 500, 100);
		labelClasificacion.setFont (fuenteLabels);
	    
		//Panel donde se muestra la gráfica
		panelGrafica = new Fondo ();
		panelGrafica.setBounds (0, 180, 650, 600);
		panelGrafica.setBackground(colorFondo);
		
		//Creación del panel		 
		panelder = new JPanel ();
	    panelder.setLayout (null);
	    panelder.setBackground(colorFondo);
	    //Adición de elementos al panel
		panelder.add (labelEstado);
		panelder.add (labelSexo);
		panelder.add (labelClasificacion);
		panelder.add (panelGrafica);
		
		this.add(panelder);//Al frame	
	}
}
