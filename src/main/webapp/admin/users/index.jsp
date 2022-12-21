<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Users</title>
</head>
<body>

<table>
    <tr>
        <th>#ID</th>
        <th>Username</th>
        <th>Email</th>
        <th>Photo</th>
        <th>Created Date</th>
        <th>Action</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.photo}</td>
            <td>${user.createdAt}</td>
            <td>
                <a href="user-edit?id=${user.id}">edit</a>
                <form action="users" method="post">
                    <input type="hidden" name="id" value="${user.id}">;
                    <button>Remove</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
