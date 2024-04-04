<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<style>
		div {
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
		}
	</style>
</head>

<body>
	<div>
		<h1>Todo Login</h1>
		<th><h5 style="color:green">${msg}</h5></th>
		<form action="login" method="post">
			<fieldset>
				<legend>Login here,</legend>
				
				<table>
					<tr>
						<th>Email: </th>
						<th><input type="email" name="email"></th>
					</tr>
					<tr>
						<th>Password: </th>
						<th><input type="password" name="password"></th>
					</tr>
					<tr>
						<th><button>Login</button></th>
						<th><button type="reset">Cancel</button></th>
					</tr>
					<tr>
						<th colspan="2"><a href="signup"><button type="button">Click to Create Account</button></a></th>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>

</html>