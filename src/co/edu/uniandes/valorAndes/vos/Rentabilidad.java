package co.edu.uniandes.valorAndes.vos;

/**
 * @author David Ricardo
 * @version 1.0
 * @created 20-sep-2014 12:00:10 p.m.
 */
public class Rentabilidad {
	
	public static final String COMPORTAMIENTO_FIJO ="FIJO";
	
	public static final String COMPORTAMIENTO_VARIABLE ="VARIABLE";
	
	public static final String DURACION_DEFINIDA ="DEFINIDA";
	
	public static final String DURACION_INDEFINIDA ="INDEFINIDA";

	public static final String FIJO_DEFINIDO = "Rentabilidad Fija";
	
	public static final String FIJO_INDEFINIDO = "Rentabilidad Fija indefinida";

	public static final String VARIABLE_DEFINIDO = "Rentabilidad Variable";

	public static final String VARIABLE_INDEFINIDO = "Rentabilidad Variable Indefinido";


	private String idRentabilidad;
	private String nombreRentabilidad;
	private String descripcionRentabilidad;
	private String funcionamiento;

	public Rentabilidad(String comportamiento, String duracion)
	{
		if(comportamiento.equalsIgnoreCase(COMPORTAMIENTO_FIJO) && duracion.equalsIgnoreCase(DURACION_DEFINIDA) )
		{
			nombreRentabilidad = "Fijo definido";
			idRentabilidad = "1";
			descripcionRentabilidad = "Rentabilidad que no varia y tiene un plazo definido.";
			funcionamiento = FIJO_DEFINIDO;
		}
		else if(comportamiento.equalsIgnoreCase(COMPORTAMIENTO_FIJO) && duracion.equalsIgnoreCase(DURACION_INDEFINIDA) )
		{
			nombreRentabilidad = "Fijo indefinido";
			idRentabilidad = "2";
			descripcionRentabilidad = "Rentabilidad que no varia y tiene un plazo indefinido.";
			funcionamiento = FIJO_INDEFINIDO;
		}
		else if(comportamiento.equalsIgnoreCase(COMPORTAMIENTO_VARIABLE) && duracion.equalsIgnoreCase(DURACION_DEFINIDA) )
		{
			nombreRentabilidad = "Variable definido";
			idRentabilidad = "3";
			descripcionRentabilidad = "Rentabilidad que varia y tiene un plazo definido.";
			funcionamiento = VARIABLE_DEFINIDO;
		}
		else if(comportamiento.equalsIgnoreCase(COMPORTAMIENTO_VARIABLE) && duracion.equalsIgnoreCase(DURACION_INDEFINIDA) )
		{
			nombreRentabilidad = "Variable indefinido";
			idRentabilidad = "4";
			descripcionRentabilidad = "Rentabilidad que varia y tiene un plazo indefinido.";
			funcionamiento = VARIABLE_INDEFINIDO;
		}
		else
		{	
				System.out.println("comportamiento o duracion no equivalentes a constantes");
		}
		
	}

	
	
	public String getIdRentabilidad() {
		return idRentabilidad;
	}



	public String getNombreRentabilidad() {
		return nombreRentabilidad;
	}



	public String getDescripcionRentabilidad() {
		return descripcionRentabilidad;
	}



	public String getFuncionamiento() {
		return funcionamiento;
	}



	public void setIdRentabilidad(String idRentabilidad) {
		this.idRentabilidad = idRentabilidad;
	}



	public void setNombreRentabilidad(String nombreRentabilidad) {
		this.nombreRentabilidad = nombreRentabilidad;
	}



	public void setDescripcionRentabilidad(String descripcionRentabilidad) {
		this.descripcionRentabilidad = descripcionRentabilidad;
	}



	public void setFuncionamiento(String funcionamiento) {
		this.funcionamiento = funcionamiento;
	}



	public void finalize() throws Throwable {

	}
}//end Rentabilidad