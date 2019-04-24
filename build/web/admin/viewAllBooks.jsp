<%@page import="com.kulchuri.library.book.BookDao"%>
<%@page import="com.kulchuri.library.book.BookDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<%
			String bid = request.getParameter("bid");
			String opn = request.getParameter("opn");
			if (bid != null && opn != null) {
				new BookDao().deleteBook(Integer.parseInt(bid));
			}
			ArrayList<BookDto> al = new BookDao().getAllBooks();
			if (al != null) {
		%>
		<table id="customers">
			<tr>
				<th>S.No.</th>
				<th>Name</th>
				<th>Author</th>
				<th>Publication</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Category</th>
				<th>Operation</th>
			</tr>
			<%
				int s = 0;
					for (BookDto dto : al) {
			%>
			<tr>
				<td><%=++s%></td>
				<td><%=dto.getBname()%></td>
				<td><%=dto.getAname()%></td>
				<td><%=dto.getPname()%></td>
				<td><%=dto.getQuantity()%></td>
				<td><%=dto.getPrice()%></td>
				<td><%=dto.getCname()%></td>
				<td>
				<a href="editBook.jsp?bid=<%=dto.getBid()%>">Edit</a> 
				<a href="viewAllBooks.jsp?bid=<%=dto.getBid()%>&opn=delete">Delete</a>
				</td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			} else {
		%>
		<center>
			<h1>Please Add Book First!</h1>
		</center>
		<%
			}
		%>
	</div>
</body>
</html>