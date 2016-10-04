package admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import admin.db.AdminDao;

@Controller
@RequestMapping("/admin_comInsert")
public class Admin_comInsert {

	private AdminDao dao;

	@Autowired
	public void setDao(AdminDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void admincomInsert(@RequestParam int com_num, HttpServletRequest request) {
		int admincomInsert = dao.admincomInsert(com_num);
		admincomInsert = dao.admincomDelete(com_num);
	}
}
