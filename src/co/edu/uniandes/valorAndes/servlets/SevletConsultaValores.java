package co.edu.uniandes.valorAndes.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.uniandes.valorAndes.vos.ValorAndes;

public class SevletConsultaValores extends HttpServlet
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
   		ValorAndes cab = ValorAndes.darInstancia();
   		PrintWriter pw = response.getWriter();
   		String valorId = request.getParameter("textoValorId");
   		
  		 		
   		try {   			
   			pw.println("<!DOCTYPE HTML>");
   			pw.println("<html lang=\"es\">");
   			pw.println("<head>");
   			pw.println("	<link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.css\">");
   			pw.println("	<link type=\"text/css\" rel=\"stylesheet\" href=\"css/style.css\">");
   			pw.println("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\"> ");
   			pw.println("    ");
   			pw.println("    <link href=\"css/bootstrap.css\" rel=\"stylesheet\">");
   			pw.println("");
   			pw.println("	<title>Central de abastos de los Andes</title>");
   			pw.println("");
   			pw.println("	<style type='text/css'> body {background-color: #ffffff;}</style>");
   			pw.println("");
   			pw.println("</head>");
   			pw.println("");
   			pw.println("<body>");
   			pw.println("    <!-- NAVBAR");
   			pw.println("================================================== -->");
   			pw.println("        <div class=\"navbar-wrapper\">");
   			pw.println("          <div class=\"container\">");
   			pw.println("    ");
   			pw.println("            <nav class=\"navbar-wrapper navbar-default navbar-static-top\" role=\"navigation\">");
   			pw.println("              <div class=\"container\">             ");
   			pw.println("              ");
   			pw.println("                <div class=\"navbar-header\">");
   			pw.println("                  <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">");
   			pw.println("                    <span class=\"sr-only\">Toggle navigation</span>");
   			pw.println("                    <span class=\"icon-bar\"></span>");
   			pw.println("                    <span class=\"icon-bar\"></span>");
   			pw.println("                    <span class=\"icon-bar\"></span>");
   			pw.println("                  </button>");
   			pw.println("                  <a class=\"navbar-brand\">CabAndes</a>                    ");
   			pw.println("                </div>");
   			pw.println("                ");
   			pw.println("                <div class=\"collapse navbar-collapse\">                ");
   			pw.println("                    <ul class=\"nav navbar-nav\">");
   			pw.println("                        <li><a href=\"login.htm\" method=\"POST\">Inicio</a></li>");
   			pw.println("                        ");
   			pw.println("                        <li><a>TextoBusqueda</a></li>");
   			pw.println("                        ");
   			pw.println("                        <li><a>TipoDeBusqueda</a></li>");
   			pw.println("                        ");
   			pw.println("                    </ul>                    ");
   			pw.println("                    ");
   			pw.println("                    <form class=\"navbar-form navbar-left\">");
   			pw.println("                        <input type=\"text\" class=\"form-control\" placeholder=\"Filtro\" name=\"filtro\">");
   			pw.println("                        ");
   			pw.println("                        <button type=\"submit\" class=\"btn btn-default\" action=\"filtrarBusqueda.htm\">Filtrar</button>");
   			pw.println("                    </form>");
   			pw.println("                    ");
   			pw.println("                    ");
   			pw.println("                    ");
   			pw.println("                    <ul class=\"nav navbar-nav\">");
   			pw.println("                        <li><a href=\"pagina.htm\">Volver</a></li>                        ");
   			pw.println("                    </ul> ");
   			pw.println("                                ");
   			pw.println("                </div>");
   			pw.println("                                                                           ");
   			pw.println("              </div>");
   			pw.println("            </div>");
   			pw.println("              ");
   			pw.println("          </div>");
   			pw.println("        </div>    ");
   			pw.println("    ");
   			cab.darValores1(valorId, pw);
   			pw.println("        <p><a class=\"TextCopy\" href=\"https://www.facebook.com/camilo.carrillo.587\">&copy; Juan Sebastian Castro Duarte Ni&#241o</a></p> ");
   			pw.println("    </footer>");
   			pw.println("");
   			pw.println("	<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\" type=\"text/javascript\"></script>");
   			pw.println("    <script src=\"./js/bootstrap.min.js\"></script>");
   			pw.println("    <script src=\"./js/docs.min.js\"></script>");
   			pw.println("</body>");
   			pw.println("");
   			pw.println("</html>");


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	}
}
