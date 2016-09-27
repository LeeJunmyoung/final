package promgr.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import promgr.db.CommentDataBean;
import promgr.db.PromgrDao;

@Controller
public class PromgrCommentAddController {

	private PromgrDao dao;

	@Autowired
	public void setDao(PromgrDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/commentAddForm.do")
	public ModelAndView form(@RequestParam(value = "promgr_num") int promgr_num) {

		ModelAndView mav = new ModelAndView("commentAddForm");
		mav.addObject("promgr_num", promgr_num);

		return mav;

	}

	@RequestMapping("/commentAddPro.do")
	public String submit(HttpServletRequest request) {

		CommentDataBean article = new CommentDataBean();

		article.setComment_content(String.valueOf(request.getParameter("promgr_comment")));
		article.setMem_num((int) request.getSession().getAttribute("mem_num"));
		article.setPromgr_num(Integer.parseInt(request.getParameter("promgr_num")));
		article.setCom_num((int) request.getSession().getAttribute("com_num"));
		article.setComment_date(new Timestamp(System.currentTimeMillis()));

		dao.addComment(article);

		return "redirect:/more.do";
	}

}
