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

import model.Course;
import model.CourseCtl;

/**
 * Servlet implementation class CourseOperationSvl
 */
@WebServlet("/CourseOperationSvl")
public class CourseOperationSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static int INSERT=21;
    public static int UPDATE=22;
    public static int DELETE=23;
    public static int[] COURSE_MENU_TYPE_ID={200,210,220,300,310,400};
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseOperationSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd=null;
		String url="";
		HttpSession session = null;
		//表示の初期設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/thml:charset=UTF-8");
		//パラメータをセットする用のフィールド
		int typeId;
		int courseId;
		int mode;
		int appetizerId=0;
		int soupId=0;
		int pastaId=0;
		int meatId=0;
		int fishId=0;
		int desserId=0;
System.out.println("courseopesvl star");

		session = request.getSession();
		if (session.getAttribute("adminInfo") == null) {
			url="home.jsp";
	}else{
		try{
			mode=Integer.parseInt(request.getParameter("mode"));
		}catch(Exception e){
			mode=100;
		}
		try{
			typeId=Integer.parseInt(request.getParameter("typeId"));
		}catch(Exception e){
			typeId=0;
		}
		try{
			courseId=Integer.parseInt(request.getParameter("courseId"));
		}catch(Exception e){
			courseId=0;
		}
		try{
			 appetizerId=(Integer.parseInt(request.getParameter("appetizerId")));
		}catch(Exception e){
			appetizerId=0;
		}
		try{
			soupId=(Integer.parseInt(request.getParameter("soupId")));
		}catch(Exception e){
			soupId=0;
		}
		try{
			pastaId=(Integer.parseInt(request.getParameter("pastaId")));
		}catch(Exception e){
			pastaId=0;
			}
		try{
			pastaId=(Integer.parseInt(request.getParameter("pastaId")));
		}catch(Exception e){
			pastaId=0;
		}
		try{
			meatId=(Integer.parseInt(request.getParameter("meatId")));
		}catch(Exception e){
			meatId=0;
			}
		try{
			fishId=(Integer.parseInt(request.getParameter("fishId")));
		}catch(Exception e){
			fishId=0;
		}
		try{
			desserId=(Integer.parseInt(request.getParameter("desserId")));
		}catch(Exception e){
			desserId=0;
			}
		try{
		if(mode==INSERT){
			Course c =new Course();
			c.setCourseName(request.getParameter("courseName"));
			c.setDetail(request.getParameter("detail"));
			c.setOrderFlg(Integer.parseInt(request.getParameter("orderFlg")));
			c.setPrice(Integer.parseInt(request.getParameter("price")));
			c.setTypeId(typeId);

			CourseCtl ApperizerId= new CourseCtl();
			ApperizerId.setM_Id(appetizerId);
			CourseCtl SoupId=new CourseCtl();
			SoupId.setM_Id(soupId);
			CourseCtl PastaId=new CourseCtl();
			PastaId.setM_Id(pastaId);
			CourseCtl MeatId=new CourseCtl();
			MeatId.setM_Id(meatId);
			CourseCtl FishId=new CourseCtl();
			FishId.setM_Id(fishId);
			CourseCtl DesserId=new CourseCtl();
			DesserId.setM_Id(desserId);

			ArrayList<CourseCtl> coursectl=new ArrayList<CourseCtl>();
			coursectl.add(ApperizerId);
			coursectl.add(SoupId);
			coursectl.add(PastaId);
			coursectl.add(MeatId);
			coursectl.add(FishId);
			coursectl.add(DesserId);

			Course.updateCourse(c, mode, coursectl);
System.out.println("courseopesvl10 typeId= " + typeId);
			request.setAttribute("type",typeId);
			url="hiddenCourse.jsp";
		}else if(mode==UPDATE){
			Course c =new Course();
			c.setCourseId(courseId);
			c.setCourseName(request.getParameter("courseName"));
			c.setDetail(request.getParameter("detail"));
			c.setOrderFlg(Integer.parseInt(request.getParameter("orderFlg")));
			c.setPrice(Integer.parseInt(request.getParameter("price")));
			c.setTypeId(typeId);

			CourseCtl ApperizerId= new CourseCtl();
			ApperizerId.setM_Id(appetizerId);
			CourseCtl SoupId=new CourseCtl();
			SoupId.setM_Id(soupId);
			CourseCtl PastaId=new CourseCtl();
			PastaId.setM_Id(pastaId);
			CourseCtl MeatId=new CourseCtl();
			MeatId.setM_Id(meatId);
			CourseCtl FishId=new CourseCtl();
			FishId.setM_Id(fishId);
			CourseCtl DesserId=new CourseCtl();
			DesserId.setM_Id(desserId);

			ArrayList<CourseCtl> coursectl=new ArrayList<CourseCtl>();
			coursectl.add(ApperizerId);
			coursectl.add(SoupId);
			coursectl.add(PastaId);
			coursectl.add(MeatId);
			coursectl.add(FishId);
			coursectl.add(DesserId);

			Course.updateCourse(c, mode, coursectl);

			request.setAttribute("type",typeId);
			url="MenuMaintenanceSvl";
		}else if(mode==DELETE){
			Course c =new Course();
			c.setCourseId(courseId);

			ArrayList<CourseCtl> coursectl=new ArrayList<CourseCtl>();

			Course.updateCourse(c, mode, coursectl);

			request.setAttribute("type",typeId);
			url="MenuMaintenanceSvl";
		}else{
		}
		}catch(Exception e){
			e.printStackTrace();

		}
	}
System.out.println("courseopesvl last url= " + url);
		rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
