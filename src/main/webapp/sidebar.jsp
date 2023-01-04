<div class="sidebar">
    <h3>Latest Updates:</h3>
    <ul>
        <c:forEach var="latestPost" items="${latestPosts}">
            <li><a href="single?id=${latestPost.id}">${latestPost.title}</a></li>
        </c:forEach>
    </ul>
</div>