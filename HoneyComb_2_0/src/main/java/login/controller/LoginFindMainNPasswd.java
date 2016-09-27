package login.controller;

import javax.mail.MessagingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.LocaleResolver;





@Controller
public class LoginFindMainNPasswd {

	private LoginDAO logindao;

	
		
	public LoginDAO getLogindao() {
		return logindao;
	}

	public void setLogindao(LoginDAO logindao) {
		this.logindao = logindao;
	}

	
		@RequestMapping(method = RequestMethod.GET,value="findEmail.do")
		public String findEmail() {
			return "findEmail";
			
		}

		@RequestMapping(method = RequestMethod.POST,value="findEmail.do")
		public String findEmail(@RequestParam("name") String name,
				@RequestParam("phone1") String phone1,
				@RequestParam("phone2") String phone2,
				@RequestParam("phone3") String phone3,ModelMap modelMap) {

			String email;
			String phone = phone1+phone2+phone3;
			email=logindao.findEmail(name, phone);
			
			
            if(email==null){
            	return "findEmailPro_n";
            }else{
            	
			modelMap.addAttribute("email", email);
			
            	
			
			return "findEmailPro_y";
            }
		}
		

		
		
		
		@RequestMapping(method = RequestMethod.GET,value="findPasswd.do")
		public String findPasswd() {
			
			
				return "findPasswd";
		}

		@RequestMapping(method = RequestMethod.POST, value="findPasswd.do")
		public String findPasswd(@RequestParam("email") String email, ModelMap modelMap) {
			
			System.out.println("실행함여");
			
			
			MailSender sender = new MailSender();
			String check = logindao.findPasswd(email);
			
			if(check==null){
				return "findPasswdPro_n";
			}else{
				try {
					int key =  sender.emailSender(email);
					modelMap.addAttribute("email", check);
					modelMap.addAttribute("key", key);
					
					
					
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return "findPasswdPro_y";
				
			}
			
            	
			
		
            
		}
	
	
	
	
	
}
