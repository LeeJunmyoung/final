package admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import admin.db.AdminDao;
import admin.db.AdminNoticeInfo;

@Controller
@RequestMapping("/admin_notice")
public class Admin_notice {
	
	private AdminDao dao;
	
	@Autowired
	public void setDao(AdminDao dao) {
		this.dao = dao;
		
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView submit(HttpServletRequest request) {
		int notice_admin_num = 1;
		notice_admin_num = (int) request.getSession().getAttribute("notice_admin_num");
		List<AdminNoticeInfo> noticelist = dao.getadminNotice(notice_admin_num);
		ModelAndView mav = new ModelAndView("admin_notice","noticelist",noticelist);
		return mav;
	}
}
