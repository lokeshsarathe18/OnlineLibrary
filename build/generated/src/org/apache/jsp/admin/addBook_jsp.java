package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kulchuri.library.book.BookDao;
import com.kulchuri.library.category.CategoryDao;
import com.kulchuri.library.category.CategoryDto;
import java.util.ArrayList;

public final class addBook_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      com.kulchuri.library.book.BookDto bdto = null;
      synchronized (_jspx_page_context) {
        bdto = (com.kulchuri.library.book.BookDto) _jspx_page_context.getAttribute("bdto", PageContext.PAGE_SCOPE);
        if (bdto == null){
          bdto = new com.kulchuri.library.book.BookDto();
          _jspx_page_context.setAttribute("bdto", bdto, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("bdto"), request);
      out.write('\r');
      out.write('\n');

    if (request.getMethod().equalsIgnoreCase("post")) {
        if (new BookDao().addBook(bdto)) {

      out.write('\r');
      out.write('\n');
      if (true) {
        _jspx_page_context.forward("viewAllBooks.jsp");
        return;
      }
      out.write('\r');
      out.write('\n');

} else {

      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("    <h1>Book Addition Failed</h1>\r\n");
      out.write("</center>\r\n");

        }
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("        <title>Insert title here</title>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/design/head.html", out, false);
      out.write("\r\n");
      out.write("        </head>\r\n");
      out.write("        <body>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/design/admin_header.jsp", out, false);
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/design/admin_menu.html", out, false);
      out.write("\r\n");
      out.write("            <div>\r\n");
      out.write("                <center>\r\n");
      out.write("                    <h1 style=\"color: white;\">Add Book Form</h1>\r\n");
      out.write("                </center>\r\n");
      out.write("            ");

                ArrayList<CategoryDto> al = new CategoryDao().getAllCategories();
                if (al != null) {
            
      out.write("\r\n");
      out.write("            <form action=\"addBook.jsp\" method=\"post\"\r\n");
      out.write("                  style=\"width: 50%; margin-left: 25%\">\r\n");
      out.write("                <select name=\"cid\">\r\n");
      out.write("                    <option>---Select Category---</option>\r\n");
      out.write("                    ");

                        for (CategoryDto dto : al) {
                    
      out.write("\r\n");
      out.write("                    <option value=\"");
      out.print(dto.getCid());
      out.write('"');
      out.write('>');
      out.print(dto.getCname());
      out.write("</option>\r\n");
      out.write("                    ");

                        }
                    
      out.write("\r\n");
      out.write("                </select> <input type=\"text\" name=\"bname\" placeholder=\"Enter book name\">\r\n");
      out.write("                <input type=\"text\" name=\"aname\" placeholder=\"Enter authour name\">\r\n");
      out.write("                <input type=\"text\" name=\"pname\" placeholder=\"Enter publication name\">\r\n");
      out.write("                <input type=\"text\" name=\"edition\" placeholder=\"Enter book edition\">\r\n");
      out.write("                <input type=\"text\" name=\"quantity\" placeholder=\"Enter book quantity\">\r\n");
      out.write("                <input type=\"text\" name=\"price\" placeholder=\"Enter book price\">\r\n");
      out.write("                <input type=\"submit\" value=\"Add\">\r\n");
      out.write("            </form>\r\n");
      out.write("            ");

            } else {
            
      out.write("\r\n");
      out.write("            <center>\r\n");
      out.write("                <h1 style=\"color: red\">Please Add Category First</h1>\r\n");
      out.write("            </center>\r\n");
      out.write("            ");

                }
            
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
