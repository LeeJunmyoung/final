package admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView adminNoticePost(@ModelAttribute AdminDao dao, HttpServletRequest request) {
		int notice_admin_num = (int) request.getSession().getAttribute("notice_admin_num");
		String notice_admin_title = (String) request.getSession().getAttribute("notice_admin_title");
		String notice_admin_content = (String) request.getSession().getAttribute("notice_admin_content");
		int noticelist = dao.adminNoticeInsert(notice_admin_num);
		ModelAndView mav = new ModelAndView("admin_notice", "noticelist", noticelist);
		return mav;
	}
}
