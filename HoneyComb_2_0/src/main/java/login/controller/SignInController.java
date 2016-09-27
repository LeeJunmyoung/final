package login.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignInController {
	
	private static final Logger log = LoggerFactory.getLogger(SignInController.class);
	
	@Autowired
	SignInDAO dao;
	
	public void setDao(SignInDAO dao) {
		this.dao = dao;
	}
	@RequestMapping("/signIn.do")//signIn 폼으로 가는 메소드 
	public String signInForm(){
		
		return "signIn";
	}
	@RequestMapping("/members.do")//DB에 insert하는 메소드
	public ModelAndView members(LogOnDataBean logdb,HttpSession session){
		
		ModelAndView mav= new ModelAndView();
		
		return mav;
	}
	/*@RequestMapping("/overlaptest.do")//email 중복확인 하는 메소드
	@ResponseBody
	public String overlapTest(String email){
		
		String checkEmail = dao.overlapTest(email);
		return checkEmail;
	}*/
		/*@RequestMapping(method = RequestMethod.GET)
		public String form() {
			return "signIn";
		}

		@RequestMapping(method = RequestMethod.POST)
		public String submit() {
			
			
				return "signIn";*/						
		}

	
	
	
