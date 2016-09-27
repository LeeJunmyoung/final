package promgr.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cloud.db.CloudInfo;
import promgr.db.ChkListViewDataBean;
import promgr.db.CommentDataBean;
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

		List articleList = null;
		int promgr_count = dao.getPromgrCount(com_num, mem_num);

		if (promgr_count > 0) {

			articleList = dao.getPromgrList(com_num, mem_num, startRow, endRow);

			int[] num_arr = null;

			for (int i = 0; i < articleList.size(); i++) {

				PromgrDataBean article = (PromgrDataBean) articleList.get(i);

				// mem_name_arr
				num_arr = cut_num(article.getMem_num());

				String[] mem_name_arr = new String[num_arr.length];

				for (int j = 0; j < num_arr.length; j++) {

					String mem_name = dao.setMem_name(num_arr[j]);
					mem_name_arr[j] = mem_name;

				}

				article.setMem_name_arr(mem_name_arr);

				// chklist_view
				if (article.getChklist_title_num() != null) {
					num_arr = cut_num(article.getChklist_title_num());
				}

				List chkList_view = new ArrayList();

				for (int j = 0; j < num_arr.length; j++) {

					ChkListViewDataBean chkList = dao.setChklist_view(num_arr[j]);

					List chkItem = dao.setChkItem(num_arr[j]);

					chkList.setItem_bean(chkItem);

					chkList_view.add(chkList);

				}

				article.setChklist_view(chkList_view);

				// file_view
				if (article.getFile_num() != null) {
					num_arr = cut_num(article.getFile_num());
				}

				List file_view = new ArrayList();

				for (int j = 0; j < num_arr.length; j++) {

					CloudInfo file = dao.setFile_view(num_arr[j]);
					file_view.add(file);

				}

				article.setFile_view(file_view);

				// comment_view
				if (article.getComment_num() != null) {
					num_arr = cut_num(article.getComment_num());
				}

				List comment_view = new ArrayList();

				for (int j = 0; j < num_arr.length; j++) {

					CommentDataBean comment = dao.setComment_view(num_arr[j]);
					comment_view.add(comment);

				}

				article.setComment_view(comment_view);

			}

		} else {
			articleList = Collections.EMPTY_LIST;
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

	public int[] cut_num(String num) {

		int[] arr = null;
		int idx = 0;

		StringTokenizer stz = new StringTokenizer(num, "/");

		arr = new int[stz.countTokens()];

		while (stz.hasMoreTokens()) {
			arr[idx] = Integer.parseInt(stz.nextToken());
			idx++;
		} // while (stz.hasMoreTokens()) end

		return arr;

	}

}
