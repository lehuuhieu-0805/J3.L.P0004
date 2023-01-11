<%-- 
    Document   : verify
    Created on : 11-Jan-2023, 23:29:50
    Author     : lehuuhieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <title>Verify Email Page</title>
    </head>
    <body>
        <div class="container">
            <c:if test="${empty requestScope.EMAIL}">
                <c:redirect url="login.jsp"/>
            </c:if>
            <h1>Verify Email Page</h1>
            <h3 style="color: red">We already send a verification code to your email</h3>
            <form action="MainController" method="POST">
                <div class="form-group">
                    <label for="exampleInputCode">Please input your verification code</label>
                    <input type="text" class="form-control" id="exampleInputCode" name="txtCode" value="${param.txtCode}">
                    <input type="hidden" name="email" value="${requestScope.EMAIL}"/>
                    <small class="form-text text-muted" style="color:red !important">${requestScope.INVALID_VERIFY}</small>
                </div>
                <input type="submit" name="action" value="Verify" class="btn btn-primary"/>
            </form>
            <hr>
            <a href="login.jsp" class="btn btn-link">Back to Login Page</a>
        </div>
    </body>
</html>
