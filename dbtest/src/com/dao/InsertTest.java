package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "c##java";
	String password = "bit";
	Connection conn;
	PreparedStatement pstmt;
	
	public InsertTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
	}
	
	public void getConnection() {	
		try {//DriverManager클래스에서 getConnection(jdbc:oracle:오라클드라이버이름:로컬호스트:db이름:포트)로 받아와서 연결한다.
			//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##java", "bit");
			conn = DriverManager.getConnection(url , username , password);
			System.out.println("접속성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.println("이름 입력: ");
		String name = scan.next();
		System.out.println("나이 입력: ");
		int age = scan.nextInt();
		System.out.println("키 입력: ");
		double height = scan.nextDouble();
		
		
		//DB
		this.getConnection();
		//Connection클래스에 PreaparedStatement를 불러오는 메소드가 있다.
		//자바언어에서는 db언어를 알아듣지 못하므로 이하 명령어를 통해 번역하여 보내도록 해야한다.
		String sql = "insert into dbtest values(?,?,?,sysdate)";
											//이렇게 작성하면 순서대로 이름/나이/키 등으로 들어가게 한다
		
		try {
			pstmt = conn.prepareStatement(sql);
			//데이터를 ?에 주입
			pstmt.setString(1,  name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			int su = pstmt.executeUpdate();//실행
			System.out.println(su+"개의 행이 만들어졌습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{//끊을때는 역순
			try {//null값일 때 close시키면 에러발생하므로 if문으로 거른다.
				if(pstmt != null) pstmt.close();
				if(pstmt != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public static void main(String[] args) {
		InsertTest insertTest = new InsertTest();
		insertTest.insertArticle();
	}
}

