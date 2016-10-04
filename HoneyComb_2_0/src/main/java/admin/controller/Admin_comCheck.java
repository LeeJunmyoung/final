package admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import admin.db.AdminDao;
import admin.db.AdminInfo;

@Controller
@RequestMapping("/admin_comCheck")
public class Admin_comCheck {

	private AdminDao dao;

	@Autowired
	public void setDao(AdminDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getadminList(@RequestParam int com_num, HttpServletRequest request) {
		List<AdminInfo> adminlist = dao.comadminList(com_num);
		ModelAndView mav = new ModelAndView("admin_comCheck", "adminlist", adminlist);
		return mav;
	}

}
