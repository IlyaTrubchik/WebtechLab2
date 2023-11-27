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
    <c:choose>
        <c:when test="${not empty sessionScope.role && sessionScope.role eq 'ADMINISTRATOR'}">
            <c:forEach items="${books}" var="book">
                <br>
                <tr>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.genre}</td>
                    <td>${book.price}</td>
                </tr>
                <form action="/books" method="post">
                    <button type="submit" text="Buy">Buy</button>
                    <input type="hidden"   name="book_id" value=${book.id} >
                    <input type = "hidden" name = "command" value = "BUY_BOOK_COMMAND">
                </form>
                <form action="/books" method="post">
                    <button type="submit">Delete</button>
                    <input type="hidden" id="delete_book_id" name="book_id" value=${book.id} >
                    <input type = "hidden" name = "command" value = "DELETE_BOOK_COMMAND">
                </form>
                <form action="/books/edit" method="post">
                    <button type="submit"> Edit book info</button>
                    <input type="hidden" name="command" value="EDIT_BOOK_PAGE_COMMAND">
                    <input type="hidden" name="book_id" value=${book.id}>
                </form>
                <br>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <c:forEach items="${books}" var="book">
                <br>
                <tr>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.genre}</td>
                    <td>${book.price}</td>
                </tr>
                <form action="/books" method="post">
                    <button type="submit" text="Buy">Submit</button>
                    <input type="hidden"   name="book_id" value=${book.id} >
                    <input type = "hidden" name = "command" value = "BUY_BOOK_COMMAND">
                </form>
                <br>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>
</body>
</body>
</html>
