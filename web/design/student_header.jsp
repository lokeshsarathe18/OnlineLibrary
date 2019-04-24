<%-- 
    Document   : student_header
    Created on : Dec 22, 2018, 11:53:03 AM
    Author     : DELL
--%>

<%
    String sid = (String) session.getAttribute("sid");
    if (sid == null) {
        response.sendRedirect("../login.jsp");
    }
%>
<img src="../images/LNCT_Bhopal_Logo.png" width="50" height="50"
     style="float: left;">
<h1>LNCT</h1>