package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {

	Scanner scanner = new Scanner(System.in);

	String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##java";
	private String password = "bit";

	private Connection connection;
	private PreparedStatement pstmt;

	public void Student() {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void menu() {
		while (true) {
			System.out.println("----------------------");
			System.out.println("	 <관리>");
			System.out.println("----------------------");
			System.out.println("	1. 입력");
			System.out.println("	2. 검색");
			System.out.println("	3. 삭제");
			System.out.println("	4. 종료");
			System.out.println("----------------------");
			System.out.print("번호선택: ");
			int choice = scanner.nextInt();

			if (choice == 4) break;
			else if (choice == 1) insertArticle();
			else if (choice == 2) selectArticle();
			else if (choice == 3) deleteArticle();
		}
	}

	public void insertArticle() {
		
		String name = null;
		String value = null;
		int code = 0;
		String sql =null;
		
		while(true) {
			System.out.println("----------------------");
			System.out.println("	  입력");
			System.out.println("----------------------");
			System.out.println("	1. 학생");
			System.out.println("	2. 교수");
			System.out.println("	3. 관리자");
			System.out.println("	4. 이전 메뉴");
			System.out.println("----------------------");
			System.out.print("번호선택: ");
			int choice = scanner.nextInt();		

			if (choice == 4) break;
	
			else if (choice == 1) {
				System.out.print("이름 입력: ");
				name = scanner.next();
				System.out.print("학번 입력: ");
				value = scanner.next();
				code = 1;
			} else if (choice == 2) {
				System.out.print("이름 입력: ");
				name = scanner.next();
				System.out.print("과목 입력: ");
				value = scanner.next();
				code = 2;
			} else if (choice == 3) {
				System.out.print("이름 입력: ");
				name = scanner.next();
				System.out.print("부서 입력: ");
				value = scanner.next();
				code = 3;			
			}
			
			getConnection();
			sql = "insert into student values(?,?,?)";
			
			try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, value);
				pstmt.setInt(3, code);
	
				int su = pstmt.executeUpdate();
				System.out.println(su + "개의 행이 만들어졌습니다");
	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null) pstmt.close();
					if (connection != null)	connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void selectArticle() {
		
		ResultSet rs = null;
		String sql = null; 
		String name = null;
		
		while(true) {
			System.out.println("----------------------");
			System.out.println("	  검색");
			System.out.println("----------------------");
			System.out.println("	1. 이름 검색");
			System.out.println("	2. 전체 검색");
			System.out.println("	3. 이전 메뉴");
			System.out.println("----------------------");
			System.out.print("번호선택: ");
			int choice = scanner.nextInt();
			
			if (choice == 3) break;
			
			else if (choice == 1) {
				System.out.print("검색할 이름 입력: ");
				name = scanner.next();
				System.out.println("----------------------");
				
				sql = "select * from student where name like ?";
			
			}else if (choice == 2) {
				System.out.println("----------------------");
				System.out.println("	전체 데이터");
				System.out.println("----------------------");
				
				sql = "select * from student";
			}
			
			try {
					
				getConnection();
				pstmt = connection.prepareStatement(sql);
				if(choice == 1) pstmt.setString(1, "%"+name+"%");
				rs = pstmt.executeQuery();					
					
				while(rs.next()) {
					System.out.print("이름="+rs.getString("name")+"\t\t");
					if(rs.getInt("code") == 1) {
						System.out.println("학번="+rs.getString("value"));
					}else if(rs.getInt("code") == 2) {
						System.out.println("과목="+rs.getString("value"));
					}else if(rs.getInt("code") == 3) {
						System.out.println("부서="+rs.getString("value"));
					}
				}
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
					if (connection != null) connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void deleteArticle() {
		
		System.out.println("----------------------");
		System.out.println("	  삭제");
		System.out.println("----------------------");
		System.out.print("삭제할 이름 입력: ");
		String name = scanner.next();
			
		getConnection();
			
		String sql = "delete student where name = ?";
			
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			int su = pstmt.executeUpdate(); // 실행
			System.out.println(su+"개의 행이 삭제되었습니다");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (connection != null)	connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

	public static void main(String[] args) {
		Student student = new Student();
		student.menu();
		System.out.println("프로그램을 종료합니다");
	}

}
