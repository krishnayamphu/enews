<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../head.jsp" %>
    <title>Category Details</title>
</head>
<body>
<%@include file="../header.jsp" %>
<main>
    <%@include file="../sidebar.jsp" %>
    <div class="content">
        <h4>Post Details</h4>
        <form action="post-edit" method="post">
            <input type="hidden" name="id" value="${post.id}">
            <label>Post Title</label>
            <input type="text" name="title" value="${post.title}" required>
            <label>Content</label>
            <textarea name="content" cols="30" rows="10">${post.content}</textarea>
            <lable>Category</lable>
            <select name="category">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}" ${category.id==post.categoryId?'selected':''}>${category.name}</option>
                </c:forEach>
            </select>
            <label>Image</label>
            <button>Set Image</button>
            <input type="text" name="image" value="${post.image}">
            <button>update</button>
        </form>
    </div>
</main>
</body>
</html>
