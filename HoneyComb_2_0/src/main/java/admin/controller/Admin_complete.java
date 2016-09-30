package admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import admin.db.AdminDao;
import admin.db.AdminInfo;

@Controller
@RequestMapping("/admin_complete")
public class Admin_complete {

	private AdminDao dao;

	@Autowired
	public void setDao(AdminDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getadmincomplete(HttpSession session, HttpServletRequest request) {
		List<AdminInfo> admincomplete = dao.adminComplete();
		ModelAndView mav = new ModelAndView("admin_main_page", "admincomplete", admincomplete);
		mav.setViewName("admin_complete");
		mav.addObject("admin_complete", admincomplete);
		return mav;
	}
}
