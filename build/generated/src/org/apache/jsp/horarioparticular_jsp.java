package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Control.Consultas;

public final class horarioparticular_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
 
    HttpSession sesion=request.getSession();
    int userId;
    if(sesion==null){
    System.out.println("No ha iniciado sesion");
    response.sendRedirect("Login.jsp");
    return;
    }
    else{
    if(sesion.getAttribute("userId")==null){
        response.sendRedirect("Login.jsp");
        System.out.println("Sesion userId no existe");
        return;
    }
    
    userId=Integer.parseInt(sesion.getAttribute("userId").toString());
    if(userId==-1){
        System.out.println("sesion2");
        response.sendRedirect("Login.jsp");
        return ;
        }
    }
    
    String []datosUsuario=null;
    String usuario=Consultas.getAttrib(request, "_buscarusuario");
    
    if(!usuario.equals("")){
        datosUsuario= Consultas.getDatosUsuario(usuario);
    }
    
 response.setHeader("Cache-Control","no-cache");
                response.setHeader("Cache-Control","no-store");
                response.setHeader("Pragma","no-cache");
                response.setDateHeader ("Expires", 0);
                if(sesion.getAttribute("userId")==null){
                    response.sendRedirect(request.getContextPath() + "/Login.jsp");

                }


      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>ALBA Geolocalizacion</title>\n");
      out.write("           <!-- Bootstrap Core CSS -->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link href=\"css/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom Fonts -->\n");
      out.write("        <link href=\"font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"pick/css/pikaday.css\">\n");
      out.write("        <script src=\"js/jquery.js\"></script>\n");
      out.write("        \n");
      out.write("          <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom styles for this template -->\n");
      out.write("        <link href=\"css/simple-sidebar.css\" rel=\"stylesheet\">\n");
      out.write("        <script type=\"text/javascript\" src=\"js/registrarUsuarios.js\"></script>\n");
      out.write("        \n");
      out.write("         <style>\n");
      out.write("          .idtabla thead th{\n");
      out.write("             background: lightgray; \n");
      out.write("            }\n");
      out.write("            .idtabla thead th:first-of-type{\n");
      out.write("            border-top-left-radius: 10px; \n");
      out.write("             }\n");
      out.write("\n");
      out.write("        .idtabla thead th:last-of-type{\n");
      out.write("            border-top-right-radius: 10px; \n");
      out.write("            }\n");
      out.write("       </style>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("     \n");
      out.write("    <body >\n");
      out.write("        <div id=\"wrapper\" >\n");
      out.write("\n");
      out.write("        <!-- Navigation -->\n");
      out.write("        <nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n");
      out.write("            <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("             <div class=\"navbar-header\">\n");
      out.write("                 <a href=\"#menu-toggle\" class=\"btn btn-secondary\" id=\"menu-toggle\">\n");
      out.write("            <img src=\"images/inicioblanco.png\" width=\"30\" height=\"30\" border=\"0\">\n");
      out.write("            </a>\n");
      out.write("            </div>\n");
      out.write("                       \n");
      out.write("            <!-- Top Menu Items -->\n");
      out.write("            <ul class=\"nav navbar-right top-nav\">\n");
      out.write("                <li class=\"dropdown\">\n");
      out.write("                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><i class=\"fa fa-user\"></i> ");
      out.print(sesion.getAttribute("nombre") );
      out.write(" <b class=\"caret\"></b></a>\n");
      out.write("                    <ul class=\"dropdown-menu\">\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"Configuracion.jsp\"><i class=\"fa fa-fw fa-gear\"></i> Cambiar Contraseña</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li>\n");
      out.write("                          <a href=\"Login?accion=cerrar\"><i class=\"fa fa-fw fa-power-off\"></i> Cerrar Sesión</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("           <center>\n");
      out.write("            <div class=\"nav collapse navbar-collapse\">\n");
      out.write("                <img src=\"images/cancerberologo.png\" width=\"50\" height=\"50\" border=\"0\">\n");
      out.write("            </div>\n");
      out.write("           </center>\n");
      out.write("           </nav>\n");
      out.write("            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->\n");
      out.write("               <!-- Sidebar -->\n");
      out.write("        <div id=\"sidebar-wrapper\">\n");
      out.write("            <ul class=\"sidebar-nav\">\n");
      out.write("                  ");
      out.print( Consultas.Permisos(Integer.parseInt(sesion.getAttribute("userId").toString())) );
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <!-- /#sidebar-wrapper -->\n");
      out.write("            <!-- /.navbar-collapse -->\n");
      out.write("        \n");
      out.write("   <div id=\"page-wrapper\">\n");
      out.write("       \n");
      out.write("       <center><font size=\"5\" color=\"#0033cc\">Horarios particulares</font></center>\n");
      out.write("       <br>\n");
      out.write("       \n");
      out.write("      \n");
      out.write("       \n");
      out.write("       <table id=\"idtabla\" class=\"table\"> \n");
      out.write("           <thead> \n");
      out.write("               <tr class=\"info\"> \n");
      out.write("                   <th scope=\"col\">Fecha</th> \n");
      out.write("                   <th scope=\"col\">Conductor</th> \n");
      out.write("                   <th scope=\"col\">Auto</th> \n");
      out.write("                   <th scope=\"col\">Ruta</th> \n");
      out.write("               </tr> \n");
      out.write("           </thead> \n");
      out.write("           <tbody> <tr> \n");
      out.write("                   <th>\n");
      out.write("                       <center><font size=\"3\" color=\"#0033cc\">Desde</font></center>\n");
      out.write("                       <input id=\"idfechainicial\" class=\"form-control\" name=\"fechainicial\" type=\"date\" >\n");
      out.write("                       <center><font size=\"3\" color=\"#0033cc\">Hasta</font></center>\n");
      out.write("                       <input id=\"idfechafinal\" class=\"form-control\" name=\"fechafinal\" type=\"date\" >\n");
      out.write("                   </th> \n");
      out.write("                   <th>\n");
      out.write("                       <select id=\"idConductor\" size=\"6\" name=\"_buscarconductor\" class=\"form-control\">   \n");
      out.write("                            ");

                                String idconductor=Consultas.getidConductor("",sesion.getAttribute("fkempresa").toString()); 
      out.write("\n");
      out.write("                            ");
      out.print(idconductor);
      out.write("\n");
      out.write("                         </select>\n");
      out.write("                   </th> \n");
      out.write("                   <th>\n");
      out.write("                        <select  id=\"idAuto\" size=\"6\" name=\"_buscarunidad\" class=\"form-control\">\n");
      out.write("                            ");

                                String idautos=Consultas.getidAuto(""); 
                            
      out.write("\n");
      out.write("                            ");
      out.print(idautos);
      out.write("\n");
      out.write("                         </select>\n");
      out.write("                   </th>\n");
      out.write("                   <th>\n");
      out.write("                       <select class=\"form-control\" size=\"6\" id=\"idruta\" >\n");
      out.write("                            ");
 String rutas=Consultas.getRutas(sesion.getAttribute("fkempresa").toString()); 
      out.write("\n");
      out.write("                            ");
      out.print(rutas);
      out.write("\n");
      out.write("                         </select>\n");
      out.write("                   </th> \n");
      out.write("               </tr> \n");
      out.write("           </tbody> \n");
      out.write("       </table>\n");
      out.write("               \n");
      out.write("        <br>                 \n");
      out.write("        <center><button class=\"btn btn-primary\">Guardar</button></center>\n");
      out.write("                         \n");
      out.write("    </div>\n");
      out.write("    </div>  \n");
      out.write("            \n");
      out.write("                    \n");
      out.write("    <!-- /#wrapper -->\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    \n");
      out.write("     <!-- Bootstrap core JavaScript -->\n");
      out.write("    <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("    <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Menu Toggle Script -->\n");
      out.write("    <script>\n");
      out.write("    $(\"#menu-toggle\").click(function(e) {\n");
      out.write("        e.preventDefault();\n");
      out.write("        $(\"#wrapper\").toggleClass(\"toggled\");\n");
      out.write("    });\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
