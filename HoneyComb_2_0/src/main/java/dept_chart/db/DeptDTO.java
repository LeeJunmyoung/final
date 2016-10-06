package dept_chart.db;

public class DeptDTO {

	private int com_dept_num;
	private String com_dept_name;

	public DeptDTO(int com_dept_num, String com_dept_name) {
		super();
		this.com_dept_num = com_dept_num;
		this.com_dept_name = com_dept_name;
	}

	public DeptDTO() {
		super();
	}

	@Override
	public String toString() {
		return "DeptDTO [com_dept_num=" + com_dept_num + ", com_dept_name=" + com_dept_name + "]";
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

}
