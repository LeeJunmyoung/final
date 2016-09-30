package cal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cal_main.do")
public class CalMainController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String calMain(){
		
		System.out.println("cal main 실행잼");
		

		return "cal_main";	
	}

}
