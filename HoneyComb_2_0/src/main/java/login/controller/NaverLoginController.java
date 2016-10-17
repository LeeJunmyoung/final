package login.controller;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.stereotype.Controller;

@Controller
public class NaverLoginController {

	public String generateState()
	{
	    SecureRandom random = new SecureRandom();
	    return new BigInteger(130, random).toString(32);
	}

	// 상태 토큰으로 사용할 랜덤 문자열 생성
	String state = generateState();
	// 세션 또는 별도의 저장 공간에 상태 토큰을 저장
/*	request.session().attribute("state", state);
	return state;*/


}
