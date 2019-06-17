package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Connect;
import dto.ProjectInfo;
import processing.YearJudge;

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

	public ArrayList<ProjectInfo> AllProjectSelect() {
		ArrayList<ProjectInfo> projectList = new ArrayList<>();

		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();
			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (projectList);
			}

			// データ取得
			String sql = "SELECT * FROM project;";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ProjectInfo projectInfo = new ProjectInfo();
				projectInfo.setProjectid(rs.getInt("projectid"));
				projectInfo.setProjectname(rs.getString("projectname"));
				projectInfo.setMember(rs.getInt("membernumber"));
				projectInfo.setStartdate(rs.getString("startdate"));
				projectInfo.setEnddate(rs.getString("enddate"));

				projectList.add(projectInfo);
			}

			rs.close();
			resultCode = Connect.DBClose();
			if (resultCode != 0) {
				System.out.println("データベースクローズに失敗しました");
				return (projectList);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (projectList);
	}

	public ArrayList<ProjectInfo> ProjectSearchNameSelect(String projectname) {
		ArrayList<ProjectInfo> projectList = new ArrayList<>();

		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();
			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (projectList);
			}

			// データ取得
			String sql = "SELECT * FROM project WHERE projectname LIKE '%" + projectname + "%';";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ProjectInfo projectInfo = new ProjectInfo();
				projectInfo.setProjectid(rs.getInt("projectid"));
				projectInfo.setProjectname(rs.getString("projectname"));
				projectInfo.setMember(rs.getInt("membernumber"));
				projectInfo.setStartdate(rs.getString("startdate"));
				projectInfo.setEnddate(rs.getString("enddate"));

				projectList.add(projectInfo);
			}

			rs.close();
			resultCode = Connect.DBClose();
			if (resultCode != 0) {
				System.out.println("データベースクローズに失敗しました");
				return (projectList);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (projectList);
	}

	public ArrayList<ProjectInfo> ProjectSearchYearSelect(String searchYear) {
		ArrayList<ProjectInfo> projectList = new ArrayList<>();

		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();
			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (projectList);
			}

			// データ取得
			String sql = "SELECT * FROM project;";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String startDate = rs.getString("startdate");
				YearJudge yearjudge = new YearJudge();
				boolean judge = yearjudge.YearJudgement(searchYear, startDate);

				if (judge) {
					ProjectInfo projectInfo = new ProjectInfo();
					projectInfo.setProjectid(rs.getInt("projectid"));
					projectInfo.setProjectname(rs.getString("projectname"));
					projectInfo.setMember(rs.getInt("membernumber"));
					projectInfo.setStartdate(rs.getString("startdate"));
					projectInfo.setEnddate(rs.getString("enddate"));

					projectList.add(projectInfo);
				}
			}

			rs.close();
			resultCode = Connect.DBClose();
			if (resultCode != 0) {
				System.out.println("データベースクローズに失敗しました");
				return (projectList);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (projectList);
	}

	public ArrayList<ProjectInfo> ProjectSearchSelect(String projectname, String searchYear) {
		ArrayList<ProjectInfo> projectList = new ArrayList<>();

		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();
			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (projectList);
			}

			// データ取得
			String sql = "SELECT * FROM project WHERE projectname LIKE '%" + projectname + "%';";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String startDate = rs.getString("startdate");
				YearJudge yearjudge = new YearJudge();
				boolean judge = yearjudge.YearJudgement(searchYear, startDate);

				if (judge) {
					ProjectInfo projectInfo = new ProjectInfo();
					projectInfo.setProjectid(rs.getInt("projectid"));
					projectInfo.setProjectname(rs.getString("projectname"));
					projectInfo.setMember(rs.getInt("membernumber"));
					projectInfo.setStartdate(rs.getString("startdate"));
					projectInfo.setEnddate(rs.getString("enddate"));

					projectList.add(projectInfo);
				}
			}

			rs.close();
			resultCode = Connect.DBClose();
			if (resultCode != 0) {
				System.out.println("データベースクローズに失敗しました");
				return (projectList);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (projectList);
	}

	public ArrayList<String> ProjectNameselect() {
		ArrayList<String> names = new ArrayList<>();

		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();
			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (names);
			}

			// データ取得
			String sql = "SELECT projectname FROM project;";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				names.add(rs.getString("projectname"));
			}

			rs.close();
			resultCode = Connect.DBClose();
			if (resultCode != 0) {
				System.out.println("データベースクローズに失敗しました");
				return (names);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (names);
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

	public ProjectInfo ProjectSelect(int projectid) {
		ProjectInfo projectInfo = new ProjectInfo();

		int resultCode = 0;
		Statement stmt = null;

		try {
			resultCode = Connect.DBAccess();
			stmt = Connect.getStmt();
			if (resultCode != 0) {
				System.out.println("データベースアクセスに失敗しました");
				return (projectInfo);
			}

			// データ取得
			String sql = "SELECT * FROM project WHERE projectid = " + projectid + ";";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				projectInfo.setProjectid(rs.getInt("projectid"));
				projectInfo.setProjectname(rs.getString("projectname"));
				projectInfo.setMember(rs.getInt("membernumber"));
				projectInfo.setStartdate(rs.getString("startdate"));
				projectInfo.setEnddate(rs.getString("enddate"));
			}

			rs.close();
			resultCode = Connect.DBClose();
			if (resultCode != 0) {
				System.out.println("データベースクローズに失敗しました");
				return (projectInfo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (projectInfo);
	}
}
