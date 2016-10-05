package login.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignInController  {
	
	private static final Logger log = LoggerFactory.getLogger(SignInController.class);
	
	@Autowired
	SignInDAO dao = new SignInDAO(); 
	
	public void setDao(SignInDAO dao) {
		this.dao = dao;
	}
	@RequestMapping("/signIn.do")//signIn 폼으로 가는 메소드 
	public String signInForm(){
		
		return "signIn";
	}
	@RequestMapping(value="members.do")//DB에 insert하는 메소드
	public ModelAndView members(/*@RequestParam(value="valueArrTest[]")List<String> valueArr, */LogOnDataBean logdb, HttpSession session, HttpServletResponse response) throws Exception{
		System.out.println("실행");
		ModelAndView mav = new ModelAndView();
		System.out.println("insert");
		dao.insertMember(logdb);
		mav.setViewName("redirect:/login/success.do");
		System.out.println("끝");
		
		return mav;
	}
	
	@RequestMapping("/success.do")//회원가입 완료페이지
	public String success(){
		
		return "success";
	}
	@RequestMapping(value = "/checkEmail.do", method= RequestMethod.POST)
	@ResponseBody
	public String mailCheck(HttpServletRequest request,HttpServletResponse response){
		
		String email = request.getParameter("email");
		
		String db = dao.CheckEmail(email);
		
		return "checkEmail_"+db+".do";
	}

	@RequestMapping("mailCheck.do")
	@ResponseBody
	public String CheckEmail(String email){
		
		String chkMail = dao.CheckEmail(email);
		
		return chkMail;
	}
	
}
							
		

	
	
	
