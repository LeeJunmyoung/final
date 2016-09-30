package promgr.db;

public class MemberListDataBean {

	private int mem_num; // 회원 번호
	private String name; // 회원 이름
	private String email; // 회원 이메일
	private String com_pos_num; // 회원 부서

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCom_pos_num() {
		return com_pos_num;
	}

	public void setCom_pos_num(String com_pos_num) {
		this.com_pos_num = com_pos_num;
	}

} // public class ProMgrDataBean end
