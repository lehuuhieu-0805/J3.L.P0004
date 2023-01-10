<%-- 
    Document   : postArticle
    Created on : 10-Jan-2023, 14:24:18
    Author     : lehuuhieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <title>Post the article</title>
    </head>
    <body>
        <div class="container">
            <h1>Post the article</h1>
            <form action="MainController" method="POST">
                <div class="form-group">
                    <label for="exampleInputTitle">Title</label>
                    <input type="text" class="form-control" id="exampleInputTitle" name="txtTitle" value="${param.txtTitle}" >
                    <small class="form-text text-muted" style="color:red !important">${requestScope.INVALID.titleError}</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputShortDescription">Short Description</label>
                    <input type="text" class="form-control" id="exampleInputShortDescription" name="txtShortDescription" value="${param.txtShortDescription}">
                    <small class="form-text text-muted" style="color:red !important">${requestScope.INVALID.shortDescriptionError}</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputContent">Content</label>
                    <input type="text" class="form-control" id="exampleInputContent" name="txtContent" value="${param.txtContent}">
                    <small class="form-text text-muted" style="color:red !important">${requestScope.INVALID.contentError}</small>
                </div>
                <input type="submit" value="Post" name="action" class="btn btn-primary"/>
            </form>
        </div>
    </body>
</html>
