<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String errMsg = (String)request.getAttribute("errMsg"); %>

<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="header_footer.css">
  <meta charset="UTF-8">
  <title>System Error</title>
</head>
<body>
<script src="_header.js"></script>
<div id="main">
  <h2>システムエラー</h2>
  <h3><% out.write(errMsg); %></h3>
  <p>上記の理由でシステム上のエラーが発生しました。<br>
  申し訳ありませんが、開発担当者にお問い合わせください。</p>
  <br>
  <p>ChiZai システム担当：080-1234-5678</p>

</div>
<script src="_footer.js"></script>
</body>
</html>