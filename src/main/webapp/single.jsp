<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.ky.utils.PostExcerpt" %>
<html>
<head>
    <%@include file="head.jsp"%>
    <title>${post.title}</title>
</head>
<body>
<%@include file="header.jsp"%>
<main>
    <div class="container">
        <div class="row">
            <div class="content">
                <div class="post">
                    <h1 class="post-heading">${post.title}</h1>
                   <img class="post-thumb" src="uploads/${post.image}" alt="">
                    <div class="post-body">
                        <p>${post.content}</p>
                    </div>
                </div>
            </div>
            <%@include file="sidebar.jsp"%>
        </div>
    </div>
</main>
</body>
</html>
