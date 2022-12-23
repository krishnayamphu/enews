<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Posts</title>
</head>
<body>

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
            <th><a href="post-edit?id=${post.id}">Edit</a>
                <form action="posts" method="post">
                    <input type="hidden" name="id" value="${post.id}">
                    <button>Delete</button>
                </form>
            </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
