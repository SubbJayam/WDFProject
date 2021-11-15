<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Update</title>
</head>
<body>
	<h2>Spring MVC Create, Read, Update and Delete (CRUD)  </h2>
	<p><strong>Update Here | <a href="../read">Click for Read</a></strong></p>
<form action="../update" method ="post"  >
<pre>
<c:forEach var="user1" items="${listuser}">
		
Id:    	<input type="text" name="dispId" value="${user1.id}" disabled="disabled"/>  
		<input type="hidden" name="id" value="${user1.id}"/>			
Username:  	<input type="text" name="username" value="${user1.username}" />

Password:  	<input type="text" name="password" value="${user1.password}" />

Firstname: <input type="text" name="firstname" value="${user1.firstname}" />

Lastname: <input type="text" name="lastname" value="${user1.lastname}" />
		
Email: 	<input type="text" name="email" value="${user1.email}" />

Address: <input type="text" name="address" value="${user1.address}" />
	    
phone:	<input type="text" name="phone" value="${user1.phone}" />
		    
        <input type="submit" value="Update" />	
</c:forEach>	
</pre>
</form>
${msg}
</body>
</html>