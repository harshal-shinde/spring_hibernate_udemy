<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<HTML>
	<HEAD>
	</HEAD>
	<BODY>
		<form:form action="processForm" modelAttribute="student"> 
		First Name : <form:input path="firstName"/>
		<br><br>
		
		Last Name : <form:input path="lastName"/>
		<br><br>
		<form:select path="country"> 
			<form:options items="${student.countryOptions}"/>
		
		</form:select>
		
		<br><br>
		
		
		Favorite Language :
		
		Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		C# <form:radiobutton path="favoriteLanguage" value="C#"/>
		PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
		
		<br><br>
		Operating System :
		
		Linux <form:checkbox path="operatingsystems"  value= "Linux"/>
		Mac OS <form:checkbox path="operatingsystems"  value= "Mac OS"/>
		Windows <form:checkbox path="operatingsystems"  value= "Windows"/>
		
		
		<br><br>
			
		<input type="submit"  value="Submit"/>
		
		</form:form>
	
	
	</BODY>


</HTML>

