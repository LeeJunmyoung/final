package edi.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edi.db.EDI_DAO;
import edi.db.EDI_DateBean;
import edi.db.Temp_EDI_DateBean;
import net.sf.json.JSONObject;

@Controller
public class Temp_EDIController {
	
	
	private EDI_DAO dao;
	
	
	
	





	public void setDao(EDI_DAO dao) {
		this.dao = dao;
	}









	@RequestMapping("/temp_form.do")
	public String tempForm(@RequestParam("temp_EDI_num") int temp_EDI_num, ModelMap map){
		
		
		Temp_EDI_DateBean tedb = dao.getTempOne(temp_EDI_num);
		
		
		map.put("EDItemp", tedb);
		
		
		return "EDI_TempForm";
	}
	@RequestMapping("/tempwriteEDI.do")
	public String submitForm(@RequestParam("attachfile") MultipartFile attachfile, @RequestParam String edi_subject,
			@RequestParam String textarea_edi, @RequestParam int mid_mem_num, @RequestParam int fin_mem_num,
			@RequestParam String send_dept_name,@RequestParam("document_num") String document_num,HttpServletRequest request,@RequestParam("temp_EDI_num") int temp_EDI_num){
		

		EDI_DateBean edb = new EDI_DateBean();
		int com_num = (int) request.getSession().getAttribute("com_num");
		int mem_num = (int) request.getSession().getAttribute("mem_num");
		String attachfileDBPath="";
		if(attachfile!=null){
			attachfileDBPath = ref_File_Save(request,attachfile); // 파일 저장
		}
		edb.setCom_num(com_num);
		edb.setAttechFile(attachfileDBPath);
		edb.setEDI_Subject(edi_subject);
		textarea_edi=textarea_edi.replace("\r\n","<br>");
		edb.setEDI_TextArea(textarea_edi);
		edb.setMid_mem_num(mid_mem_num);
		edb.setFin_mem_num(fin_mem_num);
		edb.setSend_dept_name(send_dept_name);
		edb.setDocument_num(document_num);
		edb.setDraftDate(writeDate());
		edb.setEdi_writer(mem_num);
		edb.setWriter_sign(signDate());
		dao.insertNewEDI(edb);
		dao.deleteTempTable(temp_EDI_num);
		
		
		
		return "writer_close";
	}
	
	
	
	

	@RequestMapping(value = "/writeTempUpdate.do", method = RequestMethod.POST)
	public void writeTempForm(@RequestParam String edi_subject,@RequestParam( defaultValue="0") String textarea_edi,
			 @RequestParam( defaultValue="0") String mid_mem_num,@RequestParam( defaultValue="0") String fin_mem_num,
			 @RequestParam( defaultValue="0") String send_dept_name,@RequestParam(value="document_num",defaultValue="0") String document_num
			 ,@RequestParam( defaultValue="0") String write_date,@RequestParam( defaultValue="0") String temp_EDI_num,HttpServletResponse resp,HttpServletRequest request
			 ) throws IOException{
		int com_num = (int) request.getSession().getAttribute("com_num");
		int mem_num = (int) request.getSession().getAttribute("mem_num");
		
		Temp_EDI_DateBean tedb = new Temp_EDI_DateBean();
		tedb.setEDI_Subject(edi_subject);
		textarea_edi=textarea_edi.replace("\r\n","<br>");
		tedb.setEDI_TextArea(textarea_edi);
		if(mid_mem_num!=""){
		tedb.setMid_mem_num(Integer.parseInt(mid_mem_num));
		tedb.setFin_mem_num(Integer.parseInt(fin_mem_num));
		}
		tedb.setSend_dept_name(send_dept_name);
		tedb.setDocument_num(document_num);
		tedb.setWrite_date(write_date);
		tedb.setEdi_writer(mem_num);
		tedb.setCom_num(com_num);
		tedb.setTemp_EDI_num(Integer.valueOf(temp_EDI_num));
		
		dao.updateTempTable(tedb);
	
		
		JSONObject json = new JSONObject();
		json.put("mem_info", "1");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(json.toString());
		
	}
	@RequestMapping("/del_temp.do")
	public String delTemp(@RequestParam( defaultValue="0") String temp_EDI_num,ModelMap map){
		dao.deleteTempTable(Integer.valueOf(temp_EDI_num));
	
		
		
		return "close";
	}
	
	
	
	public String writeDate() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int mon = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);

		String d = year + "-" + mon + "-" + day;

		return d;
	}
	public String signDate(){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int mon = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int mm = cal.get(Calendar.MINUTE);
		if(mm<10){
			String dd = year + "-" + mon + "-" + day+" "+hour+":0"+mm ;
			return dd;
		}
		
		String d = year + "-" + mon + "-" + day+" "+hour+":"+mm ;
		return d;
		
	}
	
	public String ref_File_Save(HttpServletRequest request,MultipartFile attachfile){
		String savepath = request.getSession().getServletContext().getRealPath("attachfile");
		Date d = new Date();
		String add_date = String.valueOf(d.getTime());
		String file_name = attachfile.getOriginalFilename();
		String convert_File_Name = add_date+"00000" + file_name;
		File file = new File(savepath + "\\" + convert_File_Name);
		String DBpath = "/HoneyComb_2_0/attachfile/" + convert_File_Name;
		try {
			attachfile.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DBpath;
		
		
	}
	
	
}
