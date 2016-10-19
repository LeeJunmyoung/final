package cal.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cal.db.Cal_DAO;
import cal.db.Cal_DataBean;

@Controller
public class Insert_Cal_Controller {

	
	private Cal_DAO dao;
	
	
	
	
	public void setDao(Cal_DAO dao) {
		this.dao = dao;
	}




	@RequestMapping("/cal_insert.do")
	public String insert_Cal(@RequestParam String title
			,@RequestParam String startDate,@RequestParam String endDate,
			@RequestParam String contents,@RequestParam("category") int category,HttpServletRequest request){
		
		Cal_DataBean calbean = new Cal_DataBean();
		
		int mem_num = (int) request.getSession().getAttribute("mem_num");
		int com_num = (int) request.getSession().getAttribute("com_num");
		int dept_num = (int) request.getSession().getAttribute("com_dept_num");
		contents=contents.replace("\r\n","<br>");
		
		calbean.setCal_subject(title);
		calbean.setCal_contents(contents);
		calbean.setCom_num(com_num);
		calbean.setCom_dept_num(dept_num);
		calbean.setCategory(category);
		calbean.setMem_num(mem_num);
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			
			
			
			Date date = format.parse(startDate);
			calbean.setCal_start(date);
			
			
			
			date= format.parse(endDate);
			calbean.setCal_end(date);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		

		
		
		dao.insertCal(calbean);
		
		
		
		
		
		
		
		return "init";
	}
	
	
	
	
}
