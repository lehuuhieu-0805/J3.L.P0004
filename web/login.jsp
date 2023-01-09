<%-- 
    Document   : login
    Created on : 09-Jan-2023, 16:00:35
    Author     : lehuuhieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <title>Login Page</title>
    </head>
    <body>
        <div class="container" style="text-align: center">
            <h1>Login</h1>
            <hr/>
            <form action="MainController" method="POST">
                <table class="form-group" style="margin-left: auto; margin-right: auto">
                    <tr>
                        <td>Email: </td>
                        <td><input type="text" name="txtEmail" value="${param.txtEmail}" class="form-control"/></td>
                        <td style="color: red">${requestScope.INVALID.emailError}</td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="txtPassword" class="form-control"/></td>
                        <td style="color: red">${requestScope.INVALID.passwordError}</td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" name="action" value="Login" class="btn btn-primary"/></td>
                    </tr>
                </table>
            </form>
            <a href="register.jsp" class="btn btn-link">Register</a>
        </div>
    </body>
</html>
