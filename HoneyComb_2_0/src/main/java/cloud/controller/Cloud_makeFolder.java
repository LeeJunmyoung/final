package cloud.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cloud.db.CloudInfo;

public class Cloud_makeFolder {
	public CloudInfo uploadFolder(HttpServletRequest request, String item, String folder, int promgr_num){
		CloudInfo info = new CloudInfo();
		HttpSession session =  request.getSession();
		int com_num = (int)session.getAttribute("com_num");
		int mem_num = (int)session.getAttribute("mem_num");
		String file_uploader = (String)session.getAttribute("name");
		String file_name =  item;
		String file_path = makeFolderPath(com_num);
		
		info.setCom_num(com_num);
		info.setcom_pos_num(0);
		info.setFile_name(file_name);
		info.setFile_path(file_path);
		info.setFile_size("0");
		info.setFile_uploader(file_uploader);
		info.setFolder(folder);
		info.setMem_num(mem_num);
		info.setPromgr_num(promgr_num);
		
		return info;		
	}
//파일경로 지정
	private String makeFolderPath(int com_num){
		String path = null;
		path = "%"+String.valueOf(com_num);
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
			path +=str;
		}	
		return path;
	}
}
