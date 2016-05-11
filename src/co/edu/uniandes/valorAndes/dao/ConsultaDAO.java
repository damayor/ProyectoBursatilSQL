/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 
 * Ejercicio: ValorAndes
 * Autor: David Ricardo Mayorga - 13-Septiembre-2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package co.edu.uniandes.valorAndes.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;







































































import co.edu.uniandes.valorAndes.excepciones.ErrorEnConsultaException;
import co.edu.uniandes.valorAndes.vos.Intermediario;
import co.edu.uniandes.valorAndes.vos.Inversionista;
import co.edu.uniandes.valorAndes.vos.Oferente;
import co.edu.uniandes.valorAndes.vos.OperacionBursatil;
import co.edu.uniandes.valorAndes.vos.OrdenCompraVenta;
import co.edu.uniandes.valorAndes.vos.PortafolioFalso;
import co.edu.uniandes.valorAndes.vos.PortafolioIntermediario;
import co.edu.uniandes.valorAndes.vos.PortafolioInversionista;
import co.edu.uniandes.valorAndes.vos.Rentabilidad;
import co.edu.uniandes.valorAndes.vos.Usuario;
import co.edu.uniandes.valorAndes.vos.Valor;
import co.edu.uniandes.valorAndes.vos.VideosValue;

/**
 * Clase ConsultaDAO, encargada de hacer las consultas básicas para el cliente
 */
public class ConsultaDAO 
{

	//----------------------------------------------------
	//Constantes
	//----------------------------------------------------
	private static final String ARCHIVO_CONEXION ="/conexion.properties";

	public static final String CONSERVADOR = "Rentabilidad Fija";

	public static final String MODERADO = "Rentabilidad Fija indefinida";

	public static final String AGRESIVO = "Agresivo Variable";

	//----------------------------------------------------
	//Consultas
	//----------------------------------------------------



	//----------------------------------------------------
	//Atributos
	//----------------------------------------------------
	/**
	 * conexion con la base de datos
	 */
	public Connection conexion;

	/**
	 * nombre del usuario para conectarse a la base de datos.
	 */
	private String usuario;

	/**
	 * clave de conexión a la base de datos.
	 */
	private String clave;

	/**
	 * ulr de conexion para conectarse a la base de datos.
	 */
	private String url;

	/**
	 * URL al cual se debe conectar para acceder a la base de datos.
	 */
	private String cadenaConexion;


	/**
	 * constructor de la clase. No inicializa ningun atributo.
	 */
	public ConsultaDAO() 
	{		

	}

	// -------------------------------------------------
	// Métodos
	// -------------------------------------------------

	/**
	 * obtiene ls datos necesarios para establecer una conexion
	 * Los datos se obtienen a partir de un archivo properties.
	 * @param path ruta donde se encuentra el archivo properties.
	 */
	public void inicializar(String path)
	{
		try
		{


			//System.out.println("Inicializando");
			url = "jdbc:oracle:thin:@157.253.238.224:1531:prod";
			usuario = "isis2304091420";
			clave = "guiparasdc1f6";
			final String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);

			//System.out.println("Inicializado");


			/**
			File arch= new File(path+ARCHIVO_CONEXION);
			System.out.println("El archivo es :"+path+ARCHIVO_CONEXION);
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream( arch );

	        prop.load( in );
	        in.close( );

			cadenaConexion = prop.getProperty("url");	// El url, el usuario y passwd deben estar en un archivo de propiedades.
												// url: "jdbc:oracle:thin:@chie.uniandes.edu.co:1521:chie10";
			usuario = prop.getProperty("usuario");	// "s2501aXX";
			clave = prop.getProperty("clave");	// "c2501XX";
			final String driver = prop.getProperty("driver");
			Class.forName(driver);
			 */

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	/**
	 * Método que se encarga de crear la conexión con el Driver Manager
	 * a partir de los parametros recibidos.
	 * @param url direccion url de la base de datos a la cual se desea conectar
	 * @param usuario nombre del usuario que se va a conectar a la base de datos
	 * @param clave clave de acceso a la base de datos
	 * @throws SQLException si ocurre un error generando la conexión con la base de datos.
	 */
	private void establecerConexion(String url, String usuario, String clave) throws SQLException
	{
		//System.out.println("Estableciendo conexion");
		try
		{
			//System.out.println("el URL es :"+url+" el Usuarios es: "+"usuario"+ "la clave es: "+clave);
			conexion = DriverManager.getConnection(url,usuario,clave);
			//System.out.println("Conectando");
		}
		catch( SQLException exception )
		{
			throw new SQLException( "ERROR: ConsultaDAO obteniendo una conexion." );
		}
		//System.out.println("Conexion establecida");
	}

	/**
	 *Cierra la conexión activa a la base de datos. Además, con=null.
	 * @param con objeto de conexión a la base de datos
	 * @throws SistemaCinesException Si se presentan errores de conexión
	 */
	public void closeConnection(Connection connection) throws Exception {        
		//System.out.println("Cerrando conexion");
		try {
			connection.close();
			connection = null;
		} catch (SQLException exception) {
			throw new Exception("ERROR: ConsultaDAO: closeConnection() = cerrando una conexión.");
		}
		//System.out.println("Conexion cerrada");
	}


	public java.sql.Date convertorJavaDateASqlDate(java.util.Date date) 
	{
		return new java.sql.Date(date.getTime());
	}
	// -------------------------------------------------
	// Métodos de consulta
	// -------------------------------------------------

	public ArrayList<Valor> buscarValorTipo(String tipoValor) {
		// TODO Auto-generated method stub
		return null;

	}
	/**
	 *Da las operaciones de un usuario y retorna el resultado con el html listo para imprimir
	 * @param 
	 * @throws 
	 */
	public String darExistenciasValores(String valor,String rentabi, boolean neg, String exp, String ofer,String inter,String inver) throws ErrorEnConsultaException
	{
		return null;
	}


	/**
	 * @throws Exception 
	 * @throws SQLException 
	 *Da las operaciones de un usuario y retorna el resultado con el html listo para imprimir
	 * @param 
	 * @throws 
	 */
	public String darOperacionesUsuario(String tipoUsuario,
			String tipoOpe, String fechaI, String fechaF, double costo) throws Exception 
	{
		//System.out.println("En consulta de Operaciones de Usuario");
		String ans="";

		establecerConexion(url, usuario, clave);
		//System.out.println("Establecio conexion");

		PreparedStatement prepStmt = null;

		//Statement s = conexion.createStatement();	
		//System.out.println("Creando Statement");
		try
		{
			//System.out.println("La consulta de RFC2 ES: "+"SELECT NOMBRE,FECHANEG,CANTIDAD,MONTO FROM(SELECT VALOR_ID AS ID2,FECHANEG,CANTIDAD,MONTO FROM (SELECT LOGIN FROM USUARIOS WHERE TIPO='"+tipoUsuario+"') JOIN (SELECT * FROM OP_BURSATILES WHERE MONTO="+costo+" AND FECHANEG BETWEEN TO_DATE('"+fechaI+"','DD-MON-YYYY') AND TO_DATE('"+fechaF+"','DD-MON-YYYY')) ON LOGIN="+tipoOpe+"_ID) JOIN (SELECT NOMBRE,VALOR_ID FROM VALORES) ON ID2=VALOR_ID;");
			prepStmt = conexion.prepareStatement( "SELECT NOMBRE,FECHANEG,CANTIDAD,MONTO FROM(SELECT VALOR_ID AS ID2,FECHANEG,CANTIDAD,MONTO FROM (SELECT LOGIN FROM USUARIOS WHERE TIPO='"+tipoUsuario+"') JOIN (SELECT * FROM OP_BURSATILES WHERE MONTO="+costo+" AND FECHANEG BETWEEN TO_DATE('"+fechaI+"','DD-MON-YYYY') AND TO_DATE('"+fechaF+"','DD-MON-YYYY')) ON LOGIN="+tipoOpe+"_ID) JOIN (SELECT NOMBRE,VALOR_ID FROM VALORES) ON ID2=VALOR_ID");

			ResultSet resultado = prepStmt.executeQuery();

			while( resultado.next( ) )
			{
				ans+="<dd><p>";
				ans+="Nombre del valor: "+resultado.getString(1)+" " ;
				ans+="Fecha: "+resultado.getDate(2).toString()+" ";
				ans+="Cantidad: "+resultado.getInt(3)+" ";
				ans+="Precio: "+resultado.getDouble(4)+" ";
				ans+="</dd></p>";

			}
			resultado.close();
		} 

		catch (SQLException e) 
		{
			throw new ErrorEnConsultaException( e.getMessage() );
		}

		finally 
		{
			if (prepStmt != null) 
			{
				try 
				{
					prepStmt.close();
				} 
				catch (SQLException exception) 
				{
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
		}
		return ans;
	}

	/**
	 *Retorna True si el valor del param aparece en operaciones bursatiles
	 * @param 
	 * @throws 
	 */

	public boolean EstaSiendoNeg(String valor) throws ErrorEnConsultaException
	{
		return false;
	} 

	// ---------------------------------------------------
	// Métodos Funcionales
	// ---------------------------------------------------

	public Intermediario buscarIntermediario(String login) throws Exception
	{
		Intermediario resp=null;

		establecerConexion(url, usuario, clave);

		PreparedStatement prepStmt = null;	

		try{
			System.out.println("La consulta fue : SELECT * FROM (SELECT * FROM USUARIOS WHERE LOGIN='"+login+"') JOIN (SELECT LOGIN AS L2,LOG_CLIENTE FROM INTERMEDIARIOS_CLIENTES WHERE LOGIN ='"+login+"') ON LOGIN=L2");
			prepStmt= conexion.prepareStatement( "SELECT * FROM (SELECT * FROM USUARIOS WHERE LOGIN='"+login+"') JOIN (SELECT LOGIN AS L2,LOG_CLIENTE FROM INTERMEDIARIOS_CLIENTES WHERE LOGIN ='"+login+"') ON LOGIN=L2");
			ResultSet resultado = prepStmt.executeQuery();
			while( resultado.next( ) )
			{
				resp=new Intermediario(resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getString(7),resultado.getString(8)
						,resultado.getString(9),resultado.getString(10));
			}

			resultado.close( );
		} 
		catch (SQLException e) 
		{
			throw new ErrorEnConsultaException( e.getMessage() );
		}
		finally 
		{
			if (prepStmt != null) 
			{
				try 
				{
					prepStmt.close();
				} 
				catch (SQLException exception) 
				{
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
		}
		return resp;
	}

	public Usuario buscarUsuario(String login) throws Exception
	{
		Usuario resp=null;


		establecerConexion(url, usuario, clave);

		PreparedStatement prepStmt = null;
		try{


			//System.out.println("SELECT * FROM (SELECT * FROM USUARIOS WHERE LOGIN='"+login+"') JOIN (SELECT LOGIN AS L2,LOG_CLIENTE, NUM_REG FROM INTERMEDIARIOS WHERE LOGIN ='"+login+"') ON LOGIN=L2;");
			prepStmt = conexion.prepareStatement( "SELECT * FROM USUARIOS WHERE LOGIN='"+login+"'");
			ResultSet resultado = prepStmt.executeQuery();resultado.next();
			resp=new Usuario(resultado.getString(1),resultado.getString(2),resultado.getString(4),
					resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getString(7),resultado.getString(8),resultado.getString(9));

			resultado.close( );
		} 
		catch (SQLException e) 
		{
			throw new ErrorEnConsultaException( e.getMessage() );
		}
		finally 
		{
			if (prepStmt != null) 
			{
				try 
				{
					prepStmt.close();
				} 
				catch (SQLException exception) 
				{
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
		}
		return resp;
	}

	public Valor buscarValor(String valor) throws Exception
	{
		Valor resp=null;


		establecerConexion(url, usuario, clave);

		PreparedStatement prepStmt = null;

		try{
			System.out.println("SELECT * FROM VALORES WHERE NOMBRE='"+valor+"'");
			prepStmt = conexion.prepareStatement("SELECT * FROM VALORES WHERE NOMBRE='"+valor+"'");
			//TODO
			ResultSet resultado = prepStmt.executeQuery();
			resultado.next();
			resp=new Valor(resultado.getString(1),resultado.getDouble(2),resultado.getString(3),Rentabilidad.DURACION_DEFINIDA,Rentabilidad.COMPORTAMIENTO_FIJO,resultado.getString(4));

			resultado.close( );

		} 
		catch (SQLException e) 
		{
			throw new ErrorEnConsultaException( e.getMessage() );
		}
		finally 
		{
			if (prepStmt != null) 
			{
				try 
				{
					prepStmt.close();
				} 
				catch (SQLException exception) 
				{
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
		}
		return resp;
	}

	//fecha en formato 2014-09-30
	public void agregarOrden(OrdenCompraVenta orden) throws ErrorEnConsultaException, SQLException 
	{
		System.out.println("en DAO");

		establecerConexion(url, usuario, clave);
		conexion.setAutoCommit(false);
		int cantidad=(int) orden.getCantidad();

		Date fechaExp=orden.getFechaExpiracion();
		System.out.println("Fecha sin trans: " + fechaExp);
		//Date fechaOrd=orden.darFechaOrden();


		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (month/day/year)
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Calendar.getInstance().getTime();
		//System.out.println("FechaHoy: " + today);

		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String fechaEx = df.format(fechaExp);
		String fechaOr = df.format(today);


		// Print what date is today!
		//System.out.println("FechaEx: " + fechaEx);
		//System.out.println("FechaOr: " + fechaOr);


		int hora = 8;
		double monto=orden.getMonto();
		String tipo=orden.getTipo();
		String inter=orden.getIntermediario().getCorreo();
		String valor=orden.getValorNegociado().getNombre();


		PreparedStatement prepStmt = null;
		try{
			System.out.println("la consulta fue :"+"INSERT INTO ISIS2304091420.ORDENES_COMPRAVENTA (CANTIDAD, FECHA_EXP, FECHA_ORD, HORA_ORD, MONTO, TIPO, INTERMEDIARIO_ID, VALOR) VALUES ('"+cantidad+"', TO_DATE('"+fechaEx+"', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('"+fechaOr+"', 'YYYY-MM-DD HH24:MI:SS'), '"+hora+"', '"+(int)monto+"', '"+tipo+"', '"+inter+"', '"+valor+"')");

			prepStmt = conexion.prepareStatement("INSERT INTO ISIS2304091420.ORDENES_COMPRAVENTA (CANTIDAD, FECHA_EXP, FECHA_ORD, HORA_ORD, MONTO, TIPO, INTERMEDIARIO_ID, VALOR) VALUES ('"+cantidad+"', TO_DATE('"+fechaEx+"', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('"+fechaOr+"', 'YYYY-MM-DD HH24:MI:SS'), '"+hora+"', '"+(int)monto+"', '"+tipo+"', '"+inter+"', '"+valor+"')");
			prepStmt.executeUpdate();

			prepStmt = conexion.prepareStatement("UPDATE ISIS2304091420.VALORES SET NEGOCIADO = 'TRUE' WHERE NOMBRE='"+valor+"'");
			prepStmt.executeUpdate();

			conexion.commit();
		} 
		catch (SQLException e) 
		{
			throw new ErrorEnConsultaException( e.getMessage() );
		}

	}

	public void eliminarOrden(OrdenCompraVenta orden) throws ErrorEnConsultaException, SQLException 
	{
		System.out.println("en DAO");

		establecerConexion(url, usuario, clave);
		conexion.setAutoCommit(false);
		int cantidad=(int) orden.getCantidad();

		Date fechaExp=orden.getFechaExpiracion();
		System.out.println("Fecha sin trans: " + fechaExp);
		//Date fechaOrd=orden.darFechaOrden();


		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (month/day/year)
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Calendar.getInstance().getTime();
		//System.out.println("FechaHoy: " + today);

		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String fechaEx = df.format(fechaExp);
		String fechaOr = df.format(today);


		// Print what date is today!
		//System.out.println("FechaEx: " + fechaEx);
		//System.out.println("FechaOr: " + fechaOr);


		int hora = 8;
		double monto=orden.getMonto();
		String tipo=orden.getTipo();
		String inter=orden.getIntermediario().getCorreo();
		String valor=orden.getValorNegociado().getNombre();


		try
		{

			System.out.println("la consulta fue :"+"DELETE FROM ISIS2304091420.ORDENES_COMPRAVENTA WHERE VALOR="+valor+" AND INTERMEDIARIO_ID="+inter+"");

			PreparedStatement ps = conexion.prepareStatement("DELETE FROM ISIS2304091420.ORDENES_COMPRAVENTA WHERE VALOR='"+valor+"' AND INTERMEDIARIO_ID='"+inter+"'");
			ps.executeUpdate();

			ps = conexion.prepareStatement("UPDATE ISIS2304091420.VALORES SET NEGOCIADO = 'FALSE' WHERE NOMBRE='"+valor+"'");
			ps.executeUpdate();

			conexion.commit();
		} 
		catch (SQLException e) 
		{
			throw new ErrorEnConsultaException( e.getMessage() );
		}

	}

	public String retirarIntermediario(String login) throws Exception
	{
		String elimino="nadie";

		establecerConexion(url, usuario, clave);
		conexion.setAutoCommit(false);
		PreparedStatement ps =null;

		try
		{
			//extraer informacion de PORTAFOLIO_INTERMEDIARIOS
			ps = conexion.prepareStatement("SELECT * FROM PORTAFOLIO_INTERMEDIARIOS WHERE INTERMEDIARIO_DUENIO='"+login+"'");
			ResultSet resultado = ps.executeQuery();
			ArrayList<PortafolioFalso> portafolios=new ArrayList<PortafolioFalso>();
			while(resultado.next())
			{
				String id=resultado.getString(1);
				String due=resultado.getString(2);
				String tipo=resultado.getString(3);
				int cant=resultado.getInt(4);

				PortafolioFalso nvo=new PortafolioFalso(cant,due,id,tipo);
				portafolios.add(nvo);
			}

			//extraer info de los clientes
			ps = conexion.prepareStatement("SELECT LOG_CLIENTE FROM INTERMEDIARIOS_CLIENTES WHERE LOGIN='"+login+"'");
			resultado=ps.executeQuery();
			ArrayList<String> clientes=new ArrayList<String>();
			while(resultado.next())
			{
				String cliente=resultado.getString(1);
				clientes.add(cliente);
			}

			//encontrar remplazo
			boolean remplazo=false;
			Intermediario miRemplazo=null;

			ArrayList<Intermediario> otros=darTodosIntermediarios();
			System.out.println("Intermediarios disponibles :"+otros.size());
			for(int i=0;i<otros.size() && remplazo==false;i++)
			{
				//System.out.println("estamos en "+i+" y el login a buscar es: "+login);
				Intermediario actl=otros.get(i);
				if(actl!=null && actl.getCorreo()!= null && actl.getCorreo().compareTo(login)!=0)
				{

					remplazo=true;
					miRemplazo=actl;
				}
			}

			if(remplazo)
			{
				System.out.println(" el remplazo es "+miRemplazo.getCorreo());
				//elimina sus registros de clientes
				System.out.println("DELETE FROM INTERMEDIARIOS_CLIENTES WHERE LOGIN='"+login+"'");
				ps=conexion.prepareStatement("DELETE FROM INTERMEDIARIOS_CLIENTES WHERE LOGIN='"+login+"'");
				ps.executeUpdate();


				//asignar clientes al remplazo
				for(int i=0;i<clientes.size();i++)
				{
					System.out.println("INSERT INTO INTERMEDIARIOS_CLIENTES(LOGIN,LOG_CLIENTE) VALUES('"+miRemplazo.getCorreo()+"','"+clientes.get(i)+"')");
					if(!yaLoTengo(miRemplazo.getCorreo(),clientes.get(i)))
					{
						ps = conexion.prepareStatement("INSERT INTO INTERMEDIARIOS_CLIENTES(LOGIN,LOG_CLIENTE) VALUES('"+miRemplazo.getCorreo()+"','"+clientes.get(i)+"')");
						ps.executeUpdate();
					}

				}
				// Se elimina de ordenes
				System.out.println("DELETE FROM ORDENES_COMPRAVENTA WHERE INTERMEDIARIO_ID='"+login+"'");
				ps = conexion.prepareStatement("DELETE FROM ORDENES_COMPRAVENTA WHERE INTERMEDIARIO_ID='"+login+"'");
				ps.executeUpdate();
				//se elimina de usuarios
				System.out.println("DELETE FROM USUARIOS WHERE LOGIN='"+login+"'");
				ps = conexion.prepareStatement("DELETE FROM USUARIOS WHERE LOGIN='"+login+"'");
				ps.executeUpdate();

				//elimina registros de portafolio
				System.out.println("DELETE FROM PORTAFOLIO_INTERMEDIARIOS WHERE INTERMEDIARIO_DUENIO='"+login+"'");
				ps=conexion.prepareStatement("DELETE FROM PORTAFOLIO_INTERMEDIARIOS WHERE INTERMEDIARIO_DUENIO='"+login+"'");
				ps.executeUpdate();
				//asignar portafolios al remplazo
				for(int i=0;i<portafolios.size();i++)
				{
					PortafolioFalso actl=portafolios.get(i);
					System.out.println("INSERT INTO PORTAFOLIO_INTERMEDIARIOS(PORTAFOLIO_ID,INTERMEDIARIO_DUENIO,TIPO,CANTIDAD) VALUES ('"+actl.getPortafolioId()+"','"+actl.getLogDuenio()+"','"+actl.getTipo()+"',"+actl.getCantidad()+")");
					ps = conexion.prepareStatement("INSERT INTO PORTAFOLIO_INTERMEDIARIOS(PORTAFOLIO_ID,INTERMEDIARIO_DUENIO,TIPO,CANTIDAD) VALUES ('"+actl.getPortafolioId()+"','"+actl.getLogDuenio()+"','"+actl.getTipo()+"',"+actl.getCantidad()+")");
					ps.executeUpdate();
				}
				//ps.close();
				elimino=miRemplazo.getCorreo();
			}

		}


		catch (SQLException e) 
		{
			conexion.rollback();
			System.out.println("estamos en el catch");
			throw new ErrorEnConsultaException( e.getMessage() );
		}

		finally 
		{
			if (ps != null) 
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException exception) 
				{
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
		}
		conexion.commit();
		System.out.println("justo despues del commit");
		return elimino;
	}
	public boolean yaLoTengo(String log,String logCliente) throws Exception
	{
		Boolean resp=false;


		establecerConexion(url, usuario, clave);

		PreparedStatement prepStmt = null;
		try{


			//System.out.println("SELECT * FROM (SELECT * FROM USUARIOS WHERE LOGIN='"+login+"') JOIN (SELECT LOGIN AS L2,LOG_CLIENTE, NUM_REG FROM INTERMEDIARIOS WHERE LOGIN ='"+login+"') ON LOGIN=L2;");
			prepStmt = conexion.prepareStatement( "SELECT * FROM INTERMEDIARIOS_CLIENTES WHERE LOGIN='"+log+"' AND LOG_CLIENTE='"+logCliente+"'");
			ResultSet resultado = prepStmt.executeQuery();resultado.next();
			if(resultado.next())
				resp=true;


			resultado.close( );
		} 
		catch (SQLException e) 
		{
			throw new ErrorEnConsultaException( e.getMessage() );
		}
		finally 
		{
			if (prepStmt != null) 
			{
				try 
				{
					prepStmt.close();
				} 
				catch (SQLException exception) 
				{
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
		}
		return resp;
	}

	public String consultarValores2(String valorId) throws Exception
	{
		String ans="";
		establecerConexion(url, usuario, clave);

		PreparedStatement prepStmt = null;
		try{
			//System.out.println("SELECT * FROM (SELECT * FROM PORTAFOLIO_INVERSIONISTAS WHERE ID_VALOR='AHAA') JOIN (SELECT * FROM PORTAFOLIO_INTERMEDIARIOS) ON ID_PORTAFOLIO=PORTAFOLIO_ID");
			prepStmt = conexion.prepareStatement( "SELECT * FROM (SELECT * FROM PORTAFOLIO_INVERSIONISTAS WHERE ID_VALOR='"+valorId+"') JOIN (SELECT * FROM PORTAFOLIO_INTERMEDIARIOS) ON ID_PORTAFOLIO=PORTAFOLIO_ID");
			ResultSet resultado = prepStmt.executeQuery();

			while(resultado.next())
			{
				ans+="<p><dd>Portafolio ID: "+resultado.getString(1)+"</p></dd>" ;
				ans+="<p><dd>Tipo de Portafolio: "+resultado.getString("TIPO")+"</p></dd>";
				ans+="<p><dd>Intrmediario del Portafolio: "+resultado.getString("INTERMEDIARIO_DUENIO")+"</p></dd>";
				ans+="<p><dd>Inversionista Dueño: "+resultado.getString(3)+"</p></dd>";
				ans+=" <br>";
			}
			resultado.close( );
		} 
		catch (SQLException e) 
		{
			throw new ErrorEnConsultaException( e.getMessage() );
		}
		finally 
		{
			if (prepStmt != null) 
			{
				try 
				{
					prepStmt.close();
				} 
				catch (SQLException exception) 
				{
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
		}
		return ans;
	}
	
	public String consultaPortafolios(String tipoValor, int mayorA) throws Exception
	{
		String ans="";
		establecerConexion(url, usuario, clave);

		PreparedStatement prepStmt = null;
		try{
			System.out.println("SELECT ID_PORTAFOLIO, RENTABILIDAD,DUENIO,VENDEDOR_ID FROM (SELECT * FROM PORTAFOLIO_VALORES) JOIN (SELECT * FROM (SELECT * FROM VALORES WHERE TIPO='"+tipoValor+"') JOIN (SELECT * FROM OP_BURSATILES WHERE MONTO > "+mayorA+") ON NOMBRE=VALOR) ON VALOR_NOMBRE=NOMBRE;");
			prepStmt = conexion.prepareStatement("SELECT ID_PORTAFOLIO, RENTABILIDAD,DUENIO,VENDEDOR_ID FROM (SELECT * FROM PORTAFOLIO_VALORES) JOIN (SELECT * FROM (SELECT * FROM VALORES WHERE TIPO='"+tipoValor+"') JOIN (SELECT * FROM OP_BURSATILES WHERE MONTO > "+mayorA+") ON NOMBRE=VALOR) ON VALOR_NOMBRE=NOMBRE");
			ResultSet resultado = prepStmt.executeQuery();

			while(resultado.next())
			{
				ans+="<p><dd>Portafolio ID: "+resultado.getString(1)+"</p></dd>" ;
				ans+="<p><dd>Rentabilidad de Portafolio: "+resultado.getString(2)+"</p></dd>";
				ans+="<p><dd>Dueño del Portafolio: "+resultado.getString(3)+"</p></dd>";
				ans+="<p><dd>Vendedor: "+resultado.getString(4)+"</p></dd>";
				ans+=" <br>";
			}
			resultado.close( );
		} 
		finally 
		{
			if (prepStmt != null) 
			{
				try 
				{
					prepStmt.close();
				} 
				catch (SQLException exception) 
				{
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
		}
		return ans;
	}
	public String consultarMovimientosValoresSinCriterio(String fechaIni, String fechaFin, String criterio, String tipoCriterio) throws Exception
	{
		//System.out.println("En consulta de Operaciones de Usuario");
		String ans="";

		establecerConexion(url, usuario, clave);
		//System.out.println("Establecio conexion");

		PreparedStatement prepStmt = null;

		//Statement s = conexion.createStatement();	
		//System.out.println("Creando Statement");
		try
		{
			//TODO y ahi que?
			
			if( tipoCriterio.equals("VALOR"))
			{
				System.out.println("La consulta de RFC8 ES SOBRE EL VALOR: \"SELECT VALOR,FECHANEG,CANTIDAD,MONTO FROM OP_BURSATILES WHERE VALOR!='"+criterio+"' AND " 
						+"FECHANEG between TO_DATE('"+fechaIni+"', 'dd/mm/yy') and TO_DATE('"+fechaFin+"', 'dd/mm/yy')\"");

				prepStmt = conexion.prepareStatement("SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM OP_BURSATILES WHERE VALOR!='"+criterio+"' AND FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')");

				//"SELECT NOMBRE,FECHANEG,CANTIDAD,MONTO FROM(SELECT VALOR_ID AS ID2,FECHANEG,CANTIDAD,MONTO FROM (SELECT LOGIN FROM USUARIOS WHERE TIPO='"+tipoUsuario+"') JOIN (SELECT * FROM OP_BURSATILES WHERE MONTO="+costo+" AND FECHANEG BETWEEN TO_DATE('"+fechaI+"','DD-MON-YYYY') AND TO_DATE('"+fechaF+"','DD-MON-YYYY')) ON LOGIN="+tipoOpe+"_ID) JOIN (SELECT NOMBRE,VALOR_ID FROM VALORES) ON ID2=VALOR_ID");

			}
			else if( tipoCriterio.equals("OFERENTE"))
			{
				System.out.println("La consulta de RFC8 ES SOBRE EL OFERENTE: \"SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM OP_BURSATILES WHERE VENDEDOR_ID !='"+criterio+"' AND FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')\"");
			
				prepStmt = conexion.prepareStatement("SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM OP_BURSATILES WHERE VENDEDOR_ID !='"+criterio+"' AND FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')");

			}
			else if( tipoCriterio.equals("INVERSIONISTA"))
			{
				System.out.println("La consulta de RFC8 ES SOBRE EL INVERSIONISTA: \"SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM "
						+ "OP_BURSATILES WHERE COMPRADOR_ID!='"+criterio+"' AND FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')\"");
			
				//js.castro125 - 27/03/13 - 31/05/31 works
				prepStmt = conexion.prepareStatement("SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM OP_BURSATILES WHERE COMPRADOR_ID!='"+criterio+"' AND FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')");
			}
			else if( tipoCriterio.equals("TIPO_VALOR"))
			{
				System.out.println("La consulta de RFC8 ES SOBRE EL TIPO VALOR: \"SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM "
						+ "((SELECT NOMBRE AS NOM1 FROM VALORES WHERE TIPO!='"+criterio+"') JOIN (SELECT * FROM OP_BURSATILES WHERE FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')) 	ON NOM1 = VALOR);\"");

				//ACCION 1/05 - 31/05 R: wynk, arzx, qqev
				prepStmt = conexion.prepareStatement("SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM "
						+ "((SELECT NOMBRE AS NOM1 FROM VALORES WHERE TIPO!='"+criterio+"') JOIN	(SELECT * FROM OP_BURSATILES WHERE FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')) ON NOM1 = VALOR)");
				
			}
			else if( tipoCriterio.equals("TIPO_RENTABILIDAD"))
			{
				System.out.println("La consulta de RFC8 ES SOBRE LA RENTABILIDAD: \"SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM "
						+ "((SELECT NOMBRE AS NOM1 FROM VALORES WHERE RENTABILIDAD!='"+criterio+"') JOIN (SELECT * FROM OP_BURSATILES WHERE FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')) ON NOM1 = VALOR)");
				
				//FIJO DEFINIDO
				prepStmt = conexion.prepareStatement("SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM "
						+ "((SELECT NOMBRE AS NOM1 FROM VALORES WHERE RENTABILIDAD!='"+criterio+"') JOIN (SELECT * FROM OP_BURSATILES WHERE FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')) ON NOM1 = VALOR)");
			}
			
			long startTime = System.currentTimeMillis();
			
			ResultSet resultado = prepStmt.executeQuery();
			
			long endTime = System.currentTimeMillis();

			double tiempoConsulta = (endTime - startTime)/1000;
			System.out.println(" Ejecuto el sql en "+tiempoConsulta+" segundos");

			while( resultado.next( ) )
			{
				
				//VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID
				
				ans+="<dd><p>";
				ans+="Nombre del valor: "+resultado.getString("VALOR");
				//System.out.println("Valor columna añadido ");

				ans+=" Fecha: "+resultado.getDate(2).toString();
				ans+=" Vendedor: "+resultado.getString(5);
				ans+=" Comprador: "+resultado.getString(6);
				ans+=" Precio: "+resultado.getDouble(4);
				ans+=" Cantidad: "+resultado.getInt(3);
				ans+="</dd></p>";

			}
			ans += "<p>Tiempo de Consulta: "+tiempoConsulta+"</p>";

			resultado.close();

		} 

		catch (SQLException e) 
		{
			throw new ErrorEnConsultaException( e.getMessage() );
		}

		finally 
		{
			if (prepStmt != null) 
			{
				try 
				{
					prepStmt.close();
				} 
				catch (SQLException exception) 
				{
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
		}
		return ans;
	}
	public String consultarMovimientosValoresConCriterio(String fechaIni, String fechaFin, String criterio, String tipoCriterio) throws Exception
	{

		/*
		 * VALOR
		 SELECT * FROM OP_BURSATILES WHERE VALOR='QQEV' AND 
		 FECHANEG BETWEEN  TO_DATE('27/04/13', 'dd/mm/yy') AND TO_DATE('31/05/13', 'dd/mm/yy');
		 */


		/* TipoValor
		 * SELECT * FROM 
			((SELECT NOMBRE AS NOM1 FROM VALORES WHERE TIPO='+ACCION+')
			JOIN
			(SELECT * FROM OP_BURSATILES WHERE FECHANEG BETWEEN  TO_DATE('01/05/13', 'dd/mm/yy') AND TO_DATE('31/05/13', 'dd/mm/yy'))
			ON NOM1 = VALOR);
		 */

		/* TipoRentabilidad
		 * SELECT * FROM 
			((SELECT NOMBRE AS NOM1 FROM VALORES WHERE RENTABILIDAD='FIJO DEFINIDO') JOIN (SELECT * FROM OP_BURSATILES WHERE FECHANEG BETWEEN  TO_DATE('27/04/13', 'dd/mm/yy') AND TO_DATE('11/05/13', 'dd/mm/yy'))
			ON NOM1 = VALOR);
		 */

		/* OFERENTE DUENIO
		 * SELECT VALOR,FECHANEG,CANTIDAD,MONTO FROM OP_BURSATILES WHERE VENDEDOR_ID='loginGoogle' AND FECHANEG BETWEEN TO_DATE('27/04/13', 'dd/mm/yy') AND TO_DATE('31/05/13', 'dd/mm/yy')
		 	R=/ QQEV
		 */

		/* INTERMEDIARIO
		 *  SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM OP_BURSATILES WHERE COMPRADOR_ID='js.castro125' AND FECHANEG BETWEEN TO_DATE('27/03/13', 'dd/mm/yy') AND TO_DATE('31/05/13', 'dd/mm/yy')

		 */



		//System.out.println("En consulta de Operaciones de Usuario");
		String ans="";

		establecerConexion(url, usuario, clave);
		//System.out.println("Establecio conexion");

		PreparedStatement prepStmt = null;

		//Statement s = conexion.createStatement();	
		//System.out.println("Creando Statement");
		try
		{
			
			if( tipoCriterio.equals("VALOR"))
			{
				System.out.println("La consulta de RFC8 ES SOBRE EL VALOR: \"SELECT VALOR,FECHANEG,CANTIDAD,MONTO FROM OP_BURSATILES WHERE VALOR='"+criterio+"' AND " 
						+"FECHANEG between TO_DATE('"+fechaIni+"', 'dd/mm/yy') and TO_DATE('"+fechaFin+"', 'dd/mm/yy')\"");

				prepStmt = conexion.prepareStatement("SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM OP_BURSATILES WHERE VALOR='"+criterio+"' AND FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')");

				//"SELECT NOMBRE,FECHANEG,CANTIDAD,MONTO FROM(SELECT VALOR_ID AS ID2,FECHANEG,CANTIDAD,MONTO FROM (SELECT LOGIN FROM USUARIOS WHERE TIPO='"+tipoUsuario+"') JOIN (SELECT * FROM OP_BURSATILES WHERE MONTO="+costo+" AND FECHANEG BETWEEN TO_DATE('"+fechaI+"','DD-MON-YYYY') AND TO_DATE('"+fechaF+"','DD-MON-YYYY')) ON LOGIN="+tipoOpe+"_ID) JOIN (SELECT NOMBRE,VALOR_ID FROM VALORES) ON ID2=VALOR_ID");

			}
			else if( tipoCriterio.equals("OFERENTE"))
			{
				System.out.println("La consulta de RFC8 ES SOBRE EL OFERENTE: \"SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM OP_BURSATILES WHERE VENDEDOR_ID='"+criterio+"' AND FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')\"");
			
				prepStmt = conexion.prepareStatement("SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM OP_BURSATILES WHERE VENDEDOR_ID='"+criterio+"' AND FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')");

			}
			else if( tipoCriterio.equals("INVERSIONISTA"))
			{
				System.out.println("La consulta de RFC8 ES SOBRE EL INVERSIONISTA: \"SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM "
						+ "OP_BURSATILES WHERE COMPRADOR_ID='"+criterio+"' AND FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')\"");
			
				//js.castro125 - 27/03/13 - 31/05/31 works
				prepStmt = conexion.prepareStatement("SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM OP_BURSATILES WHERE COMPRADOR_ID='"+criterio+"' AND FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')");
			}
			else if( tipoCriterio.equals("TIPO_VALOR"))
			{
				System.out.println("La consulta de RFC8 ES SOBRE EL TIPO VALOR: \"SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM "
						+ "((SELECT NOMBRE AS NOM1 FROM VALORES WHERE TIPO='"+criterio+"') JOIN (SELECT * FROM OP_BURSATILES WHERE FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')) 	ON NOM1 = VALOR);\"");

				//ACCION 1/05 - 31/05 R: wynk, arzx, qqev
				prepStmt = conexion.prepareStatement("SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM "
						+ "((SELECT NOMBRE AS NOM1 FROM VALORES WHERE TIPO='"+criterio+"') JOIN	(SELECT * FROM OP_BURSATILES WHERE FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')) ON NOM1 = VALOR)");
				
			}
			else if( tipoCriterio.equals("TIPO_RENTABILIDAD"))
			{
				System.out.println("La consulta de RFC8 ES SOBRE LA RENTABILIDAD: \"SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM "
						+ "((SELECT NOMBRE AS NOM1 FROM VALORES WHERE RENTABILIDAD='"+criterio+"') JOIN (SELECT * FROM OP_BURSATILES WHERE FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')) ON NOM1 = VALOR)");
				
				//FIJO DEFINIDO
				prepStmt = conexion.prepareStatement("SELECT VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID FROM "
						+ "((SELECT NOMBRE AS NOM1 FROM VALORES WHERE RENTABILIDAD='"+criterio+"') JOIN (SELECT * FROM OP_BURSATILES WHERE FECHANEG BETWEEN TO_DATE('"+fechaIni+"', 'dd/mm/yy') AND TO_DATE('"+fechaFin+"', 'dd/mm/yy')) ON NOM1 = VALOR)");
				}
			
			long startTime = System.currentTimeMillis();
			
			ResultSet resultado = prepStmt.executeQuery();
			
			long endTime = System.currentTimeMillis();

			double tiempoConsulta = (endTime - startTime)/1000;
			System.out.println(" Ejecuto el sql en "+tiempoConsulta+" segundos");

			while( resultado.next( ) )
			{
				/*ans+="<dd><p>";
				ans+="Nombre del valor: "+resultado.getString("VALOR");
				ans+="Fecha: "+resultado.getDate("FECHANEG").toString();
				ans+="Vendedor: "+resultado.getString("VENDEDOR_ID");
				ans+="Comprador: "+resultado.getString("COMPRADOR_ID");
				ans+="Precio: "+resultado.getDouble("MONTO");
				ans+="Cantidad: "+resultado.getInt("CANTIDAD");
				ans+="</dd></p>";*/
				
				//System.out.println(" Encontró un resultado.");
				//VALOR,FECHANEG,CANTIDAD,MONTO,VENDEDOR_ID,COMPRADOR_ID
				
				ans+="<dd><p>";
				ans+="Nombre del valor: "+resultado.getString("VALOR");
				//System.out.println("Valor columna añadido ");

				ans+=" Fecha: "+resultado.getDate(2).toString();
				ans+=" Vendedor: "+resultado.getString(5);
				ans+=" Comprador: "+resultado.getString(6);
				ans+=" Precio: "+resultado.getDouble(4);
				ans+=" Cantidad: "+resultado.getInt(3);
				ans+="</dd></p>";

			}
			
			ans += "<p>Tiempo de Consulta: "+tiempoConsulta+"</p>";
			resultado.close();

		} 

		catch (SQLException e) 
		{
			throw new ErrorEnConsultaException( e.getMessage() );
		}

		finally 
		{
			if (prepStmt != null) 
			{
				try 
				{
					prepStmt.close();
				} 
				catch (SQLException exception) 
				{
					throw new Exception("ERROR: ConsultaDAO: loadRow() =  cerrando una conexión.");
				}
			}
		}
		return ans;
	}
	// ---------------------------------------------------
	// Métodos De Visualizacion
	// ---------------------------------------------------

	public ArrayList<Valor> darValoresOferente(String login) throws ErrorEnConsultaException
	{
		ArrayList<Valor> valores=new ArrayList<Valor>();
	
		try 
		{
			establecerConexion(url, usuario, clave);
	
			Statement s = conexion.createStatement();	
	
			ResultSet resultado2=s.executeQuery("SELECT * FROM VALORES WHERE DUENIO='"+login+"'");
	
	
			while(resultado2.next())
			{
				String name=resultado2.getString("Nombre");
				Double precio=resultado2.getDouble("PRECIO");
				String tipo=resultado2.getString("TIPO");
				Valor add=new Valor(name,precio,tipo,null,null,null);
				valores.add(add);
			}
		}
	
	
		catch (SQLException e) {
	
			throw new ErrorEnConsultaException( e.getMessage() );
		}	
	
		return valores;
	
	}

	public ArrayList<Oferente> darTodosOferentes() throws ErrorEnConsultaException 
	{
		try{
			ArrayList<Oferente> resp = new ArrayList<Oferente>();
			//long time_start, time_end, time;
			establecerConexion(url, usuario, clave);

			Statement s = conexion.createStatement();			
			//time_start = System.currentTimeMillis();
			ResultSet resultado = s.executeQuery("SELECT * FROM USUARIOS WHERE TIPO='OFERENTE'");

			while( resultado.next( ) )
			{
				String log = resultado.getString("LOGIN" );
				String nom=resultado.getString("NOMBRE");
				String doc=resultado.getString("DOCUMENTO");

				//se arma el arrayList con las opb
				ArrayList<OperacionBursatil> opb=darOPBursatilesUsuario(log);
				// se arma el arrayList con los valores del usuario
				ArrayList<Valor> valores=darValoresOferente(log);

				//se crea el oferente
				Oferente nvo = new Oferente( log, nom, null, null, null,null,doc,null,null,null, valores );
				nvo.setVentas(opb);
				resp.add( nvo );
			}
			resultado.close( );
			s.close( );
			return resp;
		}

		catch (SQLException e) 
		{
			throw new ErrorEnConsultaException( e.getMessage() );
		}
	}

	public ArrayList<OperacionBursatil> darOPBursatilesUsuario(String login) throws ErrorEnConsultaException
	{
		ArrayList<OperacionBursatil> valores=new ArrayList<OperacionBursatil>();

		try 
		{
			establecerConexion(url, usuario, clave);

			Statement s = conexion.createStatement();	

			//System.out.println("SELECT * FROM OP_BURSATILES WHERE VENDEDOR_ID='"+login+"' OR COMPRADOR_ID='"+login+"'");
			ResultSet resultado2=s.executeQuery("SELECT * FROM OP_BURSATILES WHERE VENDEDOR_ID='"+login+"' OR COMPRADOR_ID='"+login+"'");



			while(resultado2.next())
			{
				String vendedor=resultado2.getString("VENDEDOR_ID");
				String comprador=resultado2.getString("COMPRADOR_ID");
				String valor=resultado2.getString("VALOR");
				Double monto=resultado2.getDouble("MONTO");
				int cantidad=resultado2.getInt("CANTIDAD");
				OperacionBursatil add=new OperacionBursatil(cantidad,comprador,monto,valor,vendedor);
				valores.add(add);
			}
		}
		catch (SQLException e) {

			throw new ErrorEnConsultaException( e.getMessage() );
		}	

		return valores;

	}

	public ArrayList<Inversionista> darTodosInversionistas() throws ErrorEnConsultaException 
	{
		try{
			ArrayList<Inversionista> resp = new ArrayList<Inversionista>();
			//long time_start, time_end, time;
			establecerConexion(url, usuario, clave);

			Statement s = conexion.createStatement();			
			//time_start = System.currentTimeMillis();
			ResultSet resultado = s.executeQuery("SELECT * FROM USUARIOS WHERE TIPO='INVERSIONISTA'");

			while( resultado.next( ) )
			{
				String log = resultado.getString("LOGIN" );
				String nom=resultado.getString("NOMBRE");
				String doc=resultado.getString("DOCUMENTO");

				ArrayList<OperacionBursatil> opb=darOPBursatilesUsuario(log);

				ArrayList<String> inter=new ArrayList();

				Inversionista nvo = new Inversionista( log, nom, null, null, null,null,doc,null,null,inter );
				nvo.setVentas(opb);

				resp.add( nvo );
			}
			resultado.close( );
			s.close( );
			return resp;
		}

		catch (SQLException e) 
		{
			throw new ErrorEnConsultaException( e.getMessage() );
		}
	}

	public ArrayList<PortafolioFalso> darPortafolio(String log) throws ErrorEnConsultaException
	{
		ArrayList<PortafolioFalso> resp=new ArrayList();
		try
		{
			establecerConexion(url, usuario, clave);

			Statement s = conexion.createStatement();			
			//System.out.println("SELECT * FROM (SELECT * FROM PORTAFOLIO_INVERSIONISTAS WHERE ID_INVERSIONISTA='"+log+"') JOIN  (SELECT * FROM PORTAFOLIO_INTERMEDIARIOS) ON ID_PORTAFOLIO=PORTAFOLIO_ID");
			ResultSet resultado = s.executeQuery("SELECT * FROM (SELECT * FROM PORTAFOLIO_INVERSIONISTAS WHERE ID_INVERSIONISTA='"+log+"') JOIN  (SELECT * FROM PORTAFOLIO_INTERMEDIARIOS) ON ID_PORTAFOLIO=PORTAFOLIO_ID");

			while( resultado.next( ) )
			{
				String inter = resultado.getString("INTERMEDIARIO_DUENIO" );
				String valor=resultado.getString("ID_VALOR");
				String tipo=resultado.getString("TIPO");
				Double porcentaje=resultado.getDouble("PORCENTAJE");

				PortafolioFalso nvo = new PortafolioFalso( valor, porcentaje, tipo, inter);
				resp.add(nvo);
			}
			resultado.close( );
			s.close( );

		}

		catch (SQLException e) 
		{
			throw new ErrorEnConsultaException( e.getMessage() );
		}


		return resp;
	}

	private ArrayList<String> darIntermediariosClientes(String log) throws ErrorEnConsultaException 
	{
		ArrayList<String> resp=new ArrayList<String>();
		try
		{
			establecerConexion(url, usuario, clave);
			Statement s = conexion.createStatement();	
			ResultSet resultado2=s.executeQuery("SELECT LOGIN FROM INTERMEDIARIOS_CLIENTES WHERE LOG_CLIENTE='"+log+"'");
			while(resultado2.next())
			{
				resp.add(resultado2.getString("LOGIN"));
			}
			resultado2.close( );
			s.close( );
		}
		catch (SQLException e) {

			throw new ErrorEnConsultaException( e.getMessage() );
		}
		return resp;
	}

	public ArrayList<Intermediario> darTodosIntermediarios() throws ErrorEnConsultaException 
	{
		try
		{
			ArrayList<Intermediario> resp = new ArrayList<Intermediario>();
			//long time_start, time_end, time;
			establecerConexion(url, usuario, clave);

			Statement s = conexion.createStatement();			
			//time_start = System.currentTimeMillis();
			//System.out.println("SELECT * FROM USUARIOS WHERE TIPO='INTERMEDIARIO'");
			ResultSet resultado = s.executeQuery("SELECT * FROM USUARIOS WHERE TIPO='INTERMEDIARIO'");

			while( resultado.next( ) )
			{
				String log = resultado.getString("LOGIN" );
				String nom=resultado.getString("NOMBRE");
				String doc=resultado.getString("DOCUMENTO");
				ArrayList<OperacionBursatil> opb=darOPBursatilesUsuario(log);
				Intermediario nvo = new Intermediario( log, nom, null, null, null,null,doc,null,null,null );
				nvo.setVentas(opb);

				//agregarPortafolios
				agregarPortafolios(nvo,log);

				resp.add( nvo );
			}

			resultado.close( );
			s.close( );
			return resp;
		}

		catch (SQLException e) 
		{
			throw new ErrorEnConsultaException( e.getMessage() );
		}
	}

	public void agregarPortafolios(Intermediario nvo, String log) throws ErrorEnConsultaException
	{
		//System.out.println("entro al metodo");
		try
		{
			//System.out.println("esta en el try");
			establecerConexion(url, usuario, clave);
			Statement s = conexion.createStatement();	
			//System.out.println("SELECT PORTAFOLIO_ID,TIPO,CANTIDAD,VALOR_NOMBRE  FROM (SELECT * FROM PORTAFOLIO_INTERMEDIARIOS WHERE INTERMEDIARIO_DUENIO='"+log+"') JOIN (SELECT * FROM PORTAFOLIO_VALORES) ON PORTAFOLIO_ID=ID_PORTAFOLIO");
			ResultSet resultado2=s.executeQuery("SELECT PORTAFOLIO_ID,TIPO,CANTIDAD,VALOR_NOMBRE  FROM (SELECT * FROM PORTAFOLIO_INTERMEDIARIOS WHERE INTERMEDIARIO_DUENIO='"+log+"') JOIN (SELECT * FROM PORTAFOLIO_VALORES) ON PORTAFOLIO_ID=ID_PORTAFOLIO");
			while(resultado2.next())
			{
				//System.out.println("esta en el while");
				String tipo=resultado2.getString("TIPO");
				int cant=resultado2.getInt("CANTIDAD");
				String valor=resultado2.getString("VALOR_NOMBRE");
				String tipoGo=darConstantePortafolio(tipo);
				nvo.getPortafolio(tipoGo).agregarNombreValor(valor);
				nvo.getPortafolio(tipoGo).setCantidad(cant);
			}
			resultado2.close( );
			s.close( );
		}
		catch (SQLException e) {

			throw new ErrorEnConsultaException( e.getMessage() );
		}

	}

	public String darConstantePortafolio(String n)
	{
		if(n.compareTo("AGRESIVO")==0)
			return AGRESIVO;
		else if(n.compareTo("MODERADO")==0)
			return MODERADO;
		else
			return CONSERVADOR;
	}



}