package co.edu.uniandes.valorAndes.vos;

/**
 * @author David Ricardo
 * @version 1.0
 * @created 18-sep-2014 01:25:14 p.m.
 */
public class Valor implements Comparable<Valor>
{

	private String nombre;
	private double precio;
	private Rentabilidad rentabilidad;
	private TipoValor tipo;
	
	/**
	 * comenta si hay alguna orden de compra respecto a este valor
	 */
	private boolean negociado;
	
	/**
	 * cantidad de ordenes de compra que se han realizado del valor. ordenes >= 0
	 */
	private int ordenes;
	
	/**
	 * Empresa oferente dueña del valor. Siempre va a ser la dueña.
	 */
	private String duenio;

	/**
	 * 
	 * @param nombre nombre del valor. normalmente son 4 letras mayusculas
	 * @param precio precio unitario que posee la accion al momento de comprarla
	 * @param tipo tipo valor tiene que ser igual a TipoValor.ACCION, TipoValor.BONO_PUBLICO, TipoValor.BONO_PRIVADO, TipoValor.CERTIFICADO, TipoValor.TITULO_PARTICIPACION 
	 * @param duracion duracion de la rentabilidad. Tiene que ser igual a Rentabilidad.DEFINIDA o Rentabilidad.INDEFINIDA
	 * @param comportamiento de la rentabiliad. Tiene que ser igual a Rentabilidad.FIJO o Rentabilidad.VARIABLE
	 * @param duenio Oferente que sacó al mercado la accion
	 */
	public Valor(String nombre, double precio, String tipo, String duracion, String comportamiento, String duenio) 
	{
		super();
		this.nombre = nombre;
		this.precio = precio;
		//this.rentabilidad = new Rentabilidad (comportamiento, duracion);
		this.tipo = new TipoValor (tipo);
		this.duenio = duenio;
		this.negociado = false;
		this.ordenes = 0;
		
	}

	//Metodos
	
	/**
	 * disminuye las ordenes. si las ordenes de esta son 0, ya no esta en negociacion el valor
	 * @throws Exception
	 */
	public void disminuirOrdenes() throws Exception
	{

		if(ordenes==1)
		{
			ordenes--;
			negociado = false;		
			

		}
		else if(ordenes>1)
		{
			ordenes--;

		}
		else
			throw new Exception("no se pueden disminuir mas las ordenes ya q es 0");
			
	}
	
	/**
	 * Si es la primera orden que le llega, se pone en negociado el valor.
	 * @throws Exception
	 */
	public void aumentarOrdenes()
	{
		if(ordenes==0)
		{
			negociado = true;
			ordenes++;
		}
		else
		{
			ordenes ++;
		}
			
	}
	
	public boolean isNegociado()
	{
		return negociado;
	}
	
	public void setNegociado(boolean negociado)
	{
		this.negociado = negociado;
	}
	
	
	public int getCantidadOrdenes()
	{
		return ordenes;
	}
	
	//Getters And Setters
	
	public String getNombre() {
		return nombre;
	}

	/**
	 * precio unitario por valor
	 * @return precio del valor
	 */
	public double getPrecio() {
		return precio;
	}


	public Rentabilidad getRentabilidad() {
		return rentabilidad;
	}


	public TipoValor getTipo() {
		return tipo;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Cambia el precio del valor.
	 * @param nuevo precio unitario por valor
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public void setRentabilidad(Rentabilidad rentabilidad) {
		this.rentabilidad = rentabilidad;
	}


	public void setTipo(TipoValor tipo) {
		this.tipo = tipo;
	}
	
	public String getDuenio() 
	{
		return duenio;
	}

	public int compareTo(Valor o) 
	{
		if(nombre.compareTo(o.getNombre())>0)
		{
			return 1;
		}
		else if(nombre.compareTo(o.getNombre())<0)
		{
			return -1;
		}
		else
			return 0;
	}

	public void finalize() throws Throwable {
//..
	}

	
	

}//end Valor