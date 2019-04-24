<%-- 
    Document   : studentViewBooks
    Created on : Dec 8, 2018, 12:57:05 PM
    Author     : DELL
--%>

<%@page import="com.kulchuri.library.issue.BookIssueDao"%>
<%@page import="com.kulchuri.library.issue.BookIssueBean"%>
<%@page import="com.kulchuri.library.category.CategoryDto"%>
<%@page import="com.kulchuri.library.category.CategoryDao"%>
<%@page import="com.kulchuri.library.book.BookDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kulchuri.library.book.BookDto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function bookList1() {
                var category = document.getElementById('cid').value;
                window.location.replace("studentViewBooks.jsp?cid=" + category);
            }
        </script>
        <%@include file="../design/head.html" %>
    </head>
    <body>
        <%@include file="../design/student_header.jsp" %>
        <%@include file="../design/student_menu.html" %>
        <div style="width: 25%; margin-left: 40%">
            <select  name="cid" id="cid" onchange="bookList1()">
                <%                    String cid = request.getParameter("cid");
                    CategoryDao dao = new CategoryDao();
                    if (cid == null) {
                %>
                <option>---Select Category---</option>
                <%  } else {
                    CategoryDto cd = dao.getCategory(Integer.parseInt(cid));
                %>
                <option value="<%=cd.getCid()%>"><%=cd.getCname()%></option>

                <%
                    }
                    for (CategoryDto dto : dao.getAllCategories()) {
                        if (cid != null && dto.getCid() == Integer.parseInt(cid)) {
                %>
                <%
                } else {
                %>
                <option value="<%=dto.getCid()%>"><%=dto.getCname()%></option>
                <%}
                    }%>
            </select>
        </div>
        <div>
            <%
                String bid = request.getParameter("bid");
                if (bid != null) {
                    BookIssueBean bib = new BookIssueBean();
                    bib.setBid(Integer.parseInt(bid));
                    bib.setSid(Integer.parseInt(sid));
                    if (new BookIssueDao().issueBook(bib)) {
                        response.sendRedirect("studentHome.jsp");
                    } else {
            %>
            <script>
                alert('Book Issue Failed!');
            </script>

            <%
                    }
                }
                ArrayList<BookDto> al = null;
                BookDao bdao = new BookDao();
                if (cid != null) {
                    al = bdao.getAllBooksByCategory(Integer.parseInt(cid));
            %>

            <table id="customers">
                <tr>
                    <th>S.No.</th>
                    <th>Name</th>
                    <th>Author</th>
                    <th>Publication</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Operation</th>
                </tr>
                <%                    int s = 0;
                    for (BookDto dto : al) {
                %>
                <tr>
                    <td><%=++s%></td>
                    <td><%=dto.getBname()%></td>
                    <td><%=dto.getAname()%></td>
                    <td><%=dto.getPname()%></td>
                    <td><%=dto.getQuantity()-new BookIssueDao().getTotalIssueBooks(dto.getBid())%></td>
                    <td><%=dto.getPrice()%></td>
                    <td>
                        <a href="studentViewBooks.jsp?bid=<%=dto.getBid()%>">Issue</a> 
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            <%
            } else {
                al = bdao.getAllBooks();
                if (al != null) {
            %>



            <table id="customers">
                <tr>
                    <th>S.No.</th>
                    <th>Name</th>
                    <th>Author</th>
                    <th>Publication</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Category</th>

                </tr>
                <%
                    int s = 0;
                    for (BookDto dto : al) {
                %>
                <tr>
                    <td><%=++s%></td>
                    <td><%=dto.getBname()%></td>
                    <td><%=dto.getAname()%></td>
                    <td><%=dto.getPname()%></td>
                    <td><%=dto.getQuantity()-new BookIssueDao().getTotalIssueBooks(dto.getBid())%></td>
                    <td><%=dto.getPrice()%></td>
                    <td><%=dto.getCname()%></td>
                </tr>
                <%
                    }
                %>
            </table>
            <%
            } else {
            %>
            <center>
                <h1>There is no books available</h1>
            </center>
            <%
                    }
                }
            %>
        </div>
    </body>
</html>
