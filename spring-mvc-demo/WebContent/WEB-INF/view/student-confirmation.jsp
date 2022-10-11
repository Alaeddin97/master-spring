<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Form</title>
</head>
<body>
	The student is confirmed: ${student.firstName } ${student.lastName }
	<br> Country: ${student.country }
	<br> Favorite language: ${student.favoriteLanguage }
	<br> Operating Systems:
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems }">
			<li>${temp }</li>
		</c:forEach>
	</ul>
	${student.operatingSystems }
</body>
</html>