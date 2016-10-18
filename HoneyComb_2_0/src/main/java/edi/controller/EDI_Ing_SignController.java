package edi.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edi.db.EDI_DAO;

@Controller
public class EDI_Ing_SignController {

	private EDI_DAO dao;
	
	
	public void setDao(EDI_DAO dao) {
		this.dao = dao;
	}


	@RequestMapping("/midsign.do")
	public String EDI_Ing_Sign_Mid(@RequestParam int EDI_num){
		
		dao.sign_Mid(EDI_num,signDate());
		
		
		
		return "writer_close";
	}
	@RequestMapping("/finsign.do")
	public String EDI_Ing_Sign_fin(@RequestParam int EDI_num){
		
		dao.sign_fin(EDI_num,signDate(),endDate());
		
		
		
		return "writer_close";
	}
	
	public String signDate(){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int mon = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int mm = cal.get(Calendar.MINUTE);
		if(mm<10){
			String dd = year + "-" + mon + "-" + day+" "+hour+":0"+mm ;
			return dd;
		}
		
		String d = year + "-" + mon + "-" + day+" "+hour+":"+mm ;
		return d;
		
	}
	public String endDate() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int mon = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);

		String d = year + "-" + mon + "-" + day;

		return d;
	}
	
	
	
	
	
}
