package chat.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import login.controller.LogOnDataBean;


@Component
public class Chat_DAO extends SqlSessionDaoSupport {

	private static Chat_DAO dao = new Chat_DAO();
	
	
	
	public static Chat_DAO getDao() {
		return dao;
	}

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
			
			StringTokenizer stok = new StringTokenizer(crdb.getChat_Member_Participation(), ",", false);
			
			
			String temp = stok.nextToken();
		
			if(temp.equals(String.valueOf(mem_num))){
				temp=stok.nextToken();
			}else{
				stok.nextToken();
			}
		
			
			if(!stok.hasMoreTokens() ){
				LogOnDataBean participation_info= participation_info(new Integer(temp));
				
				crdb.setProfile_IMG(participation_info.getProfile_img());
				crdb.setChat_mem_name(participation_info.getCom_dept_name()+" / "+participation_info.getCom_pos_name()+" / "+participation_info.getName());
				crdb.setChat_partner(participation_info.getName());
				crdb.setChat_Member_Participation(temp);
				
				
				return_list.add(crdb);
			}
			else{
				StringTokenizer multi_Stok = new StringTokenizer(crdb.getChat_Member_Participation(), ",", false);
				String korea_Name = "";
				String multi_Names = "";
				String temp_Names="";
				String Chat_partner="";
				String chat_source;
				int i =0;
				while(multi_Stok.hasMoreTokens()){
					temp_Names = multi_Stok.nextToken();
					System.out.println(temp_Names);
					i++;
					if(temp_Names.equals(String.valueOf(mem_num))){
						
					}else{
						
						multi_Names = multi_Names +temp_Names +","; //硫ㅻ쾭 �닽�옄�젙蹂� 
						LogOnDataBean lodb = participation_info(Integer.parseInt(temp_Names));
						
						korea_Name = lodb.getName();
						
						Chat_partner = Chat_partner+korea_Name+" / ";  // �븳湲��씠由� 異붿텧
						
					}
				}
				
				
				
				Chat_partner= Chat_partner + "("+i+")명";
				
				
				
				crdb.setChat_mem_name(Chat_partner);// ���솕�븷 �떆�엺 �븳湲� �씠由�
				crdb.setChat_Member_Participation(multi_Names);
				crdb.setChat_partner(Chat_partner);
				
				
				
				
				
				
				
			
				
				
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
		
		if(crdb.getLast_Chat_Read()!=null){
		
			list.add( crdb.getLast_Chat_Read());
			list.add(crdb.getLast_Chat_Member());
		
		}
		
		return list;
		
	}
	
	public  void check_MultiRead_Msg(int chat_num,int mem_num){
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("chat_num", String.valueOf(chat_num));
		map.put("mem_num", String.valueOf(mem_num)+",");
		
		
		getSqlSession().update("chat.check_MultiRead_Msg", map);
		
	}
	
	
	public void Read_Msg(int chat_num){
		
		getSqlSession().update("chat.Read_Msg", chat_num);
		
	}
	
	
	
	
	public void insert_Chat_Conversation(int chat_Num,String chat_User,String chat_Conversation,String chat_Date,String chat_User_Name){
	Map map = new HashMap();
	map.put("chat_Num",chat_Num);
	map.put("chat_User",chat_User);
	map.put("chat_Conversation",chat_Conversation);
	map.put("chat_Date",chat_Date);
	map.put("chat_User_Name",chat_User_Name);
		
		
		
	getSqlSession().insert("chat.insert_Chat_Conversation",map);
	
	
	}
	
	public void check_Read_Msg(int chat_num,int mem_num){
		
		Map<String,Integer> map = new  HashMap<String,Integer>();
		map.put("chat_num", chat_num);
		map.put("mem_num", mem_num);
		
		
	getSqlSession().update("chat.check_Read_Msg",map);
	
	}
public void check_Read_Msg(int chat_num,String mem_num){
		
		Map<String,Object> map = new  HashMap<String,Object>();
		map.put("chat_num", chat_num);
		map.put("mem_num", mem_num);
		
		
	getSqlSession().update("chat.check_Read_Msg",map);
	
	}
	
	
	

}
