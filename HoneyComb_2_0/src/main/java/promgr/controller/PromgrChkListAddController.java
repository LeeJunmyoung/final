package promgr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import promgr.db.ChkListDataBean;
import promgr.db.PromgrDao;

@Controller
public class PromgrChkListAddController {

	private PromgrDao dao;

	@Autowired
	public void setDao(PromgrDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/chkListAddForm.do")
	public ModelAndView form(@RequestParam(value = "promgr_num") String promgr_num) {

		ModelAndView mav = new ModelAndView("chkListAddForm");
		mav.addObject("promgr_num", promgr_num);

		return mav;

	}

	@RequestMapping("/chkListAddPro.do")
	public String submit(HttpServletRequest request) {

		ChkListDataBean article = new ChkListDataBean();

		article.setChklist_title_name(String.valueOf(request.getParameter("promgr_list_title")));
		article.setPromgr_num(Integer.parseInt(request.getParameter("promgr_num")));
		article.setCom_num((int) request.getSession().getAttribute("com_num"));

		dao.addChkList(article);

		return "redirect:/more.do";
	}

}
