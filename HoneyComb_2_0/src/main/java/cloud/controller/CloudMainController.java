package cloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.apache.catalina.core.ApplicationContext;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cloud.db.CloudDao;
import cloud.db.CloudInfo;

@Controller
public class CloudMainController implements ApplicationContextAware{
	/*Download용 ViewResolver 받기*/
	private WebApplicationContext context = null;
	@Override
	public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		
	}
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
	public ModelAndView uploadMain(@RequestParam("uploadfile")MultipartFile uploadfile, HttpServletRequest request, String security){
		int com_pos_num = 0;
		if(security != null){
			com_pos_num = 1;
		}
		CloudInfo info = new Cloud_uploadFile().uploadFile(uploadfile, "", request, com_pos_num);
		dao.uploadFile(info);
		ModelAndView mav = new ModelAndView("/upload","close",true);
		return mav;
	}
		//폴더 내부에서 업로드
	@RequestMapping(value="/upload/{folder}", method = RequestMethod.POST)
	public ModelAndView uploadFolder(@RequestParam("uploadfile")MultipartFile uploadfile, @PathVariable String folder, HttpServletRequest request, String security){
		int com_pos_num = 0;
		if(security != null ){
			com_pos_num = 1;
		}
		CloudInfo info = new Cloud_uploadFile().uploadFile(uploadfile, folder, request, com_pos_num);
		dao.uploadFile(info);
		ModelAndView mav = new ModelAndView("/upload","close",true);
		return mav;
	}
	
	/*프로젝트 업로드 컨트롤러*/
	@RequestMapping(value="/uploadPromgr")
	public void uploadPromgr(String promgrname, int promgrnum){
		
		
	}
	
	/*다운로드 처리*/
	@RequestMapping(value = "/download")
	public ModelAndView downloadFile(String selectedFiles){
		String[] fileNums = selectedFiles.split(",");
		List downloadInfo = dao.getFileInfo(fileNums);
		return new ModelAndView("downloadFiles", "downloadInfo", downloadInfo);
	}
	/*삭제처리*/
	@RequestMapping(value = "/delete")
	public ModelAndView deleteFiles(String selectedFiles){
		ModelAndView mav = null;
		try{
		String[] fileNums = selectedFiles.split(",");
		List deleteInfo = dao.getDeleteList(fileNums);
		mav =  new ModelAndView("/delete", "deleteInfo",deleteInfo);
		} catch (NullPointerException e) {
			mav = new ModelAndView("/delete");
		}		
		return mav;
	}
	@RequestMapping(value="/deletePro")
	public String deletePro(int[] file_num){
		dao.DeleteFiles(file_num);
		return"redirect:delete";
	}
	/*폴더 만들기*/
	@RequestMapping(value = "/makeFolder/{folder}")
	public ModelAndView makeFilder(@PathVariable String folder){
		ModelAndView mav =  new ModelAndView("/makeFolder");
		return mav;
	}
	@RequestMapping(value = "/makeFolder")
	public ModelAndView makeFilder(){
		ModelAndView mav =  new ModelAndView("/makeFolder");
		return mav;
	}


	
}
