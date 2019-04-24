<%@page import="com.kulchuri.library.book.BookDto"%>
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
		if (new BookDao().updateBook(bdto)) {
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
		<center>
			<h1 style="color: white;">Update Book Form</h1>
		</center>
		<%
			String bid = request.getParameter("bid");
			BookDto bookDto = new BookDao().getBook(Integer.parseInt(bid.trim()));
			ArrayList<CategoryDto> al = new CategoryDao().getAllCategories();
			if (al != null) {
		%>
		<form action="editBook.jsp" method="post"
			style="width: 50%; margin-left: 25%">
			<input type="hidden" name="bid" value="<%=bid%>"> <select
				name="cid">
				<option value="<%=bookDto.getCid()%>"><%=bookDto.getCname()%></option>
				<%
					for (CategoryDto dto : al) {
							if (!dto.getCname().equalsIgnoreCase(bookDto.getCname())) {
				%>
				<option value="<%=dto.getCid()%>"><%=dto.getCname()%></option>
				<%
					}
						}
				%>
			</select> <span style="color: white;">Book Name</span> <input type="text"
				value="<%=bookDto.getBname()%>" name="bname"
				placeholder="Enter book name"> <span style="color: white;">Author
				Name</span> <input type="text" value="<%=bookDto.getAname()%>" name="aname"
				placeholder="Enter authour name"> <span
				style="color: white;">Publication Name</span> <input type="text"
				value="<%=bookDto.getPname()%>" name="pname"
				placeholder="Enter publication name"> <span
				style="color: white;">Book Edition</span> <input type="text"
				value="<%=bookDto.getEdition()%>" name="edition"
				placeholder="Enter book edition"> <span
				style="color: white;">Book Quantity</span> <input type="text"
				value="<%=bookDto.getQuantity()%>" name="quantity"
				placeholder="Enter book quantity"> <span
				style="color: white;">Book Price</span> <input type="text"
				value="<%=bookDto.getPrice()%>" name="price"
				placeholder="Enter book price"> <input type="submit"
				value="Update">
		</form>
		<%
			} else {
		%>
		<center>
			<h1 style="color: red">Please Select Book First</h1>
		</center>
		<%
			}
		%>
	</div>
</body>
</html>
