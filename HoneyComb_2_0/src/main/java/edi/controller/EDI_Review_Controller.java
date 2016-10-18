package edi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edi.db.EDI_DAO;
import edi.db.EDI_DateBean;

@Controller
public class EDI_Review_Controller {

	private EDI_DAO dao;
	
	
	public void setDao(EDI_DAO dao) {
		this.dao = dao;
	}


	@RequestMapping("/EDI_review_form.do")
	public String EDI_Review(@RequestParam("EDI_num") int EDI_num,ModelMap map){
		
		
		EDI_DateBean getEDIonlyOne = dao.getEDIonlyOne(EDI_num);
		
		
		
		map.addAttribute("edi_info", getEDIonlyOne);
		
	
		
		
		return "EDI_review_form";
	}
	
}
