<!-- 画面ID：k02g04	発注書編集画面 -->
<!-- 初期構築：2019/07/31 ChiZai Tagawa Yuji -->

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.ProjectInfo"%>
<%@page import="dto.MenuInfo"%>
<%@page import="dto.ProjectCookDisp"%>
<% ProjectInfo projectInfo = (ProjectInfo) session.getAttribute("projectInfo");%>
<% ArrayList<ProjectCookDisp> projectCookDispList = (ArrayList<ProjectCookDisp>) session.getAttribute("projectCookDispList");%>
<% String errMsg = (String)request.getAttribute("errMsg"); %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="ProjectMenuChenge.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
  $(function(){
    $('.checkAll').on('change', function() {
      $('.' + this.id).prop('checked', this.checked);
    });
  });
</script>
<link rel="stylesheet" href="header_footer.css">
<link rel="stylesheet" href="MainStyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>発注書編集画面</title>
</head>
<body>
  <%@include file="_header.jsp"%>
  <div id="main">
    <form method="post" action="Main">
      <input type = "hidden" name = "view" value = "Confirm">
      <input class="Return" type="submit" name="calculate" value="＜ 一覧に戻る">
    </form>
    <h3 class="title">発注書編集画面</h3>
      <%out.write(projectInfo.getProjectname());%><br>
      <%out.write(projectInfo.getStartdate());%>〜<%out.write(projectInfo.getEnddate());%><br>
      <%out.write(String.valueOf(projectInfo.getMember()));%>人
    <hr>
    <table id="menus">
      <tr>
        <th>料理名</th>
        <th>人数</th>
      </tr>
      <%
        if (projectCookDispList != null || projectCookDispList.size() == 0) {
          for (int i = 0; i < projectCookDispList.size(); i++) {
            if (i == 0) {
              out.write("<tr>");
              out.write("<td>" + projectCookDispList.get(i).getMenuname() + "</td>");
              out.write("<td>" + projectCookDispList.get(i).getEatmember() + "</td>");
              out.write("</tr>");
            }
            if (i >= 1 && (projectCookDispList.get(i - 1).getMenuid() != projectCookDispList.get(i).getMenuid())) {
              out.write("<tr>");
              out.write("<td>" + projectCookDispList.get(i).getMenuname() + "</td>");
              out.write("<td>" + projectCookDispList.get(i).getEatmember() + "</td>");
              out.write("</tr>");
            }
          }
        }
      %>
    </table>
    <hr>
    <%
      if (errMsg != "" || errMsg != null) {
        out.write(errMsg);
      }
    %>
    <form method="post" action="PurchaseOrder">
      <table>
        <tr>
          <td>Check!</td>
          <td>料理</td>
          <td>材料</td>
          <td>分量</td>
        </tr>
        <%
          int cnt = 0;
          for (int i = 0; i < projectCookDispList.size(); i++){
            out.write("<tr>");
            if(i == 0){
              cnt++;
              out.write("<td><input type=\"checkbox\" id=\"check_" + cnt + "\" class=\"checkAll\"></td>");
              out.write("<td colspan=\"3\">" + projectCookDispList.get(i).getMenuname() + "</td>");
            } else {
              if(projectCookDispList.get(i).getMenuid() != projectCookDispList.get(i-1).getMenuid()){
                  cnt++;
                  out.write("<td><input type=\"checkbox\" id=\"check_" + cnt + "\" class=\"checkAll\"></td>");
                  out.write("<td colspan=\"3\">" + projectCookDispList.get(i).getMenuname() + "</td>");
              } else {
                out.write("<td><input type=\"checkbox\" class=\"check_" + cnt + "\"></td>");
                out.write("<td></td>");
                out.write("<td>" + projectCookDispList.get(i).getIngredientname() + "</td>");
                out.write("<td>" + projectCookDispList.get(i).getAmount() + projectCookDispList.get(i).getUnit() + "</td>");
              }
            }
            out.write("</tr>");
          }
        %>
      </table>
      <input type="submit" name="output" value="出力する">
    </form>
  </div>
  <%@include file="_footer.jsp"%>
</body>
</html>