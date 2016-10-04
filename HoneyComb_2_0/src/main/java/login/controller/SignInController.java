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
	@RequestMapping(value = "/EmailCheck.do", method= RequestMethod.POST)
	public @ResponseBody Map<String, Integer> appidcheck(HttpServletResponse response, 
	@RequestParam("email") String email) {

	response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	response.setHeader("Access-Control-Max-Age", "3600");
	response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
	response.setHeader("Access-Control-Allow-Origin", "*");

	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");

	String retid = dao.getCheckUserId(email);
	  
	Map<String, Integer> map = new HashMap<String, Integer>();
	  
	map.put("ret", 1);
	if(retid != null){
	 if(retid.equals(email)){
	 map.put("ret", 0);
	 }
	}
	 
	return map;
	 }
	


	

	/*@RequestMapping(value = "/chkDupId.do")
	 public void checkId(HttpServletRequest req, HttpServletResponse res,
	   ModelMap model) throws Exception {
	  PrintWriter out = res.getWriter();
	  try {

	   // 넘어온 ID를 받는다.
	   String paramId = (req.getParameter("prmId") == null) ? "" : String
	     .valueOf(req.getParameter("prmId"));

	   LogOnDataBean logdb = new LogOnDataBean();
	   logdb.setEmail(paramId.trim());
	   int chkPoint = SignInService.chkDupId(logdb);

	   out.print(chkPoint);
	   out.flush();
	   out.close();
	  } catch (Exception e) {
	   e.printStackTrace();
	   out.print("1");
	  }
	 }*/
	
	
		
	}
		/*@RequestMapping(method = RequestMethod.GET)
		public String form() {
			return "signIn";
		}

		@RequestMapping(method = RequestMethod.POST)
		public String submit() {
			
			
				return "signIn";*/						
		

	
	
	
