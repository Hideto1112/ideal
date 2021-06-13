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
 * Servlet implementation class MenuMaintenanceSvl
 */
@WebServlet("/MenuMaintenanceSvl")
public class MenuMaintenanceSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuMaintenanceSvl() {
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
		//表示の初期設定
		int typeId;
System.out.println("menumainteSvl Start");
		session = request.getSession();
		if (session.getAttribute("adminInfo") == null) {
			url="home.jsp";
		}else{
		try{
			typeId=Integer.parseInt(request.getParameter("typeId"));
System.out.println("menumainteSvl typeId= " + typeId);
		}catch(NumberFormatException e){
System.out.println("menumainteSvl Start3");
			typeId=100;
		}
		try{
System.out.println("menumainteSvl 4");
		request.setAttribute("mType",MenuType.getAllType());
		request.setAttribute("menu",Menu.getMenu(typeId));
		url="menuMaintenance.jsp";
		}catch(Exception e){
			request.setAttribute("msg", e);
			url = "adminIndex.jsp";
		}
		}
System.out.println("menumainteSvl last url= " + url);
		rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
