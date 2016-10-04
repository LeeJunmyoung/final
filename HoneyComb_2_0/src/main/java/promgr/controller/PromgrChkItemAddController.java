package promgr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import promgr.db.ChkItemDataBean;
import promgr.db.PromgrDao;

@Controller
public class PromgrChkItemAddController {

	private PromgrDao dao;

	@Autowired
	public void setDao(PromgrDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/chkItemAddForm.do")
	public ModelAndView form(@RequestParam(value = "promgr_num") String promgr_num,
			@RequestParam(value = "list_num") int list_num) {

		ModelAndView mav = new ModelAndView("chkItemAddForm");
		mav.addObject("promgr_num", promgr_num);
		mav.addObject("list_num", list_num);

		return mav;

	}

	@RequestMapping("/chkItemAddPro.do")
	public ModelAndView submit(HttpServletRequest request) {

		ChkItemDataBean article = new ChkItemDataBean();

		article.setChklist_item_name(String.valueOf(request.getParameter("promgr_list_item")));
		article.setPromgr_num(Integer.parseInt(request.getParameter("promgr_num")));
		article.setCom_num((int) request.getSession().getAttribute("com_num"));
		article.setChklist_title_num(Integer.parseInt(request.getParameter("list_num")));

		int promgr_insert_count = dao.addChkItem(article);

		ModelAndView mav = new ModelAndView("pro");
		mav.addObject("promgr_insert_count", promgr_insert_count);

		return mav;
		
	}

}
