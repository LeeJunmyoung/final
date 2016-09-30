package cloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.apache.catalina.core.ApplicationContext;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cloud.db.CloudDao;
import cloud.db.CloudInfo;

@Controller
public class CloudMainController {
	// session 받기
	private CloudDao dao;

	@Autowired
	public void setDao(CloudDao dao) {
		this.dao = dao;
	}

	// 클라우드 메인리스트
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public ModelAndView getCloudList(HttpSession session, HttpServletRequest request, String folder) {
		session = request.getSession();
/*		 session 임시설정 
		System.out.println("test용com_num설정::1");
		session.setAttribute("com_num", 1);
		session.setAttribute("com_pos_num", 1);
		session.setAttribute("name", "tester");
		session.setAttribute("mem_num", 1);
		 session임시설정끝 */

		int com_num = (int) request.getSession().getAttribute("com_num");
		List cloudlist = dao.getcloudList(com_num, folder);
		ModelAndView mav = new ModelAndView("cloud_main", "cloudlist", cloudlist);
		return mav;
	}
	/*----업로드폼으로 접근 RESTFul 사용------------*/
		//메인에서 업로드폼 연결
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String goUploadMain(){
		return("/upload");
	}
		//폴더내부에서 업로드폼 연결
	@RequestMapping(value = "/upload/{folder}", method = RequestMethod.GET)
	public String goUploadFolder(@PathVariable String folder) {
		return "/upload";
	}

		//메인에서 업로드
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public String uploadMain(@RequestParam("uploadfile")MultipartFile uploadfile, HttpServletRequest request, String security){
		int com_pos_num = 0;
		if(security != null){
			com_pos_num = 1;
		}
		CloudInfo info = new Cloud_uploadFile().uploadFile(uploadfile, "", request, com_pos_num);
		dao.uploadFile(info);
		return "/upload";
	}
		//폴더 내부에서 업로드
	@RequestMapping(value="/upload/{folder}", method = RequestMethod.POST)
	public String uploadFolder(@RequestParam("uploadfile")MultipartFile uploadfile, @PathVariable String folder, HttpServletRequest request, String security){
		int com_pos_num = 0;
		if(security != null ){
			com_pos_num = 1;
		}
		CloudInfo info = new Cloud_uploadFile().uploadFile(uploadfile, folder, request, com_pos_num);
		dao.uploadFile(info);
		return "/upload";
	}
	
	/*프로젝트 업로드 컨트롤러*/
	@RequestMapping(value="/uploadPromgr")
	public void uploadPromgr(String promgrname, int promgrnum){
		
		
	}
	
	/*다운로드 처리*/
	@RequestMapping(value = "/download")
	public String downloadFile(int[] selectedFiles){
		System.out.println(selectedFiles[0]);
		String filePathes[] = null;
		System.out.println("selectedFiles.length:"+selectedFiles.length);
		for(int i = 0; i < selectedFiles.length; i++){
			int file_num = selectedFiles[i];
			 String tempPath = dao.getFilePath(file_num);
			 System.out.println(tempPath);
			 filePathes[i] = tempPath;
			System.out.println("last::"+filePathes[i]);
		}
		
		return "redirect:/cloud/main";
	}
	
}
