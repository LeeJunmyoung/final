package promgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import promgr.db.PromgrDao;

@Controller
public class PromgrChkItemModController {

	private PromgrDao dao;

	@Autowired
	public void setDao(PromgrDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/chkItemModForm.do")
	public ModelAndView form(@RequestParam(value = "item_num") int item_num) {

		ModelAndView mav = new ModelAndView("chkListModForm");
		mav.addObject("item_num", item_num);

		return mav;

	}

	@RequestMapping("/chkItemModPro.do")
	public ModelAndView submit(@RequestParam(value = "item_num") int item_num,
			@RequestParam(value = "promgr_list_item") String item_name) {

		int promgr_update_count = dao.modChkItem(item_num, item_name);

		ModelAndView mav = new ModelAndView("pro");
		mav.addObject("promgr_update_count", promgr_update_count);

		return mav;

	}

}
