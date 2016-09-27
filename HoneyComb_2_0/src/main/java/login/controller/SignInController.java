package login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;




@Controller
@RequestMapping("/signIn.do")
public class SignInController {



		@RequestMapping(method = RequestMethod.GET)
		public String form() {
			return "signIn";
		}

		@RequestMapping(method = RequestMethod.POST)
		public String submit() {
			
			
				return "signIn";
				
				
				
		}

	
	
	
}
