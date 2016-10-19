package edi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import edi.db.EDI_DAO;
import edi.db.EDI_DateBean;
import edi.db.Temp_EDI_DateBean;

@Controller
public class EDI_MainController {

	
	private EDI_DAO dao;
	
	
	
	public void setDao(EDI_DAO dao) {
		this.dao = dao;
	}



	@RequestMapping("/EDI_Main.do")
	public String maintogo(HttpServletRequest request,ModelMap map){
		int com_num=(int) request.getSession().getAttribute("com_num");
		int mem_num=(int)request.getSession().getAttribute("mem_num");
		
		///
		
		List<EDI_DateBean> EDI_Table_end=dao.getEDI_Table_end(com_num);
		int EDI_Table_end_count= dao.getEDI_Table_end_count(com_num);
		
		map.put("EDI_Table_end", EDI_Table_end);
		map.put("EDI_Table_end_count", EDI_Table_end_count);
		
		///진행함
		
		List<EDI_DateBean> EDI_Table_ing=dao.getEDI_Table_ing(com_num,mem_num);
		int EDI_Table_ing_count= dao.getEDI_Table_ing_count(com_num, mem_num);
		
		map.put("EDI_Table_ing", EDI_Table_ing);
		map.put("EDI_Table_ing_count",EDI_Table_ing_count);
		
		///
		/*
		List<Temp_EDI_DateBean> temp=dao.getEDI_Table_ing(com_num,mem_num);
		int temp_count= dao.getEDI_Table_ing_count(com_num, mem_num);
		
		map.put("EDI_Table_ing", EDI_Table_ing);
		map.put("EDI_Table_ing_count",EDI_Table_ing_count);
		*/
		List<Temp_EDI_DateBean> temp = dao.getTemptable(mem_num);
		int temp_count = dao.getTempCount(mem_num);
		
		for(Object c : temp){
			Temp_EDI_DateBean tedb = (Temp_EDI_DateBean) c;
			System.out.println(tedb.toString());
		}
		map.put("EDI_temp",temp);
		map.put("temp_EDI_count", temp_count);
		
		return "EDI/EDI_main";
	}
	
	
	
	
	
}
