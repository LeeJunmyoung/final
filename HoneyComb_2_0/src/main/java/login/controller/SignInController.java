package login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;




@Controller
@RequestMapping("/signIn.do")
public class SignInController {


	private LocaleResolver localeResolver;
	// @RequestMapping 메서드의 리턴 타입이 String => return값을 viewname으로 사용
		@RequestMapping(method = RequestMethod.GET)
		public String form() {
			return "signIn";
		}

		@RequestMapping(method = RequestMethod.POST)
		public String submit() {
				return "signIn";
		}

	public void setLocaleResolver(LocaleResolver localeResolver) {
		this.localeResolver = localeResolver;
	}
	
	
	
}
