package promgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import promgr.db.MemberListDataBean;
import promgr.db.PromgrDao;

@Controller
public class PromgrMemberFormController {

	private PromgrDao dao;

	@Autowired
	public void setDao(PromgrDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/memberForm.do")
	public ModelAndView submit(@RequestParam(value = "promgr_num") String promgr_num,
			@RequestParam(value = "mem_num") int mem_num) {

		List<MemberListDataBean> memberJoinList = dao.getMemberJoinList(promgr_num, mem_num);
		List<MemberListDataBean> memberSearchList = dao.getMemberSearchList(promgr_num);

		ModelAndView mav = new ModelAndView("memberForm");
		mav.addObject("promgr_num", promgr_num);
		mav.addObject("memberJoinList", memberJoinList);
		mav.addObject("memberSearchList", memberSearchList);

		return mav;

	}

}
