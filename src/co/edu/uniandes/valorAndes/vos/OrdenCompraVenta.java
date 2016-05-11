package co.edu.uniandes.valorAndes.vos;

import java.util.Calendar;
import java.util.Date;

/**
 * Clase que representa el interes de un usuario de comprar y vender valores. Una vez construido no se pueden cambiar
 * sus valores. Dado el cado, se debe cancelar la operacion y crear una nueva.
 * @author David Ricardo
 * @version 1.0
 * @created 18-sep-2014 01:23:21 p.m.
 */
public class OrdenCompraVenta implements Comparable<OrdenCompraVenta>
{

	public final static String VENTA = "Venta";
	
	public final static String COMPRA = "Compra";
	
	/**
	 * indica si lo quiere comprar o vender. True indica si alguien quiere vender sus acciones; caso mas comun.
	 * false indica si alguien esta interesado de comprar.
	 */
	private String tipo;
	
	/**
	 * precio del valor que va a negociarse.
	 */
	private double monto;
	
	/**
	 *  cantidad de valores que van a ser negociados. 
	 *  Si es menor a cero se va a negociar un porcentaje de los valores que tenga el usuario. 
	 */
	private double cantidad;
	
	/**
	 * Arreglo de 3 enteros que representa la fecha de la orden, siendo el orden  respectivo anio, mes, dia.
	 */
	private int[] fechaOrden;
	
	/**
	 * Arreglo de 3 enteros que representa la hora de la orden, siendo el orden respectivo hora, minuto, segundos.
	 */
	private int[] horaOrden;
	
	/**
	 * Fecha hasta cuando se va a negociar dicha orden.
	 */
	private Date fechaExpiracion;
	
	private Intermediario intermediario;
	
	private Valor valorNegociado;


	/**
	 * Constructor 1: para el caso en que va a comprar un monto fijo de valores. 
	 * @param monto de dinero que se quiere invertir en la orden
	 * @param venta true es sale a la venta, false si lo desea comprar
	 * @param intermediario intermediario del cliente que desea sacar la orden
	 * @param valorNegociado Valor del que se va a realizar a la operacion
	 * @param fechaExpiracion fecha hasta cuando se acpetan ofertas.
	 */
	public OrdenCompraVenta(double monto, String ventaOCompra,  Intermediario intermediario, Valor valorNegociado,Date fechaExpiracion) 
	{
		
		inicializarAtributos( ventaOCompra,   intermediario,  valorNegociado, fechaExpiracion);
		
		//Vende un porcentaje de valores o un precio o una cantidad de acciones
		//negocia por medio del precio
		
		this.monto = monto;
		this.cantidad = monto/valorNegociado.getPrecio();
		
	}
	
	/**
	 * Constructor 2: para el caso en que va a comprar una cantidad fija de valores.
	 * @param cantidad de acciones que va comprar
	 * @param venta true es sale a la venta, false si lo desea comprar
	 * @param intermediario intermediario del cliente que desea sacar la orden
	 * @param valorNegociado Valor del que se va a realizar a la operacion
	 * @param fechaExpiracion fecha hasta cuando se acpetan ofertas.
	 */
	public OrdenCompraVenta(int cantidad, String ventaOCompra,  Intermediario intermediario, Valor valorNegociado,Date fechaExpiracion) 
	{
		inicializarAtributos( ventaOCompra,   intermediario,  valorNegociado,  fechaExpiracion);
		this.cantidad =(cantidad);
		this.monto = cantidad*valorNegociado.getPrecio();

		
	}
	
	
	/**
	 * Constructor 3: para el caso en que va a comprar una porcentaje de las acciones que posee
	 * @param porcentaje porcentaje <= 1
	 * @param venta
	 * @param intermediario
	 * @param valorNegociado
	 * @param fechaExpiracion fecha hasta cuando se acpetan ofertas.
	 */
	public OrdenCompraVenta(long porcentaje, String ventaOCompra,  Intermediario intermediario, Valor valorNegociado, Date fechaExpiracion) 
	{
		//inicializarAtributos( ventaOCompra,   intermediario,  valorNegociado, fechaExpiracion);
		
		//TODO buscar cuantos valores tiene un usuario de una compañia, de ahí sacar el porcentaje.
		/**double cantidad = valorNegociado.buscarEnUsuario
		
		this.cantidad = 
		this.monto = 
		*/
		
	}
	
	private void inicializarAtributos(String ventaOCompra,  Intermediario intermediario, Valor valorNegociado, Date fechaExpiracion)
	{
		this.tipo = ventaOCompra;		
		this.intermediario = intermediario;
		this.valorNegociado = valorNegociado;
		//valorNegociado.aumentarOrdenes();

		
		Calendar cal = Calendar.getInstance();		
		int anio = (cal.get(Calendar.YEAR));
		int mes = (	cal.get(Calendar.MONTH));
		int dia = (	cal.get(Calendar.DAY_OF_MONTH));
		int hora = (cal.get(Calendar.HOUR_OF_DAY));
		int mins = (cal.get(Calendar.MINUTE));
		int secs = (cal.get(Calendar.SECOND));
		this.fechaOrden = new int[3];
		this.horaOrden = new int[3];
		
		fechaOrden[0] = anio;
		fechaOrden[1] = mes;
		fechaOrden[2] = dia;
		
		horaOrden[0] = hora;
		horaOrden[1] = mins;
		horaOrden[2] = secs;
		
		this.fechaExpiracion = fechaExpiracion;
		
		
	}
	
	@SuppressWarnings("deprecation")
	public Date darFechaOrden()
	{
		Date d = new Date(
				fechaOrden[0],
				fechaOrden[1], 
				fechaOrden[2], 
				
				horaOrden[0], 
				horaOrden[1], 
				horaOrden[2] 
				);
		
		return d;
		
	}
	
	public int[] getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(int[] fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public int[] getHoraOrden() {
		return horaOrden;
	}

	public void setHoraOrden(int[] horaOrden) {
		this.horaOrden = horaOrden;
	}

	public String getTipo() {
		return tipo;
	}

	public double getMonto() {
		return monto;
	}

	public double getCantidad() {
		return cantidad;
	}

	
	public Intermediario getIntermediario() {
		return intermediario;
	}

	public Valor getValorNegociado() {
		return valorNegociado;
	}
	
	/**
	 * @return the fechaExpiracion
	 */
	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	/**
	 * @param fechaExpiracion the fechaExpiracion to set
	 */
	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}
	
	public int compareTo(OrdenCompraVenta o) 
	{
		if(valorNegociado.compareTo(o.getValorNegociado())>0)
		{
			return 1;
		}
		else if(valorNegociado.compareTo(o.getValorNegociado())<0)
		{
			return -1;
		}
		else
		{
			if(fechaExpiracion.compareTo(o.getFechaExpiracion())>0)
			{
				return 1;
			}
			else if(fechaExpiracion.compareTo(o.getFechaExpiracion())<0)
			{
				return -1;
			}
			else
				return 0; //Yo digo que aun asi toca compararlo con mas vainas cuando haya 100k de valores
		}
	}

	
	
	public void finalize() throws Throwable {

	}

	
}//end OrdenCompraVenta