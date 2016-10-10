package mypage.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import mypage.db.MyPageDAO;

@Controller
public class Profile_Img_Controller {
	
	private MyPageDAO dao;
	
	public void setDao(MyPageDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/profile_img_up")
	public String profile_Img_Upload(HttpServletRequest request, @RequestParam("profile_img") MultipartFile pro) {

		int mem_num = (int) request.getSession().getAttribute("mem_num");
		String savePath = request.getServletContext().getRealPath("profile_img");

		System.out.println("profile_Img_Upload savePath ::: " + savePath);

		Date d = new Date();
		String img_add_date = String.valueOf(d.getTime());

		String img_name = pro.getOriginalFilename();
		String file_name = img_add_date + img_name;
		String file_path = "C:\\Users\\user1\\git\\final\\HoneyComb_2_0\\WebContent\\honeycomb_profile\\" + file_name;

		File img = new File(savePath + "\\" + file_name);

		String ss = "/HoneyComb_2_0/profile_img/" + file_name;

		try {
			pro.transferTo(img);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dao.profile_Change(mem_num, ss);
		System.out.println(ss);
		request.getSession().setAttribute("profile_img", ss);

		return "myPage";
	}

}
