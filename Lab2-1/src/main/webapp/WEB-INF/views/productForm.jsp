<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/product/save" method="post">
		<input name="name">
		<input name="price">
		<button>Save</button>
	</form>
	<ul>
		<li>${name }</li>
		<li>${price }</li>
	</ul>
	
</body>
</html>