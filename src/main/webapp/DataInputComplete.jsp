<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String dataMsg = (String)request.getAttribute("dataMsg"); %>

<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="header_footer.css">
  <meta charset="UTF-8">
  <title>登録完了画面</title>
</head>
<body>
<script src="_header.js"></script>
<div id="main">
  <h2>登録完了画面</h2>

  <h3><%= dataMsg %></h3>

  <form action = "Main">
    <input type = "hidden" name = "view" value = "home">
    <input type = "submit" value = "Homeに戻る">
  </form>
</div>
<script src="_footer.js"></script>
</body>
</html>