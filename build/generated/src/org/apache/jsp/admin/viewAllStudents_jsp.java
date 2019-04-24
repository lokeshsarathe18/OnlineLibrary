package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import com.kulchuri.library.student.StudentDto;

public final class viewAllStudents_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("        <title>Library:Category</title>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/design/head.html", out, false);
      out.write("\n");
      out.write("        ");
      com.kulchuri.library.student.StudentDao dao = null;
      synchronized (_jspx_page_context) {
        dao = (com.kulchuri.library.student.StudentDao) _jspx_page_context.getAttribute("dao", PageContext.PAGE_SCOPE);
        if (dao == null){
          dao = new com.kulchuri.library.student.StudentDao();
          _jspx_page_context.setAttribute("dao", dao, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/design/header.html", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/design/admin_menu.html", out, false);
      out.write("\n");
      out.write("            <div>\n");
      out.write("                <table id=\"customers\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>S.No.</th>\n");
      out.write("                        <th>Name</th>\n");
      out.write("                        <th>Email</th>\n");
      out.write("                        <th>M.NO.</th>\n");
      out.write("                        <th>D.O.B</th>\n");
      out.write("                        <th>D.O.R</th>\n");
      out.write("                        <th>Gender</th>\n");
      out.write("                        <th>Status</th>\n");
      out.write("                        <th>Photo</th>\n");
      out.write("                    </tr>\n");
      out.write("                ");


                    ArrayList<StudentDto> list = dao.getAllStudents();
                    if (list != null) {
                        int s = 0;
                        for (StudentDto dto : list) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(++s);
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getSname());
      out.write("</td>\n");
      out.write("\n");
      out.write("                    <td>");
      out.print(dto.getEmail());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getMno());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getDob());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getDor());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getGender());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getStatus());
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("\n");
      out.write("                        <img src=\"data:image/jpeg;base64,");
      out.print(dto.getPhoto());
      out.write("\" height=\"100px\"\n");
      out.write("                             width=\"100px\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                } else {
                
      out.write("\n");
      out.write("                <h1>Please Add Category First</h1>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
