package notice.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String submit(MultipartHttpServletRequest request) {

		NoticeDataBean article = new NoticeDataBean();
		
		article.setNotice_title(request.getParameter("notice_title"));
		article.setNotice_content(request.getParameter("notice_content"));
		article.setNotice_member((String) request.getSession().getAttribute("name"));
		article.setCom_num((int) request.getSession().getAttribute("com_num"));
		article.setNotice_date(new Timestamp(System.currentTimeMillis()));

		dao.insertItem(article);

		return "redirect:/main.do";
	}

}
