package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Course;
import model.IdealException;
import model.Menu;
import model.MenuType;
import model.User;

/**
 * Servlet implementation class ShowMenuSvl
 */
@WebServlet("/ShowMenuSvl")
public class ShowMenuSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowMenuSvl() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

System.out.println("shomenusvl start");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher rd = null; // ディスパッチャー変数の宣言
		User u = null;						// session取得のためのユーザー型変数の宣言
		String url = "";
System.out.println("shomenusvl 1");
		try {
			// セッション情報(userInfo)の取得
			HttpSession session = request.getSession();
			u = (User)session.getAttribute("userInfo");
System.out.println("shomenusvl u= " + u);
		}catch(Exception e) {

		}


		try {

			// リクエストオブジェクト"courseList"にオーダー可能なコース一覧を設定する.
			ArrayList<Course> c = Course.getCourseList();
			request.setAttribute("courseList", c);
System.out.println("shomenusvl2 ");
			// リクエストオブジェクト"menyuList"にオーダー可能なメニュー一覧を設定する。
			request.setAttribute("menuList", Menu.getMenuList());

			request.setAttribute("mtype", MenuType.getAllType());
System.out.println("shomenusvl2-1 ");
			//遷移先に「メニュー紹介画面(JSP)」をセット
			url = "showMenu.jsp";
System.out.println("shomenusvl3= " + url);
		} catch (IdealException e) {
System.out.println("shomenusvl exception4");
			if (u != null) {
System.out.println("shomenusvl exception2");

				url = "userIndex.jsp";
				try {
System.out.println("shomenusvl exception5");
					throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
				} catch (IdealException e1) {
					request.setAttribute("msg", e1);
				}
			} else {
System.out.println("shomenusvl exception3");
				url = "home.jsp";
				try {
					throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
				} catch (IdealException e1) {
					request.setAttribute("msg", e1);
				}
			}
		}
System.out.println("shomenusvl5");
System.out.println("shomenusvl5-1" + url);
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
System.out.println("shomenusvl6");






	}
}
