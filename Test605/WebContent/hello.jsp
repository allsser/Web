<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page errorPage="error.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%! 
	public int sum(int a, int b){
		return a+b;
	}
%>
<h2> basic jsp </h2>
합계 : <%= sum(11, 99) %>

<%
	int num = 3/0;
%>

</body>
</html>