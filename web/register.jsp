<%-- 
    Document   : register
    Created on : 09-Jan-2023, 15:07:18
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
        <title>Register Page</title>
    </head>
    <body>
        <div class="container" style="text-align: center">
            <h1>Register</h1>
            <hr/>
            <form action="MainController" method="POST">
                <table class="form-group" style="margin-left: auto; margin-right: auto">
                    <tr>
                        <td>Email: </td>
                        <td><input type="text" name="txtEmail" value="${param.txtEmail}" class="form-control"/></td>
                        <td style="color: red">${requestScope.INVALID.emailError}</td>
                    </tr>
                    <tr>
                        <td>Name: </td>
                        <td><input type="text" name="txtName" value="${param.txtName}" class="form-control"/></td>
                        <td style="color: red">${requestScope.INVALID.nameError}</td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="txtPassword" class="form-control"/></td>
                        <td style="color: red">${requestScope.INVALID.passwordError}</td>
                    </tr>
                    <tr>
                        <td>Confirm Password: </td>
                        <td><input type="password" name="txtConfirmPassword" class="form-control"/></td>
                        <td style="color: red">${requestScope.INVALID.confirmPasswordError}</td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" name="action" value="Register" class="btn btn-primary"/></td>
                    </tr>
                </table>
            </form>
            <a href="login.jsp" class="btn btn-link">Login</a>
        </div>
    </body>
</html>
