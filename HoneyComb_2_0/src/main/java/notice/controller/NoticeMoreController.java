package notice.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import notice.db.NoticeDao;

@Controller
@RequestMapping("/more")
public class NoticeMoreController {

	private NoticeDao dao;

	public void setDao(NoticeDao dao) {
		this.dao = dao;
	}
	
	public String submit(MultipartHttpServletRequest request) {

		String pageNum = request.getParameter("pageNum");
		int com_num = (int) request.getSession().getAttribute("com_num");

		if (pageNum == null) {
			pageNum = "1";
		}

		int pageSize = 5;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = 0;
		endRow = currentPage * pageSize;

		int notice_count = 0;
		int number = 0;

		List articleList = null;

		notice_count = dao.getNoticeCount(com_num);

		if (notice_count > 0) {
			articleList = dao.getNoticeItem(com_num, startRow, endRow);
		} else {
			articleList = Collections.EMPTY_LIST;
		}

		number = notice_count - (currentPage - 1) * pageSize;
		
		

		return "more";
	}

}
