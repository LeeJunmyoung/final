package edi.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edi.db.EDI_DAO;
import edi.db.EDI_DateBean;

@Controller
public class EDI_WriteFormController {

	private EDI_DAO dao;
	
	
	public void setDao(EDI_DAO dao) {
		this.dao = dao;
	}

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
			@RequestParam String send_dept_name,@RequestParam("document_num") String document_num,HttpServletRequest request) {
		
		EDI_DateBean edb = new EDI_DateBean();
		int com_num = (int) request.getSession().getAttribute("com_num");
		String attachfileDBPath="";
		if(attachfile!=null){
			attachfileDBPath = ref_File_Save(request,attachfile); // 파일 저장
		}
		edb.setCom_num(com_num);
		edb.setAttechFile(attachfileDBPath);
		edb.setEDI_Subject(edi_subject);
		textarea_edi=textarea_edi.replace("\r\n","<br>");
		edb.setEDI_TextArea(textarea_edi);
		edb.setMid_mem_num(mid_mem_num);
		edb.setFin_mem_num(fin_mem_num);
		edb.setSend_dept_name(send_dept_name);
		edb.setDocument_num(document_num);
		edb.setDraftDate(writeDate());
		dao.insertNewEDI(edb);
		
		
		

		return "EDI/EDI_main";
	}

	public String writeDate() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int mon = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);

		String d = year + "-" + mon + "-" + day;

		return d;
	}
	public String ref_File_Save(HttpServletRequest request,MultipartFile attachfile){
		String savepath = request.getSession().getServletContext().getRealPath("attachfile");
		Date d = new Date();
		String add_date = String.valueOf(d.getTime());
		String file_name = attachfile.getOriginalFilename();
		String convert_File_Name = add_date + file_name;
		File file = new File(savepath + "\\" + convert_File_Name);
		String DBpath = "/HoneyComb_2_0/attachfile/" + convert_File_Name;
		try {
			attachfile.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DBpath;
		
		
	}

}
