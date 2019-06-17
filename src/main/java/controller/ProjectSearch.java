package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProjectInfo;
import model.ProjectData;

/**
 * Servlet implementation class ProjectSearch
 */
public class ProjectSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String view = request.getParameter("view");
		String searchDate = request.getParameter("searchDate");
		String projectName = request.getParameter("projectName");
		String sprojectid = request.getParameter("projectid");

		String errMsg = "";

		int projectid = 0;

		if (sprojectid != null && !(sprojectid.equals(""))) {
			projectid = Integer.parseInt(sprojectid);
		}

		if(view.equals("search")) {

			ArrayList<ProjectInfo> projectList = new ArrayList<>();
			ProjectData projects = new ProjectData();

			if((searchDate == null || searchDate.equals("")) && (projectName == null || projectName.equals(""))) {
				projectList = projects.AllProjectSelect();

			} else if ((searchDate != null && !(searchDate.equals(""))) && (projectName != null && !(projectName.equals("")))) {
				projectList = projects.ProjectSearchSelect(projectName, searchDate);

			} else if(searchDate != null && !(searchDate.equals(""))) {
				projectList = projects.ProjectSearchYearSelect(searchDate);

			} else if(projectName != null && !(projectName.equals(""))) {
				projectList = projects.ProjectSearchNameSelect(projectName);

			}

			request.setAttribute("searchDate", searchDate);
			request.setAttribute("projectName", projectName);
			request.setAttribute("errMsg", errMsg);
			request.setAttribute("projectList", projectList);

			request.getRequestDispatcher("ProjectList.jsp").forward(request, response);
			return;

		} else if(view.equals("decision")) {
			if(projectid == 0) {
				ArrayList<ProjectInfo> projectList = new ArrayList<>();
				ProjectData projects = new ProjectData();

				projectList = projects.AllProjectSelect();

				errMsg = "プロジェクトが選択されていません。";

				request.setAttribute("searchDate", searchDate);
				request.setAttribute("projectName", projectName);
				request.setAttribute("errMsg", errMsg);
				request.setAttribute("projectList", projectList);

				request.getRequestDispatcher("ProjectList.jsp").forward(request, response);
				return;
			}
			ProjectInfo projectInfo = new ProjectInfo();
			ProjectData projects = new ProjectData();
			projectInfo = projects.ProjectSelect(projectid);

			request.setAttribute("projectInfo", projectInfo);

			request.getRequestDispatcher("ProjectCookDetail.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
