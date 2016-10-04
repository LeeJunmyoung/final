package cal.db;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class Cal_DAO extends SqlSessionDaoSupport{

	
	public void cal_modify(Cal_DataBean cdb){
		
		
		HashMap map = new HashMap<>();
		
		
		
		map.put("cal_subject", cdb.getCal_subject());
		map.put("cal_contents", cdb.getCal_contents());
		map.put("cal_num",cdb.getCal_num());
		
		
		java.sql.Date sqlDate = new java.sql.Date(cdb.getCal_start().getTime());
		
		map.put("cal_start", sqlDate);
		
		sqlDate = new java.sql.Date(cdb.getCal_end().getTime());
		
		map.put("cal_end",sqlDate);
		
		System.out.println(map.toString());
		
		getSqlSession().update("cal.cal_modify",map);
		
		
		
	}
	
	
	
}
