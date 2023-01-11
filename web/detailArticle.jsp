<%-- 
    Document   : detailArticle
    Created on : 11-Jan-2023, 16:03:22
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
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Detail Article</h1>
            <a href="SearchController" class="btn btn-link">Back</a>
            <c:set var="dto" value="${requestScope.DTO}" />
            <c:if test="${not empty dto}" >
                <h4>Title</h4>
                <h6>${dto.title}</h6>
                <h4>Short Description</h4>
                <h6>${dto.shortDescription}</h6>
                <h4>Content</h4>
                <h6>${dto.content}</h6>
                <h4>Author</h4>
                <h6>${dto.userName}</h6>
                <h4>Posting Date</h4>
                <h6>${dto.postingDate}</h6>
                <h4>Comment</h4>
                <h6>Comment</h6>
                <hr/>

                <form action="MainController" method="POST">
                    <div class="form-group">
                        <input type="hidden" name="articleId" value="${dto.id}"/>
                        <input type="text" class="form-control" id="exampleInputDescription" name="txtDescriptionComment" value="${param.txtDescriptionComment}" placeholder="Description comment ...">
                        <small class="form-text text-muted" style="color:red !important">${requestScope.INVALID.descriptionError}</small>
                    </div>
                    <input type="submit" value="Comment" name="action" class="btn btn-primary"/>
                </form>
            </c:if>
            <c:if test="${empty dto}">
                Not found article
            </c:if>
        </div>
    </body>
</html>
