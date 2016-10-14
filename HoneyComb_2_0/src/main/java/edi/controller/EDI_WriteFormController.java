package edi.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EDI_WriteFormController {
	
	@RequestMapping("/writeForm.do")
	public String writeForm(ModelMap map){
		
		String write_date = writeDate();
		map.addAttribute("write_date", write_date);
		
		
		
		
		
		return "EDI_WriteForm";
	}
	
	public String writeDate(){
		Calendar cal = Calendar.getInstance();
		  int year = cal.get(Calendar.YEAR);
	      int mon = cal.get(Calendar.MONTH)+1;
	      int day = cal.get(Calendar.DAY_OF_MONTH);
		
		
		String d = year+"-"+mon+"-"+day;
		
		return d;
	}
	
	
	
}
