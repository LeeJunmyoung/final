package admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.validator.ValidateWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.ServletContextLiveBeansView;
import org.springframework.web.servlet.ModelAndView;

import admin.db.AdminDao;

@Controller
@RequestMapping("/admin_comSelect")
public class Admin_comSelect {

	private AdminDao dao;

	@Autowired
	public void setDao(AdminDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getadminList(HttpSession session, HttpServletRequest request) {
		System.out.println("실행중");
		int com_num = 1;
		session = request.getSession();
		session.setAttribute("com_num", 1);
		com_num = (int) request.getSession().getAttribute("com_num");

		List adminlist = dao.getadminList(com_num);

		ModelAndView mav = new ModelAndView("admin_main", "adminlist", adminlist);

		System.out.println(mav.getViewName());
		mav.setViewName("admin_comSelect");
		mav.addObject("admin_comSelect", adminlist);

		System.out.println(mav.getViewName());
		return mav;
	}
}