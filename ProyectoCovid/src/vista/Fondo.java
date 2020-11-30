package vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author Sergio Flores, Alejandro Solorzano, Carlos Ibarra
 * @version 1.0.0
 * 
 */

public class Fondo extends JPanel {
	
	private Image imagen;
	
	@Override//se sobreescribe la función
	public void paint (Graphics g) {
		
		//Creación de la imagen que se utilizará de fondo obteniendola desde src
		imagen = new ImageIcon (getClass().getResource("salud2.jpg")).getImage();
		//Se "dibuja" en el panel con las especificaciones dadas
		g.drawImage (imagen, 0, 0, getWidth(), getHeight(), this);
		setOpaque (false); //Transparencia
		super.paint(g);
	}

}
