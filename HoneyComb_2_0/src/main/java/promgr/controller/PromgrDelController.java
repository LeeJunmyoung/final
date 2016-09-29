package promgr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import promgr.db.PromgrDao;

@Controller
public class PromgrDelController {

	private PromgrDao dao;

	@Autowired
	public void setDao(PromgrDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/promgrDel.do")
	public ModelAndView submit(HttpServletRequest request) {

		String promgr_num = request.getParameter("promgr_num");
		int com_num = (int) request.getSession().getAttribute("com_num");

		int promgr_update_count = dao.delPromgr(promgr_num, com_num);

		ModelAndView mav = new ModelAndView("pro");
		mav.addObject("promgr_update_count", promgr_update_count);

		return mav;

	}

}
