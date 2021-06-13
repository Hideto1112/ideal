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
import model.MenuType;

/**
 * Servlet implementation class MenuUpdateSvl
 */
@WebServlet("/MenuUpdateSvl")
public class MenuUpdateSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuUpdateSvl() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/thml:charset=UTF-8");

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
			if(typeId==100){
			System.out.println("course"+menuId);
			}else{
				System.out.println("menu"+menuId);
			}
		}catch(NumberFormatException e){
			menuId=100;
		}
		try{
			if(typeId==100){
				request.setAttribute("typeMenuList", Menu.getMenuList());
				request.setAttribute("oneCourse", Course.getOneCourse(menuId));
				url="courseUpdate.jsp";
			}else{
				request.setAttribute("mType",MenuType.getAllType());
				request.setAttribute("typeId",typeId);
				request.setAttribute("oneMenu",Menu.getOneMenu(menuId, typeId));
				url="menuUpdate.jsp";
			}
		}catch(Exception e){
			request.setAttribute("msg", e);
			url = "menuMaintenance.jsp";
		}
		}
		rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
