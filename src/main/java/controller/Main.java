package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ProjectInfo;
import model.ProjectData;

/**
 * Servlet implementation class Main
 */
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public Main() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		String view = request.getParameter("view");
		if(view.equals("home")) {

			request.getRequestDispatcher("TopMenu.jsp").forward(request, response);

		} else if (view.equals("CookInfoInput")){

			String projectName = "";
			String cookName = "";
			int member = 0;
			String errMsg = "";
			session.setAttribute("projectName", projectName);
			request.setAttribute("cookName", cookName);
			session.setAttribute("member", member);
			request.setAttribute("errMsg", errMsg);

			ArrayList<String> projectnames = new ArrayList<>();
			ProjectData projects = new ProjectData();
			projectnames = projects.ProjectNameselect();

			request.setAttribute("projectnames", projectnames);

			request.getRequestDispatcher("CookInfoInput.jsp").forward(request, response);
			return;

		}else if(view.equals("Confirm")) {
			String errMsg = "";
			String projectName = "";
			String searchDate = "";
			// ArrayList<String> searchDateList = new ArrayList<>();

			ArrayList<ProjectInfo> projectList = new ArrayList<>();
			ProjectData projects = new ProjectData();
			projectList = projects.AllProjectSelect();

			request.setAttribute("searchDate", searchDate);
			request.setAttribute("projectName", projectName);
			request.setAttribute("errMsg", errMsg);
			request.setAttribute("projectList", projectList);

			request.getRequestDispatcher("ProjectList.jsp").forward(request, response);
			return;

		} else if (view.equals("NewProject")) {
			String errMsg = "";
			int member = 0;
			String startday = "";
			String endday = "";
			request.setAttribute("member", member);
			request.setAttribute("startday", startday);
			request.setAttribute("endday", endday);
			request.setAttribute("errMsg", errMsg);

			request.getRequestDispatcher("NewProject.jsp").forward(request, response);
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
