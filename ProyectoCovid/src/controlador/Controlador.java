package controlador;

//Paquetes locales
import modelo.PersonaModelo;
import modelo.DatosPersonasModelo;
import modelo.GenerarGraficaModelo;
import vista.VistaPersona;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;

/**
 * @author Sergio Flores, Alejandro Solorzano, Carlos Ibarra
 * @version 1.0.0
 * 
 */

public class Controlador implements ActionListener{
	
	//ATRIBUTOS
	
	VistaPersona vista;//vista
	DatosPersonasModelo modelo;//modelo
	
	//Aquí ya se realizó la consulta a la BD
	
	int estado = 1, sexo = 1, clas = 0; //Son indicadores, según la selección de los RadioButton
	//Predeterminadamente se mostrarán: Estado = Aguascalientes, Sexo = Hombre, Clasificacion por edad.
	
	int[] casos; //Se clasifican por edad los casos
	String labelSexo, labelClas; //Cadenas que se imprimen en Labels
	
	PersonaModelo persona;
	JPanel imagenPanel; //Nuevo panel donde se genera una gráfica
	ArrayList <PersonaModelo> lista; 
	
	//CONSTRUCTOR
	public Controlador(VistaPersona vista, DatosPersonasModelo modelo) {
		
		this.vista = vista;
		this.modelo = modelo;
		
		//addActionListeners
		this.vista.estados.addActionListener (this); //ComboBox de Estados
				
		this.vista.hombre.addActionListener (this); //RadioButtons conjunto 1 (Sexo)
		this.vista.mujer.addActionListener (this);
		
		this.vista.EPOC.addActionListener (this); //RadioButtons conjunto 2 (Clasificacion)
		this.vista.ASMA.addActionListener (this);
		this.vista.HIP.addActionListener (this); 
		this.vista.OBESIDAD.addActionListener (this);
		this.vista.EDAD.addActionListener (this);
	}
	
	
	public void actionPerformed (ActionEvent e){
        
		//ComboBox - Selección de estado
		if(e.getSource() == vista.estados){
			
			int estadoSelected = vista.estados.getSelectedIndex (); //Estado seleccionado en el ComboBox
			estado = estadoSelected + 1; //El listado de estados en la base de datos comienza en 1.
		}
		
		//Sexo
		if (e.getSource() == vista.hombre) {		
			sexo = 1;
			System.out.println ("Selección: " + sexo);
		}
		else if (e.getSource() == vista.mujer) {
			sexo = 2;
			System.out.println ("Selección: " + sexo);
		}
		
		//Clasificacion
		if (e.getSource() == vista.EPOC) {		
			clas = 1;
			System.out.println ("Selección: " + clas);
		}
		else if (e.getSource() == vista.ASMA) {
			clas = 2;
			System.out.println ("Selección: " + clas);
		}
		else if (e.getSource() == vista.HIP) {
			clas = 3;
			System.out.println ("Selección: " + clas);
		}	
		else if (e.getSource() == vista.OBESIDAD) {
			clas = 4;
			System.out.println ("Selección: " + clas);
		}
		else if (e.getSource() == vista.EDAD) {
			clas = 0;
			System.out.println ("Selección: " + clas);
		}
			
		//Impresiones de control (en consola)
		System.out.println ("Estado: " + estado);
		System.out.println ("Sexo: " + sexo);
		System.out.println ("Clasificacion: " + clas);
		
		//Actualización de Paneles
		vista.panelGrafica.updateUI();
		vista.panelGrafica.repaint();
		vista.panelGrafica.removeAll();
		
		//BUSCAR COINCIDENCIAS
		persona = new PersonaModelo ();
		lista = new ArrayList <PersonaModelo>();
		lista = modelo.listaPersonas();
	
		int casos[] = {0, 0, 0, 0, 0, 0};
		for (int i=0; i<lista.size(); i++) {
			
			if(persona.registroCoincidente(lista.get(i), estado, clas, sexo)) {
			casos = persona.guardarEdad (lista.get(i), casos);
			}
		}
		
		//Generar gráfica en vista
		GenerarGraficaModelo appFrame = new GenerarGraficaModelo("Casos COVID-19", casos);
		imagenPanel = appFrame.crearPanel();
		vista.panelGrafica.add (imagenPanel);
		
		//Actualización de Labels en la vista
		labelSexo = persona.LabelSexo (sexo);
		labelClas = persona.LabelCasos(clas);
		
		vista.labelEstado.setText ("En " + String.valueOf(vista.estados.getSelectedItem()));
		vista.labelSexo.setText (labelSexo);
		vista.labelClasificacion.setText (labelClas);
	}
}
