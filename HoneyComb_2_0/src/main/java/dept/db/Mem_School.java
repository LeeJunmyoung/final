package dept.db;

public class Mem_School {

	private int mem_num;
	private int school_num;
	private String school_name;
	private String school_date;
	private String school_major;

	public Mem_School() {
		super();
	}

	public Mem_School(int mem_num, int school_num, String school_name, String school_date, String school_major) {
		super();
		this.mem_num = mem_num;
		this.school_num = school_num;
		this.school_name = school_name;
		this.school_date = school_date;
		this.school_major = school_major;
	}

	@Override
	public String toString() {
		return "Mem_School [mem_num=" + mem_num + ", school_num=" + school_num + ", school_name=" + school_name
				+ ", school_date=" + school_date + ", school_major=" + school_major + "]";
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public int getSchool_num() {
		return school_num;
	}

	public void setSchool_num(int school_num) {
		this.school_num = school_num;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public String getSchool_date() {
		return school_date;
	}

	public void setSchool_date(String school_date) {
		this.school_date = school_date;
	}

	public String getSchool_major() {
		return school_major;
	}

	public void setSchool_major(String school_major) {
		this.school_major = school_major;
	}

}
