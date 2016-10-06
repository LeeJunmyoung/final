package mypage.controller;

import java.io.File;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import mypage.db.MyPageDAO;


@Controller
public class MyPage_Controller {

	private MyPageDAO dao;

	public void setDao(MyPageDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/mypage")
	public String myPage_View(HttpServletRequest session) {

		System.out.println(session.getSession().getAttribute("phone_num"));
		
		
		return "myPage";
	}

	@RequestMapping(value = "/passwd_ch_view", method = RequestMethod.GET)
	public String passwd_View() {

		return "/modify_passwd_confirm";
	}

	@RequestMapping(value = "/passwd_ch_view", method = RequestMethod.POST)
	public String passwd_Change(HttpSession session, @RequestParam("newpw1") String passwd) {

		int mem_num = Integer.parseInt((String) session.getAttribute("mem_num"));
		System.out.println("mem_num:::" + mem_num + "  passwd:::" + passwd);
		dao.passwd_Change(mem_num, passwd);

		return "/mypage";
	}

	@RequestMapping("/profile_img_up")
	public void profile_Img_Upload(HttpServletRequest request, @RequestParam("profile_img") MultipartRequest pro) {

		String save_path = request.getServletContext().getRealPath("profile_img");
		System.out.println("save_path(파일경로):::" + save_path);
		
		int sizeLimit = 1024 * 1024 * 15;
		
	}

	@RequestMapping("/my_resume")
	public String my_Resume() {

		return "/resume_change";
	}

	@RequestMapping("/account_drop")
	public String account_Drop() {

		return "/user_delete";
	}

}
