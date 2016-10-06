package login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Comcheck.do")
public class CompanyCheckController {

	private LoginDAO logindao;

	public LoginDAO getLogindao() {
		return logindao;
	}

	public void setLogindao(LoginDAO logindao) {
		this.logindao = logindao;
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String Comcheck(HttpServletRequest request){
		String email  =(String) request.getSession().getAttribute("email");
		int com_num = (int)request.getSession().getAttribute("com_num");
	
		System.out.println("email::::"+email);
		System.out.println("com_num:::::"+com_num);
			
		if(email.equals("admin@admin.com")){
			return "../../admin/admin_main_page";
		}
		
		else{
			if(com_num == 0 ){
				return "../company/mainForm";
			}else if(com_num<0){
			
				return "/temp_accept_page/wait_accept_company";
				
			}
			
			}
		
		
		LogOnDataBean lodb = logindao.getUserInfo(email);
		

		
		
		request.getSession().setAttribute("mem_num", lodb.getMem_num());
		request.getSession().setAttribute("com_num", lodb.getCom_num());
		request.getSession().setAttribute("com_dept_num", lodb.getCom_dept_num());
		request.getSession().setAttribute("com_pos_num", lodb.getCom_pos_num());
		request.getSession().setAttribute("name", lodb.getName());
		request.getSession().setAttribute("phone_num", lodb.getPhone_num());
		request.getSession().setAttribute("com_name", lodb.getCom_name());
		request.getSession().setAttribute("com_dept_name", lodb.getCom_dept_name());
		request.getSession().setAttribute("com_pos_name", lodb.getCom_pos_name());
		
		System.out.println("lodb:::"+lodb.toString());
		
		
		
		return "main_send";
	}
	
	
	
}
