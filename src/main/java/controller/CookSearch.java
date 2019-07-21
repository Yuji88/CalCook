package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.IngredientDispInfo;
import dto.MenuInfo;
import model.MenuData;
import model.MenuIngredientData;
import model.ProjectData;
import processing.IngredientProcDisp;

/**
 * Servlet implementation class CookSearch
 */
public class CookSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String cookName = request.getParameter("cookName");
		String ingredientName = request.getParameter("ingredientName");
		String decision = request.getParameter("decision");
		String search = request.getParameter("search");

		String errMsg = "";

		if(search != null) {
			ArrayList<MenuInfo> menuInfoList = new ArrayList<>();
			ArrayList<IngredientDispInfo> ingredientDispInfoList = new ArrayList<>();
			IngredientProcDisp ingredientProcDisp = new IngredientProcDisp();

			// 全データ出力
			if((cookName == null || cookName.equals("")) && (ingredientName == null || ingredientName.equals(""))) {
				MenuData menudata = new MenuData();
				menuInfoList = menudata.AllMenuSelect();

				for(int i = 0; i < menuInfoList.size(); i++) {
					ingredientDispInfoList.add(ingredientProcDisp.IngredientNameProc(menuInfoList.get(i)));
				}

			} else if((cookName != null && !(cookName.equals(""))) && (ingredientName != null && !(ingredientName.equals("")))) {
				MenuIngredientData menuIngredientData = new MenuIngredientData();
				menuInfoList = menuIngredientData.EssIngredientMenuSelect(cookName, ingredientName);

				for(int i = 0; i < menuInfoList.size(); i++) {
					ingredientDispInfoList.add(ingredientProcDisp.IngredientNameProc(menuInfoList.get(i)));
				}
			} else if (cookName != null && !(cookName.equals(""))) {
				MenuData menudata = new MenuData();
				menuInfoList = menudata.MenuSelect(cookName);

				for(int i = 0; i < menuInfoList.size(); i++) {
					ingredientDispInfoList.add(ingredientProcDisp.IngredientNameProc(menuInfoList.get(i)));
				}
			} else if (ingredientName != null && !(ingredientName.equals(""))) {
				MenuIngredientData menuIngredientData = new MenuIngredientData();
				menuInfoList = menuIngredientData.EssIngredientMenuSelect(ingredientName);

				for(int i = 0; i < menuInfoList.size(); i++) {
					ingredientDispInfoList.add(ingredientProcDisp.IngredientNameProc(menuInfoList.get(i)));
				}
			}

			request.setAttribute("ingredientDispInfoList", ingredientDispInfoList);
			request.setAttribute("cookName", cookName);
			request.setAttribute("ingredientName", ingredientName);
			request.setAttribute("errMsg", errMsg);

			request.getRequestDispatcher("CookSearch.jsp").forward(request, response);
			return;

		} else if(decision != null) {
			if(decision.equals("＜ 戻る")) {
				ArrayList<String> projectnames = new ArrayList<>();
				ProjectData projects = new ProjectData();
				projectnames = projects.ProjectNameselect();

				if (cookName == null || cookName.equals("")) {
					cookName = "";
				}
				errMsg = "";
				request.setAttribute("cookName", cookName);
				request.setAttribute("errMsg", errMsg);
				request.setAttribute("projectnames", projectnames);
				request.getRequestDispatcher("CookInfoInput.jsp").forward(request, response);
				return;

			} else if(cookName == null || cookName.equals("")) {
				ArrayList<IngredientDispInfo> ingredientDispInfoList = new ArrayList<>();
				errMsg = "料理が選択されていません。リストにチェックを入れてください。";
				cookName = "";
				ingredientName = "";

				request.setAttribute("ingredientDispInfoList", ingredientDispInfoList);
				request.setAttribute("cookName", cookName);
				request.setAttribute("ingredientName", ingredientName);
				request.setAttribute("errMsg", errMsg);
				request.getRequestDispatcher("CookSearch.jsp").forward(request, response);
			}
			errMsg = "";
			ArrayList<String> projectnames = new ArrayList<>();
			ProjectData projects = new ProjectData();
			projectnames = projects.ProjectNameselect();

			request.setAttribute("cookName", cookName);
			request.setAttribute("errMsg", errMsg);
			request.setAttribute("projectnames", projectnames);
			request.getRequestDispatcher("CookInfoInput.jsp").forward(request, response);
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
