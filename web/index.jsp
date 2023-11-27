<%--
  Created by IntelliJ IDEA.
  User: Ilya
  Date: 14.11.2023
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <form action="/register" method="post">
         <input type="hidden" name="command" value="REGISTRATION_PAGE_COMMAND">
         <button type="submit"> Registration </button>
      </form>
      <form action="/login" method="post">
        <input type="hidden" name="command" value="AUTHORIZATION_PAGE_COMMAND">
        <button type="submit"> Authorization </button>
      </form>
      <form action="/books" method="post">
        <input type="hidden" name="command" value="VIEW_BOOKS_COMMAND">
        <button type="submit"> Books </button>
      </form>
  </body>
</html>
