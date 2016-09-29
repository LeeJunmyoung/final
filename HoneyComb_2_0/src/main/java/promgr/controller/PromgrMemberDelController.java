package promgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import promgr.db.PromgrDao;

@Controller
public class PromgrMemberDelController {

	private PromgrDao dao;

	@Autowired
	public void setDao(PromgrDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/memberDel.do")
	public ModelAndView submit(@RequestParam(value = "promgr_num") int promgr_num,
			@RequestParam(value = "mem_del") String[] del_mem_num) {

		int promgr_update_count = 0;
		
		if (del_mem_num != null) {
			dao.delMembers(promgr_num, del_mem_num);
		}
		
		ModelAndView mav = new ModelAndView("memberPro");
		mav.addObject("promgr_update_count", promgr_update_count);

		return mav;

	}

}
