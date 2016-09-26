package cloud.db;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.ui.ModelMap;

public class CloudDao extends SqlSessionDaoSupport{
	
	public List<CloudInfo> getcloudList(int com_num){
		List cloudlist = new ArrayList<CloudInfo>();
		cloudlist = getSqlSession().selectList("cloud.getcloudlist", com_num);
		
		return cloudlist;
	}
	
	
}
