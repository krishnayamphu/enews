<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../head.jsp" %>
    <title>All Media Files</title>
</head>
<body>
<%@include file="../header.jsp" %>
<main>
    <%@include file="../sidebar.jsp" %>
    <div class="content">
        <form class="media-upload" action="media" method="post" enctype="multipart/form-data">
            <label>Upload:</label>
            <input type="file" name="upload">
            <button type="submit">Upload</button>
        </form>
        <hr>
        <h4>All Media Files</h4>
        <div class="media-container">
            <c:forEach var="item" items="${files}">
                <div class="media-card">
                    <img height="100" width="100" src="uploads/${item}" alt="${item}">
                    <div class="media-action">
                        <a href="uploads/${item}">View</a>
                        <form action="media-del" method="post">
                            <input type="hidden" name="media" value="${item}">
                            <button type="submit">Delete</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</main>
</body>
</html>
