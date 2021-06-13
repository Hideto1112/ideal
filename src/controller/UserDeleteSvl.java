package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet implementation class UserDeleteSvl
 */
@WebServlet("/UserDeleteSvl")
public class UserDeleteSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher rd = null;
		HttpSession session = null;
		String url ="";

		try{

			session = request.getSession();
			User u = (User)session.getAttribute("userInfo");
			if(u == null){

				response.sendRedirect("home.jsp");
			}else{
				request.setAttribute("user", User.getUser(u.getUsrId()));
				url = "userDelete.jsp";
			}

		}catch(Exception e){
			System.out.println("こっち？");
			session.setAttribute("msg", e);
			url = "userIndex.jsp";
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
