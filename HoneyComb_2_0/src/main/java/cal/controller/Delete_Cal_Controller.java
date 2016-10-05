package cal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cal.db.Cal_DAO;

@Controller
public class Delete_Cal_Controller {

	
	private Cal_DAO dao;
	
	
	
	public void setDao(Cal_DAO dao) {
		this.dao = dao;
	}



	@RequestMapping("del_cal.do")
	public String deleteCal(@RequestParam int num){
		
		dao.delCal(num);
		
		
		
		
		
		return "CloseFrame";
	}
	
}
