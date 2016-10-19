package edi.db;

public class Temp_EDI_DateBean {

	private int temp_EDI_num;
	public int getTemp_EDI_num() {
		return temp_EDI_num;
	}
	public void setTemp_EDI_num(int temp_EDI_num) {
		this.temp_EDI_num = temp_EDI_num;
	}
	private String document_num;
	private int com_num;
	private String EDI_Subject;
	private String EDI_TextArea;
	private int mid_mem_num;
	private int fin_mem_num;
	private String send_dept_name;
	private String attachFile;
	private String write_date;
	private int edi_writer;
	
	
	private String mid_mem_name;
	private String mid_mem_dept;
	private String mid_mem_pos;
	private String fin_mem_name;
	private String fin_mem_dept;
	private String fin_mem_pos;
	
	public String getMid_mem_name() {
		return mid_mem_name;
	}
	public void setMid_mem_name(String mid_mem_name) {
		this.mid_mem_name = mid_mem_name;
	}
	public String getMid_mem_dept() {
		return mid_mem_dept;
	}
	public void setMid_mem_dept(String mid_mem_dept) {
		this.mid_mem_dept = mid_mem_dept;
	}
	public String getMid_mem_pos() {
		return mid_mem_pos;
	}
	public void setMid_mem_pos(String mid_mem_pos) {
		this.mid_mem_pos = mid_mem_pos;
	}
	public String getFin_mem_name() {
		return fin_mem_name;
	}
	public void setFin_mem_name(String fin_mem_name) {
		this.fin_mem_name = fin_mem_name;
	}
	public String getFin_mem_dept() {
		return fin_mem_dept;
	}
	public void setFin_mem_dept(String fin_mem_dept) {
		this.fin_mem_dept = fin_mem_dept;
	}
	public String getFin_mem_pos() {
		return fin_mem_pos;
	}
	public void setFin_mem_pos(String fin_mem_pos) {
		this.fin_mem_pos = fin_mem_pos;
	}
	public String getDocument_num() {
		return document_num;
	}
	public void setDocument_num(String document_num) {
		this.document_num = document_num;
	}
	public int getCom_num() {
		return com_num;
	}
	public void setCom_num(int com_num) {
		this.com_num = com_num;
	}
	public String getEDI_Subject() {
		return EDI_Subject;
	}
	public void setEDI_Subject(String eDI_Subject) {
		EDI_Subject = eDI_Subject;
	}
	public String getEDI_TextArea() {
		return EDI_TextArea;
	}
	public void setEDI_TextArea(String eDI_TextArea) {
		EDI_TextArea = eDI_TextArea;
	}
	public int getMid_mem_num() {
		return mid_mem_num;
	}
	public void setMid_mem_num(int mid_mem_num) {
		this.mid_mem_num = mid_mem_num;
	}
	public int getFin_mem_num() {
		return fin_mem_num;
	}
	public void setFin_mem_num(int fin_mem_num) {
		this.fin_mem_num = fin_mem_num;
	}
	public String getSend_dept_name() {
		return send_dept_name;
	}
	public void setSend_dept_name(String send_dept_name) {
		this.send_dept_name = send_dept_name;
	}
	public String getAttachFile() {
		return attachFile;
	}
	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public int getEdi_writer() {
		return edi_writer;
	}
	public void setEdi_writer(int edi_writer) {
		this.edi_writer = edi_writer;
	}
	@Override
	public String toString() {
		return "Temp_EDI_DateBean [temp_EDI_num=" + temp_EDI_num + ", document_num=" + document_num + ", com_num="
				+ com_num + ", EDI_Subject=" + EDI_Subject + ", EDI_TextArea=" + EDI_TextArea + ", mid_mem_num="
				+ mid_mem_num + ", fin_mem_num=" + fin_mem_num + ", send_dept_name=" + send_dept_name + ", attachFile="
				+ attachFile + ", write_date=" + write_date + ", edi_writer=" + edi_writer + "]";
	}
	

		
}
