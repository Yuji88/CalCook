package model;

import java.sql.ResultSet;
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

			String sql = "INSERT INTO projectmenuhistory VALUES ("
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

			String sql = "DELETE FROM projectmenuhistory WHERE ('" + id + "');";

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

	public ProjectMenuInfo ProjectMenuHistSelect(int projectId, int menuid, int ingredientid) {
		ProjectMenuInfo projectMenuInfo = new ProjectMenuInfo();
		int resultCode = 0;
		Statement stmt = null;

		resultCode = Connect.DBAccess();
		stmt = Connect.getStmt();
		if (resultCode != 0) {
			System.out.println("データベースアクセスに失敗しました");
			return (projectMenuInfo);
		}
		try {
			String sql = "SELECT * FROM projectmenuhistory WHERE"
					+ " projectid = " + projectId
					+ "AND menuid = " + menuid
					+ "AND ingredientid = " + ingredientid + ";";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				projectMenuInfo.setId(rs.getInt("id"));
				projectMenuInfo.setProjectid(rs.getInt("projectid"));
				projectMenuInfo.setMenuid(rs.getInt("menuid"));
				projectMenuInfo.setIngredientid(rs.getInt("ingredientid"));
				projectMenuInfo.setAmount(rs.getInt("amount"));
				projectMenuInfo.setUnit(rs.getString("unit"));
				projectMenuInfo.setEatmember(rs.getInt("eatmember"));
				projectMenuInfo.setEatdate(rs.getString("eatdate"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		resultCode = Connect.DBClose();
		if (resultCode != 0) {
			System.out.println("データベースクローズに失敗しました");
			return (projectMenuInfo);
		}
		return (projectMenuInfo);
	}
}
