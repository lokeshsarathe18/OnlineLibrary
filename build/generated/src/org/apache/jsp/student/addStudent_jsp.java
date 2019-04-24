package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kulchuri.library.student.StudentDao;

public final class addStudent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("        <title>Insert title here</title>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/design/head.html", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </head>\r\n");
      out.write("        <body>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/design/header.html", out, false);
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/design/main_menu.html", out, false);
      out.write("\r\n");
      out.write("        <div>\r\n");
      out.write("            <center>\r\n");
      out.write("                <h1 style=\"color: white;\">New Student Registration Form</h1>\r\n");
      out.write("            </center>\r\n");
      out.write("            <form action=\"../StudentController\" enctype=\"multipart/form-data\"\r\n");
      out.write("                  method=\"post\" style=\"width: 50%; margin-left: 25%\">\r\n");
      out.write("\r\n");
      out.write("                <input type=\"text\" name=\"sname\" placeholder=\"Enter name\"> \r\n");
      out.write("                <input\r\n");
      out.write("                    type=\"email\" name=\"email\" placeholder=\"Enter email\"> <input\r\n");
      out.write("                    type=\"password\" name=\"pwd\" placeholder=\"Enter password\"> \r\n");
      out.write("                <input type=\"text\" name=\"mno\" maxlength=\"10\" placeholder=\"Enter mobile number\">\r\n");
      out.write("                <input type=\"text\" name=\"dob\" id=\"dob\" placeholder=\"Enter select dob\"/><br>\r\n");
      out.write("                <input type=\"radio\" value=\"Male\" checked=\"checked\" name=\"gender\">\r\n");
      out.write("                <span style=\"color: white; font-size: x-large;\">Male</span> <input\r\n");
      out.write("                    type=\"radio\" value=\"Female\" name=\"gender\"> <span\r\n");
      out.write("                    style=\"color: white; font-size: x-large;\">Female</span> <br> <br>\r\n");
      out.write("                <input type=\"file\" name=\"image\"> \r\n");
      out.write("                <input type=\"submit\" value=\"Register\">\r\n");
      out.write("\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script src=\"calander/jquery-2.1.4.min.js\"></script>\r\n");
      out.write("        <script src=\"calander/bootstrap.js\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"calander/jquery-ui.css\" />\r\n");
      out.write("    <script src=\"calander/jquery-ui.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        $(function () {\r\n");
      out.write("            $(\"#dob\").datepicker({\r\n");
      out.write("                dateFormat: 'dd/mm/yy',\r\n");
      out.write("                changeMonth: true,\r\n");
      out.write("                changeYear: true,\r\n");
      out.write("                yearRange: '-100y:c+nn',\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
