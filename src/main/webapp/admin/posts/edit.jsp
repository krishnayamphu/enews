<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../head.jsp" %>
    <title>Post Details</title>
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
            <button type="button" onclick="openMedia()">Set Image</button>
            <img class="${post.image!=''?'d-none':''}" id="postThumb"  src="uploads/${post.image}" alt="${post.image}">
            <input type="hidden" id="postImage" name="image" value="${post.image}">
            <button>update</button>
            <div id="mediaOverlay" class="media-overlay">
                <div class="media-container media-wrap">
                    <button class="btn-close" type="button" onclick="closeMedia()">Close</button>
                    <c:forEach var="item" items="${files}">
                        <div class="media-card">
                            <img onclick="setImage('${item}')" src="uploads/${item}" alt="${item}">
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
        </form>
    </div>
</main>

<script>
    function setImage(filename){
        document.getElementById("postImage").value=filename;
        document.getElementById("postThumb").src="uploads/"+filename;
        closeMedia();
    }
    function closeMedia(){
        document.getElementById("mediaOverlay").style.display="none";
    }
    function openMedia(){
        document.getElementById("mediaOverlay").style.display="flex";
    }
</script>
</body>
</html>
