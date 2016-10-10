package chat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import chat.db.Chat_DAO;
import login.controller.LogOnDataBean;



@Controller
public class Chat_InviteForm {

	
	private Chat_DAO dao;
	
	
	
	
	
	public void setDao(Chat_DAO dao) {
		this.dao = dao;
	}
	
	
	
	@RequestMapping(value="/Invite_form.do",method = RequestMethod.GET )
	public String inviteForm(HttpServletRequest request,ModelMap map){
		
		int com_num = (int)request.getSession().getAttribute("com_num");
		int mem_num = (int)request.getSession().getAttribute("mem_num");
		
		List<LogOnDataBean> chat_members = new ArrayList<LogOnDataBean>();
		chat_members = dao.view_Com_Member(mem_num, com_num);
		
		map.addAttribute("chat_members", chat_members);
		
		
		return "Invite_form";
	}
	
	@RequestMapping(value="/Invite_form.do",method = RequestMethod.POST )
	public String inviteMember(HttpServletRequest request,ModelMap map,
			@RequestParam("check") List<String> check
			){
		System.out.println("chekc::"+check.toString());

		
		ArrayList<Integer> check_mem_num = new ArrayList<Integer>();
		int mem_num = (int)request.getSession().getAttribute("mem_num");
		
		if(check.size()==1){
			String chat_mem_num = "";
			check_mem_num.add(new Integer(check.get(0)));
			check_mem_num.add(mem_num);
			check_mem_num.sort(null);
			
			chat_mem_num = check_mem_num.get(0)+"n"+check_mem_num.get(1);
			
			
			
			if(dao.check_OneNOne_Chat(chat_mem_num)){
	
				dao.create_OneNOne_Chat(chat_mem_num);
				
				
			}
			
			
			
		}
	
		
		
	
		
		
		
		
		
		
		return "Invite_pro";
	}


}
