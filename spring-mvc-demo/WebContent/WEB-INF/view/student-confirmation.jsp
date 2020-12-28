<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<HTML>
	<HEAD> <title> Student Confirmation</title>
	</HEAD>
	<BODY>
		The student is confirmed :${student.firstName} ${student.lastName}  
	
	<br><br>
	
	Country  : ${student.country}
	
	<br><br>
	
	Favorite Language : ${student.favoriteLanguage}
	
	<br><br>
	Operating System
	
	<ul>
		<c:forEach var="temp" items="${student.operatingsystems}">
			<li> ${temp }</li>
		</c:forEach>
	</ul>	
	<br><br>
	</BODY>
</HTML>	
	