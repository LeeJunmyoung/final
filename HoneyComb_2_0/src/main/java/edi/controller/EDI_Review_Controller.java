package edi.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.AbstractView;

import edi.db.EDI_DAO;
import edi.db.EDI_DateBean;

@Controller
public class EDI_Review_Controller extends AbstractView {

	private EDI_DAO dao;

	public void setDao(EDI_DAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/EDI_review_form.do")
	public String EDI_Review(@RequestParam("EDI_num") int EDI_num, ModelMap map) {

		EDI_DateBean getEDIonlyOne = dao.getEDIonlyOne(EDI_num);
		int start = getEDIonlyOne.getAttechFile().indexOf("00000") + 5;
		getEDIonlyOne.setAttechFile(getEDIonlyOne.getAttechFile().substring(start));
		
		
		map.addAttribute("edi_info", getEDIonlyOne);

		return "EDI_review_form";
	}

	

	@Override
	@RequestMapping("/EDIDown.do")
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String savepath = request.getSession().getServletContext().getRealPath("attachfile");
		
		int EDI_num =  Integer.parseInt(request.getParameter("EDI_num"));
		EDI_DateBean getEDIonlyOne = dao.getEDIonlyOne(EDI_num);
		int start = getEDIonlyOne.getAttechFile().indexOf("00000") + 5;
		String orgname = getEDIonlyOne.getAttechFile().substring(start);
		StringTokenizer stok = new StringTokenizer(getEDIonlyOne.getAttechFile(), "/");
		stok.nextToken();
		stok.nextToken();
		
		String realpath=savepath+"\\"+stok.nextToken();
		System.out.println(realpath);
		File file = new File(realpath);
		response.setContentLength((int) file.length());
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=\""+orgname+"\"");
		FileInputStream fis = null;
		OutputStream out = null;
		
		 try {
			 out = response.getOutputStream();
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO: handle exception
				}
			out.flush();
		}
		
		
		
	}

}
