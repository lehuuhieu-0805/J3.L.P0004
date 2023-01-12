<%-- 
    Document   : articlesForAdmin
    Created on : 11-Jan-2023, 20:38:17
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
        <title>Article Admin</title>
    </head>
    <body>
        <div class="container">
            <h1>List Article</h1>

            <c:if test="${not empty sessionScope.name}">
                <h3>Welcome ${sessionScope.name}</h3>
                <a href="LogoutController" class="btn btn-link btn-sm">Logout</a>
            </c:if>
            <c:if test="${empty sessionScope.email}">
                <c:redirect url="LogoutController"></c:redirect>
            </c:if>
            <c:if test="${sessionScope.role ne 'admin'}">
                <c:redirect url="error.jsp"></c:redirect>
            </c:if>

            <form action="MainController" style="margin-top: 20px">
                <div class="row">
                    <div class="form-group col-8">
                        <input type="text" class="form-control" id="exampleInputContent" name="txtSearchContent" value="${param.txtSearchContent}" placeholder="Search by content" >
                    </div>
                    <div class="col-4">
                        <select class="custom-select" name="selectStatusPosting">
                            <option ${requestScope.STATUS eq 'Choose status posting' ? 'selected' : ''}>Choose status posting</option>
                            <option ${requestScope.STATUS eq 'New' ? 'selected' : ''} value="New">New</option>
                            <option ${requestScope.STATUS eq 'Active' ? 'selected' : ''} value="Active">Active</option>
                            <option ${requestScope.STATUS eq 'Deleted' ? 'selected' : ''} value="Deleted">Deleted</option>
                        </select>
                    </div>
                </div>

                <input type="submit" value="Search Article" name="action" class="btn btn-primary"/>
            </form>

            <c:set var="result" value="${requestScope.LIST_ARTICLES}"/>
            <c:if test="${not empty result}">
                <table class="table table-bordered" style="margin-top: 20px">
                    <thead>
                        <tr>
                            <th scope="col">No.</th>
                            <th scope="col">Title</th>
                            <th scope="col">Short Description</th>
                            <th scope="col">Content</th>
                            <th scope="col">Author</th>
                            <th scope="col">Posting Date</th>
                            <th scope="col">Status</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter" >
                            <tr>
                                <th scope="row">${counter.count}</th>
                                <td>${dto.title}</td>
                                <td>${dto.shortDescription}</td>
                                <td>${dto.content}</td>
                                <td>${dto.userName}</td>
                                <td>${dto.postingDate}</td>
                                <td>${dto.status}</td>
                                <td>
                                    <c:if test="${dto.status eq 'New'}">
                                        <a href="ApproveArticleController?id=${dto.id}" class="btn btn-primary">Approve</a>
                                        <a href="DeleteArticleController?id=${dto.id}" class="btn btn-link">Delete</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-end">
                        <c:forEach begin="1" end="${requestScope.END_PAGE}" var="i">
                            <li class="page-item ${requestScope.CURRENT_PAGE == i ? "active" : ""}">
                                <a class="page-link" href="SearchArticleController?page=${i}">${i}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </nav>
            </c:if>
            <c:if test="${empty result}">
                <h2>No record found</h2>
            </c:if>
        </div>


    </body>
</html>
