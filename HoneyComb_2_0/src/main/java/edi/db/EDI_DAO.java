package edi.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import login.controller.LogOnDataBean;

public class EDI_DAO extends SqlSessionDaoSupport {
	
	
	

	public List<String> getDept_name(int com_num){
		
		
		List<String> getDeptName=getSqlSession().selectList("edi.getDeptName", com_num);
		
		
		
		return getDeptName;
	}
	
	public List<LogOnDataBean> getDept_member(int com_num,String com_dept_name){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("com_num", com_num);
		map.put("com_dept_name", com_dept_name);
		List<LogOnDataBean> list = getSqlSession().selectList("edi.getDeptMem", map);
		
		return list;
	}
	
	public LogOnDataBean getMemberInfo(int mem_num){
		
		LogOnDataBean lodb = getSqlSession().selectOne("edi.getMemberInfo", mem_num);
		
		
		return lodb;
	}
	
	public void insertNewEDI(EDI_DateBean edb){
		
		getSqlSession().insert("edi.insertNewEDI", edb);
		
	}
	
	
	public List<EDI_DateBean> getEDI_Table(int com_num){
		
		List<EDI_DateBean> list = getSqlSession().selectList("edi.getEDI_Table", com_num);
		
		return list;
		
	}
	
	
	
	
	
}
