<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="/student/save-with-validation" modelAttribute="sv">
	<label>Name:</label>
	<form:input path="name" placeholder="Name" />
	<form:errors path="name" />

	<label>Email:</label>
	<form:input path="email" placeholder="Email" />
	<form:errors path="email" />

	<label>Marks:</label>
	<form:input path="marks" placeholder="Marks" />
	<form:errors path="marks" />

	<label>Gender:</label>
	<form:radiobuttons items="${genders}" path="gender" />
	<form:errors path="gender" />

	<label>Faculty:</label>
	<form:select path="faculty">
		<form:option value="CNTT">CNTT</form:option>
		<form:option value="DLNHKS">DLNHKS</form:option>
		<form:option value="QTDN">QTDN</form:option>
	</form:select>
	<form:errors path="faculty" />

	<label>Hobbies:</label>
	<form:checkboxes items="${hobbies}" path="hobbies" />
	<form:errors path="hobbies" />

	<button type="submit">Save</button>

	<c:if test="${not empty message}">
		<div>${message}</div>
	</c:if>

</form:form>

</body>
</html>
