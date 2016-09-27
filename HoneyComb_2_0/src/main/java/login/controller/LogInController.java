package login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;



@Controller
@RequestMapping("/logIn.do")
public class LogInController {

	private LoginDAO logindao;
	
	
	
	
	public void setLogindao(LoginDAO logindao) {
		this.logindao = logindao;
	}

		// @RequestMapping 메서드의 리턴 타입이 String => return값을 viewname으로 사용
		@RequestMapping(method = RequestMethod.GET)
		public String form() {
			return "logIn";
		}

		@RequestMapping(method = RequestMethod.POST)
		public String submit(@RequestParam("email") String email,@RequestParam("passwd") String passwd) {
			
			System.out.println("email:::"+email+"passwd:::"+passwd);
			
			
			
			LogOnDataBean lodb = new LogOnDataBean(); 
			lodb= logindao.Checkmembers(email, passwd);
			if(lodb==null){
			System.out.println("실행함");	
				return "logInpro";
			}
			
			
			
			
				return "logIn";
		}

	
	
}
