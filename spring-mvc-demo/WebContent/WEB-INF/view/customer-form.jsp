<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<head>
<title>Customer Form</title>
</head>
<body>
<form:form action="processCustomerForm" modelAttribute="customer">
First name:
<form:input path="firstName"/>
<br><br>
Last name(*): 
<form:input path="lastName"/>
<form:errors path="lastName" cssClass="error" />
<br><br>
Free Passes(*): 
<form:input path="freePasse"/>
<form:errors path="freePasse" cssClass="error" />
<br><br>
Postal code(*): 
<form:input path="postalCode"/>
<form:errors path="postalCode" cssClass="error" />
<br><br>
Course code(*): 
<form:input path="courseCode"/>
<form:errors path="courseCode" cssClass="error" />
<br><br>
<input type="submit" value="Submit"/>
</form:form>
</body>