<%--
  Created by IntelliJ IDEA.
  User: Ilya
  Date: 14.11.2023
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogIn</title>
</head>
<body>
<h>It's login page</h>
<form action="/login" method="post">
    <input type="hidden" id="command" name="command" value="AUTHORIZATION_COMMAND">
    <label >Email</label>
    <input type="text"  id="login" name="login" required>
    <label >Password</label>
    <input type="password"  id="password" name="password" required>
    <input type="hidden" name="operation" value="login">
    <button type="submit" href="/books" >Submit</button>
</form>
</body>
</html>
