package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Coursect implements Serializable{
	private static final long serialVersionUID = 1L;
	//フィールド
	private int c_Id;
	private int m_Id;

	/*コンストラクタ―*/
	public Coursect(){
		super();
	}
	public int getC_Id() {
		return c_Id;
	}
	public void setC_Id(int c_Id) {
		this.c_Id = c_Id;
	}
	public int getM_Id() {
		return m_Id;
	}
	public void setM_Id(int m_Id) {
		this.m_Id = m_Id;
	}

	public static void CourseMenuChk(int mId) throws IdealException{
		//DB接続の準備
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "";
		try{
			ic = new InitialContext(); //データソースをリース
			ds = (DataSource)ic.lookup("java:comp/env/mysql"); //データソースをリース
			con = ds.getConnection(); //コネクションを実装
			//SQL文の生成
			sql = "select * from coursectl where m_id = ?";
			pst = con.prepareStatement(sql); //プリコンパイル
			pst.setInt(1, mId); //INパラメーターに値を代入
			rs = pst.executeQuery(); //実行して結果セットを取得
		}catch (SQLException e) {
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			} catch (NamingException e) {
				throw new IdealException(IdealException.ERR_NOT_NOT_MENU_DELETE);
			}finally{
				try{
					if(rs != null) rs.close(); //クローズ処理
					if(pst != null) pst.close();
					if(con != null) con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
	}
}
