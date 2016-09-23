package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;

@Controller
@RequestMapping("/main/main")
public class MainController {

	private LocaleResolver localeResolver;

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "main";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit() {
		return "main";
	}

	public void setLocaleResolver(LocaleResolver localeResolver) {
		this.localeResolver = localeResolver;
	}

}
