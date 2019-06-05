<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>

<link rel="stylesheet" href="./css/table.css">

</head>
<body>

<h1> Book List el</h1>
<table class = "tablea">
<tr>
	<th>BOOKNO</th>
	<th>TITLE</th>
	<th>AUTHOR</th>
	<th>PRICE</th>
	<th>PUBDATE</th>
</tr>

<c:forEach var="book" items="${list}">
<tr>
	<td>${book.bookno}</td>
	<td>${book.title}</td>
	<td>${book.author}</td>
	<td>${book.price}</td>
	<td>${book.pubdate}</td>
</tr>
</c:forEach>

</table>

</body>
</html>