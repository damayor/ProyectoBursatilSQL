package co.edu.uniandes.valorAndes.vos;

import java.util.ArrayList;

/**
 * @version 1.0
 * @created 18-sep-2014 01:23:20 p.m.
 */
public class Oferente extends Usuario 
{

	
	private Intermediario intermediario;
	
	private ArrayList<Valor> valores;
	
	
	/**
	 * 
	 * @param correo
	 * @param documentoId
	 * @param nombre
	 * @param nacionalidad
	 * @param direccion
	 * @param telefono
	 * @param ciudad
	 * @param departamento
	 * @param codigoPostal
	 * @param intermediario
	 */
	public Oferente(String correo, String documentoId, String nombre,
			String nacionalidad, String direccion, String telefono,
			String ciudad, String departamento, String codigoPostal, Intermediario intermediario,ArrayList<Valor> nvosVal)
	{
		super( correo,  documentoId,  nombre,
				 nacionalidad,  direccion,  telefono,
				 ciudad,  departamento,  codigoPostal);
		this.tipo = Usuario.OFERENTE;
		this.intermediario = intermediario;
		this.valores=nvosVal;

	}

	
	public Intermediario getIntermediario() {
		return intermediario;
	}



	public ArrayList<Valor> getTiposValores() {
		return valores;
	}

	public void setIntermediario(Intermediario intermediario) {
		this.intermediario = intermediario;
	}



	public void setTiposValores(ArrayList<Valor> valores) {
		this.valores = valores;
	}



	public void finalize() throws Throwable {
		super.finalize();
	}
}//end Oferente