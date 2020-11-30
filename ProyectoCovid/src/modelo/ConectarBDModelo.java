package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * @author Sergio Flores, Alejandro Solorzano, Carlos Ibarra
 * @version 1.0.0
 * 
 */

public class ConectarBDModelo {
	
	/*Atributos*/
	//Objeto de tipo Connection 
	private static Connection conn; 
	//Conexion con jar externo
	private static final String driver = "com.mysql.jdbc.Driver";
	//Usuario y contraseña
	private static final String user = "root";
	private static final String password = "";
	//Url de conexion
	private static final String url = "jdbc:mysql://localhost:3306/pruebapoo";
	
	/*
	 * Metodo para conectarse a una base de datos mysql usando un url, usuario y contraseña
	 */
	public ConectarBDModelo(){
		
		conn = null;
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			if (conn != null){
				System.out.println("Se conectó a la base de Datos");
			}
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, "No se conectó, cerrando aplicacion","Covid 2020",JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
	
	/*
	 * Metodo para recuperar el objeto de tipo Connection
	 * @return variable que contiene la conexion con la base de datos mysql
	 */
	public Connection getConnection(){
		
		return conn;
	}
	
	/*
	 * Metodo para cerrar la conexión.
	 */
	public void DesConnecton(){
		
		conn = null;
		if(conn == null){
			System.out.println("Terminó conexión");
		}
   }
}
