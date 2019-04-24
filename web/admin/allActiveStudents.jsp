<%@page import="java.util.ArrayList"%>
<%@page import="com.kulchuri.library.student.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Library:Category</title>
        <jsp:include page="/design/head.html"></jsp:include>
        <jsp:useBean id="dao" class="com.kulchuri.library.student.StudentDao"/>
    </head>
    <body>
        <jsp:include page="/design/admin_header.jsp"></jsp:include>
        <jsp:include page="/design/admin_menu.html"></jsp:include>
            <div>
                <table id="customers">

                <%
                    String opn = request.getParameter("opn");
                    String sid = request.getParameter("sid");
                    if (opn != null && sid != null) {
                        if (opn.equalsIgnoreCase("nonactive")) {
                            dao.nonActiveStudent(Integer.parseInt(sid));
                        }
                    }

                    ArrayList<StudentDto> list = dao.getAllActiveStudents();
                    if (list != null && list.size() > 0) {
                        int s = 0;
                %>
                <tr>
                    <th>S.No.</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>M.NO.</th>
                    <th>D.O.B</th>
                    <th>D.O.R</th>
                    <th>Gender</th>
                    <th>Status</th>
                    <th>Photo</th>
                    <th>Operation</th>
                </tr>
                <%
                    for (StudentDto dto : list) {
                %>
                <tr>
                    <td><%=++s%></td>
                    <td><%=dto.getSname()%></td>

                    <td><%=dto.getEmail()%></td>
                    <td><%=dto.getMno()%></td>
                    <td><%=dto.getDob()%></td>
                    <td><%=dto.getDor()%></td>
                    <td><%=dto.getGender()%></td>
                    <td><%=dto.getStatus()%></td>
                    <td>

                        <img src="data:image/jpeg;base64,<%=dto.getPhoto()%>" height="100px"
                             width="100px">


                    </td>
                    <td>
                        <a href="allActiveStudents.jsp?opn=nonactive&sid=<%=dto.getSid()%>">Non Active</a>
                    </td>
                </tr>
                <%
                    }
                } else {
                %>
                <center>
                    <h1 style="color: white">There is no active students</h1>
                </center>
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>