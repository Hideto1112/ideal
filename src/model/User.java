package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class User {
	private int usrId;
	private String usrName;
	private String password;
	private String address;
	private String phone;
	private String mail;
	private String exp;

	// getter & setter
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}

	// コンストラクター
	public User() {
		super();
	}

	//顧客ログイン処理
	public static User login(int usrId, String password) throws IdealException {
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";
		User u = null;

		try {
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			sql += "SELECT * FROM user WHERE usr_id = " + usrId;
			sql += " AND password = PASSWORD('" + password + "')";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			u = new User();
				if(rs.next()) {

					u.setUsrId(rs.getInt("usr_id"));
					u.setUsrName(rs.getString("usr_name"));
					u.setPassword(rs.getString("password"));
					u.setAddress(rs.getString("address"));
					u.setPhone(rs.getString("phone"));
					u.setMail(rs.getString("mail"));
					u.setExp(rs.getString("exp"));

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

		return u;

	}

	//顧客情報取得
	public static User getUser(int usrId) throws IdealException {
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";
		User u = null;

		try {
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			sql += "SELECT * FROM user WHERE usr_id = " + usrId;
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			u = new User();
				if(rs.next()) {

					u.setUsrId(rs.getInt("usr_id"));
					u.setUsrName(rs.getString("usr_name"));
					u.setPassword(rs.getString("password"));
					u.setAddress(rs.getString("address"));
					u.setPhone(rs.getString("phone"));
					u.setMail(rs.getString("mail"));
					u.setExp(rs.getString("exp"));

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
		return u;
	}

	//顧客情報登録処理
	public static User insert(User user) throws IdealException {
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
			sql += "INSERT INTO user VALUES(DEFAULT,?,PASSWORD(?),?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getUsrName());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getAddress());
			pst.setString(4, user.getPhone());
			pst.setString(5, user.getMail());
			pst.setString(6, user.getExp());
			pst.executeUpdate();
			rs = pst.executeQuery("SELECT LAST_INSERT_ID()");
			if(rs.next()){
				user.setUsrId(rs.getInt("LAST_INSERT_ID()"));
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
		return user;
	}

	//顧客情報変更処理
	public static User update(User user) throws IdealException {
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "";
System.out.println("userope pass= " + user.getPassword());
		try {
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			String pass = user.getPassword();
			if(pass.equals("")) {
				sql += "UPDATE user SET usr_name = ?, address = ?, phone = ?, mail = ? "
						+ "WHERE usr_id = ?";
				pst = con.prepareStatement(sql);
				pst.setString(1, user.getUsrName());
				pst.setString(2, user.getAddress());
				pst.setString(3, user.getPhone());
				pst.setString(4, user.getMail());
				pst.setInt(5, user.getUsrId());
			}else {
				sql += "UPDATE user SET usr_name = ?, password = PASSWORD(?), address = ?, phone = ?, mail = ? "
						+ "WHERE usr_id = ?";
				pst = con.prepareStatement(sql);
				pst.setString(1, user.getUsrName());
				pst.setString(2, user.getPassword());
				pst.setString(3, user.getAddress());
				pst.setString(4, user.getPhone());
				pst.setString(5, user.getMail());
				pst.setInt(6, user.getUsrId());
			}
			pst.executeUpdate();
System.out.println("user.java pst= " + pst.toString());
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
		return user;
	}

	//顧客情報削除処理
	public static void delete(User user) throws IdealException {
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "";

		try {
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			sql += "DELETE FROM user WHERE usr_id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, user.getUsrId());
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
