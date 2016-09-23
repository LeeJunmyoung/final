package members.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import members.db.MembersDao;
import notice.db.NoticeDao;

@Controller
@RequestMapping("/login/registMembers.do")
public class RegistMembersController {
	
	private MembersDao dao;
	
    @Autowired
	public void setDao(MembersDao dao) {
		this.dao = dao;
	}
    
    @RequestMapping(method = RequestMethod.GET)
	public String form() {
    	
		return "registMembers";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit() {
		
		return "registMembers";
	}
    
	
	
}
