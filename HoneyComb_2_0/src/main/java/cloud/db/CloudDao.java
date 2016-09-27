package cloud.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class CloudDao extends SqlSessionDaoSupport{
	
	public List<CloudInfo> getcloudList(int com_num, String folder){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("com_num", com_num);
		param.put("folder", folder);
		List cloudlist = new ArrayList<CloudInfo>();
		cloudlist = getSqlSession().selectList("cloud.getcloudlist", param);
		
		return cloudlist;
	}
	
	
}
