package cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cloud.db.CloudDao;

@Controller
public class CloudMainController {
	CloudDao dao;
	
	@Autowired
	public void setDao(CloudDao dao) {
		this.dao = dao;
	}
	
}
