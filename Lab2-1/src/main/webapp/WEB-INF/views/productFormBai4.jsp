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
<form action="/product-save" method="post">
  <input name="name" value="${product.name}">
  <input name="price" value="${product.price}">
  <button>Save</button>
</form>

<ul>
  <li>${product.name}</li>
  <li>${product.price}</li>
</ul>

<ul>
  <c:forEach var="item" items="${products}">
    <li>Name: ${item.name}</li>
    <li>Price: ${item.price}</li>
  </c:forEach>
</ul>
</body>
</html>