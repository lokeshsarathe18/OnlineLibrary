<%@page import="com.kulchuri.library.book.BookDao"%>
<%@page import="com.kulchuri.library.category.CategoryDao"%>
<%@page import="com.kulchuri.library.category.CategoryDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<jsp:useBean id="bdto" class="com.kulchuri.library.book.BookDto"></jsp:useBean>
<jsp:setProperty property="*" name="bdto" />
<%
    if (request.getMethod().equalsIgnoreCase("post")) {
        if (new BookDao().addBook(bdto)) {
%>
<jsp:forward page="viewAllBooks.jsp"></jsp:forward>
<%
} else {
%>
<center>
    <h1>Book Addition Failed</h1>
</center>
<%
        }
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
        <jsp:include page="/design/head.html"></jsp:include>
        </head>
        <body>
        <jsp:include page="/design/admin_header.jsp"></jsp:include>
        <jsp:include page="/design/admin_menu.html"></jsp:include>
            <div>
                <center>
                    <h1 style="color: white;">Add Book Form</h1>
                </center>
            <%
                ArrayList<CategoryDto> al = new CategoryDao().getAllCategories();
                if (al != null) {
            %>
            <form action="addBook.jsp" method="post"
                  style="width: 50%; margin-left: 25%">
                <select name="cid">
                    <option>---Select Category---</option>
                    <%
                        for (CategoryDto dto : al) {
                    %>
                    <option value="<%=dto.getCid()%>"><%=dto.getCname()%></option>
                    <%
                        }
                    %>
                </select> <input type="text" name="bname" placeholder="Enter book name">
                <input type="text" name="aname" placeholder="Enter authour name">
                <input type="text" name="pname" placeholder="Enter publication name">
                <input type="text" name="edition" placeholder="Enter book edition">
                <input type="text" name="quantity" placeholder="Enter book quantity">
                <input type="text" name="price" placeholder="Enter book price">
                <input type="submit" value="Add">
            </form>
            <%
            } else {
            %>
            <center>
                <h1 style="color: red">Please Add Category First</h1>
            </center>
            <%
                }
            %>
        </div>
    </body>
</html>
