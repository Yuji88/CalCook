<!-- 画面ID：k02g02	PJ調理材料詳細画面 -->
<!-- 初期構築：2019/07/15 ChiZai Tagawa Yuji -->

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.ProjectInfo"%>
<%@page import="dto.MenuInfo"%>
<%@page import="dto.ProjectCookDisp"%>
<%ProjectInfo projectInfo = (ProjectInfo) session.getAttribute("projectInfo");%>
<%ArrayList<ProjectCookDisp> projectCookDispList = (ArrayList<ProjectCookDisp>) session.getAttribute("projectCookDispList");%>
<%ArrayList<MenuInfo> menuInfoList = new ArrayList<>();%>
<%ArrayList<Integer> eatMemberList = new ArrayList<>();%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="ProjectMenuChenge.js"></script>
<link rel="stylesheet" href="header_footer.css">
<link rel="stylesheet" href="MainStyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PJ調理材料詳細画面</title>
</head>
<body>
  <%@include file="_header.jsp"%>
  <div id="main">
    <form method="post" action="Main">
      <input type = "hidden" name = "view" value = "Confirm">
      <input class="Return" type="submit" name="calculate" value="＜ 一覧に戻る">
    </form>
    <h3 class="title">PJ調理材料詳細画面</h3>
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
        int cnt = 0;
        if (projectCookDispList != null || projectCookDispList.size() == 0) {
          for (int i = 0; i < projectCookDispList.size(); i++) {
            if (i == 0) {
              MenuInfo menuInfo = new MenuInfo();
              menuInfo.setMenuid(projectCookDispList.get(i).getMenuid());
              menuInfo.setMenuname(projectCookDispList.get(i).getMenuname());
              menuInfoList.add(menuInfo);
              eatMemberList.add(projectCookDispList.get(i).getEatmember());

              out.write("<tr onclick=\"menuEntryChange('" + cnt + "')\">");
              out.write("<td>" + projectCookDispList.get(i).getMenuname() + "</td>");
              out.write("<td>" + projectCookDispList.get(i).getEatmember() + "</td>");
              out.write("</tr>");
              cnt++;
             }

            if (i >= 1 && (projectCookDispList.get(i - 1).getMenuid() != projectCookDispList.get(i).getMenuid())) {
              MenuInfo menuInfo = new MenuInfo();
              menuInfo.setMenuid(projectCookDispList.get(i).getMenuid());
              menuInfo.setMenuname(projectCookDispList.get(i).getMenuname());
              menuInfoList.add(menuInfo);
              eatMemberList.add(projectCookDispList.get(i).getEatmember());

              out.write("<tr onclick=\"menuEntryChange('" + cnt + "')\">");
              out.write("<td>" + projectCookDispList.get(i).getMenuname() + "</td>");
              out.write("<td>" + projectCookDispList.get(i).getEatmember() + "</td>");
              out.write("</tr>");
              cnt++;
            }
          }
        }
      %>
    </table>
    <hr>

    <%
      for (int i = 0; i < menuInfoList.size(); i++) {
        out.write("<form method=\"post\" action=\"ProjectCookEdit\">");

        out.write("<input type=\"hidden\" name=\"view\" value=\"EditStart\">");

        out.write("<div style=\"display:none\" class=\"menus\">");
        out.write("<h4>" + menuInfoList.get(i).getMenuname() + "</h4>");
        out.write("<h5>" + eatMemberList.get(i) + "人前</h5>");
        out.write("<input type=\"hidden\" name=\"dispMenuid\" value=\"" + menuInfoList.get(i).getMenuid() + "\">");
        out.write("<input type=\"submit\" name=\"edit\" value=\"情報編集\">");

        out.write("<div style=\"width:300px;height:200px;overflow:auto;\">");
        out.write("<table>");
        out.write("<tr>");
        out.write("<th>材料名</th>");
        out.write("<th>分量</th>");
        out.write("</tr>");
        for (int j = 0; j < projectCookDispList.size(); j++) {
          if (menuInfoList.get(i).getMenuid() == projectCookDispList.get(j).getMenuid()) {
            out.write("<tr>");
            out.write("<td>" + projectCookDispList.get(j).getIngredientname() + "</td>");
            out.write("<td>" + projectCookDispList.get(j).getAmount() + projectCookDispList.get(j).getUnit() + "</td>");
            out.write("</tr>");
          }
        }
        out.write("</table>");
        out.write("</div>");
        out.write("</div>");
        out.write("</form>");
      }
    %>
  </div>
  <form method="post" action="ProjectCookEdit">
    <input type="hidden" name="view" value="Purchase">
    <input type="submit" name="" value="発注書出力">
  </form>
  <%@include file="_footer.jsp"%>
</body>
</html>