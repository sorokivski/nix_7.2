<%--
  Created by IntelliJ IDEA.
  User: Mandalorian
  Date: 17.11.2021
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>MOVIES_DB</title>
    <link rel="shortcut icon" href="image/movie.png" type="image/x-icon"/>
</head>
<body style="background-color:black;color:darkmagenta" align="center">
<h1><%= "LOOKING FOR MOVIE" %>
</h1>
<br/>
<form method="get" action="findMovie" autocomplete="off">
    <label for="title">What's title?</label><br>
    <input type="text" id="title" name="title"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>