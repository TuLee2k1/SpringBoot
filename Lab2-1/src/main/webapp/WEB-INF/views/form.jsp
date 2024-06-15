<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/param/save/2021" method="post">
		<input name="y" value="2031">
		<button>Save</button>
	</form>
	<ul>
		<li>${x}</li>
		<li>${y}</li>
	</ul>
</body>
</html>