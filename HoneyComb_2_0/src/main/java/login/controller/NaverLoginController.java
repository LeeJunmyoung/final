package login.controller;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.stereotype.Controller;

@Controller
public class NaverLoginController {
	private LoginDAO logindao;

	public void setLogindao(LoginDAO logindao) {
		this.logindao = logindao;
	}



}
