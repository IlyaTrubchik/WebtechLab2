<%--
  Created by IntelliJ IDEA.
  User: Ilya
  Date: 21.11.2023
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<body>
<h1>Books</h1>
    <div>
        <c:forEach items="${books}" var="book">
            <br>
            <tr>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.genre}</td>
                <td>${book.price}</td>
            </tr>
                <form action="/books?command=orderBook" method="post">
                    <button type="submit" text="Buy">Submit</button>
                    <input type="hidden"  id="book_id" name="book_id" value=${book.id} >
                </form>
            <br>
        </c:forEach>
    </div>
</body>
</body>
</html>
