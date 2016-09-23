package notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;

@Controller
@RequestMapping("/more")
public class NoticeMoreController {

	private LocaleResolver localeResolver;

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "notice_more";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit() {
		return "notice_more";
	}

	public void setLocaleResolver(LocaleResolver localeResolver) {
		this.localeResolver = localeResolver;
	}

}
