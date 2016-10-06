package dept_chart.db;

public class Dept_Person_InfoDataBean {
	private String com_pos_name;
	private String name;
	private int mem_num;
	private String phone_num;
	private String email;

	@Override
	public String toString() {
		return "Dept_Person_Info [com_pos_name=" + com_pos_name + ", name=" + name + ", phone_num=" + phone_num
				+ ", email=" + email + "]";
	}

	public String getCom_pos_name() {
		return com_pos_name;
	}

	public void setCom_pos_name(String com_pos_name) {
		this.com_pos_name = com_pos_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
