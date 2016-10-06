package company.db;

public class MembersDTO {

	private int mem_num;
	private String name;
	private String email;
	private String passwd;
	private String phone_num;
	private int com_num;
	private String com_name;
	private int com_dept_num;
	private String com_dept_name;
	private int com_pos_num;
	private String com_pos_name;
	private String birth_date;
	private String mem_address;
	private String gender;

	public MembersDTO() {
		super();
	}

	public MembersDTO(int mem_num, String name, String email, String passwd, String phone_num, int com_num,
			String com_name, int com_dept_num, String com_dept_name, int com_pos_num, String com_pos_name,
			String birth_date, String mem_address, String gender) {
		super();
		this.mem_num = mem_num;
		this.name = name;
		this.email = email;
		this.passwd = passwd;
		this.phone_num = phone_num;
		this.com_num = com_num;
		this.com_name = com_name;
		this.com_dept_num = com_dept_num;
		this.com_dept_name = com_dept_name;
		this.com_pos_num = com_pos_num;
		this.com_pos_name = com_pos_name;
		this.birth_date = birth_date;
		this.mem_address = mem_address;
		this.gender = gender;
	}

	public MembersDTO(int mem_num, String name, String email, String passwd, String phone_num, int com_num,
			String com_name, int com_dept_num, String com_dept_name, int com_pos_num, String com_pos_name) {
		super();
		this.mem_num = mem_num;
		this.name = name;
		this.email = email;
		this.passwd = passwd;
		this.phone_num = phone_num;
		this.com_num = com_num;
		this.com_name = com_name;
		this.com_dept_num = com_dept_num;
		this.com_dept_name = com_dept_name;
		this.com_pos_num = com_pos_num;
		this.com_pos_name = com_pos_name;
	}

	public MembersDTO(int com_num, String com_name, int com_dept_num, String com_dept_name, int com_pos_num,
			String com_pos_name) {
		super();
		this.com_num = com_num;
		this.com_name = com_name;
		this.com_dept_num = com_dept_num;
		this.com_dept_name = com_dept_name;
		this.com_pos_num = com_pos_num;
		this.com_pos_name = com_pos_name;
	}

	@Override
	public String toString() {
		return "MembersDTO [mem_num=" + mem_num + ", name=" + name + ", email=" + email + ", passwd=" + passwd
				+ ", phone_num=" + phone_num + ", com_num=" + com_num + ", com_name=" + com_name + ", com_dept_num="
				+ com_dept_num + ", com_dept_name=" + com_dept_name + ", com_pos_num=" + com_pos_num + ", com_pos_name="
				+ com_pos_name + ", birth_date=" + birth_date + ", mem_address=" + mem_address + ", gender=" + gender
				+ "]";
	}

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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public int getCom_num() {
		return com_num;
	}

	public void setCom_num(int com_num) {
		this.com_num = com_num;
	}

	public String getCom_name() {
		return com_name;
	}

	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}

	public int getCom_dept_num() {
		return com_dept_num;
	}

	public void setCom_dept_num(int com_dept_num) {
		this.com_dept_num = com_dept_num;
	}

	public String getCom_dept_name() {
		return com_dept_name;
	}

	public void setCom_dept_name(String com_dept_name) {
		this.com_dept_name = com_dept_name;
	}

	public int getCom_pos_num() {
		return com_pos_num;
	}

	public void setCom_pos_num(int com_pos_num) {
		this.com_pos_num = com_pos_num;
	}

	public String getCom_pos_name() {
		return com_pos_name;
	}

	public void setCom_pos_name(String com_pos_name) {
		this.com_pos_name = com_pos_name;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getMem_address() {
		return mem_address;
	}

	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
