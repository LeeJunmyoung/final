package admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	

}
