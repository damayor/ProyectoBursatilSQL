package co.edu.uniandes.valorAndes.vos;

import java.util.ArrayList;

/**
 * @author David Ricardo
 * @version 1.0
 * @created 18-sep-2014 01:23:20 p.m.
 */
public class Intermediario extends Usuario {

	private String numRegistro;
	
	/**
	 * En lo posible para esta iteracion se va a tener solo un cliente por intermediario
	 */
	private Usuario cliente;
	
	//private PortafolioIntermediario portafolios;
	/**
	private Inversionista clienteInversionista;
	 */
	
	private PortafolioIntermediario portafolioModerado;
	
	
	private PortafolioIntermediario portafolioConservador;

	
	private PortafolioIntermediario portafolioAgresivo;

	/**
	 * Se registra su nombre, , ciudad, dirección, teléfono y nombre e identificación 
	 * @param correo del representante legal
	 * @param documentoId del representante legal. 
	 * @param nombre del representante legal.
	 * @param nacionalidad del representante legal.
	 * @param direccion del representante legal.
	 * @param telefono del representante legal.
	 * @param ciudad del representante legal
	 * @param departamento del representante legal
	 * @param codigoPostal del representante legal
	 * @param numRegistro número de registro ante la Superintendencia Nacional de Valores
	 */
	public Intermediario(String correo, String documentoId, String nombre,
			String nacionalidad, String direccion, String telefono,
			String ciudad, String departamento, String codigoPostal, String numRegistro){
		super( correo,  documentoId,  nombre,
				 nacionalidad,  direccion,  telefono,
				 ciudad,  departamento,  codigoPostal);
		tipo = Usuario.INTERMEDIARIO;
		this.numRegistro = numRegistro;
		cliente = null;
		
		portafolioModerado = new PortafolioIntermediario(PortafolioIntermediario.MODERADO, this);
		portafolioAgresivo = new PortafolioIntermediario(PortafolioIntermediario.AGRESIVO, this);
		portafolioConservador = new PortafolioIntermediario(PortafolioIntermediario.CONSERVADOR, this);

		
		//clienteInversionista = null;
	}

	public String getNumRegistro() {
		return numRegistro;
	}


	public Usuario getCliente() 
	{
		return cliente;
	}


	public void setNumRegistro(String numRegistro) {
		this.numRegistro = numRegistro;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	/**
	 * 
	 * @return true si el Inversionista no es nulo
	 */
	public boolean esClienteInversionista()
	{
		//TODO hasta ahora, para esta iteracion, no ha sido necesario difenrecia un cliente inversionista de un oferente.
		return false;
	}
	
	public PortafolioIntermediario getPortafolio(String tipo)
	{
		if(tipo.equals(PortafolioIntermediario.AGRESIVO))
		{
			return portafolioAgresivo;
		}
		else if(tipo.equals(PortafolioIntermediario.MODERADO))
		{
			return portafolioModerado;
		}
		else if(tipo.equals(PortafolioIntermediario.CONSERVADOR))
		{
			return portafolioConservador;
		}
			System.out.println("No retorno ningun portafolio");
			return null;
	}
	
	
	//--- R12 - Recomponer portafolio intermediario
	
	/**
	 * Agrega al portafolio del tipo seleccionado, los valores que entran por parametro
	 */
	public void hacerPortafolio(String tipo, ArrayList<Valor> valores)
	{	
		PortafolioIntermediario portafolio = getPortafolio(tipo);
		
		for(int i = 0; i<valores.size(); i++)
		{
			Valor e = valores.get(i);
			portafolio.agregarValor(e);
		}
	}
	
	
	
	
	public void finalize() throws Throwable {
		super.finalize();
	}
}//end Intermediario