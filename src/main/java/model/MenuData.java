package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.Connect;

public class MenuData {

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

			menuname = rs.getString(menuname);

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

			menuid = rs.getInt(menuid);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (menuid);
	}
}
