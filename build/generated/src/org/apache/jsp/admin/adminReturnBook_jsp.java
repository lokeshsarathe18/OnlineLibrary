package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kulchuri.library.utility.LibraryDate;
import com.kulchuri.library.issue.BookIssueDao;
import com.kulchuri.library.issue.BookIssueBean;

public final class adminReturnBook_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("        <title>Insert title here</title>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/design/head.html", out, false);
      out.write("\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/design/admin_header.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/design/admin_menu.html", out, false);
      out.write("\n");
      out.write("            <div style=\"margin-left: 25%\">\n");
      out.write("            ");

                if (request.getMethod().equalsIgnoreCase("post")) {
                    String biid = request.getParameter("biid");
                    String sid = request.getParameter("sid");
                    String bid = request.getParameter("bid");
                    BookIssueBean issueBean = new BookIssueBean();
                    issueBean.setSid(Integer.parseInt(sid));
                    issueBean.setBiid(Integer.parseInt(biid));
                    issueBean.setBid(Integer.parseInt(bid));
                    BookIssueDao dao = new BookIssueDao();
                    String idate = dao.getIssuedBooks(issueBean);
                    if (idate == null) {
            
      out.write("\n");
      out.write("            <script>\n");
      out.write("                alert('Enter valid details!!!');\n");
      out.write("            </script>\n");
      out.write("            ");
} else {
                Long day = LibraryDate.getDays(idate, LibraryDate.getCurrentDate());
                int fine = 0;
                if (day > 5) {
                    fine = (int) ((day - 5) * 10);
            
      out.write("\n");
      out.write("            <input type=\"hidden\" id=\"fine\" value=\"");
      out.print(fine);
      out.write("\"/>\n");
      out.write("            <script>\n");
      out.write("                var fine = document.getElementById(\"fine\").value;\n");
      out.write("                alert(\"You have to pay \" + fine);\n");
      out.write("            </script>\n");
      out.write("            ");

                        }
                        issueBean.setRdate(LibraryDate.getCurrentDate());
                        issueBean.setDay((int) (day * 1));
                        issueBean.setFine(fine);

                        dao.bookReturn(issueBean);
                    }
                }
            
      out.write("\n");
      out.write("            <form style=\"width: 50%\" action=\"adminReturnBook.jsp\" method=\"post\">\n");
      out.write("                <h1 style=\"margin-left: 5%\">\n");
      out.write("                    Book Return Form\n");
      out.write("                </h1>\n");
      out.write("                <input type=\"text\" autofocus=\"\" required=\"\" name=\"sid\" placeholder=\"Enter Student ID\" />\n");
      out.write("                <input type=\"text\" required=\"\" name=\"biid\" placeholder=\"Enter book issue number\" />\n");
      out.write("                <input type=\"text\" required=\"\" name=\"bid\" placeholder=\"Enter book id\" />\n");
      out.write("                <input type=\"submit\" value=\"Return\"/>\n");
      out.write("            </form>\n");
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
