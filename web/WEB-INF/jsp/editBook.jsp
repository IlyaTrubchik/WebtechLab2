<%--
  Created by IntelliJ IDEA.
  User: Ilya
  Date: 27.11.2023
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
        <c:set var="book" value="${requestScope.book}"></c:set>
        <form action="/book/edit" method="post">
            <input type="hidden" name="command" value="CONFIRM_BOOK_EDIT_COMMAND">
            <input type="text" name="title" value="${book.title}" required>
            <input type="text" name="author" value="${book.author}" required>
            <input type="text" name="description" value="${book.description}" required>
            <input type="text" name="genre" value="${book.genre}" required>
            <input type="text" name="price" value="${book.price}" required>
            <input type="date" name="publicationDate" value="${book.publicationDate}" required>
            <input type="hidden" name="book_id" value="${book.id}">
            <<button type="submit"> Confirm changes </button>
        </form>
</body>
</html>
