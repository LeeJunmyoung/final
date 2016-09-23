package cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cloud.db.CloudDao;

@Controller
@RequestMapping("/cloud")
public class CloudMainController {
	private CloudDao dao;
	
	@Autowired
	public void setDao(CloudDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String startMethod(){
		return "cloud_main";
	}
	
}
