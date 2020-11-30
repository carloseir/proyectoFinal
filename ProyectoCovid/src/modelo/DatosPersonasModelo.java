package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * @author Sergio Flores, Alejandro Solorzano, Carlos Ibarra
 * @version 1.0.0
 * 
 */

public class DatosPersonasModelo {
	
	/*Atributos*/
	ConectarBDModelo conectarBDModelo;
	public DatosPersonasModelo(){
		conectarBDModelo = new ConectarBDModelo();
	}
	
	/*
	 * Metodo para almacenar toda la lista de personas en un arraylist
	 */
	public ArrayList<PersonaModelo> listaPersonas(){
		
		ArrayList<PersonaModelo> lista = new ArrayList<PersonaModelo>();
		
		try{
			// recuperar la conexion
			Connection conn = conectarBDModelo.getConnection();
			// Seleccionar filas y guardarlas. 
			PreparedStatement fila = conn.prepareStatement("select * from covid");
            ResultSet rs = fila.executeQuery();
            
            while(rs.next()){
            	// Lee cada uno de las columnas de la tabla
        		PersonaModelo personaModelo = new PersonaModelo();
        		personaModelo.setSexo(rs.getInt(1));
        		personaModelo.setEntidad(rs.getInt(2));
        		personaModelo.setEdad(rs.getInt(3));
        		personaModelo.setEpoc(rs.getInt(4));
        		personaModelo.setAsma(rs.getInt(5));
        		personaModelo.setHipertension(rs.getInt(6));
        		personaModelo.setObesidad(rs.getInt(7));
            	lista.add(personaModelo); 
            }
            
		}
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "No se conectó, cerrando aplicacion","Covid 2020",JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		return lista;
	}
}