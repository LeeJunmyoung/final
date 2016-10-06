package chat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import chat.db.ChatRoomDataBean;

@Controller
public class Chat_Main_Controller {

	
	
	
	
	
	
	@RequestMapping("/mainchat.do")
	public String gotoChatMain(HttpServletRequest request){
		int mem_num = (int) request.getSession().getAttribute("mem_num");
		List<ChatRoomDataBean> view_list= new ArrayList<ChatRoomDataBean>();
		
		
		
		return "chat_main";
	}
	
}
