<%@page isELIgnored="false"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0;
	padding: 0;
}

nav {
	width: 100%;
	height: 60px;
	border: 2px solid black;
	display: flex;
	justify-content: end;
	align-items: center;
}

nav a {
	border: 2px solid black;
	height: 60px;
	width: 60px;
	border-radius: 50%;
	padding-left: -100px;
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>
	<h3 align="center" style="color: green">${pos}</h3>
	<h3 align="center" style="color: red">${neg}</h3>
	<nav>
		<a href="logout"><button class="">Logout</button></a>
	</nav>
	<h1 align="center">Home Page</h1>
	<div>
		<table>
			<tr>
				<th>task Name</th>
				<th>task Descripton</th>
				<th>Created Time</th>
				<th>Status</th>
				<th>Delete</th>
				<th>Edit</th>
			</tr>
	<jstl:forEach var="task" items="${tasks}">
			<tr>
				<th>${task.name}</th>
				<th>${task.description}</th>
				<th>${task.createdTime }</th>
				<jstl:if test="${task.status}">
				<th>Completed</th>
				</jstl:if>
				<jstl:if test="${!task.status}">
				<th><a href="complete?id=${task.id}"><button>Complete</button></a></th>
				</jstl:if>
				
				<th><a href="delete?id=${task.id}"><button>delete</button></a></th>
				<th><a
					href="edit-task?id=${task.id}&name=${task.name}&description=${task.description}"><button>Edit</button></a></th>
			</tr>
	</jstl:forEach>
		</table>
	</div>
	<a href="add-task"><button class="extra">add tasks</button></a>

</body>
</html>