package chat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import chat.db.ChatRoomDataBean;
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
		

		
		ArrayList<Integer> check_mem_num = new ArrayList<Integer>();
		List<ChatRoomDataBean> view_list = new ArrayList<ChatRoomDataBean>();
		int mem_num = (int)request.getSession().getAttribute("mem_num");
		
		if(check.size()==1){
			String chat_mem_num = "";
			check_mem_num.add(new Integer(check.get(0)));
			check_mem_num.add(mem_num);
			check_mem_num.sort(null);
			
			chat_mem_num = check_mem_num.get(0)+","+check_mem_num.get(1);
			
			
			
			if(dao.check_OneNOne_Chat(chat_mem_num)){
	
				dao.create_OneNOne_Chat(chat_mem_num);
				
				
			} else {
				view_list = dao.view_My_chatroom(check_mem_num.get(1));
				request.getSession().setAttribute("current_chat_list", view_list);

				int chat_num = 0;
				String chat_mem_name = "";
				String chat_Member_Participation = "";
				String last_Chat_Date = "";
				String last_Chat_Conversation = "";

				for (ChatRoomDataBean chat : view_list) {
					System.out.println("chat_member_pa::::::::"+chat.getChat_Member_Participation());
					System.out.println("check_mem_num::::"+check_mem_num.get(0));
					
					
					if (chat.getChat_Member_Participation().equals(String.valueOf(check_mem_num.get(0)))) {
						chat_num = chat.getChat_Num();
						chat_mem_name = chat.getChat_mem_name();
						chat_Member_Participation = chat.getChat_Member_Participation();
						last_Chat_Date = chat.getLast_Chat_Date();
						last_Chat_Conversation = chat.getLast_Chat_Conversation();
					}

				}

				request.setAttribute("chat_Num", chat_num);
				request.setAttribute("chat_mem_name", chat_mem_name);
				request.setAttribute("chat_Member_Participation", chat_Member_Participation);

				return "Existed_Chat";

			}
			view_list = dao.view_My_chatroom(check_mem_num.get(1));

			request.getSession().setAttribute("current_chat_list", view_list);

			
			
			
			
			
			return "Invite_pro";
			
			
		}else {
			check_mem_num.add(mem_num);
			for(int i= 0; i< check.size(); i++){
				check_mem_num.add(new Integer(check.get(i)));
			}
			check_mem_num.sort(null);
			
			/*String [] multi_Mem_Num = new String [invite_mem_num.length+1]; 
			
			for(int i =0; i< invite_mem_num.length;i++){
				multi_Mem_Num[i] = invite_mem_num[i];
			}
			multi_Mem_Num[invite_mem_num.length] = String.valueOf(my_mem_num);
			
			for (int i = 0; i < multi_Mem_Num.length; i++) {
				for (int j = 0; j < multi_Mem_Num.length; j++) {

					if (Integer.parseInt(multi_Mem_Num[j]) > Integer.parseInt(multi_Mem_Num[i])) {
						String temp = "";
						temp = multi_Mem_Num[i];
						multi_Mem_Num[i] = multi_Mem_Num[j];
						multi_Mem_Num[j] = temp;
					}
				}

			}
			chat_mem_num="";
			for(int i = 0; i<multi_Mem_Num.length;i++){
				chat_mem_num = chat_mem_num + multi_Mem_Num[i] ;
				if(i != multi_Mem_Num.length-1){
					chat_mem_num = chat_mem_num +"n";
				}
			}*/
			
			String chat_mem_num = "";
			for(int i =0; i< check_mem_num.size();i++){
				chat_mem_num=chat_mem_num+check_mem_num.get(i);
				if(i!= check_mem_num.size()-1){
					chat_mem_num=chat_mem_num+",";
				}
			}
			if(dao.check_OneNOne_Chat(chat_mem_num)){
				dao.create_OneNOne_Chat(chat_mem_num);
			}
			
			
			
			
			view_list = dao.view_My_chatroom(mem_num);

			request.getSession().setAttribute("current_chat_list", view_list);

			return "Invite_pro";
			
			
			
		}
	
		
		
	

	
		
		
	
	}
		
		
	
	

}
