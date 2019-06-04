package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Connect;
import dto.MenuIngredientInfo;

public class MenuIngredientData {

	public ArrayList<MenuIngredientInfo> EssMenuIngredientSelect(int menuid) {

		ArrayList<MenuIngredientInfo> menuIngredientInfoList = new ArrayList<>();
		MenuIngredientInfo menuIngredientInfo = new MenuIngredientInfo();
		MenuData menuData = new MenuData();
		IngredientData ingredientData = new IngredientData();

		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();
			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (menuIngredientInfoList);
			}

			String sql = "SELECT * FROM cookingredient WHERE menuid = " + menuid + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				menuIngredientInfo.setId(rs.getInt("id"));
				menuIngredientInfo.setMenuid(rs.getInt("menuid"));
				menuData.MenuNameSelect(rs.getInt("menuid"));
				menuIngredientInfo.setIngredientid(rs.getInt("ingredientid"));
				ingredientData.IngredientNameSelect(rs.getInt("ingredientid"));
				menuIngredientInfo.setAmount(rs.getInt("amount"));
				menuIngredientInfo.setUnit(rs.getString("unit"));

				menuIngredientInfoList.add(menuIngredientInfo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (menuIngredientInfoList);
	}
}
