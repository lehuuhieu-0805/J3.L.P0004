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
        <div class="container">
            <h1>Article Page</h1>
            <c:if test="${not empty sessionScope.name}">
                <h3>Welcome ${sessionScope.name}</h3>
                <a href="LogoutController" class="btn btn-link btn-sm">Logout</a>
                <a href="postArticle.jsp" class="btn btn-primary">Post the article</a>
            </c:if>
            <c:if test="${empty sessionScope.name}">
                <a href="login.jsp" class="btn btn-primary">Login</a>
            </c:if>

            <form action="MainController" style="margin-top: 20px">
                <div class="form-group">
                    <label for="exampleInputContent">Search by content</label>
                    <input type="text" class="form-control" id="exampleInputContent" name="txtSearchContent" value="${param.txtSearchContent}" >
                </div>

                <input type="submit" value="Search" name="action" class="btn btn-primary"/>
            </form>

            <c:set var="searchContent" value="${param.txtSearchContent}"/>
            <%--<c:if test="${not empty searchContent}">--%>
            <c:set var="result" value="${requestScope.SEARCH_RESULT}"/>
            <c:if test="${not empty result}">
                <table class="table table-bordered" style="margin-top: 20px">
                    <thead>
                        <tr>
                            <th scope="col">No.</th>
                            <th scope="col">Title</th>
                            <th scope="col">Short Description</th>
                            <th scope="col">Author</th>
                            <th scope="col">Posting Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter" >
                            <tr>
                                <th scope="row">${counter.count}</th>
                                <td onmouseover="this.style='cursor: pointer'" onclick="location.href='DetailArticleController?id=${dto.id}'">${dto.title}</td>
                                <td>${dto.shortDescription}</td>
                                <td>${dto.userName}</td>
                                <td>${dto.postingDate}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-end">
                        <c:forEach begin="1" end="${requestScope.END_PAGE}" var="i">
                            <li class="page-item ${requestScope.CURRENT_PAGE == i ? "active" : ""}">
                                <a class="page-link" href="SearchController?page=${i}">${i}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </nav>
            </c:if>
            <c:if test="${empty result}">
                <h2>No record found</h2>
            </c:if>
            <%--</c:if>--%>


        </div>

        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        ...
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
