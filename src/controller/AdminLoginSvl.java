package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.IdealException;

/**
 * Servlet implementation class AdminLoginSvl
 */
@WebServlet("/AdminLoginSvl")
public class AdminLoginSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		// TODO Auto-generated method stub
		RequestDispatcher rd=null;
		String url="";
		Admin a =null;

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/thml:charset=UTF-8");

		String admName;
		String password;

		try{
			System.out.println("1");
		admName=request.getParameter("admName");
		password=request.getParameter("password");
		a = Admin.login(admName, password);
		System.out.println("2" + a);
		if(a!=null){
		HttpSession session =request.getSession();
		session.setAttribute("adminInfo", a);
		url="adminIndex.jsp";

		}else{
			throw new IdealException(IdealException.ERR_NO_ADMIN_EXCEPTION);
		}

		}catch(Exception e){
			request.setAttribute("msg", e);
			url = "adminLogin.jsp";
		}
		rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}