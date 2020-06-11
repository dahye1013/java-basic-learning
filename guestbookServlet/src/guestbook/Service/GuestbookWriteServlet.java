package guestbook.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;


@WebServlet("/GuestbookWriteServlet")
public class GuestbookWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name, email, homepage, subject, content;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//데이터 얻어오기
		request.setCharacterEncoding("UTF-8");
		name = request.getParameter("name");
		email = request.getParameter("email");
		homepage = request.getParameter("homepage");
		subject = request.getParameter("subject");
		content = request.getParameter("content");
		content = content.replace("\r\n","<br>");

		GuestbookDTO guestbookDTO= new GuestbookDTO();
		guestbookDTO.setName(name);
		guestbookDTO.setEmail(email);
		guestbookDTO.setHomepage(homepage);
		guestbookDTO.setSubject(subject);
		guestbookDTO.setContent(content);
		
		//DB
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		int su = guestbookDAO.writeGuestbook(guestbookDTO);
		
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>"); 
		out.println("<head>");
		out.println("<title>글 작성 성공</title>");
		out.println("</head>");
		out.println("<body>");
		if(su==1) {
			out.println("작성하신 글 저장 성공!<br>");
			out.println("<input type=button value='글목록' "
					+ "onclick=location.href='http://localhost:8080/guestbookServlet/GuestbookListServlet?pg=1'>");

		}else
			out.println("방명록 작성 실패");
		out.println("</body>");
		out.println("</html>");
	}
}


