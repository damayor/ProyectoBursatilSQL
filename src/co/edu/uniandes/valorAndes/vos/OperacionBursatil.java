package co.edu.uniandes.valorAndes.vos;

import java.util.Date;
import java.util.Calendar;

/**
 * @author David Ricardo
 * @version 1.0
 * @created 18-sep-2014 01:23:21 p.m.
 */
public class OperacionBursatil {

	public String getVendedorDAO() {
		return vendedorDAO;
	}

	public String getCompradorDAO() {
		return compradorDAO;
	}

	public String getValorDAO() {
		return valorDAO;
	}

	private double cantidad;
	


	private double monto;
	
	/**
	 * Arreglo de 3 enteros que representa la fecha de la orden, siendo el orden  respectivo anio, mes, dia.
	 */
	private int[] fechaNegociacion;
	
	/**
	 * Arreglo de 3 enteros que representa la hora de la orden, siendo el orden respectivo hora, minuto, segundos.
	 */
	private int[] horaNegociacion;
	
	
	public Valor valor;
	public Intermediario vendedor;
	public Intermediario comprador;
	
	//Atributos para facilitar el DAO
		public String vendedorDAO;
		public String compradorDAO;
		public String valorDAO;

	/**
	 * Contructor de Operacion Bursatil. Ya la operacion se ha realizado y no se puede devolver.
	 * @param orden Orden de compra o venta por parte del interesado que publico la orden.
	 * @param usuarioOperacion - representa el otro usuario, quien encontro el anuncio de la orden de compra o venta y quiso realizar la operacion.
	 */
	public OperacionBursatil(OrdenCompraVenta orden, Intermediario usuarioOperacion)
	{
		//es orden de vender o comprar?
		if(orden.getTipo().equals(OrdenCompraVenta.VENTA)) // alguien queria vender sus vainos
		{
			this.vendedor = orden.getIntermediario();
			this.comprador = usuarioOperacion;
			
		}
		else
		{
			this.comprador = orden.getIntermediario();
			this.vendedor = usuarioOperacion;
		}
		
		this.valor = orden.getValorNegociado();
		this.cantidad = orden.getCantidad();
		this.monto = orden.getMonto();
		
		Calendar cal = Calendar.getInstance();		
		int anio = (cal.get(Calendar.YEAR));
		int mes = (	cal.get(Calendar.MONTH));
		int dia = (	cal.get(Calendar.DAY_OF_MONTH));
		int hora = (cal.get(Calendar.HOUR_OF_DAY));
		int mins = (cal.get(Calendar.MINUTE));
		int secs = (cal.get(Calendar.SECOND));
		this.fechaNegociacion = new int[3];
		this.horaNegociacion = new int[3];
		
		fechaNegociacion[0] = anio;
		fechaNegociacion[1] = mes;
		fechaNegociacion[2] = dia;
		
		horaNegociacion[0] = hora;
		horaNegociacion[1] = mins;
		horaNegociacion[2] = secs;
		
		registrarOperacionBursatil(vendedor, comprador);
		
	}
	
	/**
	 * Constructor 4: para contruir facil una operacion bursatil en visualizacion
	 * @param porcentaje porcentaje <= 1
	 * @param venta
	 * @param intermediario
	 * @param valorNegociado
	 * @param fechaExpiracion fecha hasta cuando se acpetan ofertas.
	 */public OperacionBursatil(int Ncantidad,String Ncomprador,double Nmonto,String Nvalor,String Nvendedor)
	 {
		 vendedorDAO=Nvendedor;
		 compradorDAO=Ncomprador;
		 valorDAO=Nvalor;
		 monto=Nmonto;
		 cantidad=Ncantidad;
	 }
	
	@SuppressWarnings("deprecation")
	public Date darFechaNegociacion()
	{
		Date d = new Date(
				fechaNegociacion[0],
				fechaNegociacion[1], 
				fechaNegociacion[2], 
				
				horaNegociacion[0], 
				horaNegociacion[1], 
				horaNegociacion[2] 
				);
		
		return d;
		
	}
	
	
	/**
	 * R10 - Registra la operacion burstail en los cambios de cada usuario, 
	 * @param comprador
	 * @param vendedor
	 */
	public void registrarOperacionBursatil(Intermediario comprador, Intermediario vendedor)
	{
		//Registra las ventas de cada intermediario
		comprador.getCompras().add(this);
		vendedor.getCompras().add(this);
		
		//TODO cuando sean mas de un cliente, le toca buscarlo en los clientes del intermediario.
		comprador.getCliente().getCompras().add(this);
		vendedor.getCliente().getCompras().add(this);
	}
	
	
	/**
	 * R13 compra los valores que se encuentran en el portafolio del inversionista que lo adquirio.
	 * @param portafolio
	 * @param cantidad
	 */
	public OperacionBursatil(PortafolioInversionista portafolio, Valor v, int cValor, String tipo)
	{
		
		
	
		if(tipo.equals(OrdenCompraVenta.VENTA)) // alguien queria vender sus vainos
		{
			this.vendedor = portafolio.getPortafolioOrigen().getCreador();
			this.comprador = null;		}
		else
		{
			this.comprador = portafolio.getPortafolioOrigen().getCreador();
			this.vendedor = null;
		}
		
		
		this.valor = v;
		this.cantidad = cValor;
		this.monto = cValor*v.getPrecio();
		
		Calendar cal = Calendar.getInstance();		
		int anio = (cal.get(Calendar.YEAR));
		int mes = (	cal.get(Calendar.MONTH));
		int dia = (	cal.get(Calendar.DAY_OF_MONTH));
		int hora = (cal.get(Calendar.HOUR_OF_DAY));
		int mins = (cal.get(Calendar.MINUTE));
		int secs = (cal.get(Calendar.SECOND));
		this.fechaNegociacion = new int[3];
		this.horaNegociacion = new int[3];
		
		fechaNegociacion[0] = anio;
		fechaNegociacion[1] = mes;
		fechaNegociacion[2] = dia;
		
		horaNegociacion[0] = hora;
		horaNegociacion[1] = mins;
		horaNegociacion[2] = secs;
		
		if(tipo.equals(OrdenCompraVenta.VENTA)) // alguien queria vender sus vainos
		{
			registrarOperacionVenta(vendedor);
		}
		else
		{
			registrarOperacionCompra(comprador);
		}
		
	
	}
	

	public void registrarOperacionVenta(Intermediario vendedor) {
		vendedor.getVentas().add(this);	
		// TODO eliminar la operacionBursatil
		

	}

	public void registrarOperacionCompra(Intermediario comprador)
	{
		//Registra las ventas de cada intermediario
		comprador.getCompras().add(this);		
	}
	
	
	// Getters And Setters
	
	public double getCantidad() {
		return cantidad;
	}

	public double getMonto() {
		return monto;
	}

	public void finalize() throws Throwable {
		

	}
}//end OperacionBursatil