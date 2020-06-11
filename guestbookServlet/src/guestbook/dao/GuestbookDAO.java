package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guestbook.bean.GuestbookDTO;

public class GuestbookDAO {
	private static GuestbookDAO instance;
	GuestbookDTO guestbookDTO = new GuestbookDTO();
	// ----------------------------------DB-------------------------------
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "c##java";
	String password = "bit";
	
	Connection conn;
	PreparedStatement pstmt;
	private ResultSet rs;
	
	public static GuestbookDAO getInstance() {
		if (instance == null) { 
			synchronized (GuestbookDAO.class) {
				instance = new GuestbookDAO();
			}
		}
		return instance;
	}
	
	public GuestbookDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int writeGuestbook(GuestbookDTO guestbookDTO) {
		int su = 0;
		getConnection();
		String sql ="insert into guestbook VALUES(seq_guestbook.nextval, ?, ?,?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, guestbookDTO.getName());
			pstmt.setString(2, guestbookDTO.getEmail());
			pstmt.setString(3, guestbookDTO.getHomepage());
			pstmt.setString(4, guestbookDTO.getSubject());
			pstmt.setString(5, guestbookDTO.getContent());
			su = pstmt.executeUpdate(); //실행
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	}
	
	public List<GuestbookDTO> getGuestbookList(int startNum, int endNum){
		List<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
		getConnection();
		String sql = "select * from "
				+ "(select rownum rn, tt.* from"
				+ "(select seq, name, email, homepage, subject, content, logtime"
				+ " from guestbook order by seq desc)tt"
				+ ") where rn>=? and rn<=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs= pstmt.executeQuery();//실행
			while(rs.next()) {
				GuestbookDTO guestbookDTO = new GuestbookDTO();
				guestbookDTO.setSeq(rs.getInt("seq"));
				guestbookDTO.setName(rs.getString("name"));
				guestbookDTO.setEmail(rs.getString("email"));
				guestbookDTO.setHomepage(rs.getString("homepage"));
				guestbookDTO.setSubject(rs.getString("subject"));
				guestbookDTO.setContent(rs.getString("content"));
				guestbookDTO.setDate(rs.getDate("logtime"));
				list.add(guestbookDTO);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null; //list 에 문제가 있어서 예외처리가 발생하면 list가 적상 작동하면 안됨. null로 바꿔서 null exception이 뜨게한다.
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
 
	public int getTotalA() {
		int totalA = 0;
		String sql = "select count(*) from guestbook";
		getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();//select는 무조건 쿼리
			rs.next(); //초점을 속성 아래로 내려야함
			totalA = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalA;
	}
	
}
