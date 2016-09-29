package promgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import promgr.db.PromgrDao;

@Controller
public class PromgrChkItemDelController {

	private PromgrDao dao;

	@Autowired
	public void setDao(PromgrDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/chkItemDelPro.do")
	public ModelAndView submit(@RequestParam(value = "promgr_num") int promgr_num,
			@RequestParam(value = "list_num") int list_num, @RequestParam(value = "item_num") int item_num) {

		int promgr_update_count = dao.delChkItem(promgr_num, list_num, item_num);

		ModelAndView mav = new ModelAndView("pro");
		mav.addObject("promgr_update_count", promgr_update_count);

		return mav;
		
	}

}
