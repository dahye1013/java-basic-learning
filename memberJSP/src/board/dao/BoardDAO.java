package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardDTO;

public class BoardDAO {
	private static BoardDAO instance;
	// ----------------------------------DB-------------------------------
	private DataSource ds;
	
	Connection conn;
	PreparedStatement pstmt;
	private ResultSet rs;

	public BoardDAO() {
		try {
			Context ctx = new InitialContext(); // context는 인터페이스라 new InitialContext로 초기화해준다, import는 javax naming
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
	public static BoardDAO getInstance() {
		if (instance == null) { // null일때만 생성할 수 있게하므로, 한번에 하나밖에 생성할 수 없다.
			synchronized (BoardDAO.class) {// 한번의 하나의 클래스만 통과할 수 있도록 한다.
				instance = new BoardDAO(); // 메모리에 한번 생성
			}
		}
		return instance;
	}
	
	
	
	public int writeBoard(String subject, String content) {
		BoardDTO boardDTO = new BoardDTO();
		int su = 0;
		
		String sql = "insert into board VALUES(seq_board.nextval,'hong','홍길동'," + 
				"                        'hong@java.com',?,?," + 
				"                        seq_board.nextval,0,0,0,0,0, sysdate)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
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
	
	public void boardWrite(Map<String, String> map) {
//		String sql = "insert into board VALUES(seq_board.nextval ,? , ? , ? , ? , ? , seq_board.currval " //ref-그룹번호 
//				+ ", ?, ?, ?, ?, ?, sysdate)";
		String sql= "insert into board(seq,id,name,email,subject,content,ref) values(seq_board.nextval,?,?,?,?,?,seq_board.currval)";
		
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, map.get("id"));
			pstmt.setString(2, map.get("name"));
			pstmt.setString(3, map.get("email"));
			pstmt.setString(4, map.get("subject"));
			pstmt.setString(5, map.get("content"));
			pstmt.executeUpdate(); //실행
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}  finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public List<BoardDTO> getBoardList(int startNum, int endNum){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "select * from "
			   +" (select rownum rn, tt.* from"
			   +"	    (select *"
			   +" 	    from board order by seq desc)tt"
			   +"	    ) where rn>=? and rn<=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs= pstmt.executeQuery();//실행
			while(rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setRn(rs.getInt(1));
				boardDTO.setSeq(rs.getInt(2));
				boardDTO.setId(rs.getString(3));
				boardDTO.setName(rs.getString(4));
				boardDTO.setEmail(rs.getString(5));
				boardDTO.setSubject(rs.getString(6));
				boardDTO.setContent(rs.getString(7));
				boardDTO.setRef(rs.getInt(8));
				boardDTO.setLev(rs.getInt(9));
				boardDTO.setStep(rs.getInt(10));
				boardDTO.setPseq(rs.getInt(11));
				boardDTO.setReply(rs.getInt(12));
				boardDTO.setHit(rs.getInt(13));
				boardDTO.setLogdate(rs.getDate(14));
				list.add(boardDTO);
				
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
		String sql = "select count(*) from board";
		try {
			conn = ds.getConnection();
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
	
	public List<BoardDTO> boardList(int startNum, int endNum){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "select * from "
			   +" (select rownum rn, tt.* from"
			   +"	    (select *"
			   +" 	    from board order by seq desc)tt"
			   +"	    ) where rn>=? and rn<=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs= pstmt.executeQuery();//실행
			while(rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setRn(rs.getInt(1));
				boardDTO.setSeq(rs.getInt(2));
				boardDTO.setId(rs.getString(3));
				boardDTO.setName(rs.getString(4));
				boardDTO.setEmail(rs.getString(5));
				boardDTO.setSubject(rs.getString(6));
				boardDTO.setContent(rs.getString(7));
				boardDTO.setRef(rs.getInt(8));
				boardDTO.setLev(rs.getInt(9));
				boardDTO.setStep(rs.getInt(10));
				boardDTO.setPseq(rs.getInt(11));
				boardDTO.setReply(rs.getInt(12));
				boardDTO.setHit(rs.getInt(13));
				boardDTO.setLogdate(rs.getDate(14));
				list.add(boardDTO);
				
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
	
	
	public BoardDTO getSingleBoard(int seq){
		String sql = "select * from board where seq=?";
		BoardDTO boardDTO = new BoardDTO();
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs= pstmt.executeQuery();//실행
			while(rs.next()) {
				boardDTO.setSeq(rs.getInt(1));
				boardDTO.setId(rs.getString(2));
				boardDTO.setName(rs.getString(3));
				boardDTO.setEmail(rs.getString(4));
				boardDTO.setSubject(rs.getString(5));
				boardDTO.setContent(rs.getString(6));
				boardDTO.setRef(rs.getInt(7));
				boardDTO.setLev(rs.getInt(8));
				boardDTO.setStep(rs.getInt(9));
				boardDTO.setPseq(rs.getInt(10));
				boardDTO.setReply(rs.getInt(11));
				boardDTO.setHit(rs.getInt(12));
				boardDTO.setLogdate(rs.getDate(13));
				
				
			}
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
		return boardDTO;
	}
	
	
	
	public void updateBoard(int seq, String subject, String content) {
		String sql= "update board set subject=? , content=? where seq=?";	
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, seq);
			pstmt.executeUpdate(); //실행
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}  finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}















