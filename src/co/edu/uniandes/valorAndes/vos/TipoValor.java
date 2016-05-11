package co.edu.uniandes.valorAndes.vos;

/**
 * @author David Ricardo
 * @version 1.0
 * @created 20-sep-2014 12:00:08 p.m.
 */
public class TipoValor {
	
	public static final String ACCION ="ACCION";
	
	public static final String BONO_PUBLICO ="BONO PUBLICO";
	
	public static final String BONO_PRIVADO = "BONO PRIVADO";
	
	public static final String CERTIFICADO = "CERTIFICADO";
		
	public static final String TITULO_PARTICIPACION = "TITULO PARTICIPACION";


	protected String idTipo;
	protected String nombreTipo;
	protected String descripcionTipo;

	
	/**
	 * Constructor del tipo de valor. Se tienen solo 5 tipos de valores y para ser creado necesita mandar el tipo de valor unicamente.
	 * @param tipo Tipo del valor que se tiene, mandado en constante
	 */
	public TipoValor(String tipo)
	{
		if(tipo.equalsIgnoreCase(ACCION))
		{
			nombreTipo = ACCION;
			idTipo = "1";
			descripcionTipo = "Valor que depende de la compra venta en tiempo real y cuyo precio varia constantemente.";	
		}
		else if(tipo.equalsIgnoreCase(BONO_PUBLICO))
		{
			nombreTipo = BONO_PUBLICO;
			idTipo = "2";
			descripcionTipo = "Valor que se compra a empresas del estado.";	
		}
		else if(tipo.equalsIgnoreCase(BONO_PRIVADO))
		{
			nombreTipo = BONO_PRIVADO;
			idTipo = "3";
			descripcionTipo = "Valor que se compra a empresas privadas.";	
		}
		else if(tipo.equalsIgnoreCase(CERTIFICADO))
		{
			nombreTipo = CERTIFICADO;
			idTipo = "4";
			descripcionTipo = "Valor que no depende de la compra venta en tiempo real y cuyo precio varia constantemente.";	
		}
		else if(tipo.equalsIgnoreCase(TITULO_PARTICIPACION))
		{
			nombreTipo = TITULO_PARTICIPACION;
			idTipo = "5";
			descripcionTipo = "Valor que da una participacion en la empresa a quien la compra.";	
		}
		else
		{	
				System.out.println("tipo no equivalente a constantes");
		}

	}
	
	public String getNombreTipo()
	{
		return nombreTipo;
	}

	public void finalize() throws Throwable {

	}
}//end TipoValor