package co.edu.uniandes.valorAndes.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SevletConsultaValoresPortafolios extends HttpServlet
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
   		//System.out.println("rESPONDIENDO SERVLET CONSULTAS");
   		PrintWriter salida = response.getWriter();
  		 		
   		try {   			
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
   			salida.println("	<title>Central de abastos de los Andes</title>");
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
   			salida.println("                        <input type=\"text\" class=\"form-control\" placeholder=\"&#191Qu&#233 desea buscar&#63\" name=\"textoBusqueda\"title=\"Si su filtro es fecha, ingresela en el siguiente formato:  dd/mm/aaaa-aa/mm/aaaa, reemplaze por una X en case de no limitar alguna.\">");
   			salida.println("");
   			salida.println("                        <input type=\"text\" class=\"form-control\" placeholder=\"Filtro\" name=\"tipoBusqueda\">");
   			salida.println("");
   			salida.println("                        ");
   			salida.println("");
   			salida.println("                        <button type=\"submit\" class=\"btn btn-default\">Buscar</button>");
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
   			salida.println("        <form class=\"well\" action=\"Portafolios.htm\" method=\"POST\">");
   			salida.println("");
   			salida.println("       <t>Ingrese los datos para consultar los portafolios con los iguientes criterios:</t>");
   			salida.println("");
   			salida.println("			<div class=\"span1 pull-Left\">");
   			salida.println("");
   			salida.println("            	<input type=\"text\" class=\"form-control\" placeholder=\"Que contengan este Tipo del Valor\" name=\"textoValorTipo\">");
   			salida.println("");
   			salida.println("            	<input type=\"text\" class=\"form-control\" placeholder=\"Con operaciones con Valor Mayor a\" name=\"textoComparar\">");
   			salida.println("");
   			salida.println("            	<button type=\"submit\" class=\"btn btn-default\">Buscar</button>");
   			salida.println("");
   			salida.println("			</div>			");
   			salida.println("");
   			salida.println("		</form>");
   			salida.println("");
   			salida.println("		<form class=\"well\" action=\"Valores.htm\" method=\"POST\">");
   			salida.println("");
   			salida.println("       <t>Ingrese el Identificador del Valor para mostrar la información de los portafolios en los que ha estado involucrado</t>");
   			salida.println("");
   			salida.println("			<div class=\"span1 pull-Left\">");
   			salida.println("");
   			salida.println("            	<input type=\"text\" class=\"form-control\" placeholder=\"Identificador del Valor\" name=\"textoValorId\">");
   			salida.println("");
   			salida.println("            	<button type=\"submit\" class=\"btn btn-default\">Buscar</button>");
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


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	}

}
