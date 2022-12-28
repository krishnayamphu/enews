<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../head.jsp" %>
    <title>New Post</title>
</head>
<body>
<%@include file="../header.jsp" %>
<main>
    <%@include file="../sidebar.jsp" %>
    <div class="content">
        <form action="post-create" method="post">
            <label>Post Title</label>
            <input type="text" name="title" required>
            <label>Content</label>
            <textarea name="content" cols="30" rows="10"></textarea>
            <lable>Category</lable>
            <select name="category">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
            <label>Image</label>
            <button>Set Image</button>
            <input type="text" name="image">
            <button>Create</button>
        </form>
    </div>
</main>
</body>
</html>
