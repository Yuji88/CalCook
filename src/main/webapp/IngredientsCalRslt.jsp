<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
  <link rel="stylesheet" href="header_footer.css">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <% String projectName = (String)request.getAttribute("projectName"); %>
  <% String cookName = (String)request.getAttribute("cookName"); %>
  <% int member = (int)request.getAttribute("member"); %>
<title>材料・分量計算結果画面</title>
</head>
<body>
<script src="_header.js"></script>
<div id="main">
projectName:<% out.print(projectName);%>
cookName:<% out.print(cookName);%>
member:<% out.print(member);%>
</div>
<script src="_footer.js"></script>
</body>
</html>