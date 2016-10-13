package login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String submit(@RequestParam("email") String email, @RequestParam("passwd") String passwd,
			HttpServletRequest request) {

		LogOnDataBean lodb = new LogOnDataBean();
		lodb = logindao.Checkmembers(email, passwd);
		if (lodb == null) {

			return "logInpro";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("mem_num", lodb.getMem_num());
			session.setAttribute("com_num", lodb.getCom_num());
			session.setAttribute("com_dept_num", lodb.getCom_dept_num());
			session.setAttribute("com_pos_num", lodb.getCom_pos_num());
			session.setAttribute("name", lodb.getName());
			session.setAttribute("phone_num", lodb.getPhone_num());
			session.setAttribute("email", email);
			session.setAttribute("profile_img", lodb.getProfile_img());

			return "comCheck";

		}

	}

}
