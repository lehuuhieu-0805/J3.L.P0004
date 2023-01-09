<%-- 
    Document   : articles
    Created on : 09-Jan-2023, 16:40:53
    Author     : lehuuhieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Article Page</title>
    </head>
    <body>
        <c:if test="${empty sessionScope.email}">
            <c:redirect url="LogoutController"></c:redirect>
        </c:if>
        <c:if test="${sessionScope.role ne 'memeber'}">
            <c:redirect url="error.jsp"></c:redirect>
        </c:if>

        <h1>Article Page</h1>
        <h3>Welcome ${sessionScope.name}</h3>
        <a href="LogoutController" class="btn btn-link btn-sm">Logout</a>
    </body>
</html>
