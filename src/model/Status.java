package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Status {
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
	private int rsvOk;
	private String baseDate;

	public static String[] RSV_TIME = {
		"17:00","17:15","17:30","17:45",
		"18:00","18:15","18:30","18:45",
		"19:00","19:15","19:30","19:45",
		"20:00","20:15","20:30","20:45",
		"21:00",
	};



	public String getBaseDate() {
		return baseDate;
	}
	public void setBaseDate(String originalDate) {
		this.baseDate = originalDate;
	}
	public int getRsvOk() {
		return rsvOk;
	}
	public void setRsvOk(int rsvOk) {
		this.rsvOk = rsvOk;
	}
	public static String[] getRSV_TIME() {
		return RSV_TIME;
	}
	public static void setRSV_TIME(String[] rSV_TIME) {
		RSV_TIME = rSV_TIME;
	}
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
	public Status() {
		super();
	}

	// 予約状況確認処理
	public static Status statusChk(String dateStr) throws IdealException {
System.out.println("status.java statusChk start ");
		ArrayList<Status> al = new ArrayList<Status>();
		Status sts = null;
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";

		LocalDateTime d = LocalDateTime.parse(dateStr);
System.out.println("status.java statusChk start2 " + d);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
System.out.println("status.java statusChk start3 ");
				DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
System.out.println("status.java statusChk start4 ");

				try {
					ic = new InitialContext();
					ds = (DataSource)ic.lookup("java:comp/env/mysql");
					con = ds.getConnection();

					sql += "SELECT * FROM reserve ";
					sql += "INNER JOIN table_loc USING(table_id) ";
					sql += "WHERE ";
					sql += "(rsv_date LIKE ?) ";
					sql += "AND ((rsv_date BETWEEN ? AND ?) ";
					sql += "OR (rsv_date BETWEEN ? AND ?)) ";
					sql += "GROUP BY table_id;";

					pst = con.prepareStatement(sql);
					String rsvDate = d.format(dtf2);
					pst.setString(1, rsvDate + "%");
System.out.println("status.java statusChk start5 " + rsvDate);

					rsvDate = d.minusHours(2).minusMinutes(45).format(dtf);
					pst.setString(2, rsvDate);
System.out.println("status.java statusChk start6 " + rsvDate);

					rsvDate =d.minusMinutes(1).format(dtf);
					pst.setString(3, rsvDate);
System.out.println("status.java statusChk start7 " + rsvDate);

					rsvDate = d.format(dtf);
					pst.setString(4, rsvDate);
System.out.println("status.java statusChk start8 " + rsvDate);

					rsvDate = d.plusHours(2).plusMinutes(59).format(dtf);
					pst.setString(5, rsvDate);
System.out.println("status.java statusChk start9 " + rsvDate);

					rs = pst.executeQuery();
System.out.println("status.java statusChk pstk= " + pst.toString());
						if(rs.last()) {
System.out.println("status.java statusChk rs= " + rs);
							rs.beforeFirst();
							while(rs.next()) {
System.out.println("status.java statusChk rs2");
								sts = new Status();
System.out.println("status.java statusChk rs3");
								sts.setTableId(rs.getInt("table_id"));
								sts.setTableName(rs.getString("table_name"));
								al.add(sts);
							}
						}
System.out.println("status.java statusChk al1=  " + al.size());
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
					sts = null;
					int[] tld = new int[al.size()];

					if(tld.length == 0) {

						sql += "SELECT * FROM table_loc ORDER by table_id";
System.out.println("status.java statusChk10");
					}else {
						for(int i=0; i<al.size();i++){
							sts = al.get(i);
							tld[i] = sts.getTableId();
System.out.println("status.java statusChk11" + tld[i]);
						}
						sql += "SELECT * FROM table_loc WHERE ";
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
System.out.println("status.java statusChk12");
					pst = con.prepareStatement(sql);
					rs = pst.executeQuery();
System.out.println("status.java statusChk13 pst= "+ pst.toString());
					if(rs.last()) {
						rs.beforeFirst();
						if(rs.next()) {
System.out.println("status.java statusChk14");
						sts = new Status();
						sts.setTableId(rs.getInt("table_id"));
System.out.println("status.java statusChk15");
						sts.setTableName(rs.getString("table_name"));
System.out.println("status.java statusChk16");
						sts.setRsvYy(d.getYear());
						sts.setRsvMm(d.getMonthValue());
						sts.setRsvDd(d.getDayOfMonth());
						sts.setRsvHh(d.getHour());
						sts.setRsvMi(d.getMinute());
						sts.setRsvOk(1);
						}
						}else {
System.out.println("status.java statusChk17");
System.out.println("status.java statusChk18 sts" + sts);
						sts.setRsvYy(d.getYear());
						sts.setRsvMm(d.getMonthValue());
						sts.setRsvDd(d.getDayOfMonth());
						sts.setRsvHh(d.getHour());
						sts.setRsvMi(d.getMinute());
						sts.setRsvOk(0);
					}

				}catch(Exception e) {
//					throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
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
System.out.println("status.java statusChk18 sts" + sts);
				return sts;

	}

}
