package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Reserve {
	private int rsvId;
	private int usrId;
	private String usrName;
	private String rsvDate;
	private int rsvYy;
	private int rsvMm;
	private int rsvDd;
	private int rsvHh;
	private int rsvMi;
	private int person;
	private int tableId;
	private String tableName;
	private int courseId;
	private String courseName;
	private String appDate;
	private int appYy;
	private int appMm;
	private int appDd;
	private int appHh;
	private int appMi;
	private String rsvYyMmDd;
	private String rsvHhMi;

	public String getRsvYyMmDd() {
		return rsvYyMmDd;
	}
	public void setRsvYyMmDd(String rsvYyMmDd) {
		this.rsvYyMmDd = rsvYyMmDd;
	}
	public String getRsvHhMi() {
		return rsvHhMi;
	}
	public void setRsvHhMi(String rsvHhMi) {
		this.rsvHhMi = rsvHhMi;
	}
	// getter & setter
	public int getRsvId() {
		return rsvId;
	}
	public void setRsvId(int rsvId) {
		this.rsvId = rsvId;
	}
	public int getUsrId() {
		return usrId;
	}
	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getRsvDate() {
		return rsvDate;
	}
	public void setRsvDate(String rsvDate) {
		this.rsvDate = rsvDate;
	}
	public int getRsvYy() {
		return rsvYy;
	}
	public void setRsvYy(int rsvYy) {
		this.rsvYy = rsvYy;
	}
	public int getRsvMm() {
		return rsvMm;
	}
	public void setRsvMm(int rsvMm) {
		this.rsvMm = rsvMm;
	}
	public int getRsvDd() {
		return rsvDd;
	}
	public void setRsvDd(int rsvDd) {
		this.rsvDd = rsvDd;
	}
	public int getRsvHh() {
		return rsvHh;
	}
	public void setRsvHh(int rsvHh) {
		this.rsvHh = rsvHh;
	}
	public int getRsvMi() {
		return rsvMi;
	}
	public void setRsvMi(int rsvMi) {
		this.rsvMi = rsvMi;
	}
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
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
	public String getAppDate() {
		return appDate;
	}
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	public int getAppYy() {
		return appYy;
	}
	public void setAppYy(int appYy) {
		this.appYy = appYy;
	}
	public int getAppMm() {
		return appMm;
	}
	public void setAppMm(int appMm) {
		this.appMm = appMm;
	}
	public int getAppDd() {
		return appDd;
	}
	public void setAppDd(int appDd) {
		this.appDd = appDd;
	}
	public int getAppHh() {
		return appHh;
	}
	public void setAppHh(int appHh) {
		this.appHh = appHh;
	}
	public int getAppMi() {
		return appMi;
	}
	public void setAppMi(int appMi) {
		this.appMi = appMi;
	}

	// コンストラクター
	public Reserve() {
		super();
	}

	// メソッド
	// 予約情報一覧取得
	public static ArrayList<Reserve> getReserveList(int usrId) throws IdealException {

		ArrayList<Reserve> al = new ArrayList<Reserve>();

		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";

		try {
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			sql += "SELECT * FROM reserve ";
			sql += "INNER JOIN user USING(usr_id) ";
			sql += "INNER JOIN course USING(c_id) ";
			sql += "INNER JOIN table_loc USING(table_id) ";
			sql	+= "WHERE usr_id = " + usrId;
			sql += " ORDER BY rsv_date";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Reserve rsv = new Reserve();
				rsv.setRsvId(rs.getInt("rsv_id"));
				rsv.setUsrId(rs.getInt("usr_id"));
				rsv.setUsrName(rs.getString("usr_name"));
				rsv.setRsvDate(rs.getString("rsv_date"));
				String date = rs.getDate("rsv_date").toString();
				String time = rs.getTime("rsv_date").toString();
				rsv.setRsvDate(date + "T" + time);
				rsv.setPerson(rs.getInt("person"));
				rsv.setTableId(rs.getInt("table_id"));
				rsv.setTableName(rs.getString("table_name"));
				rsv.setCourseId(rs.getInt("c_id"));
				rsv.setCourseName(rs.getString("c_name"));
				String date2 = rs.getDate("app_date").toString();
				String time2 = rs.getTime("app_date").toString();
				rsv.setAppDate(date2 + "T" + time2);
				al.add(rsv);
			}
		}catch(Exception e) {
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);

		}finally {
			try {
				rs.close();
				pst.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		return al;

	}

	// 予約情報取得
	public static Reserve getReserve(int rsvId) throws IdealException {
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";
		Reserve rsv = null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH時mm分");
System.out.println("rsv.java getreserve");
		try {
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			sql += "SELECT * FROM reserve ";
			sql += "INNER JOIN course USING(c_id) ";
			sql += "INNER JOIN table_loc USING(table_id) ";
			sql += "INNER JOIN user USING(usr_id) ";
			sql	+= "WHERE rsv_id = " + rsvId;
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			rsv = new Reserve();
			if(rs.next()) {
				rsv.setRsvId(rs.getInt("rsv_id"));
				rsv.setRsvDate(rs.getString("rsv_date"));
				rsv.setPerson(rs.getInt("person"));
				rsv.setCourseName(rs.getString("c_name"));
				rsv.setUsrId(rs.getInt("usr_id"));
				rsv.setUsrName(rs.getString("usr_name"));
				rsv.setTableId(rs.getInt("table_id"));
				rsv.setTableName(rs.getString("table_name"));
				rsv.setCourseId(rs.getInt("c_id"));
				rsv.setAppDate(rs.getString("app_date"));
				String date = rs.getDate("rsv_date").toString();
				String time = rs.getTime("rsv_date").toString();
				rsv.setRsvDate(date + "T" + time);

				LocalDateTime d = LocalDateTime.parse(rsv.getRsvDate());
				rsv.setRsvYy(d.getYear());
				rsv.setRsvMm(d.getMonthValue());
				rsv.setRsvDd(d.getDayOfMonth());
				rsv.setRsvHh(d.getHour());
				rsv.setRsvMi(d.getMinute());
				rsv.setRsvYyMmDd(d.format(dtf));
				rsv.setRsvHhMi(d.format(dtf2));

			}else {
				return null;
			}
		}catch(Exception e) {
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);

		}finally {
			try {
				rs.close();
				pst.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return rsv;

	}

	// 新規予約情報確認処理
	public static TableLoc insertChk(String dateStr, int personNum) throws IdealException {
System.out.println("rsv.java insertChk start ");
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";
		LocalDateTime d = LocalDateTime.parse(dateStr);
System.out.println("rsv.java insertChk start2 ");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
System.out.println("rsv.java insertChk start3 ");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
System.out.println("rsv.java insertChk start4 ");
		ArrayList<TableLoc> al = new ArrayList<TableLoc>();
System.out.println("rsv.java insertChk start5 ");
		TableLoc tl = null;
System.out.println("rsv.java insertChk");

		try {
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();

			sql += "SELECT * FROM reserve ";
			sql += "INNER JOIN table_loc USING(table_id) ";
			sql += "WHERE ";
			if(personNum > 4) {
				sql += "(max_capacity = 6) AND ";
			}

			sql += "(rsv_date LIKE ?) ";
			sql += "AND ((rsv_date BETWEEN ? AND ?) ";
			sql += "OR (rsv_date BETWEEN ? AND ?)) ";
			sql += "GROUP BY table_id;";

			pst = con.prepareStatement(sql);
			String rsvDate = d.format(dtf2);
			pst.setString(1, rsvDate + "%");

			rsvDate = d.minusHours(2).minusMinutes(45).format(dtf);
			pst.setString(2, rsvDate);

			rsvDate =d.minusMinutes(1).format(dtf);
			pst.setString(3, rsvDate);

			rsvDate = d.format(dtf);
			pst.setString(4, rsvDate);

			rsvDate = d.format(dtf2);
			pst.setString(5, rsvDate + " 21:00");

			rs = pst.executeQuery();
System.out.println("rsv.java insertChk= " + pst.toString());
				if(rs.last()) {
System.out.println("rsv.java insertChk rs1= " + rs);
					rs.beforeFirst();
					while(rs.next()) {
System.out.println("rsv.java insertChk rs4");
						tl = new TableLoc();
System.out.println("rsv.java insertChk rs5");
						tl.setTableId(rs.getInt("table_id"));
						tl.setTableName(rs.getString("table_name"));
						tl.setMaxCapacity(rs.getInt("max_capacity"));
						al.add(tl);
					}
				}
System.out.println("rsv.java insertChk rs2");

System.out.println("rsv.java insertChk  al1= " + al);
System.out.println("rsv.java insertChk  rs3");


System.out.println("rsv.java insertChk  al2= " + al);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(pst != null) {
						pst.close();
					}
					if(con != null) {
						con.close();
					}
				}catch(Exception e) {

				}
			}

		try {
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			sql = "";
			tl = null;
			int[] tld = new int[al.size()];

			if(tld.length == 0) {

				sql += "SELECT * FROM table_loc ORDER by table_id";
System.out.println("rsv.java insertChk1");
System.out.println("rsv.java insertChk1 sql= " + sql);
			}else {
				for(int i=0; i<al.size();i++){
					tl = al.get(i);
					tld[i] = tl.getTableId();
System.out.println("rsv.java insertChk1 tlid" + tld[i]);
				}
				sql += "SELECT * FROM table_loc WHERE ";
				if(personNum > 4) {
					sql += "max_capacity = 6 AND ";
				}

				sql += "NOT(table_id IN(";

				for(int i = 0; i < tld.length; i++) {
					sql += tld[i];

					if(i == (tld.length) - 1) {
						break;
					}
					sql += ",";
				}
				sql += ")) GROUP BY table_id;";
			}
System.out.println("rsv.java insertChkk2");
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
System.out.println("rsv.java insertChk7"+ pst.toString());
			if(rs.last()) {
				rs.beforeFirst();
				if(rs.next()) {
System.out.println("rsv.java insertChk7-1");
				tl = new TableLoc();
				tl.setTableId(rs.getInt("table_id"));
System.out.println("rsv.java insertChk7-2");
				tl.setTableName(rs.getString("table_name"));
System.out.println("rsv.java insertChk7-3");
				tl.setMaxCapacity(rs.getInt("max_capacity"));
System.out.println("rsv.java insertChk7-4");
				}
			}else {
System.out.println("insertChk408");
				tl = null;
				return tl;
			}

		}catch(Exception e) {
//			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pst != null) {
					pst.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {

			}
		}



		return tl;

	}

	// 新規予約情報登録処理
	public static Reserve insert(Reserve reserve) throws IdealException {
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";
		Reserve rsv = null;
System.out.println("rsv.java insert1");
		try {
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			sql += "INSERT INTO ideal.reserve VALUES(DEFAULT, ";
			sql += "?,?,?,?,?,DEFAULT)";
			pst = con.prepareStatement(sql);

			pst.setInt(1, reserve.getUsrId());
			pst.setString(2, reserve.getRsvDate());
			pst.setInt(3, reserve.getPerson());
			pst.setInt(4, reserve.getTableId());
			pst.setInt(5, reserve.getCourseId());
System.out.println("insert= " + pst.toString());
			pst.executeUpdate();
			rs = pst.executeQuery("SELECT LAST_INSERT_ID()");
			if(rs.next()){
				reserve.setRsvId(rs.getInt("LAST_INSERT_ID()"));
			}

			rsv = Reserve.getReserve(reserve.getRsvId());

		}catch(Exception e) {

			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);


		}finally {
			try {
				pst.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return rsv;

	}

	// 変更予約確認処理
	public static TableLoc updateChk(int rsvId, String dateStr, int personNum) throws IdealException{
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		String sql = "";
		LocalDateTime d = LocalDateTime.parse(dateStr);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ArrayList<TableLoc> al = new ArrayList<TableLoc>();
		TableLoc tl = null;
System.out.println("rsv.java updateChk");


			try {
				ic = new InitialContext();
				ds = (DataSource)ic.lookup("java:comp/env/mysql");
				con = ds.getConnection();

				sql += "SELECT * FROM reserve ";
				sql += "INNER JOIN table_loc USING(table_id) ";
				sql += "WHERE ";
				if(personNum > 4) {
					sql += "(max_capacity = 6) AND ";
				}

				sql += "(rsv_date LIKE ?) ";
				sql += "AND ((rsv_date BETWEEN ? AND ?) ";
				sql += "OR (rsv_date BETWEEN ? AND ?)) ";
				sql += "GROUP BY table_id;";

				pst = con.prepareStatement(sql);
				String rsvDate = d.format(dtf2);
				pst.setString(1, rsvDate + "%");

				rsvDate = d.minusHours(2).minusMinutes(45).format(dtf);
				pst.setString(2, rsvDate);

				rsvDate =d.minusMinutes(1).format(dtf);
				pst.setString(3, rsvDate);

				rsvDate = d.format(dtf);
				pst.setString(4, rsvDate);

				rsvDate = d.format(dtf2);
				pst.setString(5, rsvDate + " 21:00");

				rs = pst.executeQuery();
				rsmd = rs.getMetaData();
System.out.println("rsv.java pst= " + pst.toString());
					if(rs.last()) {
System.out.println("rsv.java rs1= " + rs);
						rs.beforeFirst();
						while(rs.next()) {
System.out.println("rsv.java rs4");
							tl = new TableLoc();
System.out.println("rsv.java rs5");
							tl.setTableId(rs.getInt("table_id"));
							tl.setTableName(rs.getString("table_name"));
							tl.setMaxCapacity(rs.getInt("max_capacity"));
							al.add(tl);
						}
System.out.println("rsv.java rs2");
					}
System.out.println("rsv.java al1= " + al);
System.out.println("rsv.java rs3");


System.out.println("rsv.java al2= " + al);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(pst != null) {
						pst.close();
					}
					if(con != null) {
						con.close();
					}
				}catch(Exception e) {

				}
			}

			try {
				ic = new InitialContext();
				ds = (DataSource)ic.lookup("java:comp/env/mysql");
				con = ds.getConnection();
				sql = "";
				tl = null;
				int[] tld = new int[al.size()];

				if(tld.length == 0) {

					sql += "SELECT * FROM table_loc ORDER by table_id";
System.out.println("rsv.java updatecheck1");
System.out.println("rsv.java updatecheck1 sql= " + sql);
				}else {
					for(int i=0; i<al.size();i++){
						tl = al.get(i);
						tld[i] = tl.getTableId();
System.out.println("rsv.java updatecheck1 tlid" + tld[i]);
					}
					sql += "SELECT * FROM table_loc WHERE ";
					if(personNum > 4) {
						sql += "max_capacity = 6 AND ";
					}

					sql += "NOT(table_id IN(";

					for(int i = 0; i < tld.length; i++) {
						sql += tld[i];

						if(i == (tld.length) - 1) {
							break;
						}
						sql += ",";
					}
					sql += ")) GROUP BY table_id;";
				}
System.out.println("rsv.java updateChk2");
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
System.out.println("rsv.java updatecheck7"+ pst.toString());
				if(rs.last()) {
					rs.beforeFirst();
					if(rs.next()) {
System.out.println("rsv.java updatecheck7-1");
					tl = new TableLoc();
					tl.setTableId(rs.getInt("table_id"));
System.out.println("rsv.java updatecheck7-2");
					tl.setTableName(rs.getString("table_name"));
System.out.println("rsv.java updatecheck7-3");
					tl.setMaxCapacity(rs.getInt("max_capacity"));
System.out.println("rsv.java updatecheck7-4");
					}
				}else {
System.out.println("408");
					return null;
				}

			}catch(Exception e) {
//				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			}finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(pst != null) {
						pst.close();
					}
					if(con != null) {
						con.close();
					}
				}catch(Exception e) {

				}
			}


		return tl;

	}

	// 予約情報変更処理
	public static Reserve update(Reserve reserve) throws IdealException {
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "";
		Reserve rsv = null;
System.out.println("rsv.java update1");
		try {
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			sql += "UPDATE reserve ";
			sql += "SET rsv_date = ?, ";
			sql += "person = ?, ";
			sql += "c_id = ?, ";
			sql += "table_id = ? ";
			sql += "WHERE rsv_id = ?";
System.out.println("update= " + sql);
			pst = con.prepareStatement(sql);

			pst.setString(1, reserve.getRsvDate());
			pst.setInt(2, reserve.getPerson());
			pst.setInt(3, reserve.getCourseId());
			pst.setInt(4, reserve.getTableId());
			pst.setInt(5, reserve.getRsvId());
System.out.println("update= " + pst.toString());
			pst.executeUpdate();

			rsv = Reserve.getReserve(reserve.getRsvId());

		}catch(Exception e) {

			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);


		}finally {
			try {
				pst.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return rsv;
	}




	// 予約情報削除処理
	public static void delete(Reserve reserve) throws IdealException {
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "";

		try {
			int rsvId = reserve.getRsvId();
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			sql += "DELETE FROM reserve WHERE rsv_id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, rsvId);
			pst.executeUpdate();
		}catch(Exception e) {

			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);


		}finally {
			try {
				pst.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}



}
