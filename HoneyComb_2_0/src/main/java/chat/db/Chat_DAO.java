package chat.db;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class Chat_DAO extends SqlSessionDaoSupport {

	public List view_My_chatroom(int mem_num){
		List list = new ArrayList<>();
		
		list = getSqlSession().selectList("chat.view_my_chatroom", "%"+mem_num+"%");
		
		
		
		
		
		
		return list;
		
	}
	
	
}
