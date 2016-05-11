package co.edu.uniandes.valorAndes.vos;

/**
 * @author David Ricardo
 * @version 1.0
 * @created 18-sep-2014 01:23:20 p.m.
 */
public class Administrador  extends Usuario
 {
	
	//No necesario para Iter2, por lo menos para los reqs funcionales
	

	private String correo;

	public Administrador()
	{
		super( "dr.mayorga20@gmail.com", "1020792650","David", "colombiano","Av siempreviva", "2342233","Bogota","cundinamarca","111166" );
		this.tipo = Usuario.ADMIN;
		
	}

	
	public String getCorreo() 
	{
		return correo;
	}

	public void setCorreo(String correo) 
	{
		this.correo = correo;
	}
	
	public void finalize() throws Throwable 
	{

	}

}//end Administrador