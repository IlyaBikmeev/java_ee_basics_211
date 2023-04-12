<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 12.04.2023
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create book</title>
</head>
<body>
    <form action="/books" method="post">
        <div>Name:<input type="text" name="name" id="name"></div>
        <div>Author:<input type="text" name="author" id="author"></div>
        <div>Price:<input type="text" name="price" id="price"></div>
        <input type="submit" value="Create">
    </form>

    <a href="/books">RETURN BACK TO BOOKS</a>
</body>
</html>
