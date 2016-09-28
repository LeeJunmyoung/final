package cloud.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.web.multipart.MultipartFile;

public class CloudDao extends SqlSessionDaoSupport{
	
	public List<CloudInfo> getcloudList(int com_num, String folder){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("com_num", com_num);
		param.put("folder", folder);
		List cloudlist = new ArrayList<CloudInfo>();
		cloudlist = getSqlSession().selectList("cloud.getcloudlist", param);
		
		return cloudlist;
	}
	public void uploadFile(MultipartFile uploadfile, String folder, HttpServletRequest request){
		HttpSession session = request.getSession();
		String file_name = uploadfile.getOriginalFilename();
		String file_path = makeFilePath(uploadfile, file_name);
		String file_uploader = (String)session.getAttribute("name");
		String file_Size = String.valueOf(uploadfile.getSize());
		int com_num = (int)session.getAttribute("com_num");
		int mem_num = (int)session.getAttribute("mem_num");
		
		
		
		
	}
	private String makeFilePath(MultipartFile file, String file_name){
		String temp_path = "";
		Long nowtime = System.currentTimeMillis();
		String timepath = String.valueOf(nowtime);
		
		for(int i = 0; i<20; i++){
			int r = (int)(Math.random()*100);
			String str = null;
			if (r<=25){
				str = String.valueOf((char)(int)(Math.random()*10+48));
			}else if(r<=60){
				str = String.valueOf((char)(int)(Math.random()*26+65));
			}else {
				str = String.valueOf((char)(int)(Math.random()*26+97));
			}
			temp_path +=str;
		}
		String file_path = "E:/cloud"+temp_path + timepath + file_name;
		return file_path;
	}
	
}
