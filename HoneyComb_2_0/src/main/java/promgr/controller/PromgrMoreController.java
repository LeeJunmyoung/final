package promgr.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import promgr.db.PromgrDao;
import promgr.db.PromgrDataBean;

@Controller
@RequestMapping("/more.do")
public class PromgrMoreController {

	private PromgrDao dao;

	@Autowired
	public void setDao(PromgrDao dao) {
		this.dao = dao;
	}

	public ModelAndView submit(HttpServletRequest request) {

		String pageNum = request.getParameter("pageNum");
		int com_num = (int) request.getSession().getAttribute("com_num");
		int mem_num = (int) request.getSession().getAttribute("mem_num");

		if (pageNum == null) {
			pageNum = "1";
		}

		int pageSize = 3;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = 0;
		endRow = currentPage * pageSize;

		List<PromgrDataBean> articleList = null;
		int promgr_count = dao.getPromgrCount(com_num, mem_num);

		if (promgr_count > 0) {

			articleList = dao.getPromgrList(com_num, mem_num, startRow, endRow);
			
			articleList = dao.setView(articleList);

		} else {
			articleList = Collections.emptyList();
		}

		int number = promgr_count - (currentPage - 1) * pageSize;

		ModelAndView mav = new ModelAndView("more");
		mav.addObject("currentPage", currentPage);
		mav.addObject("startRow", startRow);
		mav.addObject("promgr_count", promgr_count);
		mav.addObject("pageSize", pageSize);
		mav.addObject("number", number);
		mav.addObject("articleList", articleList);
		mav.addObject("mem_num", mem_num);

		return mav;
	}

}
