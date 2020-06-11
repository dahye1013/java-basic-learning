package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 class SelectTest {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "c##java";
	String password = "bit";
	Connection conn;
	PreparedStatement pstmt;
	private ResultSet rs;

	public SelectTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void selectArticle() {
		getConnection();
		String sql = "select name, age, height, to_char(longtime,'yyyy.mm.dd') as logtime from dbtest";
		// 자바에서 넘겨주는 sql은 ;붙이면 안됨.
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // executeQuery()는 값을 받을 때 ResultSet을 통해서 받는다.

			while (rs.next()) {
				System.out.println(rs.getString("name") + "\t" + rs.getInt("age") + "\t" + rs.getDouble("height") + "\t"
						+ rs.getString("logtime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (pstmt != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("접속성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SelectTest selectTest = new SelectTest();
		selectTest.selectArticle();
	}

}
