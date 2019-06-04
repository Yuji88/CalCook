<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% int member = (int)request.getAttribute("member"); %>
<% String startday = (String)request.getAttribute("startday"); %>
<% String endday = (String)request.getAttribute("endday"); %>
<% String errMsg = (String)request.getAttribute("errMsg"); %>

<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="header_footer.css">
  <meta charset="UTF-8">
  <title>新プロジェクト作成画面</title>
</head>
<body>
<script src="_header.js"></script>
<div id="main">
  <h3>新プロジェクト作成画面</h3>
  <p>説明：*印がついている箇所は入力必須項目です。</p>
  	  <% if (errMsg != "" || errMsg != null){
		out.write(errMsg);
	    }
	  %>
  <form action = "NewProject">
    <label for="projectname">*プロジェクト名：</label>
    <input type="text" name="projectname"><br>

    <label for="member">参加者：</label>
    <input type="number" name="member" min="0"
	      <% out.write("value=\"" + member + "\"");%>
          ><br>

    <label for="startday">開始日：</label>
    <input type="date" name="startday"
          <% if (startday != "" || startday != null){
          	 out.write("value=\"" + startday + "\"");
        	 }
          %>
    ><br>

    <label for="endday">終了日：</label>
    <input type="date" name="endday"
          <% if (startday != "" || endday != null){
          	 out.write("value=\"" + endday + "\"");
        	 }
          %>
    ><br>

    <input type="hidden" name="view" value="CheckProject">
    <input type = "submit" value = "次へ">
  </form>
</div>
<script src="_footer.js"></script>
</body>
</html>