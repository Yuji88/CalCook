<!-- 画面ID：k01g02	料理検索画面 -->
<!-- 初期構築：2019/07/15 ChiZai Tagawa Yuji -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.IngredientDispInfo"%>
<% String cookName = (String)request.getAttribute("cookName"); %>
<% String errMsg = (String)request.getAttribute("errMsg"); %>
<% String ingredientName = (String)request.getAttribute("ingredientName"); %>
<% ArrayList<IngredientDispInfo> ingredientDispInfoList
			= (ArrayList<IngredientDispInfo>) request.getAttribute("ingredientDispInfoList");%>

<!DOCTYPE HTML>
<html>
<head>
  <link rel="stylesheet" href="header_footer.css">
  <link rel="stylesheet" href="MainStyle.css">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>料理検索画面</title>
</head>
<body>
<%@ include file="_header.jsp" %>
<div id="main">
  <form method="post" action="CookSearch">
    <input class="Return" type="submit" name="decision" value="＜ 戻る">
  </form>
  <h3 class="title">料理検索画面</h3>
  <p>説明：~~~~~</p>
  <form method="post" action="CookSearch">

  <label for="cookName">料理名</label>
  <input type="text" name="cookName"
    <%if (cookName != "" || cookName != null) {
      out.write("value=\"" + cookName + "\"");
    }
	%>>
  <label for="ingredientName">材料名</label>
  <input type="text" name="ingredientName"
    <%if (ingredientName != "" || ingredientName != null) {
      out.write("value=\"" + ingredientName + "\"");
    }
	%>>
  <input type="submit" name="search" value="検索">
  </form>

  <form method="post" action="CookSearch">
  <hr>
			<table>
				<tr>
					<th>No.</th>
					<th>料理名</th>
					<th>材料名</th>
					<th>選択</th>
				</tr>
				<%
					if (ingredientDispInfoList != null || ingredientDispInfoList.size() == 0) {
						for (int i = 0; i < ingredientDispInfoList.size(); i++) {
							out.write("<tr>");
							out.write("<td>" + (i + 1) + "</td>");
							out.write("<td>" + ingredientDispInfoList.get(i).getMenuName() + "</td>");
							out.write("<td>" + ingredientDispInfoList.get(i).getIngredientDisps() + "</td>");
							out.write("<td><input type=\"radio\" name=\"cookName\" value=\""
									+ ingredientDispInfoList.get(i).getMenuName() + "\"></td>");
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
</div>
<%@ include file="_footer.jsp" %>
</body>
</html>