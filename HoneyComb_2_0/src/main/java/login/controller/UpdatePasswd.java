package login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpdatePasswd {
	
	

	private LoginDAO logindao;

	
		
	public LoginDAO getLogindao() {
		return logindao;
	}

	public void setLogindao(LoginDAO logindao) {
		this.logindao = logindao;
	}

	
		@RequestMapping(method = RequestMethod.POST,value="UpdatePasswd.do")
		public String updatePasswd(@RequestParam("email") String email,@RequestParam("newpasswd") String newpasswd ) {
			
			logindao.updatePasswd(email, newpasswd);
			
			
			return "updatePasswd";
		}
	
	
	
}
