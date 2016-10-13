
package wsapp;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.ejb.EJB;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import chat.db.Chat_DAO;


@Controller
@ServerEndpoint(value = "/websocket/Chatting") // 클라이언트가 접속할 때 사용될 URI
public class ChatServer {


	private static Chat_DAO dao ;
	

	



	
	public static void setDao(Chat_DAO dao) {
		ChatServer.dao = dao;
	}

	private static final Map<String, Session> sessionMap = new HashMap<String, Session>();

	private static final Map<String, Integer> chat_num_Map = new HashMap<String, Integer>();

	//private static Chat_Conversation_DBBean chat_db = Chat_Conversation_DBBean.getInstance();

	
	String mem_name;

	String receiverMem;

	String chat_Num;

	private Session session;

	public ChatServer() {
	

	}

	@OnOpen
	public void start(Session session) {
	
		
		
		String queryString = session.getQueryString();

		System.out.println("디코딩 전 쿼리스트링 : " + queryString);
		queryString = this.decoder(queryString);
		System.out.println("디코딩 후 쿼리스트링!!" + queryString);
		mem_name = this.getParameter(queryString, "mem_name");
		System.out.println("mem_name : " + mem_name);

		System.out.println("클라이언트 접속됨 " + session);

		chat_Num = this.getParameter(queryString, "chat_Num");

		// 접속자마다 한개의 세션이 생성되어 데이터 통신수단으로 사용됨
		this.session = session;
		sessionMap.put(mem_name, session);

		chat_num_Map.put(mem_name, new Integer(chat_Num));

		String message = String.format("* %s", mem_name, "has joined.");

		// sendToOne(message, sessionMap.get(mem_name));
		if (sessionMap.get(receiverMem) != null) {
		//	 sendToOne(message, sessionMap.get(receiverMem));
		}

	}

	@OnClose
	public void end() {
		
		
		sessionMap.remove(this.mem_name);
		chat_num_Map.remove(this.mem_name);
		String message = String.format("* %s %s", mem_name, "has disconnected.");

		// sendToOne(message, sessionMap.get(mem_name));
		if (sessionMap.get(receiverMem) != null) {
			// sendToOne(message, sessionMap.get(receiverMem));
		}

	}

	// 현재 세션과 연결된 클라이언트로부터 메시지가 도착할 때마다 새로운 쓰레드가 실행되어 incoming()을 호출함
	@OnMessage
    public void incoming(String message,Session session) {
		System.out.println("message:::::::"+message);
		
		
    	String queryString  = session.getQueryString();
    	queryString = this.decoder(queryString);
    	receiverMem = this.getParameter(queryString, "receiver") ;
    	
    	String my_name = this.getParameter(queryString, "my_name");
    	
    	StringTokenizer stok  = new StringTokenizer(receiverMem, ",");// 멀티채팅 멤버넘버 가져오기
    	
    	String temp_receiverMem = stok.nextToken();
    
    	
    	Vector<String> multi_Receiver = null;
    	
    	String date = "";
        Date d = new Date();
        date = String.valueOf(d.getMonth()+1)+"월 "+String.valueOf(d.getDate())+"일 "+String.valueOf(d.getHours())+"시 "+String.valueOf(d.getMinutes())+"분"; 

    	
    	
    	
    	String threadName = "Thread-Name:"+Thread.currentThread().getName();
    	System.out.println("메시지 도착:"+threadName+", "+mem_name);
        if(message==null || message.trim().equals("")) return;
        String filteredMessage = String.format("%s", message);
        
        System.out.println("receiverMem ::::::::::::::"+receiverMem);
        //Guest0의 메시지는 특정 클라이언트(Guest2)에게만 전달하는 경우
        if(!receiverMem.contains(",")){
        	System.out.println("chat 1n1 실행함니다.");
    	//chat_db.insert_Chat_Conversation(Integer.parseInt(chat_Num), mem_name, filteredMessage, date,my_name);
        dao.insert_Chat_Conversation(Integer.parseInt(chat_Num), mem_name, filteredMessage, date, my_name);
    	if(sessionMap.get(receiverMem)!=null){
        		if(chat_num_Map.get(receiverMem)!=null){
            			if(chat_num_Map.get(mem_name).equals(chat_num_Map.get(receiverMem))){//여기오류
            		
            			sendToOne(filteredMessage, sessionMap.get(receiverMem));
            			
            			}else{
            				
            			String sysmsg = "its message is deffrent user message::"+chat_Num;
                    	sendToOne(sysmsg, sessionMap.get(receiverMem));
                    	
         //           	chat_db.check_Read_Msg(Integer.parseInt(chat_Num),Integer.parseInt(mem_name));
                    	dao.check_Read_Msg(Integer.parseInt(chat_Num), Integer.parseInt(mem_name));
            			}
            		}
        	}else{
        //    	chat_db.check_Read_Msg(Integer.parseInt(chat_Num),Integer.parseInt(mem_name));
        		dao.check_Read_Msg(Integer.parseInt(chat_Num), Integer.parseInt(mem_name));
        	}
    	
    	}else{
    		
    		System.out.println("chat multi 실행함니다.");
    		dao.insert_Chat_Conversation(Integer.parseInt(chat_Num), mem_name, message, date, my_name);
      //  	chat_db.insert_Chat_Conversation(Integer.parseInt(chat_Num), mem_name, message, date,my_name);
        	List check_false =  new ArrayList<String>();
        	check_false=dao.select_False_Chat(Integer.parseInt(chat_Num));
      //  	check_false=chat_db.select_False_Chat(Integer.parseInt(chat_Num));
        	
        	
        	
        	
        	if(check_false.get(0).equals("t")||check_false.get(0)==null){
        		
        		dao.check_Read_Msg(Integer.parseInt(chat_Num), mem_name+",");
    //        chat_db.check_Read_Msg(Integer.parseInt(chat_Num), mem_name+",");//확인 체크 하는거 
        	
        		
        	}
        	check_false=dao.select_False_Chat(Integer.parseInt(chat_Num));
     //   	check_false=chat_db.select_False_Chat(Integer.parseInt(chat_Num));
        	StringTokenizer checktoken = new StringTokenizer((String)check_false.get(1), ",");
            
    		multi_Receiver = new Vector<String>();
    		multi_Receiver.add(temp_receiverMem);
    	
    		while(stok.hasMoreElements()){
    			multi_Receiver.add(stok.nextToken());
    		}
    	
    		int multi_Check_Num = 0;
    		
    		
    		for(int i =0; i< multi_Receiver.size();i++){
    			
    			String multi_Msg = "its message is multiMsg::"+my_name+"::"+message;
    			
    			if(sessionMap.get(multi_Receiver.get(i))!=null){
            		if(chat_num_Map.get(multi_Receiver.get(i))!=null){
                			if(chat_num_Map.get(mem_name).equals(chat_num_Map.get(multi_Receiver.get(i)))){//여기오류
                		
                			sendToOne(multi_Msg, sessionMap.get(multi_Receiver.get(i)));
                		    int check =0;
                			while(checktoken.hasMoreTokens()){
                			if(checktoken.nextToken().equals(sessionMap.get(multi_Receiver.get(i)))){
                			check =1;
                			}
                			}
                			if(check ==0){
                				dao.check_MultiRead_Msg(Integer.parseInt(chat_Num), Integer.parseInt(multi_Receiver.get(i)));
         //       			chat_db.check_MultiRead_Msg(Integer.parseInt(chat_Num), Integer.parseInt(multi_Receiver.get(i)));
                			}
                			multi_Check_Num++;
                			
                			
                			}else{
                				
                			String sysmsg = "its message is deffrent user message::"+chat_Num;
                        	sendToOne(sysmsg, sessionMap.get(multi_Receiver.get(i)));
                        	
                        	dao.check_Read_Msg(Integer.parseInt(chat_Num), Integer.parseInt(mem_name));
                        	//chat_db.check_Read_Msg(Integer.parseInt(chat_Num),Integer.parseInt(mem_name));
                			}
                		}
            	}
    			
    			if(multi_Check_Num == multi_Receiver.size()){
    				dao.Read_Msg(chat_num_Map.get(mem_name));
    	//			chat_db.Read_Msg(chat_num_Map.get(mem_name));
    			}
    			
    		}
    		
    		
    	}
    	
    }

	@OnError
	public void onError(Throwable t) throws Throwable {
		System.err.println("오류/세션제거(" + mem_name + "):Chat Error: " + t.toString());
		sessionMap.remove(this.mem_name);
		chat_num_Map.remove(this.mem_name);
	}

	// 클라이언트로부터 도착한 메시지를 특정 수신자(Session)에게만 전달한다
	private void sendToOne(String msg, Session ses) {
		try {

			ses.getBasicRemote().sendText(msg);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 클라이언트로부터 도착한 메시지를 모든 접속자에게 전송한다
	private void broadcast(String msg) {

		Set<String> keys = sessionMap.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Session s = sessionMap.get(key);
			try {
				s.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				sessionMap.remove(key);
				try {
					s.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				String message = String.format("* %s %s", key, "has been disconnected.");

				if (sessionMap.get(receiverMem) != null) {
					sendToOne(message, sessionMap.get(receiverMem));
				}
			}
		}
	}

	public String decoder(String s) {
		String result = "";

		try {
			result = URLDecoder.decode(s, "UTF-8");
		} catch (Exception arg3) {
			System.out.println("decoder 에러");
		}

		return result;
	}

	public String getParameter(String queryString, String paramName) {
		ArrayList params = new ArrayList();
		ArrayList result = new ArrayList();
		String paramResult = "";
		StringTokenizer tokens = new StringTokenizer(queryString, "&");

		while (tokens.hasMoreTokens()) {
			params.add(tokens.nextToken());
		}

		int cnt;
		for (cnt = 0; cnt < params.size(); ++cnt) {
			StringTokenizer st = new StringTokenizer((String) params.get(cnt), "=");

			while (st.hasMoreTokens()) {
				result.add(st.nextToken());
			}
		}

		cnt = result.indexOf(paramName);
		paramResult = (String) result.get(cnt + 1);
		return paramResult;
	}

}