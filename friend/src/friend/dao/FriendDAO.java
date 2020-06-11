package friend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import friend.bean.FriendDTO;

public class FriendDAO {
	// ----------------------------------DB-------------------------------
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "c##java";
	String password = "bit";
	Connection conn;
	PreparedStatement pstmt;
	private ResultSet rs;
	int seq;

	public FriendDAO() {
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

	public int friendWrite(FriendDTO friendDTO) {
		int su = 0;
		getConnection();
		String sql = "insert into friend values(?,?,?,?,?,?,?,?,?,?,?)"; // 테이블 values를 다 집어넣을거면 column명을 안써도됨
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, friendDTO.getSeq());
			pstmt.setString(2, friendDTO.getName());
			pstmt.setString(3, friendDTO.getTel1());
			pstmt.setString(4, friendDTO.getTel2());
			pstmt.setString(5, friendDTO.getTel3());
			pstmt.setInt(6, friendDTO.getGender());
			pstmt.setInt(7, friendDTO.getRead());
			pstmt.setInt(8, friendDTO.getMovie());
			pstmt.setInt(9, friendDTO.getMusic());
			pstmt.setInt(10, friendDTO.getGame());
			pstmt.setInt(11, friendDTO.getShopping());

			su = pstmt.executeUpdate();

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

		return su;
	}
	
	public int friendUpdate(FriendDTO friendDTO) {
		int su = 0;
		getConnection();
		String sql = "update friend set name=?"
				+ " , tel1=?,"
				+ " tel2=?,"
				+ " tel3 =?,"
				+ " gender =?,"
				+ " read=?,"
				+ " movie=?,"
				+ " music=? ,"
				+ " game=?,"
				+ " shopping=?"
				+ " where seq = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, friendDTO.getName());
			pstmt.setString(2, friendDTO.getTel1());
			pstmt.setString(3, friendDTO.getTel2());
			pstmt.setString(4, friendDTO.getTel3());
			pstmt.setInt(5, friendDTO.getGender());
			pstmt.setInt(6, friendDTO.getRead());
			pstmt.setInt(7, friendDTO.getMovie());
			pstmt.setInt(8, friendDTO.getMusic());
			pstmt.setInt(9, friendDTO.getGame());
			pstmt.setInt(10, friendDTO.getShopping());
			pstmt.setInt(11, friendDTO.getSeq());
			su= pstmt.executeUpdate();
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
		
		
		return su;
	}

	public int getSeq() {
		int seq = 0;
		getConnection();
		String sql = "select seq_friend.nextval from dual";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next(); // 현재위치에 레코드가 있는지를 묻는다
			seq = rs.getInt(1); // 1번 컬럼에서 값을 꺼낸다.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

		return seq;
	}

	public int friendDelete(FriendDTO friendDTO) {
		int su = 0;
		int seq = friendDTO.getSeq();
		getConnection();
		String sql = "delete friend where seq=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null)	conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return su ;
	}
	
	public List<FriendDTO> getFriendList() {
		List<FriendDTO> list = new ArrayList<FriendDTO>();
		getConnection();
		String sql = "select*from friend";
		try {
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();//실행
			while(rs.next()) {
				FriendDTO friendDTO = new FriendDTO();
				friendDTO.setSeq(rs.getInt("seq"));
				friendDTO.setName(rs.getString("name"));
				friendDTO.setTel1(rs.getString("tel1"));
				friendDTO.setTel2(rs.getString("tel2"));
				friendDTO.setTel3(rs.getString("tel3"));
				friendDTO.setGender(rs.getInt("gender"));
				friendDTO.setRead(rs.getInt("read"));
				friendDTO.setMovie(rs.getInt("movie"));
				friendDTO.setMusic(rs.getInt("music"));
				friendDTO.setGame(rs.getInt("game"));
				friendDTO.setShopping(rs.getInt("shopping"));
				list.add(friendDTO);
				
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

}
