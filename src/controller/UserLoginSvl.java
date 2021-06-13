package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.IdealException;
import model.User;

/**
 * Servlet implementation class UserLoginSvl
 */
@WebServlet("/UserLoginSvl")
public class UserLoginSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher rd = null;
			int usrId;
			String password = "";
			User u = null;
			String url;

		try {
			usrId = Integer.parseInt(request.getParameter("usrId"));
			password = request.getParameter("password");
			u = User.login(usrId, password);
			if(u != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userInfo",u);
				url = "userIndex.jsp";
				rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
				return;
			}else if(u == null) {
				throw new IdealException(IdealException.ERR_NO_NOT_MEMBER_EXCEPTION);
			}

		}catch(IdealException e) {
			request.setAttribute("msg", e);
			url = "userLogin.jsp";
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);

		}

	}

}
