package admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import admin.db.adminDao;

@Controller
@RequestMapping("/admin")
public class adminController {
	
	private adminDao dao;
	
	@Autowired
	public void setDao(adminDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String startMethod(){
		return "admin_main";
	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public ModelAndView getadminList(HttpSession session, HttpServletRequest request){
//		int com_num = 0;
//		session = request.getSession();
//		session.setAttribute("com_num", 1);
//		com_num = (int)request.getSession().getAttribute("com_num");
//		List adminlist = dao.getadminList(com_num);
//		ModelAndView mav = new ModelAndView("admin_main","adminlist",adminlist);		
//		return mav;
//	}
	

}
