package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

	// Azure用接続文字列
	final static String URL = "jdbc:sqlserver://calcookserver.database.windows.net:1433;database=ChiZaiDB_1;user=chizaiAdmin@calcookserver;password=P@ssWord!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	// ローカル接続用接続文字列
//	final static String URL = "jdbc:postgresql:calcook";
	private static Connection conn = null;
	private static Statement stmt = null;

	public static int DBAccess() {

		int resultCode = 0;

		try {
			if(URL.equals("jdbc:postgresql:calcook")) {
				// ローカル用 JDBCドライバーの設定
				Class.forName("org.postgresql.Driver");
				// ローカルDB接続
				conn = DriverManager.getConnection(URL,"yuji","9584ty");

			} else {
				// Azure用 JDBCドライバーの設定
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				// AzureDB接続
				conn = DriverManager.getConnection(URL);
			}

			// ステートメント作成
			stmt = conn.createStatement();
		} catch (Exception e) {
			resultCode = 99;
			e.printStackTrace();
		}
		return (resultCode);
	}

	public static int DBClose() {

		int resultCode = 0;

		// ステートメントクローズ
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// DB接続クローズ
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return (resultCode);
	}

	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		Connect.conn = conn;
	}

	public static Statement getStmt() {
		return stmt;
	}

	public static void setStmt(Statement stmt) {
		Connect.stmt = stmt;
	}

}
