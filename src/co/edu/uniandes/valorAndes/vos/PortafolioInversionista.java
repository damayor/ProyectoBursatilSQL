package co.edu.uniandes.valorAndes.vos;

import java.util.Date;

/**
 * @version 1.0
 * @created 18-sep-2014 01:23:20 p.m.
 */
public class PortafolioInversionista  {

	/**
	 * porcentajes de las acciones que adquirió del portafolio
	 */
	public double[] porcentajes;

	/**
	 * porcentajes de las acciones que adquirió del portafolio
	 */
	public Valor[] valores;

	/**
	 * Portafolio del intermediario el cual adquirió una parte el inversionista
	 */
	private PortafolioIntermediario portafolioOrigen;

	/**
	 * inversionista dueño de este portafolio
	 */
	private Inversionista duenio;




	/**
	 * 
	 * @param nPorcentajes los porcentajes que el inversionista va a adquirir de cada valor que ofrece el portafolio del intermediario
	 * @param portafolioOrigen portafolio del cual va a adquirir el inversionista
	 */
	public PortafolioInversionista(double[] nPorcentajes,  PortafolioIntermediario portafolioOrigen, Inversionista duenio)
	{

		if(nPorcentajes.length!=portafolioOrigen.getCantidadValores())
		{
			System.out.println("La cantidad de porcentajes es diferente a la cantidad de valores.No se puede crear el portafolio");
		}
		else
		{
			this.duenio = duenio;
			this.porcentajes = new double[portafolioOrigen.getCantidadValores()];
			this.valores = new Valor[portafolioOrigen.getCantidadValores()];
			this.portafolioOrigen = portafolioOrigen;

			System.out.println("Hasta ahora bien. Va a comprar los valores");


			for(int i = 0; i<nPorcentajes.length; i++)
			{
				Valor v = this.valores[i];
				double p = porcentajes[i];
				v = portafolioOrigen.getValores().get(i);
				p = nPorcentajes[i];

				comprarValor(v, portafolioOrigen.getCantidad()*p);
			}
		}

	}

	/**
	 * Compra cada vadlor del portafolio que ha sido creado
	 * <b> pre:</b> La cantidad de valores que ofrece el portafolio ya debio haber sido creada. 
	 */
	public void comprarValor(Valor v, double can)
	{

		//oc temp
		//OrdenCompraVenta oc = new OrdenCompraVenta( (int) can, OrdenCompraVenta.COMPRA,  portafolioOrigen.getCreador() , v,null); 
		if(can ==0)
		{
			System.out.println("No se va a comprar nada porque cantidad es 0");
		}
		else
		{
			OperacionBursatil compra = new OperacionBursatil(this, v, (int) can, OrdenCompraVenta.COMPRA);

			duenio.getCompras().add(compra);
		}		

	}


	public double getPorcentaje(int i) 
	{
		return porcentajes[i];
	}

	public Valor getValor(int i)
	{
		return valores[i];
	}


	public PortafolioIntermediario getPortafolioOrigen() {
		return portafolioOrigen;
	}

	public Inversionista getDuenio() {
		return duenio;
	}


	// R13 - Recomponer portafolio

	/**
	 * Cambia los porcentajes que tiene actualmente el portafolio por los nuevos. 
	 * Se encarga de la compra de los nuevos valores y de la venta de los nuevos
	 * @param nuevosPorcentajes
	 */
	public void recomponerPortafolio( double[] nuevosPorcentajes)
	{
		if(nuevosPorcentajes.length!=porcentajes.length)
		{
			System.out.println("La cantidad de porcentajes es diferente a la cantidad de valores.No se puede recomponer el portafolio");
		}
		else
		{
			String pcs =" ";

			for(int i = 0; i<nuevosPorcentajes.length; i++)
			{
				//vender el actual
				Valor v = portafolioOrigen.getValores().get(i);

				venderValor(v, portafolioOrigen.getCantidad()*porcentajes[i]);

				porcentajes[i] = nuevosPorcentajes[i];

				pcs +=nuevosPorcentajes[i]+" ";

				//comprar el nuevo
				comprarValor(v, portafolioOrigen.getCantidad()*nuevosPorcentajes[i]);
			}
			System.out.println("Los porcentajes se han cambiado. Ahora son respectivamente"+pcs);

		}

	}


	private void venderValor(Valor v, double can) 
	{
		//oc temp
		//OrdenCompraVenta oc = new OrdenCompraVenta( (int) can, OrdenCompraVenta.VENTA,  portafolioOrigen.getCreador() , v,null); 

		OperacionBursatil venta = new OperacionBursatil(this, v , (int)can ,OrdenCompraVenta.VENTA);

		duenio.getVentas().add(venta);

	}

	/**
	 * 
	 * @return
	 */

	public int compareTo(PortafolioInversionista o) 
	{
		if(duenio.compareTo(o.getDuenio())>0)
		{
			return 1;
		}
		else if(duenio.compareTo(o.getDuenio())<0)
		{
			return -1;
		}
		else
		{
			if(portafolioOrigen.compareTo(o.getPortafolioOrigen())>0)
			{
				return 1;
			}
			else if(portafolioOrigen.compareTo(o.getPortafolioOrigen())>0)
			{
				return -1;
			}
			else
			{
				return 0;
				/*
			boolean dif = false;
			for(int i=0;i<valores.length && !dif;i++ )
			{
				Valor vact = valores[i];
				double pact = porcentajes[i];
				System.out.println("vact: "+vact+"pact: "+pact);
				if(vact.compareTo(o.getValor(i))>0 || pact>o.getPorcentaje(i) )
				{	
					dif = true;
					return 1;
				}
				if(vact.compareTo(o.getValor(i))<0 || pact<o.getPorcentaje(i) )
				{
					dif = true;
					return -1;
				}
			}
			return 0; //se supone que como retorno los otros ya, solo retorna 0 si si llego al final del for*/
			}
		}

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}//end Inversor