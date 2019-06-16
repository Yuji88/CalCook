package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Connect;
import dto.MenuInfo;
import dto.MenuIngredientInfo;

public class MenuIngredientData {

	public ArrayList<MenuIngredientInfo> EssMenuIngredientSelect(int menuid) {

		ArrayList<MenuIngredientInfo> menuIngredientInfoList =  new ArrayList<>();

		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();
			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (menuIngredientInfoList);
			}

			String sql = "SELECT * FROM cookingredient JOIN menu ON cookingredient.menuid = menu.menuid" +
					" JOIN ingredient ON cookingredient.ingredientid = ingredient.ingredientid WHERE cookingredient.menuid = "
					+ menuid +";";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MenuIngredientInfo menuIngredientInfo = new MenuIngredientInfo();
				menuIngredientInfo.setId(rs.getInt("id"));
				menuIngredientInfo.setMenuid(rs.getInt("menuid"));
				menuIngredientInfo.setMenuname(rs.getString("menuname"));
				menuIngredientInfo.setIngredientid(rs.getInt("ingredientid"));
				menuIngredientInfo
						.setIngredientname(rs.getString("ingredientname"));
				menuIngredientInfo.setAmount(rs.getInt("amount"));
				menuIngredientInfo.setUnit(rs.getString("unit"));

				menuIngredientInfoList.add(menuIngredientInfo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (menuIngredientInfoList);
	}

	public ArrayList<MenuInfo> EssIngredientMenuSelect(String ingredientname) {

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

			String sql = "SELECT * FROM cookingredient JOIN menu ON cookingredient.menuid = menu.menuid" +
					" JOIN ingredient ON cookingredient.ingredientid = ingredient.ingredientid WHERE ingredient.ingredientname LIKE '%"
					+ ingredientname +"%';";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MenuInfo menuInfo = new MenuInfo();
				menuInfo.setMenuid(rs.getInt("menuid"));
				menuInfo.setMenuname(rs.getString("menuname"));

				menuInfoList.add(menuInfo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (menuInfoList);
	}

	public ArrayList<MenuInfo> EssIngredientMenuSelect(String menuname, String ingredientname) {

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

			String sql = "SELECT * FROM cookingredient JOIN menu ON cookingredient.menuid = menu.menuid" +
					" JOIN ingredient ON cookingredient.ingredientid = ingredient.ingredientid WHERE ingredient.ingredientname LIKE '%"
					+ ingredientname +"%' AND menu.menuname LIKE '%" + menuname + "%';";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MenuInfo menuInfo = new MenuInfo();
				menuInfo.setMenuid(rs.getInt("menuid"));
				menuInfo.setMenuname(rs.getString("menuname"));

				menuInfoList.add(menuInfo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (menuInfoList);
	}

public ArrayList<MenuInfo> IngredientMenuSelect(int ingredientid) {

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

		String sql = "SELECT * FROM cookingredient JOIN menu ON cookingredient.menuid = menu.menuid" +
				" JOIN ingredient ON cookingredient.ingredientid = ingredient.ingredientid WHERE cookingredient.ingredientid = "
				+ ingredientid +";";

		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			MenuInfo menuInfo = new MenuInfo();
			menuInfo.setMenuid(rs.getInt("menuid"));
			menuInfo.setMenuname(rs.getString("menuname"));

			menuInfoList.add(menuInfo);
		}
		rs.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return (menuInfoList);
}
}
