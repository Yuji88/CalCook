<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.MenuIngredientInfo"%>
<% String projectName = (String)request.getAttribute("projectName"); %>
<% String cookName = (String)request.getAttribute("cookName"); %>
<% int member = (int)request.getAttribute("member"); %>
<% String errMsg = (String)request.getAttribute("errMsg"); %>
<% ArrayList<MenuIngredientInfo> menuIngredientDataList
			= (ArrayList<MenuIngredientInfo>) session.getAttribute("menuIngredientDataList");%>

<!DOCTYPE HTML>
<html>
<head>
  <link rel="stylesheet" href="header_footer.css">
  <link rel="stylesheet" href="MainStyle.css">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>材料・分量計算結果画面</title>
</head>
<body>
<%@ include file="_header.jsp" %>
<div id="main">
  <h3 class="title">材料・分量計算結果画面</h3>
  <p>説明：~~~~~</p>
  <hr>
  <form action="ProjectCookReg">
  <h4>プロジェクト名:<% out.print(projectName);%></h4>
  <h4>料理名:<% out.print(cookName);%></h4>
  <h4>人数:<% out.print(member);%></h4>
  <input type="hidden" name="projectName" value="<% out.write(projectName); %>">
  <input type="hidden" name="cookName" value="<% out.write(cookName); %>">
  <input type="hidden" name="member" <% out.write("value=\"" + member + "\"");%>>
    <hr>
		<table>
			<tr>
				<th>No.</th>
				<th>材料名</th>
				<th>分量(1人前)</th>
				<th>分量(PJ人数)</th>
			</tr>
			<%
				if (menuIngredientDataList != null || menuIngredientDataList.size() == 0) {
					for (int i = 0; i < menuIngredientDataList.size(); i++) {
						out.write("<tr>");
						out.write("<td>" + (i + 1) + "</td>");
						out.write("<td>" + menuIngredientDataList.get(i).getIngredientname() + "</td>");
						out.write("<td>" + menuIngredientDataList.get(i).getAmount() + menuIngredientDataList.get(i).getUnit() + "</td>");
						out.write("<td>" + (menuIngredientDataList.get(i).getAmount() * member) + menuIngredientDataList.get(i).getUnit() + "</td>");
						out.write("</tr>");
					}
				}
			%>
		</table>
		<hr>
	<% if (errMsg != "" || errMsg != null){
		out.write(errMsg);
	}
	%>
  <input type="submit" name="decision" value="決定">
  </form>

  <hr>
</div>
<%@ include file="_footer.jsp" %>
</body>
</html>