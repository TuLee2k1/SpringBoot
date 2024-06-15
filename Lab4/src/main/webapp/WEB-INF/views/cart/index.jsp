<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="width: 100%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Amount</th>
			<th></th>
		</tr>
		<c:forEach var="item" items="${cart.items}">
			<form action="/cart/update/${item.id}" method="post">
				<input type="hidden" name="id" value="${item.id}">
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.price}</td>
					<td><input name="qty" value="${item.qty}"
						onblur="this.form.submit()" style="width: 50px;"></td>
					<td>${item.price * item.qty}</td>
					<td><a href="/cart/remove/${item.id}">Remove</a></td>
				</tr>
			</form>
		</c:forEach>
	</table>
	<a href="/cart/clear">Clear Cart</a>
	<a href="/item/index">Add more</a>
	<a href="/cart/add/${item.id}">Add To Cart</a>
			
</body>
</html>