<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<% String projectName = (String)session.getAttribute("projectName"); %>
<% String cookName = (String)request.getAttribute("cookName"); %>
<% int member = (int)session.getAttribute("member"); %>
<% String errMsg = (String)request.getAttribute("errMsg"); %>
<% ArrayList<String> projectnames = (ArrayList<String>)request.getAttribute("projectnames"); %>

<!DOCTYPE HTML>
<html>
<head>
  <link rel="stylesheet" href="header_footer.css">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>料理情報入力画面</title>
</head>
<body>
<script src="_header.js"></script>
<div id="main">
  <h3>料理情報入力画面</h3>
  <p>説明：~~~~~</p>
  <hr>
  <form action="CookInfo">
    <fieldset>
	  <h3><span id="right">分量を計算する</span></h3>
	    <div id="right">
	      <input type = "submit" name="calculate" value="計算する">
	    </div>
	  <hr>
	  <% if (errMsg != "" || errMsg != null){
		out.write(errMsg);
	    }
	  %>

        <p>
          <label for = "projectName">プロジェクト名</label>
          <select name = "projectName">
            <% if(projectName == "" || projectName == null){
            	out.write("<option value=\"\" selected> </optin>");
            	} else {
            	out.write("<option value=\""+ projectName + "\" selected>" + projectName + "</optin>");
            	out.write("<option value=\"\"> </optin>");
                }
            for(int i = 0; i < projectnames.size(); i++){
            	if(!(projectName.equals(projectnames.get(i)))){
            	    out.write("<option value=\"" + projectnames.get(i) + "\">" + projectnames.get(i) + "</option>");
            	}
            }
            %>
          </select>
        </p>

	  <p>
	    <label for="cookName">料理名</label>
        <input type="text" name="cookName"
          <% if (cookName.equals("") || cookName == null){
        	   out.write("value=\"\"");
        	 } else {
        	   out.write("value=\"" + cookName + "\"");
        	 }
          %>
        >
        <input type="submit" name="search" value="料理を探す">
	  </p>

      <p>
	    <label for = "member">人数</label>
	    <input type="number" name = "member"
	      <% out.write("value=\"" + member + "\"");%>
	    min="0">
	  </p>

    </fieldset>
  </form>
</div>
<script src="_footer.js"></script>
</body>
</html>