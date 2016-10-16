package edi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edi.db.EDI_DAO;

@Controller
public class EDI_ReceiveController {

	private EDI_DAO dao;

	public void setDao(EDI_DAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/receiveForm.do")//수신처 폼
	public String getEDI_ReceiveController(HttpServletRequest request,Model map) {

		int com_num = (int) request.getSession().getAttribute("com_num");

		List<String> dept_Name_EDI = dao.getDept_name(com_num);

		map.addAttribute("dept_Name_EDI", dept_Name_EDI);

		return "receiveForm";
	}

}
