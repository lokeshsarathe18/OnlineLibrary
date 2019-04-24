<%-- 
    Document   : admin_header
    Created on : Dec 25, 2018, 2:08:59 PM
    Author     : DELL
--%>


<%
    String admin = (String) session.getAttribute("admin12");
    if (admin == null) {
%>
<script>
    window.location.replace("../login.jsp");
</script>
<%
} else {%>

<img src="../images/LNCT_Bhopal_Logo.png" width="50" height="50"
     style="float: left;">
<h1>LNCT</h1>
<%}%>