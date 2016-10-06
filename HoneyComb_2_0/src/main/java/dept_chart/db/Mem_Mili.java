package dept_chart.db;

public class Mem_Mili {

	private int mem_num;
	private String mili_check;
	private String mili_ex;
	private String mili_place;
	private String mili_date;

	public Mem_Mili() {
		super();
	}

	public Mem_Mili(int mem_num, String mili_check, String mili_ex, String mili_place, String mili_date) {
		super();
		this.mem_num = mem_num;
		this.mili_check = mili_check;
		this.mili_ex = mili_ex;
		this.mili_place = mili_place;
		this.mili_date = mili_date;
	}

	@Override
	public String toString() {
		return "Mem_Mili [mem_num=" + mem_num + ", mili_check=" + mili_check + ", mili_ex=" + mili_ex + ", mili_place="
				+ mili_place + ", mili_date=" + mili_date + "]";
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public String getMili_check() {
		return mili_check;
	}

	public void setMili_check(String mili_check) {
		this.mili_check = mili_check;
	}

	public String getMili_ex() {
		return mili_ex;
	}

	public void setMili_ex(String mili_ex) {
		this.mili_ex = mili_ex;
	}

	public String getMili_place() {
		return mili_place;
	}

	public void setMili_place(String mili_place) {
		this.mili_place = mili_place;
	}

	public String getMili_date() {
		return mili_date;
	}

	public void setMili_date(String mili_date) {
		this.mili_date = mili_date;
	}

}
