<%-- 
    Document   : login
    Created on : Dec 8, 2018, 11:30:33 AM
    Author     : DELL
--%>

<%@page import="com.kulchuri.library.student.StudentDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="head.html" %>
    </head>
    <body>
        <%@include file="header.html" %>
        <%@include file="main_menu.html" %>
        <%
            if (request.getMethod().equalsIgnoreCase("post")) {
                String uname = request.getParameter("uname");
                String pwd = request.getParameter("pwd");
                String ltype = request.getParameter("ltype");
                if (ltype.equalsIgnoreCase("admin")) {
                    if (uname.equals("Admin123") && pwd.equals("Admin123")) {
                        session.setAttribute("admin12", uname);
                        response.sendRedirect("admin/adminHome.jsp");
                    } else {
        %>
        <script> alert("Please enter valid login details");</script>

        <%   }
        } else if (ltype.equalsIgnoreCase("student")) {
            int sid = new StudentDao().loginStudent(uname, pwd);
            if (sid != 0) {
                session.setAttribute("sid", sid + "");
                response.sendRedirect("student/studentHome.jsp");
            } else {
        %>
        <script> alert("Please enter valid login details");</script>
        <%
                    }
                }
            }
        %>
        <div>
            <h1>Login Form</h1>
            <form action="login.jsp" method="post" style="width: 50%; margin-left: 25%" >
                <input type="text" name="uname" placeholder="Enter username" autofocus="" required=""/><br>
                <input type="password" name="pwd" placeholder="Enter password" required=""/><br>
                <input type="radio" checked="" value="Admin" name="ltype"/>Admin
                <input type="radio" value="Employee" name="ltype"/>Employee
                <input type="radio" value="Student" name="ltype"/>Student
                <br>
                <input type="submit" value="Login"/>
            </form>
        </div>
    </body>
</html>
