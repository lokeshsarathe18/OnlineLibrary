<%-- 
    Document   : logout
    Created on : Dec 8, 2018, 1:01:08 PM
    Author     : DELL
--%>

<%
    session.removeAttribute("sid");
    response.sendRedirect("login.jsp");
    
%>