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
	
	public List getFileInfo(String[] fileNums){
		List downloadinfo = new ArrayList();
		for(int i = 0; i < fileNums.length; i++){
			int file_num = Integer.parseInt(fileNums[i]);
			String file_path = getSqlSession().selectOne("cloud.getFilePath",file_num);
			downloadinfo.add(file_path);
			String file_name = getSqlSession().selectOne("cloud.getFileName", file_num);
			downloadinfo.add(file_name);
		}
		
		return downloadinfo;
	}
}
