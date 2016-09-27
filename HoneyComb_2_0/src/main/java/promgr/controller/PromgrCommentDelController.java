package promgr.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import promgr.db.PromgrDao;
import promgr.db.PromgrDataBean;

@Controller
public class PromgrCommentDelController {

	private PromgrDao dao;

	@Autowired
	public void setDao(PromgrDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/commentDelPro.do")
	public String submit(@RequestParam("promgr_num") int promgr_num, @RequestParam("comment_num") int comment_num) {

		dao.delComment(promgr_num, comment_num);

		return "redirect:/more.do";
	}

}
