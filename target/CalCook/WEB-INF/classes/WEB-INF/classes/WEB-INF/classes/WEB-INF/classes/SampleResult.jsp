<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% String id = (String)request.getAttribute("id"); %>
<% String pass = (String)request.getAttribute("pass"); %>
<% String ErrorMsg = (String)request.getAttribute("errmsg"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<% if(ErrorMsg != ""){
	if(ErrorMsg == null){
		ErrorMsg = "";
	}
	out.print(ErrorMsg);
} %>

<body>
  <h1>ABC</h1>
  ID = <% out.print(id); %><br>
  Pass = <% out.print(pass); %><br>
</body>
</html>