package controller;

import java.io.IOException;

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
 * Servlet implementation class ReserveUpdateSvl
 */
@WebServlet("/ReserveUpdateSvl")
public class ReserveUpdateSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveUpdateSvl() {
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
		String url = "";
		int rsvId = 0;
		Reserve reserve;


		try {
			// セッション情報を取得
			session = request.getSession();
			if (session.getAttribute("userInfo") == null) {
				response.sendRedirect("home.jsp");
			} else {
				//リクエストパラメーター"rsvId"を取得

				rsvId = Integer.parseInt(request.getParameter("rsvId"));

				//リクエストオブジェクト"couseList"にオーダー可能なコースの一覧情報を設定する。
				request.setAttribute("courseList", Course.getOneCourseList());
				//取得したパラメータより、予約情報を設定する。
				//リクエストオブジェクト"reserve"にリクエストパラメーターのrsvIdに
				// 対応する予約情報を設定する。
				reserve = Reserve.getReserve(rsvId);
				if(request.getParameter("y") != null){
					int y = Integer.parseInt((request.getParameter("y")));
					int m = Integer.parseInt((request.getParameter("m")));
					int d = Integer.parseInt((request.getParameter("d")));
					int h = Integer.parseInt((request.getParameter("h")));
					int mi = Integer.parseInt((request.getParameter("mi")));
					int person = Integer.parseInt((request.getParameter("pe")));
					int cId =Integer.parseInt((request.getParameter("cId")));


					reserve.setRsvYy(y);
					reserve.setRsvMm(m);
					reserve.setRsvDd(d);
					reserve.setRsvHh(h);
					reserve.setAppMi(mi);
					reserve.setPerson(person);
					reserve.setCourseId(cId);
				}
				if(request.getAttribute("reserve") != null) {
					System.out.println("rsvupdate02");
										reserve = (Reserve)request.getAttribute("reserve");
					System.out.println("rsvupdate03 rsv " + reserve);
					System.out.println("rsvupdate033 rsv " + reserve.getRsvDate());
									}
				request.setAttribute("reserve", reserve);
				url = "reserveUpdate.jsp";
System.out.println("rsvupdate04 url " + url);
			}

		} catch (Exception e) {
System.out.println("rsvupdate05");
			session.setAttribute("msg", e);
			//e.printStackTrace();
			url = "ReserveListSvl.java";

		}finally{
System.out.println("rsvupdate06" + url);
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
System.out.println("rsvupdate07");
		}
	}


}
