package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MenuIngredientInfo;
import dto.ProjectMenuInfo;
import model.ProjectData;
import model.ProjectMenuData;

/**
 * Servlet implementation class ProjectCookReg
 */
public class ProjectCookReg extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectCookReg() {
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
		ArrayList<MenuIngredientInfo> menuIngredientInfo
				= (ArrayList<MenuIngredientInfo>) session.getAttribute("menuIngredientDataList");

		int member = 0;
		if (smember != null && !(smember.equals(""))) {
			member = Integer.parseInt(smember);
		}
		if(member ==0 ) {
			String errMsg = "データ登録エラー (プロジェクト料理登録)";
			request.setAttribute("errMsg", errMsg);
			request.getRequestDispatcher("ERROR.jsp").forward(request, response);
			return;
		}

		ProjectData projectData = new ProjectData();
		int projectid = projectData.ProjectNameToIdSelect(projectName);

		for(int i = 0; i < menuIngredientInfo.size(); i++) {
			ProjectMenuData projectMenuData = new ProjectMenuData();
			ProjectMenuInfo projectMenuInfo = new ProjectMenuInfo();
			int id = projectMenuData.ProjectMenuIdselect();

			projectMenuInfo.setId(id);
			projectMenuInfo.setProjectid(projectid);
			projectMenuInfo.setMenuid(menuIngredientInfo.get(i).getMenuid());
			projectMenuInfo.setIngredientid(menuIngredientInfo.get(i).getIngredientid());
			projectMenuInfo.setAmount(menuIngredientInfo.get(i).getAmount() * member);
			projectMenuInfo.setUnit(menuIngredientInfo.get(i).getUnit());
			projectMenuInfo.setEatmember(member);
			projectMenuInfo.setEatdate(null);

			ArrayList<Integer> idList = new ArrayList<>();
			idList.add(id);

			int resultcode = projectMenuData.ProjectMenuInsert(projectMenuInfo);

			if(resultcode == 20) {
				for(int j = 0; j < idList.size(); j++) {
					projectMenuData.ProjectMenuDelete(idList.get(i));
				}
				String errMsg = "データ登録エラー (プロジェクト料理登録)";
				request.setAttribute("errMsg", errMsg);
				request.getRequestDispatcher("ERROR.jsp").forward(request, response);
				return;
			}
		}

		String dataMsg = projectName + " に " + cookName + " の料理情報の登録が成功しました";
		request.setAttribute("dataMsg", dataMsg);
		request.getRequestDispatcher("DataInputComplete.jsp").forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
