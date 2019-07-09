package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	public ArrayList<ProjectMenuInfo> ProjectMenuSelect(int projectId) {
		ArrayList<ProjectMenuInfo> projectMenuInfoList = new ArrayList<>();
		int resultCode = 0;
		Statement stmt = null;

		resultCode = Connect.DBAccess();
		stmt = Connect.getStmt();
		if (resultCode != 0) {
			System.out.println("データベースアクセスに失敗しました");
			return (projectMenuInfoList);
		}
		try {
			String sql = "SELECT * FROM projectmenu WHERE projectid = " + projectId + ";";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ProjectMenuInfo projectMenuInfo = new ProjectMenuInfo();
				projectMenuInfo.setId(rs.getInt("id"));
				projectMenuInfo.setProjectid(rs.getInt("projectid"));
				projectMenuInfo.setMenuid(rs.getInt("menuid"));
				projectMenuInfo.setIngredientid(rs.getInt("ingredientid"));
				projectMenuInfo.setAmount(rs.getInt("amount"));
				projectMenuInfo.setUnit(rs.getString("unit"));
				projectMenuInfo.setEatmember(rs.getInt("eatmember"));
				projectMenuInfo.setEatdate(rs.getString("eatdate"));

				projectMenuInfoList.add(projectMenuInfo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		resultCode = Connect.DBClose();
		if (resultCode != 0) {
			System.out.println("データベースクローズに失敗しました");
			return (projectMenuInfoList);
		}
		return (projectMenuInfoList);
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

	public int ProjectMenuUpdate(ProjectMenuInfo projectMenuInfo) {
		int resultCode = 0;
		Statement stmt = null;

		int amount = projectMenuInfo.getAmount();
		int eatmember = projectMenuInfo.getEatmember();
		int projectid = projectMenuInfo.getProjectid();
		int menuid = projectMenuInfo.getMenuid();
		int ingredientid = projectMenuInfo.getIngredientid();

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();

			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (resultCode);
			}

			String sql = "UPDATE projectmenu SET amount = "+ amount + ", eatmember = " + eatmember +
					" WHERE projectid = " + projectid +
					" AND menuid = " + menuid +
					" AND ingredientid = " + ingredientid + ";";

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
