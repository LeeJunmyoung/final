package cloud.db;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.web.multipart.MultipartFile;

public class CloudDao extends SqlSessionDaoSupport{
	
	public List<CloudInfo> getcloudList(int com_num, String folder){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("com_num", com_num);
		param.put("folder", folder);
		List cloudlist = new ArrayList<CloudInfo>();
		cloudlist = getSqlSession().selectList("cloud.getcloudlist", param);
		
		return cloudlist;
	}
	public void uploadFile(CloudInfo info){
		getSqlSession().insert("cloud.upload", info);
	}
	
	public String getFilePath(int file_num){
		String file_path = getSqlSession().selectOne("cloud.getFilePath",file_num);
		return file_path;
	}
}
