package chat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import chat.db.ChatRoomDataBean;
import chat.db.Chat_DAO;

@Controller
public class Chat_Main_Controller {

	
	private Chat_DAO dao;
	
	
	
	
	
	public void setDao(Chat_DAO dao) {
		this.dao = dao;
	}





	@RequestMapping("/mainchat.do")
	public ModelAndView gotoChatMain(HttpServletRequest request){
		int mem_num = (int) request.getSession().getAttribute("mem_num");
		List<ChatRoomDataBean> view_list= new ArrayList<ChatRoomDataBean>();
		
		view_list = dao.view_My_chatroom(mem_num);
		
		for(Object c : view_list){
			ChatRoomDataBean crdb = (ChatRoomDataBean) c;
			
			System.out.println("chat:::::"+crdb.toString());
			
		}
		
		ModelAndView mov = new ModelAndView("chat_main");
		
		mov.addObject("current_chat_list", view_list);
		
		
		return mov;
	}
	
}
