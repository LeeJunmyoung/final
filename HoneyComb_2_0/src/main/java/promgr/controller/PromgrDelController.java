package promgr.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import promgr.db.PromgrDao;
import promgr.db.PromgrDataBean;

@Controller
public class PromgrDelController {

	private PromgrDao dao;

	@Autowired
	public void setDao(PromgrDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/del.do")
	public String submit(HttpServletRequest request) {

		String promgr_num = request.getParameter("promgr_num");
		int com_num = (int) request.getSession().getAttribute("com_num");

		dao.delchkItem(promgr_num);
		dao.delchkList(promgr_num);
		dao.delFile(promgr_num);
		dao.delComment(promgr_num, com_num);
		dao.delPromgr(promgr_num, com_num);

		return "redirect:/more.do";
	}

}
