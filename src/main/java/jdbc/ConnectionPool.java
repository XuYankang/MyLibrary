package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionPool {

	private static int maxConnections = 5;
	private static Connection[] connectionList = null;
	private static boolean[] connectionInUse = null;
	public static boolean debug = false;

	public static void setMaxConnections(int max) {
		maxConnections = max;
		if (debug)
			System.out.println("Connection pool size:" + maxConnections);
	}

	public static void setDebug(boolean on) {
		debug = on;
	}

	public static Connection getConnection() {
		if (connectionList == null) {
			connectionList = new Connection[maxConnections];
			connectionInUse = new boolean[maxConnections];
			for (int i = 0; i < maxConnections; i++) {
				connectionInUse[i] = false;
			}
		}
		boolean allInUse = true;
		int empty = -1;
		for (int i = 0; i < maxConnections; i++) {
			if (connectionInUse[i] == false) {
				allInUse = false;
				empty = i;
				connectionInUse[i] = true;
				break;
			}
		}
		if (!allInUse) {
			if (connectionList[empty] == null) {
				Connection conn = getConn();
				connectionList[empty] = conn;
			}
			if (debug)
				System.out.println("Get a connection in pool[" + empty + "]");
			return connectionList[empty];
		} else {
			if (debug)
				System.out.println("Too many connections!");
			return null;
		}

	}

	public static void releaseConnection(Connection conn) {
		for (int i = 0; i < maxConnections; i++) {
			if (conn == connectionList[i]) {
				connectionInUse[i] = false;
				if (debug)
					System.out.println("Release connection in pool[" + i + "]");
				break;
			}
		}
	}

	public static void releaseAll() {
		for (int i = 0; i < maxConnections; i++) {
			if (connectionList[i] != null) {
				releaseConnection(connectionList[i]);
			}
		}
	}

	private static Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String connnectionString = "jdbc:mysql://localhost:3306/JavaData?useUnicode=true&characterEncoding=UTF8";

		try {
			return DriverManager.getConnection(connnectionString, "root", "1");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		ConnectionPool.debug = true;
		ConnectionPool.setMaxConnections(3);
		for (int i = 0; i < 6; i++) {
			Connection conn = getConnection();
			if (i == 3) {
				releaseConnection(conn);
			}
			System.out.println(conn);
		}
		releaseAll();
	}
}
