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
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <title>Article Page</title>
    </head>
    <body>
        <c:if test="${empty sessionScope.email}">
            <c:redirect url="LogoutController"></c:redirect>
        </c:if>
        <c:if test="${sessionScope.role ne 'member'}">
            <c:redirect url="error.jsp"></c:redirect>
        </c:if>

        <h1>Article Page</h1>
        <h3>Welcome ${sessionScope.name}</h3>
        <a href="LogoutController" class="btn btn-link btn-sm">Logout</a>
        <a href="postArticle.jsp" class="btn btn-primary">Post the article</a>
    </body>
</html>
