package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BaseDate;
import model.IdealException;
import model.Status;
import model.User;

/**
 * Servlet implementation class StatusSvl
 */
@WebServlet("/StatusSvl")
public class StatusSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String[] RSV_TIME = {
		"17:00","17:15","17:30","17:45",
		"18:00","18:15","18:30","18:45",
		"19:00","19:15","19:30","19:45",
		"20:00","20:15","20:30","20:45",
		"21:00",
	};

	public static final int ORIGINAL_DATE = 777;
	public static final int NEXT_WEEK = 77;
	public static final int PREVIOUS_WEEK = 7;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusSvl() {
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
System.out.println("statussvl start");
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
				String dateStr = "";
				String dateStr2 = "";
				String baseDate = "";
System.out.println("statussvl start2");


				try {
					HttpSession session = request.getSession();
					User u = (User)session.getAttribute("userInfo");
					usrId = u.getUsrId();
System.out.println("rsvope start2-1 usrId= " + usrId);
					if(u == null) {
System.out.println("rsvope start3");
						throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
					}
				}catch(IdealException e) {
					// エラーが出た場合のメッセージをセットしてuserIndex.jspに返す
					request.setAttribute("msg", e);
System.out.println("statussvl start4");
					url = "home.jsp";
					rd = request.getRequestDispatcher(url);
					rd.forward(request, response);
				}
System.out.println("statussvl start5");

				try{
					mode = Integer.parseInt(request.getParameter("mode"));
					if(mode == StatusSvl.ORIGINAL_DATE) {
System.out.println("statussvl start5-777 mode= " + mode);
						LocalDate ldt = LocalDate.now();
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						baseDate = dtf.format(ldt);
System.out.println("statussvl start5-777 baseDate= " + baseDate);
					}else if(mode == StatusSvl.NEXT_WEEK) {
						baseDate = request.getParameter("baseDate");
System.out.println("statussvl start5-77 mode= " + mode);
System.out.println("statussvl start5-77 baseDate= " + baseDate);
						LocalDate ldt = LocalDate.parse(baseDate).plusWeeks(1L);
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						baseDate = dtf.format(ldt);
					}else if(mode == StatusSvl.PREVIOUS_WEEK) {
						baseDate = request.getParameter("baseDate");
System.out.println("statussvl start5-7 mode= " + mode);
System.out.println("statussvl start5-7 baseDate= " + baseDate);
						LocalDate ldt = LocalDate.parse(baseDate).minusWeeks(1L);
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						baseDate = dtf.format(ldt);
					}
				}catch(Exception e){

				}


				try {
System.out.println("statussvl start6");
						ArrayList<Status> al = new ArrayList<Status>();
						Status sts = null;
				for(int j = 0; j < 14; j++) {
					LocalDate ldt = LocalDate.parse(baseDate).plusDays(1 + j);
					yy = ldt.getYear();
					mm = ldt.getMonthValue();
					dd = ldt.getDayOfMonth();
System.out.println("statussvl ldt= " + dd);


						for(int i = 0; i < RSV_TIME.length; i++) {
							dateStr = yy + "-" + String.format("%02d", mm) + "-" + String.format("%02d", dd) + "T" + RSV_TIME[i];
System.out.println("statussvl dateStr= " + dateStr);
						sts = Status.statusChk(dateStr);
						al.add(sts);
						}
System.out.println("statussvl al= " + al);
						request.setAttribute("status", al);
						BaseDate bd = new BaseDate();
						bd.setBaseDate(baseDate);
						request.setAttribute("baseDate", bd);
System.out.println("statussvl start bd= " + bd.getBaseDate());

				}
						url ="status.jsp";
System.out.println("statussvl start7");
					}catch(IdealException e) {
System.out.println("statussvl start8");
						request.setAttribute("msg", e);
						url = "home.jsp";
						rd = request.getRequestDispatcher(url);
						rd.forward(request, response);
					}
System.out.println("statussvl start9");
System.out.println("statussvl start10= " + baseDate);
				rd = request.getRequestDispatcher(url);
				rd.forward(request, response);


	}


}
