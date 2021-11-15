<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Read</title>
</head>
<body>
	<h2>Spring MVC Create, Read, Update and Delete (CRUD)  </h2>
	<p><strong>user List is Here | <a href="./register">Click for Create</a></strong></p>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>UserName</th>
			<th>Password</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Action</th>
		</tr>
		<c:forEach var="user" items="${listuser}">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td>${user.firstname}</td>
				<td>${user.lastname}</td>
				<td>${user.email}</td>
				<td>${user.address}</td>
				<td>${user.phone}</td>
				<td><a href="update/<c:out value='${user.id}'/>">Update</a> | <a
					href="delete/<c:out value='${user.id}'/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>