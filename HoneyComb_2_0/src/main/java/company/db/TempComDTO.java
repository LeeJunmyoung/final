package company.db;

public class TempComDTO {

	private int com_num;
	private String com_name;
	private String com_add;
	private String com_aff;
	private String com_phone1;
	private String com_phone2;
	private String com_phone3;
	private String com_phone;

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

	public String getCom_add() {
		return com_add;
	}

	public void setCom_add(String com_add) {
		this.com_add = com_add;
	}

	public String getCom_aff() {
		return com_aff;
	}

	public void setCom_aff(String com_aff) {
		this.com_aff = com_aff;
	}

	public String getCom_phone1() {
		return com_phone1;
	}

	public void setCom_phone1(String com_phone1) {
		this.com_phone1 = com_phone1;
	}

	public String getCom_phone2() {
		return com_phone2;
	}

	public void setCom_phone2(String com_phone2) {
		this.com_phone2 = com_phone2;
	}

	public String getCom_phone3() {
		return com_phone3;
	}

	public void setCom_phone3(String com_phone3) {
		this.com_phone3 = com_phone3;
	}

	public String getCom_phone() {
		return com_phone;
	}

	public void setCom_phone(String com_phone) {
		this.com_phone = com_phone;
	}

	@Override
	public String toString() {
		return "TempComDTO [com_num=" + com_num + ", com_name=" + com_name + ", com_add=" + com_add + ", com_aff="
				+ com_aff + ", com_phone1=" + com_phone1 + ", com_phone2=" + com_phone2 + ", com_phone3=" + com_phone3
				+ "]";
	}

}
