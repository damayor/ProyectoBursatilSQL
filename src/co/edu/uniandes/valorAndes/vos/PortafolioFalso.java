package co.edu.uniandes.valorAndes.vos;

public class PortafolioFalso 
{
	private String valor;
	private double porcentaje;
	private String tipo;
	private String logDuenio;
	
	//para el de intermediario
	private String portafolioId;
	private int cantidad;
	
	private String inver;
	
	public String getInver() {
		return inver;
	}

	public void setInver(String inver) {
		this.inver = inver;
	}

	public PortafolioFalso(String valor, double porcentaje, String tipo,String log) {
		
		this.valor = valor;
		this.porcentaje = porcentaje;
		this.tipo = tipo;
		logDuenio=log;
	}
	
	//para el intermediario
	public PortafolioFalso(int ncant, String nlog, String id, String ntipo)
	{
		cantidad=ncant;
		logDuenio=nlog;
		portafolioId=id;
		tipo=ntipo;
	}
	
	public PortafolioFalso(String id, String ntipo, String inter, String inver)
	{
		portafolioId=id;
		tipo=ntipo;
		
	}

	public String getPortafolioId() {
		return portafolioId;
	}

	public void setPortafolioId(String portafolioId) {
		this.portafolioId = portafolioId;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getLogDuenio() {
		return logDuenio;
	}

	public void setLogDuenio(String logDuenio) {
		this.logDuenio = logDuenio;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
