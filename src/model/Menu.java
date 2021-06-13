package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import controller.MenuOperationSvl;

public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;
	private int menuId;
	private String menuName;
	private String detail;
	private int orderFlg;
	private int price;
	private int typeId;
	private String typeName;

	public Menu(){
		super();
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

	public static Menu getOneMenu(int menuId,int typeId)throws IdealException{
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		Menu m = null;
		String table = "ideal.menu";
		String menu_id = "m_id";
		String name = "m_name";

		if (typeId == 100) {
			table ="ideal.course";
			menu_id ="c_id";
			name = "c_name";
		}
		try {
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();

				sql = "SELECT * FROM " + table + " LEFT JOIN menutype USING (t_id) WHERE " + menu_id + " = " + menuId;
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();

				m = new Menu();
				while(rs.next()) {
					m.setMenuId(rs.getInt(menu_id));
					m.setMenuName(rs.getString(name));
					m.setDetail(rs.getString("detail"));
					m.setOrderFlg(rs.getInt("orderFlg"));
					m.setPrice(rs.getInt("price"));
					m.setTypeId(rs.getInt("t_id"));
					m.setTypeName(rs.getString("t_name"));
				}
		}catch(Exception e) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}finally {
			try {
				rs.close();
				pst.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return m;

	}

	public static ArrayList<Menu> getMenuList() throws IdealException{
System.out.println("menu getmenulist");
		ArrayList<Menu> al = new ArrayList<Menu>();
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		Menu m = null;

		try {
System.out.println("menu getmenulist1");
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			sql = "SELECT * FROM ideal.menu LEFT JOIN menutype USING (t_id) WHERE orderFlg = 1";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
System.out.println("menu getmenulist2= " + pst.toString());
			while(rs.next()) {
				m = new Menu();
				m.setMenuId(rs.getInt(2));
				m.setMenuName(rs.getString(3));
				m.setDetail(rs.getString(4));
				m.setOrderFlg(rs.getInt(5));
				m.setPrice(rs.getInt(6));
				m.setTypeId(rs.getInt(1));
				m.setTypeName(rs.getString(7));
				al.add(m);
			}
System.out.println("menu getmenulist3= " + al);
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
System.out.println("menu getmenulist4= " + al);
		return al;
	}

	public static ArrayList<Menu> getMenu(int typeId)throws IdealException{
		ArrayList<Menu> al = new ArrayList<Menu>();
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		String table = "ideal.menu";
		Menu m = null;

		if(typeId == 100){
			table = "ideal.course";
		}
		try {
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			sql = "SELECT * FROM " + table + " LEFT JOIN menutype USING (t_id) WHERE t_id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, typeId);
			rs = pst.executeQuery();


				while(rs.next()) {
					m = new Menu();
					m.setMenuId(rs.getInt(2));
					m.setMenuName(rs.getString(3));
					m.setDetail(rs.getString(4));
					m.setOrderFlg(rs.getInt(5));
					m.setPrice(rs.getInt(6));
					m.setTypeName(rs.getString(7));
					al.add(m);
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


	public static int updateMenu(Menu m,int mode)throws IdealException{
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		String sql = null;
		String table = "ideal.menu";
		String menu_id = "m_id"; //keyColumn
		String name = "m_name";

		int num = 0;
		if (m.getTypeId() == 100) {
			table ="ideal.course";
			menu_id ="c_id";
			name = "c_name";
		}

		System.out.println(mode);
		System.out.println(table);
		System.out.println(menu_id);
		System.out.println(name);
		System.out.println(m.getTypeId());

		try{
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			if(mode == MenuOperationSvl.INSERT){
				sql = "INSERT INTO " + table + " VALUES(" + "DEFAULT,?,?,?,?,?)";

				pst = con.prepareStatement(sql);
				pst.setString(1,m.getMenuName());
				pst.setString(2,m.getDetail());
				pst.setInt(3,m.getOrderFlg());
				pst.setInt(4,m.getPrice());
				pst.setInt(5,m.getTypeId());

			}else if(mode == MenuOperationSvl.UPDATE){
				sql = "UPDATE " + table + " SET "
						+ name + " = ?,"+ "detail = ?,"
						+ "orderFlg = ?,"
						+ "price = ?,"
						+ "t_id = ?"
						+ " WHERE "
						+ menu_id + " =  ?" ;

				pst = con.prepareStatement(sql);
				pst.setString(1,m.getMenuName());
				pst.setString(2,m.getDetail());
				pst.setInt(3,m.getOrderFlg());
				pst.setInt(4,m.getPrice());
				pst.setInt(5,m.getTypeId());
				pst.setInt(6, m.getMenuId());
				System.out.println(sql);

			}else if(mode == MenuOperationSvl.DELETE){
				try {
				if(m.getTypeId() == 100) {
					String sql2 = "DELETE FROM coursectl WHERE c_id " + "= ?";
					pst = con.prepareStatement(sql2);
					pst.setInt(1, m.getMenuId());
					pst.executeUpdate();
					System.out.println("DELETE= " + sql2);
					}else {
						String sql3 = "DELETE FROM coursectl WHERE m_id " + "= ?";
						pst = con.prepareStatement(sql3);
						pst.setInt(1, m.getMenuId());
						pst.executeUpdate();
					}
				}catch(Exception e){
					e.printStackTrace();
				}finally {
					try {
						pst.close();
						con.close();
					}catch(Exception e){
						e.printStackTrace();
					}
				}

				ic = new InitialContext();
				ds = (DataSource)ic.lookup("java:comp/env/mysql");
				con = ds.getConnection();
				sql = "DELETE FROM " + table + " WHERE " + menu_id + " = ?";

				pst = con.prepareStatement(sql);
				pst.setInt(1, m.getMenuId());
			}

			num = pst.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return num;
	}
}
