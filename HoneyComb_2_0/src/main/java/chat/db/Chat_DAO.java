package chat.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import login.controller.LogOnDataBean;

public class Chat_DAO extends SqlSessionDaoSupport {

	public LogOnDataBean participation_info(int mem_num){
		
		LogOnDataBean lodb = getSqlSession().selectOne("load_chat_mem_info", mem_num);
		
		
		
		
		
		return lodb;
		
	}
	
	
	
	public List view_My_chatroom(int mem_num) {
		List list = new ArrayList<>();

		list = getSqlSession().selectList("chat.view_my_chatroom", "%" + String.valueOf(mem_num) + "%");

		return list;

	}

	public List<LogOnDataBean> view_Com_Member(int mem_num, int com_num) {
		List list = new ArrayList<>();

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("mem_num",mem_num);
		map.put("com_num",com_num);
		
		list = getSqlSession().selectList("chat.view_Com_Member", map);

		return list;
	}
	
	
	public boolean check_OneNOne_Chat(String chat_mem_num){
		
		int check = getSqlSession().selectOne("chat.check_OneNOne_Chat", chat_mem_num);
		
		if(check ==0){
		return true;
		}else{
			return false;
		}
		
	}
	
	public void create_OneNOne_Chat(String chat_mem_num){
		
		
		getSqlSession().selectOne("chat.create_OneNOne_Chat", chat_mem_num);
		
		
		
		
	}
	
	
	
	

}
