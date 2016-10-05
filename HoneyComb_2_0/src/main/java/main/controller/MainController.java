package main.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import main.db.MainDao;
import main.db.NoticeDataBean;
import promgr.db.PromgrDataBean;

@Controller

public class MainController {

	private MainDao dao;

	@Autowired
	public void setDao(MainDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/main.do")
	public ModelAndView form(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, HttpServletRequest request) {

		int com_num = (int) request.getSession().getAttribute("com_num");
		int mem_num = (int) request.getSession().getAttribute("mem_num");
		int com_dept_num = (int) request.getSession().getAttribute("com_dept_num");
		
		// notice
		int rowSize = 5;
		int notice_count = 0;

		List<NoticeDataBean> notice_articleList = null;

		notice_count = dao.getNoticeCount(com_num);

		if (notice_count > 0) {

			notice_articleList = dao.getNoticeList(com_num, -1, rowSize);

		} else {
			notice_articleList = Collections.emptyList();
		}

		// promgr
		int promgr_count = 0;

		List<PromgrDataBean> promgr_articleList = null;
		promgr_count = dao.getPromgrCount(com_num, mem_num); // row 갯수 호출

		if (promgr_count > 0) {

			promgr_articleList = dao.getPromgrList(com_num, mem_num, -1, rowSize);

		} else {
			promgr_articleList = Collections.emptyList();
		}

		ModelAndView mav = new ModelAndView("main");
		
		// notice
		mav.addObject("notice_count", notice_count);
		mav.addObject("notice_articleList", notice_articleList);

		// promgr
		mav.addObject("promgr_count", promgr_count);
		mav.addObject("promgr_articleList", promgr_articleList);

		
		
		/* calendar 소스코드 입니다*/
		
		List totalCal =  dao.viewCal(mem_num,com_num,com_dept_num);
		
		mav.addObject("totalCal", totalCal);
		mav.addObject("cal_count",totalCal.size());
		
		
		
		
		
		
		/* calendar 소스코드 입니다		*/
		return mav;
		
	}

	@RequestMapping("/logout.do")
	public String logout() {
		return "logout";
	}

}
