package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MenuType implements Serializable {
	private static final long serialVersionUID = 1L;
	// フィールド
	private int typeId;
	private String typeName;

	// コンストラクタ―
	public MenuType() {
		super();
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

	// 全てのメニュータイプをArrayLustで返すメソッド
	public static ArrayList<MenuType> getAllType()throws IdealException {
		// ArrayListオブジェクトの生成
		ArrayList<MenuType> al = new ArrayList<MenuType>();
		// DB接続準備
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";

		try {
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			// SQLを生成
			sql += "SELECT * FROM ideal.menutype ORDER BY t_id";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				MenuType mt = new MenuType();
				mt.setTypeId(rs.getInt("t_id"));
				mt.setTypeName(rs.getString("t_name"));
				al.add(mt);
			}
		} catch (Exception e) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			}
		}
		return al;
	}
}
