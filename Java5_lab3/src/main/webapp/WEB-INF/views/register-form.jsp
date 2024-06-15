<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
.error {
	color: red;
}
</style>
<title>Register Page</title>

</head>

<body>
	<div class="container" style="margin-top: 10px;">
		<div class="row"
			style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
			<div class="col-sm-12">
				<h2>Register Account</h2>
				<form:form action="/account/SaveOrUpdate" modelAttribute="ACCOUNT"
					method="post" enctype="multipart/form-data">
					<div class="form-group">
						<div class="alert alert-success"><h4>${message}</h4></div>
						<label>Username</label>
						<form:input type="text" class="form-control" path="username"
							placeholder="Enter Username" />
						<form:errors path="username" cssClass="error"></form:errors>
					</div>
					<div class="form-group">
						<label>Password</label>
						<form:input type="password" class="form-control" path="password"
							placeholder="Enter Password" />
					</div>
					<div class="form-group">
						<label>Full Name</label>
						<form:input type="text" class="form-control" path="fullname"
							placeholder="Enter Full Name" />
					</div>
					<div class="form-group">
						<label>Email</label>
						<form:input type="text" class="form-control" path="email"
							placeholder="Enter Email" />
					</div>
					<div class="form-group">
						<label>Photo</label> <input type="file" class="form-control"
							name="image" accept="image" placeholder="Enter Photo" />
							<p class="error">${ERROR }</p>
					</div>
					<div class="form-group">
						<label>Status</label>
						<div class="checkbox">
							<label> <form:checkbox path="activated" /> Activated
							</label> <label> <form:checkbox path="admin" /> Admin
							</label>
						</div>
					</div>
					<form:button type="submit" class="btn btn-primary">Submit</form:button>
					<form:button type="reset" class="btn btn-primary">Cancel</form:button>
					<a href="/account/views" class="btn btn-primary">Display
						Account</a>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
