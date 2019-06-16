package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.Connect;
import dto.ProjectMenuInfo;

public class ProjectMenuData {

	public int ProjectMenuIdselect() {
		int id = 1;
		int resultCode = 0;
		Statement stmt = null;

		resultCode = Connect.DBAccess();
		stmt = Connect.getStmt();
		if (resultCode != 0) {
			System.out.println("データベースアクセスに失敗しました");
			return (resultCode);
		}

		try {
			String sql = "SELECT id FROM projectmenu;";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int tmp = 0;
				tmp = rs.getInt("id");
				if (tmp >= id) {
					id = tmp + 1;
				}
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		resultCode = Connect.DBClose();
		if (resultCode != 0) {
			System.out.println("データベースクローズに失敗しました");
			return (resultCode);
		}
		return (id);
	}

	public int ProjectMenuInsert(ProjectMenuInfo projectMenuInfo) {
		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();

			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (resultCode);
			}

			String sql = "INSERT INTO projectmenu VALUES ("
					+ projectMenuInfo.getId() + ", "
					+ "'" + projectMenuInfo.getProjectid() + "', "
					+ "'" + projectMenuInfo.getMenuid() + "', "
					+ "'" + projectMenuInfo.getIngredientid() + "', "
					+ "'" + projectMenuInfo.getAmount() + "', "
					+ "'" + projectMenuInfo.getUnit() + "', "
					+ "'" + projectMenuInfo.getEatmember() + "', "
					+ projectMenuInfo.getEatdate() + ");";

			int insertRs = stmt.executeUpdate(sql);
			if (insertRs != 1) {
				resultCode = 20;
				System.out.println("プロジェクト登録失敗しました");
				return (resultCode);
			}

			resultCode = Connect.DBClose();
			if (resultCode != 0) {
				System.out.println("データベースクローズに失敗しました");
				return (resultCode);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (resultCode);
	}

	public int ProjectMenuDelete(int id) {
		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();

			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (resultCode);
			}

			String sql = "DELETE FROM projectmenu WHERE ('" + id + "');";

			int insertRs = stmt.executeUpdate(sql);
			if (insertRs != 1) {
				resultCode = 20;
				System.out.println("プロジェクト登録失敗しました");
				return (resultCode);
			}

			resultCode = Connect.DBClose();
			if (resultCode != 0) {
				System.out.println("データベースクローズに失敗しました");
				return (resultCode);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (resultCode);
	}
}
