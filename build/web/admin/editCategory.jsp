<%@page import="com.kulchuri.library.category.CategoryDto"%>
<%@page import="com.kulchuri.library.category.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library:Category</title>
<jsp:include page="/design/head.html"></jsp:include>
<jsp:useBean id="dto1" class="com.kulchuri.library.category.CategoryDto"></jsp:useBean>
<jsp:setProperty property="*" name="dto1" />
</head>
<body>
    <jsp:include page="/design/admin_header.jsp"></jsp:include>
	<jsp:include page="/design/admin_menu.html"></jsp:include>
	<div>
		<%
			CategoryDao dao = new CategoryDao();
			if (request.getMethod().equalsIgnoreCase("post")) {
				if (dao.updateCategory(dto1)) {
		%>
		<jsp:forward page="viewAllCategories.jsp"></jsp:forward>
		<%
			}
			}

			String cid = request.getParameter("cid1");
			if (cid != null) {
				CategoryDto dto = dao.getCategory(Integer.parseInt(cid));
		%>
		<center>
			<h1 style="color: white;">Update Category Form</h1>
		</center>

		<form action="editCategory.jsp" method="post"
			style="width: 30%; margin-left: 35%">
			<input type="hidden" value="<%=dto.getCid()%>" name="cid"> <input
				type="text" name="cname" value="<%=dto.getCname()%>"
				placeholder="Enter Category" autofocus="true" /> <input
				type="submit" value="Update" />
		</form>
		<%
			} else {
		%>
		<center>
			<a href="viewAllCategories.jsp">Please Select Category for Update</a>
		</center>
		<%
			}
		%>
	</div>
</body>
</html>