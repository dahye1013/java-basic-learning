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

@WebServlet("/GuestbookListServlet")
public class GuestbookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GuestbookDTO guestDTO = new GuestbookDTO();
	public List<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
	public GuestbookListServlet() {
		super();
	}

	//post는 post라고 해달라고 할때만 하고, 나머지는 모두 get방식으로 처리해야한다
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 데이터 얻어오기
		request.setCharacterEncoding("UTF-8");
		
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// DB
		GuestbookDAO guestbookDAO = new GuestbookDAO();
		
		//페이징처리 -1페이지당 2개씩
		int endNum = pg*2;
		int startNum = endNum-1;
		list=guestbookDAO.getGuestbookList(startNum, endNum);
		
		int totalA = guestbookDAO.getTotalA(); //총 글수 
		int totalP = (totalA+1)/2;

		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>글목록</title>");
		out.println("<style>");
		out.println("#currentPaging{color:red; text-decoration:underline;}");
		out.println("#paging{color:black; text-decoration:none;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body> ");
		out.println("[글목록] - 게시글 총 "+totalA+"개");
		out.println("<br>");
		
		if(list != null) {
			for(int i=1; i<=totalP; i++) {
				if(i==pg) 
					out.println("[<a id=currentPaging href='/guestbookServlet/GuestbookListServlet?pg="+i+"'>"+i+"</a>]"); 
				//a태그를 통해서 하이퍼링크 손가락 활성화
				else 
					out.println("[<a id=paging href='/guestbookServlet/GuestbookListServlet?pg="+i+"'>"+i+"</a>]"); 
				//a태그를 통해서 하이퍼링크 손가락 활성화
				
			}
			out.println("<br>");
		}
		
		for (GuestbookDTO dto : list) {
	         
			out.println("<table border=1 width=580px cellspacing=0 cellpadding=3 style=table-layout:fixed>");
			out.println("<tr>");
	         out.println("<td align=center width='100'>작성자</td>");
	         out.println("<td align=center width='100'>"+dto.getName()+"</td>");
	         out.println("<td align=center width='100'>작성일</td>");
	         out.println("<td align=center width='100'>"+dto.getDate()+"</td>");
	         out.println("</tr>");
	         
	         out.println("<tr>");
	         out.println("<td>이메일</td>");
	         out.println("<td colspan='3'>"+dto.getEmail()+"</td>");
	         out.println("</tr>");
	         
	         out.println("<tr>");
	         out.println("<td>홈페이지</td>");
	         out.println("<td colspan='3'>"+dto.getHomepage()+"</td>");
	         out.println("</tr>");
	         
	         out.println("<tr>");
	         out.println("<td>제목</td>");
	         out.println("<td colspan='3'>"+dto.getSubject()+"</td>");
	         out.println("</tr>");
	         
	         out.println("<tr>");
//	         out.println("<td colspan='4' height='300' style=word-break:break-all>"+dto.getContent()+"</td>");
//	         out.println("<td colspan='4' height='300'><pre style='white-space: pre-line; word-break: break-all;'>"+dto.getContent()+"</td>");
	         out.println("<td  colspan='4' style='white-space: pre-wrap; word-break;'>"+dto.getContent()+"</td>");

	         out.println("</tr>");
	         
	         out.println("<hr width=500 color=red align=left></table>");
	         out.println("");
	      }
		

		
		out.println("</body> ");
		out.println("</html> ");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
 

}
