package cloud.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class CloudDao extends SqlSessionDaoSupport{
	
	public List<CloudInfo> getcloudList(int com_num, String folder){
		Map<String, Object> listinfo = new HashMap<String, Object>();
		listinfo.put("com_num", com_num);
		listinfo.put("folder", folder);
		List cloudlist = new ArrayList<CloudInfo>();
		cloudlist = getSqlSession().selectList("cloud.getcloudlist", listinfo);
		
		return cloudlist;
	}
	
	
}
