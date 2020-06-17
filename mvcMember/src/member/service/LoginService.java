package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터 
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		//DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberDTO memberDTO = memberDAO.loginMember(id, pwd);
		
		//응답
		if(memberDTO!=null) {
			String email = memberDTO.getEmail1() +"@"+memberDTO.getEmail2();
			HttpSession session = request.getSession();//세션생성
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", memberDTO.getId());
			session.setAttribute("memEmail", email);
			return "/member/loginOk.jsp";
		}else {
			return "/member/loginFail.jsp";
		}
		
		
	}

}
	