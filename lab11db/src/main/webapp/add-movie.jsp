<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>MOVIES_DB</title>
    <link rel="shortcut icon" href="image/movie.png" type="image/x-icon"/>
</head>
<body style="background-color:black;color:deeppink" align="center">
<h1><%= "Adding movie" %>
</h1>
<br/>
<form method="post" action="addMovie" autocomplete="off">
    <label for="title">What's title?</label><br>
    <input type="text" id="title" name="title"><br>
    <label for="director">What's director name?</label><br>
    <input type="text" id="director" name="director"><br><br>
    <label for="year">in which year was created?</label><br>
    <input type="text" id="year" name="year"><br><br>
    <label for="rate">What's average rate?</label><br>
    <input type="text" id="rate" name="rate"><br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>