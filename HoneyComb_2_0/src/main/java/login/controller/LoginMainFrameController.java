
package login.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;



@Controller
@RequestMapping("/LoginMainFrame.do")
public class LoginMainFrameController {


	// @RequestMapping 메서드의 리턴 타입이 String => return값을 viewname으로 사용
		@RequestMapping(method = RequestMethod.GET)
		public String form() {
			return "mainPage";
		}

		@RequestMapping(method = RequestMethod.POST)
		public String submit() {
				return "mainPage";
		}



}
