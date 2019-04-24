package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kulchuri.library.category.CategoryDto;
import com.kulchuri.library.category.CategoryDao;
import com.kulchuri.library.book.BookDao;
import java.util.ArrayList;
import com.kulchuri.library.book.BookDto;

public final class studentViewBooks_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/student/../design/head.html");
    _jspx_dependants.add("/student/../design/student_header.jsp");
    _jspx_dependants.add("/student/../design/student_menu.html");
  }

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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script>\n");
      out.write("            function bookList1() {\n");
      out.write("                var category = document.getElementById('cid').value;\n");
      out.write("                window.location.replace(\"studentViewBooks.jsp?cid=\" + category);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        ");
      out.write("<link href=\"../css/style.css\" rel=\"stylesheet\" type=\"text/css\">");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write('\n');
      out.write('\n');

    String sid = (String) session.getAttribute("sid");
    if (sid == null) {
        response.sendRedirect("../login.jsp");
    }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<img src=\"../images/LNCT_Bhopal_Logo.png\" width=\"50\" height=\"50\"\n");
      out.write("     style=\"float: left;\">\n");
      out.write("<h1>LNCT</h1>");
      out.write("\n");
      out.write("        ");
      out.write("<ul>\r\n");
      out.write("    <li><a href=\"../student/studentHome.jsp\">Home</a></li>\r\n");
      out.write("    <li><a href=\"../student/studentViewBooks.jsp\">Books</a></li>\r\n");
      out.write("    <li><a href=\"../student/studentViewIssuedBooks.jsp\">Issued Books</a></li>\r\n");
      out.write("    <li><a href=\"../student/history.jsp\">History</a></li>\r\n");
      out.write("    <li><a href=\"../logout.jsp\">Logout</a></li>\r\n");
      out.write("</ul>");
      out.write("\n");
      out.write("        <div style=\"width: 25%; margin-left: 40%\">\n");
      out.write("            <select  name=\"cid\" id=\"cid\" onchange=\"bookList1()\">\n");
      out.write("                ");

                    String cid = request.getParameter("cid");
                    CategoryDao dao = new CategoryDao();
                    if (cid == null) {
                
      out.write("\n");
      out.write("                <option>---Select Category---</option>\n");
      out.write("                ");
  } else {
                    CategoryDto cd = dao.getCategory(Integer.parseInt(cid));
                
      out.write("\n");
      out.write("                <option value=\"");
      out.print(cd.getCid());
      out.write('"');
      out.write('>');
      out.print(cd.getCname());
      out.write("</option>\n");
      out.write("\n");
      out.write("                ");

                    }
                    for (CategoryDto dto : dao.getAllCategories()) {
                        if (cid != null && dto.getCid() == Integer.parseInt(cid)) {
                
      out.write("\n");
      out.write("                ");

                } else {
                
      out.write("\n");
      out.write("                <option value=\"");
      out.print(dto.getCid());
      out.write('"');
      out.write('>');
      out.print(dto.getCname());
      out.write("</option>\n");
      out.write("                ");
}
                    }
      out.write("\n");
      out.write("            </select>\n");
      out.write("        </div>\n");
      out.write("        <div>\n");
      out.write("            ");

                ArrayList<BookDto> al = null;
                BookDao bdao = new BookDao();
                if (cid != null) {
                    al = bdao.getAllBooksByCategory(Integer.parseInt(cid));
            
      out.write("\n");
      out.write("\n");
      out.write("            <table id=\"customers\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>S.No.</th>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>Author</th>\n");
      out.write("                    <th>Publication</th>\n");
      out.write("                    <th>Quantity</th>\n");
      out.write("                    <th>Price</th>\n");
      out.write("                    <th>Operation</th>\n");
      out.write("                </tr>\n");
      out.write("                ");
                    int s = 0;
                    for (BookDto dto : al) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(++s);
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getBname());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getAname());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getPname());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getQuantity());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getPrice());
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"studentBookIssue.jsp?bid=");
      out.print(dto.getBid());
      out.write("\">Issue</a> \n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("            ");

            } else {
                al = bdao.getAllBooks();
                if (al != null) {
            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <table id=\"customers\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>S.No.</th>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>Author</th>\n");
      out.write("                    <th>Publication</th>\n");
      out.write("                    <th>Quantity</th>\n");
      out.write("                    <th>Price</th>\n");
      out.write("                    <th>Category</th>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("                ");

                    int s = 0;
                    for (BookDto dto : al) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(++s);
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getBname());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getAname());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getPname());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getQuantity());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getPrice());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(dto.getCname());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("            ");

            } else {
            
      out.write("\n");
      out.write("            <center>\n");
      out.write("                <h1>There is no books available</h1>\n");
      out.write("            </center>\n");
      out.write("            ");

                    }
                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
