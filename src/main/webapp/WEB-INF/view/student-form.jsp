<%--
  Created by IntelliJ IDEA.
  User: tautv
  Date: 2/10/2023
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Student registration form</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">

  First name: <form:input path="firstName"/>
  <br><br>
  Last name: <form:input path="lastName"/>
  <br><br>
    <form:select path="country">

        <form:options items="${student.optionsOfCountry}"/>

    </form:select>
  <br><br>
    Java <form:radiobutton path="favoriteLanguage" value="Java" />
    C# <form:radiobutton path="favoriteLanguage" value="C#" />
    PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
    Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />


  <br><br>
  Linux <form:checkbox path="operatingSystem" value="Linux"/>
  Mac OS <form:checkbox path="operatingSystem" value="Mac OS"/>
  MS Windows <form:checkbox path="operatingSystem" value="MS Window"/>
  <br><br>
<input type="submit" value="Submit"/>

</body>
</html>
