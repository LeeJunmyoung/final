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
@RequestMapping("/admin_noticePopup")
public class Admin_noticePopup {

	private AdminDao dao;

	@Autowired
	public void setDao(AdminDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView adminNoticePost(HttpServletRequest request) {
		List<AdminNoticeInfo> adminNotice = dao.getadminNotice();
		ModelAndView mav = new ModelAndView("admin_noticePopup", "noticelist", adminNotice);
		return mav;
	}

}
