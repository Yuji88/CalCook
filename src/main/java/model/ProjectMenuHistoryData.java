package model;

import java.sql.SQLException;
import java.sql.Statement;

import data.Connect;
import dto.ProjectMenuInfo;

public class ProjectMenuHistoryData {

	public int ProjectMenuHistoryInsert(ProjectMenuInfo projectMenuInfo) {
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

	public int ProjectMenuHistoryDelete(int id) {
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
