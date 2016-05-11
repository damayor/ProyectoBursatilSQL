package co.edu.uniandes.valorAndes.vos;

import java.util.ArrayList;

/**
 * @version 1.0
 * @created 18-sep-2014 01:23:21 p.m.
 */
public class Usuario implements Comparable<Usuario>
{

	public static final String ADMIN = "Admin";
	
	public static final String OFERENTE = "Oferente";

	public static final String INTERMEDIARIO = "Intemediario";

	public static final String INVERSIONISTA = "Inversionista";

	protected String tipo;
	
	private String correo;
	
	/**
	 * documento del usuario o repressentante legal de la empresa, eso si puede cambiar, paila
	 */
	private String documentoId;
	private String nombre;
	private String nacionalidad;
	private String direccion;
	private String telefono;
	private String ciudad;
	private String departamento;
	private String codigoPostal;
	private ArrayList<OperacionBursatil> compras;
	private ArrayList<OperacionBursatil> ventas;
	



	public Usuario(String correo, String nombre, String ciudad,
			String codigoPostal, String departamento, String direccion,
			String documentoId, String nacionalidad, String tipo) 
	
	{
		this.setTipo(tipo);
		this.correo = correo;
		this.documentoId = documentoId;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.direccion = direccion;
		this.tipo = tipo;
		this.ciudad = ciudad;
		this.departamento = departamento;
		this.codigoPostal = codigoPostal;
		this.compras = new ArrayList<OperacionBursatil>();
		this.setVentas(new ArrayList<OperacionBursatil>());
	}

	public String getCorreo() {
		return correo;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDocumentoId() {
		return documentoId;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getDepartamento() {
		return departamento;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public ArrayList<OperacionBursatil> getCompras() {
		return compras;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public void setCompras(ArrayList<OperacionBursatil> compras) {
		this.compras = compras;
	}


	/**
	 * @return the ventas
	 */
	public ArrayList<OperacionBursatil> getVentas() {
		return ventas;
	}

	/**
	 * @param ventas the ventas to set
	 */
	public void setVentas(ArrayList<OperacionBursatil> ventas) {
		this.ventas = ventas;
	}
	
	
	public int compareTo(Usuario otro) {
		if(correo.compareTo(otro.getCorreo())>0)
		{
			return 1;
		}
		else if(correo.compareTo(otro.getCorreo())<0)
		{
			return -1;
		}
		else
			return 0;
	}


	public void finalize() throws Throwable {

	}

	

}//end Usuario