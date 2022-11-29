<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>all users</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body class="container">
    <a href="?mylocale=en_US">English </a> | <a href="?mylocale=fr_FR">Francais </a> | <a href="?mylocale=ar_EG">العربية </a>
<table class="table">
    <thead class="table table-dark">
    <tr>
        <td><spring:message code="user.firstName"/></td>
        <td><spring:message code="user.lastName"/></td>
        <td><spring:message code="user.salary"/></td>
    </tr>
    </thead>
    <tbody>
    <c:if test="${!empty users}">
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.salary}</td>
            </tr>
        </c:forEach>

    </c:if>
    </tbody>

</table>
</body>
</html>
