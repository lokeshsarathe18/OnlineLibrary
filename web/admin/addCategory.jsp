<%@page import="com.kulchuri.library.category.CategoryDao"%>
<jsp:useBean id="cat" class="com.kulchuri.library.category.CategoryDto"></jsp:useBean>
<jsp:setProperty property="*" name="cat" />
<%
	if (new CategoryDao().addCategory(cat)) {
%>
<jsp:forward page="viewAllCategories.jsp"></jsp:forward>
<%
	} else {
%>
<jsp:forward page="request_category.jsp">
	<jsp:param value="Add Category Failed" name="msg" />
</jsp:forward>
<%
	}
%>