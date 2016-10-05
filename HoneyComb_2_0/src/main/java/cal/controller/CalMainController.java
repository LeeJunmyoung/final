package cal.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cal.db.Cal_DAO;

@Controller
@RequestMapping("/cal_main.do")
public class CalMainController {
	
	private Cal_DAO dao;
	
	
	
	public void setDao(Cal_DAO dao) {
		this.dao = dao;
	}



	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView calMain(HttpServletRequest request){
		
		int mem_num =(int) request.getSession().getAttribute("mem_num");
		
		ModelAndView mav = new ModelAndView("cal_more");
		
		List totalCal =  dao.viewCal(mem_num);
		
		mav.addObject("totalCal", totalCal);
		mav.addObject("cal_count",totalCal.size());
		
		
		return mav;	
	}

}
