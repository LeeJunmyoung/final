package notice.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import notice.db.NoticeDao;
import notice.db.NoticeDataBean;

@Controller
public class NoticeWriteController {

	private NoticeDao dao;

	@Autowired
	public void setDao(NoticeDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/writeForm.do")
	public String form() {

		return "writeForm";

	}

	@RequestMapping("/writePro.do")
	public ModelAndView submit(HttpServletRequest request) {

		NoticeDataBean article = new NoticeDataBean();

		article.setNotice_title(request.getParameter("notice_title"));
		article.setNotice_content(request.getParameter("notice_content").replace("\r\n","<br>"));
		article.setNotice_member((String) request.getSession().getAttribute("name"));
		article.setCom_num((int) request.getSession().getAttribute("com_num"));
		article.setNotice_date(new Timestamp(System.currentTimeMillis()));

		int notice_insert_count =  dao.addNotice(article);
		
		ModelAndView mav = new ModelAndView("writePro");
		mav.addObject("notice_insert_count", notice_insert_count);
		
		return mav;

	}

}
