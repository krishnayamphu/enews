<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../head.jsp" %>
    <title>User Registration</title>
</head>
<body>

<div class="register-form">
    <h4>User Registration</h4>
    <form action="register" method="post">
        <label>Username</label>
        <input type="text" name="username" required>
        <label>Email</label>
        <input type="email" name="email" required>
        <label>Password</label>
        <input type="password" name="password" required>
        <button>Register</button>
    </form>
</div>

</body>
</html>
