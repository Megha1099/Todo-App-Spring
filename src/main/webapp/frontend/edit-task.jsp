<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Task</title>
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
	<h3 align="center" style=" color:green">${pos}</h3>
<h3 align="center" style=" color:red">${neg}</h3>
		<h1>Edit Task</h1>
		<form action="update-task" method="post">
		<input type="hidden" name="id" value="<%=request.getParameter("id")%>" >
			<fieldset>
				<legend>Enter Task here,</legend>
				<table>
					<tr>
						<th>Task Name:</th>
						<th><input type="text" name="name" value="<%=request.getParameter("name")%>"></th>
					</tr>
					<tr>
						<th>Task Description:</th>
						<th><input type="text" name="description" value="<%=request.getParameter("description")%>"></th>
					</tr>
					<tr>
						<th><button>Update</button></th>
						<th><button type="reset">Cancel</button></th>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>