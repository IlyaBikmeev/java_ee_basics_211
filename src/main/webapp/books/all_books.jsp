<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 12.04.2023
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All books</title>

    <style>
        table, tr, td {
            border: 1px solid black
        }
    </style>
</head>
<body>

    <h1>All books:</h1>

    <table>
        <tr>
            <th>name</th>
            <th>author</th>
            <th>price</th>
        </tr>
        <c:forEach items="${requestScope.allBooks}" var="book">
            <tr>
                <td><c:out value="${book.name}"/></td>
                <td><c:out value="${book.author}"/></td>
                <td><c:out value="${book.price}"/></td>
            </tr>
        </c:forEach>
    </table>

    <a href="/books/create">CREATE NEW BOOK</a>
</body>
</html>
