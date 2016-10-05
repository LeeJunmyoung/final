package cloud.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartFile;

import cloud.db.CloudInfo;

public class Cloud_uploadFile {
	public CloudInfo uploadFile(MultipartFile uploadfile, String folder, HttpServletRequest request, int com_pos_num){
		HttpSession session = request.getSession();
		String file_name = uploadfile.getOriginalFilename();
		String file_path = makeFilePath(uploadfile, file_name);
		String file_uploader = (String)session.getAttribute("name");
		String file_size = String.valueOf(uploadfile.getSize());
		int com_num = (int)session.getAttribute("com_num");
		int mem_num = (int)session.getAttribute("mem_num");
		
		CloudInfo info = new CloudInfo();
		info.setFile_name(file_name);
		info.setFile_path(file_path);
		info.setFile_size(file_size);
		info.setCom_num(com_num);
		info.setFolder(folder);
		info.setMem_num(mem_num);
		info.setcom_pos_num(com_pos_num);
		info.setFile_uploader(file_uploader);
		System.out.println("folder::"+folder);
		uploadFile(file_path, uploadfile);
		
		return info;
	}
	//파일경로 만드는 메서드
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
		String file_path = "D:/cloud/"+temp_path + timepath + file_name;
		return file_path;
	}
	//파일 업로드 메서드
	private void uploadFile(String file_path, MultipartFile uploadfile){
		File file = new File(file_path);
		try{
			uploadfile.transferTo(file);
		} catch(IllegalStateException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
}
