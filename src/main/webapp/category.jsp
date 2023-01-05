<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.ky.utils.PostExcerpt" %>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>Enews | Category</title>
</head>
<body>
<%@include file="header.jsp" %>
<main>
    <div class="container">
        <div class="row">
            <div class="content">
                <c:forEach var="post" items="${categoryPosts}">
                    <div class="post-list">
                        <a href="single?id=${post.id}"><img class="post-thumb" src="uploads/${post.image}" alt=""></a>
                        <div class="post-body">
                            <h3 class="post-heading"><a href="single?id=${post.id}">${post.title}</a></h3>
                            <p>${PostExcerpt.getExcerpt(post.content,100)}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <%@include file="sidebar.jsp" %>
        </div>
    </div>
</main>
</body>
</html>
