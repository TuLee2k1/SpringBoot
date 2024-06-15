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
	<ul>
		<c:forEach var="item" items="${items}">
			<li>${item.name} (${item.price}) :: [<a
				href="/cart/add/${item.id}">Add To Cart</a>]
			</li>
		</c:forEach>
	</ul>
</body>
</html>