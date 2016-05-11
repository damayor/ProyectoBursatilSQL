package co.edu.uniandes.valorAndes.vos;

import java.util.ArrayList;

/**
 * @version 1.0
 * @created 18-sep-2014 01:23:20 p.m.
 */
public class Inversionista extends Usuario {

	private ArrayList<String> intermediariosLog;
	
	private Intermediario intermediario;
	
	private ArrayList<PortafolioInversionista> portafolios;

	/**
	 * 
	 * @param correo
	 * @param documentoId - En caso de ser una empresa, es la identificacion del representante legal.
	 * @param nombre - En caso de ser una empresa, es el nombre del representante legal.
	 * @param nacionalidad
	 * @param direccion
	 * @param telefono
	 * @param ciudad
	 * @param departamento
	 * @param codigoPostal
	 */
	public Inversionista(String correo, String documentoId, String nombre,
			String nacionalidad, String direccion, String telefono,
			String ciudad, String departamento, String codigoPostal, Intermediario intermediario)
	{
		super( correo,  documentoId,  nombre,
				 nacionalidad,  direccion,  telefono,
				 ciudad,  departamento,  codigoPostal);
		this.intermediario = intermediario;
		this.tipo = Usuario.INVERSIONISTA;
		this.setPortafolios(new ArrayList<PortafolioInversionista>());
	}
	
	public Inversionista(String correo, String documentoId, String nombre,
			String nacionalidad, String direccion, String telefono,
			String ciudad, String departamento, String codigoPostal, ArrayList<String> nintermediarios)
	{
		super( correo,  documentoId,  nombre,
				 nacionalidad,  direccion,  telefono,
				 ciudad,  departamento,  codigoPostal);
		this.intermediariosLog = nintermediarios;
		this.tipo = Usuario.INVERSIONISTA;
		this.setPortafolios(new ArrayList<PortafolioInversionista>());
	}

	public ArrayList<String> getIntermediarios() {
		return intermediariosLog;
	}

	public void setIntermediarios(ArrayList<String> intermediarios) {
		this.intermediariosLog = intermediarios;
	}

	public Intermediario getIntermediario() {
		return intermediario;
	}

	public void setIntermediario(Intermediario intermediario) {
		this.intermediario = intermediario;
	}



	public ArrayList<PortafolioInversionista> getPortafolios() {
		return portafolios;
	}



	public void setPortafolios(ArrayList<PortafolioInversionista> portafolios) {
		this.portafolios = portafolios;
	}
	
	public PortafolioInversionista buscarPortafolio(PortafolioInversionista buscado)
	{
		boolean found = false;
		for(int i =0; i<portafolios.size() && !found;i++)
		{
			PortafolioInversionista act = portafolios.get(i);
			if(act.compareTo(buscado)==0)
			{
				found = true;
				return act;
			}
		}
		return null;
	}
	
	
	//--- R12 - Recomponer portafolio intermediario
	
	/**
	 * Crea al portafolio del inversionista con el portafolio de orgien y los debidos porcentajes de cada valor. 
	 * <b>pre:</b> porcentajesValores debe ser de la misma longitud que la cantidad de valores que ofrece el portafolio
	 */
	public void crearPortafolio(PortafolioIntermediario pOrigen, double[] porcentajesValores)
	{

		PortafolioInversionista nPortafolio = new PortafolioInversionista(porcentajesValores, pOrigen, this);
		
		portafolios.add(nPortafolio);
		
		
	}



	public void finalize() throws Throwable {
		super.finalize();
	}
}//end Inversor