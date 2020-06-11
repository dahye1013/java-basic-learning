package member.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public List<MemberDTO> list = new ArrayList<MemberDTO>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 데이터 얻어오기
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//DB
 		MemberDAO memberDAO = new MemberDAO();
 		String name = memberDAO.loginMember(id, pwd);
 		
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>로그인</title>");
		out.println("</head>");
		out.println("<body>");

		if(name==null) out.println("로그인실패");
		else out.println(name+"님 로그인 성공");
		
			
		out.println("</body>");
		out.println("</html>");

	}

}
