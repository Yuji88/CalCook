package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Connect;
import dto.IngredientInfo;

public class IngredientData {

	public ArrayList<IngredientInfo> IngredientSelect(String ingredientName) {
		ArrayList<IngredientInfo> ingredientInfoList = new ArrayList<>();
		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();
			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (ingredientInfoList);
			}

			String sql = "SELECT * FROM ingredient WHERE ingredientname LIKE '%" + ingredientName + "%';";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int ingredientid = rs.getInt("ingredientid");
				String ingredientname = rs.getString("ingredientname");
				IngredientInfo ingredientinfo = new IngredientInfo(ingredientid, ingredientname);
				ingredientInfoList.add(ingredientinfo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return(ingredientInfoList);
	}

	public String IngredientNameSelect(int ingredientid) {

		String ingredientname = "";
		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();
			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (ingredientname);
			}

			String sql = "SELECT ingredientname FROM ingredient WHERE ingredientid = " + ingredientid + ";";
			ResultSet rs = stmt.executeQuery(sql);

			rs.next();
			ingredientname = rs.getString("ingredientname");
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (ingredientname);
	}

	public int IngredientIdSelect(String ingredientname) {

		int ingredientid = 0;
		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();
			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (ingredientid);
			}

			String sql = "SELECT ingredientid FROM ingredient WHERE ingredientid = " + ingredientname + ";";
			ResultSet rs = stmt.executeQuery(sql);

			ingredientid = rs.getInt(ingredientid);
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (ingredientid);
	}
}
