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
    <title>Title</title>
</head>
<body>
 <h>It's register page</h>
 <form action="/register" method="post">
     <input type="hidden" name="command" value="registration">
         <label >Login</label>
         <input type="text"  id="login" name="login" required>
         <label >Name</label>
         <input type="text"  id="name" name="name" required>
         <label >Phone</label>
         <input type="text"  id="phone" name="phone" required>
         <label >Address</label>
         <input type="text"  id="address" name="address" required>
         <label >Password</label>
         <input type="password"  id="password" name="password" required>
     <input type="hidden" name="operation" value="registration">
     <button type="submit" >Submit</button>
 </form>
</body>
</html>
