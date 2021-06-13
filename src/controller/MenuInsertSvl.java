package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Menu;
import model.MenuType;

/**
 * Servlet implementation class MenuInsertSvl
 */
@WebServlet("/MenuInsertSvl")
public class MenuInsertSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuInsertSvl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/thml:charset=UTF-8");

		RequestDispatcher rd = null;
		String url = "";
		HttpSession session = null;

System.out.println("menu insert svl start");
		int typeId;
		session = request.getSession();
		System.out.println(session.getAttribute("adminInfo"));
		if (session.getAttribute("adminInfo") == null) {
			url = "home.jsp";
		} else {
			try {
				typeId = Integer.parseInt(request.getParameter("typeId"));
System.out.println("menuinsertSvl typeId= " + typeId);
			} catch (NumberFormatException e) {
				typeId = 100;
			}
System.out.println("menu insert svltypeId= " + typeId);
			try {
				if (typeId == 100) {

					request.setAttribute("typeMenuList", Menu.getMenuList());
					url = "courseInsert.jsp";
System.out.println("menu insert svl start2");
				} else {
					request.setAttribute("mType", MenuType.getAllType());
					request.setAttribute("typeId", typeId);
					url = "menuInsert.jsp";
System.out.println("menu insert svl start3");
				}
			} catch (Exception e) {
System.out.println("menu insert svl start4");
				request.setAttribute("msg", e);
				url = "menuMaintenance.jsp";
			}
		}
System.out.println("menu insert svl start5 url= " + url);
		rd = request.getRequestDispatcher(url);
System.out.println("menu insert svl start5-2 url= " + url);
		rd.forward(request, response);
System.out.println("menu insert svl start6 url= " + url);
	}

}
