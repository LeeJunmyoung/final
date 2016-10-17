package login.controller;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NaverLoginController {
	@Autowired
	private SignInDAO dao;
	
	public void setDao(SignInDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/login/naverLogIn.do")
	public String NaverLoginCk(String email, String gender, String name){
		int mailCheck = Integer.parseInt(dao.CheckEmail(email));
		if(mailCheck > 0){
			System.out.println("here");
			return "/HoneyComb_2_0/login/logIn.do";
		}
		dao.insertAPI(email, gender, name);
		System.out.println(email);
		System.out.println(gender);
		System.out.println(name);
		System.out.println("success");
		
		
		return "/HoneyComb_2_0/login/logIn.do";
	}

}
