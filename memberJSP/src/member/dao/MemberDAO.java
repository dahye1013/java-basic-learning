package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public class MemberDAO {
	private static MemberDAO instance;
	// ----------------------------------DB-------------------------------
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "c##java";
	String password = "bit";
	Connection conn;
	PreparedStatement pstmt;
	private ResultSet rs;

	public static MemberDAO getInstance() {
		if (instance == null) { // null일때만 생성할 수 있게하므로, 한번에 하나밖에 생성할 수 없다.
			synchronized (MemberDAO.class) {// 한번의 하나의 클래스만 통과할 수 있도록 한다.
				instance = new MemberDAO(); // 메모리에 한번 생성
			}
		}
		return instance;
	}

	public MemberDAO() {
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

	public void writeMember(MemberDTO memberDTO) {
		int su = 0;
		getConnection();
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getZipcode());
			pstmt.setString(11, memberDTO.getAddr1());
			pstmt.setString(12, memberDTO.getAddr2());
			su = pstmt.executeUpdate(); // 실행
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

	}

	public List<MemberDTO> getMemberList() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		getConnection();
		String sql = "select*from member";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();// 실행
			while (rs.next()) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setName(rs.getString(1));
				memberDTO.setId(rs.getString(2));
				memberDTO.setPwd(rs.getString(3));
				memberDTO.setGender(rs.getString(4));
				memberDTO.setEmail1(rs.getString(5));
				memberDTO.setEmail2(rs.getString(6));
				memberDTO.setTel1(rs.getString(7));
				memberDTO.setTel2(rs.getString(8));
				memberDTO.setTel3(rs.getString(9));
				memberDTO.setZipcode(rs.getString(10));
				memberDTO.setAddr1(rs.getString(11));
				memberDTO.setAddr2(rs.getString(12));
				memberDTO.setDate(rs.getDate(13));
				list.add(memberDTO);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null; // list 에 문제가 있어서 예외처리가 발생하면 list가 적상 작동하면 안됨. null로 바꿔서 null exception이 뜨게한다.
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
		return list;
	}
	public MemberDTO getMember(String id) {
		MemberDTO memberDTO = null;
		String sql = "select * from member where id=?";
		getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setName(rs.getString("name"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));
				memberDTO.setTel1(rs.getString("tel1"));
				memberDTO.setTel2(rs.getString("tel2"));
				memberDTO.setTel3(rs.getString("tel3"));
				memberDTO.setZipcode(rs.getString("zipcode"));
				memberDTO.setAddr1(rs.getString("addr1"));
				memberDTO.setAddr2(rs.getString("addr2"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return memberDTO;
	}
	public MemberDTO getMemberInfo(String id) {
		MemberDTO memberDTO = new MemberDTO();
		getConnection();
		String sql = "select * from member where id = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // 실행

			if (rs.next()) { 
				memberDTO.setName(rs.getString(1));
				memberDTO.setId(rs.getString(2));
				memberDTO.setPwd(rs.getString(3));
				memberDTO.setGender(rs.getString(4));
				memberDTO.setEmail1(rs.getString(5));
				memberDTO.setEmail2(rs.getString(6));
				memberDTO.setTel1(rs.getString(7));
				memberDTO.setTel2(rs.getString(8));
				memberDTO.setTel3(rs.getString(9));
				memberDTO.setZipcode(rs.getString(10));
				memberDTO.setAddr1(rs.getString(11));
				memberDTO.setAddr2(rs.getString(12));
				memberDTO.setDate(rs.getDate(13));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			memberDTO = null; // list 에 문제가 있어서 예외처리가 발생하면 list가 적상 작동하면 안됨. null로 바꿔서 null exception이 뜨게한다.
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
		return memberDTO;
	}

	public String loginMember(String id, String pwd) {
		String name = null;
		String sql = "select*from member where id=? and pwd=?";
		getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			rs = pstmt.executeQuery(); // 실행

			if (rs.next()) { // 어차피 한 레코드밖에 나오지 않는다. -> while필요없음.
				name = rs.getString("name");
			}
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
		return name;
	}

	public boolean isExistedId(String id) {
		String result=null;
		String sql = "select id from member where id=?";
		getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery(); 
			
			if (rs.next()) {
				result = rs.getString("id");
			}
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
		if (result == null) {
			return false;
		} else
			return true;
	}
	
	
	public List<ZipcodeDTO> getZipcodeList(String sido, String sigungu,String roadname) {
		List<ZipcodeDTO> list = new ArrayList<ZipcodeDTO>();
		getConnection();
		String sql = "select * from newzipcode where sido like ? and nvl(sigungu,'0') like ? and roadname like ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			// 실행
			pstmt.setString(1, "%"+sido+"%");
			pstmt.setString(2, "%"+sigungu+"%");
			pstmt.setString(3, "%"+roadname+"%");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {				
				ZipcodeDTO zipcodeDTO = new ZipcodeDTO();
				zipcodeDTO.setZipcode(rs.getString("zipcode"));
				zipcodeDTO.setSido(rs.getString("sido"));
				zipcodeDTO.setSigungu(rs.getString("sigungu")==null? "" : rs.getString("sigungu"));
				zipcodeDTO.setRoadname(rs.getString("roadname"));
				zipcodeDTO.setBuildingname(rs.getString("buildingname")==null? "" : rs.getString("buildingname"));
				zipcodeDTO.setYubmyungdong(rs.getString("yubmyundong"));
				//zipcodeDTO.setRi(rs.getString("ri"));
				//조건 연산자  조건? 참:거짓
				zipcodeDTO.setRi(rs.getString("ri")==null? "" : rs.getString("ri")); 
				
				list.add(zipcodeDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null; 
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
		return list;
	}
	

	public void modifyMember(MemberDTO memberDTO) {
		getConnection();
		String sql = "update member set name=? ,"
				+ "pwd=? ,"
				+ "gender=? ,"
				+ "email1=? ,"
				+ "email2=? ,"
				+ "tel1=? ,"
				+ "tel2=? ,"
				+ "tel3=? ,"
				+ "zipcode=? ,"
				+ "addr1=? ,"
				+ "addr2=? ,"
				+ "logtime=sysdate where id=?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getGender());
			pstmt.setString(4, memberDTO.getEmail1());
			pstmt.setString(5, memberDTO.getEmail2());
			pstmt.setString(6, memberDTO.getTel1());
			pstmt.setString(7, memberDTO.getTel2());
			pstmt.setString(8, memberDTO.getTel3());
			pstmt.setString(9, memberDTO.getZipcode());
			pstmt.setString(10, memberDTO.getAddr1());
			pstmt.setString(11, memberDTO.getAddr2());
			pstmt.setString(12, memberDTO.getId());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
	public static void main(String[] args) {
		
	}
	
}