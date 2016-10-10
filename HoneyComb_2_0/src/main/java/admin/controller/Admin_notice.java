package admin.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView adminNoticePost(@RequestParam int notice_admin_num, HttpServletRequest request) {
		System.out.println("post 실행중");
		AdminNoticeInfo admininfo = new AdminNoticeInfo();
		admininfo.setNotice_admin_title(request.getParameter("notice_admin_title"));
		admininfo.setNotice_admin_content(request.getParameter("notice_admin_content"));
		admininfo.setNotice_admin_date(new Timestamp(System.currentTimeMillis()));
		int noticelist = dao.adminNoticeInsert(admininfo);
		List<AdminNoticeInfo> adminNotice = dao.getadminNotice(notice_admin_num);
		ModelAndView mav = new ModelAndView("admin_notice", "noticelist", adminNotice);
		return mav;
	}
}
