<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String projectName = (String)request.getAttribute("projectName"); %>
<% String cookName = (String)request.getAttribute("cookName"); %>
<% int member = (int)request.getAttribute("member"); %>

<!DOCTYPE HTML>
<html>
<head>
  <link rel="stylesheet" href="header_footer.css">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>材料・分量計算結果画面</title>
</head>
<body>
<script src="_header.js"></script>
<div id="main">
  <h3>材料・分量計算結果画面</h3>
  <p>説明：~~~~~</p>
  <hr>
  <h4>projectName:<% out.print(projectName);%></h4>
  <h4>cookName:<% out.print(cookName);%></h4>
  <h4>member:<% out.print(member);%></h4>
  <hr>
</div>
<script src="_footer.js"></script>
</body>
</html>