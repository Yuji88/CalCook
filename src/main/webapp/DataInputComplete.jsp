<!-- 画面ID：k00g03	完了メッセージ -->
<!-- 初期構築：2019/07/15 ChiZai Tagawa Yuji -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String dataMsg = (String)request.getAttribute("dataMsg"); %>

<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="header_footer.css">
  <link rel="stylesheet" href="MainStyle.css">
  <meta charset="UTF-8">
  <title>登録完了画面</title>
</head>
<body>
<%@ include file="_header.jsp" %>
<div id="main">
  <h3 class="title-NoReturn">登録完了画面</h3>

  <h4><%= dataMsg %></h4>

  <form method="post" action = "Main">
    <input type = "hidden" name = "view" value = "home">
    <input type = "submit" value = "Homeに戻る">
  </form>
</div>
<%@ include file="_footer.jsp" %>
</body>
</html>