<%-- 
    Document   : logout
    Created on : Dec 25, 2018, 2:07:34 PM
    Author     : DELL
--%>
<%
    session.removeAttribute("admin12");
    response.sendRedirect("../login.jsp");
%>