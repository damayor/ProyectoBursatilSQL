package co.edu.uniandes.valorAndes.vos;

import java.util.ArrayList;

/**
 * @author David Ricardo
 * @version 1.0
 * @created 18-sep-2014 01:23:20 p.m.
 */
public class PortafolioIntermediario {
	
	public static final String CONSERVADOR = "Rentabilidad Fija";
	
	public static final String MODERADO = "Rentabilidad Fija indefinida";

	public static final String AGRESIVO = "Agresivo Variable";


	private String tipo;
	
	private int id;
	
	/**
	 * los valores que ofrece el invermediario dentro del portafolio
	 */
	private ArrayList<Valor> valoresOfrecidos;
	
	private ArrayList<String> nombreValores;
	

	/**
	 * Intermediario que promociona dicho portafolio
	 */

	private Intermediario creador;

	/**
	 * Cantidad total de los valores que son ofrecidos por el intermediario para que sean comprados
	 */
	private int canValores;
	
	private int cantidad;
	
	
	/**
	private Inversionista clienteInversionista;
	 */
	/**
	 * Se registra el tipo de portafolio y se crea con los valores vacios y la cantidad que ofrecera tambien vacia
	 * @param tipo tipo del portafolio, tipo == CONSERVADOR |AGRESIVO | MODERADO
	 */
	public PortafolioIntermediario(int nid,String tipo,Intermediario creador,int ncantidad)
	{	
		this.id=nid;
		this.tipo = tipo;
		this.creador = creador;
		//this.setCantidadValores(canValores);
		valoresOfrecidos = new ArrayList<Valor>();	
		nombreValores=new ArrayList<String>();
		cantidad=ncantidad;
	}
	

	/**
	 * Crea el portafolio con una cantidad por defecto igual a 10000 valores a ser albergados dentro del portafolio;
	 * @param ntipo
	 * @param intermediario
	 */
	public PortafolioIntermediario(String ntipo,
			Intermediario intermediario) 
	{
		this.tipo=ntipo;
		this.creador=intermediario;
		valoresOfrecidos = new ArrayList<Valor>();	
		nombreValores=new ArrayList<String>();
		this.cantidad=10000;
	}


	public String getTipo() {
		return tipo;
	}
	public void agregarNombreValor(String n)
	{
		nombreValores.add(n);
	}
	
	public int getCantidadValores()
	{
		return valoresOfrecidos.size();
	}
	public ArrayList getNombreValores()
	{
		return nombreValores;
	}

	public void agregarValor(Valor e)
	{
		valoresOfrecidos.add(e);
	}
	public int getId()
	{
		return id;
	}
	public ArrayList<Valor> getValores()
	{
		return valoresOfrecidos;
	}
	
	public void setID(int nuId)
	{
		this.id=nuId;
	}


	
	public Intermediario getCreador() {
		return creador;
	}

	public void setCreador(Intermediario creador) {
		this.creador = creador;
	}
	
	public void setCantidad(int canValores)
	{
		this.canValores = canValores;
	}
	
	public int getCantidad()
	{
		return canValores;
	}
	
	public void setCantidadTotal(int canTotal)
	{
		this.cantidad = canTotal;
	}
	
	public int getCantidadTotal()
	{
		return cantidad;
	}
	
	public int compareTo(PortafolioIntermediario o) 
	{
		if(creador.compareTo(o.getCreador())>0)
		{
			return 1;
		}
		else if(creador.compareTo(o.getCreador())<0)
		{
			return -1;
		}
		else
		{
			boolean dif = false;
			for(int i=0;i<valoresOfrecidos.size() && !dif;i++ )
			{
				if(valoresOfrecidos.get(i).compareTo(o.valoresOfrecidos.get(i))>0)
				{	
					dif = true;
					return 1;
				}
				else if(valoresOfrecidos.get(i).compareTo(o.valoresOfrecidos.get(i))<0)
				{
					dif = true;
					return -1;
				}
			}
			return 0; //se supone que como retorno los otros ya, solo retorna 0 si si llego al final del for
		}

	}
	
	

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void setCantidadValores(int canValores) {
		this.canValores = canValores;
	}
}//end PortafolioIntermediario