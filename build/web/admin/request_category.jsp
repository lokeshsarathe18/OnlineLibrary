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
        <div>
            <center>
                <h1 style="color: white;">Add Category Form</h1>
            </center>
            <form action="addCategory.jsp" method="post"
                  style="width: 30%; margin-left: 35%">

                <input type="text" name="cname" placeholder="Enter Category"
                       autofocus="true"> <input type="submit" value="Add">
            </form>
        </div>
    </body>
</html>