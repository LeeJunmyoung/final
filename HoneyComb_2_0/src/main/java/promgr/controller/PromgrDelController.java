package promgr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import promgr.db.PromgrDao;

@Controller
public class PromgrDelController {

	private PromgrDao dao;

	@Autowired
	public void setDao(PromgrDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/promgrDel.do")
	public String submit(HttpServletRequest request) {

		String promgr_num = request.getParameter("promgr_num");
		int com_num = (int) request.getSession().getAttribute("com_num");
		
		dao.delPromgr(promgr_num, com_num);

		return "redirect:/more.do";
	}

}
