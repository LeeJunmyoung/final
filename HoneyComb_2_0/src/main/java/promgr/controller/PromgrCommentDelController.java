package promgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import promgr.db.PromgrDao;

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
