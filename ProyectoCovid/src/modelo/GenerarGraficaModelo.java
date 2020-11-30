package modelo;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author Sergio Flores, Alejandro Solorzano, Carlos Ibarra
 * @version 1.0.0
 * 
 */

public class GenerarGraficaModelo extends JFrame {
	//Atributos
	private static String edades[] = {"20-30", "30-40", "40-50", "50-60", "60-70", "70-100"};
    private int[] casos ;
    private String titulo;
    
    /*
	 * Metodo constructor
	 */
    public GenerarGraficaModelo(String titulo, int[] casos) {
        super(titulo);
    	this.titulo = titulo;
        this.casos = casos;
    }

    /*
	 * Metodo que genera el panel de la grafica
	 * @return JPanel
	 */
    public JPanel crearPanel() {
        CategoryDataset datos = crearDatos();
        JFreeChart grafica = crearGrafica(datos);
        ChartPanel panel = new ChartPanel(grafica);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(Color.white);
        return panel;
    }
    
    /*
	 * Metodo que inserta los datos dentro de la grafica
	 * @return dataset
	 */
    private CategoryDataset crearDatos() {

        var datos = new DefaultCategoryDataset();
        datos.setValue(casos[0], "Numero de casos", edades[0]);
        datos.setValue(casos[1], "Numero de casos", edades[1]);
        datos.setValue(casos[2], "Numero de casos", edades[2]);
        datos.setValue(casos[3], "Numero de casos", edades[3]);
        datos.setValue(casos[4], "Numero de casos", edades[4]);
        datos.setValue(casos[5], "Numero de casos", edades[5]);
        
        return datos;
    }
    
    /*
	 * Metodo que genera la grafica a partir de los datos y un titulo
	 * @return barChart
	 */
    private JFreeChart crearGrafica(CategoryDataset dataset) {
        JFreeChart grafica = ChartFactory.createBarChart(
        titulo,
        "",
        "Numero de casos",
        dataset,
        PlotOrientation.VERTICAL,
        false, true, false);
        return grafica;
    }
}