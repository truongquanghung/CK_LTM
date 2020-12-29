<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
img {
	max-width: 100%;
}
</style>
</head>
<body>
	<form name="f1" action="xulianh" method="post" enctype="multipart/form-data">
		<h2 align="center">Chuyển đổi thành ảnh đơn sắc</h2>
		<p align="center">
			<input type="file" name="anh" accept="image/*"> <input
				type="submit" name="s1" value="Xử lí ảnh">
			<%
				if (request.getAttribute("imageAsBase64") != null) {
			%>
		
		<h3 align="center">Ảnh sau đổi:</h3>
		
		<p align="center">
			<img src="data:image/jpg;base64,${imageAsBase64}" />
		</p>
		<%
			}
		%>
	</form>
</body>
</html>