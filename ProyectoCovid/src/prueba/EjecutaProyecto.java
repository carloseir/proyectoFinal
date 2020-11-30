package prueba;

import controlador.Controlador;
import vista.VistaPersona;
import modelo.DatosPersonasModelo;

/**
 * @author Sergio Flores, Alejandro Solorzano, Carlos Ibarra
 * @version 1.0.0
 * 
 */

public class EjecutaProyecto {

	public static void main (String[] args) {
		
		//MODELO VISTA CONTROLADOR (MVC)
		
	     VistaPersona vista = new VistaPersona();
		 DatosPersonasModelo modelo = new DatosPersonasModelo();
		 
		 Controlador controlador = new Controlador(vista, modelo);
		 vista.setVisible(true);//Mostrar frame de Vista
	}

}
