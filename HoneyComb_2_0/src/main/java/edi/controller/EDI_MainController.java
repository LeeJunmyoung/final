package edi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EDI_MainController {

	
	@RequestMapping("/EDI_Main.do")
	public String maintogo(){
		
		
		
		
		
		return "EDI/EDI_main";
	}
	
	
	
	
	
}
