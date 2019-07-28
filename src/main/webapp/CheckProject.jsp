<!-- 画面ID：kXXgXX	登録プロジェクト確認画面 -->
<!-- 初期構築：2019/07/15 ChiZai Tagawa Yuji -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String projectname = (String)request.getAttribute("projectname"); %>
<% int member = (int)request.getAttribute("member"); %>
<% String startday = (String)request.getAttribute("startday"); %>
<% String endday = (String)request.getAttribute("endday"); %>

<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="header_footer.css">
  <link rel="stylesheet" href="MainStyle.css">
  <meta charset="UTF-8">
  <title>登録プロジェクト確認画面</title>
</head>
<body>
  <%@ include file="_header.jsp" %>
  <div id="main">
    <h3 class="title">登録プロジェクト確認画面</h3>
    <p>以下の内容で登録してよろしいですか？</p>
    <hr>

	<form method="post" action="NewProject">
    <p>プロジェクト名：
    <% out.write(projectname);%></p>

    <p>人数：
    <%= member %>人</p>

    <p>期間：
    <% out.write(startday + " 〜 " + endday);%></p>

	<input type="hidden" name="projectname"
		<% out.write("value=\"" + projectname + "\""); %>>
	<input type="hidden" name="member"
		<% out.write("value=\"" + member + "\""); %>>
	<input type="hidden" name="startday"
		<% out.write("value=\"" + startday + "\""); %>>
	<input type="hidden" name="endday"
		<% out.write("value=\"" + endday + "\""); %>>

	<input type="hidden" name="view" value="ProjectCreate">
    <input type="submit" value="登録する">
  </form>
  </div>
  <%@ include file="_footer.jsp" %>
</body>
</html>