<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.ProjectInfo"%>
<% ProjectInfo projectInfo = (ProjectInfo)request.getAttribute("projectInfo"); %>

<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="header_footer.css">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PJ調理材料詳細画面</title>
</head>
<body>
<script src="_header.js"></script>
<div id="main">
  <h3>PJ調理材料詳細画面</h3>
  <% out.write(projectInfo.getProjectname()); %>
  <% out.write(projectInfo.getStartdate()); %> 〜 <% out.write(projectInfo.getEnddate()); %>
  <% out.write(String.valueOf(projectInfo.getMember())); %>人

</div>
<script src="_footer.js"></script>
</body>
</html>