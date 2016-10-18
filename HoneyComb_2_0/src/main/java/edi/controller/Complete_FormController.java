package edi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edi.db.EDI_DAO;
import edi.db.EDI_DateBean;

@Controller
public class Complete_FormController {
	
	private EDI_DAO dao;
	
	
	public void setDao(EDI_DAO dao) {
		this.dao = dao;
	}


	@RequestMapping("/EDI_complete_form.do")
	public String viewCompleteForm(@RequestParam int EDI_num,ModelMap map){
		EDI_DateBean getEDIonlyOne = dao.getEDIonlyOne(EDI_num);
		map.addAttribute("edi_info", getEDIonlyOne);
		
		return "complete_form";
	}
	
	
	
	

}
