package cal.db;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	public List viewCal(int mem_num) {

		List totalCal = new ArrayList<>();
		List totalCal1 = new ArrayList<>();
		
		totalCal = getSqlSession().selectList("cal.viewCal", mem_num);
		
		for (Object c : totalCal) {
			Cal_DataBean cal = (Cal_DataBean) c;
			
			Date formatdate = new Date(cal.getCal_end().getYear(),cal.getCal_end().getMonth(),cal.getCal_end().getDate()+1);
			
			
			cal.setCal_end(formatdate);
			formatdate= new Date(cal.getCal_start().getYear(),cal.getCal_start().getMonth(),cal.getCal_start().getDate());
			cal.setCal_start(formatdate);
			//System.out.println(cal.toString());
			

			totalCal1.add(cal);
		}

		return totalCal1;

	}
	
	
}
