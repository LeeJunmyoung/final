package mypage.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import mypage.db.MyPageDAO;

@Controller
public class MyPage_Controller {

	private MyPageDAO dao;

	public void setDao(MyPageDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/mypage")
	public String myPage_View(HttpServletRequest session) {
		
		return "myPage";
	}

	@RequestMapping("/passwd_ch_view")
	public ModelAndView passwd_View(HttpServletRequest request) {
		
		int mem_num = (int) request.getSession().getAttribute("mem_num");

		String passwd = dao.passwd(mem_num);

		ModelAndView mav = new ModelAndView("modify_passwd_confirm");
		mav.addObject("passwd", passwd);

		return mav;
	}

	@RequestMapping("/passwd_change")
	public String passwd_Change(HttpServletRequest request, @RequestParam("newpw1") String passwd) {
		
		int mem_num = (int) request.getSession().getAttribute("mem_num");
		System.out.println("mem_num:::" + mem_num + "  passwd:::" + passwd);
		dao.passwd_Change(mem_num, passwd);

		return "mypage_close";
	}

	@RequestMapping("/my_resume")
	public String my_Resume() {

		return "resume_change";
	}
	
	@RequestMapping("/account_drop_view")
	public ModelAndView account_Drop_View(HttpServletRequest request) {
		
		int mem_num = (int) request.getSession().getAttribute("mem_num");
		String passwd = dao.passwd(mem_num);
		
		ModelAndView mav = new ModelAndView("/user_delete");
		mav.addObject("passwd", passwd);
		
		return mav;
	}

	@RequestMapping("/account_drop")
	public String account_Drop(HttpServletRequest request) {

		int mem_num = (int) request.getSession().getAttribute("mem_num");
		
		dao.account_Delete(mem_num);
		
		return "user_del_compl";
	}

}
