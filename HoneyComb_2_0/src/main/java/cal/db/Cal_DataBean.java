/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package cal.db;

import java.util.Date;

public class Cal_DataBean {
	private int cal_num;
	private String cal_subject;
	private String cal_contents;
	private Date cal_start;
	private Date cal_end;
	private int com_num;
	private int com_dept_num;
	private int category;
	private int mem_num;
	
	
	public int getCal_num() {
		return cal_num;
	}
	public void setCal_num(int cal_num) {
		this.cal_num = cal_num;
	}
	public String getCal_subject() {
		return cal_subject;
	}
	public void setCal_subject(String cal_subject) {
		this.cal_subject = cal_subject;
	}
	public String getCal_contents() {
		return cal_contents;
	}
	public void setCal_contents(String cal_contents) {
		this.cal_contents = cal_contents;
	}
	public Date getCal_start() {
		return cal_start;
	}
	public void setCal_start(Date cal_start) {
		this.cal_start = cal_start;
	}
	public Date getCal_end() {
		return cal_end;
	}
	public void setCal_end(Date cal_end) {
		this.cal_end = cal_end;
	}
	public int getCom_num() {
		return com_num;
	}
	public void setCom_num(int com_num) {
		this.com_num = com_num;
	}
	public int getCom_dept_num() {
		return com_dept_num;
	}
	public void setCom_dept_num(int com_dept_num) {
		this.com_dept_num = com_dept_num;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	@Override
	public String toString() {
		return "Cal_DataBean [cal_num=" + cal_num + ", cal_subject=" + cal_subject + ", cal_contents=" + cal_contents
				+ ", cal_start=" + cal_start + ", cal_end=" + cal_end + ", com_num=" + com_num + ", com_dept_num="
				+ com_dept_num + ", category=" + category + ", mem_num=" + mem_num + "]";
	}

	
}