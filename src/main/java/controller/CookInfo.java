package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			request.setAttribute("projectName", projectName);
			request.setAttribute("cookName", cookName);
			request.setAttribute("member", member);

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

				request.setAttribute("projectName", projectName);
				request.setAttribute("cookName", cookName);
				request.setAttribute("member", member);
				request.setAttribute("errMsg", errMsg);

				// 未入力 自画面遷移
				request.getRequestDispatcher("CookInfoInput.jsp").forward(request, response);
				return;
			}

			request.setAttribute("projectName", projectName);
			request.setAttribute("cookName", cookName);
			request.setAttribute("member", member);

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
