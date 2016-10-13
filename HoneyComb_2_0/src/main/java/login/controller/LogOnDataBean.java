package login.controller;

import java.sql.Timestamp;

public class LogOnDataBean {
	public String getPnum1() {
		return pnum1;
	}
	public String getPnum2() {
		return pnum2;
	}
	public String getPnum3() {
		return pnum3;
	}
	@Override
	public String toString() {
		return "LogOnDataBean [mem_num=" + mem_num + ", name=" + name + ", email=" + email + ", passwd=" + passwd
				+ ", phone_num=" + phone_num + ", com_num=" + com_num + ", com_dept_num=" + com_dept_num
				+ ", com_pos_num=" + com_pos_num + ", com_name=" + com_name + ", com_dept_name=" + com_dept_name
				+ ", com_pos_name=" + com_pos_name + ", profile_img=" + profile_img + ", birth_date=" + birth_date
				+ ", gender=" + gender + ", pnum1=" + pnum1 + ", pnum2=" + pnum2 + ", pnum3=" + pnum3 + "]";
	}
	private int mem_num;
	private String name;
	private String email;
	private String passwd;
	private String phone_num;
	private int com_num;
	private int com_dept_num;
	private int com_pos_num;
	private String com_name;
	private String com_dept_name;
	private String com_pos_name;
	private String profile_img;
	private String birth_date;
	private String gender;
	
	private String pnum1;
	private String pnum2;
	private String pnum3;
	
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public int getCom_dept_num() {
		return com_dept_num;
	}
	public void setCom_dept_num(int com_dept_num) {
		this.com_dept_num = com_dept_num;
	}
	public int getCom_pos_num() {
		return com_pos_num;
	}
	public void setCom_pos_num(int com_pos_num) {
		this.com_pos_num = com_pos_num;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public String getCom_dept_name() {
		return com_dept_name;
	}
	public void setCom_dept_name(String com_dept_name) {
		this.com_dept_name = com_dept_name;
	}
	public String getCom_pos_name() {
		return com_pos_name;
	}
	public void setCom_pos_name(String com_pos_name) {
		this.com_pos_name = com_pos_name;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public void setPnum1(String pnum1) {
		this.pnum1 = pnum1;
	}
	public void setPnum2(String pnum2) {
		this.pnum2 = pnum2;
	}
	public void setPnum3(String pnum3) {
		this.pnum3 = pnum3;
	}


	

	
	
	
}
