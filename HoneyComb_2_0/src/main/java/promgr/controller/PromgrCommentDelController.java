package promgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import promgr.db.PromgrDao;

@Controller
public class PromgrCommentDelController {

	private PromgrDao dao;

	@Autowired
	public void setDao(PromgrDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/commentDel.do")
	public ModelAndView submit(@RequestParam("promgr_num") int promgr_num,
			@RequestParam("comment_num") int comment_num) {

		int promgr_update_count = dao.delComment(comment_num, promgr_num);

		ModelAndView mav = new ModelAndView("pro");
		mav.addObject("promgr_update_count", promgr_update_count);

		return mav;
		
	}

}
