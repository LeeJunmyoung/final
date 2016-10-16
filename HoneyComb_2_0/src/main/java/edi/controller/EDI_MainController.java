package edi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import edi.db.EDI_DAO;

@Controller
public class EDI_MainController {

	
	private EDI_DAO dao;
	
	
	
	public void setDao(EDI_DAO dao) {
		this.dao = dao;
	}



	@RequestMapping("/EDI_Main.do")
	public String maintogo(HttpServletRequest request,ModelMap map){
		
		
		
		return "EDI/EDI_main";
	}
	
	
	
	
	
}
