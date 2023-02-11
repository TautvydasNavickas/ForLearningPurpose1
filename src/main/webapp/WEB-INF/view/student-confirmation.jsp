<%--
  Created by IntelliJ IDEA.
  User: tautv
  Date: 2/11/2023
  Time: 12:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>

The student is confirmed: ${student.firstName} ${student.lastName}
<br>

Country: ${student.country}
Language: ${student.favoriteLanguage}
<br><br>
<ul>
    <c:forEach var="temp" items="${student.operatingSystem}">
    <li>${temp}</li>
    </c:forEach>
</ul>
</body>
</html>
