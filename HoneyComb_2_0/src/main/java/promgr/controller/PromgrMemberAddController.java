package promgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import promgr.db.PromgrDao;

@Controller
public class PromgrMemberAddController {

	private PromgrDao dao;

	@Autowired
	public void setDao(PromgrDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/memberAdd.do")
	public String submit(@RequestParam(value = "promgr_num") int promgr_num,
			@RequestParam(value = "mem_add") String[] add_mem_num) {

		if (add_mem_num != null) {
			dao.addMembers(promgr_num, add_mem_num);
		}

		return "redirect:/more.do";

	}

}
