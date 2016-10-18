package edi.db;

public class EDI_DateBean {

	private int EDI_num;
	private String document_num;
	private int com_num;
	private String EDI_Subject;
	private String EDI_TextArea;
	private int mid_mem_num;
	private int mid_accept;
	private int fin_mem_num;
	private int fin_accept;
	private String send_dept_name;
	private String attechFile;
	private String draftDate;
	private String approvalDate;
	private int edi_writer;
	private String writer_sign;
	private String mid_sign;
	private String fin_sign;
	
	public String getWriter_sign() {
		return writer_sign;
	}
	public void setWriter_sign(String writer_sign) {
		this.writer_sign = writer_sign;
	}
	public String getMid_sign() {
		return mid_sign;
	}
	public void setMid_sign(String mid_sign) {
		this.mid_sign = mid_sign;
	}
	public String getFin_sign() {
		return fin_sign;
	}
	public void setFin_sign(String fin_sign) {
		this.fin_sign = fin_sign;
	}
	public int getEdi_writer() {
		return edi_writer;
	}
	public void setEdi_writer(int edi_writer) {
		this.edi_writer = edi_writer;
	}
	//////밑에는 그냥 필요 정보
	private String mid_mem_name;
	private String mid_mem_dept;
	private String mid_mem_pos;
	private String fin_mem_name;
	private String fin_mem_dept;
	private String fin_mem_pos;
	private String writer_mem_name;
	private String writer_mem_dept;
	private String writer_mem_pos;
	
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
	public String getWriter_mem_name() {
		return writer_mem_name;
	}
	public void setWriter_mem_name(String writer_mem_name) {
		this.writer_mem_name = writer_mem_name;
	}
	public String getWriter_mem_dept() {
		return writer_mem_dept;
	}
	public void setWriter_mem_dept(String writer_mem_dept) {
		this.writer_mem_dept = writer_mem_dept;
	}
	public String getWriter_mem_pos() {
		return writer_mem_pos;
	}
	public void setWriter_mem_pos(String writer_mem_pos) {
		this.writer_mem_pos = writer_mem_pos;
	}
	@Override
	public String toString() {
		return "EDI_DateBean [EDI_num=" + EDI_num + ", document_num=" + document_num + ", com_num=" + com_num
				+ ", EDI_Subject=" + EDI_Subject + ", EDI_TextArea=" + EDI_TextArea + ", mid_mem_num=" + mid_mem_num
				+ ", mid_accept=" + mid_accept + ", fin_mem_num=" + fin_mem_num + ", fin_accept=" + fin_accept
				+ ", send_dept_name=" + send_dept_name + ", attechFile=" + attechFile + ", draftDate=" + draftDate
				+ ", approvalDate=" + approvalDate + "]";
	}
	public String getDraftDate() {
		return draftDate;
	}
	public void setDraftDate(String draftDate) {
		this.draftDate = draftDate;
	}
	public String getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}
	public int getEDI_num() {
		return EDI_num;
	}
	public void setEDI_num(int eDI_num) {
		EDI_num = eDI_num;
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
	public int getMid_accept() {
		return mid_accept;
	}
	public void setMid_accept(int mid_accept) {
		this.mid_accept = mid_accept;
	}
	public int getFin_mem_num() {
		return fin_mem_num;
	}
	public void setFin_mem_num(int fin_mem_num) {
		this.fin_mem_num = fin_mem_num;
	}
	public int getFin_accept() {
		return fin_accept;
	}
	public void setFin_accept(int fin_accept) {
		this.fin_accept = fin_accept;
	}
	public String getSend_dept_name() {
		return send_dept_name;
	}
	public void setSend_dept_name(String send_dept_name) {
		this.send_dept_name = send_dept_name;
	}
	public String getAttechFile() {
		return attechFile;
	}
	public void setAttechFile(String attechFile) {
		this.attechFile = attechFile;
	}
	
}
