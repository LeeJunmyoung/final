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
import login.controller.LogOnDataBean;

@Controller
@RequestMapping("/admin_comSearch")
public class Admin_comSearch {

	private AdminDao dao;

	@Autowired
	public void setDao(AdminDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getadminList(@RequestParam int com_num, HttpServletRequest request) {
		List<LogOnDataBean> memlist = dao.memadminList(com_num);
		ModelAndView mav = new ModelAndView("admin_comSearch", "memlist", memlist);
		System.out.println("mav ::: "+mav);
//		mav.setViewName("admin_comSearch");
//		mav.adObject("admin_comSearch", memlist);
		return mav;
	}
}