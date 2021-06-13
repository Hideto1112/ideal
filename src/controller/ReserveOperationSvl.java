package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.IdealException;
import model.MailSend;
import model.Reserve;
import model.TableLoc;
import model.User;

/**
 * Servlet implementation class ReserveOperationSvl
 */
@WebServlet("/ReserveOperationSvl")
public class ReserveOperationSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final int INSERT = 11;
	public static final int UPDATE = 12;
	public static final int DELETE = 13;
	public static final int MAILMODE = 987;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveOperationSvl() {
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
System.out.println("rsvope start");
		RequestDispatcher rd = null;		// ディスパッチャー変数の宣言
		String url = "";							// urlを格納
		int mode = 0;
		int rsvId = 0;
		int usrId = 0;
		int yy = 0;
		int mm = 0;
		int dd = 0;
		int hh = 0;
		int mi = 0;
		int person = 0;
		int courseId = 0;
		String dateStr = null;
		String dateStr2 = null;
System.out.println("rsvope start2");

		try {
			HttpSession session = request.getSession();
			User u = (User)session.getAttribute("userInfo");
			usrId = u.getUsrId();
System.out.println("rsvope start2-1 usrId" + usrId);
			if(u == null) {
System.out.println("rsvope start3");
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			}
		}catch(IdealException e) {
			// エラーが出た場合のメッセージをセットしてuserIndex.jspに返す
			request.setAttribute("msg", e);
System.out.println("rsvope start4");
			url = "home.jsp";
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
System.out.println("rsvope start5");
		try {
			mode = Integer.parseInt(request.getParameter("mode"));
		}catch(NumberFormatException e) {
			request.setAttribute("msg", e);
			url = "home.jsp";
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
System.out.println("rsvope start6");
		try {
System.out.println("rsvope start7");
			if(request.getParameter("rsvId") == null) {
				rsvId = 0;
			}else {
				rsvId = Integer.parseInt(request.getParameter("rsvId"));
			}
System.out.println(rsvId);

			if(request.getParameter("rsvYy") != null){
				yy = Integer.parseInt(request.getParameter("rsvYy"));
System.out.println(yy);
				mm = Integer.parseInt(request.getParameter("rsvMm"));
System.out.println(mm);
				dd = Integer.parseInt(request.getParameter("rsvDd"));
System.out.println(dd);
				hh = Integer.parseInt(request.getParameter("rsvHh"));
System.out.println(hh);
				mi = Integer.parseInt(request.getParameter("rsvMi"));
System.out.println(mi);
				person = Integer.parseInt(request.getParameter("person"));
System.out.println(person);
				courseId = Integer.parseInt(request.getParameter("courseId"));
System.out.println(courseId);
				dateStr = yy + "-" + String.format("%02d", mm) + "-" + String.format("%02d", dd) + "T" + String.format("%02d", hh) + ":" + String.format("%02d", mi);
				dateStr2 = yy + "-" + String.format("%02d", mm) + "-" + String.format("%02d", dd) + " " + String.format("%02d", hh) + ":" + String.format("%02d", mi);
System.out.println(dateStr);
	System.out.println(dateStr2);
		}

		}catch(Exception e) {
			request.setAttribute("msg", e);
			url = "home.jsp";
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}


		try {
			request.getAttribute("reserve");

		}catch(NumberFormatException e) {
			request.setAttribute("msg", e);
			url = "home.jsp";
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}

		// modeが「登録処理」
		if(mode == INSERT) {
System.out.println("reserveOpe-inert start ");
			int rId = 0;
			try {
					TableLoc tl = (TableLoc)Reserve.insertChk(dateStr, person);
System.out.println("reserveOpe-inert tl= " + tl);
							Reserve rsv = new Reserve();
						if(!(tl == null)) {
							rsv.setUsrId(usrId);
System.out.println("reserveOpe-inert tl2= " + usrId);
							rsv.setRsvDate(dateStr2);
System.out.println("reserveOpe-inert tl3= ");
							rsv.setPerson(person);
System.out.println("reserveOpe-inert tl4= ");
							rsv.setCourseId(courseId);
System.out.println("reserveOpe-inert tl5= ");
							rsv.setTableId(tl.getTableId());
System.out.println("reserveOpe-inert tl6= " + rsv.getTableId());
							Reserve r = Reserve.insert(rsv);
							rId = r.getRsvId();
							request.setAttribute("reserve", r);
							url = "reserveCompletion.jsp";
					}else {
						rsv.setUsrId(usrId);
						rsv.setRsvDate(dateStr);
						LocalDateTime d = LocalDateTime.parse(rsv.getRsvDate());
						rsv.setRsvYy(d.getYear());
System.out.println("reserveOpe-Insert year" + d.getYear());
						rsv.setRsvMm(d.getMonthValue());
System.out.println("reserveOpe-Insert month" + d.getMonthValue());
						rsv.setRsvDd(d.getDayOfMonth());
System.out.println("reserveOpe-Insert month" + d.getDayOfMonth());
						rsv.setRsvHh(d.getHour());
System.out.println("reserveOpe-Insert month" + d.getHour());
						rsv.setRsvMi(d.getMinute());
System.out.println("reserveOpe-Insert month" + d.getMinute());
						rsv.setUsrId(usrId);
						rsv.setPerson(person);
						rsv.setCourseId(courseId);
						request.setAttribute("reserve", rsv);
						throw new IdealException(IdealException.ERR_NOT_NOT_VACANCY);
					}
System.out.println("reserveOpe-Insert17");

			}catch(IdealException e) {
				// エラーが出た場合のメッセージをセットしてuserIndex.jspに返す
System.out.println("reserveOpe-Insert18");
				request.setAttribute("msg", e);
				url = "ReserveInsertSvl";

			}finally {
System.out.println("reserveOpe-Insert18");
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			}

			try {
				MailSend.send(mode, rId);
			} catch (IdealException e) {
				e.printStackTrace();
			}
System.out.println("reserveOpe-Insert19");
		}
		// modeが「変更処理」
		if(mode == UPDATE) {
System.out.println("reserveOpe-UPDATE");
			try {

				TableLoc tl = (TableLoc)Reserve.updateChk(rsvId,dateStr,person);
System.out.println("reserveOpe-tl= " + tl);
				Reserve rsv = new Reserve();
				if(!(tl == null)) {
					rsv.setRsvId(rsvId);
System.out.println("reserveOpe-tl2= ");
					rsv.setRsvDate(dateStr2);
System.out.println("reserveOpe-tl3= ");
					rsv.setPerson(person);
System.out.println("reserveOpe-tl4= ");
					rsv.setCourseId(courseId);
System.out.println("reserveOpe-tl5= ");
					rsv.setTableId(tl.getTableId());
System.out.println("reserveOpe-tl6= " + rsv.getTableId());
					Reserve r = Reserve.update(rsv);
					request.setAttribute("reserve", r);
					url = "ReserveListSvl";

				}else {
					rsv.setRsvId(rsvId);
					rsv.setRsvDate(dateStr);
System.out.println("rsvopesvl 90 " + rsv.getRsvDate());
					LocalDateTime d = LocalDateTime.parse(rsv.getRsvDate());
System.out.println("rsvopesvl 99 " + d);
					rsv.setRsvYy(d.getYear());
System.out.println("rsvopesvl 98 " + rsv.getRsvDate());
System.out.println("rsvopesvl 99 " + rsv.getRsvYy());
					rsv.setRsvMm(d.getMonthValue());
					rsv.setRsvDd(d.getDayOfMonth());
					rsv.setRsvHh(d.getHour());
					rsv.setRsvMi(d.getMinute());
					rsv.setUsrId(usrId);
System.out.println("rsvopesvl 100" + rsv.getUsrId());
					rsv.setPerson(person);
System.out.println("rsvopesvl 102" + rsv.getPerson());
					rsv.setCourseId(courseId);
System.out.println("rsvopesvl 103" + rsv.getCourseId());
					request.setAttribute("reserve", rsv);

					throw new IdealException(IdealException.ERR_NOT_NOT_VACANCY);
				}
			}catch(IdealException e) {
				// エラーが出た場合のメッセージをセットしてuserIndex.jspに返す
System.out.println("rsvopesvl 104");
				request.setAttribute("msg", e);
				url = "ReserveUpdateSvl";

			}finally {
System.out.println("rsvopesvl 105" + url);
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			}
		}
		// modeが「削除処理」
		if(mode == DELETE) {
			try {
				Reserve rsv = Reserve.getReserve(rsvId);
				Reserve.delete(rsv);
				ArrayList<Reserve> al  = Reserve.getReserveList(usrId);
				request.setAttribute("reserveList", al);
				url = "ReserveListSvl";
			}catch(IdealException e) {

			}
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}

}
