package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProjectInfo;
import model.ProjectData;

/**
 * Servlet implementation class NewProject
 */
public class NewProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String projectname = request.getParameter("projectname");
		String smember = request.getParameter("member");
		String startday = request.getParameter("startday");
		String endday = request.getParameter("endday");
		String view = request.getParameter("view");

		int member = 0;

		if (smember != null && !(smember.equals(""))) {
			member = Integer.parseInt(smember);
		}
		if (view.equals("CheckProject")) {

			if (projectname.equals("") || projectname == null) {
				String errMsg = "プロジェクト名が未入力です";
				request.setAttribute("member", member);
				request.setAttribute("startday", startday);
				request.setAttribute("endday", endday);
				request.setAttribute("errMsg", errMsg);

				request.getRequestDispatcher("NewProject.jsp").forward(request, response);
			}
			request.setAttribute("projectname", projectname);
			request.setAttribute("member", member);
			request.setAttribute("startday", startday);
			request.setAttribute("endday", endday);

			request.getRequestDispatcher("CheckProject.jsp").forward(request, response);

		} else if (view.equals("ProjectCreate")) {
			int resultCode = 0;
			ProjectData projectData = new ProjectData();

			// プロジェクトID採番
			int id = projectData.ProjectIdselect();
			// プロジェクト情報
			ProjectInfo projectInfo = new ProjectInfo(id, projectname, member, startday, endday);

			// プロジェクト情報登録
			resultCode = projectData.ProjectInsert(projectInfo);
			if (resultCode != 0) {
				String errMsg = "システムエラー(プロジェクト登録 失敗)";
				request.setAttribute("errMsg", errMsg);
				request.getRequestDispatcher("ERROR.jsp").forward(request, response);
			}
			String dataMsg = "プロジェクトの登録が完了しました！";
			request.setAttribute("dataMsg", dataMsg);
			request.getRequestDispatcher("DataInputComplete.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
