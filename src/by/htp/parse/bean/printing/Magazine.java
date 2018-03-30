package by.htp.parse.bean.printing;

import java.util.ArrayList;
import java.util.List;
import by.htp.parse.bean.person.Editor;

public class Magazine {

	private int id;
	private String title;
	private int year;
	private int count;
	private int countDays;

	public int getCountDays() {
		return countDays;
	}

	public void setCountDays(int countDays) {
		this.countDays = countDays;
	}

	private List<Editor> listEditors = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Editor> getListEditors() {
		return listEditors;
	}

	public void setListEditors(List<Editor> listEditors) {
		this.listEditors = listEditors;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
