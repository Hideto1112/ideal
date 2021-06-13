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
import model.MailSend;
import model.User;

/**
 * Servlet implementation class UserOperationSvl
 */
@WebServlet("/UserOperationSvl")
public class UserOperationSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final int INSERT = 11;
	public static final int UPDATE = 12;
	public static final int DELETE = 13;
	public static final int MAILMODE = 123;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserOperationSvl() {
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

		int usrId = 0 ;							// 取得したsessionからusrId取得用変数の宣言
		int mode = 0;
		int mailMode = 0;
		//modeをリクエストパラメーターから受け取る
		try {
			mode = Integer.parseInt(request.getParameter("mode"));
			mailMode = Integer.parseInt(request.getParameter("mailMode"));
		}catch(NumberFormatException e) {
			response.sendRedirect("home.jsp");
		}

			// 顧客登録
			if(mode == INSERT) {
System.out.println("userope insert start");
				// Userオブジェクトを生成
				User u = new User();
				// パラメーターを取得
				u.setUsrName(request.getParameter("usrName"));
				u.setAddress(request.getParameter("address"));
				u.setPhone(request.getParameter("phone"));
				u.setMail(request.getParameter("mail"));
				u.setPassword(request.getParameter("password"));

				try {
					// DBにINSERT
					User user = User.insert(u);
					// INSERTしたusrIdを取得
					usrId = user.getUsrId();
					// INSERTした顧客情報取得
					user = User.getUser(usrId);

					// 取得した顧客情報取得をsessionに設定
					HttpSession session = request.getSession();
					session.setAttribute("userInfo",user);
					//設定したsessionをuserInsertCompletion.jspに返す
					url = "hiddenUser.jsp";

					if(user == null) {
						throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
					}
				}catch(IdealException e) {
					// エラーが出た場合のメッセージをセットしてuserIndex.jspに返す
					request.setAttribute("msg", e);
					url = "userInsert.jsp";
					rd = request.getRequestDispatcher(url);
					rd.forward(request, response);
				}
				try {
System.out.println("userope insert mode usr id" + mailMode + " & " + usrId);
					MailSend.send(mailMode, usrId);
				} catch (IdealException e) {
					e.printStackTrace();
				}


			// 顧客情報更新処理
			}else if(mode == UPDATE) {
				System.out.println("1" + mode);
				HttpSession session = request.getSession();
				User u = (User)session.getAttribute("userInfo");
				// パラメーターを取得
				u.setUsrName(request.getParameter("usrName"));
				u.setAddress(request.getParameter("address"));
				u.setPhone(request.getParameter("phone"));
				u.setMail(request.getParameter("mail"));
				u.setPassword(request.getParameter("password"));


//				u.setUsrId(u.getUsrId());
				try {
					// DBにINSERT
					User user = User.update(u);
					usrId = user.getUsrId();
					// INSERTした顧客情報取得
					User newUser = User.getUser(usrId);

					// 取得した顧客情報取得をsessionに設定
					session.setAttribute("userInfo",newUser);
					//設定したsessionをuserIndex.jspに返す
					url = "userIndex.jsp";

					if(newUser == null) {
						throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
					}


				}catch(IdealException e) {
					// エラーが出た場合のメッセージをセットしてuserIndex.jspに返す
					request.setAttribute("msg", e);
					url = "userIndex.jsp";
					rd = request.getRequestDispatcher(url);
					rd.forward(request, response);
				}


			// 顧客情報更新処理
			}else if(mode == DELETE) {
				System.out.println("1" + mode);
				HttpSession session = request.getSession();
				// パラメーターを取得
				int id = Integer.parseInt(request.getParameter("usrId"));

				try {
					User u =	User.getUser(id);
					// DBにDELETE
					User.delete(u);
					session.removeAttribute("userInfo");
					session.invalidate();
					url = "home.jsp";

							}catch(Exception ex) {
								// エラーが出た場合のメッセージをセットしてuserIndex.jspに返す
								try{
									throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
								}catch(IdealException e){
									request.setAttribute("msg", e);
									url = "userIndex.jsp";
									rd = request.getRequestDispatcher(url);
									rd.forward(request, response);
								}
							}
						}

			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
	}

}
