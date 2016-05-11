package co.edu.uniandes.valorAndes.vos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import co.edu.uniandes.valorAndes.dao.ConsultaDAO;
import co.edu.uniandes.valorAndes.excepciones.ErrorEnConsultaException;

/**
 * @author David Ricardo & Sebastian Castro
 * @version 1.0
 * @created 18-sep-2014 01:23:21 p.m.
 */
public class ValorAndes {

	public final static String ARCHIVO_CONEXION = "/WebContent";

	/**
	 * Instancia única de la clase
	 */
	private static ValorAndes instance;

	private  ArrayList<Usuario> usuarios;

	private  ArrayList<OperacionBursatil> operacionesBursatiles;

	private  ArrayList<OrdenCompraVenta> ordenesCompraVenta;

	public ArrayList<Intermediario> intermediarios;

	private Usuario admin;

	private ConsultaDAO conexion;

	private ArrayList<Valor> valores;

	//Test Case
	private Intermediario u1;

	private Intermediario u2;

	private Inversionista lobo;

	private Oferente ecopetrol;

	private Valor tituloE;

	private Valor accionE;

	public ValorAndes()
	{
		conexion = new ConsultaDAO();

		conexion.inicializar(ARCHIVO_CONEXION);


		usuarios = new ArrayList<Usuario>();
		valores = new ArrayList<Valor>();
		operacionesBursatiles = new ArrayList<OperacionBursatil>();
		ordenesCompraVenta = new ArrayList<OrdenCompraVenta>();
		intermediarios=new ArrayList<Intermediario>();


		//Test
		u1 = new Intermediario("dr.mayorga20@gmail.com", "1912240777","Pedro", "colombiano","Av siempreviva", "8884233","Bogota","cundinamarca","112566","101.222.333.444" );
		u2 = new Intermediario("js.castro125@gmail.com", "1013797634","Sebastian", "colombiano","Autonorte", "2345533","zipaquira","cundinamarca","111166","101.222.333.444");
		lobo = new Inversionista("inversionista22@gmail.com", "19797634","Inversor Perez", "colombiano","Autonorte", "2345334","Bogota","cundinamarca","111166", u1);
		u1.setCliente(lobo);
		//ecopetrol = new Oferente("petroleros1@gmail.com", "51797639","Maria", "colombiano","Av 7a", "5655533","Bogota","cundinamarca","111166",u2);
		u2.setCliente(ecopetrol);

		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(lobo);
		usuarios.add(ecopetrol);

		tituloE = new Valor("ECOT",5000,TipoValor.TITULO_PARTICIPACION,Rentabilidad.DURACION_DEFINIDA, Rentabilidad.COMPORTAMIENTO_FIJO, "ecopetrol");
		accionE = new Valor("ECOA",5000,TipoValor.ACCION,Rentabilidad.DURACION_INDEFINIDA, Rentabilidad.COMPORTAMIENTO_VARIABLE, "ecopetrol");
		valores.add(accionE);
		valores.add(tituloE);

		u1.hacerPortafolio(PortafolioIntermediario.CONSERVADOR, valores);

		System.out.println("hizo el portafolio de U1");

		double[] porc = new double[2];

		porc[0] = 0.4;
		porc[1] = 0.6;

		comprarPortafolio(lobo, u1.getPortafolio(PortafolioIntermediario.CONSERVADOR), porc);

		double[] nporc = new double[2];

		porc[0] = 0.3;
		porc[1] = 0.7;

		PortafolioInversionista p = new PortafolioInversionista(porc, u1.getPortafolio(PortafolioIntermediario.CONSERVADOR), lobo);

		recomponerPortafolio(lobo, p, nporc);
	}




	//Test R8
	//ordenarOperacionBursatilCantidad(OrdenCompraVenta.VENTA,100,ecopetrol.getIntermediario(),accionE);
	//ordenarOperacionBursatilMonto(OrdenCompraVenta.COMPRA,500001,lobo.getIntermediario(),tituloE);



	//Test R9
	//OrdenCompraVenta ordenEcopetrol = new OrdenCompraVenta(100, OrdenCompraVenta.VENTA,ecopetrol.getIntermediario(), accionE, new Date(2014,10,31));
	//try
	//{
	//cancela la orden de accionE
	//cancelarOperacionBursatil(ordenEcopetrol, u2);
	//}
	//catch(Exception e)
	//{
	//System.out.println("Error cogido: "+ e.getMessage());
	//}

	//}

	// -------------------------------------------------
	// Métodos funcionales
	// -------------------------------------------------

	/**
	 * R8 - crea la orden de compra venta
	 * 
	 */
	/**
	 * Sale a negociacion el valor, de acuerdo a la cantidad de valores que se deseen negocia.
	 * @param cantidad de valores que se van a negociar
	 * @param tipoOrden compra o venta? venta = true, compra = false
	 * @param intermediario intermediario de quien va a sacar la orden
	 * @param valorNegociado del cual se va a sacar la orden
	 */

	public void ordenarOperacionBursatilCantidad(PrintWriter pw, String tipoOrden, int cantidad, String logIntermediario, String idValorNegociado, String fechaExp)
	{

		//1. OrdenCompraVenta = new OrdenCompraVenta(...);		
		try
		{
			System.out.println("en ValorAndes");
			Intermediario intermediario = conexion.buscarIntermediario(logIntermediario);

			Valor valorNegociado = conexion.buscarValor(idValorNegociado);

			SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
			Date fecha = null;	
			fecha = sd.parse(fechaExp);

			String fechaOr= sd.format(fecha);
			System.out.println("La fecha transformada queda: " + fecha);;


			OrdenCompraVenta orden = new OrdenCompraVenta(cantidad,tipoOrden,intermediario, valorNegociado, fecha); 
			///////System.out.println("Sale a la venta el valor "+orden.getValorNegociado().getNombre()+"");
			valorNegociado.aumentarOrdenes();

			ordenesCompraVenta.add(orden);


		}
		catch(ErrorEnConsultaException e)
		{
			e.getMessage();

		}
		catch(ParseException f)
		{
			f.getMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pw.println("<div class=\"well\">");
		pw.println("	<div class=\"span1 pull-Left\">");
		pw.println("	</div>");
		pw.println("	<t><dd><p> Se ha insertado una nueva Orden</dd></p></t>");
		pw.println("</div>");
	}


	/**
	 * Sale a negociacion el valor, de acuerdo a la cantidad de dinero que se deseen negocia.
	 * @param tipoOrden compra o venta? venta = true, compra = false
	 * @param intermediario intermediario de quien va a sacar la orden
	 * @param valorNegociado del cual se va a sacar la orden
	 * @param monto que se va a negociar
	 * @param fechaExp string del tipo yyyy-MM-dd
	 */
	public void ordenarOperacionBursatilMonto(PrintWriter pw,String ventaOCompra, double monto, String logIntermediario, String idValorNegociado, String fechaExp)
	{
		System.out.println("en ValorAndes");

		try
		{
			System.out.println("en el try");

			Intermediario intermediario = conexion.buscarIntermediario(logIntermediario);

			Valor valorNegociado = conexion.buscarValor(idValorNegociado);

			//SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
			//Date fecha = null;	
			//fecha = sd.parse(fechaExp);

			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha = null;	
			fecha = sd.parse(fechaExp);

			String fechaOr= sd.format(fecha);
			System.out.println("La fecha transformada queda: " + fechaOr);;


			OrdenCompraVenta orden = new OrdenCompraVenta(monto,ventaOCompra,intermediario, valorNegociado, fecha);//new Date(2014,10,31)); 

			valorNegociado.aumentarOrdenes();

			System.out.println("llamando a conexion");
			conexion.agregarOrden(orden);

			ordenesCompraVenta.add(orden);

		}
		catch(ErrorEnConsultaException e)
		{
			e.printStackTrace();

		}
		catch(ParseException f)
		{
			f.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pw.println("<div class=\"well\">");
		pw.println("	<div class=\"span1 pull-Left\">");
		pw.println("	</div>");
		pw.println("	<t><dd><p> Se ha insertado una nueva Orden</dd></p></t>");
		pw.println("</div>");
	}

	/**
	 * R9 - cancela la operacion y como todavia no se habia registrado ninguna compra la coherencia sigue intacta.
	 * @param orden
	 * @throws Exception 
	 */
	public void cancelarOperacionBursatil(PrintWriter pw,String ventaOCompra, double monto, String logIntermediario, String idValorNegociado, String fechaExp)
	{
		System.out.println("en ValorAndes");

		try
		{
			System.out.println("en el try");

			Intermediario intermediario = conexion.buscarIntermediario(logIntermediario);

			Valor valorNegociado = conexion.buscarValor(idValorNegociado);

			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha = null;	
			fecha = sd.parse(fechaExp);

			String fechaOr= sd.format(fecha);
			System.out.println("La fecha transformada queda: " + fechaOr);;


			OrdenCompraVenta orden = new OrdenCompraVenta(monto,ventaOCompra,intermediario, valorNegociado, fecha);//new Date(2014,10,31)); 

			System.out.println("llamando a conexion");
			conexion.eliminarOrden(orden);


		}
		catch(ErrorEnConsultaException e)
		{
			e.printStackTrace();

		}
		catch(ParseException f)
		{
			f.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pw.println("<div class=\"well\">");
		pw.println("	<div class=\"span1 pull-Left\">");
		pw.println("	</div>");
		pw.println("	<t><dd><p> Se ha eliminado la Orden</dd></p></t>");
		pw.println("</div>");
	}

	/**
	 * Elimina la orden de compra ya sea porque se cancelo o porque se hizo volvio una operacion realizada.
	 * @param orden
	 */
	private void eliminarOrden(OrdenCompraVenta orden) throws Exception
	{
		Iterator<OrdenCompraVenta> i = ordenesCompraVenta.iterator();
		boolean found = false;
		while(i.hasNext() && !found)
		{
			OrdenCompraVenta o = i.next();
			if(o.compareTo(orden)==0)
			{
				ordenesCompraVenta.remove(o);
				found = true;
				////////System.out.println("se elimina la orden del arreglo" +orden.getValorNegociado().getNombre());
			}
		}
		if(found !=true)
		{
			System.out.println("No encontro la orden, pero deberia estar");
			throw new Exception("No encontro la orden, pero deberia estar");

		}

	}


	/**
	 *R10 - La orden de compra se vuelve una operacion bursatil y se le registra a los cuatros usuarios que hicieron parte de la misma.
	 * @param orden
	 * @param otroUsuario
	 */
	public void registrarOperacionBursatil(OrdenCompraVenta orden, Intermediario otroUsuario) throws Exception
	{
		//otro usuario de servlets
		//saca la orden de la BD 

		//la elimina de la bd

		eliminarOrden(orden);
		//disminuye las operDe el Valor
		orden.getValorNegociado().disminuirOrdenes();

		OperacionBursatil oper = new OperacionBursatil(orden, otroUsuario);
		//y la guarda en la BD de operacionesBursatiles
		operacionesBursatiles.add(oper);

		//update 4 usuarios que tienen q ver con la operacion

		if(orden.getTipo().equals(OrdenCompraVenta.VENTA))
		{
			orden.getIntermediario().getVentas().add(oper);
			orden.getIntermediario().getCliente().getVentas().add(oper);

			otroUsuario.getCompras().add(oper);
			otroUsuario.getCliente().getCompras().add(oper);

		}
		else if(orden.getTipo().equals(OrdenCompraVenta.COMPRA))
		{
			orden.getIntermediario().getCompras().add(oper);
			orden.getIntermediario().getCliente().getCompras().add(oper);

			otroUsuario.getVentas().add(oper);
			otroUsuario.getCliente().getVentas().add(oper);

		}

		//cerrar conexion
	}

	/**
	 *R12 - Se crea un portafolio a partir del que ofrece un itermediario .
	 * @param orden
	 * @param otroUsuario
	 */
	public void comprarPortafolio(Inversionista inver, PortafolioIntermediario port, double[] porcentajes)
	{
		inver.crearPortafolio(port, porcentajes);

	}

	/**
	 * Recompone el portafolio del inversionista con los nuevos porcentajes que le llegan por parametro.
	 * @param inver Inversionista dueño del portafolio
	 * @param port portafolio a ser recompuesto
	 * @param porcentajes nuevos porcentajes de los valores ofrecidos
	 */
	public void recomponerPortafolio(Inversionista inver, PortafolioInversionista port, double[] porcentajes)
	{
		if(inver.buscarPortafolio(port)!=null)
		{
			System.out.println("Si lo encontro");
			port.recomponerPortafolio(porcentajes);
		}
		else
			System.out.println("No se ha encontrado el portafolio que deberia tener el inversionista");
	}







	// -------------------------------------------------
	// Métodos de consulta
	// -------------------------------------------------



	public void darExistenciaValores(PrintWriter pw,String valor,String tipoValor,String rentabi, boolean neg, String exp, String ofer,String inter,String inver)
	{

		String ans="";

		try 
		{
			if(!valor.equals(""))
			{
				Valor temp=conexion.buscarValor(valor);
				ans+="<dd><p>";
				ans+="Nombre del valor: "+temp.getNombre()+" " ;
				ans+="Precio: "+temp.getPrecio()+" ";
				ans+="</dd></p>";	
			}

			else if(!tipoValor.equals(""))
			{
				ArrayList<Valor> valores= conexion.buscarValorTipo(tipoValor);
			}
		} 

		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pw.println("<div class=\"well\">");
		pw.println("	<div class=\"span1 pull-Left\">");
		pw.println("	</div>");
		pw.println("	<t>" + ans +  "</t>");
		pw.println("</div>");
	}


	public void darOperacionesUsuario( PrintWriter pw, String tipoUsuario, String tipoOpe, String fechaI, String fechaF, double costo )
	{
		String resp = "";

		try {
			resp= conexion.darOperacionesUsuario(tipoUsuario,tipoOpe,fechaI,fechaF,costo);
		} catch (ErrorEnConsultaException e) 
		{
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pw.println("<div class=\"well\">");
		pw.println("	<div class=\"span1 pull-Left\">");
		pw.println("	</div>");
		pw.println("	<t>" + resp +  "</t>");
		pw.println("</div>");
	}

	public void darValores1(String valorId,PrintWriter salida)
	{
		String imp="";

		try {
			imp=conexion.consultarValores2(valorId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		if(imp.equals(""))
		{
			salida.println("<div class=\"well\">");
			salida.println("	<div class=\"span1 pull-Left\">");
			salida.println("	</div>");
			salida.println("	<t>No hay informacion del Valor.(</t>");
			salida.println("</div>");
		}
		else
		{
			salida.println("<div class=\"well\">");
			salida.println("	<div class=\"span1 pull-Left\">");
			salida.println("	</div>");
			salida.println("	<t>" + imp +  "</t>");
			salida.println("</div>");
		}
	}
	public void darPortofolios(String tipoValor, String numero,PrintWriter salida)
	{
		String imp="";
		int mayorA= Integer.parseInt(numero);
		try {
			imp=conexion.consultaPortafolios(tipoValor, mayorA);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		if(imp.equals(""))
		{
			salida.println("<div class=\"well\">");
			salida.println("	<div class=\"span1 pull-Left\">");
			salida.println("	</div>");
			salida.println("	<t>No hay informacion del Portafolio.</t>");
			salida.println("</div>");
		}
		else
		{
			salida.println("<div class=\"well\">");
			salida.println("	<div class=\"span1 pull-Left\">");
			salida.println("	</div>");
			salida.println("	<t>" + imp +  "</t>");
			salida.println("</div>");
		}
	}

	/* RFC8 Mostrar los movimientos de valores realizados en un rango de tiempo (dado por el usuario),
	 * que correspondan a un criterio de búsqueda asociado con el movimiento (valor, tipo de valor,
	 * tipo de rentabilidad, intermediario, oferente, …), también dado por el usuario.
	 */
	
	public void consultarMovimientosConCriterio(PrintWriter pw, String criterio, String tipoBusqueda, String fechaIni, String fechaFin)
	{
		try
		{
			String res = conexion.consultarMovimientosValoresConCriterio(fechaIni, fechaFin, criterio, tipoBusqueda);
			pw.println("<pp><b> Movimientos con "+tipoBusqueda+": "+criterio+" entre "+fechaIni+" y "+fechaFin+"  </dd></b><p></p>" +res);
		}	
		catch(Exception e)
		{
			pw.println("<pp><dd> No se ha podido realizar la consulta</dd></p>");
			e.printStackTrace();
		}
	}
	
	public void consultarMovimientosSinCriterio(PrintWriter pw, String criterio, String tipoBusqueda, String fechaIni, String fechaFin)
	{
		try
		{
			String res = conexion.consultarMovimientosValoresSinCriterio(fechaIni, fechaFin, criterio, tipoBusqueda);
			pw.println("<pp><b> Movimientos con "+tipoBusqueda+": "+criterio+" entre "+fechaIni+" y "+fechaFin+"  </dd></b><p></p>" +res);
		}	
		catch(Exception e)
		{
			pw.println("<pp><dd> No se ha podido realizar la consulta</dd></p>");
			e.printStackTrace();
		}
	}
	
	/* RFC9 Mostrar los movimientos de valores realizados en un rango de tiempo (dado por el usuario),
	 * que NO correspondan a un criterio de búsqueda asociado con el movimiento (valor, tipo de valor,
	 * tipo de rentabilidad, intermediario, oferente, …), también dado por el usuario.
	 */
	
	public void consultarMovimientosSinCriterio(PrintWriter pw, String criterio, String tipoBusqueda)
	{
		
	}



	// -------------------------------------------------
	// Metodos de Visualizacion
	// -------------------------------------------------

	public void darOferentes(PrintWriter salida) 
	{
		ArrayList<Oferente> resp = new ArrayList<Oferente>();

		//long time_start, time_end;
		//time_start = System.currentTimeMillis();
		try 
		{
			resp=conexion.darTodosOferentes();
		} 
		catch (ErrorEnConsultaException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//time_end = System.currentTimeMillis();
		//System.out.println("the task has taken "+ ( time_end - time_start )/ 1000 +"seconds");

		if(resp.size()==0)
		{
			salida.println("<div class=\"well\">");
			salida.println("	<div class=\"span1 pull-Left\">");
			salida.println("	</div>");
			salida.println("	<t>No hay Oferentes registrados :(</t>");
			salida.println("</div>");
		}

		else
		{
			salida.println("<div class=\"well\">");
			salida.println("<div class=\"span1 pull-Left\">");
			//pw.println("	</div>");

			String respEscrita = "";
			for (int i = 0; i < resp.size(); i++) 
			{

				Oferente act = resp.get(i);
				String keep="";
				String opb="";

				//imprimir los nombres de las operaciones bursatiles
				ArrayList<OperacionBursatil> op=act.getVentas();
				for (int j = 0; j < op.size(); j++) 
				{
					OperacionBursatil actl=op.get(j);
					int pos=j+1;
					opb+="<p><dd>Operacion Numero: "+pos+"; Login Vendedor: "+actl.getVendedorDAO()+"; Login Comprador: "+actl.getCompradorDAO()+"; Valor: "+actl.getValorDAO()+"; Cantidad: "+actl.getCantidad()+"; Monto: "+actl.getMonto()+"</dd></p>";
				}

				//imprimir los nombres de los valores
				ArrayList<Valor> valores=act.getTiposValores();
				for (int j = 0; j < valores.size(); j++) 
				{
					Valor actl=valores.get(j);

					keep+="<p><dd>Nombre del Valor: "+actl.getNombre()+"; Precio en la volsa: "+actl.getPrecio() +"; Tipo :"+actl.getTipo().getNombreTipo()+"</dd></p>";

				}

				respEscrita+="<p><dd> Nombre: "+act.getNombre()+"</dd></p>";
				respEscrita+="<p><dd> Login: "+act.getCorreo()+"</dd></p>";
				respEscrita+="<p><dd> Documento: "+act.getDocumentoId()+"</dd></p>";
				respEscrita+="<p><dd> Operaciones Bursatiles: "+opb+"</dd></p>";
				respEscrita+="<p><dd> El oferente tiene los siguientes Valores en la bolsa: "+keep+"</dd></p>";

				keep="";
				opb="";
				respEscrita+=" <br>";
				//respEscrita+="<p><dd> </dd></p>";
			}


			salida.println("	<t>" + respEscrita +  "</t>");
			salida.println("</div>");

		}

	}
	


	public void darInversionistas(PrintWriter salida) 
	{

		ArrayList<Inversionista> resp = new ArrayList<Inversionista>();

		//long time_start, time_end;
		//time_start = System.currentTimeMillis();
		try {
			resp=conexion.darTodosInversionistas();
		} catch (ErrorEnConsultaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//time_end = System.currentTimeMillis();
		//System.out.println("the task has taken "+ ( time_end - time_start )/ 1000 +"seconds");

		if(resp.size()==0)
		{
			salida.println("<div class=\"well\">");
			salida.println("	<div class=\"span1 pull-Left\">");
			salida.println("	</div>");
			salida.println("	<t>No hay Oferentes registrados :(</t>");
			salida.println("</div>");
		}

		else
		{
			salida.println("<div class=\"well\">");
			salida.println("<div class=\"span1 pull-Left\">");
			//pw.println("	</div>");

			String respEscrita = "";
			for (int i = 0; i < resp.size(); i++) {

				Inversionista act = resp.get(i);
				String opb="";
				String port="";

				ArrayList<PortafolioFalso> portafolios=new ArrayList();
				try 
				{
					portafolios=conexion.darPortafolio(act.getCorreo());
					//System.out.println(portafolios.size());
				} 
				catch (ErrorEnConsultaException e) 
				{
					e.printStackTrace();
				}
				ArrayList<PortafolioFalso> conservador=new ArrayList<PortafolioFalso>();
				ArrayList<PortafolioFalso> agresivo=new ArrayList<PortafolioFalso>();
				ArrayList<PortafolioFalso> moderado=new ArrayList<PortafolioFalso>();

				for(int j=0;j<portafolios.size();j++)
				{
					PortafolioFalso actl=portafolios.get(j);
					if(actl.getTipo().equals("CONSERVADOR"))
						conservador.add(actl);
					else if(actl.getTipo().equals("AGRESIVO"))
						agresivo.add(actl);
					else
						moderado.add(actl);
				}

				//imprimir los portafolios agresivos
				port+="<p><dd> En portafolios agresivos el Inversionista tiene: </dd></p>";
				if(agresivo.isEmpty())
				{
					port+="<p><dd> No tiene registros </p></dd>";
				}
				else
				{
					for (int j = 0; j < agresivo.size(); j++) 
					{
						PortafolioFalso actl=agresivo.get(j);
						int pos=j+1;
						port+="<p><dd>Valor Numero: "+pos+"; Nombre Valor: "+actl.getValor()+"; Porcentaje: "+actl.getPorcentaje()+"; Intermediario : "+actl.getLogDuenio()+"</dd></p>";
					}
				}

				//moderados
				port+="<p><dd> En portafolios moderados el Inversionista tiene: </dd></p>";
				if(moderado.isEmpty())
				{
					port+="<p><dd> No tiene registros </p></dd>";
				}
				else
				{
					for (int j = 0; j < moderado.size(); j++) 
					{
						PortafolioFalso actl=moderado.get(j);
						int pos=j+1;
						port+="<p><dd>Valor Numero: "+pos+"; Nombre Valor: "+actl.getValor()+"; Porcentaje: "+actl.getPorcentaje()+"; Intermediario : "+actl.getLogDuenio()+"</dd></p>";
					}
				}
				//conservadores
				port+="<p><dd> En portafolios conservadores el Inversionista tiene: </dd></p>";
				if(conservador.isEmpty())
				{
					port+="<p><dd> No tiene registros </p></dd>";
				}
				else
				{
					for (int j = 0; j < conservador.size(); j++) 
					{
						PortafolioFalso actl=conservador.get(j);
						int pos=j+1;
						port+="<p><dd>Valor Numero: "+pos+"; Nombre Valor: "+actl.getValor()+"; Porcentaje: "+actl.getPorcentaje()+"; Intermediario : "+actl.getLogDuenio()+"</dd></p>";
					}
				}


				//imprimir los nombres de las operaciones bursatiles
				ArrayList<OperacionBursatil> op=act.getVentas();
				for (int j = 0; j < op.size(); j++) 
				{
					OperacionBursatil actl=op.get(j);
					int pos=j+1;
					opb+="<p><dd>Operacion Numero: "+pos+"; Login Vendedor: "+actl.getVendedorDAO()+"; Login Comprador: "+actl.getCompradorDAO()+"; Valor: "+actl.getValorDAO()+"; Cantidad: "+actl.getCantidad()+"; Monto: "+actl.getMonto()+"</dd></p>";
				}



				respEscrita+="<p><dd> Nombre: "+act.getNombre()+"</dd></p>";
				respEscrita+="<p><dd> Login: "+act.getCorreo()+"</dd></p>";
				respEscrita+="<p><dd> Documento: "+act.getDocumentoId()+"</dd></p>";
				respEscrita+="<p><dd> Operaciones Bursatiles: "+opb+"</dd></p>";
				respEscrita+="<p><dd> Portafolios: "+port+"</dd></p>";

				respEscrita+=" <br>";
				opb="";
				port="";
				//respEscrita+="<p><dd> </dd></p>";
			}


			salida.println("	<t>" + respEscrita +  "</t>");
			salida.println("</div>");

		}

	}

	public void darIntermediarios(PrintWriter salida) 
	{
		//ArrayList<Intermediario> resp = new ArrayList<Intermediario>();

		//long time_start, time_end;
		//time_start = System.currentTimeMillis();
		try 
		{
			intermediarios=conexion.darTodosIntermediarios();
		} 
		catch (ErrorEnConsultaException e) 
		{
			e.printStackTrace();
		}
		//time_end = System.currentTimeMillis();
		//System.out.println("the task has taken "+ ( time_end - time_start )/ 1000 +"seconds");

		if(intermediarios.size()==0)
		{
			salida.println("<div class=\"well\">");
			salida.println("	<div class=\"span1 pull-Left\">");
			salida.println("	</div>");
			salida.println("	<t>No hay Oferentes registrados :(</t>");
			salida.println("</div>");
		}

		else
		{
			salida.println("<div class=\"well\">");
			salida.println("<div class=\"span1 pull-Left\">");
			//pw.println("	</div>");

			String respEscrita = "";
			//System.out.println(intermediarios.size());
			for (int i = 0; i < intermediarios.size(); i++) 
			{

				Intermediario act = intermediarios.get(i);
				String opb="";
				String portafolios="<p><dd> En el portafolio Agresivo ofrece los siguientes valores: </dd></p>";
				///**
				//imprimir los nombres de los portafolios y valores
				ArrayList<String> agre=act.getPortafolio(PortafolioIntermediario.AGRESIVO).getNombreValores();
				//System.out.println(agre.size());
				for(int j=0;j<agre.size();j++)
				{
					String nval=agre.get(j);
					portafolios+="<p><dd> Valor numero: "+(j+1)+"; Nombre del Valor: "+nval+"</dd></p>";
				}
				ArrayList<String> mode=act.getPortafolio(PortafolioIntermediario.MODERADO).getNombreValores();
				//System.out.println(mode.size());
				portafolios+="<p><dd> En el portafolio Moderado ofrece los siguientes valores: </dd></p>";
				for(int j=0;j<mode.size();j++)
				{
					String nval=mode.get(j);
					portafolios+="<p><dd> Valor numero: "+(j+1)+"; Nombre del Valor: "+nval+"</dd></p>";
				}
				ArrayList<String> cons=act.getPortafolio(PortafolioIntermediario.CONSERVADOR).getNombreValores();
				//System.out.println(cons.size());
				portafolios+="<p><dd> En el portafolio Conservador ofrece los siguientes valores: </dd></p>";
				for(int j=0;j<cons.size();j++)
				{
					String nval=cons.get(j);
					portafolios+="<p><dd> Valor numero: "+(j+1)+"; Nombre del Valor: "+nval+"</dd></p>";
				}
				//*/

				//imprimir los nombres de las operaciones bursatiles
				ArrayList<OperacionBursatil> op=act.getVentas();
				if(op.isEmpty())
				{
					opb+="<p><dd> No tiene Operaciones Bursatiles registradas</dd></p>";
				}
				else
				{
					for (int j = 0; j < op.size(); j++) 
					{
						OperacionBursatil actl=op.get(j);
						int pos=j+1;
						opb+="<p><dd>Operacion Numero: "+pos+"; Login Vendedor: "+actl.getVendedorDAO()+"; Login Comprador: "+actl.getCompradorDAO()+"; Valor: "+actl.getValorDAO()+"; Cantidad: "+actl.getCantidad()+"; Monto: "+actl.getMonto()+"</dd></p>";
					}
				}
				respEscrita+="<p><dd> Nombre: "+act.getNombre()+"</dd></p>";
				respEscrita+="<p><dd> Login: "+act.getCorreo()+"</dd></p>";
				respEscrita+="<p><dd> Documento: "+act.getDocumentoId()+"</dd></p>";
				respEscrita+="<p><dd> Operaciones Bursatiles: "+opb+"</dd></p>";
				respEscrita+="<p><dd> Portafolios: "+portafolios+"</dd></p>";

				respEscrita+=" <br>";
				portafolios="";
				opb="";
				//respEscrita+="<p><dd> </dd></p>";
			}


			salida.println("	<t>" + respEscrita +  "</t>");
			salida.println("</div>");

		}

	}


	public void retirarIntermediario(PrintWriter pw, String login)
	{
		try 
		{
			String resp=conexion.retirarIntermediario(login);
			pw.println("<pp><dd> Se ha eliminado el Intermediario y sus responsabilidades se han asignado a: "+resp+"</dd></p>");
		} 
		catch (Exception e) 
		{
			pw.println("<pp><dd> No se ha podido eliminar el Intermediario</dd></p>");
			e.printStackTrace();
		}
	}

	// -------------------------------------------------
	// TEST
	// -------------------------------------------------

	public void cerrarConexion()
	{
		//TODO mirar cabandes
	}

	public ArrayList<Usuario> getUsuarios()
	{
		return usuarios;
	}

	public ArrayList<OperacionBursatil> getOperacionesBursatiles()
	{
		return operacionesBursatiles;
	}

	public ArrayList<OrdenCompraVenta> getOrdenesCompraVenta()
	{
		return ordenesCompraVenta;
	}

	/**
	 * @return the valores
	 */
	public ArrayList<Valor> getValores() 
	{
		return valores;
	}


	/**
	 * @param valores the valores to set
	 */
	public void setValores(ArrayList<Valor> valores) 
	{
		this.valores = valores;
	}

	public static void main(String[] args) 
	{
		ValorAndes v = new ValorAndes();
		System.out.println("Se inicializó el programa ");		
	}

	public static ValorAndes darInstancia() throws IOException
	{
		//System.out.println("generando instancia");
		if(instance != null)
		{
			return instance;
		}
		else{
			instance = new ValorAndes();
			return instance;
		}
	}



	public void finalize() throws Throwable 
	{
		//............
	}



}//end ValorAndes