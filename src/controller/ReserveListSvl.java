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

import model.IdealException;
import model.Reserve;
import model.User;
/**
 * Servlet implementation class ReserveListSvl
 */
@WebServlet("/ReserveListSvl")
public class ReserveListSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveListSvl() {
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

		// request,responseの文字コード設定
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");

				RequestDispatcher rd = null;		// ディスパッチャー変数の宣言
				String url = "";							// urlを格納
				int usrId;
				ArrayList<Reserve> al = new ArrayList<Reserve>();

				try {
					HttpSession session = request.getSession();
					User u = (User)session.getAttribute("userInfo");
System.out.println("rsvListSvl u= " + u);
					usrId = u.getUsrId();
System.out.println("rsvListSvl usrId= " + usrId);
					al = Reserve.getReserveList(usrId);
					request.setAttribute("reserveList", al);
					url = "reserveList.jsp";

					if(al == null) {
						throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
					}
				}catch(IdealException e) {
					// エラーが出た場合のメッセージをセットしてuserIndex.jspに返す
					request.setAttribute("msg", e);
					url = "userIndex.jsp";
					rd = request.getRequestDispatcher(url);
					rd.forward(request, response);
				}
				rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
	}

}
