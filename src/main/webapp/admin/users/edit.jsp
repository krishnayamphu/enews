<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>

<div class="user-form">
    <form action="user-edit" method="post">
        <label>Username</label>
        <input type="text" name="username"  value="${user.username}" required>
        <label>Email</label>
        <input type="email" name="email" value="${user.email}" required>
        <label>Password</label>
        <input type="password" name="password" value="${user.password}" required>
        <button>update</button>
    </form>
</div>

</body>
</html>
