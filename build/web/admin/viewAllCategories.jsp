<%@page import="com.kulchuri.library.category.CategoryDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kulchuri.library.category.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Library:Category</title>
        <jsp:include page="/design/head.html"></jsp:include>
        </head>
        <body>
        <jsp:include page="/design/admin_header.jsp"></jsp:include>
        <jsp:include page="/design/admin_menu.html"></jsp:include>
            <div style="width: 50%; margin-left: 25%">
                <h1>All Categories</h1>
                <table id="customers">
                    <tr>
                        <th>S.No.</th>
                        <th>Name</th>
                        <th>Operation</th>
                    </tr>
                <%
                    CategoryDao dao = new CategoryDao();
                    String cid = request.getParameter("cid");

                    if (cid != null && request.getParameter("opn") != null) {
                        dao.deleteCategory(Integer.parseInt(cid));
                    }
                    ArrayList<CategoryDto> list = dao.getAllCategories();
                    if (list != null) {
                        int s = 0;
                        for (CategoryDto dto : list) {
                %>
                <tr>
                    <td><%=++s%></td>
                    <td><%=dto.getCname()%></td>
                    <td><a href="editCategory.jsp?cid1=<%=dto.getCid()%>">Edit</a>
                        <a href="viewAllCategories.jsp?cid=<%=dto.getCid()%>&opn=delete">Delete</a>
                    </td>
                </tr>
                <%
                    }
                } else {
                %>
                <h1>Please Add Category First</h1>
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>