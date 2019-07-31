package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ProjectCookDisp;
import dto.ProjectMenuInfo;
import model.ProjectMenuData;
import model.ProjectMenuHistoryData;

/**
 * Servlet implementation class ProjectCookEdit
 */
public class ProjectCookEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjectCookEdit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		// 画面遷移判断用変数
		String view = request.getParameter("view");
		// セッション情報取得
		ArrayList<ProjectCookDisp> projectCookDispList =
				(ArrayList<ProjectCookDisp>) session.getAttribute("projectCookDispList");
		String errMsg = "";

		// 情報編集用変数
		String smenuid = request.getParameter("menuid");
		String smember = request.getParameter("member");

		String[] smenus = request.getParameterValues("menus");
		String[] singredients = request.getParameterValues("ingredients");
		String[] samounts = request.getParameterValues("amounts");

		// 処理判断変数
		String recalculation = request.getParameter("recalculation");
		String save = request.getParameter("save");
		String initialize = request.getParameter("initialize");
		String sdispMenuid = request.getParameter("dispMenuid");

		// 料理を食べる人数の文字 -> 数字変換
		int member = 0;
		if (smember != null && !(smember.equals(""))) {
			member = Integer.parseInt(smember.trim());
		}

		// メニューIDの文字 -> 数字変換
		int menuid = 0;
		if (smenuid != null && !(smenuid.equals(""))) {
			menuid = Integer.parseInt(smenuid.trim());
		}

		// 表示用メニューIDの文字 -> 数字変換
		int dispMenuid = 0;
		if (sdispMenuid != null && !(sdispMenuid.equals(""))) {
			dispMenuid = Integer.parseInt(sdispMenuid.trim());
		}

		if (view.equals("EditStart")) {
			request.setAttribute("dispMenuid", dispMenuid);
			request.setAttribute("errMsg", errMsg);

			request.getRequestDispatcher("ProjectCookEdit.jsp").forward(request, response);
			return;

		} else if(view.equals("Purchase")){
			request.setAttribute("errMsg", errMsg);
			request.getRequestDispatcher("PurchaseOrderEdit.jsp").forward(request, response);
			return;

		} else if (recalculation != null) {
			for (int i = 0; i < projectCookDispList.size(); i++) {
				if (projectCookDispList.get(i).getMenuid() == menuid) {
					ProjectCookDisp tmpProjectCookDisp = projectCookDispList.get(i);
					int tmpAmount = (int) Math
							.ceil(tmpProjectCookDisp.getAmount() / tmpProjectCookDisp.getEatmember());
					tmpProjectCookDisp.setAmount(tmpAmount * member);
					tmpProjectCookDisp.setEatmember(member);

					projectCookDispList.set(i, tmpProjectCookDisp);
				}
			}
			session.setAttribute("projectCookDispList", projectCookDispList);
			request.setAttribute("dispMenuid", dispMenuid);
			request.setAttribute("errMsg", errMsg);

			request.getRequestDispatcher("ProjectCookEdit.jsp").forward(request, response);
			return;

		} else if (save != null) {
			int[] menus = new int[smenus.length];
			int[] ingredients = new int[singredients.length];
			int[] amounts = new int[samounts.length];;

			for (int i = 0; i < samounts.length; i++) {
				if ((smenus[i] != null && !(smenus[i].equals("")))
						&& (singredients[i] != null && !(singredients[i].equals("")))
						&& (samounts[i] != null && !(samounts[i].equals("")))) {

					menus[i] = Integer.parseInt(smenus[i]);
					ingredients[i] = Integer.parseInt(singredients[i]);
					amounts[i] = Integer.parseInt(samounts[i]);
				} else {
					errMsg = "分量に数字以外が入力されています。";
					request.setAttribute("errMsg", errMsg);
					request.setAttribute("dispMenuid", dispMenuid);

					request.getRequestDispatcher("ProjectCookEdit.jsp").forward(request, response);
					return;
				}
			}

			for(int i = 0; i < projectCookDispList.size(); i++) {
				ProjectMenuInfo tmpProjectMenuInfo = new ProjectMenuInfo();
				ProjectMenuData projectMenuData = new ProjectMenuData();
				tmpProjectMenuInfo.setProjectid(projectCookDispList.get(i).getProjectid());
				tmpProjectMenuInfo.setMenuid(projectCookDispList.get(i).getMenuid());
				tmpProjectMenuInfo.setIngredientid(projectCookDispList.get(i).getIngredientid());
				tmpProjectMenuInfo.setEatmember(projectCookDispList.get(i).getEatmember());
				tmpProjectMenuInfo.setAmount(projectCookDispList.get(i).getAmount());
				for (int j = 0; j < samounts.length; j++) {
					if (tmpProjectMenuInfo.getMenuid() == menus[j]
							&& tmpProjectMenuInfo.getIngredientid() == ingredients[j]) {
						tmpProjectMenuInfo.setAmount(amounts[j]);
					}
				}

				int resultCode = projectMenuData.ProjectMenuUpdate(tmpProjectMenuInfo);

				if(resultCode != 0 ) {
					errMsg = "システムエラー(プロジェクト料理編集 失敗)";
					request.setAttribute("errMsg", errMsg);
					request.getRequestDispatcher("ERROR.jsp").forward(request, response);
				}
			}

			request.setAttribute("dispMenuid", dispMenuid);
			request.setAttribute("errMsg", errMsg);
			request.getRequestDispatcher("ProjectCookDetail.jsp").forward(request, response);
			return;

		} else if (initialize != null) {
			for (int i = 0; i < projectCookDispList.size(); i++) {
				if (projectCookDispList.get(i).getMenuid() == menuid) {
					ProjectMenuInfo tmpProjectMenuInfo = new ProjectMenuInfo();
					ProjectCookDisp tmpProjectCookDisp = projectCookDispList.get(i);
					ProjectMenuHistoryData projectMenuHistoryData = new ProjectMenuHistoryData();

					int projectid = projectCookDispList.get(i).getProjectid();
					int ingredientid = projectCookDispList.get(i).getIngredientid();

					tmpProjectMenuInfo = projectMenuHistoryData.ProjectMenuHistSelect(projectid, menuid, ingredientid);
					int tmpAmount = tmpProjectMenuInfo.getAmount();
					int tmpEatmember = tmpProjectMenuInfo.getEatmember();
					tmpProjectCookDisp.setAmount(tmpAmount);
					tmpProjectCookDisp.setEatmember(tmpEatmember);

					projectCookDispList.set(i, tmpProjectCookDisp);
				}
			}
			session.setAttribute("projectCookDispList", projectCookDispList);
			request.setAttribute("dispMenuid", dispMenuid);
			request.setAttribute("errMsg", errMsg);

			request.getRequestDispatcher("ProjectCookEdit.jsp").forward(request, response);
			return;

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
