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
 * Servlet implementation class UserUpdateSvl
 */
@WebServlet("/UserUpdateSvl")
public class UserUpdateSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateSvl() {
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
		String url;							// urlを格納
		User u = null;						// session取得のためのユーザー型変数の宣言
		User user = null;					// 顧客情報取得のためのユーザー型変数の宣言
		int usrId ;							// 取得したsessionからusrId取得用変数の宣言
		try {
		//セッション情報(userInfo)の取得
		HttpSession session = request.getSession();
		u = (User)session.getAttribute("userInfo");
		// ユーザーID取得
		usrId =u.getUsrId();
		// ユーザーIDから顧客情報取得
		user = User.getUser(usrId);
System.out.println("UserUpdateSvl.usrId:" + user.getUsrId());
			if(user != null) {
				// 顧客情報をセッションにセット&userUpdate.jspに送る
				request.setAttribute("user", user);
				url = "userUpdate.jsp";
				rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			}else if(user == null) {
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			}

		}catch(IdealException e) {
			// エラーが出た場合のメッセージをセットしてuserIndex.jspに返す
			request.setAttribute("msg", e);
			url = "userIndex.jsp";
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);

		}
	}
}
