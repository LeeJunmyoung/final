package edi.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import login.controller.LogOnDataBean;

public class EDI_DAO extends SqlSessionDaoSupport {

	public List<String> getDept_name(int com_num) {

		List<String> getDeptName = getSqlSession().selectList("edi.getDeptName", com_num);

		return getDeptName;
	}

	public List<LogOnDataBean> getDept_member(int com_num, String com_dept_name) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("com_num", com_num);
		map.put("com_dept_name", com_dept_name);
		List<LogOnDataBean> list = getSqlSession().selectList("edi.getDeptMem", map);

		return list;
	}

	public LogOnDataBean getMemberInfo(int mem_num) {

		LogOnDataBean lodb = getSqlSession().selectOne("edi.getMemberInfo", mem_num);

		return lodb;
	}

	public void insertNewEDI(EDI_DateBean edb) {

		getSqlSession().insert("edi.insertNewEDI", edb);

	}

	public List<EDI_DateBean> getEDI_Table_ing(int com_num, int mem_num) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("com_num", com_num);
		map.put("mem_num", mem_num);

		List<EDI_DateBean> list = getSqlSession().selectList("edi.getEDI_Table_ing", map);
		List<EDI_DateBean> returnlist = new ArrayList<EDI_DateBean>();

		for (Object object : list) {
			EDI_DateBean edb = (EDI_DateBean) object;
			LogOnDataBean lodb = getMemberInfo(edb.getEdi_writer());
			edb.setWriter_mem_dept(lodb.getCom_dept_name());
			edb.setWriter_mem_pos(lodb.getCom_pos_name());
			edb.setWriter_mem_name(lodb.getName());

			returnlist.add(edb);

		}

		return returnlist;

	}

	public int getEDI_Table_ing_count(int com_num, int mem_num) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("com_num", com_num);
		map.put("mem_num", mem_num);

		int count = getSqlSession().selectOne("edi.getEDI_Table_ing_count", map);

		return count;
	}
	
	public EDI_DateBean getEDIonlyOne(int EDI_num){
		
		EDI_DateBean edb = getSqlSession().selectOne("edi.getEDIonlyOne", EDI_num);
		LogOnDataBean writer = getMemberInfo(edb.getEdi_writer());
		LogOnDataBean mid_mem = getMemberInfo(edb.getMid_mem_num());
		LogOnDataBean fin_mem = getMemberInfo(edb.getFin_mem_num());
		
		
		String text = edb.getEDI_TextArea().replaceAll("<br>", "\r\n");
		
		edb.setEDI_TextArea(text);
		
		edb.setWriter_mem_dept(writer.getCom_dept_name());
		edb.setWriter_mem_pos(writer.getCom_pos_name());
		edb.setWriter_mem_name(writer.getName());
		
		edb.setMid_mem_dept(mid_mem.getCom_dept_name());
		edb.setMid_mem_pos(mid_mem.getCom_pos_name());
		edb.setMid_mem_name(mid_mem.getName());
		
		edb.setFin_mem_dept(fin_mem.getCom_dept_name());
		edb.setFin_mem_pos(fin_mem.getCom_pos_name());
		edb.setFin_mem_name(fin_mem.getName());
		
		
		
		
		return edb;
	}
	
	
	public void sign_Mid(int EDI_num,String mid_sign){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("EDI_num", EDI_num);
		map.put("mid_sign", mid_sign);
		getSqlSession().update("edi.sign_Mid", map);
	
	}
	
	
	public void sign_fin(int EDI_num,String fin_sign,String endDate){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("EDI_num", EDI_num);
		map.put("fin_sign", fin_sign);
		map.put("endDate", endDate);
		getSqlSession().update("edi.sign_fin", map);
		
		
	}
	
	public List<EDI_DateBean> getEDI_Table_end(int com_num){
		
		

		List<EDI_DateBean> list = getSqlSession().selectList("edi.getEDI_Table_end", com_num);
		List<EDI_DateBean> returnlist = new ArrayList<EDI_DateBean>();

		for (Object object : list) {
			EDI_DateBean edb = (EDI_DateBean) object;
			LogOnDataBean lodb = getMemberInfo(edb.getEdi_writer());
			edb.setWriter_mem_dept(lodb.getCom_dept_name());
			edb.setWriter_mem_pos(lodb.getCom_pos_name());
			edb.setWriter_mem_name(lodb.getName());

			returnlist.add(edb);

		}
		
		return returnlist;
		
		
	}
	
	public int getEDI_Table_end_count(int com_num) {

		int count = getSqlSession().selectOne("edi.getEDI_Table_end_count", com_num);

		return count;
	}

}
