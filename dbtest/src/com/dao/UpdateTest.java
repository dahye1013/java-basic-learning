package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/* 1.����̹��ε�
 * 2.����
 * 3.update
 * ������ �̸� �Է�: ȫ
 * ȫ�� ���� �̸��� ���̵� 1����, Ű�� 1����
 */

public class UpdateTest {
	String driver = "oracle.jdbc.driver.OracleDriver";
	Connection conn;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##java";
	String password = "bit";
	PreparedStatement pstmt;
	private ResultSet rs;


	UpdateTest() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("접속 성공");
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateArticle() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("변경할 이름: ");
		String name = scan.next();
		
		this.getConnection();
		
		
		String sql = "update dbtest set age=age+1, height=height+1 where name like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			int su = pstmt.executeUpdate();//����
			System.out.println(su+"행 변경.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt != null) pstmt.close();
				if(pstmt != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}

	public static void main(String[] args) {
		UpdateTest updateTest = new UpdateTest();
		updateTest.updateArticle();
	}
}
