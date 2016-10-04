package promgr.db;

import java.util.List;

public class ChkListViewDataBean {

	private String chklist_title_num; // 진행 상황 체트 제목 번호
	private String chklist_title_name; // 진행 상황 체크 제목 이름
	private int chklist_title_ing; // 진행 상황 진행률
	private List<ChkItemDataBean> item_bean; // 진행 상황 체크 항목 list

	public String getChklist_title_num() {
		return chklist_title_num;
	}

	public void setChklist_title_num(String chklist_title_num) {
		this.chklist_title_num = chklist_title_num;
	}

	public String getChklist_title_name() {
		return chklist_title_name;
	}

	public void setChklist_title_name(String chklist_title_name) {
		this.chklist_title_name = chklist_title_name;
	}

	public int getChklist_title_ing() {
		return chklist_title_ing;
	}

	public void setChklist_title_ing(int chklist_title_ing) {
		this.chklist_title_ing = chklist_title_ing;
	}

	public List<ChkItemDataBean> getItem_bean() {
		return item_bean;
	}

	public void setItem_bean(List<ChkItemDataBean> item_bean) {
		this.item_bean = item_bean;
	}

} // public class ChkListViewDataBean end
