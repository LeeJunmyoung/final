package chat.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import login.controller.LogOnDataBean;

public class Chat_DAO extends SqlSessionDaoSupport {

	public LogOnDataBean participation_info(int mem_num) {

		LogOnDataBean lodb = getSqlSession().selectOne("load_chat_mem_info", mem_num);

		return lodb;

	}

	public List view_My_chatroom(int mem_num) {
		List list = new ArrayList<>();

		list = getSqlSession().selectList("chat.view_my_chatroom", "%" + String.valueOf(mem_num) + "%");

		
		
		
		
		
		
		
		
		return detail_view_my_chat(list,mem_num);

	}

	public List detail_view_my_chat(List view_my_chatroom,int mem_num) {
		ArrayList<ChatRoomDataBean> return_list = new ArrayList<ChatRoomDataBean>();
		for(Object c : view_my_chatroom){
			ChatRoomDataBean crdb = (ChatRoomDataBean) c;
			
			StringTokenizer stok = new StringTokenizer(crdb.getChat_Member_Participation(), "n", false);
			
			
			String temp = stok.nextToken();
			
			
			
			
			if(temp.equals(String.valueOf(mem_num))){
				temp=stok.nextToken();
			}else{
				stok.nextToken();
			}
			
			
			
			if(!stok.hasMoreTokens() ){
				LogOnDataBean participation_info= participation_info(new Integer(temp));
				
				crdb.setProfile_IMG(participation_info.getProfile_img());
				crdb.setChat_mem_name(participation_info.getCom_dept_name()+" "+participation_info.getCom_pos_name()+" "+participation_info.getName());
				crdb.setChat_partner(participation_info.getName());
				
				
				/*
				pstmt= conn.prepareStatement(" select profile_img from members where mem_num = ? ");
				pstmt.setInt(1, Integer.parseInt(temp));
				rs2 = pstmt.executeQuery();
				if(rs2.next()){
					crdb.setProfile_IMG(rs2.getString(1));
				}
				crdb.setChat_Member_Participation(temp);
				crdb.setLast_Chat_Date(rs.getString(3));
				crdb.setLast_Chat_Conversation(rs.getString(4));	
				chat_source = view_Chat_Info(Integer.parseInt(temp));
				crdb.setChat_mem_name(chat_source);
				stok = new StringTokenizer(chat_source, " ",false);
				Chat_partner = stok.nextToken();
				crdb.setChat_partner(Chat_partner);
				//20168�썡 17�씪 異붽�遺�  �씫�뾿�뒗吏� �븡�씫�뾿�뒗吏� �솗�씤
				crdb.setLast_Chat_Member(rs.getString("Last_Chat_Member"));
				crdb.setLast_Chat_Read(rs.getString("Last_Chat_Read"));
				list.add(crdb);
				*/	
				return_list.add(crdb);
			}
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		return return_list;
	}

	public List<LogOnDataBean> view_Com_Member(int mem_num, int com_num) {
		List list = new ArrayList<>();

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("mem_num", mem_num);
		map.put("com_num", com_num);

		list = getSqlSession().selectList("chat.view_Com_Member", map);

		return list;
	}

	public boolean check_OneNOne_Chat(String chat_mem_num) {

		int check = getSqlSession().selectOne("chat.check_OneNOne_Chat", chat_mem_num);

		if (check == 0) {
			return true;
		} else {
			return false;
		}

	}

	public void create_OneNOne_Chat(String chat_mem_num) {

		getSqlSession().selectOne("chat.create_OneNOne_Chat", chat_mem_num);

	}
	
	
	public List view_Chat_Conversation(int chat_num){
		List<Chat_Conversation_DataBean> list = new ArrayList<Chat_Conversation_DataBean>();
		list =  getSqlSession().selectList("chat.view_Chat_Conversation", chat_num);
		return list;
	}
	
	public List select_False_Chat(int chat_num){
		List<String> list= new ArrayList<String>();
		ChatRoomDataBean crdb =  getSqlSession().selectOne("chat.select_False_Chat", chat_num);
		
		
		list.set(0, crdb.getLast_Chat_Read());
		list.set(1, crdb.getLast_Chat_Member());
		
		
		return list;
		
	}
	
	public  void check_MultiRead_Msg(int chat_num,int mem_num){
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("chat_num", String.valueOf(chat_num));
		map.put("mem_num", String.valueOf(mem_num)+"n");
		
		
		getSqlSession().update("chat.check_MultiRead_Msg", map);
		
	}
	
	
	public void Read_Msg(int chat_num){
		
		getSqlSession().update("chat.Read_Msg", chat_num);
		
	}
	
	
	
	

}
