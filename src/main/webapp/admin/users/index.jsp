<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../head.jsp" %>
    <title>All Users</title>
</head>
<body>
<%@include file="../header.jsp" %>
<main>
    <%@include file="../sidebar.jsp" %>
    <div class="content">
        <h4>User Users</h4>
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
                        <div class="action-group">
                            <a href="user-edit?id=${user.id}">edit</a>
                            <form action="users" method="post">
                                <input type="hidden" name="id" value="${user.id}">
                                <button>Remove</button>
                            </form>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</main>
</body>
</html>
