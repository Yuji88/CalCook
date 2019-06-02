package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.Connect;

public class IngredientData {

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

			String sql = "SELECT ingredientname FROM ingredient WHERE = " + ingredientid + ";";
			ResultSet rs = stmt.executeQuery(sql);

			ingredientname = rs.getString(ingredientname);

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

			String sql = "SELECT ingredientid FROM ingredient WHERE = " + ingredientname + ";";
			ResultSet rs = stmt.executeQuery(sql);

			ingredientid = rs.getInt(ingredientid);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (ingredientid);
	}
}
