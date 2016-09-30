package promgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import promgr.db.PromgrDao;

@Controller
public class PromgrMemberAddController {

	private PromgrDao dao;

	@Autowired
	public void setDao(PromgrDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/memberAdd.do")
	public ModelAndView submit(@RequestParam(value = "promgr_num") String promgr_num,
			@RequestParam(value = "mem_add") String[] add_mem_num) {

		int promgr_update_count = 0;

		if (add_mem_num != null) {
			promgr_update_count = dao.addMembers(promgr_num, add_mem_num);
		}

		ModelAndView mav = new ModelAndView("memberPro");
		mav.addObject("promgr_update_count", promgr_update_count);
		
		return mav;

	}

}
