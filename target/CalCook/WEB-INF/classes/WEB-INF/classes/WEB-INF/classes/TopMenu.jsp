<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
  <link rel="stylesheet" href="header_footer.css">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Home - Welcome to CalCook!</title>
</head>

<body>
<script src="_header.js"></script>

<div id="main">
  <h1>Welcome to CalCook!</h1>

  <form action = "Main">
	<input type = "hidden" name = "view" value = "CookInfoInput">
    <input type = "submit" value = "作業する">  <p>説明：~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p><br>
  </form>

  <form action = "Main">
  	<input type = "hidden" name = "view" value = "home">
    <input type = "submit"  value = "確認する">  <p>説明：~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>
  </form>

  <hr>
  <form action="Main">
    <input type="hidden" name="view" value="NewProject">
	<input type = "submit"  value = "プロジェクトを登録する">
  </form>

</div>
<script src="_footer.js"></script>
</body>
</html>