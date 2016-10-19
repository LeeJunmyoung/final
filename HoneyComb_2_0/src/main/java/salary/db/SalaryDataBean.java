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
	int tax_np; // 국민연금
	int tax_ui; // 고용보험
	int tax_hi; // 건강보험
	int tax_lci; // 장기요양보험
	int tax_ei; // 근로소득세
	int tax_li; // 주민세
	int tax_sum;

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
		setTax();
		setTax_sum();
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
		setTax();
		setTax_sum();
	}

	public int getSalary_add_holiday() {
		return salary_add_holiday;
	}

	public void setSalary_add_holiday(int salary_add_holiday) {
		this.salary_add_holiday = salary_add_holiday;
		setSalary_sum();
		setTax();
		setTax_sum();
	}

	public int getSalary_bonus() {
		return salary_bonus;
	}

	public void setSalary_bonus(int salary_bonus) {
		this.salary_bonus = salary_bonus;
		setSalary_sum();
		setTax();
		setTax_sum();
	}

	public int getCosts_food() {
		return costs_food;
	}

	public void setCosts_food(int costs_food) {
		this.costs_food = costs_food;
		setSalary_sum();
		setTax();
		setTax_sum();
	}

	public int getCosts_transport() {
		return costs_transport;
	}

	public void setCosts_transport(int costs_transport) {
		this.costs_transport = costs_transport;
		setSalary_sum();
		setTax();
		setTax_sum();
	}

	public int getCosts_benefit() {
		return costs_benefit;
	}

	public void setCosts_benefit(int costs_benefit) {
		this.costs_benefit = costs_benefit;
		setSalary_sum();
		setTax();
		setTax_sum();
	}

	public int getCosts_etc() {
		return costs_etc;
	}

	public void setCosts_etc(int costs_etc) {
		this.costs_etc = costs_etc;
		setSalary_sum();
		setTax();
		setTax_sum();
	}

	public int getSalary_sum() {
		return salary_sum;
	}

	private void setSalary_sum() {
		this.salary_sum = salary_month + salary_add_time + salary_add_holiday + salary_bonus + costs_food
				+ costs_transport + costs_benefit + costs_etc;
	}

	private void setTax() {

		// int tax_li; // 주민세

		this.tax_np = (int) (salary_sum * 0.045); // 국민연금
		this.tax_ui = (int) (salary_sum * 0.0065); // 고용보험
		this.tax_hi = (int) (salary_sum * 0.0306); // 건강보험
		this.tax_lci = (int) (tax_hi * 0.03275); // 장기요양보험
		setTax_ei(salary_year); // 근로소득세
		this.tax_li = (int) (tax_ei * 0.1); // 주민세
	}

	public int getTax_np() {
		return tax_np;
	}

	public int getTax_ui() {
		return tax_ui;
	}

	public int getTax_hi() {
		return tax_hi;
	}

	public int getTax_lci() {
		return tax_lci;
	}

	public int getTax_ei() {
		return tax_ei;
	}

	private void setTax_ei(int salary_year) {

		int deduct = 0; // 소득공제
		int cta = 0; // 산출세액
		int credit = 0;// 세액공제

		// 인적 소득공제 setting
		if (salary_year <= 5000000) {
			deduct = (int) (salary_year * 0.7);
			deduct += 1500000;
		} else if (salary_year <= 15000000) {
			deduct = (int) (3500000 + (salary_year - 50000000) * 0.4);
			deduct += 1500000;
		} else if (salary_year <= 45000000) {
			deduct = (int) (7500000 + (salary_year - 150000000) * 0.15);
			deduct += 1500000;
		} else if (salary_year <= 100000000) {
			deduct = (int) (12000000 + (salary_year - 450000000) * 0.05);
			deduct += 1500000;
		} else if (salary_year > 100000000) {
			deduct = (int) (14750000 + (salary_year - 100000000) * 0.02);
			deduct += 1500000;
		}

		// 특별 소득공제 setting
		if (salary_year <= 30000000) {
			deduct += (3100000 + salary_year * 0.04);
		} else if (salary_year <= 45000000) {
			deduct += (3100000 + salary_year * 0.015 + (salary_year - 30000000) * 0.05);
		} else if (salary_year <= 70000000) {
			deduct += (3100000 + salary_year * 0.015);
		} else if (salary_year <= 120000000) {
			deduct += (3100000 + salary_year * 0.005);
		}

		// 과세표준 setting
		int as = salary_year - deduct - tax_np * 12;

		// 산출세액 setting
		if (salary_year <= 12000000) {
			cta = (int) (as * 0.06);
		} else if (salary_year <= 46000000) {
			cta = (int) (12000000 * 0.06 + (as - 12000000) * 0.15 - 1080000);
		} else if (salary_year <= 88000000) {
			cta = (int) (46000000 * 0.15 + (as - 46000000) * 0.24 - 5220000);
		} else if (salary_year <= 150000000) {
			cta = (int) (88000000 * 0.24 + (as - 88000000) * 0.35 - 14900000);
		} else if (salary_year > 150000000) {
			cta = (int) (150000000 * 0.35 + (as - 150000000) * 0.38 - 19400000);
		}

		// 세액공제 setting
		if (cta <= 500000) {
			credit = (int) (cta * 0.55);
		} else if (cta > 500000) {
			credit = (int) (275000 + (cta - 500000) * 0.3);
		}

		// 소득세 setting
		int income = cta - credit;

		this.tax_ei = (int) (income / 12); // 근로소득세

	}

	public int getTax_li() {
		return tax_li;
	}

	public int getTax_sum() {
		return tax_sum;
	}

	private void setTax_sum() {
		this.tax_sum = tax_np + tax_ui + tax_hi + tax_lci + tax_ei + tax_li;
	}

}
