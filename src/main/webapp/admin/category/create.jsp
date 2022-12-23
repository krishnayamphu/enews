<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Category</title>
</head>
<body>

<form action="category-create" method="post">
    <label>Name</label>
    <input type="text" name="name" required>
    <label>Description</label>
    <textarea name="description" cols="30" rows="10"></textarea>
    <button>Create</button>
</form>

</body>
</html>
