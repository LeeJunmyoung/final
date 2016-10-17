package edi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edi.db.EDI_DAO;
import login.controller.LogOnDataBean;
import net.sf.json.JSONObject;

@Controller
public class SelectApprovalMemFrameController {
	private EDI_DAO dao;

	public void setDao(EDI_DAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/select_approval.do" ,method = RequestMethod.GET)
	public String SelectApprovalMemFrame(HttpServletRequest request,ModelMap map){
		
		
		int com_num = (int) request.getSession().getAttribute("com_num");

		List<String> dept_Name_EDI = dao.getDept_name(com_num);

		map.addAttribute("dept_Name_EDI", dept_Name_EDI);

	
		
		
		return "select_approval_mem_Form";
	}
	
	@RequestMapping(value="/select_approval.do" ,method = RequestMethod.POST)
	public String Selected(HttpServletRequest request,ModelMap map,
			@RequestParam("chk_box1") List<String> chk_box1,
			@RequestParam("chk_box2") List<String> chk_box2){
		
		LogOnDataBean lodb = new LogOnDataBean();
		
		lodb = dao.getMemberInfo(Integer.parseInt( (chk_box1.get(0) ) ) );
		
		map.addAttribute("mid_mem", lodb);
		
		lodb = dao.getMemberInfo(Integer.parseInt( (chk_box2.get(0) ) ) );
		
		map.addAttribute("fin_mem", lodb);
	
	
		
		
		return "setMember";
	}
	
	
	
	
	
	@RequestMapping(value = "/getDeptMember.do", method = RequestMethod.POST)
	public void getDeptMember(HttpServletRequest request,HttpServletResponse resp,@RequestParam String dept) throws IOException{
		
	
		int com_num = (int) request.getSession().getAttribute("com_num");
		List<LogOnDataBean> list = dao.getDept_member(com_num, dept);
		
		
		
		JSONObject json = new JSONObject();
		json.put("mem_info", list);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(json.toString());
	}
	
	
}
