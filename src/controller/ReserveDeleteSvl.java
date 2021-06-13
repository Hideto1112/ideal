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
import model.Reserve;
import model.User;
/**
 * Servlet implementation class ReserveDeleteSvl
 */
@WebServlet("/ReserveDeleteSvl")
public class ReserveDeleteSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveDeleteSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// request,responseの文字コード設定
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");

				RequestDispatcher rd = null;		// ディスパッチャー変数の宣言
				String url = "";					// urlを格納
				int rsvId;							// 予約番号変数の宣言
				Reserve rsv = new Reserve();
				try {
					HttpSession session = request.getSession();
					User u = (User)session.getAttribute("userInfo");
					if(u == null) {
						url = "home.jsp";
						response.sendRedirect(url);
					}
					rsvId = Integer.parseInt(request.getParameter("rsvId"));
					rsv = Reserve.getReserve(rsvId);
					request.setAttribute("reserve", rsv);
					url = "reserveDelete.jsp";
					if(rsv == null) {
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
