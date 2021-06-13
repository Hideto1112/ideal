package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import controller.CourseOperationSvl;

public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	private int courseId;
	private String courseName;
	private String detail;
	private int orderFlg;
	private int price;
	private int typeId;
	private String typeName;
	private int menuId;
	private String menuName;

	public static int[] COURSE_MENU_TYPE_ID = { 200, 210, 220, 300, 310, 400 };

	public static int[] getCOURSE_MENU_TYPE_ID() {
		return COURSE_MENU_TYPE_ID;
	}

	public static void setCOURSE_MENU_TYPE_ID(int[] cOURSE_MENU_TYPE_ID) {
		COURSE_MENU_TYPE_ID = cOURSE_MENU_TYPE_ID;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getOrderFlg() {
		return orderFlg;
	}

	public void setOrderFlg(int orderFlg) {
		this.orderFlg = orderFlg;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public static Course getCourse(int c_Id) throws IdealException{
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		// 変数の宣言と初期化
		Course c = null;
		String sql = null;

		try {
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mysql"); // データソースをリース
			con = ds.getConnection(); // コネクションを実装
			/* SQL文を生成 */
			sql += "select * from course join menutype using (t_id) where c_id = ?";
			pst = con.prepareStatement(sql); // プリコンパイル
			pst.setInt(1, c_Id); // INパラメーターにmenuIDをセット
			rs = pst.executeQuery(); // 実行して結果セットを取得
			while (rs.next()) {
				c = new Course();
				c.setCourseId(rs.getInt("c_id"));
				c.setCourseName(rs.getString("c_name"));
				c.setDetail(rs.getString("detail"));
				c.setOrderFlg(rs.getInt("orderFlg"));
				c.setPrice(rs.getInt("price"));
				c.setTypeId(rs.getInt("t_id"));
			}
		} catch (Exception e) { // 例外処理
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		} finally {
			try {
				if (rs != null)
					rs.close(); // クローズ処理
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) { // 例外処理
				e.printStackTrace();
			}
		}
		return c;
	}

	public static ArrayList<Course> getOneCourse(int c_Id) throws IdealException{
System.out.println("course getonecourse start");
		ArrayList<Course> al = new ArrayList<Course>(); // ArrayListオブジェクトの生成
		// DB接続の準備
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

System.out.println("course getonecourse start2");
		// 変数の宣言と初期化
		String sql = "";
System.out.println("course getonecourse start3= " + sql);
		try {
System.out.println("course getonecourse start4");
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mysql"); // データソースをリース
			con = ds.getConnection(); // コネクションを実装
			/* SQL文を生成 */
			sql = "select m_id,c_id,c_name,course.detail,course.orderFlg,course.price,m_name,menu.detail,menu.t_id,t_name "
					+ "from ideal.course join coursectl "
					+ "using (c_id) join menu using (m_id) "
					+ "join menutype on menu.t_id = menutype.t_id "
					+ "where c_Id = ?";
System.out.println("course getonecourse start5= " + sql);
			pst = con.prepareStatement(sql); // プリコンパイル
System.out.println("course getonecourse start6");
			pst.setInt(1, c_Id); // INパラメーターにmenuIDをセット
System.out.println("course getonecourse start7");
			rs = pst.executeQuery(); // 実行して結果セットを取得
System.out.println("course getonecourse1= " + pst.toString());

			if(rs.next()){
				rs.close();
				rs=pst.executeQuery();
				while (rs.next()) { // 全行分繰り返す
				Course c = new Course();
				c.setCourseId(rs.getInt("c_id"));
System.out.println("course getonecourse2-1= " + c.getCourseId());
				c.setCourseName(rs.getString("c_name"));
System.out.println("course getonecourse2-2= " + c.getCourseName());
				c.setDetail(rs.getString("course.detail"));
System.out.println("course getonecourse2-3= " + c.getDetail());
				c.setOrderFlg(rs.getInt("course.orderFlg"));
System.out.println("course getonecourse2-4= " + c.getOrderFlg());
				c.setPrice(rs.getInt("course.price"));
System.out.println("course getonecourse2-5= " + c.getPrice());
				c.setTypeId(rs.getInt("menu.t_id"));
System.out.println("course getonecourse2-6= " + c.getTypeId());
				c.setTypeName(rs.getString("t_name"));
System.out.println("course getonecourse2-7= " + c.getTypeName());
				c.setMenuId(rs.getInt("m_id"));
System.out.println("course getonecourse2-8= " + c.getMenuId());
				c.setMenuName(rs.getString("m_name"));
System.out.println("course getonecourse2-9= " + c.getMenuName());
				al.add(c);
			 }

			}else{
				pst.close();
				rs.close();

				sql="SELECT *FROM ideal.course WHERE c_id=?";
System.out.println("course getonecourse start1a= " + sql);
				pst=con.prepareStatement(sql);
System.out.println("course getonecourse start2a= " + sql);
				pst.setInt(1, c_Id);
System.out.println("course getonecourse start3a");
				rs = pst.executeQuery();
System.out.println("course getonecourse start4a");
				while(rs.next()){
					Course c = new Course();
				c.setCourseId(rs.getInt("c_id"));
System.out.println("course getonecourse2a-1= " + c.getCourseId());
				c.setCourseName(rs.getString("c_name"));
System.out.println("course getonecourse2a-2= " + c.getCourseName());
				c.setDetail(rs.getString("course.detail"));
System.out.println("course getonecourse2a-3= " + c.getDetail());
				c.setOrderFlg(rs.getInt("course.orderFlg"));
System.out.println("course getonecourse2a-4= " + c.getOrderFlg());
				c.setPrice(rs.getInt("course.price"));
System.out.println("course getonecourse2a-5= " + c.getPrice());
				c.setTypeId(0);
System.out.println("course getonecourse2a-6= " + c.getTypeId());
				c.setTypeName(null);
System.out.println("course getonecourse2a-7= " + c.getTypeName());
				c.setMenuId(0);
System.out.println("course getonecourse2a-8= " + c.getMenuId());
				c.setMenuName(null);
System.out.println("course getonecourse2a-9= " + c.getMenuName());
				al.add(c);				}
			}
System.out.println("course getonecourse2-10= " + al);
		} catch (Exception e) { // 例外処理
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		} finally {
			try {
				if (rs != null)
					rs.close(); // クローズ処理
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) { // 例外処理
				e.printStackTrace();
			}
		}
System.out.println("course getonecourse3");
		return al; // ArrayListオブジェクトを返す
	}

	public static ArrayList<Course> getCourseList() throws IdealException{
		ArrayList<Course> al = new ArrayList<Course>(); // ArrayListオブジェクト
		// DB接続の準備
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		// 変数の宣言と初期化
		String sql = "";
		try {
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mysql"); // データソースをリース
			con = ds.getConnection(); // コネクションを実装
			// SQL文の生成
			/* SQL文を生成 */
			sql = "select * from course join coursectl "
					+ " using (c_id) join menu using (m_id) "
					+ " join menutype on menu.t_id = menutype.t_id";

			pst = con.prepareStatement(sql); // プリコンパイル
System.out.println("course.java getcourselist" + pst.toString());
			rs = pst.executeQuery(); // 実行して結果セットを取得
			while (rs.next()) { // 全行分繰り返す
				Course c = new Course();
				c.setCourseId(rs.getInt("c_id"));
				c.setCourseName(rs.getString("c_name"));
				c.setDetail(rs.getString("detail"));
				c.setOrderFlg(rs.getInt("orderFlg"));
				c.setPrice(rs.getInt("price"));
				c.setTypeId(rs.getInt("t_id"));
				c.setTypeName(rs.getString("t_name"));
				c.setMenuId(rs.getInt("m_id"));
				c.setMenuName(rs.getString("m_name"));
				al.add(c);
			}
System.out.println("course.java getcourselist2" + al);
		} catch (Exception e) { // 例外処理
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		} finally {
			try {
				if (rs != null)
					rs.close(); // クローズ処理
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) { // 例外処理
			}
		}
System.out.println("course.java getcourselist3" + al);
		return al; // ArrayListオブジェクトを返す
	}

	/*コース情報一覧取得情報*/
	public static ArrayList<Course> getOneCourseList() throws IdealException{
System.out.println("course.java getonecourselist start");
		ArrayList<Course> al = new ArrayList<Course>(); //ArrayListオブジェクト
		//DB接続の準備
				InitialContext ic = null;
				DataSource ds = null;
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
				//変数の宣言と初期化
				String sql = "";
				try{
					ic = new InitialContext();
					ds = (DataSource)ic.lookup("java:comp/env/mysql"); //データソースをリース
					con = ds.getConnection(); //コネクションを実装
					//SQL文の生成
					/* SQL文を生成 */
					sql = "SELECT * FROM course WHERE orderFlg = 1 ";
					pst = con.prepareStatement(sql); //プリコンパイル
System.out.println("course.java getonecourselist start sql" + sql.toString());
					rs = pst.executeQuery(); //SQLを実行して結果セットを得る
					while (rs.next()) {
						Course c = new Course();
						c = new Course();
						c.setCourseId(rs.getInt("c_id"));
						c.setCourseName(rs.getString("c_name"));
						c.setDetail(rs.getString("detail"));
						c.setOrderFlg(rs.getInt("orderFlg"));
						c.setPrice(rs.getInt("price"));
						c.setTypeId(rs.getInt("t_id"));
						al.add(c);
					}
				} catch (Exception e) { //例外処理
					throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
				} finally {
					try {
						if (rs != null)
							rs.close(); // クローズ処理
						if (pst != null)
							pst.close();
						if (con != null)
							con.close();
					} catch (Exception e) { //例外処理
						e.printStackTrace();
					}
				}
				return al;
			}

	/* 分類別コース情報一覧取得処理 */
	public static ArrayList<Course> getTypeCourseList(int t_Id)
			throws IdealException {
		ArrayList<Course> al = new ArrayList<Course>(); // ArrayListオブジェクトの生成
		// DB接続の準備
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		// 変数の宣言と初期化
		String sql = "";
		try {
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mysql"); // データソースをリース
			con = ds.getConnection(); // コネクションを実装
			// SQL文の生成
			sql = "select * from course join menutype using (t_id)"
					+ " where t_id = ?" + " order by t_id";
			pst = con.prepareStatement(sql); // プリコンパイル
			pst.setInt(1, t_Id); // INパラメーターに値を設定
			rs = pst.executeQuery(); // SQLを実行して結果セットを得る
			while (rs.next()) {
				Course c = new Course();
				c = new Course();
				c.setCourseId(rs.getInt("c_id"));
				c.setCourseName(rs.getString("c_name"));
				c.setDetail(rs.getString("detail"));
				c.setOrderFlg(rs.getInt("orderFlg"));
				c.setPrice(rs.getInt("price"));
				c.setTypeName(rs.getString("t_name"));
			}
		} catch (Exception e) { // 例外処理
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		} finally {
			try {
				if (rs != null)
					rs.close(); // クローズ処理
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) { // 例外処理
				e.printStackTrace();
			}
		}
		return al; // ArrayListオブジェクトを返す
	}

	/* コース情報更新処理(mode別にINSERT、UPDATE、DELETEするメソッド) */
	public static int updateCourse(Course c, int mode,
			ArrayList<CourseCtl> coursectl) throws IdealException {
		// DB接続の準備
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		// 変数の宣言と初期化
		String sql = "";
		int num = 0;
		int c_id=0;
		String courseName=c.getCourseName();
		String detail=c.getDetail();
		int orderFlg=c.getOrderFlg();
		int price=c.getPrice();
		int typeId=c.getTypeId();
		try{
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			if (mode == CourseOperationSvl.INSERT) { // INSERT処理
System.out.println("course.java insert start" + mode);
				// SQL文の生成
				// コーステーブルの登録
				sql = "INSERT INTO ideal.course VALUES "
						+ "(DEFAULT,?,?,?,?,?)";

				pst = con.prepareStatement(sql); // プリコンパイル
				pst.setString(1,courseName);
				pst.setString(2,detail);
				pst.setInt(3,orderFlg);
				pst.setInt(4,price);
				pst.setInt(5,typeId);
				num=pst.executeUpdate();
				pst.close();

				sql="SELECT * FROM ideal.course WHERE c_name ='"+courseName +"' and detail ='"+detail
						+"' and orderFlg =" +orderFlg +" and price = "+price +" and t_id ="+typeId;
				pst = con.prepareStatement(sql);
				rs=pst.executeQuery();
System.out.println("course.java insert 5");
				while(rs.next()){
					c_id=rs.getInt(1);
				}
				if(num!=0){
					num=0;
				}
				for (int i=0;i<coursectl.size();i++){
					if(coursectl.get(i).getM_Id()!=0){
						sql = "INSERT INTO ideal.coursectl VALUES "
								+ "(" +c_id +","+coursectl.get(i).getM_Id()+")";
						pst=con.prepareStatement(sql);
						num+=pst.executeUpdate();
						pst.close();
					}
System.out.println("course.java insert 10");
				}
			}else if (mode == CourseOperationSvl.UPDATE) { // UPDATE処理
System.out.println("course.java updatechk start");
				courseName=c.getCourseName();
				detail=c.getDetail();
				orderFlg=c.getOrderFlg();
				price=c.getPrice();
				int courseId=c.getCourseId();
				// SQL文の生成
				// コーステーブルの変更
				sql = "UPDATE"
					    + " ideal.course"
					    + " SET"
					    + " c_name = ?"
					    + " ,detail = ?"
					    + " ,orderFlg = ?"
					    + " ,price= ? "
					    + "WHERE c_id =? ";
					pst = con.prepareStatement(sql);
					pst.setString(1, courseName);
					pst.setString(2,detail);
					pst.setInt(3,orderFlg);
					pst.setInt(4,price);
					pst.setInt(5,courseId);
System.out.println("course.java updatechk start2" + pst.toString());
				num=pst.executeUpdate();
				pst.close();
				if(num!=0){
					num=0;
				}
				// コントロールテーブルの変更
				sql="DELETE FROM ideal.coursectl WHERE c_id = ? ;";
				pst=con.prepareStatement(sql);
				pst.setInt(1, courseId);
				num=pst.executeUpdate();
				pst.close();
				if(num!=0){
					num=0;
				}
				for (int i=0;i<coursectl.size();i++){
					if(coursectl.get(i).getM_Id()!=0){
						sql = "INSERT INTO ideal.coursectl VALUES "
								+ "(" +courseId +","+coursectl.get(i).getM_Id()+")";
						pst=con.prepareStatement(sql);
						num+=pst.executeUpdate();
						pst.close();
					}
				}

			} else if (mode == CourseOperationSvl.DELETE) { // DELETE処理
System.out.println("course.java del start");
				// SQL文の生成
					sql = "delete from ideal.coursectl where c_id = ?";
					pst = con.prepareStatement(sql); // プリコンパイル
					pst.setInt(1, c.getCourseId());
System.out.println("course.java del start2" + pst.toString());
					num=pst.executeUpdate();
					pst.close();

					sql = "delete from ideal.course where c_id = ?";
					pst = con.prepareStatement(sql); // プリコンパイル
					pst.setInt(1, c.getCourseId()); // INパラメーターに値を代入
System.out.println("course.java del start21" + pst.toString());
					num=pst.executeUpdate();
					pst.close();
System.out.println("course.java del start3 num" + num);
			}
		} catch (Exception e) { // 例外処理
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		} finally {
			try {
				if(rs !=null){
					rs.close();
				}
				if (pst != null){
					pst.close();
				}// クローズ処理
				if (con != null){
					con.close();
				}
			} catch (Exception e) { // 例外処理
				e.printStackTrace();
			}
		}
		return num; // 処理行数を返す
	}


	// 仕様書になりメソッド
//	public static int[] idNumberChk() throws IdealException {
//System.out.println("course.java idnumberchk start");
//		ArrayList<Course> al = new ArrayList<Course>(); //ArrayListオブジェクト
//		//DB接続の準備
//				InitialContext ic = null;
//				DataSource ds = null;
//				Connection con = null;
//				PreparedStatement pst = null;
//				ResultSet rs = null;
//				//変数の宣言と初期化
//				String sql = "";
//				int[] cIdNo;
//				try{
//					ic = new InitialContext();
//					ds = (DataSource)ic.lookup("java:comp/env/mysql"); //データソースをリース
//					con = ds.getConnection(); //コネクションを実装
//					//SQL文の生成
//					/* SQL文を生成 */
//					sql = "SELECT * FROM course WHERE orderFlg = 1";
//					pst = con.prepareStatement(sql); //プリコンパイル
//System.out.println("course.java idnumberchk start sql" + sql.toString());
//					rs = pst.executeQuery(); //SQLを実行して結果セットを得る
//					while (rs.next()) {
//						Course c = new Course();
//						c = new Course();
//						c.setCourseId(rs.getInt("c_id"));
//						c.setCourseName(rs.getString("c_name"));
//						c.setDetail(rs.getString("detail"));
//						c.setOrderFlg(rs.getInt("orderFlg"));
//						c.setPrice(rs.getInt("price"));
//						c.setTypeId(rs.getInt("t_id"));
//						al.add(c);
//					}
//					int size = al.size();
//					cIdNo = new int[size];
//					for(int i = 0; i < size; i++) {
//						Course cc = al.get(i);
//						cIdNo[i] = cc.getCourseId();
//					}
//
//				} catch (Exception e) { //例外処理
//					throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
//				} finally {
//					try {
//						if (rs != null)
//							rs.close(); // クローズ処理
//						if (pst != null)
//							pst.close();
//						if (con != null)
//							con.close();
//					} catch (Exception e) { //例外処理
//						e.printStackTrace();
//					}
//				}
//
//System.out.println("course.java idnumberchk10");
//		return cIdNo;
//
//
//	}


}
