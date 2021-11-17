<%--
  Created by IntelliJ IDEA.
  User: Mandalorian
  Date: 14.11.2021
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ServletsTask</title>
    <link rel="shortcut icon" href="image/anony.jpg" type="image/x-icon"/>
</head>
<body background="image/place.jpg", style="color:orange", align="center" >
<h5 style="color:greenyellow">GETTING CURRENT ADDRESS </h5>
<h2 style="color:lawngreen">Request from: </h2>
<p> Address: <%= request.getRemoteAddr()%></p>
<p>User-Agent: <%= request.getHeader("User-Agent")%></p>
<br><a href="index.html">Back to Main Page</a>
</body>
</html>
