package cal.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cal.db.Cal_DAO;
import cal.db.Cal_DataBean;



@Controller
@RequestMapping("/curd_cal_page")
public class Curd_cal_pageController {
	

	private Cal_DAO dao;
	
	
	
	
	
	public void setDao(Cal_DAO dao) {
		this.dao = dao;
	}



	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modify(@RequestParam String num,@RequestParam String subject
			,@RequestParam String start,@RequestParam String end,
			@RequestParam String contents){

		System.out.println("num::::"+num);
		System.out.println("subject::::"+subject);
		System.out.println("start::::"+start);
		System.out.println("end::::"+end);
		System.out.println("contents::::"+contents);
	
		
		Cal_DataBean cdb = new Cal_DataBean();
		cdb.setCal_num(new Integer(num));
		cdb.setCal_subject(subject);
		cdb.setCal_contents(contents);
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date start_date = transFormat.parse(start);
			cdb.setCal_start(start_date);
			start_date = transFormat.parse(end);
			cdb.setCal_end(start_date);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	
		dao.cal_modify(cdb);
		

		
		
		
		

		return "CloseFrame";	
	}
	
	
	
	@RequestMapping(value="/getpage",method=RequestMethod.GET)
	public String curd_cal_page(@RequestParam int cal_num,@RequestParam String cal_subject
			,@RequestParam String cal_start,@RequestParam String cal_end,
			@RequestParam String cal_contents,ModelMap map){
		
		
		System.out.println("실행");
		
		if(map.isEmpty()){
		
		map.addAttribute("cal_num", cal_num);
		map.addAttribute("cal_subject", cal_subject);
		map.addAttribute("cal_start",cal_start);
		map.addAttribute("cal_end", cal_end);
		map.addAttribute("cal_contents", cal_contents);
		}
		
		
		

		return "main_curd_cal_page";	
	}
	
	
	
	
	
	
	
}
