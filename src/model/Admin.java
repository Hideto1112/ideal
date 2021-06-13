package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;
	private String admName;
	private String password;
	private String exp;

	public Admin() {
		super();
	}

	public String getAdmName() {
		return admName;
	}

	public void setAdmName(String admName) {
		this.admName = admName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public static Admin login(String admName, String password)
			throws IdealException {
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "";
		Admin a = new Admin();
		String adminName = admName;
		String pass = password;

		try {
			System.out.println("3");
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();

			sql = "SELECT * FROM ideal.admin WHERE adm_name " + "= '"
					+ adminName + "' and password = password('" + pass + "')";
			System.out.println(sql);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			System.out.println("4" + sql);
			// 存在したとき
			if (rs.next()) {
				a.setAdmName(rs.getString("adm_name"));
				a.setPassword(rs.getString("password"));
				a.setExp(rs.getString("exp"));

			} else {
				a = null;
			}

		} catch (Exception e) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return a;
	}

}
