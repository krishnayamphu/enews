<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../head.jsp" %>
    <title>User Registration</title>
</head>
<body>
<%@include file="../header.jsp" %>
<main>
    <%@include file="../sidebar.jsp" %>
    <div class="content">
        <div class="user-form">
            <form action="user-edit" method="post">
                <input type="hidden" name="id" value="${user.id}">
                <label>Username</label>
                <input type="text" name="username"  value="${user.username}" required>
                <label>Email</label>
                <input type="email" name="email" value="${user.email}" required>
                <label>Password</label>
                <input type="password" name="password" value="${user.password}" required>
                <button>update</button>
            </form>
        </div>
    </div>
</main>
</body>
</html>
