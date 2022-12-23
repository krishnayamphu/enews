<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category Details</title>
</head>
<body>

<form action="category-edit" method="post">
    <input type="hidden" name="id" value="${category.id}">
    <label>Name</label>
    <input type="text" name="name" value="${category.name}" required>
    <label>Description</label>
    <textarea name="description" cols="30" rows="10">${category.description}</textarea>
    <button>Update</button>
</form>

</body>
</html>
