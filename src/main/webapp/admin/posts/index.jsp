<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../head.jsp" %>
    <title>All Posts</title>
</head>
<body>
<%@include file="../header.jsp" %>
<main>
    <%@include file="../sidebar.jsp" %>
    <div class="content">
        <h4>All Posts</h4>
        <table>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Category</th>
                <th>Created Date</th>
                <th>Action</th>
            </tr>
            <c:forEach var="post" items="${posts}">
                <tr>
                    <td>${post.id}</td>
                    <td>${post.title}</td>
                    <td>${post.getCategory(post.categoryId)}</td>
                    <td>${post.createdAt}</td>
                    <th>
                        <div class="action-group">
                            <a href="post-edit?id=${post.id}">Edit</a>
                            <form action="posts" method="post">
                                <input type="hidden" name="id" value="${post.id}">
                                <button>Delete</button>
                            </form>
                        </div>
                    </th>
                </tr>
            </c:forEach>
        </table>
    </div>
</main>
</body>
</html>
