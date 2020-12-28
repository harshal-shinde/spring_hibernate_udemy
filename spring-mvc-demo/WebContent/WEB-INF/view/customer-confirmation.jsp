<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<HTML>
	<HEAD><title> Customer Confirmation</title></HEAD>
	<BODY>
		The customer is confirmed :${customer.firstName} ${customer.lastName}
		
		<br><br>
		
		Free passes : ${customer.freePasses}
		<br><br>
		
		Postal code : ${customer.postalCode}
		<br><br>
		
		Course code : ${customer.courseCode}
		<br><br>
	</BODY>
</HTML>	
	