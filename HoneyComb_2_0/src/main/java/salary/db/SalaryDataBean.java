package salary.db;

public class SalaryDataBean {

	int salary_num;
	int mem_num;
	String name;
	int com_num;
	String com_name;
	int com_dept_num;
	String com_dept_name;
	int com_pos_num;
	String com_pos_name;
	int salary_year;
	int salary_month;
	int salary_add_time;
	int salary_add_holiday;
	int salary_bonus;
	int costs_food;
	int costs_transport;
	int costs_benefit;
	int costs_etc;
	int salary_sum;

	public int getSalary_num() {
		return salary_num;
	}

	public void setSalary_num(int salary_num) {
		this.salary_num = salary_num;
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

	public int getSalary_year() {
		return salary_year;
	}

	public void setSalary_year(int salary_year) {
		this.salary_year = salary_year;
		this.salary_month = salary_year / 12;
		setSalary_sum();
	}

	public int getSalary_month() {
		return salary_month;
	}

	public int getSalary_add_time() {
		return salary_add_time;
	}

	public void setSalary_add_time(int salary_add_time) {
		this.salary_add_time = salary_add_time;
		setSalary_sum();
	}

	public int getSalary_add_holiday() {
		return salary_add_holiday;
	}

	public void setSalary_add_holiday(int salary_add_holiday) {
		this.salary_add_holiday = salary_add_holiday;
		setSalary_sum();
	}

	public int getSalary_bonus() {
		return salary_bonus;
	}

	public void setSalary_bonus(int salary_bonus) {
		this.salary_bonus = salary_bonus;
		setSalary_sum();
	}

	public int getCosts_food() {
		return costs_food;
	}

	public void setCosts_food(int costs_food) {
		this.costs_food = costs_food;
		setSalary_sum();
	}

	public int getCosts_transport() {
		return costs_transport;
	}

	public void setCosts_transport(int costs_transport) {
		this.costs_transport = costs_transport;
		setSalary_sum();
	}

	public int getCosts_benefit() {
		return costs_benefit;
	}

	public void setCosts_benefit(int costs_benefit) {
		this.costs_benefit = costs_benefit;
		setSalary_sum();
	}

	public int getCosts_etc() {
		return costs_etc;
	}

	public void setCosts_etc(int costs_etc) {
		this.costs_etc = costs_etc;
		setSalary_sum();
	}

	public int getSalary_sum() {
		return salary_sum;
	}

	public void setSalary_sum() {
		this.salary_sum = salary_month + salary_add_time + salary_add_holiday + salary_bonus + costs_food
				+ costs_transport + costs_benefit + costs_etc;
	}

}
