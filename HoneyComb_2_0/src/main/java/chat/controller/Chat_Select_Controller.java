package chat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import chat.db.ChatRoomDataBean;
import chat.db.Chat_Conversation_DataBean;
import chat.db.Chat_DAO;

@Controller
public class Chat_Select_Controller {

	private Chat_DAO dao;

	public void setDao(Chat_DAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/Chat_Select_Controller.do")
	public String Chat_Select(ChatRoomDataBean crdb, HttpServletRequest request) {

		
		setChatRoom(crdb, request);

		
		System.out.println("dao:::::"+dao.toString());
		return "chatting";
	}

	public void setChatRoom(ChatRoomDataBean crdb, HttpServletRequest request) {
		int mem_num = (int) request.getSession().getAttribute("mem_num");

		List<Chat_Conversation_DataBean> list = new ArrayList<Chat_Conversation_DataBean>();
		List<ChatRoomDataBean> view_list = new ArrayList<ChatRoomDataBean>();

		list = dao.view_Chat_Conversation(crdb.getChat_Num());

		String check_Multi = new String(crdb.getChat_Member_Participation());

		if (check_Multi.contains(",")) {

			List checklist = new ArrayList<>();
			checklist = dao.select_False_Chat(crdb.getChat_Num());
			if (!checklist.isEmpty()) {
				StringTokenizer stokcheck = new StringTokenizer((String) checklist.get(1), ",");

				int room_num = 1;
				int multi_check = 0;

				StringTokenizer another_stokcheck = new StringTokenizer(check_Multi, ",");

				while (another_stokcheck.hasMoreTokens()) {
					another_stokcheck.nextToken();
					room_num++;
				}

				while (stokcheck.hasMoreTokens()) {
					String temp = stokcheck.nextToken();

					if (temp.equals(String.valueOf(mem_num))) {
						multi_check = 1;
					}

				}
				stokcheck = new StringTokenizer((String) checklist.get(1), ",");
				if (multi_check == 0) {

					dao.check_MultiRead_Msg(crdb.getChat_Num(), mem_num);
					checklist = dao.select_False_Chat(crdb.getChat_Num());

					if (stokcheck.countTokens() >= room_num) {

						dao.Read_Msg(crdb.getChat_Num());

					}
				}

				if (stokcheck.countTokens() >= room_num) {
					dao.Read_Msg(crdb.getChat_Num());

				}
			}
		} else {

			dao.Read_Msg(crdb.getChat_Num());

		}

		view_list = dao.view_My_chatroom(mem_num);

		request.getSession().setAttribute("current_chat_list", view_list);
		request.setAttribute("chat_Num", crdb.getChat_Num());
		request.setAttribute("chat_mem_name", crdb.getChat_mem_name());
		request.setAttribute("chat_Member_Participation", crdb.getChat_Member_Participation());
		request.setAttribute("chat_partner", crdb.getChat_partner());

		request.setAttribute("before_chat_record", list);

	}

}
