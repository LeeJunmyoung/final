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
public class PromgrCommentModController {

	private PromgrDao dao;

	@Autowired
	public void setDao(PromgrDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/commentModForm.do")
	public ModelAndView form(@RequestParam(value = "comment_num") int comment_num) {

		ModelAndView mav = new ModelAndView("commentModForm");
		mav.addObject("comment_num", comment_num);

		return mav;

	}

	@RequestMapping("/commentModPro.do")
	public String submit(@RequestParam(value = "comment_num") int comment_num,
			@RequestParam(value = "promgr_comment") String comment_content) {

		Timestamp update_time = new Timestamp(System.currentTimeMillis());

		dao.modComment(comment_num, comment_content, update_time);

		return "redirect:/more.do";
	}

}
