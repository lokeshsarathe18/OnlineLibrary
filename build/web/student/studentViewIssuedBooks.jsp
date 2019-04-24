<%-- 
    Document   : studentViewIssuedBooks
    Created on : Dec 8, 2018, 12:58:12 PM
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
        <%                ArrayList<BookDto> al = null;

            al = new BookIssueDao().getAllIssuedBooks(Integer.parseInt(sid));
        %>

        <table id="customers">
            <tr>
                <th>S.No.</th>
                <th>Name</th>
                <th>Author</th>
                <th>Publication</th>
                <th>Price</th>
                <th>Issued Date</th>
            </tr>
            <%                    int s = 0;
                for (BookDto dto : al) {
            %>
            <tr>
                <td><%=++s%></td>
                <td><%=dto.getBname()%></td>
                <td><%=dto.getAname()%></td>
                <td><%=dto.getPname()%></td>
                <td><%=dto.getPrice()%></td>
                <td>
                    <%=dto.getIdate() %>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</body>
</html>
