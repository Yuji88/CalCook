<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.ProjectInfo"%>
<%@page import="dto.MenuInfo"%>
<%@page import="dto.ProjectCookDisp"%>
<% ProjectInfo projectInfo = (ProjectInfo) session.getAttribute("projectInfo");%>
<% ArrayList<ProjectCookDisp> projectCookDispList = (ArrayList<ProjectCookDisp>) session.getAttribute("projectCookDispList");%>
<% ArrayList<MenuInfo> menuInfoList = new ArrayList<>();%>
<% ArrayList<Integer> eatMemberList = new ArrayList<>();%>
<% int dispMenuid = (int)request.getAttribute("dispMenuid"); %>
<% String errMsg = (String)request.getAttribute("errMsg"); %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="ProjectMenuChenge.js"></script>
<link rel="stylesheet" href="header_footer.css">
<link rel="stylesheet" href="MainStyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PJ調理材料編集画面</title>
</head>
<body>
	<%@ include file="_header.jsp"%>
	<div id="main">
		<h3 class="title">PJ調理材料編集画面</h3>
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

						if (i >= 1
								&& (projectCookDispList.get(i - 1).getMenuid() != projectCookDispList.get(i).getMenuid())) {
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
		<%if (errMsg != "" || errMsg != null) {
				out.write(errMsg);
			}
		%>
		<%
			for (int i = 0; i < menuInfoList.size(); i++) {
				out.write("<form action=\"ProjectCookEdit\">");
				out.write("<input type=\"hidden\" name=\"view\" value=\"reveiw\">");

				if(dispMenuid == menuInfoList.get(i).getMenuid()){
					out.write("<div style=\"display:block\" class=\"menus\">");
				} else {
					out.write("<div style=\"display:none\" class=\"menus\">");
				}

				out.write("<h4>" + menuInfoList.get(i).getMenuname() + "</h4>");
				out.write("<input type=\"hidden\" name=\"menuid\" value=\"" + menuInfoList.get(i).getMenuid() + "\">");
				out.write("<h5><input type=\"text\" name=\"member\" value=\"" + eatMemberList.get(i) + "\">人前</h5>");
				out.write("<input type=\"hidden\" name=\"dispMenuid\" value=\"" + menuInfoList.get(i).getMenuid() + "\">");
				out.write("<input type=\"submit\" name=\"recalculation\" value=\"人数再計算\">");

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
						out.write("<input type=\"hidden\" name=\"menus\" value=\"" + projectCookDispList.get(j).getMenuid() + "\">");
						out.write("<input type=\"hidden\" name=\"ingredients\" value=\"" + projectCookDispList.get(j).getIngredientid() + "\">");
						out.write("<td><input type=\"text\" name=\"amounts\" value=\"" + projectCookDispList.get(j).getAmount() + "\"></td>");
						out.write("<td>" + projectCookDispList.get(j).getUnit() + "</td>");
						out.write("</tr>");
					}
				}
				out.write("</table>");
				out.write("</div>");
				out.write("<input type=\"submit\" name=\"initialize\" value=\"分量を初期化する\">");
				out.write("<input type=\"submit\" name=\"save\" value=\"保存する\">");
				out.write("</div>");
				out.write("</form>");
			}
		%>
	</div>

	<%@ include file="_footer.jsp"%>
</body>
</html>