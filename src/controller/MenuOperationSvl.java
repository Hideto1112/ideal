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

/**
 * Servlet implementation class MenuOperationSvl
 */
@WebServlet("/MenuOperationSvl")
public class MenuOperationSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int INSERT = 11;
	public static int UPDATE = 12;
	public static int DELETE = 13;
	public static int[] COURSE_MENU_TYPE_ID = { 200, 210, 220, 300, 310, 400 };

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuOperationSvl() {
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
		doPost(request,response);
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

		int mode=0;
		String menuName=null;
		String detail=null;
		int orderFlg;
		int price;
		int typeId;
		int menuId;

		session = request.getSession();
		if (session.getAttribute("adminInfo") == null) {
			url="home.jsp";
	}else{
		try {
		mode = Integer.parseInt(request.getParameter("mode"));
		menuName = request.getParameter("menuName");
		detail = request.getParameter("detail");

		try {
				orderFlg = Integer.parseInt(request.getParameter("orderFlg"));
			} catch (Exception e) {
				orderFlg = 0;
			}
		try {
				price = Integer.parseInt(request.getParameter("price"));
			} catch (Exception e) {
				price = 0;
			}
			try {
				typeId = Integer.parseInt(request.getParameter("typeId"));
			} catch (Exception e) {
				typeId = 0;
			}
			try {
				menuId = Integer.parseInt(request.getParameter("menuId"));
			} catch (Exception e) {
				menuId = 0;
			}



				Menu m = new Menu();
				m.setMenuName(menuName);
				m.setDetail(detail);
				m.setOrderFlg(orderFlg);
				m.setPrice(price);
				m.setTypeId(typeId);
				m.setMenuId(menuId);
				Menu.updateMenu(m, mode);
				request.setAttribute("typeId", typeId);
				url = "MenuMaintenanceSvl";
			} catch (Exception e) {
				request.setAttribute("msg", e);
				if (mode == MenuOperationSvl.INSERT) {
					url = "menuInsert.jsp";
				} else if (mode == MenuOperationSvl.UPDATE) {
					url = "menuUpdate.jsp";
				} else if (mode == MenuOperationSvl.DELETE) {
					url = "menuDelete.jsp";
				}
			}
	}
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
