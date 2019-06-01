package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		String errmsg = "";
		String view = request.getParameter("view");
		System.out.println("view = " + view);

		if(view.equals("home")) {

			request.getRequestDispatcher("TopMenu.jsp").forward(request, response);

		} else if (view.equals("CookInfoInput")){

			String projectName = "";
			String cookName = "";
			int member = 0;
			String errMsg = "";
			request.setAttribute("projectName", projectName);
			request.setAttribute("cookName", cookName);
			request.setAttribute("member", member);
			request.setAttribute("errMsg", errMsg);

			request.getRequestDispatcher("CookInfoInput.jsp").forward(request, response);

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
