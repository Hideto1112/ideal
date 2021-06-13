package controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Course;
import model.Reserve;

/**
 * Servlet implementation class ReserveInsertSvl
 */
@WebServlet("/ReserveInsertSvl")
public class ReserveInsertSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReserveInsertSvl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher rd = null;
		HttpSession session = null;
		String url = "";
		int rsvYy = 0;
		int rsvMm = 0;
		int rsvDd = 0;
		int rsvHh = 0;
		int rsvMi = 0;
		int usrId = 0;
		int person = 0;;
		int courseId = 0;;

		try {
			// セッション情報を取得
			session = request.getSession();
			if (session.getAttribute("userInfo") == null) {

				response.sendRedirect("home.jsp");
			} else {
				try {
					//パラメータ（予約情報）を取得
System.out.println("reserveInsSvl01");
					rsvYy = Integer.parseInt(request.getParameter("y"));
System.out.println("reserveInsSvl02");
					rsvMm = Integer.parseInt(request.getParameter("m"));
System.out.println("reserveInsSvl03");
					rsvDd = Integer.parseInt(request.getParameter("d"));
System.out.println("reserveInsSvl04");
					rsvHh = Integer.parseInt(request.getParameter("h"));
System.out.println("reserveInsSvl05");
					rsvMi = Integer.parseInt(request.getParameter("mi"));
System.out.println("reserveInsSvl06");
					if(request.getParameter("pe") != null) {
					person = Integer.parseInt(request.getParameter("pe"));
					}else {
						person = 0;
					}
System.out.println("reserveInsSvl07");
					if(request.getParameter("cId") != null) {
					courseId = Integer.parseInt(request.getParameter("cId"));
					}else {
						courseId = 0;
					}
				} catch (NumberFormatException e) {
					//変換時に例外が発生した場合、0を設定する。
					rsvYy = 0;
					rsvMm = 0;
					rsvDd = 0;
					rsvHh = 0;
					rsvMi = 0;
					person = 0;
					courseId = 0;
				}
				//リクエストオブジェクト"couseList"にオーダー可能なコースの一覧情報を設定する。
System.out.println("1:" + rsvYy +1);
				request.setAttribute("courseList", Course.getOneCourseList());
System.out.println("2:" + rsvYy +2);
				//取得したパラメータより、予約情報を設定する。
				Reserve r =  new Reserve();
				if(rsvYy != 0){
					r.setRsvYy(rsvYy);
					r.setRsvMm(rsvMm);
					r.setRsvDd(rsvDd);
					r.setRsvHh(rsvHh);
					r.setRsvMi(rsvMi);
					r.setUsrId(usrId);
					r.setPerson(person);
					r.setCourseId(courseId);
				}else if(request.getAttribute("reserve") != null) {
					System.out.println("rsvupdate02");
					r = (Reserve)request.getAttribute("reserve");
System.out.println("rsvinsert r :" + r);
System.out.println("rsvinsert r :" + r.getRsvDate());
				}else{
					//予約日時が0の時、現在の日時を設定する。
					Calendar cal = Calendar.getInstance();
					r.setRsvYy(cal.get(Calendar.YEAR));
					r.setRsvMm(cal.get(Calendar.MONTH) + 1);
					r.setRsvDd(cal.get(Calendar.DATE));
					r.setRsvHh(cal.get(Calendar.HOUR_OF_DAY));
					r.setRsvMi(cal.get(Calendar.MINUTE));
					r.setPerson(person);
					r.setCourseId(courseId);
System.out.println("3:" + r.getRsvYy());
				}

				//リクエストオブジェクト"reserve"に予約情報を設定する。
				request.setAttribute("reserve", r);
				url = "reserveInsert.jsp";
			}

		} catch (Exception e) {
			session.setAttribute("msg", e);
			//e.printStackTrace();
			url = "ReserveListSvl.java";

		}finally{
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}

}
