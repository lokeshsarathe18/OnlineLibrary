<%-- 
    Document   : adminReturnBook
    Created on : Dec 25, 2018, 12:52:31 PM
    Author     : DELL
--%>
<%@page import="com.kulchuri.library.utility.LibraryDate"%>
<%@page import="com.kulchuri.library.issue.BookIssueDao"%>
<%@page import="com.kulchuri.library.issue.BookIssueBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
        <jsp:include page="/design/head.html"></jsp:include>
        </head>
        <body>
        <jsp:include page="/design/admin_header.jsp"></jsp:include>
        <jsp:include page="/design/admin_menu.html"></jsp:include>
            <div style="margin-left: 25%">
            <%
                if (request.getMethod().equalsIgnoreCase("post")) {
                    String biid = request.getParameter("biid");
                    String sid = request.getParameter("sid");
                    String bid = request.getParameter("bid");
                    BookIssueBean issueBean = new BookIssueBean();
                    issueBean.setSid(Integer.parseInt(sid));
                    issueBean.setBiid(Integer.parseInt(biid));
                    issueBean.setBid(Integer.parseInt(bid));
                    BookIssueDao dao = new BookIssueDao();
                    String idate = dao.getIssuedBooks(issueBean);
                    if (idate == null) {
            %>
            <script>
                alert('Enter valid details!!!');
            </script>
            <%} else {
                Long day = LibraryDate.getDays(idate, LibraryDate.getCurrentDate());
                int fine = 0;
                if (day > 5) {
                    fine = (int) ((day - 5) * 10);
            %>
            <input type="hidden" id="fine" value="<%=fine%>"/>
            <script>
                var fine = document.getElementById("fine").value;
                alert("You have to pay " + fine);
            </script>
            <%
                        }
                        issueBean.setRdate(LibraryDate.getCurrentDate());
                        issueBean.setDay((int) (day * 1));
                        issueBean.setFine(fine);

                        dao.bookReturn(issueBean);
                    }
                }
            %>
            <form style="width: 50%" action="adminReturnBook.jsp" method="post">
                <h1 style="margin-left: 5%">
                    Book Return Form
                </h1>
                <input type="text" autofocus="" required="" name="sid" placeholder="Enter Student ID" />
                <input type="text" required="" name="biid" placeholder="Enter book issue number" />
                <input type="text" required="" name="bid" placeholder="Enter book id" />
                <input type="submit" value="Return"/>
            </form>
        </div>
    </body>
</html>
