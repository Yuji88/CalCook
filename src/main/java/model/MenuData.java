package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Connect;
import dto.MenuInfo;

public class MenuData {

	public ArrayList<MenuInfo> AllMenuSelect() {
		ArrayList<MenuInfo> menuInfoList = new ArrayList<>();
		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();
			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (menuInfoList);
			}

			String sql = "SELECT * FROM menu;";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int menuid = rs.getInt("menuid");
				String menuname = rs.getString("menuname");
				MenuInfo menuinfo = new MenuInfo(menuid, menuname);
				menuInfoList.add(menuinfo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return(menuInfoList);
	}

	public ArrayList<MenuInfo> MenuSelect(String menuName) {
		ArrayList<MenuInfo> menuInfoList = new ArrayList<>();
		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();
			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (menuInfoList);
			}

			String sql = "SELECT * FROM menu WHERE menuname LIKE '%" + menuName + "%';";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int menuid = rs.getInt("menuid");
				String menuname = rs.getString("menuname");
				MenuInfo menuinfo = new MenuInfo(menuid, menuname);
				menuInfoList.add(menuinfo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return(menuInfoList);
	}

	public String MenuNameSelect(int menuid) {

		String menuname = "";
		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();
			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (menuname);
			}

			String sql = "SELECT menuname FROM menu WHERE menuid = " + menuid + ";";
			ResultSet rs = stmt.executeQuery(sql);

			menuname = rs.getString("menuname");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (menuname);
	}

	public int MenuIdSelect(String menuname) {

		int menuid = 0;
		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();
			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (menuid);
			}

			String sql = "SELECT menuid FROM menu WHERE menuname = " + menuname + ";";
			ResultSet rs = stmt.executeQuery(sql);

			menuid = rs.getInt("menuid");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (menuid);
	}
}
