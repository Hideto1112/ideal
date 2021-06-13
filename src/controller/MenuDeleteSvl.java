package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Course;
import model.Menu;

/**
 * Servlet implementation class MenuDeleteSvl
 */
@WebServlet("/MenuDeleteSvl")
public class MenuDeleteSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuDeleteSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd=null;
		String url="";
		HttpSession session = null;

		int typeId;
		int menuId;

		session = request.getSession();
		if (session.getAttribute("adminInfo") == null) {
			url="home.jsp";
		}else{
		try{
			typeId=Integer.parseInt(request.getParameter("typeId"));
			System.out.println("TOP" + typeId);
		}catch(NumberFormatException e){
			typeId=100;
		}
		try{
			menuId=Integer.parseInt(request.getParameter("menuId"));
		}catch(NumberFormatException e){
			menuId=100;
		}
		try{
			if(typeId==100){
System.out.println("menudel1 menuid= " + menuId);
				request.setAttribute("typeMenuList", Menu.getMenuList());
System.out.println("menudel2 ");
				request.setAttribute("oneCourse",Course.getOneCourse(menuId));
System.out.println("menudel3 ");
				request.setAttribute("typeId",typeId);
				url="courseDelete.jsp";
			}else{
				request.setAttribute("oneMenu",Menu.getOneMenu(menuId, typeId));
				url="menuDelete.jsp";

			}
		}catch(Exception e){
			request.setAttribute("msg", e);
			url = "menuMaintenance.jsp";
		}
		}
System.out.println("menudel4 " + url);
		rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
