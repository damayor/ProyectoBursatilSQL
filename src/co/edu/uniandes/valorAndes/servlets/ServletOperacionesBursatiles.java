package co.edu.uniandes.valorAndes.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletOperacionesBursatiles extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    	procesarSolicitud(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        procesarSolicitud(request, response);
    }
    
   	private void procesarSolicitud(HttpServletRequest request, HttpServletResponse response) {
        try {
			responder(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   	
   	private void responder(HttpServletRequest request, HttpServletResponse response) throws IOException
   	{
   		PrintWriter salida = response.getWriter();
  		 		
   		try 
   		{   			
   			salida.println("<!DOCTYPE HTML>");
   			salida.println("");
   			salida.println("<html lang=\"es\">");
   			salida.println("");
   			salida.println("<head>");
   			salida.println("");
   			salida.println("	<link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.css\">");
   			salida.println("");
   			salida.println("	<link type=\"text/css\" rel=\"stylesheet\" href=\"css/style.css\">");
   			salida.println("");
   			salida.println("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\"> ");
   			salida.println("");
   			salida.println("    ");
   			salida.println("");
   			salida.println("    <link href=\"css/bootstrap.css\" rel=\"stylesheet\">");
   			salida.println("");
   			salida.println("");
   			salida.println("");
   			salida.println("	<title>Valores de los Andes</title>");
   			salida.println("");
   			salida.println("");
   			salida.println("");
   			salida.println("	<style type='text/css'> body {background-color: #ffffff;}</style>");
   			salida.println("");
   			salida.println("");
   			salida.println("");
   			salida.println("</head>");
   			salida.println("");
   			salida.println("");
   			salida.println("");
   			salida.println("<body>");
   			salida.println("");
   			salida.println("    <!-- NAVBAR");
   			salida.println("");
   			salida.println("================================================== -->");
   			salida.println("");
   			salida.println("        <div class=\"navbar-wrapper\">");
   			salida.println("");
   			salida.println("          <div class=\"container\">");
   			salida.println("");
   			salida.println("    ");
   			salida.println("");
   			salida.println("            <nav class=\"navbar-wrapper navbar-default navbar-static-top\" role=\"navigation\">");
   			salida.println("");
   			salida.println("              <div class=\"container\">             ");
   			salida.println("");
   			salida.println("              ");
   			salida.println("");
   			salida.println("                <div class=\"navbar-header\">");
   			salida.println("");
   			salida.println("                  <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">");
   			salida.println("");
   			salida.println("                    <span class=\"sr-only\">Toggle navigation</span>");
   			salida.println("");
   			salida.println("                    <span class=\"icon-bar\"></span>");
   			salida.println("");
   			salida.println("                    <span class=\"icon-bar\"></span>");
   			salida.println("");
   			salida.println("                    <span class=\"icon-bar\"></span>");
   			salida.println("");
   			salida.println("                  </button>");
   			salida.println("");
   			salida.println("                  <a class=\"navbar-brand\">ValorAndes</a>                    ");
   			salida.println("");
   			salida.println("                </div>");
   			salida.println("");
   			salida.println("                ");
   			salida.println("");
   			salida.println("                <div class=\"collapse navbar-collapse\">                ");
   			salida.println("");
   			salida.println("                    <ul class=\"nav navbar-nav\">");
   			salida.println("");
   			salida.println("                        <li><a href=\"login.htm\" method=\"POST\">Inicio</a></li>");
   			salida.println("");
   			salida.println("                        ");
   			salida.println("");
   			salida.println("                    </ul>                    ");
   			salida.println("");
   			salida.println("                    ");
   			salida.println("");
   			salida.println("                    <form class=\"navbar-form navbar-left\" action=\"busqueda.htm\" method=\"POST\">");
   			salida.println("");
   			salida.println("");
   			salida.println("");
   			salida.println("                        ");
   			salida.println("");
   			salida.println("          ");
   			salida.println("");
   			salida.println("                    </form>");
   			salida.println("");
   			salida.println("                                  ");
   			salida.println("");
   			salida.println("                </div>");
   			salida.println("");
   			salida.println("                                                                           ");
   			salida.println("");
   			salida.println("              </div>");
   			salida.println("");
   			salida.println("            </div>");
   			salida.println("");
   			salida.println("              ");
   			salida.println("");
   			salida.println("          </div>");
   			salida.println("");
   			salida.println("        </div>");
   			salida.println("");
   			salida.println("        ");
   			salida.println("");
   			salida.println("        <form class=\"well\" action=\"ordenarOB.htm\" method=\"POST\">");
   			salida.println("");
   			salida.println("       <t>Ordenar Operacion Bursatil</t>");
   			salida.println("");
   			salida.println("			<div class=\"span1 pull-Left\">");
   			salida.println("");
   			salida.println("            ");
   			salida.println("");
   			salida.println("");
   			salida.println("            ");
   			salida.println("");
   			salida.println("            	<input type=\"text\" class=\"form-control\" placeholder=\"Ingrese el Monto\" name=\"textoMonto\">");
   			salida.println("");
   			salida.println("            	");
   			salida.println("");
   			salida.println("            	<input type=\"text\" class=\"form-control\" placeholder=\"Ingrese el login del Intermediario\" name=\"textoLogin\">");
   			salida.println("");
   			salida.println("            	");
   			salida.println("");
   			salida.println("            	<input type=\"text\" class=\"form-control\" placeholder=\"Ingrese el Tipo de Operacion\" name=\"textoOperacion\">");
   			salida.println("");
   			salida.println("            	");
   			salida.println("");
   			salida.println("            	<input type=\"text\" class=\"form-control\" placeholder=\"Ingrese el Nombre del Valor\" name=\"textoValor\">");
   			salida.println("");
   			salida.println("            	");
   			salida.println("");
   			salida.println("            	<input type=\"text\" class=\"form-control\" placeholder=\"Ingrese la fecha de expiracion (dd-mm-yyyy)\" name=\"textoFecha\">");
   			salida.println("");
   			salida.println("            	");
   			salida.println("");
   			salida.println("            	<input type=\"text\" class=\"form-control\" placeholder=\"Ingrese la hora de expiracion\" name=\"textoHora\">");
   			salida.println("");
   			salida.println("                        ");
   			salida.println("");
   			salida.println("            	<button type=\"submit\" class=\"btn btn-default\">Ordenar</button>");
   			salida.println("");
   			salida.println("            ");
   			salida.println("");
   			salida.println("			</div>			");
   			salida.println("");
   			salida.println("		</form>");
   			salida.println("");
   			salida.println("		");
   			salida.println("");
   			salida.println("        <form class=\"well\" action=\"eliminarOB.htm\" method=\"POST\">");
   			salida.println("");
   			salida.println("       <t>Eliminar Operacion Bursatil</t>");
   			salida.println("");
   			salida.println("			<div class=\"span1 pull-Left\">");
   			salida.println("");
   			salida.println("            ");
   			salida.println("");
   			salida.println("            	<input type=\"text\" class=\"form-control\" placeholder=\"Ingrese el Monto\" name=\"textoMonto\">");
   			salida.println("");
   			salida.println("            ");
   			salida.println("");
   			salida.println("            	<input type=\"text\" class=\"form-control\" placeholder=\"Ingrese el login del Intermediario\" name=\"textoLogin\">");
   			salida.println("");
   			salida.println("            	");
   			salida.println("");
   			salida.println("            	<input type=\"text\" class=\"form-control\" placeholder=\"Ingrese el Tipo de Operacion\" name=\"textoOperacion\">");
   			salida.println("");
   			salida.println("            	");
   			salida.println("");
   			salida.println("            	<input type=\"text\" class=\"form-control\" placeholder=\"Ingrese el Nombre del Valor\" name=\"textoValor\">");
   			salida.println("");
   			salida.println("            	");
   			salida.println("");
   			salida.println("            	<input type=\"text\" class=\"form-control\" placeholder=\"Ingrese la fecha de expiracion\" name=\"textoFecha\">");
   			salida.println("");
   			salida.println("            	");
   			salida.println("");
   			salida.println("            	<input type=\"text\" class=\"form-control\" placeholder=\"Ingrese la hora de expiracion\" name=\"textoHora\">");
   			salida.println("");
   			salida.println("                        ");
   			salida.println("");
   			salida.println("            	<button type=\"submit\" class=\"btn btn-default\">Eliminar</button>");
   			salida.println("");
   			salida.println("            ");
   			salida.println("");
   			salida.println("			</div>			");
   			salida.println("");
   			salida.println("		</form> ");
   			salida.println("");
   			salida.println("");
   			salida.println("");
   			salida.println("	<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\" type=\"text/javascript\"></script>");
   			salida.println("");
   			salida.println("    <script src=\"./js/bootstrap.min.js\"></script>");
   			salida.println("");
   			salida.println("    <script src=\"./js/docs.min.js\"></script>");
   			salida.println("");
   			salida.println("</body>");
   			salida.println("");
   			salida.println("");
   			salida.println("");
   			salida.println("</html>");

		} 
   		catch (Exception e) 
   		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	}

}


