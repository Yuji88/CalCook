package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.IngredientDispInfo;
import dto.MenuIngredientInfo;
import model.MenuData;
import model.MenuIngredientData;
import model.ProjectData;

/**
 * Servlet implementation class CookInfo
 */
public class CookInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String projectName = request.getParameter("projectName");
		String cookName = request.getParameter("cookName");
		String smember = request.getParameter("member");
		String calculate = request.getParameter("calculate");
		String search = request.getParameter("search");

		int member = 0;

		if (smember != null && !(smember.equals(""))) {
			member = Integer.parseInt(smember);
		}

		if (search != null) {
			if (projectName == null) {
				projectName = "";
			}
			cookName = "";
			String errMsg = "";
			String ingredientName = "";
			ArrayList<IngredientDispInfo> ingredientDispInfoList = new ArrayList<>();

			session.setAttribute("projectName", projectName);
			session.setAttribute("member", member);
			request.setAttribute("ingredientDispInfoList", ingredientDispInfoList);
			request.setAttribute("cookName", cookName);
			request.setAttribute("ingredientName", ingredientName);
			request.setAttribute("errMsg", errMsg);

			// 料理選択画面遷移
			request.getRequestDispatcher("CookSearch.jsp").forward(request, response);
			return;

		} else if (calculate != null){
			// 未入力チェック
			if(projectName == null || projectName.equals("") || cookName == null || cookName.equals("")
					|| smember == null || member <= 0) {
				String errMsg = "";
				String preErrMsg1 = "";
				String preErrMsg2 = "";
				String preErrMsg3 = "";

				if (projectName == null || projectName.equals("")) {
					projectName = "";
					preErrMsg1 = "「プロジェクト名」";
				}

				if (cookName == null || cookName.equals("")) {
					cookName = "";
					preErrMsg2 = "「料理名」";
				}

				if (smember == null || member <= 0) {
					preErrMsg3 = "「1名以上の人数」";
				}

				errMsg = preErrMsg1 + preErrMsg2 + preErrMsg3 + "を入力してください";

				ArrayList<String> projectnames = new ArrayList<>();
				ProjectData projects = new ProjectData();
				projectnames = projects.ProjectNameselect();

				request.setAttribute("projectnames", projectnames);
				session.setAttribute("projectName", projectName);
				request.setAttribute("cookName", cookName);
				session.setAttribute("member", member);
				request.setAttribute("errMsg", errMsg);

				// 未入力 自画面遷移
				request.getRequestDispatcher("CookInfoInput.jsp").forward(request, response);
				return;
			}

			ArrayList<MenuIngredientInfo> menuIngredientDataList = new ArrayList<>();
			MenuIngredientData menuIngredientData = new MenuIngredientData();
			MenuData menuData = new MenuData();
			int menuid = menuData.MenuIdSelect(cookName);
			menuIngredientDataList = menuIngredientData.EssMenuIngredientSelect(menuid);

			if(menuIngredientDataList.size() == 0) {
				String errMsg = "計算できる料理ではありません。";
				ArrayList<String> projectnames = new ArrayList<>();
				ProjectData projects = new ProjectData();
				projectnames = projects.ProjectNameselect();

				request.setAttribute("projectnames", projectnames);
				request.setAttribute("cookName", cookName);
				request.setAttribute("errMsg", errMsg);

				// 未入力 自画面遷移
				request.getRequestDispatcher("CookInfoInput.jsp").forward(request, response);
				return;
			}

			String errMsg = "";

			request.setAttribute("projectName", projectName);
			request.setAttribute("cookName", cookName);
			request.setAttribute("member", member);
			session.setAttribute("menuIngredientDataList", menuIngredientDataList);
			request.setAttribute("errMsg", errMsg);

			// 計算画面遷移
			request.getRequestDispatcher("IngredientsCalRslt.jsp").forward(request, response);
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
