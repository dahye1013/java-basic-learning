package member.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.bean.ZipcodeDTO;
import member.dao.MemberDAO;

public class CheckPostService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//데이터 
		request.setCharacterEncoding("UTF-8");
		String sido = request.getParameter("sido");
		String sigungu = request.getParameter("sigungu");
		String roadname = request.getParameter("roadname");
		System.out.println(sido+","+sigungu+","+roadname);

		//DB
		List<ZipcodeDTO> list =null;
		if(sido!=null && roadname!=null){
			MemberDAO memberDAO = MemberDAO.getInstance(); //싱글톤으로 생성한다
			list = memberDAO.getZipcodeList(sido, sigungu, roadname);
			if(list != null)System.out.println(list.size());
		}
		
		ArrayList<String> addList = new ArrayList<String>();
		
		if(list !=null){ 
		for(ZipcodeDTO zipcodeDTO: list){
			String address =  zipcodeDTO.getSido()+" "+zipcodeDTO.getSigungu()+" "+ zipcodeDTO.getYubmyungdong()+" "
					+zipcodeDTO.getRi()+" "+zipcodeDTO.getRoadname()+" "+zipcodeDTO.getBuildingname();
			addList.add(address);
			}
		}

		request.setAttribute("addList", addList);

		//응답
		
		request.setAttribute("list", list);	
		


		
		return "/member/checkPost.jsp";
	}

}
