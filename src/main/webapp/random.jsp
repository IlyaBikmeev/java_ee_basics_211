<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 12.04.2023
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="java.util.Random" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .random {
            background: darkmagenta;
            color: whitesmoke;
            width: 2rem;
            padding: 1rem;
        }
        ul {
            list-style-type: none;
        }
    </style>
</head>
<body>

<div>
    <h2>Your random numbers are: </h2>

    <ul>
        <c:forEach var="i" begin="1" end="10">
            <li>
                <div class="random">
                    <c:out value="${requestScope.random.nextInt(100)}"/>
                </div>
            </li>
        </c:forEach>
    </ul>

</div>
</body>
</html>
