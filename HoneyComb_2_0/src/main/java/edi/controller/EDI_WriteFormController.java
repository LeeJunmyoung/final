package edi.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class EDI_WriteFormController {

	@RequestMapping(value = "/writeForm.do", method = RequestMethod.GET)
	public String writeForm(ModelMap map) {

		String write_date = writeDate();
		map.addAttribute("write_date", write_date);

		return "EDI_WriteForm";
	}

	@RequestMapping(value = "/writeEDI.do", method = RequestMethod.POST)
	public String writeForm(
			@RequestParam("attachfile") MultipartFile attachfile, @RequestParam String edi_subject,
			@RequestParam String textarea_edi, @RequestParam int mid_mem_num, @RequestParam int fin_mem_num,
			@RequestParam String send_dept_name,@RequestParam("document_num") String document_num) {

		textarea_edi=textarea_edi.replace("\r\n","<br>");
		
		
		

		return "EDI_WriteForm";
	}

	public String writeDate() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int mon = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);

		String d = year + "-" + mon + "-" + day;

		return d;
	}

}
