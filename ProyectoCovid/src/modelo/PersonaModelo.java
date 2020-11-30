package modelo;

/**
 * @author Sergio Flores, Alejandro Solorzano, Carlos Ibarra
 * @version 1.0.0
 * 
 */

public class PersonaModelo {
	
	/*Atributos*/
	private int entidad;
	private int sexo;
	private int edad;
	private int epoc;
	private int asma;
	private int obesidad;
	private int hipertension;
	
	/*Metodo Constructor*/
	public PersonaModelo(){
		entidad = 0;
		sexo = 0;
		edad = 0;
		epoc = 0;
		asma = 0;
		obesidad = 0;
		hipertension = 0;
	}
	
	/*Metodos Set y Get*/
	public int getEntidad() {
		return entidad;
	}

	public void setEntidad(int estado) {
		this.entidad = estado;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getEpoc() {
		return epoc;
	}

	public void setEpoc(int epoc) {
		this.epoc = epoc;
	}

	public int getAsma() {
		return asma;
	}

	public void setAsma(int asma) {
		this.asma = asma;
	}

	public int getObesidad() {
		return obesidad;
	}

	public void setObesidad(int obesidad) {
		this.obesidad = obesidad;
	}

	public int getHipertension() {
		return hipertension;
	}

	public void setHipertension(int hipertension) {
		this.hipertension = hipertension;
	}
	
	/*Metodo para definir el tipo de sexo en la busqueda*/
	public int identificarSexo (String sexo) {
	
		if (sexo.equals("Hombre")) {
			return 1;
		}
		if (sexo.equals("Mujer")){
			return 2;
		}
		else {
			return 0;
		}
	}
	
	/*Metodo para definir el tipo de enfermedad en la busqueda*/
	public int identificarEnfermedad (String enfermedad) {
		
		if (enfermedad.equals("Epoc")) {
			return 1;
		}
		if (enfermedad.equals("Asma")){
			return 2;
		}
		if (enfermedad.equals("Obesidad")){
			return 3;
		}
		if (enfermedad.equals("Hipertension")){
			return 4;
		}
		else {
			return 0;
		}
	}
	
	/*Metodo para encontrar objetos que coincidan con los criterios de busqueda*/
	public boolean registroCoincidente (PersonaModelo objeto, int estado, int enfermedad, int sexo) {
		
		switch (enfermedad) {
		case 0:
			if (objeto.getEntidad() == estado && objeto.getSexo() == sexo) {
				return true;
			}
			else {
				return false;
			}
			
		case 1:
			if (objeto.getEntidad() == estado && objeto.getSexo() == sexo && objeto.getEpoc() == 1) {
				return true;
			}
			else {
				return false;
			}
			
		case 2:
			if (objeto.getEntidad() == estado && objeto.getSexo() == sexo && objeto.getAsma() == 1) {
				return true;
			}
			else {
				return false;
			}
			
		case 3:
			if (objeto.getEntidad() == estado && objeto.getSexo() == sexo && objeto.getObesidad() == 1) {
				return true;
			}
			else {
				return false;
			}
			
		case 4:
			if (objeto.getEntidad() == estado && objeto.getSexo() == sexo && objeto.getHipertension() == 1) {
				return true;
			}
			else {
				return false;
			}
			
		default:
			return false;
		}
	}
	
	/*Metodo para encontrar objetos que coincidan con los criterios de busqueda*/
	public int[] guardarEdad (PersonaModelo objeto, int[] casos) {
	
		if (objeto.getEdad() >= 20 && objeto.getEdad() <= 30) {
			casos[0]= casos[0] + 1;
			return casos;
		}
		if (objeto.getEdad() > 30 && objeto.getEdad() <= 40) {
			casos[1]= casos[1] + 1;
			return casos;
		}
		if (objeto.getEdad() > 40 && objeto.getEdad() <= 50) {
			casos[2]= casos[2] + 1;
			return casos;
		}
		if (objeto.getEdad() > 50 && objeto.getEdad() <= 60) {
			casos[3]= casos[3] + 1;
			return casos;
		}
		if (objeto.getEdad() > 60 && objeto.getEdad() <= 70) {
			casos[4]= casos[4] + 1;
			return casos;
		}
		if (objeto.getEdad() > 70 && objeto.getEdad() <= 110) {
			casos[5]= casos[5] + 1;
			return casos;
		}
		return casos;
	}
	
	/*Metodo para convertir un id de sexo a String*/
	public String LabelSexo (int sexo) {
		String label = null;
		if (sexo == 1) {
			label = "Población de hombres";
			return label;
		}
		else if (sexo == 2) {
			label = "Población de mujeres";
			return label;
		}
		return label;
	}
	
	/*Metodo para convertir un id de casos a String*/
	public String LabelCasos (int clas) {
		String label = null;
		if (clas == 1) {
			label = "Casos con EPOC";
			return label;
		}
		else if (clas == 2) {
			label = "Casos con asma";
			return label;
		}
		else if (clas == 3) {
			label = "Casos con hipertensión";
			return label;
		}
		else if (clas == 4) {
			label = "Casos con obesidad";
			return label;
		}
		else if (clas == 0) {
			label = "Casos por edad";
			return label;
		}	
		return label;
	}
}
