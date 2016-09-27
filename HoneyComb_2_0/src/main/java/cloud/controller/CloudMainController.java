package cloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cloud.db.CloudDao;

@Controller
public class CloudMainController {
	// session 받기
	/* HttpSession session; */
	private CloudDao dao;

	@Autowired
	public void setDao(CloudDao dao) {
		this.dao = dao;
	}

	// 클라우드 메인리스트
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public ModelAndView getCloudList(HttpSession session, HttpServletRequest request, String folder) {
		int com_num = 0;
		session = request.getSession();
		System.out.println(folder);
		/* session 임시설정 */
		System.out.println("test용com_num설정::1");
		session.setAttribute("com_num", 1);
		/* session임시설정끝 */

		com_num = (int) request.getSession().getAttribute("com_num");
		List cloudlist = dao.getcloudList(com_num, folder);
		ModelAndView mav = new ModelAndView("cloud_main", "cloudlist", cloudlist);
		return mav;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload(String folder) {
		System.out.println(folder);
		return "upload";
	}
}
