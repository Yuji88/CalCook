package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.Connect;
import dto.ProjectInfo;

public class ProjectData {

	public int ProjectIdselect() {
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
			String sql = "SELECT projectid FROM project;";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int tmp = 0;
				tmp = rs.getInt("projectid");
				if (tmp >= id) {
					id = tmp + 1;
				}
			}
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

	public int ProjectInsert(ProjectInfo projectInfo) {
		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();

			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (resultCode);
			}

			String sql = "INSERT INTO project VALUES ("
					+ projectInfo.getProjectid() + ", "
					+ "'" + projectInfo.getProjectname() + "', "
					+ projectInfo.getMember() + ", "
					+ "'" + projectInfo.getStartdate() + "', "
					+ "'" + projectInfo.getEnddate() + "');";

			int insertRs = stmt.executeUpdate(sql);
			if(insertRs != 1) {
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
