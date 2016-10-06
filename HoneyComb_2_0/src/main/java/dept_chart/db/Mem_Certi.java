package dept_chart.db;

public class Mem_Certi {

	private int mem_num;
	private String certi_name;
	private String certi_insti;
	private String certi_date;

	public Mem_Certi() {
		super();
	}

	public Mem_Certi(int mem_num, String certi_name, String certi_insti, String certi_date) {
		super();
		this.mem_num = mem_num;
		this.certi_name = certi_name;
		this.certi_insti = certi_insti;
		this.certi_date = certi_date;
	}

	@Override
	public String toString() {
		return "Mem_Certi [mem_num=" + mem_num + ", certi_name=" + certi_name + ", certi_insti=" + certi_insti
				+ ", certi_date=" + certi_date + "]";
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public String getCerti_name() {
		return certi_name;
	}

	public void setCerti_name(String certi_name) {
		this.certi_name = certi_name;
	}

	public String getCerti_insti() {
		return certi_insti;
	}

	public void setCerti_insti(String certi_insti) {
		this.certi_insti = certi_insti;
	}

	public String getCerti_date() {
		return certi_date;
	}

	public void setCerti_date(String certi_date) {
		this.certi_date = certi_date;
	}

}
