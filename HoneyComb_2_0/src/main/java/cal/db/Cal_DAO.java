package cal.db;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class Cal_DAO extends SqlSessionDaoSupport{

	
	public void cal_modify(Cal_DataBean cdb){
		
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		
		
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

	public List<Object> viewCal(int mem_num ,int com_num,int com_dept_num) {

		List<Object> totalCal = new ArrayList<Object>();
		List<Object> totalCal1 = new ArrayList<Object>();
		
		HashMap< String, Integer> map = new HashMap< String, Integer>();
		map.put("mem_num", mem_num);
		map.put("com_num", com_num);
		map.put("com_dept_num", com_dept_num);
		
		
		
		totalCal = getSqlSession().selectList("cal.viewCal", map);
		
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
	
	
	
	public void insertCal(Cal_DataBean calbean){
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("cal_subject", calbean.getCal_subject());
		map.put("cal_contents", calbean.getCal_contents());
		map.put("com_num", calbean.getCom_num());
		map.put("com_dept_num", calbean.getCom_dept_num());
		map.put("category",calbean.getCategory());
		map.put("mem_num", calbean.getMem_num());
		
		map.put("cal_start", new java.sql.Date(calbean.getCal_start().getTime()));
		map.put("cal_end",  new java.sql.Date(calbean.getCal_end().getTime()));
		
		
		
		
		getSqlSession().insert("cal.cal_insert",map);
		
	}
	
	public void delCal(int cal_num){
		
		getSqlSession().delete("cal.cal_del",cal_num);
		
		
		
		
	}
	
	
}
