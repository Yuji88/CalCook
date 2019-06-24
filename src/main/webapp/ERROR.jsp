<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String errMsg = (String)request.getAttribute("errMsg"); %>

<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="header_footer.css">
  <link rel="stylesheet" href="MainStyle.css">
  <meta charset="UTF-8">
  <title>System Error</title>
</head>
<body>
<%@ include file="_header.jsp" %>
<div id="main">
  <h3 class="title">システムエラー</h3>
  <h4><% out.write(errMsg); %></h4>
  <p>上記の理由でシステム上のエラーが発生しました。<br>
  申し訳ありませんが、開発担当者にお問い合わせください。</p>
  <br>
  <p>ChiZai システム担当：080-1234-5678</p>

</div>
<%@ include file="_footer.jsp" %>
</body>
</html>