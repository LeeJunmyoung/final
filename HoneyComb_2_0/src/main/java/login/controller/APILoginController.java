package login.controller;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class APILoginController {
	@Autowired
	private SignInDAO dao;
	
	private LoginDAO logindao;
	public void setDao(SignInDAO dao) {
		this.dao = dao;
	}
	@Autowired
	public void setLogindao(LoginDAO logindao) {
		this.logindao = logindao;
	}


	@RequestMapping("/login/apiLogIn.do")
	public String NaverLoginCk(String email, String gender, String name, HttpServletRequest request){
		int mailCheck = Integer.parseInt(dao.CheckEmail(email));
		if(mailCheck > 0){
			LogOnDataBean lodb = logindao.getUserInfo(email);
			setInfoSession(lodb, request, email);
			
			return "redirect: /HoneyComb_2_0/login/Comcheck.do";
		}
		dao.insertAPI(email, gender, name);
		System.out.println(email);
		System.out.println(gender);
		System.out.println(name);
		System.out.println("success");
		
		
		return "redirect: /HoneyComb_2_0/login/logIn.do";
	}
	
	private void setInfoSession(LogOnDataBean lodb, HttpServletRequest request, String email){
		HttpSession session = request.getSession();
		session.setAttribute("mem_num", lodb.getMem_num());
		session.setAttribute("com_num", lodb.getCom_num());
		session.setAttribute("com_dept_num", lodb.getCom_dept_num());
		session.setAttribute("com_pos_num", lodb.getCom_pos_num());
		session.setAttribute("name", lodb.getName());
		session.setAttribute("phone_num", lodb.getPhone_num());
		session.setAttribute("email", email);
		session.setAttribute("profile_img", lodb.getProfile_img());
		
	}

}
