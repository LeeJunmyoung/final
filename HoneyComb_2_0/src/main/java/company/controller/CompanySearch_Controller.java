package company.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import company.db.CompanyDAO;

@Controller
public class CompanySearch_Controller {

	private CompanyDAO dao;

	public void setDao(CompanyDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/com_searchForm")
	public String search_View() {
		return "companyCheck";
	}

	@RequestMapping("/company_search")
	public ModelAndView search_Com(@RequestParam String com_name) {
		// 검색창에 회사명 입력시 실행

		List search_list = dao.searchCom(com_name);

		ModelAndView mav = new ModelAndView("companyCheck", "search_list", search_list);

		return mav;

	}

}
